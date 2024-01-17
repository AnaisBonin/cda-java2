import java.util.Arrays;

public class TicTacToe {
    final int size = 3;
    Player player = new Player();
    Cell[][] board = new Cell[size][size];

    private Cell[] buildOneRow() {
        Cell[] row = new Cell[size];

        for (int i = 0; i < size; i++) {
            row[i] = new Cell();
        }
        return row;
    }

    private void getBoard() {
        for (int i = 0; i < size; i++) {
            board[i] = buildOneRow();
        }
    }

    public TicTacToe() {
        getBoard();
    }

    public void display() {
        String endRow = "|";
        StringBuilder horizontalBorder = new StringBuilder();
        horizontalBorder.append(" ----".repeat(size));

        System.out.println(horizontalBorder);

        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.printf(cell.getRepresentation());
            }
            System.out.printf(endRow);
            System.out.println();
            System.out.println(horizontalBorder);
        }
    }

    private boolean isMoveValid (int[] move) {
        boolean isLengthValid = move.length == 2;
        boolean isDataValid = (move[0] <= size && move[0] > 0) && (move[1] <= size && move[1] > 0);

        return isLengthValid && isDataValid;
    }
    public int[] getMoveFromPlayer() {
        int[] move = new int[2];

        boolean canProceed = isMoveValid(move);

        if (canProceed) {
            System.out.println(Arrays.toString(move));
        } else {
            System.out.println("Your input is invalid, please try again");
//            getMoveFromPlayer();
        }
        return move;
    }
}
