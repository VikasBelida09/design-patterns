package org.example;

import org.example.Behavioural.State.MusicPlayer;
import org.example.Behavioural.Observer.WeatherClient;
import org.example.Behavioural.Observer.WeatherClient2;
import org.example.Behavioural.Observer.WeatherStation;
import org.example.creational.AbstractFactory.AbstractFactory;
import org.example.creational.AbstractFactory.Engine;
import org.example.creational.AbstractFactory.FactoryProducer;
import org.example.creational.AbstractFactory.Vehicle;
import org.example.creational.Singleton;
import org.example.structural.Adapter.BankTransfer;
import org.example.structural.Adapter.PaymentProcessor;
import org.example.structural.Adapter.Paypal;
import org.example.structural.Adapter.PaypalAdapter;
import org.example.structural.Coffee;
import org.example.structural.MilkDecorator;
import org.example.structural.SimpleCoffe;
import org.example.structural.SugarDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton1==singleton);

//        factory example
//        Vehicle vehicle=VehicleFactory.getVehicle("CAR");
//        vehicle.drive();

        //abstract factory example

        AbstractFactory<Vehicle> vehicleAbstractFactory= (AbstractFactory<Vehicle>) FactoryProducer.getFactory("VEHICLE");
        Vehicle car=vehicleAbstractFactory.create("CAR");
        car.drive();

        AbstractFactory<Engine> engineAbstractFactory= (AbstractFactory<Engine>) FactoryProducer.getFactory("ENGINE");
        Engine engine=engineAbstractFactory.create("CARENGINE");
        engine.start();

        // decorator pattern
        SimpleCoffe simpleCoffe=new SimpleCoffe();
        Coffee sugarAndMilk=new SugarDecorator(new MilkDecorator(simpleCoffe));
        System.out.println(sugarAndMilk.getDescription());
        System.out.println(sugarAndMilk.getCost());

        //
        PaymentProcessor bankTransfer=new BankTransfer();
        PaypalAdapter adapter=new PaypalAdapter(new Paypal());
        processAndPay(bankTransfer);
        processAndPay123(bankTransfer);

        MusicPlayer player=new MusicPlayer();
        player.pressPlayButton();
        player.pressPlayButton();
        player.pressPlayButton();

        // observer pattern
        WeatherStation weatherStation=new WeatherStation();
        WeatherClient weatherClient=new WeatherClient();
        WeatherClient2 weatherClient2=new WeatherClient2();

        weatherStation.registerObserver(weatherClient2);
        weatherStation.registerObserver(weatherClient);

        for(int i=0;i<10;i++){
            weatherStation.updateObservers((int) (Math.random() * 10), (int) (Math.random() * 10));
        }

    }
    private static void processAndPay(PaymentProcessor paymentProcessor){
        paymentProcessor.processPayment(123);
    }
    private static void processAndPay123(PaymentProcessor pp1){
        pp1.processPayment(123);
    }
}