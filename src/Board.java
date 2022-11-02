import pieces.King;
import pieces.Piece;
import pieces.Team;

import java.util.ArrayList;

public class Board {

    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public void printBoard() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("====================");
        for (int i = 0; i < pieces.size(); i++){
            System.out.printf("%d, %d, %c\n", pieces.get(i).getPosX(), pieces.get(i).getPosY(), pieces.get(i).getShape());
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
