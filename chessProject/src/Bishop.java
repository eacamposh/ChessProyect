import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(boolean white) {

        super(white);
    }

    @Override
    public boolean isValidMove(Move move) {

        if (!super.isValidMove(move)) {
            return false;
        }

        if (move.getEndPosition().getPiece() != null) {
            //same Place
            if (move.getEndPosition().getPiece().isWhite() == move.getStartPosition().getPiece().isWhite()) {
                return false;
            }
        }

        //Diagonally
        int bishopMovableRange = getMovableRange(move.getStartPosition(), move.getEndPosition());
        int moveStartCol = move.getStartPosition().getCol();
        int moveEndCol = move.getEndPosition().getCol();
        int moveStartRow = move.getEndPosition().getRow();
        int moveEndRow = move.getStartPosition().getRow();

        if (
          Math.abs(moveEndCol - moveStartCol) == Math.abs(moveEndRow - moveStartRow)
            && Math.abs(moveEndRow - moveStartRow) < bishopMovableRange)
        {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "♗";
        } else {
            return "♝";
        }
    }

    public int getMovableRange(Position start, Position end) {
        int movableRange = 0;
        int distance = Math.abs(end.getRow())- start.getRow();
        int x = start.getRow();
        int y = start.getCol();

        for (int i = x ; x < distance ; x++) {
            for (int j = y ; y < distance ; y++) {
                if(end.getPiece() != null && end.getPiece().isWhite() == isWhite()) {
                    int limitRow = end.getRow();
                    int limitCol = end.getCol();
                    if(end.getPiece().isWhite()){
                        Position limitPosition = new Position(limitCol,limitRow,end.getPiece());
                        movableRange = Math.abs(limitPosition.getRow());
                        return movableRange;
                    }
                }
                if(end.getPiece() != null && end.getPiece().isWhite() != isWhite()){
                    end = null;
                }
            }
        }
        return movableRange;
    }

    //




}
