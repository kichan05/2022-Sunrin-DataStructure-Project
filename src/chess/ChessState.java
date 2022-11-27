package chess;

import chess.pieces.King;
import chess.pieces.Piece;
import chess.player.AlphaChess;
import chess.player.Human;
import chess.player.Player;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;

public class ChessState {
    private static boolean gameState = true;
    public static boolean getGameState() {
        return gameState;
    }
    public static void gameEnd(Team winner) {
        System.out.println(winner.getTeamColor() + winner + "팀이 승리하였습니다.");
        gameState = false;
    }


    private static int turnCount = 0;
    public static int getTurn() {
        return turnCount;
    }
    public static void nextTurn() {
        turnCount++;
    }


    private static final Player[] players = new Player[2];
    public static Player getCurrentPlayer() {
        return players[turnCount % 2];
    }
    public static Player getNextPlayer() {
        return players[(ChessState.getTurn() + 1) % 2];
    }
    public static void initPlayers(int gameMode) {
        switch (gameMode) {
            case 1:
                players[0] = new Human(Team.BLUE);
                players[1] = new Human(Team.YELLOW);
                break;
            case 2:
                players[0] = new Human(Team.BLUE);
                players[1] = new AlphaChess(Team.YELLOW);
                break;
            case 3:
                players[0] = new AlphaChess(Team.BLUE);
                players[1] = new AlphaChess(Team.YELLOW);
                break;
            default:
                throw new RuntimeException("Game Mode Error");
        }
    }


    private static boolean isYellowCheck = false;
    private static boolean isBlueCheck = false;
    public static boolean isCheck(Team team) {
        if (team == Team.BLUE) return isBlueCheck;
        else return isYellowCheck;
    }
    public static void checkTest(Team team) {
        King king = Board.board.getKing(team);
        ArrayList<Piece> enemyPieceList = Board.board.getTeamPieceList(team == Team.BLUE ? Team.YELLOW : Team.BLUE);

        for (Piece enemy : enemyPieceList) {
            if (enemy.canMove(king.getPos())) {
                if (team == Team.BLUE) isBlueCheck = true;
                else isYellowCheck = true;

                return;
            }
        }
        if (team == Team.BLUE) isBlueCheck = false;
        else isYellowCheck = false;
    }

    private static boolean isRedCheckMate = false;
    private static boolean isBlueCheckMate = false;
    public static boolean isCheckMate(Team team) {
        if (team == Team.BLUE) return isBlueCheckMate;
        else return isRedCheckMate;
    }
    public static void checkMateTest(Team team) {
        King king = Board.board.getKing(team);

        for (Pos pos : king.getCanMovePosList()) {
            if(king.checkEnemyMove(pos)) { // 적의 공격을 안받는 움직 일 수 있는 위치가 있다. -> 체크메이트 아님
                if (team == Team.BLUE) isBlueCheckMate = false;
                else isRedCheckMate = false;
                return;
            }
        }

        // 체크메이트다.
        if (team == Team.BLUE) isBlueCheckMate = true;
        else isRedCheckMate = true;
    }
    /**
     * 문제점 : 킹이 공격받지 않고 보호를 받아도 움직일 수 있는 곳은 없다.
     * -> 체크메이트 함수 구조의 문제
     *
     * 기존의 체크메이트 함수 로직
     * - 킹의 canMoveList를 가져온다.
     * - 가져온 리스트가 비어있는지를 본다.
     *
     * 킹의 canMoveList 가져오는법
     * - 자신 기준의 9칸에 갈 수 있는지 비교한다.
     * - 적 기물들을 가져오고, 적 기물들이 갈수있는 위치에서 자신을 뺀다.
     * 	-> 왜냐면 킹은 상대 기물이 갈 수 있는 위치는 못간다.
     *
     *
     * 어떻게 하면 좋을까
     * - 행마법용 canMoveList와 체크메이트의 canMoveList를 분리시킨다.
     * - 이동 불가 판정을 킹을 사용자 단에서 체크한다.
     *
     * - 결과
     * 	- canMoveList에서 이동 불가 체크  삭제
     * 	- 사용자 입력받을때, 이동 불가를 체크
     * 		-> 플레이어와 인공지능을 어떻게 통합하지
     * 			- Player클래스에서 함수 구현,
     * 			- checkKingMove함수 정의
     * 				- 적 기물 리스트를 불러온다.
     * 				- 움직이려는 위치중에 적 기물의 canMoveList에 포함되었는지 확인한다.
     * 	- 체크메이트는 어떻게 하는게 좋을까
     *      - 킹이 움직일 수 있는 곳이 없다면 체크메이트
     *      - 킹의 canMoveList를 가져온다.
     *      - 반복하면서 움직일 수 있는 위치가 적이 움직일수 있는지 판단.
     *      - player에 checkKingMove 함수와 같은 로직
     *      - 그냥 킹 행마법 특수규칙 체크를 킹에 넣자
     *      - palyer checkKingMove 함수를 king으로 이동
     *      - 사용자 입력과 체크메이트에서 둘 다 사용
     * */
}
