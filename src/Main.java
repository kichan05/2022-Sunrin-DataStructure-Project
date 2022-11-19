import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;
import util.ColorCode;
import util.FontColor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

        Player[] players = {new Player(Team.BLUE), new Player(Team.RED)};
        int turnCount = 0;

        Board.board.initGameBoard();

        while (gameState) {
            // 플레이어1 기물 선택
            Player currentPlayer = players[turnCount % 2];
            Piece selectPiece;
            Pos inputPos;
            while (true) {
                inputPos = currentPlayer.inputPos("이동할 기물을 선택하세요.");
                selectPiece = Board.board.getPieceByPos(inputPos);

                System.out.printf("%s입력한 좌표> %d, %d%s\n", FontColor.PURPLE.getFontColor(), inputPos.getX(), inputPos.getY(), FontColor.RESET.getFontColor());
                System.out.printf("%s선택한 기물> %s%s\n", FontColor.PURPLE.getFontColor(), selectPiece, FontColor.RESET.getFontColor());

                if(!inputPos.inBoard()){
                    System.out.println("범위를 벗어난 입력입니다.");
                }
                else if(selectPiece == null){
                    System.out.println("해당 위치에 기물이 없습니다.");
                }
                else if(selectPiece.getTeam() != currentPlayer.getTeam()){
                    System.out.println("상대팀의 기물은 선택 할 수 없습니다.");
                }
                else if (!selectPiece.canMove()){
                    System.out.println("해당 기물은 움직일수있는 위치가 없습니다.");
                }
                else{
                    break;
                }

                System.out.println("기물을 다시 선택하세요.");
            }

            selectPiece.select();
            ArrayList<Pos> canMoveList = selectPiece.getCanMovePosList();
            Board.board.setCanMovePosList(canMoveList);

            Board.board.printBoard();

//            for (Pos i : selectPiece.getCanMovePosList()){
//                System.out.println(i);
//            }

            /* 선택한 기물 이동 */
            while (true) {
                inputPos = currentPlayer.inputPos("기물을 이동할 위치를 선택하세요.");

                if(!inputPos.inBoard()){
                    System.out.println("범위를 벗어난 입력입니다.");
                }
                else if (!selectPiece.canMove(inputPos)){
                    System.out.println("해당 위치로 이동할 수 없습니다.");
                }
                else{
                    break;
                }

                System.out.println("움직일 위치를 다시 선택하세요.");
            }
            System.out.printf("%s입력한 좌표> %d, %d%s\n", FontColor.PURPLE.getFontColor(), inputPos.getX(), inputPos.getY(), FontColor.RESET.getFontColor());

            Piece targetPiece = Board.board.getPieceByPos(inputPos);
            if(targetPiece != null && targetPiece.getTeam() != currentPlayer.getTeam()){
                targetPiece.death();
                System.out.printf("%s죽은 기물> %s%s\n", FontColor.PURPLE.getFontColor(), Board.board.getPieceByPos(inputPos), FontColor.RESET.getFontColor());
            }

            Board.board.clearCanMoveList();
            selectPiece.unSelect();
            selectPiece.setPos(inputPos);
            Board.board.printBoard();

            turnCount++;
            //행마법 테스트 때문에 잠깐 주석처리함
        }
    }
}
