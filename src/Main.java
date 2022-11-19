import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;
import player.Human;
import player.Player;
import util.Color;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

        Player[] players = {new Human(Team.BLUE), new Human(Team.RED)};
        int turnCount = 0;

        Board.board.initGameBoard();

        while (gameState) {
            Player currentPlayer = players[turnCount % 2];
            Piece selectedPiece = currentPlayer.selectPiece();
            System.out.printf("%s선택한 기물> %s%s\n", Color.PURPLE.getFontColor(), selectedPiece, Color.RESET.getFontColor());
//            selectPiece.select();
//            ArrayList<Pos> canMoveList = selectPiece.getCanMovePosList();
//            Board.board.setCanMovePosList(canMoveList);
//
//            Board.board.printBoard();

//            for (Pos i : selectPiece.getCanMovePosList()){
//                System.out.println(i);
//            }

            /* 선택한 기물 이동 */
//            while (true) {
//                inputPos = currentPlayer.inputPos("기물을 이동할 위치를 선택하세요.");
//
//                if(!inputPos.inBoard()){
//                    System.out.println("범위를 벗어난 입력입니다.");
//                }
//                else if (!selectPiece.canMove(inputPos)){
//                    System.out.println("해당 위치로 이동할 수 없습니다.");
//                }
//                else{
//                    break;
//                }
//
//                System.out.println("움직일 위치를 다시 선택하세요.");
//            }
//            System.out.printf("%s입력한 좌표> %d, %d%s\n", Color.PURPLE.getColor(), inputPos.getX(), inputPos.getY(), Color.RESET.getColor());

//            Piece targetPiece = Board.board.getPieceByPos(inputPos);
//            if(targetPiece != null && targetPiece.getTeam() != currentPlayer.getTeam()){
//                targetPiece.death();
//                System.out.printf("%s죽은 기물> %s%s\n", Color.PURPLE.getColor(), Board.board.getPieceByPos(inputPos), Color.RESET.getColor());
//            }
//
//            Board.board.clearCanMoveList();
//            selectPiece.unSelect();
//            selectPiece.setPos(inputPos);
//            Board.board.printBoard();

            turnCount++;
            //행마법 테스트 때문에 잠깐 주석처리함
        }
    }
}
