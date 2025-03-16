package org.example.Splitwise;

import java.util.List;

public class EqualSplit extends Expense {
    EqualSplit(String expenseDescription, double amnt, User paidBy, List<User> participants) {
        super(expenseDescription, amnt, paidBy, participants);
    }

    @Override
    public void caclulateSplit() {
        double amntPerPerson=amnt/participants.size();
        for (User participant : participants) {
            if(participant!=paidBy){
                participant.updateBalance(paidBy,amntPerPerson);
                paidBy.updateBalance(participant,-amntPerPerson);
            }
        }
    }
}
