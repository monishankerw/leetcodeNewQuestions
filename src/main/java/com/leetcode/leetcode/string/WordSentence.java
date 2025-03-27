package com.leetcode.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordSentence {
    public static class WordCount {
        public static void main(String[] args) {

            String str = "This is my Name is This my test";

            System.out.println("Word Count without java 8::" + wordCountWithoutJaava8(str));
            System.out.println("Word Count with java 8::" + wordCountWithJaava8(str));

            System.out.println("Frequency Occurrence Words Without java 8::"+frequenyOccWordsWithoutJava8(str));
            System.out.println("Frequency Occurrence Words With java 8::"+frequenyOccWordsWithJava8(str));


            System.out.println("Non Repeated words without java 8::"+nonRepeatedWordsWithoutJava8(str));
            System.out.println("Non Repeated words with java 8::"+nonRepeatedWordsWithJava8(str));

            System.out.println("MostFrequentWordWithoutJava8::"+mostFrequentWordWithoutJava8(str));
            System.out.println("MostFrequentWordWithJava8::"+mostFrequentWordWithJava8(str));

        }



        private static int wordCountWithoutJaava8(String str) {
            // trim() returns a new string with leading and trailing spaces removed,
            str = str.trim();
            if (str.isEmpty()) {
                return 0;
            }
            // Start with 1 assuming there's at least one word

            int count = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                // If current character is space and next character is not space, count a new word
                if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                    count++;
                }
            }
            return count;
        }
    }
    /*
    	1.	trim() → Removes any leading or trailing spaces from the string.
	2.	split("\\s+") → Splits the string into words using one or more spaces (\\s+ regex).
	3.	Arrays.stream(...).count() → Converts the array into a stream and counts the number of words.

     */
    private static long wordCountWithJaava8(String str) {
        return Arrays.stream(str.trim().split("\\s+")).count();
    }

    private static String frequenyOccWordsWithoutJava8(String str) {

        String[] split = str.trim().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word:split){
            map.put(word,map.getOrDefault(word,0)+1);
        }

return map.toString();
    }

    private static String frequenyOccWordsWithJava8(String str) {
        Map<String, Long> map = Arrays.stream(str.trim().split("\\s+")).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
return map.toString();
    }

    private static String nonRepeatedWordsWithoutJava8(String str) {
        String[] word = str.trim().split("\\s+");
        Map<String,Integer> map = new HashMap<>();
        for (String w:word){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        StringBuilder builder = new StringBuilder();
        for (String wors:word){
            if (map.get(wors)==1){
                builder.append(wors).append("");
            }
        }
        return builder.toString().trim();
    }
    private static String nonRepeatedWordsWithJava8(String str) {
        List<String> nonRepeatedWords = Arrays.stream(str.split("\\s+")) // Split sentence into words
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())) // Count occurrences
                .entrySet().stream() // Convert to stream
                .filter(entry -> entry.getValue() == 1) // Filter words that appear only once
                .map(Map.Entry::getKey) // Extract words
                .collect(Collectors.toList()); // Collect as a List
return nonRepeatedWords.toString();

    }

    private static String mostFrequentWordWithoutJava8(String str) {
        String[] words = str.trim().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        String mostFreq=" ";
        int maxCount=0;
        for (Map.Entry<String,Integer>entry:map.entrySet()){
            if(entry.getValue()>maxCount){
                mostFreq=entry.getKey();
                maxCount=entry.getValue();
            }
        }
        return mostFreq;
    }
    private static String mostFrequentWordWithJava8(String str) {
        String mostFrequent = Arrays.stream(str.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Find the max value
                .get().getKey(); // Extract the word
return mostFrequent;
    }

    /*

⸻



2️⃣ Find the Most Frequent Word in a Sentence

Example:

Input: "apple banana apple mango banana apple"
Output: "apple"

⸻

3️⃣ Reverse Each Word in a Sentence

Example:

Input: "Hello World"
Output: "olleH dlroW"

⸻

4️⃣ Reverse Words Order in a Sentence

Example:

Input: "Java is awesome"
Output: "awesome is Java"

⸻

5️⃣ Check If Two Strings Are Anagrams

Example:

Input: "listen", "silent"
Output: true

⸻

6️⃣ Find the Longest Word in a Sentence

Example:

Input: "This is an example sentence"
Output: "sentence"

⸻

7️⃣ Count the Number of Vowels and Consonants in a String

Example:

Input: "Hello World"
Output:
	•	Vowels: 3
	•	Consonants: 7

⸻

8️⃣ Find Words with Even Length in a Sentence

Example:

Input: "this is Java"
Output: ["this", "Java"]

⸻

9️⃣ Find the Shortest Word in a Sentence

Example:

Input: "This is a test"
Output: "a"

⸻

🔟 Find the Word with Maximum Repeated Characters

Example:

Input: "apple banana mississippi"
Output: "mississippi"

⸻

     */
}
