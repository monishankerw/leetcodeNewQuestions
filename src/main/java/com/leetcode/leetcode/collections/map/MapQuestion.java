package com.leetcode.leetcode.collections.map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapQuestion {




    public static class EvenOrOdd {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1, 2, 4, 3, 2, 5);
            Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
            System.out.println("eee" + map.get(true));
            System.out.println("ttt" + map.get(false));
        }

    }

    public static class EvenAndOdd {
        public static void main(String[] args) {
            int[] arr = {1, 3, 2, 5, 6};
            EvenAndOdd evenAndOdd = new EvenAndOdd();
            Map<Boolean, List<Integer>> evenAndOdd1 = evenAndOdd.FindEvenAndOdd(arr);
            System.out.println("Even::" + evenAndOdd1.get(true));
            System.out.println("Odd::" + evenAndOdd1.get(false));
        }

        private Map<Boolean, List<Integer>> FindEvenAndOdd(int[] arr) {
            return Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        }
    }

    public static class FreqOcc {
        public static void main(String[] args) {
            int[] arr = {1, 2, 1, 3, 2, 4, 3, 1};
            FreqOcc freqOcc = new FreqOcc();
            Map<Integer, Integer> map = freqOcc.occFreq(arr);
            System.out.println("Freq Occ::" + map);
            Map<Integer, Long> map1 = freqOcc.occFreJava8(arr);
            System.out.println("Frrrr:" + map1);
        }

        private Map<Integer, Integer> occFreq(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return map;
        }

        private Map<Integer, Long> occFreJava8(int[] arr) {

            return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        }

    }

    public static class FreqOccString {
        public static void main(String[] args) {
            String str = "tereterttee";
            FreqOccString freqOccString = new FreqOccString();

            Map<Character, Integer> map = freqOccString.freqOccStr(str);
            System.out.println("Freq occ::" + map);
            Map<Character, Long> map1 = freqOccString.freqOccStrJava8(str);
            System.out.println("Freq occ::" + map1);
        }

        private static Map<Character, Long> freqOccStrJava8(String str) {
            return str.chars() // Get an IntStream of character codes from the string
                    .mapToObj(c -> (char) c) // Convert int (character codes) to Character objects
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Group and count occurrences
        }

        private Map<Character, Integer> freqOccStr(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            return map;
        }
    }

    public static class FreOccWords {
        public static void main(String[] args) {
            String text = "Test I Test My Test abc prq";
            FreOccWords obj = new FreOccWords();

            Map<String, Integer> wordFreqMap = obj.freqWordOcc(text);
            System.out.println("Word Frequencies: " + wordFreqMap);

            Map<String, Integer> wordFreqMap1 = obj.freqWordOccJava8(text);
            System.out.println("Word Frequencies: " + wordFreqMap1);
        }

        private Map<String, Integer> freqWordOcc(String text) {
            Map<String, Integer> map = new HashMap<>();
            String[] words = text.split("\\s+"); // split by spaces

            for (String word : words) {
                word = word.toLowerCase(); // optional: case-insensitive
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            return map;
        }

        private Map<String, Integer> freqWordOccJava8(String text) {
            return Arrays.stream(text.split("\\s+"))
                    .map(String::toLowerCase)
                    .collect(Collectors.toMap(
                            Function.identity(),
                            word -> 1,
                            Integer::sum
                    ));
        }


        public static class CharFrequencyExample {

            public static void main(String[] args) {
                char[] ch = {'a', 'a', 'd', 'w', 't', 't', 'e', 'q'};

                System.out.println("==> Java 8 Approach:");
                frequencyWithJava8(ch);

                System.out.println("\n==> Traditional Approach:");
                frequencyWithoutJava8(ch);
            }

            // ✅ Java 8 Approach using Stream API
            public static void frequencyWithJava8(char[] ch) {
                Map<Character, Long> freqMap = new String(ch)
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                freqMap.forEach((k, v) -> System.out.println(k + ": " + v));
            }

            // ✅ Traditional Approach using for-loop and HashMap
            public static void frequencyWithoutJava8(char[] ch) {
                Map<Character, Integer> freqMap = new HashMap<>();

                for (char c : ch) {
                    freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                }

                for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

    }

    public static class FirstNonRepeatedNumber {

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 1, 2, 3, 4, 3, 5, 6};

            FirstNonRepeatedNumber obj = new FirstNonRepeatedNumber();

            // Java 8 version
            Integer java8Result = obj.firstNonRepeatedNumbersJava8(arr);
            System.out.println("First Non-Repeated Number (Java 8):: " + java8Result);

            // Traditional version
            Integer traditionalResult = obj.firstNonRepeatedNumberTraditional(arr);
            System.out.println("First Non-Repeated Number (Traditional):: " + traditionalResult);
        }

        // Java 8 version
        private Integer firstNonRepeatedNumbersJava8(int[] arr) {
            Map<Integer, Long> map = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));

            return map.entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(-1);
        }

        // Traditional version
        private Integer firstNonRepeatedNumberTraditional(int[] arr) {
            Map<Integer, Integer> map = new LinkedHashMap<>();

            // Count frequencies
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // Return the first non-repeated number
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }

            return -1;
        }
    }
    public static class IndexOfFirstNonRepeatingChar {
        public static void main(String[] args) {
            String str = "loveleetcode";
            System.out.println("Index of first non-repeating character: " + indexOfFirstNonRepeatingChar(str));
        }

        private static int indexOfFirstNonRepeatingChar(String str) {
            Map<Character, Integer> charCount = new LinkedHashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() == 1) {
                    return str.indexOf(entry.getKey());
                }
            }
            return -1; // No unique character found
        }
    }
    public static class FirstNonRepeatedCharct {
        public static void main(String[] args) {
            String str = "swiss";
            FirstNonRepeatedCharct firstNonRepeatedCharct = new FirstNonRepeatedCharct();
            String map = firstNonRepeatedCharct.firstNonRepeatedChars(str);
            System.out.println("First Non-Repeated Chars::" + map);
            System.out.println("First Non-Repeating Character (Streams): " + findFirstNonRepeatedCharacter8(str).orElse(' '));
        }

        private String firstNonRepeatedChars(String str) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return String.valueOf(entry.getKey());
                }
            }

            return "No Unique charct";
        }
    }

    public static Optional<Character> findFirstNonRepeatedCharacter8(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }



    public static class NonRepeatedCharactersFinder {

        public static void main(String[] args) {
            String str3 = "hello world java";

            System.out.println("Non-Repeated Characters (Streams): " + findNonRepeatedUsingStreams(str3));
            System.out.println("Non-Repeated Characters (Traditional): " + findNonRepeatedWithoutStreams(str3));
        }

        public static List<Character> findNonRepeatedUsingStreams(String str) {
            return str.replaceAll("\\s+", "").chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        public static List<Character> findNonRepeatedWithoutStreams(String str) {
            str = str.replaceAll("\\s+", "");
            Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
            List<Character> nonRepeatedChars = new ArrayList<>();

            for (char c : str.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() == 1) {
                    nonRepeatedChars.add(entry.getKey());
                }
            }

            return nonRepeatedChars;
        }
    }

    public static class FirstNonRepeatedWordFinder {

        public static void main(String[] args) {
            String str4 = "Java is fun and Java is popular";

            System.out.println("First Non-Repeated Word (Traditional): " + firstNonRepeatedWordTraditional(str4));
            System.out.println("First Non-Repeated Word (Streams): " + firstNonRepeatedWordJava8(str4));
        }

        public static String firstNonRepeatedWordTraditional(String input) {
            String[] words = input.split("\\s+");
            Map<String, Integer> wordCount = new LinkedHashMap<>();
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                if (wordCount.get(word) == 1) return word;
            }
            return "";
        }

        public static String firstNonRepeatedWordJava8(String input) {
            return Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse("");
        }
    }

    public static class MostFrequentElement {

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 1, 2, 4, 3, 5, 3, 1, 2, 1};

            MostFrequentElement mfe = new MostFrequentElement();

            // Java 8 Version
            Integer java8Result = mfe.mostFrequentElementJava8(arr);
            System.out.println("Most Frequent Element (Java 8): " + java8Result);

            // Traditional Version
            Integer traditionalResult = mfe.mostFrequentElementTraditional(arr);
            System.out.println("Most Frequent Element (Traditional): " + traditionalResult);
        }

        // ✅ Java 8 version
        private Integer mostFrequentElementJava8(int[] arr) {
            Map<Integer, Long> freqMap = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

            return freqMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(-1);
        }

        // ✅ Traditional version (no Java 8 features)
        private Integer mostFrequentElementTraditional(int[] arr) {
            Map<Integer, Integer> freqMap = new HashMap<>();

            // Count frequency
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            int mostFrequent = -1;
            int maxCount = 0;

            // Find max frequency
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequent = entry.getKey();
                }
            }

            return mostFrequent;
        }
    }
    public static class ArraySplitExample {
        public static void main(String[] args) {
            int[] arr1 = {1, 6, 3, 8, 5, 9, 4};

            // 40. Split Array into Two Based on Condition (Java 8 Approach)
            Map<Boolean, List<Integer>> splitJava8 = Arrays.stream(arr1)
                    .boxed()
                    .collect(Collectors.partitioningBy(n -> n <= 5));
            System.out.println("40. Split (Java 8) (≤5, >5): " + splitJava8);

            // 40. Split Array into Two Based on Condition (Traditional Approach)
            List<Integer> lessThanOrEqualTo5 = new ArrayList<>();
            List<Integer> greaterThan5 = new ArrayList<>();

            for (int num : arr1) {
                if (num <= 5) {
                    lessThanOrEqualTo5.add(num);
                } else {
                    greaterThan5.add(num);
                }
            }
            System.out.println("40. Split (Traditional) (≤5): " + lessThanOrEqualTo5);
            System.out.println("40. Split (Traditional) (>5): " + greaterThan5);
        }
    }

    public static class CheckAnagramNumber{
        public static void main(String[] args) {
            int ang1[]={1,2,3};
            int ang2[]={2,3,1};
            boolean map=anagramNumber(ang1,ang2);
            System.out.println("Check Anagram::"+map);
            boolean result = anagramNumberJava8(ang1, ang2);
            System.out.println("Check Anagram:: " + result);
        }

        private static boolean anagramNumber(int[] ang1, int[] ang2) {
            return Arrays.equals(Arrays.stream(ang1).sorted().toArray(),Arrays.stream(ang2).sorted().toArray());
        }
        private static boolean anagramNumberJava8(int[] ang1, int[] ang2) {
            // Check lengths first
            if (ang1.length != ang2.length) {
                return false;
            }

            // Sort both arrays
            Arrays.sort(ang1);
            Arrays.sort(ang2);

            // Compare element by element
            for (int i = 0; i < ang1.length; i++) {
                if (ang1[i] != ang2[i]) {
                    return false;
                }
            }

            return true;
        }
    }
    // 9. Check Anagram
    public static class CheckAnagramString {

        public static void main(String[] args) {

            // Java 8 version
            checkAnagramJava8("listenase", "silent");

            // Traditional version
            checkAnagramTraditional("listenase", "silent");
        }

        // ✅ Java 8 Stream version
        private static void checkAnagramJava8(String a, String b) {
            boolean result = getFreqMapJava8(a).equals(getFreqMapJava8(b));
            System.out.println("Are Anagram (Java 8): " + result);
        }

        private static Map<Character, Long> getFreqMapJava8(String s) {
            return s.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        }

        // ✅ Traditional version (without Java 8)
        private static void checkAnagramTraditional(String a, String b) {
            boolean result = getFreqMapTraditional(a).equals(getFreqMapTraditional(b));
            System.out.println("Are Anagram (Traditional): " + result);
        }

        private static Map<Character, Integer> getFreqMapTraditional(String s) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
            return freqMap;
        }
    }
    public static void main(String[] args) {
        printIndices();
        groupWordsByLength();
        sortMapByValue();
        duplicateWords();
        characterFrequency();
        linkedHashMapOrder();
        elementsMoreThanOnce();
        arrayToMapWithIndex();
        elementWithKFrequency(2);
        mapOfSquares();
        groupByRemainder(3);
        pairSumCount(10);
        countElementsGreaterThanK(5);
        mapWithFirstAndLastIndex();
        removeDuplicates();
        valueGreaterThanKey();

    }
    // 16. Print Indices of Elements
    private static void printIndices() {
        /*
        int[] arr = {10, 20, 10, 30};
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

            This line is commonly used to group or index elements. It means:
           "If arr[i] is not already a key in the map, then create a new empty list for that key. Then, add the index i to the list."

           computeIfAbsent(key, mappingFunction):
           Checks if the key exists.
           If not, it adds the key with the value generated by mappingFunction.
           If it does exist, nothing is changed.
           Then it returns the value associated with that key (existing or new).

        */
        int[] arr = {10, 20, 10, 30};
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }


        System.out.println("Indices Map: " + map);
    }
    // 5. Group Words by Length
    private static void groupWordsByLength() {
        List<String> words = Arrays.asList("hi", "hello", "world", "yes", "no");
        Map<Integer, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Group by Length: " + grouped);
    }
    // 6. Sort Map by Value
    private static void sortMapByValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 2);
        map.put("banana", 5);
        map.put("cherry", 1);
        Map<String, Integer> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Sorted by Value: " + sorted);
    }
    // 7. Duplicate Words
    private static void duplicateWords() {
        String[] words = {"a", "b", "a", "c", "b", "a"};
        Map<String, Long> map = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println("Duplicates: " + map);
    }
    // 8. Character Frequency
    private static void characterFrequency() {
        String str = "character";
        Map<Character, Long> freq = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Char Freq: " + freq);
    }

    // 11. LinkedHashMap Order
    private static void linkedHashMapOrder() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        System.out.println("LinkedHashMap Order: " + map);
    }
    // 17. Elements Occurring More Than Once
    private static void elementsMoreThanOnce() {
        int[] arr = {1, 2, 3, 2, 1, 4};
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        freq.entrySet().stream().filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println("Duplicate: " + e.getKey()));
    }
    // 18. Array to Map with Index
    private static void arrayToMapWithIndex() {
        String[] arr = {"a", "b", "c"};
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        System.out.println("Index Map: " + map);
    }
    // 19. Elements Appearing Exactly K Times
    private static void elementWithKFrequency(int k) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) freq.put(i, freq.getOrDefault(i, 0) + 1);
        List<Integer> result = freq.entrySet().stream()
                .filter(e -> e.getValue() == k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Freq = " + k + ": " + result);
    }
    // 20. Map of Number and its Square
    private static void mapOfSquares() {
        int[] arr = {1, 2, 3, 4};
        Map<Integer, Integer> map = Arrays.stream(arr).boxed()
                .collect(Collectors.toMap(x -> x, x -> x * x));
        System.out.println("Squares: " + map);
    }
    // 21. Group by Remainder
    private static void groupByRemainder(int mod) {
        int[] arr = {10, 11, 12, 13};
        Map<Integer, List<Integer>> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(x -> x % mod));
        System.out.println("Grouped by % " + mod + ": " + map);
    }

    // 22. Count Pairs with Sum = K
    private static void pairSumCount(int k) {
        int[] arr = {1, 5, 7, -1, 5};
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : arr) {
            count += map.getOrDefault(k - i, 0);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println("Pairs with sum " + k + ": " + count);
    }

    // 23. Count > K
    private static void countElementsGreaterThanK(int k) {
        int[] arr = {1, 5, 3, 8, 6};
        long count = Arrays.stream(arr).filter(x -> x > k).count();
        System.out.println("Count > " + k + ": " + count);
    }

    // 24. First and Last Index
    private static void mapWithFirstAndLastIndex() {
        int[] arr = {1, 2, 1, 3, 2, 1};
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new int[]{i, i});
            } else {
                map.get(arr[i])[1] = i;
            }
        }
        map.forEach((k, v) -> System.out.println(k + " => First: " + v[0] + ", Last: " + v[1]));
    }

    // 25. Remove Duplicates
    private static void removeDuplicates() {
        int[] arr = {1, 2, 2, 3, 1};
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : arr) set.add(i);
        System.out.println("Unique (Order Preserved): " + set);
    }

    // 26. Value > Key
    private static void valueGreaterThanKey() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 5);
        map.put(2, 1);
        map.put(3, 4);
        List<Integer> keys = map.entrySet().stream()
                .filter(e -> e.getValue() > e.getKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Keys where value > key: " + keys);
    }
}
