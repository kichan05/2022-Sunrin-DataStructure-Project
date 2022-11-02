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
        for (int i = 0; i < pieces.size(); i++){
            int pieceX = pieces.get(i).getPosX();
            int pieceY = pieces.get(i).getPosY();

            playground[pieceX][pieceY] = pieces.get(i).getShape();
        }

        System.out.print("\n\n\n\n");

        System.out.println("====================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(playground[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("====================");
    }

    public void initGameBoard() {
        pieces.add(new Rook(0, 0, Team.WHITE));
        pieces.add(new Knight(0, 1, Team.WHITE));
        pieces.add(new Bishop(0, 2, Team.WHITE));
        pieces.add(new Queen(0, 3, Team.WHITE));
        pieces.add(new King(0, 4, Team.WHITE));
        pieces.add(new Bishop(0, 5, Team.WHITE));
        pieces.add(new Knight(0, 6, Team.WHITE));
        pieces.add(new Rook(0, 7, Team.WHITE));
        for (int i = 0; i < 8; i++) pieces.add(new Pawn(1, i, Team.WHITE));

        pieces.add(new Rook(7, 0, Team.BLACK));
        pieces.add(new Knight(7, 1, Team.BLACK));
        pieces.add(new Bishop(7, 2, Team.BLACK));
        pieces.add(new Queen(7, 3, Team.BLACK));
        pieces.add(new King(7, 4, Team.BLACK));
        pieces.add(new Bishop(7, 5, Team.BLACK));
        pieces.add(new Knight(7, 6, Team.BLACK));
        pieces.add(new Rook(7, 7, Team.BLACK));
        for (int i = 0; i < 8; i++) pieces.add(new Pawn(6, i, Team.BLACK));

        printBoard();
    }

    public void clearBoard() {
        pieces.clear();
    }

}
