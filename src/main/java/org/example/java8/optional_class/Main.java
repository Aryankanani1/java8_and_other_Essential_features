package org.example.java8.optional_class;

import java.util.Optional;

// Optional is a container that may or may not hold a non-null value.
// It helps us avoid NullPointerException and handle "no value" cleanly.
public class Main {
    public static void main(String[] args) {

        // create an Optional that holds a value
        Optional<String> name = Optional.of("Aryan");
        System.out.println("Is value present? " + name.isPresent());
        System.out.println("Value: " + name.get());

        // an empty Optional (no value inside)
        Optional<String> empty = Optional.empty();
        // orElse -> give a default when the value is missing
        System.out.println("Empty value or default: " + empty.orElse("No name"));

        // ofNullable -> safe way when the value might be null
        String maybeNull = null;
        Optional<String> safe = Optional.ofNullable(maybeNull);

        // ifPresent -> run code only when a value exists
        safe.ifPresent(v -> System.out.println("This will NOT print: " + v));

        // map -> transform the value only if it is present
        String upper = name.map(String::toUpperCase).orElse("EMPTY");
        System.out.println("Upper-cased: " + upper);
    }
}
