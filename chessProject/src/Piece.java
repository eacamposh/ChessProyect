public abstract class Piece {

  public Position position;
  private int value;
  private boolean isWhite;

  public Piece() {
  }

  public Piece(Integer value, Boolean isWhite) {
    this.value = value;
    this.isWhite = isWhite;
  }

  public Piece(Position position) {
    this.position = position;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }

  public boolean isValidMove(Position newPosition) {
    if (newPosition.getRow() > 0 && newPosition.getCol() > 0
        && newPosition.getRow() < 8 && newPosition.getCol() < 8) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "Piece{" + "position=" + position + ", value=" + value + ", isWhite=" + isWhite + '}';
  }
}
