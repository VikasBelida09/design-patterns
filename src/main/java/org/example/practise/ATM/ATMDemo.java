package org.example.practise.ATM;

public class ATMDemo {
    public static void main(String[] args) {
        ATM atm=ATM.getATMObject();
        BankAccount account = new BankAccount("123456", 5000);
        Card card = new Card("John Doe", "1234", "4321", account);

        atm.insertCard(card);
        atm.authenticatePin(card, "4321");
        atm.selectOperation(card, TransactionType.CASH_WITHDRAWAL);
        atm.cashWithdraw(card, 2700);
    }
}
