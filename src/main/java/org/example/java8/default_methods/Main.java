package org.example.java8.default_methods;

// Java 8 lets interfaces have "default" methods with a body.
// This means we can add new methods to an interface WITHOUT
// breaking the classes that already implement it.
interface Vehicle {

    // abstract method - every implementing class must provide this
    void start();

    // default method - implementing classes get this for free
    default void honk() {
        System.out.println("Beep beep!");
    }

    // static method in an interface (also new in Java 8)
    static String type() {
        return "This is a vehicle";
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = () -> System.out.println("Car started");

        car.start();          // our own implementation
        car.honk();           // the default method from the interface
        System.out.println(Vehicle.type()); // the static interface method
    }
}
