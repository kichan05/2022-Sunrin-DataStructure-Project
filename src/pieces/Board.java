package pieces;

import util.Color;

import java.util.ArrayList;

public class Board {
    public static Board board = new Board();

    private final ArrayList<Piece> pieces = new ArrayList<>();
    private ArrayList<Pos> canMovePosList = new ArrayList<>();
    private final String[][] playground = new String[8][8];

    public void setCanMovePosList(ArrayList<Pos> posList) {
        canMovePosList = posList;

        for (Pos pos : posList) {
            Piece piece = getPieceByPos(pos);
            if(piece != null) {
                piece.check();
            }
        }
    }

    public void clearCanMoveList() {
        canMovePosList.clear();

        for(Piece piece : pieces){
            piece.unCheck();
        }
    }

    public void printBoard() {
        // 출력되는 문자열 배열 초기화
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                playground[j][i] = "ㅤ";
            }
        }

        // 선택한 말 움직일수 있는 위치 표시
        for (Pos pos : canMovePosList) {
            playground[pos.getX()][pos.getY()] = Color.YELLOW.getFontColor() + "★" + Color.RESET.getFontColor() ;
        }

        // 기물들 표시
        for (Piece piece : pieces) {
            if(piece.isDeath()) //이미 죽은 말이면 표시 안함
                continue;

            int pieceX = piece.getPosX();
            int pieceY = piece.getPosY();

            playground[pieceX][pieceY] = piece.toBoardString();
        }

        System.out.print("\n\n\n\n");

        // 출력판 표시
        System.out.println("     0ㅤㅤ1ㅤㅤ2ㅤㅤ3ㅤㅤ4ㅤㅤ5ㅤㅤ6ㅤㅤ7");
        System.out.println("  ───────────────────────────────────────");
        for (int i = 0; i < 8; i++) {
            System.out.print(i+" │ ");
            for (int j = 0; j < 8; j++) {
                System.out.print(playground[j][i]+" │ ");
            }
            System.out.println("\n  ───────────────────────────────────────");
        }

    }

    public void initGameBoard() {
        pieces.add(new Rook(0, 0, Team.RED));
        pieces.add(new Knight(1, 0, Team.RED));
        pieces.add(new Bishop(2, 0, Team.RED));
        pieces.add(new Queen(3, 0, Team.RED));
        pieces.add(new King(4, 0, Team.RED));
        pieces.add(new Bishop(5, 0, Team.RED));
        pieces.add(new Knight(6, 0, Team.RED));
        pieces.add(new Rook(7, 0, Team.RED));
        for (int i = 0; i < 8; i++) pieces.add(new Pawn(i, 1, Team.RED));

        pieces.add(new Rook(0, 7, Team.BLUE));
        pieces.add(new Knight(1, 7, Team.BLUE));
        pieces.add(new Bishop(2, 7, Team.BLUE));
        pieces.add(new Queen(3, 7, Team.BLUE));
        pieces.add(new King(4, 7, Team.BLUE));
        pieces.add(new Bishop(5, 7, Team.BLUE));
        pieces.add(new Knight(6, 7, Team.BLUE));
        pieces.add(new Rook(7, 7, Team.BLUE));
        for (int i = 0; i < 8; i++) pieces.add(new Pawn(i, 6, Team.BLUE));

//        testBoard();
        printBoard();
    }

    public void testBoard(){
        clearPieces();
        pieces.add(new Pawn(2, 0, Team.RED));
        pieces.add(new Pawn(2, 1, Team.BLUE));
        pieces.add(new King(4, 0, Team.RED));
        pieces.add(new King(4, 7, Team.BLUE));


    }

    /** 좌표를 입력받고 보드판에서 해당 위치에 말이 있는지 확인
     * 있으면 해당 말 객체를 반환, 없으면 null 반환 */
    public Piece getPieceByPos(Pos pos){
        for(Piece i : pieces) {
            if(i.getPos().equals(pos) && !i.isDeath()){
                return i;
            }
        }

        return null;
    }

    public ArrayList<Piece> getTeamPieceList(Team team) {
        ArrayList<Piece> pieceList = new ArrayList<>();

        for (Piece i : pieces){
            if (i.getTeam() == team && !i.isDeath()){
                pieceList.add(i);
            }
        }

        return pieceList;
    }

    public void createPiece(Pos pos, PieceType pieceType, Team team){
        switch (pieceType){
            case PAWN -> pieces.add(new Pawn(pos.getX(), pos.getY(), team));
            case BISHOP -> pieces.add(new Bishop(pos.getX(), pos.getY(), team));
            case ROOK -> pieces.add(new Rook(pos.getX(), pos.getY(), team));
            case KNIGHT -> pieces.add(new Knight(pos.getX(), pos.getY(), team));
            case QUEEN -> pieces.add(new Queen(pos.getX(), pos.getY(), team));
            case KING -> pieces.add(new King(pos.getX(), pos.getY(), team));
        }
    }

    public boolean isPosEmpty(Pos pos){
        return getPieceByPos(pos) == null;
    }

    public void clearPieces() {
        pieces.clear();
    }
}
