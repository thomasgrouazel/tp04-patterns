package tp04.exo1;

public class LineNumberSequence implements Sequence {
    private final Sequence originalSequence;
    private int lineNumber;

    public LineNumberSequence(Sequence originalSequence) {
        this.originalSequence = originalSequence;
        this.lineNumber = 0; 
    }

    @Override
    public String ligneSuivante() {
        String line = originalSequence.ligneSuivante();
        if (line != null) {
            lineNumber++; 
        }
        return line;
    }

    public int getLineNumber() {
        return lineNumber; 
    }

    @Override
    public boolean hasNext() {
        return originalSequence.hasNext();
    }
}