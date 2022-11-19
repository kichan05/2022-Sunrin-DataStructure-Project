package pieces;

import util.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private Pos pos;
    private final Team team;

    private final char shape;

    private int moveCount;

    private boolean isSelected = false;
    private boolean isDeath = false;
    private boolean isCheck = false;

    Piece(int x, int y, Team team, char shapeWhite) {
        this.pos = new Pos(x, y);
        this.team = team;

        this.shape = shapeWhite;

        this.moveCount = 0;
    }

    public Pos getPos() {
        return pos;
    }

    public int getPosX() {
        return pos.getX();
    }

    public int getPosY() {
        return pos.getY();
    }

    public void setPos(Pos pos) {
        this.pos = pos;
        this.moveCount++;
    }

    public Team getTeam() {
        return team;
    }

    public int getMoveCount() {
        return moveCount;
    }

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

    public void check() {
        isCheck = true;
    }

    public void unCheck() {
        isCheck = false;
    }

    public boolean isCheck() {
        return isCheck;
    }


    public boolean isDeath() {
        return isDeath;
    }

    /**
     * 화면에 출력하는 용도의 문자열 변환
     */
    public String toBoardString() {
        if (isCheck) {
            return String.format("%s%c%s", Color.YELLOW.getFontColor(), shape, Color.RESET.getFontColor());
        }

        if (isSelected) { // 선택 됐으면 노란색으로
            return String.format("%s%c%s", Color.YELLOW.getFontColor(), shape, Color.RESET.getFontColor());
        }

        return toString(); //선택 안됐으면 기본 기물 색상으로
    }

    /**
     * 팀 색상을 적용한 문자열 반환
     */
    @Override
    public String toString() {
        String fontColor = getTeam() == Team.BLUE ? Color.BLUE.getFontColor() : Color.RED.getFontColor();

        return String.format("%s%c%s", fontColor, shape, Color.RESET.getFontColor());
    }

    /**
     * 해당 기물이 움직일 수 있는 위치가 있는지
     */
    public boolean canMove() {
        return !(getCanMovePosList().isEmpty());
    }

    /**
     * 기물이 해당 위치로 이동 할 수 있는지
     */
    public boolean canMove(Pos pos) {
        List<Pos> moveList = getCanMovePosList();

        for (Pos i : moveList) {
            if (pos.equals(i)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 기물이 움직일 수 있는 위치 리스트 반환
     */
    abstract public ArrayList<Pos> getCanMovePosList();
}
