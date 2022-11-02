import java.util.List;

public abstract class Piece {
    private Pos pos;
    private Team team;
    private boolean isLive;

    Piece(int x, int y, Team team){
        this.pos = new Pos(x, y);
        this.team = team;
        this.isLive = true;
    }

    public Pos getPos(){
        return pos;
    }

    public int getPosX() {
        return pos.getX();
    }

    public int getPosY() {
        return pos.getY();
    }

    public void setPos(Pos pos){
        this.pos = pos;
    }

    public void setPos(char x, int y){
        pos.setPos(x, y);
    }

    public Team getTeam(){
        return team;
    }

    abstract public boolean canMove(char x, int y);
    abstract public boolean canMove(Pos pos);
    abstract public List<Pos> getCanMovePosList();
}
