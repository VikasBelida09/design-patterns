package org.example.test.bridge;

public class Radio implements Device{
    private int deviceVolume=30;
    private boolean radioOn;
    private String mode="FM";
    @Override
    public void turnOff() {
        this.radioOn=false;
    }

    @Override
    public void turnOn() {
    this.radioOn=true;
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
this.mode=mode;
    }
}
