package player;

import pieces.Piece;
import pieces.Pos;
import pieces.Team;
import util.Color;

import java.util.Scanner;

abstract public class Player {
    final Scanner scanner = new Scanner(System.in);
    private Team team;

    public Player(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    /** 플레이어(인간 또는 인공지능)가 기물을 선택 해서  */
    abstract public Piece selectPiece();

    public Pos inputPos(String message) {
        int x, y;
        System.out.printf("%s%s팀) %s : %s",
                Color.getTeamColor(team), team, message, Color.RESET.getFontColor());
        x = scanner.nextInt();
        y = scanner.nextInt();

        return new Pos(x, y);
    }
}
