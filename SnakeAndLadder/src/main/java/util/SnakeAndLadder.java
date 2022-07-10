package util;

import core.Dice;
import core.Player;
import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
@Builder
public class SnakeAndLadder {
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private Queue<Player> players;
    private Dice dice;
    private final static int MAXIMUM_VAL = 100;

    public void startGame() {
        while (players.size() > 1) {
            Player player = players.poll();
            int currentPosition = player.getPosition();
            int diceValue = Dice.rollDice();
            int newPosition = checkPositionContainsSnake(currentPosition + diceValue);
            if (newPosition != -1) {
                player.setPosition(newPosition);
            } else {
                newPosition = checkPositionContainsLadder(currentPosition + diceValue);
                if (newPosition != -1) {
                    player.setPosition(newPosition);
                } else {
                    if (currentPosition + diceValue <= MAXIMUM_VAL) {
                        player.setPosition(currentPosition + diceValue);
                    } else {
                        System.out.println("Invalid Move");
                    }
                }
            }
            System.out.println(player.getName() + " current position= " + currentPosition + " dice= " +
                    diceValue + " new position= " + player.getPosition());
            if (player.getPosition() == MAXIMUM_VAL) {
                player.setIsWon(true);
                System.out.println("Player " + player.getName() + " is won");
            }
            if (!player.getIsWon()) {
                players.add(player);
            }
        }
    }

    public int checkPositionContainsSnake(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        return -1;
    }

    public int checkPositionContainsLadder(int position) {
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        return -1;
    }

}

