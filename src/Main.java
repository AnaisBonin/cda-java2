public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Player player = new Player();

        ticTacToe.display();
        ticTacToe.getMoveFromPlayer();
        player.getRepresentation();

    }
}