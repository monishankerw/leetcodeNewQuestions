package com.leetcode.leetcode.listQuestions;

import java.util.*;

public class Lists {

     //1. WAP to traverse(ot iterate) ArrayList.
    public class A {
        public static void main(String[] args) {
            ArrayList<Integer> a=new ArrayList<>();
            a.add(3);
            a.add(17);
            a.add(6);
            a.add(9);
            a.add(7);
            System.out.println(a);
        }

//         ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 17, 6, 9, 7));
//        System.out.println(a);
    }//op:[3, 17, 6, 9, 7]


    public static class B {
        public static void main(String[] args) {
            ArrayList<Integer>a=new ArrayList<>();
            a.add(3);
            a.add(17);
            a.add(6);
            a.add(9);
            a.add(7);

            for (Integer num:a){
                System.out.print(" "+num);
            }
        }//o/p  3 17 6 9 7
// ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 17, 6, 9, 7));
//
//        a.forEach(num -> System.out.print(" " + num)); // Using lambda expression
    }

    public static class C {
        public static void main(String[] args) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i <= 5; i++) {
                a.add(i);
                System.out.println(a);
            }

            // Removing element at index 3
            a.remove(3);

            System.out.println(a);
            for (int i=0;i<a.size();i++){
                System.out.println(a.get(i)+" ");
            }
        }
        /*
          // Initialize the list with elements from 0 to 5
        ArrayList<Integer> a = new ArrayList<>();
        IntStream.rangeClosed(0, 5).forEach(i -> {
            a.add(i);
            System.out.println(a);
        });

        // Remove the element at index 3
        a.remove(3);
        System.out.println(a);

        // Print each element using forEach and a lambda expression
        a.forEach(num -> System.out.print(num + " "));
    }
         */
    }//op:[0, 1, 2, 3, 4, 5]
//       [0, 1, 2, 4, 5]
//               0 1 2 4 5
//
//    add(object):used to add an object to the collection
//    size():used to return the number of elements in the collection.
//            remove():remove only one elements.

//       4. Given an element write a program check if element(value)
//    exist in elements.

    public static class Contains {
        public static void main(String[] args) {
            ArrayList<Integer>a=new ArrayList<>();
            a.add(1);
            a.add(4);
            a.add(2);
            a.add(3);
            System.out.println(a);
            if(a.contains(2)){
                System.out.println("Found");
            } else{
                System.out.println("Not found");
            }
        }
        /*
         ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        System.out.println(a);

        // Using lambda expression to check the condition
        System.out.println(a.contains(2) ? "Found" : "Not found");
    }
         */
    }
       //[1, 4, 2, 3]
   // Found
//    contains(object o);
//    This method returns true if the collection contains the specified elements.

    // 5. Reverse An ArrayList
    public static class ReverseElements {
        public static void main(String[] args) {
            ArrayList<Integer>a=new ArrayList<>();
            a.add(4);
            a.add(3);
            a.add(1);
            a.add(2);
            System.out.println("OriginalList:"+a);
            Collections.reverse(a);
            System.out.println("ReverseNumber:"+a);
        }
    }
    /*
     ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4, 3, 1, 2));
        System.out.println("Original List: " + a);

        // Using Stream to reverse the list
        List<Integer> reversedList = a.stream()
                                      .sorted(Collections.reverseOrder())
                                      .collect(Collectors.toList());

        System.out.println("Reversed List: " + reversedList);
    }
     */
//    OriginalList:[4, 3, 1, 2]
//    ReverseNumber:[2, 1, 3, 4]

           // 6.
    public static class ComPareElements {
        public static void main(String[] args) {
            ArrayList<Integer> a=new ArrayList<>();

            a.add(4);
            a.add(3);
            a.add(1);
            a.add(2);
            a.add(5);
            a.add(8);
            int min= Collections.min(a);
            int max=Collections.max(a);

            /*
                    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4, 3, 1, 2, 5, 8));

        // Using Stream API to find the min and max values
        int min = a.stream().min(Comparator.naturalOrder()).orElseThrow();
        int max = a.stream().max(Comparator.naturalOrder()).orElseThrow();

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
             */
            if(min==max){
                System.out.println("All Elements are Equal");
            } else{
                System.out.println("Minimum Elements");
                System.out.println("max");
            }
        }
    }

