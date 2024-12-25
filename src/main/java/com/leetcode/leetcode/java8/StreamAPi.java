package com.leetcode.leetcode.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
     STREAMAPI JAVA8FEATURES
->WHICH HELPS US TO MANIPULATE COLLECTION
->A STREAM IS A SEQUENCE OF OBJECTS THAT SUPPORTS VARIOUS METHODS.
->PRESENT IN java.util.package
-> A STREAM IS NOT PRESENT IN JAVA.UTIL PACKAGE
....INTERMEDIATE OPERATION
                            THREE METHODS:
                            1.FILTER():->FILTER IS USED FOR FILTERING THE DATA. IT ALWAYS RETURNS THE BOOLEAN VALUE.
                            2.MAP():->TRANSFER THE OBJECT VALUE.
.....TERMINAL OPERATIONS
                            1.COLLECT()->THE COLLECT METHOD IS USED TO RETURN THE RESULT OF THE INTERMEDIATE OPERATIONS PERFORMED ON THE STREAM.
                            2.FOREACH()->THE FOREACH METHOD IS USED TO ITERATE THROUGH EVERY ELEMENTS OF THE STREAM.
                            3.REDUCE()->THE REDUCE METHOD IS USED TO REDUCE THE ELEMENTS OF A STREAM TO A SINGLE VALUE.
                            STREAM(): STREAM IS A SEQUENCE OF OBJECT WE CAN TRAVELS THROUGH SEQUENCE OF OBJECT THROUGH JAVA8.
                            1.SEQUENTIAL STREAM: sequential stream is where you current stream execute in one core in one thread.
                            2.PARALLEL STREAM:Parallel stream is applicable for multiple core sequential stream execute single core.

 */
public class StreamAPi {

    public static void main(String[] args) {
        List<Integer>num =Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer>num1 =Arrays.asList(3,5,7,8,4,6,4,1);
        List<String> startWith = Arrays.asList("1122", "2222", "11112", "444444");
        List<Integer> remDuplicate = Arrays.asList(1, 2, 1, 3, 1, 4, 2, 4);
        // even number 2,4,6,8
        //num%2==0
        //stream(): convert collection into stream

//        Stream<Integer> stream = num.stream();
//        System.out.println(stream);
        // // collect(): Collects the elements into a another data structure.
        //        // 1. filter():filter the elements based on a predicate.
        List<Integer>evenNumber=num.stream().filter(nums->nums%2==0).collect(Collectors.toList());
        System.out.println("Even Number:"+evenNumber);

        //2.odd number
        List<Integer>oddNumber=num.stream().filter(nums->nums%2!=0).collect(Collectors.toList());
        System.out.println("Odd Number:"+oddNumber);

        //3.sum of even number
        // reduce():Terminal Operation
        //Used to perform a reduction on the elements of a stream using an associative accumulation function and returning an optional with the reduced value.

        Integer sum = num.stream().filter(nums -> nums % 2 == 0).reduce(0, (a, b) -> a + b);
       /*
       Method	Explanation
list.stream()	Creates a stream from the list.
.filter(x -> x % 2 == 0)	Filters even numbers (x % 2 == 0).
.reduce(0, (a, b) -> a + b)	Reduces the stream to a single value (sum of elements).
        */
        System.out.println(sum);

        //4.

        Map<Boolean, List<Integer>> map = num.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
       /*
       Operation	Explanation
list.stream()	Creates a stream from the list.
s -> s % 2 == 0	Predicate to check if a number is even.
Collectors.partitioningBy	Partitions the stream elements into two groups.
        */
        System.out.println("EVEN NUMBER:"+map.get(true));
        System.out.println("ODD NUMBER:"+map.get(false));

        // 5. map : Transforms each elements into another form
        List<Integer> list = num.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());
        System.out.println("Square even Number::"+list);

        // 6. startWith
        List<String> list1 = startWith.stream().filter(x -> x.startsWith("1")).collect(Collectors.toList());
        System.out.println("StartWith:"+list1);

        // 7. Remove Duplicate
        List<Integer> removeDuplicate = remDuplicate.stream().distinct().collect(Collectors.toList());
        System.out.println("Remove Duplicate::"+removeDuplicate);

        //  8. mapToInt
        // sum all number in list
        System.out.println("Sum All Numbers::" + num.stream().mapToInt(Integer::intValue).sum());

        //  9. sort the number acending or descending
        List<Integer> sortAccending = num1.stream().sorted().collect(Collectors.toList());
        System.out.println("SORT ELEMENTS ACCENDING ORDER"+sortAccending);

