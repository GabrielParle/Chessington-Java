package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.PlayerColour;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;



    private boolean hasMoved =false;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }
    public boolean checkBoardEmpty(Coordinates potentialMove, Board board) {
        if (board.get(potentialMove) == null) {
            return true;
        }

        return false;

    }
    public boolean checkinBounds(Coordinates poetentialMove) {
        if (poetentialMove.getCol() < 8 && poetentialMove.getRow() < 8 && poetentialMove.getCol() >= 0 && poetentialMove.getRow() >= 0) {
            return true;
        } else{
            return false;
        }

    }
    public int blackOrWhite(int i) {
        if (this.getColour() == PlayerColour.WHITE) {
            return (-i);

        } else if (this.getColour() == PlayerColour.BLACK) {
            return (i);

        }
        else {
            System.out.println("no colour");
            return 10000;
        }
    }
    public boolean canITake(Coordinates potentialMove,Board board) {
        if(board.get(potentialMove).getColour() == this.colour){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
