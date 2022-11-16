package pieces;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(int x, int y, Team team) {
        super(x, y, team, '♝');
    }

    @Override
    public List<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<Pos>();
        int x, y;
        Pos pos;
        Piece posPiece;

        x = getPosX() - 1;
        y = getPosY() - 1;
        pos = new Pos(x, y);
        posPiece = Board.board.getPieceByPos(pos);
        while (pos.inBoard() && (posPiece == null || posPiece.getTeam() != getTeam())) {
            posList.add(pos);
            pos = new Pos(--x, --y);
        }

        x = getPosX() + 1;
        y = getPosY() - 1;
        pos = new Pos(x, y);
        posPiece = Board.board.getPieceByPos(pos);
        while (pos.inBoard() && (posPiece == null || posPiece.getTeam() != getTeam())) {
            posList.add(pos);
            pos = new Pos(++x, --y);
        }

        x = getPosX() - 1;
        y = getPosY() + 1;
        pos = new Pos(x, y);
        posPiece = Board.board.getPieceByPos(pos);
        while (pos.inBoard() && (posPiece == null || posPiece.getTeam() != getTeam())) {
            posList.add(pos);
            pos = new Pos(--x, ++y);
        }

        x = getPosX() + 1;
        y = getPosY() + 1;
        pos = new Pos(x, y);
        posPiece = Board.board.getPieceByPos(pos);
        while (pos.inBoard() && (posPiece == null || posPiece.getTeam() != getTeam())) {
            posList.add(pos);
            pos = new Pos(++x, ++y);
        }

        return posList;
    }


}
