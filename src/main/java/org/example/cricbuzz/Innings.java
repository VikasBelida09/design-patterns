package org.example.cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    Team battingTeam;
    Team bowlingTeam;
    List<Over> overs;
    MatchType type;

    public Innings(Team battingTeam, Team bowlingTeam, MatchType type) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.overs = new ArrayList<>();
        this.type = type;
    }

    void startInnings(int runsToWin){

    }
    int getTotalRuns(){
        return 0;
    }
}
