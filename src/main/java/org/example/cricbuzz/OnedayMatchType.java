package org.example.cricbuzz;

public class OnedayMatchType implements MatchType{
    @Override
    public int noOfOvers() {
        return 50;
    }

    @Override
    public int maxOverBolwerAllowed() {
        return 10;
    }
}
