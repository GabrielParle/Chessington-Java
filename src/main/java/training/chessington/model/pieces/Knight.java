package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> movesList = new ArrayList<Move>();
        knightMoves(from, board, movesList);


        return movesList;
    }


    public void knightMoves(Coordinates from, Board board, ArrayList<Move> movesList) {
        for (int i = -2; i < 3; i++) {
            for (int y = -2; y < 3; y++) {

                int yplus = (y < 0) ? (y * -1) : y;
                int iplus = (i < 0) ? (i * -1) : i;

                if ((iplus + yplus) == 3) {
                    System.out.println(i + "," + y);
                    Coordinates potentialMove = new Coordinates((from.getRow() + i), (from.getCol() + y));
                    if (checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board) || (checkinBounds(potentialMove) && canITake(potentialMove,board))) {
                        movesList.add(new Move(from, potentialMove));
                    }


                }
            }
        }
    }
}
