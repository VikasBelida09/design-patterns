package org.example.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static volatile GameManager instance;
    private final List<SnakeAndLadder> games;
    private GameManager(){
        games=new ArrayList<>();
    }
    public static GameManager getInstance(){
        if(instance==null){
            synchronized (GameManager.class){
                if(instance==null){
                    instance=new GameManager();
                }
            }
        }
        return instance;
    }
    public void startGame(List<String> players){
        SnakeAndLadder snakeAndLadder=new SnakeAndLadder(players);
        games.add(snakeAndLadder);
        new Thread(snakeAndLadder::startGame).start();
    }
}
