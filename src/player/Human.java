package player;

import pieces.Board;
import pieces.Piece;
import pieces.Pos;
import pieces.Team;

public class Human extends Player {
    public Human(Team team) {
        super(team);
    }

    @Override
    public Piece selectPiece() {
        Piece selectPiece;
        Pos inputPos;
        while (true) {
            inputPos = inputPos("이동할 기물을 선택하세요.");
            selectPiece = Board.board.getPieceByPos(inputPos);


            if (!inputPos.inBoard()) {
                System.out.println("범위를 벗어난 입력입니다.");
            } else if (selectPiece == null) {
                System.out.println("해당 위치에 기물이 없습니다.");
            } else if (selectPiece.getTeam() != getTeam()) {
                System.out.println("상대팀의 기물은 선택 할 수 없습니다.");
            } else if (!selectPiece.canMove()) {
                System.out.println("해당 기물은 움직일수있는 위치가 없습니다.");
            } else {
                break;
            }

            System.out.println("기물을 다시 선택하세요.");
        }

        return selectPiece;
    }

    @Override
    public Pos selectMovePos(Piece selectPiece) {
        /* 선택한 기물 이동 */
        while (true) {
            Pos inputPos = inputPos("기물을 이동할 위치를 선택하세요.");


            if (!inputPos.inBoard()) {
                System.out.println("범위를 벗어난 입력입니다.");
            } else if (!selectPiece.canMove(inputPos)) {
                System.out.println("해당 위치로 이동할 수 없습니다.");
            } else {
                return inputPos;
            }

            System.out.println("움직일 위치를 다시 선택하세요.");
        }
    }
}
