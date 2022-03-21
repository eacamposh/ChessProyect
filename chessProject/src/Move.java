public class Move {

  private Position startPosition;
  private Position endPosition;
  private Player player;
  private Piece pieceMoved;
  private Piece pieceKilled;


  public Move(Player player, Position start, Position end) {
    this.player = player;
    this.startPosition = start;
    this.endPosition = end;
    this.pieceMoved = start.getPiece();
  }


  public Position getStartPosition() {
    return startPosition;
  }

  public void setStartPosition(Position startPosition) {
    this.startPosition = startPosition;
  }

  public Position getEndPosition() {
    return endPosition;
  }

  public void setEndPosition(Position endPosition) {
    this.endPosition = endPosition;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Piece getPieceMoved() {
    return pieceMoved;
  }

  public void setPieceMoved(Piece pieceMoved) {
    this.pieceMoved = pieceMoved;
  }

  public Piece getPieceKilled() {
    return pieceKilled;
  }

  public void setPieceKilled(Piece pieceKilled) {
    this.pieceKilled = pieceKilled;
  }

  public boolean isPieceOnTheWay(Piece piece) {

    return true;
  }

}
