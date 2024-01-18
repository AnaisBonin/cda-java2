public class Cell {
    private String representation;

    public void setRepresentation(CellStatus status) {
        switch(status) {
            case CellStatus.EMPTY -> this.representation = "|    ";
            case CellStatus.X -> this.representation = "|  X ";
            case CellStatus.Y -> this.representation = "|  Y ";
        }
    }
    public Cell(CellStatus status) {
        setRepresentation(status);
    }


    public String getRepresentation() {
        return this.representation;
    }
}
