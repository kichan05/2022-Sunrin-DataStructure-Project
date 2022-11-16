package pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(int x, int y, Team team) {
        super(x, y, team, '♙');
    }

    @Override
    public List<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<Pos>();

        Pos tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? - 1 : 1));
        if(Board.board.isPosEmpty(tempPos)){
            posList.add(tempPos);

            tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? - 2 : 2));
            if(tempPos.inBoard() && getMoveCount() == 0 && Board.board.isPosEmpty(tempPos)){
                posList.add(tempPos);
            }
        }


        return posList;
    }
}