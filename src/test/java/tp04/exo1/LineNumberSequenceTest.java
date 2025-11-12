package tp04.exo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LineNumberSequenceTest {

    @Test
    public void testLineNumberIncrement() {
        String[] data = {"ligne1", "ligne2", "ligne3"};
        Sequence original = new ArraySequence(data);
        LineNumberSequence lineNumberSequence = new LineNumberSequence(original);

        assertEquals(0, lineNumberSequence.getLineNumber());
        assertEquals("ligne1", lineNumberSequence.ligneSuivante());
        assertEquals(1, lineNumberSequence.getLineNumber());
        assertEquals("ligne2", lineNumberSequence.ligneSuivante());
        assertEquals(2, lineNumberSequence.getLineNumber());
        assertEquals("ligne3", lineNumberSequence.ligneSuivante());
        assertEquals(3, lineNumberSequence.getLineNumber());
        assertNull(lineNumberSequence.ligneSuivante());
        assertEquals(3, lineNumberSequence.getLineNumber());
    }

    @Test
    public void testEmptySequence() {
        String[] data = {};
        Sequence original = new ArraySequence(data);
        LineNumberSequence lineNumberSequence = new LineNumberSequence(original);

        assertEquals(0, lineNumberSequence.getLineNumber());
        assertNull(lineNumberSequence.ligneSuivante());
        assertEquals(0, lineNumberSequence.getLineNumber());
    }

    @Test
    public void testHasNext() {
        String[] data = {"ligne1", "ligne2"};
        Sequence original = new ArraySequence(data);
        LineNumberSequence lineNumberSequence = new LineNumberSequence(original);

        assertTrue(lineNumberSequence.hasNext());
        lineNumberSequence.ligneSuivante();
        assertTrue(lineNumberSequence.hasNext());
        lineNumberSequence.ligneSuivante();
        assertFalse(lineNumberSequence.hasNext());
    }
}