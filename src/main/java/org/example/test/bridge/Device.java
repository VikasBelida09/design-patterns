package org.example.test.bridge;

public interface Device {
    void turnOff();
    void turnOn();
    void increaseVolumne();
    void decreaseVolume();

    void mute();
    void setMode(String mode);
}
