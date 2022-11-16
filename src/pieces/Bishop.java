package pieces;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(int x, int y, Team team) {
        super(x, y, team, '♝');
    }

    @Override
    public List<Pos> getCanMovePosList() {
        return null;
    }


}
