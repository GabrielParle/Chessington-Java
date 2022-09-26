package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {





        ArrayList<Move> movesList = new ArrayList<Move>();

        checkAmove0through8(from,movesList,board,"col");
        checkAmove0through8(from,movesList,board,"row");



        return movesList;
    }

    public void checkAmove0through8(Coordinates from, ArrayList<Move> movesList, Board board, String colOrRow) {

        int fromRow = from.getRow();
        int fromCol = from.getCol();


        if (colOrRow.contains("col")) {
            for (int i = (from.getCol() + 1); i < 9; i++) {
                fromCol = i;
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


        } else if (colOrRow.contains("row")) {
            for (int i = (from.getRow() + 1); i < 9; i++) {
                fromRow = i;
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
        }

        if (colOrRow.contains("col")) {
            for (int i = (from.getCol() - 1); i > -9; i--) {
                fromCol = i;
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


        } else if (colOrRow.contains("row")) {
            for (int i = (from.getRow() - 1); i > -9; i--) {
                fromRow = i;
                Coordinates potentialMove = new Coordinates((fromRow), fromCol);
                if (checkinBounds(potentialMove) && checkBoardEmpty(potentialMove, board)) {
                    movesList.add(new Move(from, potentialMove));


                } else if(checkinBounds(potentialMove)&& canITake(potentialMove,board)){
                    movesList.add(new Move(from, potentialMove));
                    break;
                } else{
                    break;
                }
            }
        }





        }




    }

