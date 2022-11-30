package chess.pieces;

import chess.Board;
import chess.util.PieceType;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(int x, int y, Team team) {
        super(x, y, team, '♜', 2, PieceType.ROOK);
    }

    /**
     * 룩의 위치를 기준으로, 동서남북으로 위치를 보면서 본다
     */
    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<Pos>();

        for (int y = getPosY() + 1; y < 8; y++) {
            Pos p = new Pos(getPosX(), y);

            Piece posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }

        for (int y = getPosY() - 1; 0 <= y; y--) {
            Pos p = new Pos(getPosX(), y);

            Piece posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }

        for (int x = getPosX() + 1; x < 8; x++) {
            Pos p = new Pos(x, getPosY());

            Piece posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }

        for (int x = getPosX() - 1; 0 <= x; x--) {
            Pos p = new Pos(x, getPosY());

            Piece posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }

        return posList;
    }
}
