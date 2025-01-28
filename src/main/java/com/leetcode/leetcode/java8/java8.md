>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Java 8 Features>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

1. Functional Interface
2. Lambda Expression
3. Default Keyword
4. Optional Class
5. Stream API

Q. Difference between java 7 and java8?
Here’s a markdown version of the comparison:

# Difference Between Java 7 and Java 8

Java 7 and Java 8 introduced significant changes to the Java programming language. Below is a comparison of the two:

## Key Differences

| **Feature/Area**            | **Java 7**                                                                                   | **Java 8**                                                                                     |
|-----------------------------|------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| **Lambda Expressions**      | Not available.                                                                          | Introduced Lambda Expressions, enabling functional programming and cleaner code.          |
| **Stream API**              | Not available.                                                                          | Introduced for processing collections and streams of data using a functional approach.    |
| **Default and Static Methods in Interfaces** | Not available.                                                                          | Introduced default and static methods in interfaces to provide method implementations.    |
| **Functional Interfaces**   | Not emphasized.                                                                         | Introduced `@FunctionalInterface` for defining single-abstract-method (SAM) interfaces.   |
| **Date and Time API**       | Relied on `java.util.Date` and `java.util.Calendar`, which were cumbersome to use.       | Introduced a new `java.time` package for handling date and time with improved APIs.       |
| **Type Inference**          | Limited type inference in diamond operators for generics.                               | Enhanced type inference for lambda expressions and improved type checking.               |
| **Nashorn JavaScript Engine** | Not available.                                                                          | Introduced Nashorn, a high-performance JavaScript runtime to run JavaScript within Java.  |
| **Optional Class**          | Not available.                                                                          | Introduced `java.util.Optional` to handle null checks and avoid `NullPointerException`.   |
| **Streams and Collectors**  | Not available.                                                                          | Added `Stream` and `Collectors` for functional-style operations on data.                 |
| **Method References**       | Not available.                                                                          | Introduced method references to simplify lambda expressions.                             |
| **Parallelism**             | No dedicated support for parallel data processing.                                       | Introduced parallel streams for parallel data processing using multiple CPU cores.        |
| **PermGen Space**           | Still used for storing metadata about classes and methods.                              | Replaced `PermGen` with `Metaspace` for improved memory management.                      |
| **Try-With-Resources**      | Introduced to automatically close resources that implement the `AutoCloseable` interface.| Same as Java 7 but more effective with the use of lambdas.                               |
| **String in Switch**        | Introduced the ability to use `String` in `switch` statements.                          | Same as Java 7.                                                                           |
| **Fork/Join Framework**     | Introduced for parallel task execution but required more manual handling.               | Works seamlessly with parallel streams.                                                  |

## Summary

- **Java 7**: Focused on enhancements to existing features, such as try-with-resources and diamond operators.
- **Java 8**: A major release introducing groundbreaking features like functional programming (Lambda, Stream API), and a new date-time API, transforming modern Java development.
1. Functional Interface
   a. A Functional Interface is an interface that contains only one abstract method(Incomplete method).
   b. It is also known as SAM Interface(Single Abstract Method)
   c. A Functional Interface can have any number of default and static method.
   Exam: Runnable, Camparable, ActionListener
   d. Lambda Expressions can be used and executted by representing the interface with an annotation called @FunctionalInterface.
   e. @Functional Interface annotation is used to ensure that the functional interface can not more than one abstract method.
   Ex: 1
   @FunctionalInterface
   public interface A {
   public void test();
   }

Ex:2
@FunctionalInterface
public interface A {
public void test();
public void test1();
}//error

2. Lambda Expression
   -> Lambda Expression is mainly used to implement functional interface.
   -> Lambda Expression is an anonymous function.
   -> It is a function without name and does not belongs to any class.
   -> It reduces the line of java code. but the drawback is it make the code less readable.
   -> Lambda expression implement the only abstract function and therefore implement functional interface.
3. Why are use Lambda expression?
   Facilitates Functional programming.
   ->To provided the implementation of the java 8 functional Interface.
   ->Reduce lines of code.
   ->Passing behavious into method.
4. Write a java Lambda Expression to create Thread.
   ->The Runnable interface is a functional interface so we can use Lambda Expression to implement Runnable functional interface.

Ex1.
@FunctionalInterface
public interface A {
public void test();
}

public class A1 {
public static void main(String[] args) {
A a=()->{
System.out.println(100);
System.out.println(355);
};
a.test();
}
}

Ex2:
@FunctionalInterface
public interface B {
public void test(int a,int b);
}
public class B1 {
public static void main(String[] args) {
B b1=(int a,int b)->{
System.out.println(a);
System.out.println(b);

        };
        b1.test(1,2);
    }
}

Ex3:
@FunctionalInterface
public interface C {
public int multiple(int x,int b);
}
public class C1 {
public static void main(String[] args) {
C c=(a,b)->a*b;
System.out.println(c.multiple(1,4));
}
}

Ex4:
@FunctionalInterface
public interface D {
public int add(int a, int b);
}

public class D1 {
public static void main(String[] args) {
D d1=(a,b)->a+b;
System.out.println(d1.add(4,9));
}
}

