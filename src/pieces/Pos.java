package pieces;

import java.text.Format;

public class Pos {
    private int x;
    private int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPos(Pos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public boolean inBoard() {
        return 0 <= x && x < 8 && 0 <= y && y < 8;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pos)) {
            throw new RuntimeException("Type");
        }
        Pos pos = (Pos) obj;

        return getX() == pos.getX() && getY() == pos.getY();
    }

    @Override
    public String toString() {
        return String.format("Pos(x = %d, y = %d)", getX(), getY());
    }
}