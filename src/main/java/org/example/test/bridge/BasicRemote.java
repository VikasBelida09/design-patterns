package org.example.test.bridge;

public class BasicRemote extends Remote{
    public BasicRemote(Device device){
        super(device);
    }
    public void mute(){
        this.device.mute();
    }
}
