package pieces;

import util.FontColor;

import java.util.List;

public abstract class Piece {
    private Pos pos;
    private final Team team;

    private final char shape;

    private int moveCount;

    Piece(int x, int y, Team team, char shapeWhite){
        this.pos = new Pos(x, y);
        this.team = team;

        this.shape = shapeWhite;

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
        this.moveCount++;
    }

    public void setPos(char x, int y){
        pos.setPos(x, y);
    }

    public Team getTeam(){
        return team;
    }

    public int getMoveCount() { return moveCount; }

    public String getPrintShape() {
        String fontColor = getTeam() == Team.BLUE ? FontColor.BLUE.getFontColor() : FontColor.RED.getFontColor();

        return String.format("%s%c%s", fontColor, shape, FontColor.RESET.getFontColor());
    }

    public char getShape() {
        return shape;
    }

    abstract public boolean canMove(Pos pos);
    abstract public List<Pos> getCanMovePosList();
}
