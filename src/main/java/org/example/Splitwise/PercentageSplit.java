package org.example.Splitwise;

import java.util.List;

public class PercentageSplit extends Expense{
    private final List<Double> percentageSplits;
    PercentageSplit(String expenseDescription, double amnt, User paidBy, List<User> participants, List<Double>percentages) {
        super(expenseDescription, amnt, paidBy, participants);
        percentageSplits=percentages;
    }

    @Override
    public void caclulateSplit() {
        for(int i=0;i<participants.size();i++){
            User user=participants.get(i);
            double percentage=percentageSplits.get(i)/100;
            if(user!=paidBy){
                user.updateBalance(paidBy,amnt * percentage);
                paidBy.updateBalance(user, -amnt * percentage);
            }
        }
    }
}
