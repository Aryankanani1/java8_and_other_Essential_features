package org.example.java8.lamda_expression;

public class Main {
    public static void main(String[] args) {
        final Runnable runnable = () -> System.out.println("hello world");
runnable.run();
    }
}
