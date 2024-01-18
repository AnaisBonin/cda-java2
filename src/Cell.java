public class Cell {
    String representation = "|    ";
    CellStatus status;

    public Cell(CellStatus status) {
        this.status = status;
    }


    public String getRepresentation() {
        return this.representation;
    }
}
