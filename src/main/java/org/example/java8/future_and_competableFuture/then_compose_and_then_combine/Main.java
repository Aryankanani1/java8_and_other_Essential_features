package org.example.java8.future_and_competableFuture.then_compose_and_then_combine;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        // compose
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10 )
                .thenCompose(result -> CompletableFuture.supplyAsync(()-> result * 2));
        System.out.println(future1.join());

        // combine
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> completableFuture = future2.thenCombine(future3,Integer::sum);
        System.out.println(completableFuture.join());
    }
}
