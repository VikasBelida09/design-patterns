package org.example.cricbuzz;

import java.util.List;
import java.util.Queue;

public class Team {
    String teamName;
    Queue<Player> players;
    List<Player> benchPlayers;
    PlayerBowlingController playerBowlingController;
    PlayerBattingController playerBattingController;
    boolean isWinner;

    int getTotalRuns(){
        return 0;
    }

}