        // 10. sort number descending order
        List<Integer> descendingOrder = num1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("DescendingOrder:"+descendingOrder);



        // 11. greater than 4 and then find their average
        OptionalDouble average = num1.stream().filter(x -> x > 4).mapToInt(x -> x).average();
        System.out.println("AVERAGE:"+average);

        //  12. flatMap(): flatten the lists into a single list
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3),Arrays.asList(4, 3, 1),Arrays.asList(5, 7, 6));

        //13.
        List<Integer> singleList = lists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Single List::"+singleList);

        //14.  merge and remove duplicate
        List<Integer> merge = lists.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
        System.out.println("Merge List::"+merge);

        // 15.Find the second-highest number
        Optional<Integer> secondHighestNumber = num.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("Second Highest Number::"+secondHighestNumber);

        //16. Maximum Value in a List
        OptionalInt maxNumber = num.stream().mapToInt(x -> x).max();
        System.out.println("Max Number:"+maxNumber);
        OptionalInt minNumber = num.stream().mapToInt(x -> x).min();

        //17. Average of Even Numbers
        OptionalDouble avgOfEvenNumber = num.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average();
        System.out.println("Avg Of even number"+avgOfEvenNumber);

        //18. Count Numbers Divisible by 3
        long count = num.stream().mapToInt(x -> x).filter(x -> x % 3 == 0).count();
        System.out.println("Count Numbers Divisible by 3:"+count);

        //19. Convert a List of Numbers to Their ASCII Characters

        List<Integer> assValue = Arrays.asList(67, 67, 68, 98, 97);
        assValue.stream().mapToInt(x->x).mapToObj(c->(char)c).forEach(c->System.out.println("Characters::"+c));

        //20.Convert String Lengths to an IntStream
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "cherry");
        words.stream().mapToInt(String::length).forEach(length->System.out.println("Length:"+length));

        //21.Find the longest string using reduce
        Optional<String> longestString = words.stream().reduce((x, y) -> x.length() > y.length() ? x : y);
        System.out.println("Longest String ::"+longestString);
        //22. uppercase
        List<String> upperCase = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("UpperCase::"+upperCase);

        //23. Convert a stream of strings to a list of integers representing their lengths
        List<Integer> x2 = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(x2);

        //24. Split the string into individual characters
        String input="aavdaaavdsswfsasa";
        String[] output = input.split("");
        System.out.println("OUTPUT::"+Arrays.toString(output));

        //25. Count occurrences of each character
        Map<String, Long> countOccurence = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Count occurrences of each character:::"+countOccurence);

        //26.Find duplicate characters with occurrences > 1
        List<String> duplicateChar = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Find duplicate characters with occurrences"+duplicateChar);

        //27.  Find unique elements

        List<String> unique = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Find unique elements"+unique);

        //28.  Find the first non-repeating element

        // Step 1: Convert input string into a stream of characters
        Optional<String> firstNonRepeating = Arrays.stream(input.split("")) // Split string into individual characters
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences of each character
                .entrySet().stream() // Convert map to a stream of entries
                .filter(entry -> entry.getValue() == 1) // Filter entries where the count is 1 (non-repeating)
                .map(Map.Entry::getKey) // Extract the character (key)
                .findFirst(); // Find the first non-repeating character

        System.out.println("Find the first non-repeating element::"+firstNonRepeating);
    
// Intersection
int[] arr1 = {1, 2, 3,2, 4};
int[] arr2 = {1, 2};

// Convert arr1 to a Set for efficient lookup
Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        System.out.println("SET:"+set);
// Filter arr2 to find elements present in set and print them
System.out.print("Intersection: ");
Arrays.stream(arr2)
      .filter(set::contains)
      .distinct() // To ensure unique elements
      .forEach(System.out::println); // Correct usage of forEach

/*
Step	            Function	                   Result
Arrays.stream(arr1)	Convert int[] to IntStream	    [1, 2, 3, 2, 1]
.boxed()	Convert IntStream to Stream<Integer>	[Integer(1), Integer(2), Integer(3), Integer(2), Integer(1)]
.collect(Collectors.toSet())	Collect elements into a Set<Integer>	[1, 2, 3]


Step	Function	Result
Arrays.stream(arr2)	Converts arr2 to a stream	[3, 4, 5, 6]
.filter(set::contains)	Filters elements present in set	[3, 4] (if set = {3, 4})
.distinct()	Ensures no duplicates	[3, 4]
.forEach(System.out::println)	Prints each element in the stream	Prints 3 on one line and 4 on the next
 */
    }  
}