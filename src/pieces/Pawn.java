package pieces;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(int x, int y, Team team) {
        super(x, y, team, '♟', '♙');
    }

    @Override
    public boolean canMove(char x, int y) {
        return false;
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
