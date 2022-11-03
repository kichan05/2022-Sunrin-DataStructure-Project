import pieces.Piece;
import pieces.Pos;
import pieces.Team;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

        Board board = new Board();

        Player player1 = new Player(Team.BLACK);
        Player player2 = new Player(Team.WHITE);

        Scanner scanner = new Scanner(System.in);

        board.initGameBoard();

        while (gameState) {
            Piece player1SelectPiece;
            while (true) {
                Pos player1InputPos = player1.inputPos("기물을 선택하세요.");
                player1SelectPiece = board.getPieceByPos(player1InputPos);

                if (player1InputPos != null) break;

                System.out.print("해당 위치에 기물이 없습니다.\n다시 ");
            }

            System.out.println(player1SelectPiece);
        }

    }
}
