package pieces;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(int x, int y, Team team) {
        super(x, y, team, '♛', 3);
    }

    @Override
    public ArrayList<Pos> getCanMovePosList() {
        ArrayList<Pos> posList = new ArrayList<>();
        int x, y;
        Pos pos;
        Piece posPiece;

        // 대각선, 왼쪽 위
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

        // 대각선, 오른쪽 위
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

        // 대각선, 왼쫃 아래
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

        // 대각선, 오른쪽 아래
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

        // 수직 하
        for (y = getPosY() + 1; y < 8; y++) {
            Pos p = new Pos(getPosX(), y);

            posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }

        // 수직 상
        for (y = getPosY() - 1; 0 <= y; y--) {
            Pos p = new Pos(getPosX(), y);

            posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }

        // 수평 우
        for (x = getPosX() + 1; x < 8; x++) {
            Pos p = new Pos(x, getPosY());

            posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }

        // 수평 좌
        for (x = getPosX() - 1; 0 <= x; x--) {
            Pos p = new Pos(x, getPosY());

            posPiece = Board.board.getPieceByPos(p);
            if(posPiece != null){
                if(posPiece.getTeam() != getTeam())
                    posList.add(p);

                break;
            }

            posList.add(p);
        }


        return posList;
    }
}
