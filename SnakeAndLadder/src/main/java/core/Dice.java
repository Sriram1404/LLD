package core;

import java.util.Random;

public class Dice {
    public static int rollDice(){
        return new Random().nextInt(6);
    }
}
