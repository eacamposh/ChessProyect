import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Driver {

  private static Player p1;
  private static Player p2;

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Game game = new Game();
    System.out.println("Welcome to our Chess Game");
    System.out.println("White Pieces: ♔ ♕ ♖ ♗ ♘ ♙");
    System.out.println("Black Pieces: ♚ ♛ ♜ ♝ ♞ ♟");

    // initialize and show the board.
    game.newBoard();
    game.currentBoardGame();
    System.out.println("Press enter to play (type 'help' for help):");
    String help = input.nextLine().toLowerCase(Locale.ROOT);
    if (help.equals("help")) {
      game.helpGame();
    }

    // initialize and show the board.
    game.newBoard();
    //game.currentBoardGame();

    // initialize players and board.
    p1 = new Player(true);
    p2 = new Player(false);
    //p1.setPieceColorWhite(true);
    game.initializePlayers(p1, p2);

    while (true) {

      // print the current board.
      boolean validator1 = true;
      boolean validator2 = true;
      game.currentBoardGame();
      Scanner sc = new Scanner(System.in);
      // Move move = new Move();
      int xInitial = 0;
      int yInitial = 0;
      int xFinal = 0;
      int yFinal = 0;

      if (!game.GAME_STATUS.equalsIgnoreCase("ACTIVE")) {
        System.out.println("END GAME, Thanks for playing");
        break;
      }

      // this while it's going to work while if the player1 pick up a different piece their color
      while (validator1) {
        //ask the player for the movement.
        yInitial = Game.getUserInput("♔ Player 1:  Insert the position (number in Y axis ) of the piece that you want to move ");
        xInitial = Game.getUserInput("♔ Player 1: Insert the position (number in X axis ) of the piece that you want to move ");

        Position pos[][] = game.getBoard();

        Piece pieceSelected = pos[yInitial][xInitial].getPiece();

        if (pieceSelected.isWhite()) {
          validator1 = false;
        }

        yFinal = Game.getUserInput("♔ Player 1: Insert the position (number in Y axis ) to where you want to move your piece ");
        xFinal = Game.getUserInput("♔ Player 1: Insert the position (number in X axis ) to where you want to move your piece ");

        Piece endPiece = pos[yFinal][xFinal].getPiece();
        // if the player pick up a proper piece, then make the move.
        if (!validator1) {
          Position positionStart = new Position(xInitial, yInitial, pieceSelected);
          Position positionEnds = new Position(xFinal, yFinal, endPiece);
          Move move = new Move(p1, positionStart, positionEnds);

          if (!game.makeMove(move, p1)) {
            validator1 = true;
            game.currentBoardGame();
            System.out.println("You can't move the piece : " + positionStart.getPiece()
                + " in that way, please try again");
          }
        } else {
          game.currentBoardGame();
          System.out.println("You can't move the other player pieces, try again");
        }
      }

      if (!game.GAME_STATUS.equalsIgnoreCase("ACTIVE")) {
        System.out.println("END GAME, Thanks for playing");
        break;
      }

      // time to play for player 2

      game.currentBoardGame();
      Scanner sc2 = new Scanner(System.in);
      int xInitial2 = 0;
      int yInitial2 = 0;
      int xFinal2 = 0;
      int yFinal2 = 0;

      while (validator2) {
        yInitial2 = Game.getUserInput("♔ Player 2:  Insert the position (number in Y axis ) of the piece that you want to move ");
        xInitial2 = Game.getUserInput("♔ Player 2: Insert the position (number in X axis ) of the piece that you want to move ");

        Position pos2[][] = game.getBoard();
        Piece pieceSelected2 = pos2[yInitial2][xInitial2].getPiece();

        if (!pieceSelected2.isWhite()) {
          validator2 = false;
        }
        Game.isEmpty(pieceSelected2);

        yFinal2 = Game.getUserInput("♔ Player 2:  Insert the position (number in Y axis ) of the piece that you want to move ");
        xFinal2 = Game.getUserInput("♔ Player 2: Insert the position (number in X axis ) of the piece that you want to move ");
        Piece endPiece2 = pos2[yFinal2][xFinal2].getPiece();

        // if the player pick up a proper piece, then make the move.
        if (!validator2) {
          Position positionStart2 = new Position(xInitial2, yInitial2, pieceSelected2);
          Position positionEnds2 = new Position(xFinal2, yFinal2, endPiece2);
          Move move2 = new Move(p2, positionStart2, positionEnds2);

          if (!game.makeMove(move2, p2)) {
            validator2 = true;
            game.currentBoardGame();
            System.out.println("You can't move the piece : " + positionStart2.getPiece()
                + " in that way, please try again");
          }
        } else {
          game.currentBoardGame();
          System.out.println("You can't move the other player pieces, try again");
        }
      }
    }
  }

}
