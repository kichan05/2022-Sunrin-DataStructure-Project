package chess.util;

public enum Team {
    RED, BLUE;

    public String getTeamColor() {
        if (this == Team.BLUE) {
            return Color.BLUE.getFontColor();
        } else {
            return Color.RED.getFontColor();
        }
    }
}
