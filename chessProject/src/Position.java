public class Position {

    /**
     * [Y]
     */
    private int col;
    /**
     * [X]
     */
    private int row;

    private Piece piece;

    /**
     *
     * @param col Y
     * @param row X
     * @param piece
     */
    public Position(int col, int row, Piece piece) {
        this.col = col;
        this.row = row;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "•\t\t";
    }

}
