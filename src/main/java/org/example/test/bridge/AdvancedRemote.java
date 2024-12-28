package org.example.test.bridge;

public class AdvancedRemote extends Remote{
    public AdvancedRemote(Device device){
        super(device);
    }
    public void setChannel(int channel){
        System.out.println("Channel set to "+ channel +".");
    }
    public void changeMode(String mode){
        device.setMode(mode);
        System.out.println("Mode changed to "+mode+" via Advanced Remote");
    }
}

