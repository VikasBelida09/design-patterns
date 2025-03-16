package org.example.Splitwise;

import java.util.Arrays;

public class SplitwiseDemo {
    public static void main(String[] args) {
        SplitwiseService splitwise=SplitwiseService.getInstance();
        User user=new User("Vikas belida","123");
        User user1=new User("Virat Kohli","234");
        User user2=new User("MS Dhoni","12345");

        splitwise.addUser(user);
        splitwise.addUser(user1);
        splitwise.addUser(user2);

        Group diningGroup=splitwise.addGroup("Restaurant- Mintt");

        diningGroup.addUser(user);
        diningGroup.addUser(user1);
        diningGroup.addUser(user2);

        Expense expense=ExpenseFactory.createExpense(new ExpenseRequest("EQUAL", "Lunch ", 150, user, Arrays.asList(user, user1, user2), null));
        splitwise.addExpense(expense, diningGroup.getGroupId());
    }
}
