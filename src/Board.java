import pieces.*;

import java.util.ArrayList;

public class Board {

    private ArrayList<Piece> pieces = new ArrayList<>();
    private String[][] playground = new String[8][8];

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                playground[j][i] = "ㅤ";
            }
        }

        for (Piece piece : pieces) {
            int pieceX = piece.getPosX();
            int pieceY = piece.getPosY();

            playground[pieceX][pieceY] = piece.getPrintShape();
        }

        System.out.print("\n\n\n\n");


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

        printBoard();
    }

    public void clearBoard() {
        pieces.clear();
    }

    public Piece getPieceByPos(Pos pos){
        for(Piece i : pieces) {
            if(i.getPos().equals(pos)){
                return i;
            }
        }

        return null;
    }
}
