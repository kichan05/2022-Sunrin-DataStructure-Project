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
        if(pos!=null && pos.getX() < 8 && pos.getX() > 0 && pos.getY() < 8 && pos.getY() > 0) {
            if(getTeam() == Team.WHITE){
                if(getPosY()==pos.getY() + 1) return true;
                else return getPosY() == pos.getY() + 2 && getMoveCount() == 0;
            }
            else { // Team black
                if(getPosY()==pos.getY() - 1) return true;
                else return getPosY() == pos.getY() - 2 && getMoveCount() == 0;
            }

        }
        return false;
    }

    @Override
    public List<Pos> getCanMovePosList() {
        return null;
    }


}
