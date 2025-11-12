package tp04.exo2;

import java.util.Collections;
import java.util.List;

/**
 * Classe parente pour toutes les parties d'un document XML
 */
public abstract class Node {
    
    /**
     * Retourne tous les enfants de ce nœud.
     * @return une liste de nœuds.
     */
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    /**
     * Retourne la concaténation de tout le texte contenu dans un Nœud (y compris dans ses enfants).
     * @return
     */
    public abstract String textContent();

    /**
     * Retourne le code XML du Nœud.
     * @return
     */
    public abstract String toXML();
}
