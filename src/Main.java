import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;
import player.AlphaChess;
import player.Player;
import util.Color;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameState = true;

        Player[] players = {new AlphaChess(Team.BLUE), new AlphaChess(Team.RED)};
//        Player[] players = {new Human(Team.BLUE), new Human(Team.RED)};
        int turnCount = 0;

        Board.board.initGameBoard();

        while (gameState) {
            Player currentPlayer = players[turnCount % 2];
            Piece selectedPiece = currentPlayer.selectPiece();

            selectedPiece.select(); //선택된 기물을 선택처리
            Board.board.setCanMovePosList(selectedPiece.getCanMovePosList());
            Board.board.printBoard();
            System.out.printf("%s선택한 기물> %s%s\n", Color.PURPLE.getFontColor(), selectedPiece, Color.RESET.getFontColor());
            nextEnter();

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
            nextEnter();

            turnCount++;
            //행마법 테스트 때문에 잠깐 주석처리함
        }
    }

    private static void nextEnter() {
        System.out.printf("%s다음 (ENTER를 눌러주세요)> %s", Color.YELLOW.getFontColor(), Color.RESET.getFontColor());
        scanner.nextLine();
    }
}
