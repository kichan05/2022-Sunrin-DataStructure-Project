package chess.util;

public enum Team {
    YELLOW, BLUE;

    public String getTeamColor() {
        if (this == Team.BLUE) {
            return Color.BLUE.getFontColor();
        } else {
            return Color.YELLOW.getFontColor();
        }
    }
}
