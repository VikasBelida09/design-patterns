package org.example.creational.AbstractFactory;

public class FactoryProducer {
    public static AbstractFactory<?> getFactory(String type){
        return switch (type){
            case "VEHICLE"->new VehicleFactory();
            case "ENGINE" -> new EngineFactory();
            default -> null;
        };
    }
}
