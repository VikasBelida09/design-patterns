package org.example;

import org.example.creational.Singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton1==singleton);
    }
}