package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {

    @Test
    public void whiteRookCanMoveSquares() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
    }
    @Test
    public void BlackRookCanMoveSquares() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
    }

    @Test
    public void RooksCannotMoveIfPieceInFrontSameColour() {
        // Arrange
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.WHITE);
        Coordinates blackCoords = new Coordinates(3, 4);
        board.placePiece(blackCoords, blackRook);

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4, 4);
        board.placePiece(whiteCoords, whiteRook);

        // Act
        List<Move> blackMoves = blackRook.getAllowedMoves(blackCoords, board);
        List<Move> whiteMoves = whiteRook.getAllowedMoves(whiteCoords, board);

        // Assert
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(1, 0)));
        assertThat(whiteMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(-1, 0)));
    }

    @Test
    public void whiteRooksCanCapture() {
        // Arrange
        Board board = Board.empty();
        Piece Rook = new Rook(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates RookCoords = new Coordinates(4, 4);
        board.placePiece(RookCoords, Rook);

        Coordinates enemyCoords = RookCoords.plus(0, 2);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = Rook.getAllowedMoves(RookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(RookCoords, enemyCoords));
    }



}
