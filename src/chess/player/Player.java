package chess.player;

import chess.Board;
import chess.ChessUi;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.util.Pos;
import chess.util.Team;
import chess.util.Color;

import java.util.ArrayList;
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

    /** 킹의 특수룰, 상대 기물이 이동 할 수 있는 위치는 이동 목한다.
     * 를 체크하는 함수 */

    public Pos inputPos(String message) {
        int x, y;
        ChessUi.printTeamMessage(getTeam(), message);
        x = scanner.nextInt();
        y = scanner.nextInt();

        return new Pos(x, y);
    }
}
