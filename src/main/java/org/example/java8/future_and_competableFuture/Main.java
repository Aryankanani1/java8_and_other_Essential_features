package org.example.java8.future_and_competableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // ---------- Future ----------
        // A Future represents the result of an async task. You submit a task to an
        // ExecutorService, get back a Future, and call get() to (blocking) wait for the result.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(500); // simulate work
            return 2 + 3;
        });

        System.out.println("Future done? " + future.isDone());
        Integer futureResult = future.get(); // blocks until the task finishes
        System.out.println("Future result: " + futureResult);

        executor.shutdown();

        // ---------- CompletableFuture ----------
        // CompletableFuture is a Future you can chain and compose without blocking.

        // 1. Run async and get a result
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 10);

        // 2. Chain transformations (non-blocking pipeline)
        CompletableFuture<String> pipeline = cf
                .thenApply(n -> n * 2)                 // 20
                .thenApply(n -> "Result is " + n);     // "Result is 20"

        System.out.println(pipeline.get());

        // 3. Combine two independent async tasks
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> 7);
        CompletableFuture<Integer> sum = a.thenCombine(b, Integer::sum);
        System.out.println("Combined sum: " + sum.get());
    }
}
