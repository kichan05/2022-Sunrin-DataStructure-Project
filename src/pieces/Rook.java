package pieces;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(int x, int y, Team team) {
        super(x, y, team, '♜', '♖');
    }

    @Override
    public boolean canMove(Pos pos) {
        List<Pos> moveList = getCanMovePosList();
        for(Pos i : moveList){
            if(this.getPos().equals(i)){
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<Pos>();

        for(int y = 0; y < 8; y++){
            posList.add(new Pos(getPosX(), y));
        }

        for(int x = 0; x < 8; x++){
            posList.add(new Pos(x, getPosY()));
        }

        return posList;
    }
}
