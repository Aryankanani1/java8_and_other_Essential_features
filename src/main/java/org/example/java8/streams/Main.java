package org.example.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //primitive type array
        int [] array = {1,2,3,4,5,6};
        IntStream intStream = Arrays.stream(array);
        intStream.forEach(System.out::println);


        //object type array
        Integer[] integers = {2,1,3,4};
        Stream<Integer> integerStream = Stream.of(integers);
        integerStream.forEach(System.out::println);

        // without stream
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for(Integer integer : list){
            if(integer % 2 == 0){
                int square = integer * integer;
            }
            
        }
    }


}
