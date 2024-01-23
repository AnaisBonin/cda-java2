import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    //
    // *********
    // ****************
    // TIC TAC TOE ATTRIBUTES
    // ****************
    // *********
    //

    private final int size = 3;
    private final Cell[][] board = new Cell[size][size];
    private final Scanner scanner = new Scanner(System.in);

    private final Victory victory = new Victory();

    private String victoryMessage = "No winner yet";

    //
    // *********
    // ATTRIBUTES SETTERS
    // *********
    //

    //
    // BUILD BOARD : get one row first (*size* columns), then duplicate this row (*size* rows)
    //

    private Cell[] getOneRow() {
        Cell[] row = new Cell[size];

        for (int i = 0; i < size; i++) {
            row[i] = new Cell();
        }
        return row;
    }

    private void getBoard() {
        for (int i = 0; i < size; i++) {
            board[i] = getOneRow();
        }
    }


    //
    // *********
    // ****************
    // TIC TAC TOE CONSTRUCTOR
    // ****************
    // *********
    //

    public TicTacToe() {
        getBoard();
    }


    //
    // *********
    // ****************
    // TIC TAC TOE METHODS
    // ****************
    // *********
    //


    //
    // *********
    // Display visually game grid - size  * size
    // *********
    //

    public void display() {
        String endRow = "|";
        StringBuilder horizontalBorder = new StringBuilder();
        horizontalBorder.append(" ----".repeat(size));

        System.out.println(horizontalBorder);

        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.printf(cell.getDrawing(cell.getRepresentation()));
            }
            System.out.printf(endRow);
            System.out.println();
            System.out.println(horizontalBorder);
        }
    }


    //
    // *********
    // Check Player Move: the move/target needs to be within the board size
    // *********
    //

    private boolean isMoveInvalid(int target) {
        return (target > size || target <= 0);
    }

    private int getPlayerEntry(String target) {
        int result = -1;

        System.out.println("which " + target + " do you want to target?");

        while (isMoveInvalid(result)) {
            try {
                result = Integer.parseInt(scanner.nextLine());

                if (isMoveInvalid(result)) {
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
    // *********
    // Check if targeted cell is available
    // *********
    //


    private boolean isCellAvailable(int[] move) {
        int col = move[0];
        int row = move[1];

        Cell targettedCell = board[row - 1][col - 1];
        boolean isCellAvailable = targettedCell.isCellAvailable();

        if (isCellAvailable) {
            return true;
        } else {
            System.out.println("This cell is not available, select another cell");
            return false;
        }
    }


    //
    // *********
    // METHOD to return player move
    // *********
    //

    public int[] getMoveFromPlayer() {
        int[] move = setPlayerEntry();

        while (!isCellAvailable(move)) {
            move = setPlayerEntry();
        }

        System.out.println("You picked: " + Arrays.toString(move));
        return move;
    }

    private void setOwner(int[] move, Player player) {
        int col = move[0];
        int row = move[1];
        Representation status = player.getRepresentation();

        this.board[row - 1][col - 1].setRepresentation(status);
    }


    //
    // *********
    // METHOD to play turns
    // *********
    //

    private boolean isFirstPlayerTurn(int turn) {
        return turn % 2 == 0;
    }


    private void playerTurn(Player player) {
        display();
        System.out.println("Your turn, player " + player.getRepresentation());

        int[] playerMove = getMoveFromPlayer();
        setOwner(playerMove, player);

        boolean isWinner = victory.foundWinningLine(playerMove, board, size);

        if (isWinner) {
            victory.setVictory(true);
            victoryMessage = ("Player " + player.getRepresentation() + " won!!");
        }
    }

    private void playTurns(Player player1, Player player2) {
        System.out.println("Welcome both of you! Now let's play. Player1, you start!");
        int turn = 0;

        while ((turn < (size * size)) && !victory.getVictory()) {
            if (isFirstPlayerTurn(turn)) {
                playerTurn(player1);
            } else {
                playerTurn(player2);
            }
            turn++;
        }

        display();
    }


    //
    // *********
    // METHOD for final play
    // *********
    //
    public void play() {
        Player player1 = new Player();

        Representation player1Representation = player1.getRepresentation();
        Player player2 = new Player(player1Representation);

        playTurns(player1, player2);

        System.out.println("~~*-_-*-_-*-_-*~~");
        if (!victory.getVictory()) {
            victoryMessage = "Both of you lost :( Try again!";
        }
        System.out.println(victoryMessage);

    }

}
