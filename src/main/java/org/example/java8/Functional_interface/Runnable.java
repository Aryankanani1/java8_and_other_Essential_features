package org.example.java8.Functional_interface;
@FunctionalInterface
interface FunctionalInterfaceExample {
    // only one abstract method
    void execute();

    default void defaultMethod(){
        System.out.println("this is default method");
    }

    static void staticMethod(){
        System.out.println("this is static method");
    }
}

@FunctionalInterface
public interface Runnable{
    void run();
}
