package tp04.exo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GrepSequenceTest {

    @Test
    public void testLignesCorrespondantes() {
        String[] data = {"chemin1", "autre ligne", "chemin2", "encore une ligne"};
        Sequence original = new ArraySequence(data);
        Sequence grep = new GrepSequence(original, "chemin");

        assertTrue(grep.hasNext());
        assertEquals("chemin1", grep.ligneSuivante());
        assertEquals("chemin2", grep.ligneSuivante());
        assertFalse(grep.hasNext());
        assertNull(grep.ligneSuivante());
    }

    @Test
    public void testAucuneCorrespondance() {
        String[] data = {"ligne1", "ligne2", "ligne3"};
        Sequence original = new ArraySequence(data);
        Sequence grep = new GrepSequence(original, "inexistant");

        assertFalse(grep.hasNext());
        assertNull(grep.ligneSuivante());
    }

    @Test
    public void testSequenceVide() {
        String[] data = {};
        Sequence original = new ArraySequence(data);
        Sequence grep = new GrepSequence(original, "chemin");

        assertFalse(grep.hasNext());
        assertNull(grep.ligneSuivante());
    }

    @Test
    public void testCorrespondancePartielle() {
        String[] data = {"ligne1", "chemin", "ligne3"};
        Sequence original = new ArraySequence(data);
        Sequence grep = new GrepSequence(original, "chemin");

        assertTrue(grep.hasNext());
        assertEquals("chemin", grep.ligneSuivante());
        assertFalse(grep.hasNext());
        assertNull(grep.ligneSuivante());
    }
}