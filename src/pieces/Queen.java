package pieces;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(int x, int y, Team team) {
        super(x, y, team, '♛');
    }

    @Override
    public boolean canMove(Pos pos) {
        return false;
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<>();

        return posList;
    }


}
