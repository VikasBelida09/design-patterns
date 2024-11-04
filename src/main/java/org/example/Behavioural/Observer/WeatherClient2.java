package org.example.Behavioural.Observer;

public class WeatherClient2 implements WeatherObserver{
    @Override
    public void update(int temperature, int humidity) {
        System.out.println("temperature is "+ temperature+" humidity is "+ humidity+" from weather client 2");
    }
}
