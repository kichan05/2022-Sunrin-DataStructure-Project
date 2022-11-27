package chess.pieces;

import chess.Board;
import chess.ChessUi;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;

public class King extends Piece {
    public King(int x, int y, Team team) {
        super(x, y, team, '♚', 4);
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList();

        for (int y = Math.max(0, getPosY() - 1); y <= Math.min(7, getPosY() + 1); y++) {
            for (int x = Math.max(0, getPosX() - 1); x <= Math.min(7, getPosX() + 1); x++) {
                Pos tempPos = new Pos(x, y);
                Piece targetPiece = Board.board.getPieceByPos(tempPos);
                if(targetPiece == null || (targetPiece.getTeam() != getTeam())){
                    posList.add(tempPos);
                }
            }
        }

        return posList;
    }

    public boolean checkEnemyMove(Pos targetPos) {
        ArrayList<Piece> enemyPieceList = Board.board.getTeamPieceList(getTeam() == Team.BLUE ? Team.YELLOW : Team.BLUE);

        for (Piece i : enemyPieceList) {
            if (i.getCanMovePosList().contains(targetPos)) {
                return false;
            }
        }

        return false;
    }


}
