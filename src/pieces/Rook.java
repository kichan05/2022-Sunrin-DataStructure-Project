package pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(int x, int y, Team team) {
        super(x, y, team, '♜', '♖');
    }

    @Override
    public boolean canMove(Pos pos) {

        return false;
    }

    @Override
    public List<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<Pos>();

        for(int y = 1; y <= 8; y++){
            posList.add(new Pos(getPosX(), y));
        }

        for(int x = 1; x <= 8; x++){
            posList.add(new Pos(x, getPosY()));
        }

        return posList;
    }
}
