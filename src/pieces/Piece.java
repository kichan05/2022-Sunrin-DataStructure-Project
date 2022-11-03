package pieces;

import java.util.List;

public abstract class Piece {
    private Pos pos;
    private final Team team;

    private final char shapeWhite;
    private final char shapeBlack;

    private int moveCount;

    Piece(int x, int y, Team team, char shapeWhite, char shapeBlack){
        this.pos = new Pos(x, y);
        this.team = team;

        this.shapeWhite = shapeWhite;
        this.shapeBlack = shapeBlack;

        this.moveCount = 0;
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

    public int getMoveCount() { return moveCount; }

    public char getShape() {
        if(team == Team.BLACK)
            return shapeBlack;
        else
            return shapeWhite;
    }

    abstract public boolean canMove(char x, int y);
    abstract public boolean canMove(Pos pos);
    abstract public List<Pos> getCanMovePosList();
}
