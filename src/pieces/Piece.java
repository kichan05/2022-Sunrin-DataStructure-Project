package pieces;

import util.FontColor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private Pos pos;
    private final Team team;

    private final char shape;

    private int moveCount;

    private boolean isSelected = false;
    private boolean isDeath = false;

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

    public Team getTeam(){
        return team;
    }

    public int getMoveCount() { return moveCount; }

    public boolean isSelected() {
        return isSelected;
    }

    public void select() {
        isSelected = true;
    }

    public void unSelect() {
        isSelected = false;
    }

    public void death() {
        isDeath = true;
    }

    public boolean isDeath() {
        return isDeath;
    }

    public String toBoardString() {
        if(isSelected){
            return String.format("%s%c%s", FontColor.YELLOW.getFontColor(), shape, FontColor.RESET.getFontColor());
        }
        else {
            return toString();
        }
    }

    @Override
    public String toString() {
        String fontColor = getTeam() == Team.BLUE ? FontColor.BLUE.getFontColor() : FontColor.RED.getFontColor();

        return String.format("%s%c%s", fontColor, shape, FontColor.RESET.getFontColor());
    }

    public boolean canMove() {
        return !(getCanMovePosList().isEmpty());
    }

    public boolean canMove(Pos pos) {
        List<Pos> moveList = getCanMovePosList();

        for(Pos i : moveList){
            if(pos.equals(i)){
                return true;
            }
        }

        return false;
    }

    abstract public ArrayList<Pos> getCanMovePosList();
}
