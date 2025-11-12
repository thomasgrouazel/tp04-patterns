package tp04.exo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ArraySequenceTest {
    
    @Test
    public void testSequenceVide() {
        String [] t = {};
        Sequence seq = new ArraySequence(t);
        assertSame(null, seq.ligneSuivante());
    }

    /*
     * Vérifie qu'il n'y a pas de plantage si on 
     * appelle plusieurs fois ligneSuivante après la
     * fin de la séquence.
     */
    @Test
    public void testSequenceVideBis() {
        String [] t = {};
        Sequence seq = new ArraySequence(t);
        assertSame(null, seq.ligneSuivante());
        assertSame(null, seq.ligneSuivante());
    }

    @Test
    public void testSimple() {
        String [] t= {"un", "deux", "trois"};
        Sequence seq = new ArraySequence(t);
        assertEquals("un", seq.ligneSuivante());
        assertEquals("deux", seq.ligneSuivante());
        assertEquals("trois", seq.ligneSuivante());
        assertSame(null,seq.ligneSuivante());
    }
    
        /*
     * Vérifie le comportement avec un tableau contenant un seul élément.
     */
    @Test
    public void testSequenceUnElement() {
        String[] t = {"unique"};
        Sequence seq = new ArraySequence(t);
        assertEquals("unique", seq.ligneSuivante());
        assertSame(null, seq.ligneSuivante());
    }

    /*
     * Vérifie le comportement avec un tableau contenant des éléments null.
     */
    @Test
    public void testSequenceAvecNull() {
        String[] t = {"un", null, "trois"};
        Sequence seq = new ArraySequence(t);
        assertEquals("un", seq.ligneSuivante());
        assertSame(null, seq.ligneSuivante());
        assertEquals("trois", seq.ligneSuivante());
        assertSame(null, seq.ligneSuivante());
    }

    /*
     * Vérifie le comportement avec un tableau très grand.
     */
    @Test
    public void testSequenceGrande() {
        int taille = 1000;
        String[] t = new String[taille];
        for (int i = 0; i < taille; i++) {
            t[i] = "ligne" + i;
        }
        Sequence seq = new ArraySequence(t);
        for (int i = 0; i < taille; i++) {
            assertEquals("ligne" + i, seq.ligneSuivante());
        }
        assertSame(null, seq.ligneSuivante());
    }

    /*
     * Vérifie que hasNext() retourne false pour une séquence vide.
     */
    @Test
    public void testHasNextAvecSequenceVide() {
        String[] t = {};
        Sequence seq = new ArraySequence(t);
        assertFalse(seq.hasNext());
    }

    /*
     * Vérifie que hasNext() retourne true tant qu'il reste des éléments.
     */
    @Test
    public void testHasNextAvecElements() {
        String[] t = {"un", "deux"};
        Sequence seq = new ArraySequence(t);
        assertTrue(seq.hasNext());
        seq.ligneSuivante();
        assertTrue(seq.hasNext());
        seq.ligneSuivante();
        assertFalse(seq.hasNext());
    }
}


