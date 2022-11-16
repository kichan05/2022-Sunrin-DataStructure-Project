import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

        Player[] players = {new Player(Team.BLUE), new Player(Team.RED)};
        int playerIndex = 0;

        Board.board.initGameBoard();

        while (gameState) {
            // 플레이어1 기물 선택
            Player currentPlayer = players[playerIndex % 2];
            Piece selectPiece;
            Pos inputPos;
            while (true) {
                inputPos = currentPlayer.inputPos("이동할 기물을 선택하세요.");
                selectPiece = Board.board.getPieceByPos(inputPos);

                if(inputPos == null){
                    System.out.println("잘못된 입력입니다.");
                }
                else if(selectPiece == null){
                    System.out.println("해당 위치에 기물이 없습니다.");
                }
                else if(selectPiece.getTeam() != currentPlayer.getTeam()){
                    System.out.println("상대팀의 기물은 선택 할 수 없습니다.");
                }
                else{
                    break;
                }

                System.out.println("기물을 다시 선택하세요.");
            }

            System.out.println(selectPiece.getPrintShape());

            // 플레이어1 기물 이동
            while (true) {
                inputPos = currentPlayer.inputPos("기물을 이동할 위치를 선택하세요.");

                if (selectPiece.canMove(inputPos)) break;

                System.out.println("해당 위치로 이동할 수 없습니다.\n다시 선택하세요.");
            }

            selectPiece.setPos(inputPos);
            Board.board.printBoard();

            playerIndex++;
        }
    }


}
