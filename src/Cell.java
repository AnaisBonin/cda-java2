public class Cell {
    private String representation;

    public void setRepresentation(Representation status) {
        this.representation = "|  " + status.getValue() + " ";
    }
    public Cell(Representation status) {
        setRepresentation(status);
    }
    public Cell() {
        this(Representation.EMPTY);
    }


    public String getRepresentation() {
        return this.representation;
    }
}
