public class Pos {
    private char x;
    private int y;

    Pos(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(char x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPos(Pos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }
}