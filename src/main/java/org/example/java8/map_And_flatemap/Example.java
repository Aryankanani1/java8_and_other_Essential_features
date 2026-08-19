package org.example.java8.map_And_flatemap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        // map
        List<String> words = Arrays.asList("aryan","robert","hulk");
        List<String> uppercaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppercaseWords);

        // flat map
        List<List<Integer>> flatList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
                );

        List<Integer> flatStream = flatList.stream().flatMap(List::stream)
                .map(n -> n+1).collect(Collectors.toList());
        System.out.println(flatStream);

    }
}
