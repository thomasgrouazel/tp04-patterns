package tp04.exo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

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
    


}
