package chess;

import chess.pieces.Piece;
import chess.util.Color;
import chess.util.Team;

import java.util.Scanner;

public class ChessUi {
    private static final Scanner scanner = new Scanner(System.in);

    public static int showMenu() {
        System.out.println("1. 인간 vs 인간");
        System.out.println("2. 인간 vs 인공지능");
        System.out.println("3. 인공지능 vs 인공지능");
        System.out.println("4. 종료");
        System.out.print("메뉴를 선택하세요 : ");

        return scanner.nextInt();
    }

    public static void nextEnter() {
        System.out.printf("%s다음 (ENTER를 눌러주세요)> %s", Color.YELLOW.getFontColor(), Color.RESET.getFontColor());
        scanner.nextLine();
    }

    public static void showBoard() {
        if (Board.board.isCheck(Team.RED)) {
            System.out.println(Color.RED.getFontColor() + Team.RED + "팀 체크" + Color.RESET.getFontColor());
        }
        if (Board.board.isCheck(Team.BLUE)) {
            System.out.println(Color.BLUE.getFontColor() + Team.BLUE + "팀 체크" + Color.RESET.getFontColor());
        }

        Board.board.printBoard();
    }

    public static void printPiece(String message, Piece piece) {
        System.out.println(
                Color.PURPLE.getFontColor() +
                message + "> " + piece + Color.RESET.getFontColor()
        );
    }

}
