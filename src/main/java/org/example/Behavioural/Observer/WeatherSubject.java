package org.example.Behavioural.Observer;

public interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void updateObservers(int temp, int humidity);
}
