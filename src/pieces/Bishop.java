package pieces;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(int x, int y, Team team) {
        super(x, y, team, '♝');
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<>();
        int x, y;
        Pos pos;
        Piece posPiece;

        x = getPosX() - 1;
        y = getPosY() - 1;
        while (true) {
            pos = new Pos(x--, y--);
            if(!pos.inBoard())
                break;
            posPiece = Board.board.getPieceByPos(pos);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(pos);

                break;
            }

            posList.add(pos);
        }

        x = getPosX() + 1;
        y = getPosY() - 1;
        while (true) {
            pos = new Pos(x++, y--);
            if(!pos.inBoard())
                break;
            posPiece = Board.board.getPieceByPos(pos);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(pos);

                break;
            }

            posList.add(pos);
        }

        x = getPosX() - 1;
        y = getPosY() + 1;
        while (true) {
            pos = new Pos(x--, y++);
            if(!pos.inBoard())
                break;
            posPiece = Board.board.getPieceByPos(pos);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(pos);

                break;
            }

            posList.add(pos);
        }

        x = getPosX() + 1;
        y = getPosY() + 1;
        while (true) {
            pos = new Pos(x++, y++);
            if(!pos.inBoard())
                break;
            posPiece = Board.board.getPieceByPos(pos);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(pos);

                break;
            }

            posList.add(pos);
        }

        return posList;
    }
}
