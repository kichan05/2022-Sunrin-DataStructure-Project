package player;

import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;

public class AlphaChess extends Player {
    public AlphaChess(Team team) {
        super(team);
    }

    @Override
    public Piece selectPiece() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return selectPiece();
        }

        while (true) {
            // 랜덤으로 좌표 선택
            int x = (int)(Math.random() * 10000) % 8;
            int y = (int)(Math.random() * 10000) % 8;
            Piece randomSelectPiece = Board.board.getPieceByPos(new Pos(x, y));

            // 해당 좌표의 기물이 선택히 가능하면 반환s
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return selectMovePos(selectPiece);
        }

        while (true) {
            // 랜덤으로 좌표 선택
            int x = (int)(Math.random() * 10000) % 8;
            int y = (int)(Math.random() * 10000) % 8;
            Pos randomPos = new Pos(x, y);

            // 해당 좌표로 이동이 가능하면 반환
            if (selectPiece.canMove(randomPos)) {
                return randomPos;
            }
        }
    }
}
