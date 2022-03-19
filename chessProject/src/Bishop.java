public class Bishop extends Piece {

  public Bishop(boolean white) {

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

    if (Math.abs(newPosition.getCol() - this.position.getCol()) == Math.abs(
        newPosition.getRow() - this.position.getRow())) {
      return true;
    } else {
      return false;
    }

  }


}
