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
        // return  only legal moves in arraylist of moves
        if(this.getColour() == PlayerColour.WHITE ) {
            Coordinates potentialmove = new Coordinates((from.getRow() - 1), from.getCol());
            movesList.add(new Move(from,potentialmove));
        } else if(this.getColour() == PlayerColour.BLACK ) {
            Coordinates potentialmove = new Coordinates((from.getRow() + 1), from.getCol());
            movesList.add(new Move(from,potentialmove));
        } else {
            System.out.println("error no colour");
        }



         return movesList;
    }
}
