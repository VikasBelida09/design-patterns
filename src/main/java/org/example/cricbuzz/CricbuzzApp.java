package org.example.cricbuzz;

import java.util.List;

public class CricbuzzApp {
    private List<Match>currentMatches;
    private List<Match>archivedMatches;
    private List<Match>upcomingMatches;

    public List<Match> getCurrentMatches() {
        return currentMatches;
    }

    public void setCurrentMatches(List<Match> currentMatches) {
        this.currentMatches = currentMatches;
    }

    public List<Match> getArchivedMatches() {
        return archivedMatches;
    }

    public void setArchivedMatches(List<Match> archivedMatches) {
        this.archivedMatches = archivedMatches;
    }

    public List<Match> getUpcomingMatches() {
        return upcomingMatches;
    }

    public void setUpcomingMatches(List<Match> upcomingMatches) {
        this.upcomingMatches = upcomingMatches;
    }

    private List<Match> searchArchivedMatches(String criteria){
        return null;
    }
    private List<Match> searchLiveMatches(String criteria){
        return null;
    }
}
