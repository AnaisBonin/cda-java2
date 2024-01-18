import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    final int size = 3;
    Player player = new Player();

    //
    // SET GAME BOARD AND SET BOARD ACCORDING TO SIZE
    //
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


    //
    // TICTACTOE METHODS
    //

    //
    // Display visually game grid - size  * size
    //
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


    //
    // Check target chosen by Player: the target needs to be within the board size
    //

    private boolean isTargetValid(int target) {
        return (target <= size && target > 0);
    }

    Scanner scanner = new Scanner(System.in);

    private int getPlayerEntry(String target) {
        int result;

        try {
            System.out.println("which " + target + " do you want to target?");
            result = Integer.parseInt(scanner.nextLine());

            if (!isTargetValid(result)) {
                System.out.println("Invalid - you must choose a number between 1 and " + size);
                return getPlayerEntry(target);
            }
        } catch (NumberFormatException e) {
            System.out.println("Entry invalid, try again:");
            return getPlayerEntry(target);
        }
        return result;
    }

    //
    // Check if targeted cell is available
    //

    private boolean isCellAvailable(int[] move) {
        if (move[0] == 1) {
            System.out.println("this cell is not available, select another cell");
            return false;
        } else {
            System.out.println("cell valid");
            return true;
        }
    }

    // Finale public method return player move

    public int[] getMoveFromPlayer() {
        int[] move = new int[2];

        move[0] = getPlayerEntry("Column");
        move[1] = getPlayerEntry("Row");

        if (!isCellAvailable(move)) return getMoveFromPlayer();

        System.out.println("You picked: " + Arrays.toString(move));
        return move;
    }
}
