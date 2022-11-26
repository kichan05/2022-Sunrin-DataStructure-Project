package chess;

import chess.pieces.King;
import chess.pieces.Piece;
import chess.util.Team;

import java.util.ArrayList;

public class ChessState {
    private static boolean gameState = true;
    public static boolean getGameState(){
        return gameState;
    }
    public static void gameEnd(Team winner){
        System.out.println(winner + "팀이 승리하였습니다.");
        gameState = false;
    }


    private static int turnCount = 0;
    public static int getTurn(){
        return turnCount;
    }
    public static void nextTurn(){
        turnCount++;
    }


    private static boolean isRedCheck = false;
    private static boolean isBlueCheck = false;
    public static boolean isCheck(Team team){
        if(team == Team.BLUE) return isBlueCheck;
        else return isRedCheck;
    }
    public static void checkTest(Team team) {
        King king = Board.board.getKing(team);
        ArrayList<Piece> enemyPieceList = Board.board.getTeamPieceList(team == Team.BLUE ? Team.YELLOW : Team.BLUE);

        for (Piece enemy : enemyPieceList) {
            if (enemy.canMove(king.getPos())) {
                king.check();

                if(team == Team.BLUE) isBlueCheck = true;
                else isRedCheck = true;
            }
        }
        if(team == Team.BLUE) isBlueCheck = false;
        else isRedCheck = false;
    }

//    private static final ArrayList<Player>[] players = new ArrayList[2];
//
}
