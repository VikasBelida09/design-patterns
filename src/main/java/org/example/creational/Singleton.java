package org.example.creational;

import java.util.Objects;

public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(Objects.isNull(instance)){
            instance=new Singleton();
        }
        return instance;
    }

}
