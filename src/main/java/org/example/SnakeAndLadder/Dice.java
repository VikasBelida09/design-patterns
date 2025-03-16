package org.example.SnakeAndLadder;

public class Dice {
    private static final int MIN_VALUE=1;
    private static final int MAX_VALUE=6;
    public static int roll(){
        return (int) (Math.random() * (MAX_VALUE-MIN_VALUE+1))+1;
    }
}
