package com.leetcode.leetcode.collections;

import com.leetcode.leetcode.collections.listQuestions.Lists;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsInJava {

    /*
    collection: Any group of individual objects which are represents as a single unit is
    known as a collection of object.

    Difference between Collection and Collections.
    Collection:
    1. Interface 2. Store server object in single entity

    Collections
    1. class 2. Help us perform like sorting, searching

    What is a Collection in java?
    1. It is an interface.
    2. It stores server an object as single entity.
    3. Collection gives us radimate data structure.
    4. Size of collection is dynamics.

    Collection Framework in java
    Collection Hierarchy

                           Iterable
                               |
                         Collection
        ----------------------------------------------------
       |                   |                           |
      List                Set                        Queue
   -----------      ----------------          ------------------
  |           |    |                |        |                |
ArrayList  LinkedList HashSet   LinkedHashSet PriorityQueue  Deque
                          |                                 |
                      SortedSet                        ArrayDeque
                          |
                       TreeSet

                           Map
        --------------------------------------------
       |                      |                   |
    HashMap          LinkedHashMap           TreeMap
       |
  ConcurrentHashMap

  Difference between Arrays nad Collections
  Array
  1. Fixed Size
  2.Homogeneous Data
  3.Memory usage it is less efficient
  4.No underlying data structure.

  Collections
  1. Size Dynamics
  2. Both homogeneous and Hetrogeneous
  3. Memory are more efficient
  4.He got underlying data structure to simplify our work.


  Commonly used methods in the collections class.
  The Collections class in Java is a utility class in the java.util package that provides static methods for operating on or returning collections. These methods include searching, sorting, shuffling, reversing, and more. Below is a list of commonly used methods in the Collections class along with explanations and examples.

1. Sorting Methods
	•	sort(List<T> list)
	•	Sorts the specified list in ascending order.
	•	Example:

List<Integer> list = Arrays.asList(5, 3, 8, 1);
Collections.sort(list);
System.out.println(list); // Output: [1, 3, 5, 8]


	•	sort(List<T> list, Comparator<? super T> c)
	•	Sorts the specified list based on the custom comparator.
	•	Example:

Collections.sort(list, Collections.reverseOrder());
System.out.println(list); // Output: [8, 5, 3, 1]

2. Searching Methods
	•	binarySearch(List<? extends T> list, T key)
	•	Performs a binary search for the specified key in a sorted list.
	•	Example:

List<Integer> list = Arrays.asList(1, 3, 5, 7);
int index = Collections.binarySearch(list, 5);
System.out.println(index); // Output: 2

3. Shuffle and Randomization
	•	shuffle(List<?> list)
	•	Randomly shuffles the elements of the specified list.
	•	Example:

List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
Collections.shuffle(list);
System.out.println(list); // Output: [3, 1, 5, 2, 4] (varies)


	•	shuffle(List<?> list, Random rnd)
	•	Shuffles the list with a custom random number generator.

4. Reverse and Rotation
	•	reverse(List<?> list)
	•	Reverses the order of elements in the specified list.
	•	Example:

List<Integer> list = Arrays.asList(1, 2, 3, 4);
Collections.reverse(list);
System.out.println(list); // Output: [4, 3, 2, 1]


	•	rotate(List<?> list, int distance)
	•	Rotates the elements in the list by the specified distance.
	•	Example:

List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
Collections.rotate(list, 2);
System.out.println(list); // Output: [4, 5, 1, 2, 3]

5. Frequency and Disjoint
	•	frequency(Collection<?> c, Object o)
	•	Returns the frequency of the specified object in the collection.
	•	Example:

List<String> list = Arrays.asList("a", "b", "a", "c");
int freq = Collections.frequency(list, "a");
System.out.println(freq); // Output: 2


	•	disjoint(Collection<?> c1, Collection<?> c2)
	•	Checks if two collections have no elements in common.
	•	Example:

List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(4, 5, 6);
boolean result = Collections.disjoint(list1, list2);
System.out.println(result); // Output: true

6. Min and Max
	•	min(Collection<? extends T> coll)
	•	Returns the minimum element in the collection.
	•	Example:

List<Integer> list = Arrays.asList(3, 5, 2, 8);
int min = Collections.min(list);
System.out.println(min); // Output: 2


	•	max(Collection<? extends T> coll)
	•	Returns the maximum element in the collection.
	•	Example:

int max = Collections.max(list);
System.out.println(max); // Output: 8

7. Thread-Safe Collections
	•	synchronizedList(List<T> list)
	•	Returns a thread-safe version of the specified list.
	•	Example:

List<Integer> list = Collections.synchronizedList(new ArrayList<>());


	•	synchronizedMap(Map<K, V> map)
	•	Returns a thread-safe version of the specified map.

8. Singleton and Empty Collections
	•	singleton(T o)
	•	Returns an immutable set containing the specified element.
	•	Example:

Set<String> singletonSet = Collections.singleton("Hello");


	•	emptyList()
	•	Returns an empty, immutable list.
	•	Example:

List<String> emptyList = Collections.emptyList();

9. Add All
	•	addAll(Collection<? super T> c, T... elements)
	•	Adds all specified elements to the collection.
	•	Example:

List<Integer> list = new ArrayList<>();
Collections.addAll(list, 1, 2, 3, 4);
System.out.println(list); // Output: [1, 2, 3, 4]

10. Unmodifiable Collections
	•	unmodifiableList(List<? extends T> list)
	•	Returns an unmodifiable view of the specified list.
	•	Example:

List<Integer> list = Arrays.asList(1, 2, 3);
List<Integer> unmodifiableList = Collections.unmodifiableList(list);

Summary Table

Method	Description
sort()	Sort a list in ascending order.
binarySearch()	Search for an element in a sorted list.
shuffle()	Shuffle elements randomly.
reverse()	Reverse the order of elements in a list.
frequency()	Count occurrences of an element.
disjoint()	Check if two collections have no common elements.
min() / max()	Find the minimum/maximum element in a collection.
synchronizedList()	Create a thread-safe list.
addAll()	Add multiple elements to a collection.

*/

/*
LIST:
ArrayList,LinkList,Vector,stack
Index based data structure.
allow to store duplicate elements
List can store any value of null elements
performance is low

Difference between Array and ArrayList?
Array
Fixed Size
not inside build method
contain both permitive datatype as well as object type.
can be multidimensional
part of core java program
ArrayList
size dynamics
many build method
support only object entity
one dimensional
part of collection framework.

ArrayList
It can contains duplicate elements
It maintains insertion order.
Allows Random access of data.
Internally it is implements as dynamics arrays.
used wrapper class.
ArrayList cannot used for primitivity type order

Difference between Arraylist and LinkedList.
ArrayList
ArrayList internally used a dynamics array to store the elements.
Manipulation with Arraylist is slow.
ArrayList consumes less memory than linked list.
An arraylist class can acts as a list only.
Arraylist better for sorting and accessing data.
LinkedList
1. LinkedList internally used a doubly linked list to store the elements.
2. Manipulation with arraylist is fast
Linked list consumes more memory the arraylist.
An likedlist class can acts as a list and queue.
Linkedlist better for manipulation data.

Difference between Arraylist and vector.
ArrayList
Arraylist gives better performance
non-synchronized and non-thread safe.
Arraylist can use iterator for traversing its elements

Vector
poor performance
synchronized and thread safe
vector can use both enumeration and iterator for traversing over elements.


vector
The vector Thread safe and synchronized and poor performance.
maintain insertion order
similar to arraylist
vector fall in legacy class
vector implements a dynamics array.

How do you make arraylist as synchronized?
Two ways:
1.Collections.synchronizedList()
2.copyoneWriteArrayList

 */

    /*
    Use for retrieving of data in collection
    forEach,iterator,Listiterator,EnumerationIterator,cursor

    In Java, various mechanisms are provided to retrieve data from collections. These include forEach, Iterator, ListIterator, Enumeration, and Cursors. Each method has its own use case, functionality, and advantages. Below is an explanation of these mechanisms with code examples.

1. forEach

The forEach method allows concise iteration over collections using lambda expressions (introduced in Java 8).

Key Features:
	•	Simplifies iteration.
	•	Supports functional programming with lambda expressions.

Example:

List<String> list = Arrays.asList("Apple", "Banana", "Cherry");

list.forEach(item -> System.out.println(item));

Output:

Apple
Banana
Cherry

2. Iterator

The Iterator interface provides a way to traverse elements one by one. It works for all collection types.

Key Features:
	•	Allows traversal in one direction.
	•	Can remove elements during iteration.

Methods:
	•	hasNext(): Checks if there are more elements.
	•	next(): Retrieves the next element.
	•	remove(): Removes the last element returned by the iterator.

Example:

List<Integer> numbers = Arrays.asList(10, 20, 30);

Iterator<Integer> iterator = numbers.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

Output:

10
20
30

3. ListIterator

ListIterator extends Iterator and allows bi-directional traversal of lists.

Key Features:
	•	Traverses in both directions (hasPrevious() and previous()).
	•	Can modify elements during iteration (set()).

Methods:
	•	hasNext(), next(), hasPrevious(), previous().
	•	add(), remove(), set().

Example:

List<String> list = Arrays.asList("A", "B", "C", "D");

ListIterator<String> listIterator = list.listIterator();
System.out.println("Forward Traversal:");
while (listIterator.hasNext()) {
    System.out.println(listIterator.next());
}

System.out.println("Backward Traversal:");
while (listIterator.hasPrevious()) {
    System.out.println(listIterator.previous());
}

Output:

Forward Traversal:
A
B
C
D
Backward Traversal:
D
C
B
A

4. Enumeration

Enumeration is a legacy interface used to iterate over Vector and Hashtable.

Key Features:
	•	Works only with legacy collections.
	•	Does not support element modification.

Methods:
	•	hasMoreElements()
	•	nextElement()

Example:

Vector<String> vector = new Vector<>();
vector.add("X");
vector.add("Y");
vector.add("Z");

Enumeration<String> enumeration = vector.elements();
while (enumeration.hasMoreElements()) {
    System.out.println(enumeration.nextElement());
}

Output:

X
Y
Z

5. Cursor

Cursors are used to retrieve data from collections like Iterator and ListIterator. They are not a separate interface but are generic terms for data retrieval mechanisms.

Types of Cursors:
	1.	Iterator: For one-way traversal.
	2.	ListIterator: For bi-directional traversal.
	3.	Enumeration: For legacy collections.

Cursor Comparison:

Feature	Iterator	ListIterator	Enumeration
Direction	Forward	Forward and backward	Forward
Modify Elements	Yes (remove)	Yes (add, set, remove)	No
Applicable To	All collections	List only	Legacy collections
Introduced In	Java 2	Java 2	Java 1

Comparison of Methods

Method	Scope	Supports Modification	Key Features
forEach	All collections	No	Functional programming style, concise.
Iterator	All collections	Yes (remove only)	Universal cursor, one-way traversal.
ListIterator	Lists only	Yes (add, set, remove)	Bi-directional traversal.
Enumeration	Legacy collections	No	Lightweight, only forward traversal.
Cursor (Generic)	All collections	Depends (Iterator/ListIterator)	Unified term for iterators and enumerations.

Choosing the Right Method
	•	Use forEach:
When you need concise and readable iteration for any collection.
	•	Use Iterator:
When you need to traverse and remove elements during iteration.
	•	Use ListIterator:
When you need to traverse in both directions or modify elements in a list.
	•	Use Enumeration:
When working with legacy collections like Vector or Hashtable.

These mechanisms provide flexibility for retrieving and operating on data in collections effectively.
     */

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
    public static class D {
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
            ArrayList<Lists.Student> a=new ArrayList<>();
            Lists.Student student1=new Lists.Student("abc","12");
            Lists.Student student2=new Lists.Student("abcd","13");
            Lists.Student student3=new Lists.Student("abcde","14");
            a.add(student1);
            a.add(student2);
            a.add(student3);
            for (Lists.Student C:a){
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


/*
In Java, the Set interface is part of the Java Collections Framework and represents a collection that does not allow duplicate elements.
 It is derived from the Collection interface, forming part of the collection hierarchy.
 Below is a detailed explanation of the Set hierarchy, its types, and their uses.

Set in the Collection Hierarchy

The Collection hierarchy for Set is as follows:

java.lang.Object
   |
   +--java.util.Collection (Interface)
           |
           +--java.util.Set (Interface)
                   |
                   +--java.util.HashSet (Class)
                   |
                   +--java.util.LinkedHashSet (Class)
                   |
                   +--java.util.SortedSet (Interface)
                           |
                           +--java.util.NavigableSet (Interface)
                                   |
                                   +--java.util.TreeSet (Class)

Key Characteristics of Set
	1.	No Duplicates: A Set does not allow duplicate elements.
	2.	Unordered: Most implementations do not maintain the order of elements (except for LinkedHashSet and TreeSet).
	3.	Null Values: Set allows a single null element (except for TreeSet).

Types of Set Implementations

1. HashSet
	•	Characteristics:
	•	Implements the Set interface.
	    It will contains only unique elements,does not maintain insertion order,
	    Not synchronized and not thread safe
	    not allow duplicate value
	    Hashing technique to inject data into database
	•	Hashset internally use  HashMap.
	•	Unordered: Elements are stored based on their hash code, so the order is not guaranteed.
	•	Allows one null element.
	•	Performance:
	•	Constant-time performance for add, remove, and contains.
	•	Code Example:

Set<String> hashSet = new HashSet<>();
hashSet.add("Apple");
hashSet.add("Banana");
hashSet.add("Apple"); // Duplicate, ignored
System.out.println(hashSet); // Output: [Apple, Banana] (Order may vary)

2. LinkedHashSet
	•	Characteristics:
	•	Extends HashSet.
	•	Maintains insertion order of elements.
	•	Allows one null element.
	•	Performance:
	•	Slightly slower than HashSet due to the maintenance of insertion order.
	•	Code Example:

Set<String> linkedHashSet = new LinkedHashSet<>();
linkedHashSet.add("Apple");
linkedHashSet.add("Banana");
linkedHashSet.add("Cherry");
System.out.println(linkedHashSet); // Output: [Apple, Banana, Cherry]

3. TreeSet
	•	Characteristics:
	•	Implements the NavigableSet and SortedSet interfaces.
	•	Maintains elements in sorted order (natural ordering or via a custom comparator).
	•	Does not allow null elements.
	•	Performance:
	•	Operations like add, remove, and contains take O(log n) due to the underlying Red-Black Tree implementation.
	•	Code Example:

Set<Integer> treeSet = new TreeSet<>();
treeSet.add(20);
treeSet.add(10);
treeSet.add(30);
System.out.println(treeSet); // Output: [10, 20, 30]

Set Interface Methods

The Set interface inherits methods from the Collection interface. Key methods include:
	•	Basic Operations:
	•	add(E e): Adds an element to the set.
	•	remove(Object o): Removes the specified element.
	•	contains(Object o): Checks if the set contains the element.
	•	size(): Returns the number of elements.
	•	isEmpty(): Checks if the set is empty.
	•	clear(): Removes all elements.
	•	Bulk Operations:
	•	addAll(Collection<? extends E> c): Adds all elements from another collection.
	•	removeAll(Collection<?> c): Removes all elements from another collection.
	•	retainAll(Collection<?> c): Retains only the elements that are also in another collection.

Set Comparison Table

Implementation	Ordering	Duplicates	Null Values	Performance
HashSet	Unordered	No	Allows one	Fast (constant time)
LinkedHashSet	Insertion order	No	Allows one	Slightly slower
TreeSet	Sorted (natural/custom)	No	Not allowed	Slower (O(log n))

Use Cases of Set
	1.	HashSet:
	•	When you need to ensure uniqueness but don’t care about the order.
	•	Example: Storing unique IDs or email addresses.
	2.	LinkedHashSet:
	•	When you need to maintain the order of insertion.
	•	Example: Caching elements where insertion order is important.
	3.	TreeSet:
	•	When you need to store elements in a sorted order.
	•	Example: Storing sorted employee IDs or maintaining a sorted leaderboard.

Iterating Over a Set
	1.	Using forEach:

hashSet.forEach(System.out::println);


	2.	Using Iterator:

Iterator<String> iterator = hashSet.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}


	3.	Using Enhanced for Loop:

for (String element : hashSet) {
    System.out.println(element);
}

Conclusion
	•	Set is a fundamental part of the Java Collections Framework and ensures that elements are unique.
	•	Choose the specific implementation (HashSet, LinkedHashSet, or TreeSet) based on requirements like ordering, performance, and sorting.
 */
/*
Difference between alist and a set in java?
List allows duplicate elements where set does not
List maintain the order of elements while the set implementations (Hashset,Treeset)may or not maintain the order
ex:
HashSet does not maintain any order
LinkedHashSet maintain insertion order
Tree set maintain nature or custom sorted order

can a null elements be add to a set?
Hashset and linkedHashset allow a single null elements
Treeset does not allow null elements because it tries to sort elements.
if add throws a nullpointer exception when comparing null for other elements.


What happens if you try to add a duplicate elements to a set?
If you try to add a duplicate element the set will simple ignore the new elements and retain the existing one. no error will be throw.

HashSet set vs LinkedHashSet
HashSet
HashSet does not maintain insertion order
Hashset internally used HashMap
LinkeHashMap
LinkedHashMap maintain insertion order
LinkedHashMap internally used LinkedHashMap

How to HashSet internally work.
Internally it used a HAshMap to store its elements
1. The Hashset used a HashMap internally where each elements it stored as a key with a constant dummay value.
2. Hashcode of an elements determines the index of the bucket where it will be store.
3. Collision are handled by using Linked lists or balanced trees within the buckets.
4. Duplicate Check Using equals():
	•	Before adding an element, the HashSet checks if the element is already present using the equals() method.
	•	If an element with the same key exists, it does not add the duplicate.

 */
    /*
    What is TreeSet?
    It is sort the data
    Contains unique elements only its sort
    The data is the accending order
    not allow null values
    not allow to duplicate and not maintain insertion order
    Three set internally create TreeMap

    What is the time complexity of basic operation in a Treeset.
    Insertion,Removal and search operation in TreeSet have a time complexity ofO(logn) due to the underly red-black tree structure.

    TreeSet vs HashSet
    Here’s a comparison of TreeSet and HashSet in Java:

1. Overview

Aspect	TreeSet	HashSet
Implementation	Based on TreeMap (Red-Black Tree)	Based on HashMap
Order	Maintains elements in sorted order	Does not guarantee any specific order
Performance	Slower due to sorting (O(log n))	Faster for basic operations (O(1))

2. Key Differences

Feature	TreeSet	HashSet
Ordering	Maintains natural or custom order (via comparator).	No order is maintained (neither insertion nor sorting).
Performance	add(), remove(), and contains() take O(log n) due to the Red-Black Tree.	add(), remove(), and contains() take O(1) on average.
Null Elements	Does not allow null elements. Throws NullPointerException.	Allows one null element.
Usage Scenario	Use when sorted order is required.	Use when order is not important and performance is key.
Customization	Supports custom ordering with a Comparator.	No customization for ordering.

3. Similarities
	1.	Both Implement Set Interface:
	•	Both ensure that no duplicate elements are stored.
	2.	No Duplicates:
	•	Both rely on equals() to check for duplicate elements.
	3.	Thread-Safety:
	•	Neither TreeSet nor HashSet is thread-safe. Use Collections.synchronizedSet() or ConcurrentSkipListSet/ConcurrentHashMap for thread safety.

4. Examples

TreeSet Example:

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);

        System.out.println("TreeSet: " + treeSet); // Output: [1, 3, 5]
    }
}

HashSet Example:

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(1);
        hashSet.add(3);

        System.out.println("HashSet: " + hashSet); // Output: [3, 1, 5] (order not guaranteed)
    }
}

5. When to Use

Scenario	Recommended Set
You need elements in sorted order.	TreeSet
Order is not important, and you want speed.	HashSet
You want custom sorting.	TreeSet
You need to store null.	HashSet

6. Performance Comparison

Operation	TreeSet (O)	HashSet (O)
add()	O(log n)	O(1)
remove()	O(log n)	O(1)
contains()	O(log n)	O(1)
Iteration	O(n)	O(n)

Summary

Feature	TreeSet	HashSet
Use Case	Sorted and ordered data	Fast operations and unordered data
Order	Maintains order	No specific order
Performance	Slower due to sorting	Faster for basic operations
Null Handling	Does not allow null	Allows one null value

Choose TreeSet for sorted data needs and HashSet for faster, unordered storage.

     */


    public static class TreeSetDemo {
        public static void main(String[] args) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(5);
            treeSet.add(1);
            treeSet.add(3);

            System.out.println("TreeSet: " + treeSet); // Output: [1, 3, 5]
        }
    }

    public static class HashSetDemo {
        public static void main(String[] args) {
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(5);
            hashSet.add(1);
            hashSet.add(3);

            System.out.println("HashSet: " + hashSet); // Output: [3, 1, 5] (order not guaranteed)
        }
    }

/*
TreeSet vs TreeMap
Here is a detailed comparison between TreeSet and TreeMap in Java:

1. Overview

Aspect	TreeSet	TreeMap
Definition	Implements the Set interface.	Implements the Map interface.
Data Structure	Backed by a TreeMap internally.	Based on a Red-Black Tree (self-balancing).
Purpose	Used to store unique elements in a sorted order.	Used to store key-value pairs in sorted order of keys.

2. Key Differences

Feature	TreeSet	TreeMap
Interface Implemented	Implements the Set interface.	Implements the Map interface.
Data Stored	Stores only unique elements.	Stores key-value pairs.
Sorting	Maintains elements in natural order or custom order defined by a Comparator.	Maintains keys in sorted order (natural or custom). Values are not sorted.
Null Handling	Does not allow null elements.	Does not allow null keys, but allows null values.
Usage	Use when you need unique, sorted elements.	Use when you need key-value pairs sorted by keys.

3. Similarities
	1.	Tree-Based Structure:
	•	Both are implemented using a Red-Black Tree, which ensures sorted order and provides O(log n) time complexity for most operations.
	2.	Custom Sorting:
	•	Both can use a custom comparator for sorting.
	•	Example: new TreeSet<>(Comparator.reverseOrder()) or new TreeMap<>(Comparator.reverseOrder()).
	3.	Thread-Safety:
	•	Neither is thread-safe. Use Collections.synchronizedSet() or Collections.synchronizedMap() for thread safety.

4. Examples

TreeSet Example:

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);

        System.out.println("TreeSet: " + treeSet); // Output: [1, 3, 5]
    }
}

TreeMap Example:

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Apple", 3);
        treeMap.put("Banana", 5);
        treeMap.put("Cherry", 2);

        System.out.println("TreeMap: " + treeMap); // Output: {Apple=3, Banana=5, Cherry=2}
    }
}

5. Use Cases

Scenario	Recommended
Need unique elements in sorted order.	TreeSet
Need key-value pairs in sorted key order.	TreeMap
Need fast access to sorted elements.	TreeSet
Need fast access to sorted keys/values.	TreeMap

6. Performance

Operation	TreeSet (O)	TreeMap (O)
Add/Delete/Lookup	O(log n)	O(log n)
Iteration	O(n)	O(n)

7. Null Handling

Feature	TreeSet	TreeMap
Null Elements	Does not allow null elements.	Does not allow null keys but allows null values.
Example (TreeSet)	treeSet.add(null); → Throws NullPointerException.	N/A
Example (TreeMap)	treeMap.put(null, 1); → Throws NullPointerException.	treeMap.put("key", null); → Works.

8. Summary Table

Feature	TreeSet	TreeMap
Interface	Set	Map
Data Stored	Unique elements	Key-value pairs
Sorting	Natural/custom order	Keys in natural/custom order
Null Handling	No null elements	No null keys, but allows null values
Performance	O(log n) for basic operations	O(log n) for basic operations

Conclusion
	•	Use TreeSet when you need unique, sorted elements.
	•	Use TreeMap when you need a sorted map of key-value pairs.
 */


    public static class TreeSetDemos {
        public static void main(String[] args) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(5);
            treeSet.add(1);
            treeSet.add(3);

            System.out.println("TreeSet: " + treeSet); // Output: [1, 3, 5]
        }
    }

    public static class TreeMapDemo {
        public static void main(String[] args) {
            TreeMap<String, Integer> treeMap = new TreeMap<>();
            treeMap.put("Apple", 3);
            treeMap.put("Banana", 5);
            treeMap.put("Cherry", 2);

            System.out.println("TreeMap: " + treeMap); // Output: {Apple=3, Banana=5, Cherry=2}
        }
    }

/*
What happen if you try to add null to a TreeSet
If you try to add a null element to a TreeSet in Java, a NullPointerException will be thrown.
Reason
	1.	Sorting Requirement:
	•	A TreeSet internally uses a Red-Black Tree to maintain elements in sorted order.
Violation of Contract:
	•	TreeSet does not permit null because it cannot ensure proper ordering, as null does not have a defined order with respect to other non-null elements.

 */


    public static class TreeSetNullExample {
        public static void main(String[] args) {
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Add elements to the TreeSet
            treeSet.add(10);
            treeSet.add(20);

            try {
                treeSet.add(null); // This will throw NullPointerException
            } catch (NullPointerException e) {
                System.out.println("Exception: " + e);
            }

            System.out.println("TreeSet: " + treeSet); // Output: [10, 20]
        }
    }

/*
HashSet vs. TreeSet:
	•	HashSet allows a single null element because it does not rely on ordering, but
	     TreeSet always enforces sorting, which makes null invalid.
 */

//Longest Substring using Sliding Window technique
public static class LongestSubString {
    public static void main(String[] args) {
        String str = "abcabcbb";
        LongestSubString output = new LongestSubString();
        int result = output.longSubString(str);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }

    private int longSubString(String str) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            // If the character at the right pointer is already in the set, remove characters from the left
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }

            // Add the character at the right pointer to the set
            set.add(str.charAt(right));

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

    public static class DuplicateElements {
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 1, 2, 4, 5};

            // Use a Set to track unique elements
            Set<Integer> uniqueElements = new HashSet<>();
            int j = 0;

            for (int i = 0; i < arr.length; i++) {
                if (!uniqueElements.contains(arr[i])) {
                    uniqueElements.add(arr[i]);
                    arr[j++] = arr[i];
                }
            }

            // Print the array without duplicates
            for (int i = 0; i < j; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    public static class D1 {
        public static void main(String[] args) {
            Set<Integer> a = new HashSet<>(Arrays.asList(1, 3, 2, 4, 8, 9, 0));
            Set<Integer> b = new HashSet<>(Arrays.asList(1, 3, 7, 5, 4, 0, 7, 5));

            System.out.println("Elements in a: " + a);
            System.out.println("Elements in b: " + b);

            Set<Integer> union = new HashSet<>(a);
            union.addAll(b);
            System.out.println("UNION: " + union);

            Set<Integer> intersection = new HashSet<>(a);
            intersection.retainAll(b);//Retain only common elements
            System.out.println("INTERSECTION: " + intersection);

            Set<Integer> symmetricDifference = new HashSet<>(union);
            symmetricDifference.removeAll(intersection);
            System.out.println("SYMMETRIC DIFFERENCE: " + symmetricDifference);
        }
    }


    public static class ReverseVowelOfString {
        public static void main(String[] args) {

            ReverseVowelOfString solution = new ReverseVowelOfString();
            // Example 1
            String input1 = "IceCreAm";
            String output1 = solution.reverseVowels(input1);
            System.out.println("Input: " + input1);
            System.out.println("Output: " + output1);

            // Example 2
            String input2 = "leetcode";
            String output2 = solution.reverseVowels(input2);
            System.out.println("Input: " + input2);
            System.out.println("Output: " + output2);
        }

        private String reverseVowels(String s) {
            char[] ch=s.toCharArray();
            System.out.println("Character Array: " + java.util.Arrays.toString(ch)); // Print the character array
            Set<Character>vowels=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
            int left=0;
            int right=ch.length-1;
            while (left<right){
                while (left<right&&!vowels.contains(ch[left])){
                    left++;
                }
                while (left<right&&!vowels.contains(ch[right])){
                    right--;
                }
                if(left<right){
                    char temp=ch[left];
                    ch[left]=ch[right];
                    ch[right]=temp;
                    left++;
                    right--;
                }
            }
            return new String(ch);

        }
    }









    /*
    MAP
   Key Points about Map in Java:
	1.	Definition:
	•	Map is an interface in the Java Collections Framework that represents a collection of key-value pairs.
	2.	Key Characteristics:
	•	Each key in a Map must be unique.
	•	Values, however, can be duplicated.
	•	If you try to add a duplicate key, the new value replaces the old value associated with that key.
	3.	Handling null:
	•	In most implementations (e.g., HashMap), you can have:
	•	At most one null key.
	•	Multiple null values.
	4.	Implementations:
	•	Common classes implementing Map include:
	•	HashMap: Unordered, allows one null key and multiple null values.
	•	LinkedHashMap: Maintains insertion order, allows one null key.
	•	TreeMap: Sorted by keys (natural ordering or a custom comparator), does not allow null keys.
	•	Hashtable: Synchronized, does not allow null keys or null values.

     */
    public static class Maps{
        public static void main(String[] args) {
            Map<String, Integer> map = new HashMap<>();
            /*
            	Key Characteristics:
	•	Each key in a Map must be unique.
	•	Values, however, can be duplicated.
	•	If you try to add a duplicate key, the new value replaces the old value associated with that key.
             */
            map.put("Apple", 1);
            map.put("Banana", 2);
            map.put("Orange", 3);
            map.put("Orange", 1);

// Retrieve value by key
            System.out.println(map);
            int value = map.get("Banana");  // Returns 2
            System.out.println(value);
        }

    }


    public static class MapExample {
        public static void main(String[] args) {
            // Example with HashMap
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("key1", "value1");
            hashMap.put("key2", "value2");
            hashMap.put("key1", "newValue1"); // Replaces the previous value for "key1"
            hashMap.put(null, "nullValue");  // Allows one null key
            hashMap.put("key3", null);      // Allows multiple null values

            System.out.println("HashMap: " + hashMap);

            // Example with LinkedHashMap (maintains insertion order)
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("key1", "value1");
            linkedHashMap.put("key2", "value2");
            linkedHashMap.put("key1", "newValue1");
            linkedHashMap.put(null, "nullValue");
            linkedHashMap.put("key3", null);

            System.out.println("LinkedHashMap: " + linkedHashMap);

            // Example with TreeMap (sorted, does not allow null keys)
            Map<String, String> treeMap = new TreeMap<>();
            treeMap.put("key1", "value1");
            treeMap.put("key2", "value2");
            treeMap.put("key1", "newValue1");
            // treeMap.put(null, "nullValue"); // Throws NullPointerException

            System.out.println("TreeMap: " + treeMap);
        }
    }
/*
### Q. Difference between `HashMap` and `HashTable`.
- **HashMap**:
  1. Not synchronized, not thread-safe (better performance).
  2. Allows `null` for both key and value.(key use only one null and value use multiple)
  3. Non-legacy class.
  4. Introduced in JDK 1.2.

- **HashTable**:
  1. Synchronized, thread-safe (poor performance).
  2. Does not allow `null` for key or value.
  3. Legacy class.
  4. Introduced in JDK 1.1.

   How does `HashMap` work internally?
- HashMap internally works similar to a `HashTable`.
- Example:
  ```java
  HashMap<String, Integer> map = new HashMap<>();
  map.put("xyz(key)", 32(value));
  ```

- In Java 8, `HashMap` replaces `LinkedList` with a binary tree when the number of elements in a bucket exceeds a threshold.
- While converting the list to a binary tree, the hash code is used as a branching variable.

    - **Initial Capacity (IC)** = 16
    - **Load Factor (LF)** = 0.75
    - **Hashing Calculation**: IC * LF = 16 * 0.75 = 12
    - At the 12th key-value pair, `HashMap`'s capacity will double to 32.

What is Hashing?

Hashing is a way to store data in a HashMap using a special function (hash function)
that converts a key (like a number or a word) into a unique number (called a hash code).
This number tells the HashMap where to save or find the data quickly.

What is Rehashing?

Rehashing happens when a HashMap gets too full.
The size of the map is increased, and all the data is rearranged (rehashed) to
fit into the new size. This helps keep the HashMap fast for adding and finding data.

Q. How do you iterate over a Map in Java?
1. **Using `entrySet()` for key-value pairs**:
   ```java
   for (Map.Entry<String, Integer> entry : map.entrySet()) {
       System.out.println(entry.getKey() + " : " + entry.getValue());
   }
   ```
2. **Using `keySet()` to iterate over keys**:
   ```java
   for (String key : map.keySet()) {
       System.out.println(key);
   }
   ```
3. **Using `values()` to iterate over values**:
   ```java
   for (Integer value : map.values()) {
       System.out.println(value);
   }

   ### Q. Difference between `keySet()`, `entrySet()`, and `values()` in a `Map`?
- `keySet()`: Returns a set of all keys.
- `entrySet()`: Returns a set of key-value pairs (entries).
- `values()`: Returns a collection of all values.

 Q. How to sort a `HashMap` by values?
- Convert `HashMap` to a list and sort using a comparator:
  ```java
  Map<String, Integer> map = new HashMap<>();
  map.put("Apple", 2);
  map.put("Banana", 1);
  map.put("Orange", 3);

  List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
  list.sort(Map.Entry.comparingByValue());

  for (Map.Entry<String, Integer> entry : list) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
  }


### Q. What happens if two keys have the same `hashCode` in `HashMap`?
- Both keys are placed in the same bucket, and the `equals()` method is used to differentiate them.
- In Java 8+, if collisions occur, entries are stored in a balanced tree, reducing lookup time.

### Q. What is the load factor in `HashMap`?
- The load factor measures how full the `HashMap` can get before resizing.
- Default load factor is 0.75, meaning when 75% of the capacity is filled, `HashMap` will resize (usually doubling the bucket size).

 */


    public static class MapIterationExamples {
        public static void main(String[] args) {
            // Creating a Map
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "One");
            map.put(2, "Two");
            map.put(3, "Three");

            System.out.println("1. Using entrySet() and a for-each loop:");
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            System.out.println("\n2. Using keySet() and a for-each loop:");
            for (Integer key : map.keySet()) {
                System.out.println("Key: " + key + ", Value: " + map.get(key));
            }

            System.out.println("\n3. Using values() to iterate only over values:");
            for (String value : map.values()) {
                System.out.println("Value: " + value);
            }

            System.out.println("\n4. Using Java 8's forEach() with Lambda:");
            map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        }
    }

    public static class FrequencyOccurency {
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 1, 2, 3, 4, 5, 6, 5, 4};
            Map<Integer, Integer> frequencyOcc = frequencyOcc(arr);
            System.out.println("Frequency Occurence:" + frequencyOcc);
        }

        private static Map<Integer, Integer> frequencyOcc(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return map;
        }
    }
    public static class FirstNonRepeating {
        public static int[] firstNonRepeating(int[] nums) {
            // HashMap to store frequency of each number
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            // Populate the frequency map
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            // Find the first non-repeating number and its index
            for (int i = 0; i < nums.length; i++) {
                if (frequencyMap.get(nums[i]) == 1) {
                    return new int[]{i, nums[i]}; // Return index and element
                }
            }

            // If no non-repeating number found, return -1 for both
            return new int[]{-1, -1};
        }

        public static void main(String[] args) {
            int[] nums1 = {2, 3, 4, 2, 4};
            int[] nums2 = {3, 5, 3, 5, 2, 4, 4, 2};

            int[] result1 = firstNonRepeating(nums1);
            int[] result2 = firstNonRepeating(nums2);

            System.out.println("First non-repeating in nums1: Index = " + result1[0] + ", Element = " + result1[1]);
            System.out.println("First non-repeating in nums2: Index = " + result2[0] + ", Element = " + result2[1]);
        }
    }
    public static class LongestHarmonicSubsequence{
        public static void main(String[] args) {
            int[] arr = {1, 3, 2, 2, 5, 2, 3, 7};
LongestHarmonicSubsequence output=new LongestHarmonicSubsequence();
                int result=output.longestHarSubseq(arr);
            System.out.println("Result "+result);
        }

        private static int longestHarSubseq(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num:arr){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            int maxLen=0;
            for (int key:map.keySet()){
                if (map.containsKey(key + 1)) {
                   int curLen=map.get(key)+map.get(key+1);
                    maxLen=Math.max(maxLen,curLen);
                }
            }
            return maxLen;
        }
    }
    public static class MostFreq {
        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 2, 2, 3, 4, 1, 5};
            MostFreq mostFreq = new MostFreq();
            List<Integer> output = mostFreq.mostFreqElements(nums);
            System.out.println("Most Frequent Elements: " + output);
        }

        private List<Integer> mostFreqElements(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            // Count the frequency of each number
            for (int x : nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            // Find the maximum frequency
            int max = 0;
            for (int count : map.values()) {
                if (count > max) {
                    max = count;
                }
            }

            // Collect elements with the maximum frequency
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    list.add(entry.getKey());
                }
            }
            return list;
        }
    }
    public static class AnagramCheck {
        public static void main(String[] args) {
            AnagramCheck check = new AnagramCheck();
            String s1 = "anagram";
            String t1 = "nagaram";
            System.out.println(check.isAnagram(s1, t1)); // Output: true

            String s2 = "rat";
            String t2 = "car";
            System.out.println(check.isAnagram(s2, t2)); // Output: false
        }

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            Map<Character, Integer> countMapS = new HashMap<>();
            Map<Character, Integer> countMapT = new HashMap<>();

            for (char c : s.toCharArray()) {
                countMapS.put(c, countMapS.getOrDefault(c, 0) + 1);
            }

            for (char c : t.toCharArray()) {
                countMapT.put(c, countMapT.getOrDefault(c, 0) + 1);
            }

            return countMapS.equals(countMapT);
        }
    }

    public static class FreOcurrs {
        public static void main(String[] args) {
            String str = "anbadbeaaa";

            Map<Character, Integer> map = new HashMap<>();
            //The toCharArray() method in Java is a built-in method of the String class.
            // It is used to convert a String into a character array (char[]),
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(0, 1) + 1);
            }
            System.out.println("Freq::" + map);
        }
    }

    public static class FreOcurrsJava8 {
        public static void main(String[] args) {
            String str = "anbadbeaaa";

            // Count the frequency of each character
            Map<Character, Long> charFrequency = str.chars()
                    .mapToObj(c -> (char) c) // Convert each int (ASCII) to a Character
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Group and count

            // Print the frequency map
            System.out.println(charFrequency);
        }
    }
    public static class Sum {
        public static void main(String[] args) {
            Sum sum = new Sum();
            int[] nums = {2, 7, 11, 15};
            int target = 17;

            int[] output = sum.sums(nums, target);
            if (output != null) {
                System.out.println("Indices: [" + output[0] + ", " + output[1] + "]");
            } else {
                System.out.println("No two sum solution found.");
            }
        }

        private int[] sums(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    // Return the indices of the two numbers
                    return new int[]{map.get(diff), i};
                }
                // Add the current number and its index to the map
                map.put(nums[i], i);
            }
            // Return null if no solution is found
            return null;
        }

    }

    public static class LongestRepeatedChar {
        public static void main(String[] args) {
            LongestRepeatedChar longestRepeatedChar = new LongestRepeatedChar();
            String str = "ABAB";
            int k = 2;
            int maxLength = longestRepeatedChar.longestRepCha(str, k);
            System.out.println(maxLength); // Print the length of the longest substring
        }

        public int longestRepCha(String str, int k) {
            Map<Character, Integer> countMap = new HashMap<>();
            int maxCount = 0;
            int left = 0;
            int maxLength = 0;

            for (int right = 0; right < str.length(); right++) { // Fixed variable name from s to str
                char currentChar = str.charAt(right);
                countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);

                maxCount = Math.max(maxCount, countMap.get(currentChar));

                // Window size is (right - left + 1)
                // Number of characters to replace is (window size - count of the most frequent character)
                if (right - left + 1 - maxCount > k) {
                    char leftChar = str.charAt(left);
                    countMap.put(leftChar, countMap.get(leftChar) - 1);
                    left++;
                }

                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }

    public static class GroupAnagrams {
        public static void main(String[] args) {
            GroupAnagrams groupAnagrams = new GroupAnagrams();
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> result = groupAnagrams.groupAnagrams(strs);
            System.out.println(result);
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> anagramMap = new HashMap<>();

            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedStr = new String(charArray);

                if (!anagramMap.containsKey(sortedStr)) {
                    anagramMap.put(sortedStr, new ArrayList<>());
                }

                anagramMap.get(sortedStr).add(str);
            }

            return new ArrayList<>(anagramMap.values());
        }
    }
    public static class NumIdenticalPairs {
        public int numIdenticalPairs(int[] nums) {
            // Create a hashmap to store the frequency of each number
            HashMap<Integer, Integer> map = new HashMap<>();
            int goodPairs = 0; // Variable to count the number of good pairs

            System.out.println("Initial nums array: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Iterate through the array
            for (int num : nums) {
                // Check if the number already exists in the map
                if (map.containsKey(num)) {
                    // Print when we find a pair
                    System.out.println("Found duplicate of: " + num);
                    // Add the current count of this number to goodPairs (i.e., the count of previous occurrences)
                    goodPairs += map.get(num);
                    System.out.println("Number of good pairs so far: " + goodPairs);
                }

                // Update the count of this number in the map
                map.put(num, map.getOrDefault(num, 0) + 1);
                System.out.println("Updated frequency map: " + map);
            }

            System.out.println("Final number of good pairs: " + goodPairs);
            return goodPairs;
        }

        // Main method to run the solution
        public static void main(String[] args) {
            NumIdenticalPairs solution = new NumIdenticalPairs();

            // Test case 1
            int[] nums1 = {1, 2, 3, 1, 1, 3};
            System.out.println("Test Case 1:");
            int result1 = solution.numIdenticalPairs(nums1);
            System.out.println("Output: " + result1);

            // Test case 2
            int[] nums2 = {1, 1, 1, 1};
            System.out.println("Test Case 2:");
            int result2 = solution.numIdenticalPairs(nums2);
            System.out.println("Output: " + result2);

            // Test case 3
            int[] nums3 = {1, 2, 3};
            System.out.println("Test Case 3:");
            int result3 = solution.numIdenticalPairs(nums3);
            System.out.println("Output: " + result3);
        }
    }
    public static class MinimumWindowSubstring {
        public static void main(String[] args) {
            MinimumWindowSubstring solution = new MinimumWindowSubstring();
            String s = "ADOBECODEBANC";
            String t = "ABC";
            String result = solution.minWindow(s, t);
            System.out.println(result); // Output: "BANC"
        }

        public String minWindow(String s, String t) {
            if (s.length() < t.length()) return "";

            Map<Character, Integer> requiredCount = new HashMap<>();
            for (char c : t.toCharArray()) {
                requiredCount.put(c, requiredCount.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> windowCount = new HashMap<>();
            int left = 0, right = 0, formed = 0;
            int minLength = Integer.MAX_VALUE;
            String minWindow = "";

            while (right < s.length()) {
                char c = s.charAt(right);
                windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

                if (requiredCount.containsKey(c) &&
                        windowCount.get(c).intValue() == requiredCount.get(c).intValue()) {
                    formed++;
                }

                while (left <= right && formed == requiredCount.size()) {
                    c = s.charAt(left);

                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        minWindow = s.substring(left, right + 1);
                    }

                    windowCount.put(c, windowCount.get(c) - 1);
                    if (requiredCount.containsKey(c) &&
                            windowCount.get(c).intValue() < requiredCount.get(c).intValue()) {
                        formed--;
                    }

                    left++;
                }

                right++;
            }

            return minWindow;
        }
    }

    public static class FindShortestSubArray {
        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, Integer> count = new HashMap<>();   // To store the frequency of each number
            HashMap<Integer, Integer> first = new HashMap<>();   // To store the first occurrence index of each number
            HashMap<Integer, Integer> last = new HashMap<>();    // To store the last occurrence index of each number

            int degree = 0;  // Initialize degree of the array

            // Iterate through the array to fill the maps
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                count.put(num, count.getOrDefault(num, 0) + 1);
                if (!first.containsKey(num)) {
                    first.put(num, i);  // Record the first occurrence of num
                }
                last.put(num, i);  // Update the last occurrence of num

                // Update degree with the maximum frequency
                degree = Math.max(degree, count.get(num));
            }

            // Print the frequency count map
            System.out.println("Count map: " + count);
            // Print the first and last occurrence maps
            System.out.println("First occurrence map: " + first);
            System.out.println("Last occurrence map: " + last);
            // Print the degree of the array
            System.out.println("Degree of the array: " + degree);

            int minLength = nums.length;  // Initialize minimum length as the entire array size

            // Now iterate over the elements to find the smallest subarray with the same degree
            for (int num : count.keySet()) {
                if (count.get(num) == degree) {
                    // Calculate the length of the subarray that contains this number with the same degree
                    int subArrayLength = last.get(num) - first.get(num) + 1;
                    // Print the length of the subarray
                    System.out.println("Subarray length for number " + num + ": " + subArrayLength);
                    minLength = Math.min(minLength, subArrayLength);
                }
            }

            // Print the minimum length of the subarray found
            System.out.println("Minimum length of subarray with same degree: " + minLength);

            return minLength;
        }

        public static void main(String[] args) {
            FindShortestSubArray solution = new FindShortestSubArray();

            // Test case 1
            int[] nums1 = {1, 2, 2, 3, 1};
            System.out.println("Test case 1: ");
            System.out.println("Result: " + solution.findShortestSubArray(nums1));  // Expected output: 2

            // Test case 2
            int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
            System.out.println("Test case 2: ");
            System.out.println("Result: " + solution.findShortestSubArray(nums2));  // Expected output: 6
        }
    }
    /*
    HashTable Internal Working
- **HashTable** is synchronized and thread-safe.
- Stores content as key-value pairs.
- Any non-null object can be used as a key or a value.

  Example:
  ```java
  class A {
      public static void main() {
          HashTable<Integer, String> h = new HashTable<>();
          h.put(100, "abc");
          h.put(101, "dbc");
          System.out.println(h);
      }
  }
     */

