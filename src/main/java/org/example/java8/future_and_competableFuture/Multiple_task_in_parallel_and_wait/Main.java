package org.example.java8.future_and_competableFuture.Multiple_task_in_parallel_and_wait;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Void> allFuture = CompletableFuture.allOf(future1,future2);
        allFuture.thenRun(() ->{
            System.out.println("both task finished");
        });
    }
}
