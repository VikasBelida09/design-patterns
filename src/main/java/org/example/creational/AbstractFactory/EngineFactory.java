package org.example.creational.AbstractFactory;
public class  EngineFactory implements AbstractFactory<Engine>{
    public Engine create(String type){
        return switch (type){
            case "CARENGINE" -> new CarEngine();
            case "BIKEENGINE" -> new BikeEngine();
            default -> null;
        };
    }
}
