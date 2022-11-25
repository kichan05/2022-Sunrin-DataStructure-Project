package chess.player;

import chess.pieces.Piece;
import chess.util.Pos;
import chess.util.Team;
import chess.util.Color;

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

    /** 플레이어(인간 또는 인공지능)가 기물을 선택 해서 반환합니다.  */
    abstract public Piece selectPiece();

    /** 기물을 움직일 위치를 선택해서 반환합니다.  */
    abstract public Pos selectMovePos(Piece selectPiece);

    public Pos inputPos(String message) {
        int x, y;
        System.out.printf("%s%s팀) %s : %s", team.getTeamColor(), team, message, Color.RESET.getFontColor());
        x = scanner.nextInt();
        y = scanner.nextInt();

        return new Pos(x, y);
    }
}
