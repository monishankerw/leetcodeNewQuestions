package com.leetcode.leetcode.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(1, 1, 2, 4, 3, 5, 5, 4, 6, 6, 7, 8, 6);
        List<Integer> avg = Arrays.asList(1, 4, 7, 8, 7, 5, 6);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "app", "application");
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 3, 1), Arrays.asList(5, 7, 6));


        //1. stream(): convert collection into stream
//        List<Integer>out=num.stream();
//        System.out.println(out+"output");
        // collect(): Collects the elements into a another data structure.
        // 1. filter():filter the elements based on a predicate.
        // a. find even number
        System.out.println("EvenNumber::" + num.stream().filter(nums -> nums % 2 == 0).collect(Collectors.toList()));
        System.out.println("Print Even Number and Sum even number::" + num.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList()));

        // reduce():Terminal Operation
        //Used to perform a reduction on the elements of a stream using an associative accumulation function and returning an optional with the reduced value.
        // sum of even number
        System.out.println("Sum of even numbers: " +
                num.stream()
                        .filter(x -> x % 2 == 0)
                        .reduce(0, (a, b) -> a + b)
        );

        // Partitioning the list into even and odd numbers
        Map<Boolean, List<Integer>> partitionedNumbers = num.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Number:" + partitionedNumbers.get(true));
        System.out.println("Odd Number:" + partitionedNumbers.get(false));

        // 2. map : Transforms each elements into another form
        // Print String in upper case
        System.out.println("UPPERCASE WORDS::" + words.stream().map(String::toUpperCase).collect(Collectors.toList()));
        // 3. mapToInt
        // sum all number in list
        System.out.println("Sum All Numbers::" + num.stream().mapToInt(Integer::intValue).sum());

        // 4. find First
        // print first word starting with a
        System.out.println("Find First Words::" + words.stream().filter(w -> w.startsWith("a")).collect(Collectors.toList()));

        // 5. grouping the stream using Stream API
        System.out.println("group the Strings::" + words.stream().collect(Collectors.groupingBy(String::length)));

        // 6. count the word greater than 3
        System.out.println("Count Word Greater Than Three::" + words.stream().filter(x -> x.length() > 3).count());

        // 7.flatMap(): flatten the lists into a single list
        System.out.println("Print Single List::" + lists.stream().flatMap(List::stream).collect(Collectors.toList()));

        // merge list and remove duplicate
        System.out.println("Print Single List and Remove duplicate::" + lists.stream().flatMap(List::stream).distinct().collect(Collectors.toList()));

        // 8. sort them in alphabetical order and collect the result
        System.out.println("Alphabetical Order Sort::" + words.stream().sorted().collect(Collectors.toList()));

        // 9. Remove Duplicate in list
        System.out.println("Remove Duplicate numbers in List::" + num.stream().distinct().collect(Collectors.toList()));

        // 10. greater than 4 and then find their average
        System.out.println("Print Average Greater than 4::" + avg.stream().filter(x -> x > 4).mapToInt(x -> x).average());

        // Count character occurrences in a string
        String input = "hello world";
        Map<Character, Long> characterCount = input.chars() // Convert the string to an IntStream of characters
                .mapToObj(c -> (char) c) // Convert the IntStream to a Stream<Character>
                .collect(Collectors.groupingBy( // Group by each character
                        Function.identity(), // Use the character as the key
                        Collectors.counting() // Count the occurrences
                ));
        String input1 = "hello world";

        Map<String, Long> map = Arrays.stream(input1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Occurence of each::" + map);
//forEach():Performs an actions on each elements
        System.out.println("Performing an action on each element:");
        num.stream().forEach(System.out::println);         // Print the character counts
        characterCount.forEach((character, count) -> System.out.println(character + ": " + count));

        // Convert a stream of strings to a list of integers representing their lengths
        List<Integer> x2 = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(x2);

        // Sorting a list of Person objects
        List<Person> people = Arrays.asList(
                new Person(30, "Alice"),
                new Person(25, "Bob"),
                new Person(35, "Charlie")
        );
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparingInt(person -> person.age))
                .collect(Collectors.toList());
        sortedPeople.forEach(System.out::println);

        // Collecting a map from a list of people
        Map<String, Integer> nameToAgeMap = people.stream()
                .collect(Collectors.toMap(person -> person.name, person -> person.age));
        System.out.println(nameToAgeMap);

        // Sorting Employee list by ID (natural ordering)
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Mani", 122222));
        list.add(new Employee(102, "Shanker", 111111));
        list.add(new Employee(103, "Test", 22222));

        // Sorting by ID (natural ordering)
        Collections.sort(list);
        System.out.println("Sorted by ID:");
        list.forEach(System.out::println);

        // Sorting by Name using Comparator
        Collections.sort(list, Comparator.comparing(Employee::getName));
        System.out.println("\nSorted by Name:");
        list.forEach(System.out::println);

        // Sorting by Salary using Comparator
        Collections.sort(list, Comparator.comparingInt(Employee::getSalary));
        System.out.println("\nSorted by Salary:");
        list.forEach(System.out::println);
    }

    // Person class
    public static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    // Employee class with Comparable implementation
    public static class Employee implements Comparable<Employee> {
        private int id;
        private String name;
        private int salary;

        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public int compareTo(Employee o) {
            return this.id - o.id;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }
}
