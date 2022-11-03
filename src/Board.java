import pieces.*;

import java.util.ArrayList;

public class Board {

    private ArrayList<Piece> pieces = new ArrayList<>();
    private char[][] playground
            = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};

    public void printBoard() {
        for (Piece piece : pieces) {
            int pieceX = piece.getPosX();
            int pieceY = piece.getPosY();

            playground[pieceX][pieceY] = piece.getShape();
        }

        System.out.print("\n\n\n\n");

        System.out.println("====================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(playground[j][i]+" ");
            }
            System.out.println();
        }
        System.out.println("====================");
    }

    public void initGameBoard() {
        pieces.add(new Rook(0, 0, Team.WHITE));
        pieces.add(new Knight(1, 0, Team.WHITE));
        pieces.add(new Bishop(2, 0, Team.WHITE));
        pieces.add(new Queen(3, 0, Team.WHITE));
        pieces.add(new King(4, 0, Team.WHITE));
        pieces.add(new Bishop(5, 0, Team.WHITE));
        pieces.add(new Knight(6, 0, Team.WHITE));
        pieces.add(new Rook(7, 0, Team.WHITE));
        for (int i = 0; i < 8; i++) pieces.add(new Pawn(i, 1, Team.WHITE));

        pieces.add(new Rook(0, 7, Team.BLACK));
        pieces.add(new Knight(1, 7, Team.BLACK));
        pieces.add(new Bishop(2, 7, Team.BLACK));
        pieces.add(new Queen(3, 7, Team.BLACK));
        pieces.add(new King(4, 7, Team.BLACK));
        pieces.add(new Bishop(5, 7, Team.BLACK));
        pieces.add(new Knight(6, 7, Team.BLACK));
        pieces.add(new Rook(7, 7, Team.BLACK));
        for (int i = 0; i < 8; i++) pieces.add(new Pawn(i, 6, Team.BLACK));

        printBoard();
    }

    public void clearBoard() {
        pieces.clear();
    }

    public Piece getPieceByPos(Pos pos){
        for(Piece i : pieces) {
            if(i.getPosX() == pos.getX() && i.getPosY() == pos.getY()){
                return i;
            }
        }

        return null;
    }
}
