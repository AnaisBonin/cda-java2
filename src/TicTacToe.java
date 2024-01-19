import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private final int size = 3;
    private final Scanner scanner = new Scanner(System.in);

    //
    // SET GAME BOARD AND SET BOARD ACCORDING TO SIZE
    //
    private final Cell[][] board = new Cell[size][size];

    private Cell[] buildOneRow() {
        Cell[] row = new Cell[size];

        for (int i = 0; i < size; i++) {
            row[i] = new Cell(Representation.EMPTY);
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

    private boolean isTargetInvalid(int target) {
        return (target > size || target <= 0);
    }

    private int getPlayerEntry(String target) {
        int result= -1;

        System.out.println("which " + target + " do you want to target?");

        while (isTargetInvalid(result)) {
            try {
                result = Integer.parseInt(scanner.nextLine());

                if (isTargetInvalid(result)) {
                    System.out.println("Invalid - you must choose a number between 1 and " + size);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entry invalid, try again:");
            }
        }
        return result;
    }

    private int[] setPlayerEntry() {
        int col = getPlayerEntry("Column");
        int row = getPlayerEntry("Row");

        return new int[]{col, row};
    }

    //
    // Check if targeted cell is available
    //

    private boolean isCellAvailable(int[] move) {
        int col = move[0];
        int row = move[1];

        Cell cell = new Cell(Representation.EMPTY);
        String emptyCell = cell.getRepresentation();

        Cell targettedCell = board[row - 1][col - 1];
        String cellValue = targettedCell.getRepresentation();

        if (cellValue.equals(emptyCell)) {
            return true;
        } else {
            System.out.println("This cell is not available, select another cell");
            return false;
        }
    }

    //
    // Finale public method return player move
    //

    public int[] getMoveFromPlayer() {
        int[] move = setPlayerEntry();

        while (!isCellAvailable(move)) {
            move = setPlayerEntry();
        }

        System.out.println("You picked: " + Arrays.toString(move));
        return move;
    }

    private void setOwner(int[] move, Player player){
        int col = move[0];
        int row = move[1];
        Representation status = player.getRepresentation();

        this.board[row-1][col-1].setRepresentation(status);
    }

    private void playerTurn(Player player) {
        display();
        System.out.println("Your turn, player " + player.getRepresentation());
        int[] playerMove = getMoveFromPlayer();
        setOwner(playerMove, player);
    }
    public void play() {
        Player player1 = new Player();

        Representation player1Representation = player1.getRepresentation();
        Player player2 = new Player(player1Representation);

        System.out.println("Welcome both of you! Now let's play. Player1, you start!");
        int turn = 1;

        while (turn <= size * size ) {
            if (turn % 2 == 0) {
                playerTurn(player2);
            } else {
                playerTurn(player1);
            }
            turn++;
        }
        display();
        System.out.println("~~*-_-*-_-*-_-*~~");
        System.out.println("All right! So, who won??");

    }

}
