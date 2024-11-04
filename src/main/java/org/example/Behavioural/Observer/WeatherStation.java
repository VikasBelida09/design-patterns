package org.example.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherSubject{
    private List<WeatherObserver> observerList;
    public WeatherStation(){
        this.observerList=new ArrayList<>();
    }
    @Override
    public void registerObserver(WeatherObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateObservers(int temp, int humidity) {
        observerList.forEach(observer-> observer.update(temp,humidity));
    }
}
