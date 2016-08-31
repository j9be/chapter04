package packt.java9.by.example.mastermind;

/**
 * A Game maintains a secret and a table and when there is a new guess it stores it setting the
 * position and colors matched.
 */
public class Game {

    final Table table;
    final private Row secretRow;
    boolean finished = false;

    public Game(Table table, Color[] secret ) {
        this.table = table;
        this.secretRow = new Row(secret);
    }

    public void newGuess(Row row) {
        if( isFinished()){
            throw new IllegalArgumentException("You can not guess on a finished game.");
        }
        final int positionMatch = secretRow.nrMatchingPositions(row.positions);
        final int colorMatch = secretRow.nrMatchingColors(row.positions);
        row.setMatch(positionMatch, colorMatch);
        table.addRow(row);
        if( positionMatch == row.positions.length ){
            finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }
}
