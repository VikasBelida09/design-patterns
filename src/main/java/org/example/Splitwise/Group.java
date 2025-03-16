package org.example.Splitwise;

import java.util.*;

public class Group implements Subject{
    private String groupId;

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    private String groupName;
    private final List<User> participants;
    private Date createdDate;
    private final List<Expense> expenses;

    private final List<Observer> observers;

    public String getGroupId() {
        return groupId;
    }
    Group(String name){
        this.groupName=name;
        this.participants=new ArrayList<>();
        this.expenses=new ArrayList<>();
        this.createdDate=new Date();
        this.observers=new ArrayList<>();
    }

    void addUser(User user){
        this.participants.add(user);
        this.observers.add(user);
    }
    void addExpense(Expense expense){
        this.expenses.add(expense);
        expense.caclulateSplit();
        notifyAll("New Expense of $"+expense.amnt+" added by "+expense.paidBy.getName());
        ActivityLog.addActivity("Expense: "+expense.expenseDescription+" has been added ");
    }
    void makePayment(User payer, User payee, double amnt, String payerComments){
        Payment payment=new Payment(payer,payee, amnt,payerComments);
        payment.makePayment();
        ActivityLog.addActivity(payer.getName()+" Paid $"+amnt+" to "+payee.getName());
    }

    @Override
    public void addObserver(Observer v) {
        this.observers.add(v);
    }

    @Override
    public void removeObserver(Observer v) {
        this.observers.remove(v);
    }

    @Override
    public void notifyAll(String message) {
        observers.forEach(o->o.receiveUpdate(message));
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", participants=" + participants +
                ", createdDate=" + createdDate +
                ", expenses=" + expenses +
                ", observers=" + observers +
                '}';
    }
    public void simplifyDebt(){
        Map<User, Double> userBalances=new HashMap<>();
        for(User user: participants){
            double balance = 0;
            for (Map.Entry<User, Double> entry : user.getBalanceMap().entrySet()) {
                balance += entry.getValue();
            }
            userBalances.put(user, balance);
        }
        DebtSimplification.simplifyDebts(userBalances);
    }
}
