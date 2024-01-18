import java.util.Scanner;

public class Player {
    CellStatus representation;

    //
    // CONSTRUCTOR
    //

    private boolean isPlayerInputValid(String input) {
        return switch (input) {
            case "X", "Y" -> true;
            default -> false;
        };
    }
    private void getPlayerInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Who do you want to play ? X or Y ? Press the X or Y key and Enter");
        String playerInput = scanner.nextLine().toUpperCase();

        while (!isPlayerInputValid(playerInput)) {
            System.out.println("Your entry is not valid, press X or Y");
            playerInput = scanner.nextLine().toUpperCase();
        }

        representation =  playerInput.equals("X") ? CellStatus.X : CellStatus.Y;

        System.out.println("Great! You are playing " + playerInput);
    }

    public Player() {
        getPlayerInput();
    }

    //
    // METHODS
    //
    public CellStatus getRepresentation() {
        return this.representation;
    }
}
