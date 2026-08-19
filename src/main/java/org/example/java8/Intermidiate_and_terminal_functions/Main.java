package org.example.java8.Intermidiate_and_terminal_functions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// A Stream pipeline has two kinds of operations:
//   Intermediate  -> return a Stream, are lazy, can be chained (filter, map, sorted, distinct...)
//   Terminal      -> produce a result and end the stream (forEach, collect, count, reduce...)
public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Aryan", "Bob", "Anita", "Charlie", "Amit");

        // ---- Intermediate operations (filter + map + sorted) ----
        // then a terminal operation (collect) to get a List back
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))   // intermediate
                .map(String::toUpperCase)               // intermediate
                .sorted()                               // intermediate
                .collect(Collectors.toList());          // terminal

        System.out.println("Names starting with A: " + result);

        // ---- Terminal: count ----
        long count = names.stream()
                .filter(name -> name.length() > 4)
                .count();
        System.out.println("Names longer than 4 chars: " + count);

        // ---- Terminal: reduce (combine all elements into one) ----
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);

        // ---- Terminal: forEach ----
        System.out.print("All names: ");
        names.stream().forEach(name -> System.out.print(name + " "));
        System.out.println();
    }
}
