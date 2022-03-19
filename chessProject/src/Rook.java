public class Rook extends Piece {


  public Rook(boolean white) {

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

    if (newPosition.getCol() == this.position.getCol()
        || newPosition.getRow() == this.position.getRow()) {
      return true;
    } else {
      return false;
    }
  }


}
