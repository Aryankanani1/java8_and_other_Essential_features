package org.example.java8.grouping_and_aggregession;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // immutable list
        var immutableList = Stream.of("RED","GREEN","BLUE",null).toList();
        System.out.println(immutableList);

        // modifiable list
        var modifiable = Stream.of("RED","GREEN","BLUE",null).collect(Collectors.toList());
        modifiable.add("BLACK");
        System.out.println(modifiable);

        // grouping
        record Animal(
                String type,
                String name,
                double weight,
                int age
        ){};
        List<Animal> animals  = List.of(
              new Animal("cat","lion",104.00,14),
              new Animal("dog","fox",20.00,10),
              new Animal("bird","eagle",10.00,5),
              new Animal("cat","tiger",120.00,12),
              new Animal("dog","wolf",45.00,8),
              new Animal("bird","sparrow",0.50,2),
              new Animal("cat","leopard",90.00,9),
              new Animal("dog","beagle",15.00,6),
              new Animal("bird","owl",3.00,4),
              new Animal("fish","shark",250.00,20)
        );
        // grouping
        Map<String,List<Animal>> groupByAnimalType = animals.stream().collect(
                Collectors.groupingBy(Animal::type));
        System.out.println(groupByAnimalType);

        // aggregations
        Map<String,Double> averageAge = animals.stream().collect(
                Collectors.groupingBy(Animal::type,
                 Collectors.averagingDouble(Animal::age)));
        System.out.println(averageAge);

        // filtering
        var filteringProduct = animals.stream().filter(animal -> animal.age > 10).toList();
        System.out.println(filteringProduct);

        //extracting
        var extractAnimalType = animals.stream().map(Animal::type).collect(Collectors.toList());
        System.out.println(extractAnimalType);

        //partitioning
        var partitioningBasedOnWeight = animals.stream().collect(
                Collectors.partitioningBy(animal -> animal.weight > 50)
        );
        System.out.println(partitioningBasedOnWeight);

        // summary statistics
        Map<String , IntSummaryStatistics> summaryStatistics = animals.stream().
                collect(Collectors.groupingBy(Animal::name,
                        Collectors.summarizingInt(Animal::age)));
        System.out.println(summaryStatistics);
    }
}
