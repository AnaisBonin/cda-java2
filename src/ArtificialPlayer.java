import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtificialPlayer extends Player {
    private boolean isArtificialPlayer;


    public ArtificialPlayer(Representation otherPlayerRepresentation) {
        super(otherPlayerRepresentation);
        setIsArtificialPlayer(true);
    }
    //
    // *********
    // ****************
    // ARTIFICIAL PLAYER METHODS
    // ****************
    // *********
    //

    public boolean getIsArtificialPlayer() {
        return this.isArtificialPlayer;
    }

    public void setIsArtificialPlayer(boolean value) {
        this.isArtificialPlayer = value;
    }

    public void playArtificialTurn(Cell[][] board) {
        List<Cell> cells = new ArrayList<Cell>(){};
        for (int i = 0; i < board.length ; i++) {
// to do
        }

    }

}
