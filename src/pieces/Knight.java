package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(int x, int y, Team team) {
        super(x, y, team, '♞', 2);
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList();

        Pos pos;

        pos = new Pos(getPosX() - 1, getPosY() - 2);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        pos = new Pos(getPosX() - 1, getPosY() + 2);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        pos = new Pos(getPosX() - 2, getPosY() - 1);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        pos = new Pos(getPosX() - 2, getPosY() + 1);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        pos = new Pos(getPosX() + 1, getPosY() - 2);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        pos = new Pos(getPosX() + 1, getPosY() + 2);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        pos = new Pos(getPosX() + 2, getPosY() - 1);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        pos = new Pos(getPosX() + 2, getPosY() + 1);
        if(pos.inBoard() && (Board.board.getPieceByPos(pos) == null || Board.board.getPieceByPos(pos).getTeam() != getTeam()))
            posList.add(pos);

        return posList;
    }
}
