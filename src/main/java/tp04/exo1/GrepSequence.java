package tp04.exo1;

public class GrepSequence implements Sequence {
    private final Sequence originalSequence;
    private final String searchText;
    private String nextMatchingLine;

    public GrepSequence(Sequence originalSequence, String searchText) {
        this.originalSequence = originalSequence;
        this.searchText = searchText;
        this.nextMatchingLine = null;
    }

    @Override
    public boolean hasNext() {
        if (nextMatchingLine != null) {
            return true;
        }
        while (originalSequence.hasNext()) {
            String line = originalSequence.ligneSuivante();
            if (line != null && line.contains(searchText)) {
                nextMatchingLine = line;
                return true;
            }
        }
        return false;
    }

    @Override
    public String ligneSuivante() {
        if (hasNext()) {
            String result = nextMatchingLine;
            nextMatchingLine = null;
            return result;
        }
        return null;
    }
}