package chess.player;

import chess.Board;
import chess.ChessState;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.util.Pos;
import chess.util.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class AlphaChess extends Player {
    public AlphaChess(Team team) {
        super(team);
    }

    @Override
    public Piece selectPiece() {
        if(ChessState.isCheck(getTeam())){ //자신의 팀이 체크 상황이라면
            //상대 기물을 잡는 로직
            Piece piece = checkLogicKillEnemy();
            if (piece != null) return piece;

            //킹을 이동 시키는 로직
            King king = checkLogicMoveKing();
            if(king != null) return king;
        }
        /**
         * 본인 팀이 체크상황이라면 어떻게 해야할까 -> 체크하는 상대의 팀 기물을 잡아야함 -> 생각해보니까 킹을 이동 시키는 로직도 있네
         * 둘중에 어떤걸 더 먼저 처리해야할까
         *
         * 상대 기물을 잡는 경우
         * 본인의 기물들을 가져온 다음에 반복을 함
         * 각 기물이 체크를 하는 기물의 위치에 이동 할 수 있는지를 판단함 -> 이걸 위해서 체크하는 기물을 BoardState에 저장함
         * 이동할 수 있으면 그 위치를 반환
         *
         * 킹을 이동 시킨다면
         * 반환하는 값은 킹 객체
         * 조건 : 킹이 이동 가능한 위치가 있다.
         * 
         * 없으면 랜덤으로 이동하게 설정
         * */

        return selectPieceRandomLogic();
    }

    @Nullable
    private Piece checkLogicKillEnemy() {
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
        return null;
    }

    private King checkLogicMoveKing() {
        //킹을 이동 시키는 로직
        King king = Board.board.getKing(getTeam());
        for(Pos pos : king.getCanMovePosList()){
            if(king.checkEnemyMove(pos)) {
                return king;
            }
        }

        return null;
    }

    private Piece selectPieceRandomLogic() {
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

            if (selectPiece.canMove(checkPiece.getPos())) { //체크하는 기물을 잡는 로직
                return checkPiece.getPos();
            }

            if(selectPiece instanceof King){ //킹을 이동 시키는 로직
                King king = (King) selectPiece;
                for(Pos pos : king.getCanMovePosList()){
                    if(king.checkEnemyMove(pos)) {
                        return pos;
                    }
                }
            }
        }

        Pos maxLevelPos = selectMoveMaxLevel(selectPiece);
        if (maxLevelPos != null) return maxLevelPos;

        while (true) { // 랜덤으로 좌표 선택
            Pos randomPos = Pos.getRandomPos();

            if(!selectPiece.canMove(randomPos))
                continue;

            if(Board.board.getPieceByPos(randomPos) instanceof chess.pieces.King)
                continue;

            return randomPos;
        }
    }

    @Nullable
    private static Pos selectMoveMaxLevel(Piece selectPiece) {
        ArrayList<Pos> pieceCanMovePosList = selectPiece.getCanMovePosList();
        int maxLevel = 0;
        Pos maxLevelPos = null;

        for (Pos pos : pieceCanMovePosList){
            Piece targetPiece = Board.board.getPieceByPos(pos);

            if(targetPiece == null && !(targetPiece instanceof King))
                continue;

            if(targetPiece.getLevel() > maxLevel){
                maxLevel = targetPiece.getLevel();
                maxLevelPos = pos;
            }
        }

        if (maxLevelPos != null) {
            return maxLevelPos;
        }
        return null;
    }
}
