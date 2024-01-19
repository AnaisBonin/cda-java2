public class Cell {

    //
    // ATTRIBUTES
    //

    private Representation representation;
    private String drawing;

    public void setDrawing(Representation representation) {
        this.drawing = "|  " + representation.getValue() + " ";
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    //
    // CONSTRUCTOR
    //

    public Cell(Representation representation) {
        setRepresentation(representation);
        setDrawing(representation);
    }
    public Cell() {
        this(Representation.EMPTY);
    }

    //
    // METHODS
    //
    public boolean isCellAvailable(){
        return this.representation == Representation.EMPTY;
    }

    public Representation getRepresentation() {
        return this.representation;
    }

    public String getDrawing() {
        return this.drawing;
    }
}
