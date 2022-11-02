import pieces.King;
import pieces.Piece;
import pieces.Team;

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

            playground[pieceX][pieceY] = '1';
        }

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("====================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

            }
        }
        System.out.println("====================");
    }

    public void initGameBoard() {
        pieces.add(new King(4, 0, Team.WHITE));
        pieces.add(new King(4, 7, Team.BLACK));

        printBoard();
    }

    public void clearBoard() {
        pieces.clear();
    }

}
