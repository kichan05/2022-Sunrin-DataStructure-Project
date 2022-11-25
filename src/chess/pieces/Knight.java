package chess.pieces;

import chess.Board;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(int x, int y, Team team) {
        super(x, y, team, '♞', 2);
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList();

        Pos pos;
        Piece targetPiece;

        pos = new Pos(getPosX() - 1, getPosY() - 2);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        pos = new Pos(getPosX() - 1, getPosY() + 2);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        pos = new Pos(getPosX() - 2, getPosY() - 1);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        pos = new Pos(getPosX() - 2, getPosY() + 1);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        pos = new Pos(getPosX() + 1, getPosY() - 2);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        pos = new Pos(getPosX() + 1, getPosY() + 2);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        pos = new Pos(getPosX() + 2, getPosY() - 1);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        pos = new Pos(getPosX() + 2, getPosY() + 1);
        targetPiece = Board.board.getPieceByPos(pos);
        if( pos.inBoard() && (targetPiece == null || targetPiece.getTeam() != getTeam() && !(targetPiece instanceof King)))
            posList.add(pos);

        return posList;
    }
}
