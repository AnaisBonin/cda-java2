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

        for (Cell [] row : board){
            for (Cell cell : row){
                System.out.printf(cell.getRepresentation());
            }
            System.out.printf(endRow);
            System.out.println();
            System.out.println(horizontalBorder);
        }
    }
    public void getMoveFromPlayer(int[] move) {
        boolean isMoveValid = move.length == 2;

        if (isMoveValid) {
            System.out.println(player.getRepresentation());
        } else {
            System.out.println("Invalid input");
        }
    }
}
