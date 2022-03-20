public class Pawn extends Piece {

    private Boolean promoted;
    private Piece newPiece;


    public Pawn() {
    }

    public Pawn(boolean white) {
        super(white);
    }


    @Override
    public boolean isValidMove(Move move) {

        if (!super.isValidMove(move)) {
            return false;
        }
        if (Math.abs(move.getEndPosition().getCol() - move.getStartPosition().getCol()) == Math.abs(
          move.getEndPosition().getRow() - move.getStartPosition().getRow())) {
            return true;
        }

        if (move.getEndPosition().getPiece() != null) {
            if (move.getEndPosition().getPiece().isWhite() == move.getStartPosition().getPiece()
              .isWhite()) {
                return false;
            }
        }
        if ((move.getEndPosition().getCol() == move.getStartPosition().getCol())
          & move.getEndPosition().getPiece() == null) {
            if (Math.abs(move.getEndPosition().getRow() - move.getStartPosition().getRow()) == 2
              & move.getStartPosition().getRow() == 1 & move.getStartPosition().getPiece().isWhite()) {
                return true;
            } else if (Math.abs(move.getEndPosition().getRow() - move.getStartPosition().getRow()) == 2
              & move.getStartPosition().getRow() == 6 & !move.getStartPosition().getPiece().isWhite()) {
                return true;
            } else if (Math.abs(move.getEndPosition().getRow() - move.getStartPosition().getRow()) == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }


    public Pawn(Boolean isWhite, Boolean promoted, Piece newPiece) {
        super(isWhite);
        this.promoted = promoted;
        this.newPiece = newPiece;

    }

    public Boolean getPromoted() {
        return promoted;
    }

    public void setPromoted(Boolean promoted) {
        this.promoted = promoted;
    }

    public Piece getNewPiece() {
        return newPiece;
    }

    public void setNewPiece(Piece newPiece) {
        this.newPiece = newPiece;
    }


    @Override
    public String toString() {
        if (isWhite()) {
            return "♙";
        } else {
            return "♟";
        }
    }
}
