package chess;

import chess.pieces.Piece;
import chess.util.Pos;
import chess.util.Team;
import chess.player.AlphaChess;
import chess.player.Human;
import chess.player.Player;
import chess.util.Color;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRedCheck = false;
        boolean isBlueCheck = false;
        Player player1 = null, player2 = null;

        int selectMenu = showMenu();
        switch (selectMenu) {
            case 1:
                player1 = new Human(Team.BLUE);
                player2 = new Human(Team.RED);
                break;
            case 2:
                player1 = new Human(Team.BLUE);
                player2 = new AlphaChess(Team.RED);
                break;
            case 3:
                player1 = new AlphaChess(Team.BLUE);
                player2 = new AlphaChess(Team.RED);
                break;
            case 4:
                System.out.println("게임을 종료합니다.");
                return;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
        Player[] players = {player1, player2};

        Board.board.initGameBoard();

        int turnCount = 0;
        boolean gameState = true;
        while (gameState) {
            Player currentPlayer = players[turnCount % 2];

            if(isRedCheck){
                System.out.println(Color.RED.getFontColor() + Team.RED + "팀 체크" + Color.RESET.getFontColor());
            }
            if(isBlueCheck){
                System.out.println(Color.BLUE.getFontColor() +  Team.BLUE + "팀 체크" + Color.RESET.getFontColor());
            }

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

            isRedCheck = Board.board.isCheck(Team.RED);
            isBlueCheck = Board.board.isCheck(Team.BLUE);

            turnCount++;
        }
    }

    public static int showMenu() {
        System.out.println("1. 인간 vs 인간");
        System.out.println("2. 인간 vs 인공지능");
        System.out.println("3. 인공지능 vs 인공지능");
        System.out.println("4. 종료");
        System.out.print("메뉴를 선택하세요 : ");

        return scanner.nextInt();
    }

    private static void nextEnter() {
        System.out.printf("%s다음 (ENTER를 눌러주세요)> %s", Color.YELLOW.getFontColor(), Color.RESET.getFontColor());
        scanner.nextLine();
    }
}