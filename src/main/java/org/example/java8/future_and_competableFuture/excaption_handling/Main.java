package org.example.java8.future_and_competableFuture.excaption_handling;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() ->
        {
            if(new Random().nextBoolean()) throw new RuntimeException("Oops!");
            return "task completed";
        }).exceptionally(ex -> ex.getMessage())
                .thenAccept(System.out::println);
    }
}
