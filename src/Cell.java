import java.sql.Array;

public class Cell {

    //
    // ATTRIBUTES
    //

    private Representation representation;
    private int[] coordinates;



    //
    // CONSTRUCTOR
    //

    public Cell(Representation representation) {
        setRepresentation(representation);
    }

    public Cell() {
        this(Representation.EMPTY);
    }

    public Cell(int col, int row) {
        setCoordinates(new int[]{col, row});
    }

    //
    // METHODS
    //

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }
    public Representation getRepresentation() {
        return this.representation;
    }

    public int[] getCoordinates(){
        return this.coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isCellAvailable() {
        return this.representation == Representation.EMPTY;
    }

    public String getDrawing(Representation representation) {
        return "|  " + representation.getValue() + " ";
    }
}

