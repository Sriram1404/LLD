import core.Player;
import util.SnakeAndLadder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Player> players = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Total no. of players");
        int totalNoOfPlayers = sc.nextInt();
        while (totalNoOfPlayers > 0) {
            System.out.println("Enter player name");
            String name = sc.next();
            Player player = Player.builder()
                    .name(name)
                    .position(0)
                    .isWon(false)
                    .build();
            players.add(player);
            totalNoOfPlayers--;
        }
        //System.out.println("Players"+ players);
        System.out.println("Total no. of Snakes");
        int totalSnakes = sc.nextInt();
        Map<Integer, Integer> snakes = new HashMap<>();
        while (totalSnakes > 0) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            snakes.put(startPosition, endPosition);
            totalSnakes--;
        }
        //System.out.println("Snakes="+snakes);
        System.out.println("Total no. of Ladders");
        int totalLadders = sc.nextInt();
        Map<Integer, Integer> ladders = new HashMap<>();
        while (totalLadders > 0) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            ladders.put(startPosition, endPosition);
            totalLadders--;
        }
        //System.out.println("ladders="+ladders);
        SnakeAndLadder snakeAndLadder = SnakeAndLadder.builder()
                .ladders(ladders)
                .snakes(snakes)
                .players(players)
                .build();

        snakeAndLadder.startGame();
    }
}
