package org.example.test.bridge;

public abstract class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void turnOff(){
        this.device.turnOff();
    }

    public void turnOn(){
        this.device.turnOn();
    }

    public void increaseVolume(){
        this.device.increaseVolumne();
    }

    public void decreaseVolume(){
        this.device.decreaseVolume();
    }
}