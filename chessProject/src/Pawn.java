public class Pawn extends Piece {

  private Boolean promoted;
  private Piece newPiece;

  public Pawn() {
  }

  public Pawn(Integer value, Boolean isWhite, Boolean promoted, Piece newPiece) {
    super(value, isWhite);
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
