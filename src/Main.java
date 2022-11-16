import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

        Player player1 = new Player(Team.BLUE);
        Player player2 = new Player(Team.RED);

        Board.board.initGameBoard();

        while (gameState) {

            // 플레이어1 기물 선택
            Piece player1SelectPiece;
            Pos player1InputPos;
            while (true) {
                player1InputPos = player1.inputPos("이동할 기물을 선택하세요.");
                player1SelectPiece = Board.board.getPieceByPos(player1InputPos);

                if (player1InputPos != null && player1SelectPiece != null && player1SelectPiece.getTeam() == Team.BLUE)
                    break;

                System.out.println("기물을 다시 선택하세요.");
            }

            System.out.println(player1SelectPiece.getPrintShape());

            for(Pos i : player1SelectPiece.getCanMovePosList()){
                System.out.println(i);
            }

            // 플레이어1 기물 이동
            while (true) {
                player1InputPos = player1.inputPos("기물을 이동할 위치를 선택하세요.");

                if (player1SelectPiece.canMove(player1InputPos)) break;

                System.out.println("해당 위치로 이동할 수 없습니다.\n다시 선택하세요.");
            }

            player1SelectPiece.setPos(player1InputPos);
            Board.board.printBoard();


        }
    }


}