//    Minimum Elements max
//       7. WAP to add elements at the specified index in the list using add(index,elements) method.
    public class D {
        public static void main(String[] args) {
            ArrayList<Integer>a=new ArrayList<>();
            //add method for integer arraylist
            a.add(1);
            a.add(2);
            // index is zero based
            a.add(1,3);
            a.add(2,4);
            System.out.println(a);
        }
        /*
          ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4, 3, 1, 2, 5, 8));

        // Using Stream API to find min and max
        Optional<Integer> min = a.stream().min(Integer::compareTo);
        Optional<Integer> max = a.stream().max(Integer::compareTo);

        if (min.isPresent() && max.isPresent() && min.get().equals(max.get())) {
            System.out.println("All Elements are Equal");
        } else {
            System.out.println("Minimum Element: " + min.orElseThrow());
            System.out.println("Maximum Element: " + max.orElseThrow());
        }
         */
    }
//       [1, 3, 4, 2]
//
//               8.
    public static class Student {
        private String name;
        private String rollNo;

        public Student(String name, String rollNo) {
            this.name = name;
            this.rollNo = rollNo;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollNo='" + rollNo + '\'' +
                    '}';
        }

        public static void main(String[] args) {
            ArrayList<Student> a=new ArrayList<>();
            Student student1=new Student("abc","12");
            Student student2=new Student("abcd","13");
            Student student3=new Student("abcde","14");
            a.add(student1);
            a.add(student2);
            a.add(student3);
            for (Student C:a){
                System.out.println(C);
            }
//        a.forEach(student -> System.out.println(student));

        }
    }

//       9. WAP to sort ArrayList in descending order.
    public static class DescendingOrder {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("pqr");
        a.add("mno");
        a.add("abc");
        a.add("str");
        System.out.println(a);//unsorted
        Collections.sort(a, Collections.reverseOrder());
        System.out.println(a);//reverse
    }
}
/*
  ArrayList<String> a = new ArrayList<>(Arrays.asList("pqr", "mno", "abc", "str"));

        System.out.println("Original List: " + a); // unsorted

        // Using Stream API to sort in reverse order
        List<String> sortedList = a.stream()
                                   .sorted((s1, s2) -> s2.compareTo(s1)) // Custom comparator for descending order
                                   .collect(Collectors.toList());

        System.out.println("Sorted in Descending Order: " + sortedList); // reverse
    }
 */
//    }All Elements::
//            [pqr, mno, abc, str]
//    Descending Order::
//            [str, pqr, mno, abc]

          //  10. WAP to convert List to Array.
    public static class ListToArray {
        public static void main(String[] args) {
            ArrayList<String>a=new ArrayList<>();
            a.add("Apple");
            a.add("Banana");
            a.add("Pear");
            a.add("Mango");
            String[]str=new String[a.size()];
            for(int i=0;i<a.size();i++){
                str[i]=a.get(i);
            }
            for (String s:str){
                System.out.println(s);
            }
        }
        /*
         ArrayList<String> a = new ArrayList<>(Arrays.asList("Apple", "Banana", "Pear", "Mango"));

        // Using Stream API to convert the list to an array
        String[] str = a.stream().toArray(String[]::new);

        // Using forEach to print each element
        Arrays.stream(str).forEach(System.out::println);
    }
         */
    }
//    Apple
//            Banana
//    Pear
//            Mango
//
//       11.WAP to convert Array to List.
    public static class ArrayToList {
        public static void main(String[] args) {
            String[] str={"Dog","cat","Elephant"};
            for (String value:str){
                System.out.println("All Elements:"+value);
            }
            ArrayList arrayList=new ArrayList<>(Arrays.asList(str));
            System.out.println("List Elements:"+arrayList);
        }
    }

/*
String[] str = {"Dog", "Cat", "Elephant"};

        // Using Stream API to print all elements of the array
        Arrays.stream(str).forEach(value -> System.out.println("All Elements: " + value));

        // Converting array to ArrayList (with generics for type safety)
        List<String> arrayList = new ArrayList<>(Arrays.asList(str));

        // Printing the ArrayList
        System.out.println("List Elements: " + arrayList);
    }
}
 */
//    All Elements:Dog
//    All Elements:cat
//    All Elements:Elephant
//    List Elements:[Dog, cat, Elephant]

    //How would you remove duplicate elements from list using a set?
    public static class RemoveDuplicate{
        public static void main(String[] args) {
            List<String> list = Arrays.asList("abc", "bvc", "abc", "ygf", "bvc");
            Set<String> set = new HashSet<>(list);//remove duplicate
            List<String> list1 = new ArrayList<>(set);
            System.out.println(list1);
        }
    }
}
