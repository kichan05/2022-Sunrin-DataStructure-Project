package chess.pieces;

import chess.Board;
import chess.ChessUi;
import chess.util.PieceType;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;
import java.util.stream.StreamSupport;

public class King extends Piece {
    public King(int x, int y, Team team) {
        super(x, y, team, '♚', 4, PieceType.KING);
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<>();

        for (int y = Math.max(0, getPosY() - 1); y <= Math.min(7, getPosY() + 1); y++) {
            for (int x = Math.max(0, getPosX() - 1); x <= Math.min(7, getPosX() + 1); x++) {
                Pos tempPos = new Pos(x, y);
                Piece targetPiece = Board.board.getPieceByPos(tempPos);
                if(targetPiece == null || (targetPiece.getTeam() != getTeam())){
                    posList.add(tempPos);
                }
            }
        }


        /*
        캐슬링 조건
        1. 킹과 캐슬링하는 측의 룩이 같이 초기배치에서 움직이면 안 된다. (moveCount 체크)
        2. 킹과 캐슬링하는 측의 룩 사이에 다른 기물이 있어서는 안 된다. (사이 targetPos 체크)
        3. 현재 킹이 체크되어 있으면 안 된다. (!isCheck)
        4. 현재 킹이 통과 하는 칸에 적의 기물이 공격/이동이 가능해서는 안 된다.
         */
        // 킹사이드 캐슬링 (숏 캐슬링)
        if(!isCheck()){ // (4)

            Pos tempPos = new Pos(7, (getTeam() != Team.BLUE) ? 0 : 7);
            Piece targetPiece = Board.board.getPieceByPos(tempPos);
            if(targetPiece != null){ // 룩 위치 Piece null 체크
                if(getMoveCount()==0 && targetPiece.getPieceType() == PieceType.ROOK && targetPiece.getMoveCount() == 0){ // (1)
                    if(Board.board.getPieceByPos(new Pos(5,getPosY())) == null && Board.board.getPieceByPos(new Pos(6, getPosY())) == null){ // (2)
                        posList.add(new Pos(6, getPosY()));
                    }
                }
            }

            // 퀸사이드 캐슬링 (롱 캐슬링)
            tempPos = new Pos(0, (getTeam() != Team.BLUE) ? 0 : 7);
            targetPiece = Board.board.getPieceByPos(tempPos);
            if(targetPiece != null) { // 룩 위치 Piece null 체크
                if (getMoveCount() == 0 && targetPiece.getPieceType() == PieceType.ROOK && targetPiece.getMoveCount() == 0) { // (1)
                    if (Board.board.getPieceByPos(new Pos(1, getPosY())) == null && Board.board.getPieceByPos(new Pos(2, getPosY())) == null && Board.board.getPieceByPos(new Pos(3, getPosY())) == null) { // (2)
                        posList.add(new Pos(1, getPosY()));
                    }
                }
            }
        }

        return posList;
    }

    @Override
    public void setPos(Pos pos) {
        super.setPos(pos);

        // 캐슬링
        if(pos.getY() == ((getTeam()!=Team.BLUE) ? 0 : 7)){
            Piece targetPiece = Board.board.getPieceByPos(new Pos(0, (getTeam() != Team.BLUE) ? 0 : 7));
            if(pos.getX() == 1 && targetPiece != null){
                targetPiece.setPos(new Pos(2,(getTeam()!=Team.BLUE) ? 0 : 7));
            }

            targetPiece = Board.board.getPieceByPos(new Pos(7, (getTeam() != Team.BLUE) ? 0 : 7));
            if(pos.getX() == 6 && targetPiece != null){
                targetPiece.setPos(new Pos(5,(getTeam()!=Team.BLUE) ? 0 : 7));
            }
        }

    }

    // 적의 공격을 안 받는 움직일 수 있는 위치 존재 체크
    public boolean checkEnemyMove(Pos targetPos) {
        ArrayList<Piece> enemyPieceList = Board.board.getTeamPieceList(getTeam() == Team.BLUE ? Team.YELLOW : Team.BLUE);

        for (Piece i : enemyPieceList) {

            if (i.getCanMovePosList().contains(targetPos)) {
                if(!(i.getPieceType() == PieceType.PAWN && i.getPosX() == getPosX() )
                        && !(i.getPosY() + ((getTeam() != Team.BLUE) ? -2 : 2) == getPosY())
                        && !(i.getMoveCount() == 0 && i.getPosY() + ((getTeam() != Team.BLUE) ? -3 : 3) == getPosY())){ // 폰 전진 예외

//                    System.out.println("checkEnemyMove : " + i.getTeam() + " | " + i.getPieceType() + " | " + i.getCanMovePosList());
                    return false;
                }

            }
        }

        return true;
    }

    // 적 기물을 잡을 수 있는 기물 존재 체크
    public boolean checkEnemyMoveProtect(Pos targetPos) {
        ArrayList<Piece> enemyPieceList = Board.board.getTeamPieceList(getTeam() == Team.BLUE ? Team.YELLOW : Team.BLUE);
        ArrayList<Piece> allyPieceList = Board.board.getTeamPieceList(getTeam() == Team.BLUE ? Team.BLUE : Team.YELLOW);

        for (Piece i : enemyPieceList) {
            if (i.getCanMovePosList().contains(targetPos)) {
                for(Piece j : allyPieceList){

                    if (j.getCanMovePosList().contains(i.getPos())){
//                        System.out.println("checkEnemyMoveProtect : " + j.getTeam() + " | " + j.getPieceType() + " | " + j.getCanMovePosList());
                        return true;

                    }
                }
            }
        }

        return false;
    }

    // 적 공격을 막을 수 있는 기물 존재 체크
    public boolean checkAllyMove(Pos targetPos) {
        ArrayList<Piece> allyPieceList = Board.board.getTeamPieceList(getTeam() == Team.BLUE ? Team.BLUE : Team.YELLOW);

        for (Piece i : allyPieceList) {
            if (i.getPieceType()!=PieceType.KING && i.getCanMovePosList().contains(targetPos)) {
//                System.out.println("checkAllyMove : " + i.getTeam() + " | " + i.getPieceType() + " | " + i.getCanMovePosList());
                return true;
            }
        }

        return false;
    }

}
