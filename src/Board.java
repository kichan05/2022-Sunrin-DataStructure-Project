import java.util.ArrayList;

public class Board {

    ArrayList<Piece> pieces = new ArrayList<Piece>();


    public void printBoard() {
        for (int i = 0; i < pieces.size(); i++){
        }
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