/*
1. What is ConcurrentHashMap, and how does it work?

ConcurrentHashMap is a thread-safe and high-performance implementation of the Map interface in the java.util.concurrent package. It is specifically designed for concurrent applications, allowing multiple threads to read and write simultaneously without compromising data integrity.
	•	How It Works:
	•	It uses fine-grained locking (bucket-level or segment-based locking in Java 7, and internal table-based locking in Java 8+).
	•	Instead of locking the entire map, it locks only specific parts (buckets) to allow better concurrency.
	•	Reads are mostly lock-free, while updates are thread-safe due to internal synchronization mechanisms.
	•	Iterators are fail-safe, allowing modifications during iteration without throwing ConcurrentModificationException.

2. What is the difference between ConcurrentHashMap and HashMap or Hashtable?

Feature	HashMap	Hashtable	ConcurrentHashMap
Thread Safety	Not thread-safe	Thread-safe	Thread-safe
Performance	High in single-threaded apps	Low due to global locking	High due to fine-grained locking
Null Keys/Values	Allows one null key and multiple null values	Does not allow null keys/values	Does not allow null keys/values
Iteration	Fail-fast	Fail-fast	Fail-safe
Locking	None	Locks the entire map	Locks specific buckets or entries
Concurrency	Poor in multi-threaded apps	Poor due to single lock	Excellent

3. How does ConcurrentHashMap achieve thread safety?

Mechanism:
	1.	Fine-Grained Locking:
	•	In Java 7, ConcurrentHashMap divided the map into segments (default: 16). Each segment could be locked independently, allowing concurrent access.
	•	In Java 8+, it replaced segments with a concurrent hash table where individual buckets or groups of buckets are locked during updates.
	2.	Atomic Operations:
	•	Uses atomic methods like putIfAbsent(), computeIfAbsent(), and replace() to ensure thread-safe modifications without external synchronization.
	3.	Non-Blocking Reads:
	•	For reads, ConcurrentHashMap avoids locking entirely by using volatile variables and atomic operations like CAS (Compare-And-Swap).
	4.	Fail-Safe Iterators:
	•	Iterators work on a snapshot of the data structure and do not throw ConcurrentModificationException.

4. Explain the importance of atomic operations in ConcurrentHashMap.

Atomic operations are crucial for maintaining data consistency and integrity in multi-threaded environments. ConcurrentHashMap provides several atomic methods that eliminate the need for explicit locking or synchronization:
	•	putIfAbsent(K key, V value):
	•	Ensures the key-value pair is added only if the key is not already present.
	•	replace(K key, V oldValue, V newValue):
	•	Replaces the value for a key only if it is currently mapped to the specified oldValue.
	•	computeIfAbsent(K key, Function mappingFunction):
	•	Computes a value for a key and inserts it if the key is absent.

Why Important:
	•	They help achieve thread-safe updates without impacting performance significantly.
	•	Prevent race conditions by ensuring only one thread can modify a key at a time.

5. Why doesn’t ConcurrentHashMap allow null keys or values?

Reasons:
	1.	Ambiguity in get() and containsKey():
	•	If null is allowed as a key or value, it becomes ambiguous whether null returned by get() means the key is present with a null value or the key is absent.
	2.	Thread Safety:
	•	Allowing null keys/values can lead to race conditions during concurrent updates or reads, as the map cannot differentiate between null as a value and an uninitialized state.
	3.	Design Philosophy:
	•	ConcurrentHashMap enforces stricter rules to avoid potential bugs in concurrent programming.
	•	This contrasts with HashMap, which is more permissive but not thread-safe.

Summary Table:

Question	Answer
What is ConcurrentHashMap?	A thread-safe, high-performance Map implementation for concurrent applications.
Difference with HashMap/Hashtable?	Allows better concurrency with fine-grained locking; no null keys/values; fail-safe iterators.
How does it ensure thread safety?	Fine-grained locking, atomic operations, non-blocking reads, and fail-safe iterators.
Importance of atomic operations?	Prevents race conditions, ensures thread-safe updates, and avoids explicit synchronization.
Why no null keys/values?	To avoid ambiguity, prevent race conditions, and ensure consistency in concurrent environments.
 */
    public static class ConcurrentHashMaps{
        public static void main(String[] args) {
            //concurrent hashmap is a thread safe and high performance implementation of the map interface part of the java.util.concurrent package.
            //concurrent Hashmap does not permit null key or value;
            //uses a technique called bucket-level location or segment-based locking
 Map<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();
 concurrentHashMap.put("A", 1);
 concurrentHashMap.put("B",2);
 concurrentHashMap.put("C",3);
            Thread thread1 =new Thread(()->{
                concurrentHashMap.put("D",4);
                System.out.println("Thread 1: Added D->4");

            });
            Thread thread2 =new Thread(()->{
                Integer b = concurrentHashMap.get("B");
                System.out.println("Thread 2: Added B->4"+b);

            });

thread1.start();
thread2.start();
try {
    thread1.join();
    thread2.join();
}catch (InterruptedException e){
    e.printStackTrace();
}
//It provides atomic methods such as putIfAbsent(),replace(),computeIfAbsence()
concurrentHashMap.putIfAbsent("A",10);
            System.out.println("After putIfAbsent :A->"+concurrentHashMap.get("A"));
            concurrentHashMap.replace("B",20);
            System.out.println("After replace :B->"+concurrentHashMap.get("B"));
            System.out.println("Map entry");
//The iterators of concurrent HashMap are fail-safe ,meaning they do not throw a concurrent modification Exception
//If the map is modification during iteration.
//The iterators of concurrentHashMap are fail-safe, meaning they do not throw a concurrent modification exception if the map is modified during iteration.
            concurrentHashMap.forEach((key,value)-> System.out.println(key+"->"+value));

        }
    }
    /*
    ### Q. How does `LinkedHashMap` maintain the order of elements?
- `LinkedHashMap` maintains a doubly-linked list of entries, preserving the insertion order or access order.

     */

    public static class FirstNonRepeatingCharacter {
        public static void main(String[] args) {
            String str = "swiss";
            System.out.println(findFirstNonRepeatingCharacter(str));
        }

        private static char findFirstNonRepeatingCharacter(String str) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            throw new RuntimeException("No non-repeating character found");
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
    public static class A2 {
        public static void main(String[] args) {

            Map<Integer, String> map = new TreeMap<>();
            //TreeMap is key-value pair
            map.put(2,"re");
            map.put(1,"req");
            map.put(3,"aq");
            //not thread safe and not synchronized
            //sorting data in accenting order
            System.out.println(map);
            try{
                map.put(null,"fr");
            }catch (NullPointerException e){
                System.out.println(e+"if add null in treemap ");
            }
            map.put(4,null);
            map.put(5,null);
            //treemap allow multiple null values
            System.out.println(map);

            for (Map.Entry<Integer,String >entry:map.entrySet()){
                System.out.println("key:"+entry.getKey()+"Value:"+entry.getValue());
            }
        }
    }
}
