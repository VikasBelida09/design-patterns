package org.example.Splitwise;

import java.util.List;

public class ExactSplit extends Expense{
    private final List<Double> exactAmnt;
    ExactSplit(String expenseDescription, double amnt, User paidBy, List<User> participants,List<Double>exactAmnt) {
        super(expenseDescription, amnt, paidBy, participants);
        this.exactAmnt=exactAmnt;
    }

    @Override
    public void caclulateSplit() {
        for (int i=0;i<participants.size();i++){
            User user=participants.get(i);
            double split=exactAmnt.get(i);
            if(user!=paidBy){
                user.updateBalance(paidBy,split);
                paidBy.updateBalance(user, -split);
            }
        }
    }
}
