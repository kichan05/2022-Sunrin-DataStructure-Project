import java.time.temporal.Temporal;
import java.util.List;

public abstract class Piecs {
    private Pos pos;
    private Team team;

    Piecs(char x, int y, Team team){
        this.pos = new Pos(x, y);
        this.team = team;
    }

    public Pos getPos(){
        return pos;
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
