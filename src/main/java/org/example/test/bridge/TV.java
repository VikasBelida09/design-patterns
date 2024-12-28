package org.example.test.bridge;

public class TV implements Device{
    private boolean on=false;
    private int deviceVolume=30;
    private String tvMode="Standard";
    @Override
    public void turnOff() {
        this.on=false;
    }

    @Override
    public void turnOn() {
    this.on=true;
    }

    @Override
    public void increaseVolumne() {
        this.deviceVolume++;
    }

    @Override
    public void decreaseVolume() {
    this.deviceVolume--;
    }

    @Override
    public void mute() {
this.deviceVolume=0;
    }

    @Override
    public void setMode(String mode) {
        this.tvMode=mode;
    }
}
