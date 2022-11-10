import pieces.Piece;
import pieces.Pos;
import pieces.Team;
import java.util.Scanner;

public class Main {
    static Board board = new Board();

    public static void main(String[] args) {
        boolean gameState = true;


        Player player1 = new Player(Team.BLACK);
        Player player2 = new Player(Team.WHITE);

        Scanner scanner = new Scanner(System.in);

        board.initGameBoard();

        while (gameState) {

            // 플레이어1 기물 선택
            Piece player1SelectPiece;
            Pos player1InputPos;
            while (true) {
                player1InputPos = player1.inputPos("이동할 기물을 선택하세요.");
                player1SelectPiece = board.getPieceByPos(player1InputPos);

                if (player1InputPos != null && player1SelectPiece != null && player1SelectPiece.getTeam() == Team.BLACK)
                    break;

                System.out.println("기물을 다시 선택하세요.");
            }

            System.out.println(player1SelectPiece);

            // 플레이어1 기물 이동
            while (true) {
                player1InputPos = player1.inputPos("기물을 이동할 위치를 선택하세요.");

                if (player1SelectPiece.canMove(player1InputPos)) break;

                System.out.println("해당 위치로 이동할 수 없습니다.\n다시 선택하세요.");
            }

            player1SelectPiece.setPos(player1InputPos);
            board.printBoard();


        }

    }

}
