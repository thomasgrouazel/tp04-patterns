package tp04.exo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Un élément au sens XML du terme.
 * Il représente un couple de balises ouvrantes et fermantes,
 * et tout ce qu'il y a dedans.
 * C'est un Composite au sens pattern.
 */
public class Element extends Node {
    private String tag;
    private TreeMap<String, String> attributes = new TreeMap<>();
    private List<Node> children = new ArrayList<>();

    /**
     * Déclare l'élément.
     * @param tag : Le nom de la balise.
     */
    public Element(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void addChild(Node newChild) {
        children.add(newChild);
    }

    public void removeChild(Node toRemove) {
        children.remove(toRemove);
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(children);
    }

    public void setAttributeValue(String attributeName, String value) {
        attributes.put(attributeName, value);
    }

    public String getAttributeValue(String attributeName) {
        return attributes.get(attributeName);
    }

    /**
     * Retourne l'ensemble des noms des attributs définis.
     * @return Un ensemble trié des noms des attributs.
     */
    public Set<String> getDefinedAttributes() {
        return new TreeSet<>(attributes.keySet());
    }

    @Override
    public String textContent() {
        StringBuilder builder = new StringBuilder();
        for (Node n : getChildren()) {
            builder.append(n.textContent());
        }
        return builder.toString();
    }

    @Override
    public String toXML() {
        // Génère les attributs triés par ordre alphabétique
        StringBuilder attributesBuilder = new StringBuilder();
        for (String attributeName : getDefinedAttributes()) {
            String value = XMLHelper.protectAttributeValue(attributes.get(attributeName));
            attributesBuilder.append(" ").append(attributeName).append("=\"").append(value).append("\"");
        }

        // Génère le contenu des enfants
        StringBuilder childrenBuilder = new StringBuilder();
        for (Node child : children) {
            childrenBuilder.append(child.toXML());
        }

        // Si l'élément n'a pas de contenu, utilise une balise fermante explicite
        if (children.isEmpty()) {
            return "<" + tag + attributesBuilder + "></" + tag + ">";
        }

        // Sinon, génère une balise ouvrante et fermante avec contenu
        return "<" + tag + attributesBuilder + ">" + childrenBuilder + "</" + tag + ">";
    }
}