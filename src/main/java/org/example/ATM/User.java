package org.example.ATM;

public class User {
    private String name;
    private Card card;
    private UserBankAccount userBankAccount;

    public User(String name, Card card, UserBankAccount userBankAccount) {
        this.name = name;
        this.card = card;
        this.userBankAccount = userBankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public UserBankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }
}
