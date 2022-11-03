import pieces.Pos;
import pieces.Team;

import java.util.Scanner;

public class Player {
    Team team;

    public Player(Team team) {
        this.team = team;
    }

    private final Scanner scanner = new Scanner(System.in);
    public Pos inputPos(String message) {
        int x, y;
        System.out.printf("%s : ", message);

        x = scanner.nextInt();
        y = scanner.nextInt();

        return new Pos(x, y);
    }
}
