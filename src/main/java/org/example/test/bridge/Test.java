package org.example.test.bridge;

public class Test {
    public static void main(String[] args) {
        Device tv=new TV();
        Device radio=new Radio();
        AdvancedRemote advancedTvRemote=new AdvancedRemote(tv);
        BasicRemote basicTvRemote=new BasicRemote(tv);
        advancedTvRemote.turnOff();
        advancedTvRemote.turnOn();
        advancedTvRemote.changeMode("Sports");
        advancedTvRemote.setChannel(12);
    }
}
