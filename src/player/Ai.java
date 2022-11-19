package player;

import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;

import javax.swing.plaf.TableHeaderUI;

public class Ai extends Player {
    public Ai(Team team) {
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
            Piece selectPiece = Board.board.getPieceByPos(new Pos(x, y));

            // 해당 좌표의 기물이 선택히 가능하면 반환s
            if (selectPiece != null
                && selectPiece.getTeam() == getTeam()
                && selectPiece.canMove()
            ) {
                return selectPiece;
            }
        }
    }

    @Override
    public Pos selectMovePos(Piece selectPiece) {
        return null;
    }
}
