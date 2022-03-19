public class Queen extends Piece {


  public Queen(boolean white) {

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

    return RookMovement(newPosition) || BishopMovement(newPosition);
  }


  protected boolean BishopMovement(Position newPosition) {

    if (Math.abs(newPosition.getCol() - this.position.getCol()) == Math.abs(
        newPosition.getRow() - this.position.getRow())) {
      return true;
    } else {
      return false;
    }

  }


  protected boolean RookMovement(Position newPosition) {

    if (newPosition.getCol() == this.position.getCol()
        || newPosition.getRow() == this.position.getRow()) {
      return true;
    } else {
      return false;
    }

  }


}
