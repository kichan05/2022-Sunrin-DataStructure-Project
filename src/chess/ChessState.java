package chess;

import chess.pieces.King;
import chess.pieces.Piece;
import chess.player.AlphaChess;
import chess.player.Human;
import chess.player.Player;
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

    private static final Player[] players = new Player[2];
    public static Player getCurrentPlayer() {
        return players[turnCount % 2];
    }
    public static Player getNextPlayer() {
        return players[(ChessState.getTurn() + 1) % 2];
    }
    public static void initPlayers(int gameMode){
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
}
