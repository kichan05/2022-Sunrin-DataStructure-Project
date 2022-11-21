package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(int x, int y, Team team) {
        super(x, y, team, '♚', 4);
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList();

        for (int y = Math.max(0, getPosY() - 1); y <= Math.min(7, getPosY() + 1); y++) {
            for (int x = Math.max(0, getPosX() - 1); x <= Math.min(7, getPosX() + 1); x++) {
                Pos tempPos = new Pos(x, y);

                if(Board.board.isPosEmpty(tempPos)) {
                    posList.add(tempPos);
                }
            }
        }

        return posList;
    }


}
