package tp04.exo1;

public class SliceSequence implements Sequence {
    private final LineNumberSequence lineNumberSequence;
    private final int startIndex;
    private final int endIndex;

    public SliceSequence(Sequence originalSequence, int startIndex, int endIndex) {
        if (startIndex < 0) {
            throw new IllegalArgumentException("startIndex must be >= 0");
        }
        if (endIndex <= startIndex) {
            throw new IllegalArgumentException("endIndex must be > startIndex");
        }
        this.lineNumberSequence = new LineNumberSequence(originalSequence);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public String ligneSuivante() {
        String line;
        while ((line = lineNumberSequence.ligneSuivante()) != null) {
            int currentLineNumber = lineNumberSequence.getLineNumber() - 1; // Adjust for 0-based indexing
            if (currentLineNumber >= startIndex && currentLineNumber < endIndex) {
                return line;
            } else if (currentLineNumber >= endIndex) {
                return null; // Stop reading once we reach the endIndex
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        int currentLineNumber = lineNumberSequence.getLineNumber() - 1; // Adjust for 0-based indexing
        return lineNumberSequence.hasNext() && currentLineNumber < endIndex - 1;
    }
}