package pieces;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(int x, int y, Team team) {
        super(x, y, team, '♜');
    }

    @Override
    public boolean canMove(Pos pos) {
        List<Pos> moveList = getCanMovePosList();

        for(Pos i : moveList){
            if(pos.equals(i)){
                return true;
            }
        }

        return false;
    }

    /** 룩의 위치를 기준으로, 동서남북으로 위치를 보면서 탐색 */
    @Override
    public List<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<Pos>();

        for(int y = getPosY() + 1; y < 8; y++) {
            Pos p = new Pos(getPosX(), y);

            if(!Board.board.isCanMove(p))
                break;

            posList.add(p);
        }

        for(int y = getPosY() - 1; 0 <= y ; y--) {
            Pos p = new Pos(getPosX(), y);

            if(!Board.board.isCanMove(p))
                break;

            posList.add(p);
        }

        for(int x = getPosY() + 1; x < 8; x++) {
            Pos p = new Pos(x, getPosY());

            if(!Board.board.isCanMove(p))
                break;

            posList.add(p);
        }

        for(int x = getPosY() - 1; 0 <= x; x--) {
            Pos p = new Pos(x, getPosY());

            if(!Board.board.isCanMove(p))
                break;

            posList.add(p);
        }

        return posList;
    }
}
