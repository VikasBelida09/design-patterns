package org.example.Splitwise;

public class ExpenseFactory {
    public static Expense createExpense(ExpenseRequest expenseRequest){
        return switch (expenseRequest.type()) {
            case "EQUAL" -> new EqualSplit(expenseRequest.expenseDescription(), expenseRequest.amnt(), expenseRequest.paidBy(), expenseRequest.participants());
            case "EXACT" -> new ExactSplit(expenseRequest.expenseDescription(), expenseRequest.amnt(), expenseRequest.paidBy(), expenseRequest.participants(), expenseRequest.exactAmntOrPercentages());
            case "PERCENTAGE" ->
                    new PercentageSplit(expenseRequest.expenseDescription(), expenseRequest.amnt(), expenseRequest.paidBy(), expenseRequest.participants(), expenseRequest.exactAmntOrPercentages());
            default -> throw new IllegalArgumentException("Invalid type passed");
        };
    }
}
