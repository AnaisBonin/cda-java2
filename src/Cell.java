public class Cell {

    //
    // ATTRIBUTES
    //

    private Representation representation;

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }
    public Representation getRepresentation() {
        return this.representation;
    }


    //
    // CONSTRUCTOR
    //

    public Cell(Representation representation) {
        setRepresentation(representation);
    }

    public Cell() {
        this(Representation.EMPTY);
    }

    //
    // METHODS
    //
    public boolean isCellAvailable() {
        return this.representation == Representation.EMPTY;
    }

    public String getDrawing(Representation representation) {
        return "|  " + representation.getValue() + " ";
    }
}

