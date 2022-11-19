import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;
import player.AlphaChess;
import player.Human;
import player.Player;
import util.Color;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameState = true;

        Player[] players = {new AlphaChess(Team.BLUE), new AlphaChess(Team.RED)};
//        Player[] players = {new Human(Team.BLUE), new Human(Team.RED)};
//        Player[] players = {new Human(Team.BLUE), new AlphaChess(Team.RED)};
        int turnCount = 0;

        Board.board.initGameBoard();

        while (gameState) {
            Player currentPlayer = players[turnCount % 2];

            Piece selectedPiece = currentPlayer.selectPiece();

            selectedPiece.select(); //선택된 기물을 선택처리
            Board.board.setCanMovePosList(selectedPiece.getCanMovePosList());
            // 기물이 움직일 수 있는 위치 저장

            Board.board.printBoard();
            System.out.printf("%s선택한 기물> %s%s\n", Color.PURPLE.getFontColor(), selectedPiece, Color.RESET.getFontColor());

            if(currentPlayer instanceof AlphaChess) {
                nextEnter();
            }

            Pos selectPos = currentPlayer.selectMovePos(selectedPiece); //기물이 움직일 선택한 좌표
            Piece targetPiece = Board.board.getPieceByPos(selectPos); // 해당 위치에 있는 기물 가져오기
            if(targetPiece != null){ //위치에 기물이 있으면 죽이기
                targetPiece.death();
            }
            selectedPiece.unSelect(); // 선택한 기물 선택 해제
            Board.board.clearCanMoveList(); // 기물이 움직일 수 있는 위치 초기화
            selectedPiece.setPos(selectPos); //기물 움직이기

            Board.board.printBoard();
            if(targetPiece != null){
                System.out.printf("%s죽은 기물> %s%s\n", Color.PURPLE.getFontColor(), targetPiece, Color.RESET.getFontColor());
            }

            if(currentPlayer instanceof AlphaChess && players[(turnCount + 1) % 2] instanceof AlphaChess) {
                nextEnter();
            }

            turnCount++;
        }
    }

    private static void nextEnter() {
        System.out.printf("%s다음 (ENTER를 눌러주세요)> %s", Color.YELLOW.getFontColor(), Color.RESET.getFontColor());
        scanner.nextLine();
    }
}
