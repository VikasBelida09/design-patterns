package org.example.cricbuzz;

import java.util.Date;

public class Match {
    Team teamA;
    Team teamB;
    String venue;
    Date date;
    String result;

    Innings[] innings;
    Team tossWinner;
    MatchType type;

    public Match(Team teamA, Team teamB, String venue, Date date, MatchType type) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.venue = venue;
        this.date = date;
        this.innings = new Innings[2];
        this.type = type;
    }
    public void startMatch(){
        tossWinner=toss(teamA, teamB);
        for(int inning=1;inning<=2;inning++){
            Innings inningsDetails;
            Team bowlingTeam;
            Team battingTeam;

            boolean isChasing=false;
            if(inning==1){
                battingTeam=tossWinner;
                bowlingTeam=tossWinner.teamName.equals(teamA.teamName) ? teamB : teamA;
                inningsDetails=new Innings(battingTeam,bowlingTeam,type);
                inningsDetails.startInnings(-1);
            }else{
                bowlingTeam=tossWinner;
                battingTeam=tossWinner.teamName.equals(teamA.teamName) ? teamB : teamA;
                inningsDetails=new Innings(battingTeam, bowlingTeam,type);
                inningsDetails.startInnings(innings[0].getTotalRuns());
                if (bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()){
                    bowlingTeam.isWinner=true;
                }
            }
            innings[inning-1]=inningsDetails;
        }
    }
    Team toss(Team teamA, Team teamB){
        if(Math.random()<0.5)return teamA;
        else return teamB;
    }
}
