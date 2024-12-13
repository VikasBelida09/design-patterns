package org.example.cricbuzz;

public class TestMatchType implements MatchType{
    @Override
    public int noOfOvers() {
        return 90;
    }

    @Override
    public int maxOverBolwerAllowed() {
        return 20;
    }
}
