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

        x = getPosX() - 1;
        y = getPosY() - 1;
        while (0 <= x && 0 <= y && Board.board.isPosEmpty(new Pos(x, y))){
            posList.add(new Pos(x--, y--));
        }

        x = getPosX() + 1;
        y = getPosY() - 1;
        while (x < 8 && 0 <= y && Board.board.isPosEmpty(new Pos(x, y))){
            posList.add(new Pos(x++, y--));
        }

        x = getPosX() - 1;
        y = getPosY() + 1;
        while (0 <= x && y < 8 && Board.board.isPosEmpty(new Pos(x, y))){
            posList.add(new Pos(x--, y++));
        }

        x = getPosX() + 1;
        y = getPosY() + 1;
        while (x < 8 && y < 8 && Board.board.isPosEmpty(new Pos(x, y))){
            posList.add(new Pos(x++, y++));
        }

        return posList;
    }


}
