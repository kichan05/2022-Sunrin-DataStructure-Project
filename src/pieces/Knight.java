package pieces;

import java.util.List;

public class Knight extends Piece {
    public Knight(int x, int y, Team team) {
        super(x, y, team, '♞');
    }

    @Override
    public boolean canMove(Pos pos) {
        return false;
    }

    @Override
    public List<Pos> getCanMovePosList() {
        return null;
    }


}
