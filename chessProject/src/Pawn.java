public class Pawn extends Piece {

  private Boolean promoted;
  private Piece newPiece;


  public Pawn() {
  }

  public Pawn(boolean white) {

    super(white);
  }


  @Override
  public boolean isValidMove(Position newPosition) {

    if (!super.isValidMove(position)) {
      return false;
    }

    if (newPosition.getPiece().isWhite() == this.position.getPiece().isWhite()) {
      return false;
    }

    if ((newPosition.getRow() == this.position.getRow()) && (
        newPosition.getCol() - this.position.getCol() == 1)) {
      return true;
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
}
