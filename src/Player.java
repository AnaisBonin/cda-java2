import java.util.Scanner;

public class Player {
    String representation;

    public String getRepresentation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who do you want to play ? X or Y ? Press the X or Y key and Enter");

        String playerRepresentation = scanner.nextLine();

        switch (playerRepresentation) {
            case "X":
                representation = "|  X";
                break;
            case "Y":
                representation = "|  Y";
                break;
            default:
                System.out.println("Your entry is not valid, try again");
                return getRepresentation();
        }
        System.out.println("Great! You are playing " + representation);
        return representation;
    }
}
