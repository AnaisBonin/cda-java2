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
        boolean victory = areValuesIdentical(row);
        return setVictory(victory);
    }

    private boolean isIdenticalColumn(Cell[][] board, int columnNumber, int size) {
        Cell[] columnArray = new Cell[size];

        for (int i = 0; i < size; i++) {
            columnArray[i] = board[i][columnNumber];
        }
        boolean victory = areValuesIdentical(columnArray);
        return setVictory(victory);
    }

    private boolean isIdenticalDiagonal(Cell[][] board, int size) {
        Cell[] diagonal1 = new Cell[size];
        Cell[] diagonal2 = new Cell[size];

        diagonal1[0] = board[0][2];
        diagonal1[1] = board[1][1];
        diagonal1[2] = board[2][0];

        for (int i = 0; i < size; i++) {
            diagonal2[i] = board[i][i];
        }

        boolean victory = areValuesIdentical(diagonal1) | areValuesIdentical(diagonal2);
        return setVictory(victory);
    }

    public boolean checkMoveForVictory(int[] move, Cell[][]board, int size){
        return isIdenticalColumn(board, move[0]-1, size) |
        isIdenticalRow(board[move[1]-1]) |
        isIdenticalDiagonal(board, size);
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

    public boolean setVictory(boolean status) {
        this.status = status;
        return status;
    }

    public boolean getVictory(){
        return this.status;
    }
}
