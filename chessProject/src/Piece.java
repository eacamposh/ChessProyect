public abstract class Piece {

  public Position position;
  private boolean itsAlive;

  private boolean isWhite;

  public Piece() {
  }


  public Piece(Boolean isWhite) {

    this.isWhite = isWhite;
  }

  public Piece(Position position) {
    this.position = position;
  }


  public boolean isWhite() {
    return isWhite;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }

  public boolean isItsAlive() {
    return itsAlive;
  }

  public void setItsAlive(boolean itsAlive) {
    this.itsAlive = itsAlive;
  }

  public boolean isValidMove(Position newPosition) {
    // check if the move is in the board
    if (newPosition.getRow() > 0 && newPosition.getCol() > 0
        && newPosition.getRow() < 8 && newPosition.getCol() < 8) {

      return true;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "Piece{" +
        "position=" + position +
        ", isWhite=" + isWhite +
        '}';
  }
}
