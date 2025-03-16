package org.example.SnakeAndLadder;

import java.util.Arrays;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        GameManager gameManager=GameManager.getInstance();
        gameManager.startGame(Arrays.asList("player1", "player2", "player3"));
    }
}
