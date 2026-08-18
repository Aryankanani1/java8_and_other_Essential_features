package org.example.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        // without stream
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int sumSquare = 0;
        for(Integer integer : list){
            if(integer % 2 == 0){
                int square = integer * integer;
                sumSquare += square;
            }
        }
        System.out.println(sumSquare);

        int sumSquare_stream = list.stream().filter(number -> number %2 ==0).mapToInt(n -> n* n).sum();
        System.out.println(sumSquare_stream);
    }
}
