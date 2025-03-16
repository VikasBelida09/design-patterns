package org.example.practise.ATM;

public class Card {
    private String cardName;
    private String cardNumber;
    private String pin;
    private BankAccount bankAccount;
    public boolean isPinEnteredCorrect(String pin){
        return this.pin.equals(pin);
    }

    public Card(String cardName, String cardNumber, String pin, BankAccount bankAccount) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void deductBalance(int balance){
        this.bankAccount.deductBalance(balance);
    }
}
