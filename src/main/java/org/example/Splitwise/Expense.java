package org.example.Splitwise;

import java.util.List;

public abstract class Expense {
    protected String id;
    protected String expenseDescription;
    protected List<User> participants;
    protected double amnt;
    protected User paidBy;

    Expense(String expenseDescription,double amnt, User paidBy, List<User> participants){
        this.amnt=amnt;
        this.paidBy=paidBy;
        this.participants=participants;
        this.expenseDescription=expenseDescription;
    }
    public abstract void caclulateSplit();
}
