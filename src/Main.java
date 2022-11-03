import pieces.Team;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

        Board board = new Board();

        Player player1 = new Player(Team.BLACK);
        Player player2 = new Player(Team.WHITE);

        Scanner scanner = new Scanner(System.in);

        board.initGameBoard();

        while (gameState){
            player1.inputPos("기물을 선택하세요.");
        }

    }
}
