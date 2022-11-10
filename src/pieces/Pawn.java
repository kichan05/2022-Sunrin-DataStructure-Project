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
        if(pos!=null && pos.getX() <= 7 && pos.getX() >= 0 && pos.getY() <= 7 && pos.getY() >= 0) {
            if(getTeam() == Team.BLACK){
                if(getPosY()==pos.getY() + 1 && getPosX()==pos.getX()) return true;
                else return getPosY() == pos.getY() + 2 && getMoveCount() == 0 && getPosX()==pos.getX();
            }
            else {
                if(getPosY()==pos.getY() - 1 && getPosX()==pos.getX()) return true;
                else return getPosY() == pos.getY() - 2 && getMoveCount() == 0 && getPosX()==pos.getX();
            }

        }
        return false;
    }

    @Override
    public List<Pos> getCanMovePosList() {
        return null;
    }


}