Ex5:
@FunctionalInterface
public interface E {
public int add(int a,int b);
}
public class E1 {
public static void main(String[] args) {
E e1=(int a, int b)->a+b;
System.out.println(e1.add(4,9));
}
}

Ex6:
@FunctionalInterface
public interface Square {
public int square(int x);
}
public class Square1 {
public static void main(String[] args) {
Square square=(int a)->a*a;
System.out.println(square.square(4));}
}

Ex7:
class Test{
main(){
ArrayList<Integer>a=new ArrayList<Integer>();
a.add(1);
a.add(2);
a.add(3);
a.add(4);
a.forEach((n)->syso(n));
a.forEach((n)->{if(n%2==0)syso(n);});


    }
}

Optional Class
->Optional class handle null pointer Exception.
empty()-> Returns an empty optional instance
of(T value)-> Returns an optional with the specified present non-null value.
ofNullable(T value)->Returns an optional describing the specified value, if non-null,other wise returns an empty optional.

1. public class A {
   int x=10;
   static A a1;
   public static void main(String[] args) {
   try{
   System.out.println(a1.x);
   }catch (Exception e){
   e.printStackTrace();
   }
   System.out.println(100);
   }
   }

2. public class B {
   int x=10;
   static B b1;
   public static void main(String[] args) {
   Optional<B>b=Optional.ofNullable(b1);
   System.out.println(b.isPresent());
   System.out.println(100);

   }
   }

3.
public class C {
int c=100;
public static void main(String[] args) {
C c1=null;
Optional<C>c2=Optional.ofNullable(c1);
System.out.println(c2.isPresent());
System.out.println(122);
}
}

4. Default Keyword
   ->using default keyword we can created complete mmethods inside an interface.
   Note:A functional interface should consist exactly one incomplete method but can have any number of complete method in it.

Ex1;
@FunctionalInterface
public interface A {
public void test1(int x);
default void test2(){
System.out.println(2);
}
default void test3(){
System.out.println(3);
}
}


public class B implements A{
@Override
public void test1(int x) {
System.out.println(x);
}



    public static void main(String[] args) {
        B b1=new B();
        b1.test1(1);
        b1.test2();
        b1.test3();
    }
}

Ex2:
@FunctionInterface
public interface Test {
public void test1(int x);
default void test2(){
System.out.println(100);
}
default void test3(){
System.out.println(200);
}
}
public class Main {
public static void main(String[] args) {
Test test=(int x)->{
System.out.println(x);
};
test.test1(1);
test.test2();
test.test3();
}
}

->In an Interface  we can add main method.
public interface A{
int x=10;
main(){
sout(A.x)
}
}
->We can develop complete static method in an interface.
public interface A{
int x=10;
main(){
sout(A.x);
A.test();
}
public static void test(){
sout(100);
}
}


5. STREAM API
   -> It helps us manipulate collection.
   ->A stream is a sequence of objects that supports various method.
   ->stream() method used and stream is not a dstastructure.
   stream s=c.stream()-> present java .util.package
   Q. How to Stream working internally
   -> To filter out from the objects we do have a function name filter()
   -> To collect elements we will be using Collectors.toList() to collect all the required elements.

They are listed and as follows:
1. Sequence of Elements
2. Source
3. Aggregate Opteration
4. Pipelining
5. Internal iteration

1. INTERMEDIATE OPERATION
   a. filter()
   filtering the data and always return boolean value
   ex: x.stream().filter().collect(Collectors.toList());
   b. map()
   -> Transform the object values.
   -> The map operation allows us to apply a function that take in parameter of one type and return some this else.
1. Duplicate Elements

public class DuplicateElements {
public static void main(String[] args) {
List<Integer>x =Arrays.asList(1,2,2,3,1,2,3,4,5,4);
//remove duplicate
//        List<Integer>y=x.stream().distinct().collect(Collectors.toList());
List<Integer>list=new ArrayList<>();
Collections.addAll(list,1,2,3,4,5,1,2,3,4);
Set<Integer>set=new HashSet<>();
List<Integer>y=list.stream().filter(x1->!set.add(x1)).collect(Collectors.toList());
System.out.println(y);
}
}

2. Sum or Even and odd
   public class SumOfEvenAndOdd {
   public static void main(String[] args) {
   List<Integer> x = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
   //        List<Integer>evenSum= Collections.singletonList(x.stream().filter(a -> a % 2 == 0).reduce(0, (ans, i) -> ans + i));
   //        System.out.println(evenSum);
   //
   //Collectors.partitioningBy() is used to partition the elements of the stream into even and odd numbers.
   //Collectors.summingInt() is used to calculate the sum of integers in each partition.


//                Map<Boolean, Integer> sumByEven = x.stream()
//                        .collect(Collectors.partitioningBy(a -> a % 2 == 0,
//                                Collectors.summingInt(Integer::intValue)));
//
//                System.out.println("Sum of even numbers: " + sumByEven.get(true));
//                System.out.println("Sum of odd numbers: " + sumByEven.get(false));
//            }
Map<Boolean,Integer>sumEvenOrOdd=x.stream().collect(Collectors.partitioningBy(a->a%2==0,Collectors.summingInt(Integer::intValue)));
System.out.println(sumEvenOrOdd.get(true));
System.out.println(sumEvenOrOdd.get(false));
}


