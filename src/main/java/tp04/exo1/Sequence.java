package tp04.exo1;
/**
 * Une séquence de String, éventuellement infinie
 */
public interface Sequence {
    /**
     * Retourne la ligne suivante de la séquence, ou null 
     * si elle est terminée.
     * @return une string, éventuellement nulle.
     */
    String ligneSuivante();
}
