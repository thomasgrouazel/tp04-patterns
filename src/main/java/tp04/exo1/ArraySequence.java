package tp04.exo1;

/**
 * Une séquence implémentée par un tableau de String.
 */
public class ArraySequence implements Sequence {
    private String[] representation;
    private int position;

    public ArraySequence(String[] representation) {
        this.representation = representation.clone();
    }

    @Override
    public String ligneSuivante() {
        if (position >= representation.length) {
            return null;
        } else {
            // On peut le faire en une ligne, mais
            // soyons lisibles.
            String resultat = representation[position];
            position++;
            return resultat;
        }
    }
    
}
