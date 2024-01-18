public class Cell {
    private String representation;

    public void setRepresentation(Representation status) {
        switch(status) {
            case Representation.EMPTY -> this.representation = "|    ";
            case Representation.X -> this.representation = "|  X ";
            case Representation.Y -> this.representation = "|  Y ";
        }
    }
    public Cell(Representation status) {
        setRepresentation(status);
    }


    public String getRepresentation() {
        return this.representation;
    }
}
