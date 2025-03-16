package org.example.Splitwise;

import java.util.List;

public record ExpenseRequest(String type, String expenseDescription, double amnt, User paidBy, List<User> participants,
                             List<Double> exactAmntOrPercentages) {
}