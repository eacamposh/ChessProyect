import java.util.Scanner;

public class Game {

  private Position[][] board;
  private Player[] players = new Player[2];
  private Player currentTurnPlayer;
  public String GAME_STATUS = "ACTIVE";


  public Position[][] getBoard() {
    return board;
  }

  public void setBoard(Position[][] board) {
    this.board = board;
  }

  public Player[] getPlayers() {
    return players;
  }

  public void setPlayers(Player[] players) {
    this.players = players;
  }

  public Player getCurrentTurnPlayer() {
    return currentTurnPlayer;
  }

  public void setCurrentTurnPlayer(Player currentTurnPlayer) {
    this.currentTurnPlayer = currentTurnPlayer;
  }

  public Game() {

  }


  public void newBoard() {
    board = new Position[8][8];

    // white pieces.first line ( the important pieces )
    board[0][0] = new Position(0, 0, new Rook(true));
    board[0][1] = new Position(0, 1, new Knight(true));
    board[0][2] = new Position(0, 2, new Bishop(true));
    board[0][3] = new Position(0, 3, new King(true));
    board[0][4] = new Position(0, 4, new Queen(true));
    board[0][5] = new Position(0, 5, new Bishop(true));
    board[0][6] = new Position(0, 6, new Knight(true));
    board[0][7] = new Position(0, 7, new Rook(true));

    // the white  pawn's line
    board[1][0] = new Position(1, 0, new Pawn(true));
    board[1][1] = new Position(1, 1, new Pawn(true));
    board[1][2] = new Position(1, 2, new Pawn(true));
    board[1][3] = new Position(1, 3, new Pawn(true));
    board[1][4] = new Position(1, 4, new Pawn(true));
    board[1][5] = new Position(1, 5, new Pawn(true));
    board[1][6] = new Position(1, 6, new Pawn(true));
    board[1][7] = new Position(1, 7, new Pawn(true));

    // black pieces.first line ( the important pieces )

    board[7][0] = new Position(7, 0, new Rook(false));
    board[7][1] = new Position(7, 1, new Knight(false));
    board[7][2] = new Position(7, 2, new Bishop(false));
    board[7][3] = new Position(7, 3, new King(false));
    board[7][4] = new Position(7, 4, new Queen(false));
    board[7][5] = new Position(7, 5, new Bishop(false));
    board[7][6] = new Position(7, 6, new Knight(false));
    board[7][7] = new Position(7, 7, new Rook(false));

    // the black  pawn's line

    board[6][0] = new Position(6, 0, new Pawn(false));
    board[6][1] = new Position(6, 1, new Pawn(false));
    board[6][2] = new Position(6, 2, new Pawn(false));
    board[6][3] = new Position(6, 3, new Pawn(false));
    board[6][4] = new Position(6, 4, new Pawn(false));
    board[6][5] = new Position(6, 5, new Pawn(false));
    board[6][6] = new Position(6, 6, new Pawn(false));
    board[6][7] = new Position(6, 7, new Pawn(false));

    //  remaining slots without any piece (null)
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = new Position(i, j, null);
      }
    }


  }

  public void initializePlayers(Player p1, Player p2) {
    players[0] = p1;
    players[1] = p2;

    if (p1.isPieceColorWhite()) {
      this.currentTurnPlayer = p1;
    } else {
      this.currentTurnPlayer = p2;
    }


  }


  public boolean makeMove(Move move, Player player) {

    Piece currentPieceMoving = move.getStartPosition().getPiece();

    // the player cannot move a NO piece
    if (currentPieceMoving == null) {
      return false;
    }
    if (!currentPieceMoving.isValidMove(move)) {
      return false;
    }

    // moving the piece

    Piece destPiece = move.getEndPosition().getPiece();
    if (destPiece instanceof King) {
      if (player.isPieceColorWhite()) {
        System.out.println("PLAYER WHITE WIN");
        GAME_STATUS = "WHITE_WIN";
      } else {
        System.out.println("PLAYER BLACK WIN");
        GAME_STATUS = "BLACK_WIN";
      }
    }
    move.getEndPosition().setPiece(move.getStartPosition().getPiece());
    move.getStartPosition().setPiece(null);

    board[move.getStartPosition().getRow()][move.getStartPosition().getCol()].setPiece(null);
    board[move.getEndPosition().getRow()][move.getEndPosition().getCol()].setPiece(
        move.getEndPosition().getPiece());

    return true;
  }

  public void currentBoardGame() {
    System.out.print("\n\t [X0]  [X1]   [X2]    [X3]    [X4]    [X5]     [X6]    [X7]");
    for (int i = 0; i < board.length; i++) {
      System.out.println();
      //System.out.print(i + "  ");
      System.out.print("[Y" + i + "]  ");
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j].getPiece() != null) {
          System.out.print(board[i][j].getPiece().toString() + "\t\t");
        } else {
          System.out.print(board[i][j].toString());
        }
      }
    }
    //System.out.println("\n   0 \t1 \t2 \t3 \t4 \t5 \t6 \t7");
    System.out.println("\n");
  }

  public void showBoardGame() {
    Game game = new Game();
    //System.out.print("\n\t\t (X0)  (X1)  (X2)  (X3)  (X4)  (X5)  (X6)  (X7)");
    System.out.print("\n\t [X0]  [X1]   [X2]    [X3]    [X4]    [X5]     [X6]    [X7]");
    for (int i = 0; i < board.length; i++) {
      System.out.println();
      System.out.print("(Y" + i + ")  ");
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j].getPiece() != null) {
          System.out.print(board[i][j].getPiece().toString() + "\t\t");
        } else {
          System.out.print(board[i][j].toString());
        }
      }
    }
    System.out.println("\n");
    helpGame();
  }

  public void possiblesMoves() {
    System.out.println("♛: The King moves from its square to a neighboring square.");
    System.out.println(
        "♚: The Queens move diagonally, horizontally, or vertically any number of squares.");
    System.out.println("♜: The Rook can move in its line or row.");
    System.out.println("♝: The Bishop moves diagonally.");
    System.out.println(
        "♞: The Knights move in an ‘L’ shape’: two squares in a horizontal or vertical direction, then move one square horizontally or vertically.");
    System.out.println("♟: The Pawn moves one square straight ahead.");
    System.out.println("\n");
    helpGame();

  }


  public void helpGame() {
    Scanner input = new Scanner(System.in);
    Game game = new Game();
    System.out.print(""
        + "|=======    Help    ============| "
        + "\n| 1. To list all possible moves |"
        + "\n| 2. To see the board again     |"
        + "\n| 3. Resign                     |"
        + "\n| 4. Start to play              |\n\n");
    int option = input.nextInt();
    switch (option) {
      case 1:
        game.possiblesMoves();
        break;
      case 2:
        game.newBoard();
        game.showBoardGame();
        break;
      case 3:
        System.out.println("Bye!");
        System.exit(0);
        break;
      case 4:
        game.newBoard();
        game.currentBoardGame();
        break;
      default:
        System.out.println("Invalid Input. Enter number between 1 and 4");
        helpGame();
    }
  }

  public static int getUserInput(String prompt) {
    int position = 0;
    try {
      Scanner question = new Scanner(System.in);
      System.out.println(prompt);
      position = question.nextInt();
      return position;
    } catch (NullPointerException e) {
      System.out.println("The spot is EMPTY. Please type 0 - 7");
    }
    return position;
  }

  public static boolean isEmpty(Piece piece){
    if(piece == null) {
      System.out.println("The spot is empty. Try again");
    }
    return true;
  }

}
