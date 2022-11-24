package pieces;

import java.util.ArrayList;
import java.util.List;
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
        if(getTeam() == Team.RED && getPosY() == 7) {
            return posList;
        }

        Pos tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? -1 : 1));
        Piece posPiece = Board.board.getPieceByPos(tempPos);
        if(posPiece == null || posPiece.getTeam() != getTeam()){
            posList.add(tempPos);

            tempPos = new Pos(getPosX(), getPosY() + ((getTeam() == Team.BLUE) ? -2 : 2));
            if (tempPos.inBoard() && getMoveCount() == 0 && Board.board.isPosEmpty(tempPos)) {
                posList.add(tempPos);
            }
        }


        return posList;
    }

    @Override
    public void setPos(Pos pos){
        super.setPos(pos);

        if(getTeam() == Team.BLUE && getPosY() == 0) {
            promotion();
        }
        if(getTeam() == Team.RED && getPosY() == 7) {
            promotion();
        }
    }

    private void promotion(){
        Scanner scanner = new Scanner(System.in);
        int choosePiece;

        System.out.println("승급할 기물을 선택해주세요.");
        System.out.println("1. 퀸  2. 룩  3. 비숍  4. 나이트");

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