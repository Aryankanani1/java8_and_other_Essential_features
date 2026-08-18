package org.example.java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // before stream
        int [] array = {1,2,3,4,5,6};
        IntStream intStream = Arrays.stream(array);
        intStream.forEach(System.out::println);

        //
    }
}
