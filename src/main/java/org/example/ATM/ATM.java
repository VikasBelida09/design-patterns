package org.example.ATM;

import org.example.ATM.ATMState.ATMState;
import org.example.ATM.ATMState.IdleState;

public class ATM {
    private static final ATM atmObject=new ATM();
    ATMState atmState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfHundreds;

    private ATM(){

    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfHundreds = noOfHundreds - number;
    }


    public int getNoOfHundreds() {
        return noOfHundreds;
    }

    public void setNoOfHundreds(int noOfHundreds) {
        this.noOfHundreds = noOfHundreds;
    }
    public void deductATMBalance(int amount){
        this.atmBalance=this.atmBalance-amount;
    }
    public static ATM getATMObject(){
        atmObject.setAtmState(new IdleState());
        return atmObject;
    }
}
