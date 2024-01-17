public class Main {
    public static void main(String[] args) {
        int[] playerInput = new int[]{1, 3};

        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.display();
        ticTacToe.getMoveFromPlayer(playerInput);
    }
}