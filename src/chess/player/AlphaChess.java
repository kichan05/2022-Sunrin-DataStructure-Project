package chess.player;

import chess.Board;
import chess.ChessState;
import chess.ChessUi;
import chess.pieces.Piece;
import chess.util.Pos;
import chess.util.Team;

import java.lang.reflect.Array;
import java.time.temporal.Temporal;
import java.util.ArrayList;

public class AlphaChess extends Player {
    public AlphaChess(Team team) {
        super(team);
    }

    @Override
    public Piece selectPiece() {
        if(ChessState.isCheck(getTeam())){ //자신의 팀이 체크 상황이라면
            ArrayList<Piece> piecesList = Board.board.getTeamPieceList(getTeam());
            Piece checkPiece;

            if(getTeam() == Team.BLUE){
                checkPiece = ChessState.getCheckPiece(Team.BLUE);
            }
            else{
                checkPiece = ChessState.getCheckPiece(Team.YELLOW);
            }

            for(Piece piece : piecesList) {
                if(piece.canMove(checkPiece.getPos())) {
                    return piece;
                }
            }
        }
        /**
         * 본인 팀이 체크상황이라면 어떻게 해야할까 -> 체크하는 상대의 팀 기물을 잡아야함
         * 본인의 기물들을 가져온 다음에 반복을 함
         * 각 기물이 체크를 하는 기물의 위치에 이동 할 수 있는지를 판단함 -> 이걸 위해서 체크하는 기물을 BoardState에 저장함
         * 이동할 수 있으면 그 위치를 반환
         * 
         * 없으면 랜덤으로 이동하게 설정
         * */

        while (true) { // 랜덤으로 좌표 선택
            Pos randomPos = Pos.getRandomPos();
            Piece randomSelectPiece = Board.board.getPieceByPos(randomPos);

            // 해당 좌표의 기물이 선택히 가능하면 반환
            if (randomSelectPiece != null
                && randomSelectPiece.getTeam() == getTeam()
                && randomSelectPiece.canMove()
            ) {
                return randomSelectPiece;
            }
        }
    }

    @Override
    public Pos selectMovePos(Piece selectPiece) {
        if(ChessState.isCheck(getTeam())){ //자신의 팀이 체크 상황이라면
            Piece checkPiece;

            if(getTeam() == Team.BLUE){
                checkPiece = ChessState.getCheckPiece(Team.BLUE);
            }
            else{
                checkPiece = ChessState.getCheckPiece(Team.YELLOW);
            }

            return checkPiece.getPos();
        }

        while (true) { // 랜덤으로 좌표 선택
            Pos randomPos = Pos.getRandomPos();

            // 해당 좌표로 이동이 가능하면 반환
            if (selectPiece.canMove(randomPos)
                    && !(Board.board.getPieceByPos(randomPos) instanceof chess.pieces.King)) {
                return randomPos;
            }
        }
    }
}
