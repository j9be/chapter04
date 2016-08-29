package packt.java9.by.example.mastermind;

import java.util.Arrays;

/**
 * One row on the table. It contains the guesses at position and also the
 * number of matching colors and position.
 */
public class Row {
    final Color[] positions;
    private int matchedPositions;
    private int matchedColors;
    public static final Row none = new Row(Guesser.none);

    public Row(Color[] positions) {
        this.positions = Arrays.copyOf(positions, positions.length);
    }

    public void setMatch(int matchedPositions, int matchedColors) {
        if (matchedColors + matchedPositions > positions.length) {
            throw new IllegalArgumentException(
                    "Number of matches can not be more that the position.");
        }
        if (matchedColors + matchedPositions == positions.length &&
                matchedColors == 1) {
            throw new IllegalArgumentException(
                    "If all but one matches the last position can not match.");
        }
        this.matchedColors = matchedColors;
        this.matchedPositions = matchedPositions;
    }

    public boolean guessMatches(Color[] guess) {
        return countMatchedColors(guess) == matchedColors &&
                countMatchedPositions(guess) == matchedPositions;
    }

    /**
     * Count the number of colors that are present on the guess but not on the position where they are in the secret.
     * If the same color is on multiple position it is counted for each position once. For example the secret is
     * <pre>
     *     RGRB
     * </pre>
     * and the guess is
     * <pre>
     *     YRPR
     * </pre>
     * then this method will return 2.
     *
     * @param guess is the actual guess that we evaluate
     * @return the number of good colors out of position
     */
    public int countMatchedColors(Color[] guess) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                if (i != j && guess[i] == positions[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Count the number of colors that are correct and are in position.
     *
     * @param guess is the actual guess that we evaluate
     * @return the number of colors that match in position
     */
    public int countMatchedPositions(Color[] guess) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == positions[i]) {
                count++;
            }
        }
        return count;
    }

    public int nrColumns() {
        return positions.length;
    }

    public Color position(int i) {
        return positions[i];
    }

    public int matchedPositions() {
        return matchedPositions;
    }

    public int matchedColors() {
        return matchedColors;
    }
}
