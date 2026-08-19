package org.example.java8.Functional_interface;

@FunctionalInterface
public interface Comparator<T>{
    int compare(T o1, T o2);
}
