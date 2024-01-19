import java.util.Scanner;

public class Player {
    private Representation representation;

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

        System.out.println("Hello new player! Who do you want to play ? X or Y ? Press the X or Y key and Enter");
        String playerInput = scanner.nextLine().toUpperCase();

        while (!isPlayerInputValid(playerInput)) {
            System.out.println("Your entry is not valid, press X or Y");
            playerInput = scanner.nextLine().toUpperCase();
        }

        representation =  playerInput.equals("X") ? Representation.X : Representation.Y;

        System.out.println("Great! You are playing " + playerInput);
    }

    public Player() {
        getPlayerInput();
    }

    public Player(Representation otherPlayerRepresentation) {
        if (otherPlayerRepresentation == Representation.X) {
            this.representation = Representation.Y;
        } else {
            this.representation = Representation.X;
        }
        System.out.println("~~*-_-*-_-*-_-*~~");
        System.out.println("Hello other player! Since the first player is playing as " + otherPlayerRepresentation + ", you will play as " + this.representation);
    }

    //
    // METHODS
    //
    public Representation getRepresentation() {
        return this.representation;
    }
}
