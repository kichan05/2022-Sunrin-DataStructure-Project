package chess;

import chess.util.PieceType;
import chess.util.Pos;
import chess.util.Team;

public class GameTest {
    public static void testEnPassant() {
        Board.board.clearBoard();

        initBackLine();
        for (int i = 0; i < 8; i++) Board.board.createPiece(new Pos(i, 1), PieceType.PAWN, Team.YELLOW);
        Board.board.createPiece(new Pos(5, 6), PieceType.PAWN, Team.BLUE);
        Board.board.getPieceByPos(new Pos(5, 6)).setPos(new Pos(5 ,4));
    }

    public static void testCastling() {
        Board.board.clearBoard();

        initKing();
        Board.board.createPiece(new Pos(0, 0), PieceType.ROOK, Team.YELLOW);
        Board.board.createPiece(new Pos(7, 0), PieceType.ROOK, Team.YELLOW);
        Board.board.createPiece(new Pos(0, 7), PieceType.ROOK, Team.BLUE);
        Board.board.createPiece(new Pos(7, 7), PieceType.ROOK, Team.BLUE);
    }

    public static void testPromotion() {
        Board.board.clearBoard();

        initKing();
        Board.board.createPiece(new Pos(2, 1), PieceType.PAWN, Team.BLUE);
        Board.board.createPiece(new Pos(2, 6), PieceType.PAWN, Team.YELLOW);
    }

    public static void initKing() {
        Board.board.createPiece(new Pos(4, 0), PieceType.KING, Team.YELLOW);
        Board.board.createPiece(new Pos(4, 7), PieceType.KING, Team.BLUE);
    }

    public static void initBackLine() {
        Board.board.createPiece(new Pos(0, 0), PieceType.ROOK, Team.YELLOW);
        Board.board.createPiece(new Pos(1, 0), PieceType.KNIGHT, Team.YELLOW);
        Board.board.createPiece(new Pos(2, 0), PieceType.BISHOP, Team.YELLOW);
        Board.board.createPiece(new Pos(3, 0), PieceType.QUEEN, Team.YELLOW);
        Board.board.createPiece(new Pos(4, 0), PieceType.KING, Team.YELLOW);
        Board.board.createPiece(new Pos(5, 0), PieceType.BISHOP, Team.YELLOW);
        Board.board.createPiece(new Pos(6, 0), PieceType.KNIGHT, Team.YELLOW);
        Board.board.createPiece(new Pos(7, 0), PieceType.ROOK, Team.YELLOW);

        Board.board.createPiece(new Pos(0, 7), PieceType.ROOK, Team.BLUE);
        Board.board.createPiece(new Pos(1, 7), PieceType.KNIGHT, Team.BLUE);
        Board.board.createPiece(new Pos(2, 7), PieceType.BISHOP, Team.BLUE);
        Board.board.createPiece(new Pos(3, 7), PieceType.QUEEN, Team.BLUE);
        Board.board.createPiece(new Pos(4, 7), PieceType.KING, Team.BLUE);
        Board.board.createPiece(new Pos(5, 7), PieceType.BISHOP, Team.BLUE);
        Board.board.createPiece(new Pos(6, 7), PieceType.KNIGHT, Team.BLUE);
        Board.board.createPiece(new Pos(7, 7), PieceType.ROOK, Team.BLUE);

    }

    public static void testKing() {
        Board.board.clearBoard();

        initKing();
        Board.board.createPiece(new Pos(4, 3), PieceType.ROOK, Team.BLUE);
    }
}
