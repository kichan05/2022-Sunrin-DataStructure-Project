package chess;

import chess.pieces.Piece;
import chess.util.Pos;
import chess.util.Team;
import chess.player.AlphaChess;
import chess.player.Player;

public class Main {

    public static void main(String[] args) {
        showMenu();

        Board.board.initGameBoard();
        ChessUi.showBoard();

        while (ChessState.getGameState()) {
            Player currentPlayer = ChessState.getCurrentPlayer();

            Piece selectedPiece = currentPlayer.selectPiece();

            selectedPiece.select(); //선택된 기물을 선택처리
            Board.board.setCanMovePosList(selectedPiece.getCanMovePosList());
            // 기물이 움직일 수 있는 위치 저장

            ChessUi.showBoard();
            ChessUi.printPieceMessage("선택한 기물", selectedPiece);

            if(currentPlayer instanceof AlphaChess) {
                ChessUi.nextEnter();
            }

            Pos selectPos = currentPlayer.selectMovePos(selectedPiece); //기물이 움직일 선택한 좌표
            Piece targetPiece = Board.board.getPieceByPos(selectPos); // 해당 위치에 있는 기물 가져오기
            if(targetPiece != null){ //위치에 기물이 있으면 죽이기
                targetPiece.death();
            }

            selectedPiece.unSelect(); // 선택한 기물 선택 해제
            Board.board.clearCanMoveList(); // 기물이 움직일 수 있는 위치 초기화
            selectedPiece.setPos(selectPos); //기물 움직이기

            ChessUi.showBoard();

            if(targetPiece != null){
                ChessUi.printPieceMessage("죽은 기물", targetPiece);
            }
            if(currentPlayer instanceof AlphaChess && ChessState.getNextPlayer() instanceof AlphaChess) {
                ChessUi.nextEnter();
            }

            ChessState.checkTest(Team.BLUE);
            ChessState.checkTest(Team.YELLOW);

            ChessState.nextTurn();
        }
    }

    private static void showMenu() {
        while(true){
            int selectMenu = ChessUi.showMenu();
            if(1 <= selectMenu && selectMenu <=3){
                ChessState.initPlayers(selectMenu);
                return;
            }
            else if(selectMenu == 4){
                System.out.println("잘가요.");
                System.exit(0);
            }

            ChessUi.printErrorMessage("잘못된 입력입니다");
            ChessUi.printErrorMessage("다시 입력해주세요.\n\n");
        }
    }
}
