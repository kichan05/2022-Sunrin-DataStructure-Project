package chess.pieces;

import chess.util.Color;
import chess.util.PieceType;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private Pos pos;
    private final Team team;
    private final char shape;
    private int moveCount = 0;
    private boolean isSelected = false;
    private boolean isDeath = false;
    private boolean isCheck = false;
    private int level;
    //기물의 레벨 : 폰 = 1, 나이트, 비숍, 룩 = 2, 퀸 = 3, 킹 = 4
    private PieceType pieceType;

    Piece(int x, int y, Team team, char shapeWhite, int level, PieceType pieceType) {
        this.pos = new Pos(x, y);
        this.team = team;

        this.shape = shapeWhite;
        this.level = level;
        this.pieceType = pieceType;
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

    public int getLevel(){
        return level;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * 화면에 출력하는 용도의 문자열 변환
     */
    public String toBoardString() {
        if (isCheck) { // 자신이 죽을수도 있으면 빨간색으로 표시
            return String.format("%s%c%s", Color.RED.getFontColor(), shape, Color.RESET.getFontColor());
        }

        if (isSelected) { // 선택 됐으면 보라색으로
            return String.format("%s%c%s", Color.PURPLE.getFontColor(), shape, Color.RESET.getFontColor());
        }

        return toString(); //선택 안됐으면 기본 기물 색상으로
    }

    /**
     * 팀 색상을 적용한 문자열 반환
     */
    @Override
    public String toString() {
        String fontColor = getTeam().getTeamColor();

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

    @Override
    public boolean equals(Object obj) {
        return team.equals(((Piece) obj).getTeam()) && shape == ((Piece) obj).shape;
    }

    /**
     * 기물이 움직일 수 있는 위치 리스트 반환
     */
    abstract public ArrayList<Pos> getCanMovePosList();
}
