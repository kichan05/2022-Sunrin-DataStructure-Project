package chess.pieces;

import chess.Board;
import chess.util.PieceType;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;

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

        // 킹사이드 캐슬링
        Pos tempPos = new Pos(7, (getTeam() != Team.BLUE) ? 0 : 7);
        Piece targetPiece = Board.board.getPieceByPos(tempPos);
        if(targetPiece != null){
            if(getMoveCount()==0 && targetPiece.getPieceType() == PieceType.ROOK && targetPiece.getMoveCount() == 0){
                if(Board.board.getPieceByPos(new Pos(5,getPosY())) == null && Board.board.getPieceByPos(new Pos(6,getPosY())) == null){
                    posList.add(new Pos(6, getPosY()));
                }
            }
        }

        // 퀸사이드 캐슬링
        tempPos = new Pos(0, (getTeam() != Team.BLUE) ? 0 : 7);
        targetPiece = Board.board.getPieceByPos(tempPos);
        if(targetPiece != null) {
            if (getMoveCount() == 0 && targetPiece.getPieceType() == PieceType.ROOK && targetPiece.getMoveCount() == 0) {
                if (Board.board.getPieceByPos(new Pos(1, getPosY())) == null && Board.board.getPieceByPos(new Pos(2, getPosY())) == null && Board.board.getPieceByPos(new Pos(3, getPosY())) == null) {
                    posList.add(new Pos(1, getPosY()));
                }
            }
        }
        return posList;
    }

    @Override
    public void setPos(Pos pos) {
        super.setPos(pos);

        // 캐슬링
        if(pos.getY() == ((getTeam()!=Team.BLUE)?0:7)){
            if(pos.getX() == 1){
                Piece targetPiece = Board.board.getPieceByPos(new Pos(0, (getTeam() != Team.BLUE) ? 0 : 7));
                targetPiece.setPos(new Pos(2,(getTeam()!=Team.BLUE)?0:7));
            }
            if(pos.getX() == 6){
                Piece targetPiece = Board.board.getPieceByPos(new Pos(7, (getTeam() != Team.BLUE) ? 0 : 7));
                targetPiece.setPos(new Pos(5,(getTeam()!=Team.BLUE)?0:7));
            }
        }

    }

    public boolean checkEnemyMove(Pos targetPos) {
        ArrayList<Piece> enemyPieceList = Board.board.getTeamPieceList(getTeam() == Team.BLUE ? Team.YELLOW : Team.BLUE);

        for (Piece i : enemyPieceList) {
            if (i.getCanMovePosList().contains(targetPos)) {
                return false;
            }
        }

        return true;
    }


}
