public class Rook extends Piece {






  @Override
  public boolean isValidMove(Position newPosition) {
    if (newPosition.getCol() == this.position.getCol()
        || newPosition.getRow() == this.position.getRow()) {
      return true;
    } else {
      return false;
    }
  }


}
