import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;
import player.Ai;
import player.Human;
import player.Player;
import util.Color;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

//        Player[] players = {new Ai(Team.BLUE), new Ai(Team.RED)};
        Player[] players = {new Human(Team.BLUE), new Human(Team.RED)};
        int turnCount = 0;

        Board.board.initGameBoard();

        while (gameState) {
            Player currentPlayer = players[turnCount % 2];
            Piece selectedPiece = currentPlayer.selectPiece();

            selectedPiece.select(); //선택된 기물을 선택처리
            Board.board.setCanMovePosList(selectedPiece.getCanMovePosList());
            Board.board.printBoard();
            System.out.printf("%s선택한 기물> %s%s\n", Color.PURPLE.getFontColor(), selectedPiece, Color.RESET.getFontColor());

            Pos selectPos = currentPlayer.selectMovePos(selectedPiece);
            Piece targetPiece = Board.board.getPieceByPos(selectPos);
            if(targetPiece != null && targetPiece.getTeam() != currentPlayer.getTeam()){
                targetPiece.death();
                System.out.printf("%s죽은 기물> %s%s\n", Color.PURPLE.getFontColor(), targetPiece, Color.RESET.getFontColor());
            }

            Board.board.clearCanMoveList();
            selectedPiece.unSelect();
            selectedPiece.setPos(selectPos);
            Board.board.printBoard();

            turnCount++;
            //행마법 테스트 때문에 잠깐 주석처리함
        }
    }
}
