package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);

    }


    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {



        ArrayList<Move> movesList = new ArrayList<Move>();

        // checks if collsion occurs on potential move .


        // return  only legal moves in arraylist of moves

//        Coordinates potentialMove = new Coordinates((from.getRow()  + blackOrWhite(1) ), from.getCol());
//        if (checkBoardEmpty(potentialMove, board) && checkinBounds(potentialMove)) {
//            movesList.add(new Move(from, potentialMove));
        checkAmove(from, movesList, board,1);

        checkCapture(from,movesList,board);

        if ((!this.getHasMoved()) && checkAmove(from, movesList, board,1)) {
            checkAmove(from, movesList, board,2);

        }


        return movesList;
    }

    //getters and setters

    public boolean checkinBounds(Coordinates poetentialMove) {
        if (poetentialMove.getCol() < 8 && poetentialMove.getRow() < 8 && poetentialMove.getCol() >= 0 && poetentialMove.getRow() >= 0) {
            return true;
        } else{
            return false;
        }

    }

    public boolean checkBoardEmpty(Coordinates potentialMove, Board board) {
        if (board.get(potentialMove) == null) {
            return true;
        }

        return false;

    }
    public boolean checkPawnCapturable(Coordinates potentialMove, Board board) {
        PlayerColour switcheroo;
        if (board.get(potentialMove) != null) {

            if (this.getColour() == PlayerColour.WHITE) {
                switcheroo = PlayerColour.BLACK;

            } else {
                switcheroo = PlayerColour.WHITE;
            }
            if ((board.get(potentialMove).getType() != null) && board.get(potentialMove).getColour() == switcheroo) {
                return true;
            }
        }

        return false;

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

    public boolean checkAmove (Coordinates from, ArrayList<Move> movesList, Board board , int movedist){
        Coordinates potentialMove = new Coordinates((from.getRow()  + blackOrWhite(movedist) ), from.getCol());
        if ( checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board)) {
            movesList.add(new Move(from, potentialMove));
            return true;
        }
        return false;
    }

    public void checkCapture(Coordinates from, ArrayList<Move> movesList, Board board){
        Coordinates potentialMove = new Coordinates((from.getRow() + blackOrWhite(1)), (from.getCol() +1));
        if ( checkinBounds(potentialMove) ) {
            if (checkPawnCapturable(potentialMove, board)) {

                    movesList.add(new Move(from, potentialMove));


            }
        }

           Coordinates potentialMove2 = new Coordinates((from.getRow() + blackOrWhite(1)), (from.getCol() -1 ));
            if ( checkinBounds(potentialMove2) ) {
                if (checkPawnCapturable(potentialMove2, board)) {

                    movesList.add(new Move(from, potentialMove2));


                }
            }


    }
}
