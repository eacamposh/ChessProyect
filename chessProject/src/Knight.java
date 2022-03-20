public class Knight extends Piece {


    public Knight(boolean white) {
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

        if ((Math.abs(move.getEndPosition().getRow() - move.getStartPosition().getRow()) == 1)
            && (Math.abs(move.getEndPosition().getCol() - move.getStartPosition().getCol()) == 2) ||
            (Math.abs(move.getEndPosition().getRow() - move.getStartPosition().getRow()) == 2)
                && (Math.abs(move.getEndPosition().getCol() - move.getStartPosition().getCol()) == 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "♘";
        } else {
            return "♞";
        }
    }

}
