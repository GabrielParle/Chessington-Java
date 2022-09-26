package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> movesList = new ArrayList<Move>();


        moveDiagonally(from,movesList,board);

         return movesList;

    }

    public void moveDiagonally(Coordinates from, ArrayList<Move> movesList, Board board)
        {
            int fromRow = from.getRow();
            int fromCol = from.getCol();
        for (int i = (from.getCol() + 1); i < 9; i++) {
            fromCol = i;
            fromRow++;
            Coordinates potentialMove = new Coordinates((fromRow), fromCol);
            if (checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board)) {
                movesList.add(new Move(from, potentialMove));


            } else if(checkinBounds(potentialMove) && canITake(potentialMove,board)){
                movesList.add(new Move(from, potentialMove));
                break;
            } else{
                break;
            }
        }

            int fromRow2 = from.getRow()-1;
            int fromCol2 = from.getCol();
            for (int i = (from.getCol()+1); i < 9; i++, fromRow2--) {
                fromCol2 = i;


                Coordinates potentialMove = new Coordinates((fromRow2), fromCol2);
                if (checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board)) {
                    movesList.add(new Move(from, potentialMove));


                } else if(checkinBounds(potentialMove) && canITake(potentialMove,board)){
                    movesList.add(new Move(from, potentialMove));
                    break;
                } else{
                    break;
                }
            }

            fromRow2 = from.getRow()-1;
            fromCol2 = from.getCol();
            for (int i = (from.getCol()-1); i < 9; i--, fromRow2--) {
                fromCol2 = i;


                Coordinates potentialMove = new Coordinates((fromRow2), fromCol2);
                if (checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board)) {
                    movesList.add(new Move(from, potentialMove));


                } else if(checkinBounds(potentialMove) && canITake(potentialMove,board)){
                    movesList.add(new Move(from, potentialMove));
                    break;
                } else{
                    break;
                }
            }
            fromRow2 = from.getRow()+1;
            fromCol2 = from.getCol();
            for (int i = (from.getCol()-1); i < 9; i--, fromRow2++) {
                fromCol2 = i;


                Coordinates potentialMove = new Coordinates((fromRow2), fromCol2);
                if (checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board)) {
                    movesList.add(new Move(from, potentialMove));


                } else if(checkinBounds(potentialMove) && canITake(potentialMove,board)){
                    movesList.add(new Move(from, potentialMove));
                    break;
                } else{
                    break;
                }
            }
    }
}
