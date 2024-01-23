import java.util.Arrays;

public class Victory {

    // **
    // ******
    // ***********
    // ****************  ATTRIBUTES
    // ***********
    // ******
    // **

    private boolean status;

    // **
    // ***** Attributes methods
    // **

    private boolean areValuesIdentical(Cell[] cells) {
        Representation[] repValues = new Representation[3];

        for (int i = 0; i < cells.length; i++) {
            repValues[i] = cells[i].getRepresentation();
        }
        return Arrays.stream(repValues).distinct().count() == 1;
    }

    private boolean isIdenticalRow(Cell[] row) {
        return areValuesIdentical(row);
    }

    private boolean isIdenticalColumn(Cell[][] board, int columnNumber, int size) {
        Cell[] columnArray = new Cell[size];

        for (int i = 0; i < size; i++) {
            columnArray[i] = board[i][columnNumber];
        }
        return areValuesIdentical(columnArray);
    }

    private boolean isDiagonal1Identical(Cell[][] board, int size) {
        Cell[] diagonal1 = new Cell[size];

        for (int i = 0; i < size; i++) {
            Cell currentCell = board[i][size - 1 - i];

            if (currentCell.getRepresentation() == Representation.EMPTY) {
                return false;
            }
            diagonal1[i] = currentCell;
        }

        return areValuesIdentical(diagonal1);
    }

    private boolean isDiagonal2Identical(Cell[][] board, int size) {
        Cell[] diagonal2 = new Cell[size];

        for (int i = 0; i < size; i++) {
            Cell currentCell = board[i][i];

            if (currentCell.getRepresentation() == Representation.EMPTY) {
                return false;
            }
            diagonal2[i] = currentCell;
        }

        return areValuesIdentical(diagonal2);
    }

    public boolean foundWinningLine(int[] move, Cell[][] board, int size) {
        return isIdenticalColumn(board, move[0] - 1, size) |
                isIdenticalRow(board[move[1] - 1]) |
                isDiagonal1Identical(board, size) |
                isDiagonal2Identical(board, size);
    }

    // **
    // ******
    // ***********
    // ****************  CONSTRUCTOR
    // ***********
    // ******
    // **


    public Victory() {
        this.status = false;
    }

    // **
    // ******
    // ***********
    // ****************  METHODS
    // ***********
    // ******
    // **

    public void setVictory(boolean status) {
        this.status = status;
    }

    public boolean getVictory() {
        return this.status;
    }
}
