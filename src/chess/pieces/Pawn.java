package chess.pieces;

import chess.Board;
import chess.ChessUi;
import chess.util.PieceType;
import chess.util.Pos;
import chess.util.Team;

import java.util.ArrayList;
import java.util.Scanner;

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
        if(getTeam() == Team.YELLOW && getPosY() == 7) {
            return posList;
        }

        Pos tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? -1 : 1));
        Piece posPiece = Board.board.getPieceByPos(tempPos);
        if(posPiece == null){ //기본 앞으로 이동
            posList.add(tempPos);

            tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? -2 : 2));
            if (tempPos.inBoard() && getMoveCount() == 0 && Board.board.isPosEmpty(tempPos)) {
                posList.add(tempPos);
            }
        }
        // 대각선 부분을 봄
        tempPos = new Pos(getPosX() + 1, getPosY() + ((getTeam() == Team.BLUE) ? -1 : 1));
        posPiece = Board.board.getPieceByPos(tempPos);
        if(tempPos.inBoard() && posPiece != null && posPiece.getTeam() != getTeam()){
            posList.add(tempPos);
            System.out.println("대각선 + 1");
        }

        tempPos = new Pos(getPosX()-1, getPosY() + ((getTeam() == Team.BLUE) ? -1 : 1));
        posPiece = Board.board.getPieceByPos(tempPos);
        if(tempPos.inBoard() && posPiece != null && posPiece.getTeam() != getTeam()){
            posList.add(tempPos);
            System.out.println("대각선 - 1");
        }

        return posList;
    }

    @Override
    public void setPos(Pos pos){
        super.setPos(pos);

        if(getTeam() == Team.BLUE && getPosY() == 0) {
            promotion();
        }
        if(getTeam() == Team.YELLOW && getPosY() == 7) {
            promotion();
        }
    }

    private void promotion(){
        Scanner scanner = new Scanner(System.in);
        int choosePiece;

        ChessUi.printTeamMessage(getTeam(), "1. 퀸  2. 룩  3. 비숍  4. 나이트\n");
        ChessUi.printTeamMessage(getTeam(), "승급할 기물을 선택해주세요 : ");

        death();

        choosePiece = scanner.nextInt();
        switch (choosePiece){
            case 1 -> Board.board.createPiece(this.getPos(), PieceType.QUEEN, this.getTeam());
            case 2 -> Board.board.createPiece(this.getPos(), PieceType.ROOK, this.getTeam());
            case 3 -> Board.board.createPiece(this.getPos(), PieceType.BISHOP, this.getTeam());
            case 4 -> Board.board.createPiece(this.getPos(), PieceType.KNIGHT, this.getTeam());
        }

    }
}