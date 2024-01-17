public class TicTacToe {
    final int size = 3;
    Cell[][] board = new Cell[size][size];

    private Cell[] buildOneRow() {
        Cell[] row = new Cell[size];

        for (int i = 0; i < size; i++) {
            row[i] = new Cell();
        }
        return row;
    }
}
