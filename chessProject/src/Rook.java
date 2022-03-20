public class Rook extends Piece {


    public Rook(boolean white) {

        super(white);
    }


    @Override
    public boolean isValidMove(Move move) {

        if (!super.isValidMove(move)) {
            return false;
        }
        if (move.getEndPosition().getPiece() != null) {
            if (move.getEndPosition().getPiece().isWhite() == move.getStartPosition().getPiece().isWhite()) {
                return false;
            }
        }

        if (move.getEndPosition().getCol() == move.getStartPosition().getCol() || move.getEndPosition().getRow() == move.getStartPosition().getRow()) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        if (isWhite()) {
            return "♖";
        } else {
            return "♜";
        }
    }

}
