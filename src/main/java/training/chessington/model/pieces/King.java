package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> movesList = new ArrayList<Move>();

        kingsMove(from,board,movesList);

        return movesList;
    }

    public void kingsMove(Coordinates from, Board board, ArrayList<Move> movesList){

        for(int i = -1 ; i< 2; i++){
            for(int y = -1; y < 2 ; y++){
                System.out.println(i + "'" + y);


                    Coordinates potentialMove = new Coordinates((from.getRow() + i), (from.getCol() + y));
                    if (checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board) || (checkinBounds(potentialMove) && canITake(potentialMove,board))) {
                        movesList.add(new Move(from, potentialMove));
                    }


                }
            }
        }
    }




