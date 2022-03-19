public class Knight extends Piece {


  public Knight(boolean white) {
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

    if ((Math.abs(newPosition.getRow() - this.position.getRow()) == 1)
        && (Math.abs(newPosition.getCol() - this.position.getCol()) == 2) ||
        (Math.abs(newPosition.getRow() - this.position.getRow()) == 2)
            && (Math.abs(newPosition.getCol() - this.position.getCol()) == 1)) {
      return true;
    } else {
      return false;
    }
  }

}
