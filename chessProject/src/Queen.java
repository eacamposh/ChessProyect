public class Queen extends Piece {


    public Queen(boolean white) {

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

        return RookMovement(move) || BishopMovement(move);
    }


    protected boolean BishopMovement(Move move) {

        if (Math.abs(move.getEndPosition().getCol() - move.getStartPosition().getCol()) == Math.abs(move.getEndPosition().getRow() - move.getStartPosition().getRow())) {
            return true;
        } else {
            return false;
        }

    }


    protected boolean RookMovement(Move move) {

        if (move.getEndPosition().getCol() == move.getStartPosition().getCol() || move.getEndPosition().getRow() == move.getStartPosition().getRow()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "♔";
        } else {
            return "♚";
        }
    }


}
