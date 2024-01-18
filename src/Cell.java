public class Cell {
    String representation;
    CellStatus status;

    private void defineRepresentation(CellStatus status) {
        switch(status) {
            case X: representation = "|  X ";
            case Y: representation = "|  Y ";
            default: representation = "|    ";
        }
    }
    public Cell(CellStatus status) {
        this.status = status;
        defineRepresentation(status);
    }


    public String getRepresentation() {
        return this.representation;
    }
}
