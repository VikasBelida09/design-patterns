package org.example;

import org.example.Behavioural.State.MusicPlayer;
import org.example.Behavioural.Observer.WeatherClient;
import org.example.Behavioural.Observer.WeatherClient2;
import org.example.Behavioural.Observer.WeatherStation;
import org.example.Behavioural.strategy.ShoppingCart;
import org.example.Logger.CustomLoggerFactory;
import org.example.Logger.Logger;
import org.example.ParkingLot.ParkingLot;
import org.example.ParkingLot.Ticket;
import org.example.ParkingLot.VehicleFactory;
import org.example.ParkingLot.VehicleType;
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
import org.example.test.DPQ1.*;
import org.example.test.singleton.DatabaseConnection;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Logger logger= CustomLoggerFactory.getLogger(Main.class);
        logger.log("Hello world!");
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        logger.log(singleton1==singleton);

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
        logger.log(sugarAndMilk.getDescription());
        logger.log(sugarAndMilk.getCost());

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
//            weatherStation.updateObservers((int) (Math.random() * 10), (int) (Math.random() * 10));
        }

        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.setStrategy(new org.example.Behavioural.strategy.Paypal("vikasbelida09@gmail.com"));
        shoppingCart.setItems(Arrays.asList("Tea Powder", "Coffee","Whey Protein","Milk"));
        shoppingCart.pay();


        DatabaseConnection connection=DatabaseConnection.getInstance();
        DatabaseConnection connection1=DatabaseConnection.getInstance();
        System.out.println(connection1==connection);
        PricingStrategy ps=PricingStrategyFactory.getPricingStrategyChain();
        EcommerceCart cart=new EcommerceCart(ps);
        cart.addItemToCart(new Item("Iphone 16 pro max",1283.0,1));
        cart.addItemToCart(new Item("Airpods 2nd gen pro",150.0,2));
        EcommerceCart cart1=new EcommerceCart(ps);
        cart1.addItemToCart(new Item("Iphone 16 pro max",1283.0,2));
        cart1.addItemToCart(new Item("Airpods 2nd gen pro",150.0,2));
        cart.makePayment(new org.example.test.DPQ1.Paypal("vikasbelida09@gmail.com"), CustomerType.GOLD);
        cart1.makePayment(new CreditCard("1234512345","123","11/27"), CustomerType.REGULAR);
        AtomicBoolean flag= new AtomicBoolean(false);

        Thread writerThread=new Thread(()->{
            try{
                Thread.sleep(1000);
                flag.set(true);
                logger.log("Writer thread changed flag to true");
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        });
        Thread readerThread = new Thread(() -> {
            while (!flag.get()) {
                // Keep checking the flag until it's true
            }
            logger.log("Reader thread detected flag as true");
        });
        writerThread.start();
        readerThread.start();
        writerThread.join();
        readerThread.join();
        logger.log("End of program!");


        ParkingLot parkingLot=ParkingLot.getInstance(1,4);
        org.example.ParkingLot.Vehicle car1=VehicleFactory.createVehicle("AB-1233", VehicleType.CAR);
        org.example.ParkingLot.Vehicle  bike1=VehicleFactory.createVehicle("CA-12323",VehicleType.BIKE);
        org.example.ParkingLot.Vehicle truck1=VehicleFactory.createVehicle("TS-1231231",VehicleType.TRUCK);
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(bike1);
        Ticket truckTicket=parkingLot.parkVehicle(truck1);

        System.out.println(parkingLot.removeVehicle(truckTicket));
    }
    private static void processAndPay(PaymentProcessor paymentProcessor){
        paymentProcessor.processPayment(123);
    }
    private static void processAndPay123(PaymentProcessor pp1){
        pp1.processPayment(123);
    }
}