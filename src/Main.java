import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameState = true;

        Board board = new Board();

        Player player1 = new Player();
        Player player2 = new Player();

        Scanner scanner = new Scanner(System.in);

        board.initGameBoard();

        int x, y;
        while (gameState){
            System.out.print("기물을 선택하세요 : ");
            x = scanner.nextInt();
            y = scanner.nextInt();

        }

    }
}
