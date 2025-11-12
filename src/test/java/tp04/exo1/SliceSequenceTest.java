package tp04.exo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

public class SliceSequenceTest {

    @Test
    public void testSliceWithinBounds() {
        String[] data = {
            "ligne0", "ligne1", "ligne2", "ligne3", "ligne4",
            "ligne5", "ligne6", "ligne7", "ligne8", "ligne9",
            "ligne10", "ligne11", "ligne12", "ligne13", "ligne14",
            "ligne15", "ligne16", "ligne17", "ligne18", "ligne19"
        };

        Sequence original = new ArraySequence(data);
        SliceSequence sliceSequence = new SliceSequence(original, 10, 15);

        assertEquals("ligne10", sliceSequence.ligneSuivante());
        assertEquals("ligne11", sliceSequence.ligneSuivante());
        assertEquals("ligne12", sliceSequence.ligneSuivante());
        assertEquals("ligne13", sliceSequence.ligneSuivante());
        assertEquals("ligne14", sliceSequence.ligneSuivante());
        assertNull(sliceSequence.ligneSuivante());
    }

    @Test
    public void testSliceOutOfBounds() {
        String[] data = {"ligne0", "ligne1", "ligne2"};
        Sequence original = new ArraySequence(data);
        SliceSequence sliceSequence = new SliceSequence(original, 10, 15);

        assertNull(sliceSequence.ligneSuivante());
    }

    @Test
    public void testSliceEmptySequence() {
        String[] data = {};
        Sequence original = new ArraySequence(data);
        SliceSequence sliceSequence = new SliceSequence(original, 0, 5);

        assertNull(sliceSequence.ligneSuivante());
    }

    @Test
    public void testSliceExactBounds() {
        String[] data = {"ligne0", "ligne1", "ligne2", "ligne3", "ligne4"};
        Sequence original = new ArraySequence(data);
        SliceSequence sliceSequence = new SliceSequence(original, 1, 4);

        assertEquals("ligne1", sliceSequence.ligneSuivante());
        assertEquals("ligne2", sliceSequence.ligneSuivante());
        assertEquals("ligne3", sliceSequence.ligneSuivante());
        assertNull(sliceSequence.ligneSuivante());
    }

    @Test
    public void testInvalidIndices() {
        String[] data = {"ligne0", "ligne1", "ligne2"};
        Sequence original = new ArraySequence(data);
        try {
            new SliceSequence(original, -1, 5);
            fail("Expected IllegalArgumentException for startIndex < 0");
        } catch (IllegalArgumentException e) {
            assertEquals("startIndex must be >= 0", e.getMessage());
        }
    }

    @Test
    public void testInvalidIndicesReversed() {
        String[] data = {"ligne0", "ligne1", "ligne2"};
        Sequence original = new ArraySequence(data);
        try {
            new SliceSequence(original, 5, 3);
            fail("Expected IllegalArgumentException for endIndex <= startIndex");
        } catch (IllegalArgumentException e) {
            assertEquals("endIndex must be > startIndex", e.getMessage());
        }
    }
}