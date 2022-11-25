package chess.pieces;

import chess.Board;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(int x, int y, Team team) {
        super(x, y, team, '♙', 1);
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<>();

        if(getTeam() == Team.BLUE && getPosY() == 0) {
            return posList;
        }
        if(getTeam() == Team.RED && getPosY() == 7) {
            return posList;
        }

        Pos tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? -1 : 1));
        Piece posPiece = Board.board.getPieceByPos(tempPos);
        if(posPiece == null){
            posList.add(tempPos);

            tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? -2 : 2));
            if (tempPos.inBoard() && getMoveCount() == 0 && Board.board.isPosEmpty(tempPos)) {
                posList.add(tempPos);
            }
        }
        else {
            tempPos = new Pos(getPosX()+1, getPosY() + ((getTeam() == Team.BLUE) ? -1 : 1));
            posPiece = Board.board.getPieceByPos(tempPos);
            if(tempPos.inBoard() && posPiece != null && posPiece.getTeam() != getTeam()){
                posList.add(tempPos);
            }

            tempPos = new Pos(getPosX()-1, getPosY() + ((getTeam() == Team.BLUE) ? -1 : 1));
            posPiece = Board.board.getPieceByPos(tempPos);
            if(tempPos.inBoard() && posPiece != null && posPiece.getTeam() != getTeam()){
                posList.add(tempPos);
            }
        }

        return posList;
    }
}