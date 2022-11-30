package chess;

import chess.pieces.*;
import chess.util.PieceType;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;

public class Board {
    public static Board board = new Board();

    private final ArrayList<Piece> pieces = new ArrayList<>();
    private ArrayList<Pos> canMovePosList = new ArrayList<>();

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setCanMovePosList(ArrayList<Pos> posList) {
        canMovePosList = posList;

        for (Pos pos : posList) {
            Piece piece = getPieceByPos(pos);
            if (piece != null) {
                piece.check();
            }
        }
    }

    public ArrayList<Pos> getCanMovePosList() {
        return canMovePosList;
    }

    public void clearCanMoveList() {
        canMovePosList.clear();

        for (Piece piece : pieces) {
            piece.unCheck();
        }
    }


    public void initGameBoard() {
        Board.board.createPiece(new Pos(0, 0), PieceType.ROOK, Team.YELLOW);
        Board.board.createPiece(new Pos(1, 0), PieceType.KNIGHT, Team.YELLOW);
        Board.board.createPiece(new Pos(2, 0), PieceType.BISHOP, Team.YELLOW);
        Board.board.createPiece(new Pos(3, 0), PieceType.QUEEN, Team.YELLOW);
        Board.board.createPiece(new Pos(4, 0), PieceType.KING, Team.YELLOW);
        Board.board.createPiece(new Pos(5, 0), PieceType.BISHOP, Team.YELLOW);
        Board.board.createPiece(new Pos(6, 0), PieceType.KNIGHT, Team.YELLOW);
        Board.board.createPiece(new Pos(7, 0), PieceType.ROOK, Team.YELLOW);
        for (int i = 0; i < 8; i++) Board.board.createPiece(new Pos(i, 1), PieceType.PAWN, Team.YELLOW);

        Board.board.createPiece(new Pos(0, 7), PieceType.ROOK, Team.BLUE);
        Board.board.createPiece(new Pos(1, 7), PieceType.KNIGHT, Team.BLUE);
        Board.board.createPiece(new Pos(2, 7), PieceType.BISHOP, Team.BLUE);
        Board.board.createPiece(new Pos(3, 7), PieceType.QUEEN, Team.BLUE);
        Board.board.createPiece(new Pos(4, 7), PieceType.KING, Team.BLUE);
        Board.board.createPiece(new Pos(5, 7), PieceType.BISHOP, Team.BLUE);
        Board.board.createPiece(new Pos(6, 7), PieceType.KNIGHT, Team.BLUE);
        Board.board.createPiece(new Pos(7, 7), PieceType.ROOK, Team.BLUE);
        for (int i = 0; i < 8; i++) Board.board.createPiece(new Pos(i, 6), PieceType.PAWN, Team.BLUE);

//        GameTest.testEnPassant();
//        GameTest.testCastling();
//        GameTest.testPromotion();
    }

    /**
     * 좌표를 입력받고 보드판에서 해당 위치에 말이 있는지 확인
     * 있으면 해당 말 객체를 반환, 없으면 null 반환
     */
    public Piece getPieceByPos(Pos pos) {
        for (Piece i : pieces) {
            if (i.getPos().equals(pos) && !i.isDeath()) {
                return i;
            }
        }

        return null;
    }

    public ArrayList<Piece> getTeamPieceList(Team team) {
        ArrayList<Piece> pieceList = new ArrayList<>();

        for (Piece i : pieces) {
            if (i.getTeam() == team && !i.isDeath()) {
                pieceList.add(i);
            }
        }

        return pieceList;
    }

    public void createPiece(Pos pos, PieceType pieceType, Team team) {
        switch (pieceType) {
            case PAWN -> pieces.add(new Pawn(pos.getX(), pos.getY(), team));
            case BISHOP -> pieces.add(new Bishop(pos.getX(), pos.getY(), team));
            case ROOK -> pieces.add(new Rook(pos.getX(), pos.getY(), team));
            case KNIGHT -> pieces.add(new Knight(pos.getX(), pos.getY(), team));
            case QUEEN -> pieces.add(new Queen(pos.getX(), pos.getY(), team));
            case KING -> pieces.add(new King(pos.getX(), pos.getY(), team));
        }
    }

    public King getKing(Team team) {
        for (Piece i : pieces) {
            if (i instanceof King && i.getTeam() == team) {
                return (King) i;
            }
        }

        return null;
    }

    public boolean isPosEmpty(Pos pos) {
        return getPieceByPos(pos) == null;
    }

    public void clearBoard() {
        pieces.clear();
    }
}
