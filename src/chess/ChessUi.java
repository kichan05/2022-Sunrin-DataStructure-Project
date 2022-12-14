package chess;

import chess.pieces.Piece;
import chess.util.Color;
import chess.util.Pos;
import chess.util.Team;

import java.util.Scanner;

public class ChessUi {
    private static final Scanner scanner = new Scanner(System.in);

    public static void clearBuffer() {
        scanner.nextLine();
    }

    public static void printErrorMessage(String message) {
        System.out.printf("%s▶ %s%s\n", Color.RED.getFontColor(), message, Color.RESET.getFontColor());
    }

    public static void printTeamMessage(Team team, String message) {
        System.out.printf("%s▶ %s팀) %s%s", team.getTeamColor(), team, message, Color.RESET.getFontColor());
    }

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
        System.out.print("\n\n");
        for(int i = 0; i < 50; i++)
            System.out.print("─");
        System.out.println();

        printPieceCount();
        printCheck();
        printBoard();
    }

    private static void printBoard() {
        String[][] playground = new String[8][8];

        // 출력되는 문자열 배열 초기화
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                playground[j][i] = "ㅤ";
            }
        }

        // 선택한 말 움직일수 있는 위치 표시
        for (Pos pos : Board.board.getCanMovePosList()) {
            playground[pos.getX()][pos.getY()] = Color.PURPLE.getFontColor() + "★" + Color.RESET.getFontColor() ;
        }

        // 기물들 표시
        for (Piece piece : Board.board.getPieces()) {
            if(piece.isDeath()) //이미 죽은 말이면 표시 안함
                continue;

            int pieceX = piece.getPosX();
            int pieceY = piece.getPosY();

            playground[pieceX][pieceY] = piece.toBoardString();
        }

        System.out.println();

        // 출력판 표시
        System.out.println("     0ㅤㅤ1ㅤㅤ2ㅤㅤ3ㅤㅤ4ㅤㅤ5ㅤㅤ6ㅤㅤ7");
        System.out.println("  ───────────────────────────────────────");
        for (int i = 0; i < 8; i++) {
            System.out.print(i+" │ ");
            for (int j = 0; j < 8; j++) {
                System.out.print(playground[j][i]+" │ ");
            }
            System.out.println("\n  ───────────────────────────────────────");
        }
//        System.out.println("     0ㅤㅤ1ㅤㅤ2ㅤㅤ3ㅤㅤ4ㅤㅤ5ㅤㅤ6ㅤㅤ7");
    }

    private static void printPieceCount() {
        String message = String.format("%s남은 말 %s%02d개 %s%02d개%s",
                Color.PURPLE.getFontColor(),
                Team.YELLOW.getTeamColor(), Board.board.getTeamPieceList(Team.YELLOW).size(),
                Team.BLUE.getTeamColor(), Board.board.getTeamPieceList(Team.BLUE).size(),
                Color.RESET.getFontColor()
        );

        System.out.printf("%61s\n", message);
    }

    private static void printCheck() {
        if(!ChessState.isCheck(Team.YELLOW) && !ChessState.isCheck(Team.BLUE)){
            String message = Color.WHITE.getFontColor() + "체크 없음" + Color.RESET.getFontColor();

            System.out.printf("%52s\n", message);
        }

        Team temp = Team.YELLOW;
        if(ChessState.isCheck(temp)){
            String message = temp.getTeamColor() + temp + "팀 체크" + Color.RESET.getFontColor();
            System.out.printf("%52s\n", message);
        }

        temp = Team.BLUE;
        if(ChessState.isCheck(temp)){
            String message = temp.getTeamColor() + temp + "팀 체크" + Color.RESET.getFontColor();
            System.out.printf("%52s\n", message);
        }
    }

    public static void printPieceMessage(String message, Piece piece) {
        System.out.println(
                Color.PURPLE.getFontColor() +
                message + "> " + piece + Color.RESET.getFontColor()
        );
    }
}
