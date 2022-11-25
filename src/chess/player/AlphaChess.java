package chess.player;

import chess.Board;
import chess.pieces.Piece;
import chess.util.Pos;
import chess.util.Team;

public class AlphaChess extends Player {
    public AlphaChess(Team team) {
        super(team);
    }

    @Override
    public Piece selectPiece() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        while (true) {
            // 랜덤으로 좌표 선택
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
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        while (true) {
            // 랜덤으로 좌표 선택
            Pos randomPos = Pos.getRandomPos();

            // 해당 좌표로 이동이 가능하면 반환
            if (selectPiece.canMove(randomPos)) {
                return randomPos;
            }
        }
    }
}