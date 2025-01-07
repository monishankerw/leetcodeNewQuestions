package com.leetcode.leetcode.exceptions;
public class Exceptions {
//Whenever a bad user input given a program it will be hold the program execution abruptly
    //is called exception
    public static class ExcpOcc{
        public static void main(String[] args) {
            int x=10,y=0;
            int z=x/y;
            System.out.println(1);
            System.out.println(2);
        }
    }
    //To handle exception in java we used try catch block
    /*
    if exception occur in try block then try block automatically create exception object and given that
    object address to catch block.
    catch block will now suppress the exception and then futher code from there will continues to run.
     */
    public static class HandleExcp {
        public static void main(String[] args) {
            try {

                int x = 10, y = 0, z;
                z = x / y;
                System.out.println("welcome");
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(122);
            System.out.println(222);
        }
    }
    /*
    Q. Can exceptions be used for debugging?
Yes, exceptions can be used for debugging purposes.
When an exception is thrown, it provides useful information in the form of a stack trace,
which helps in identifying where the error occurred.

- The **stack trace** provided by `e.printStackTrace()` prints detailed information about
where the exception occurred. In this case, the error happens at line 5 in the `Test` class (`Test.java:5`).


What is the purpose of the assert statement in Java?
The assert statement is used to create assertions, which are conditions that must be true at a certain point in the program. If the condition is false, the program will throw an AssertionError. Assertions are generally used for testing and debugging purposes.

Example:


public class Test {
public static void main(String[] args) {
int age = 15;
assert age >= 18 : "Age must be at least 18";
System.out.println("Age is " + age);
}
}
Output when assertions are enabled (-ea flag):


Exception in thread "main" java.lang.AssertionError: Age must be at least 18
If assertions are enabled using the -ea flag, this will throw an AssertionError. If assertions are disabled, the program will execute normally.


How are exceptions propagated in Java?
Exception propagation refers to the process of passing an exception from the method where it occurs to its caller, and this continues until it is caught or until it reaches the main method. If not caught, it causes the program to terminate.

Example:


public class Test {
public static void method1() {
int data = 10 / 0; // This will cause an ArithmeticException
}

    public static void method2() {
        method1();  // method1 is called here
    }

    public static void main(String[] args) {
        try {
            method2();  // method2 is called here
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }
}
Output:


Exception caught in main: / by zero
Here, the exception is propagated from method1 to method2 to main where it is finally caught.
     */
    public static class A1{
        public static void main(String[] args) {
            try {
                int x=10,y=0,z;
                z=x/y;
                System.out.println("welcome::");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(1);
            System.out.println(2);
        }
    }
    /*

### Text-based explanation:

1. **Compile Time (Checked) Exception:**
   This exception will occur when .java file is compiling .class file.

   Example:
   ```java
   class A {
       public static void main(String[] args) {
           try {
               FileReader fr = new FileReader("D://test.txt"); // Checked Exception
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }
       }
   }
   ```

2. **Run Time (Unchecked) Exception:**
   These exceptions occur when running the `.class` file. They are not checked during compilation and typically result from programming errors (like dividing by zero).

   Example:
   ```java
   class A {
       public static void main(String[] args) {
           int x = 20 / 0; // Unchecked Exception (ArithmeticException)
       }
   }
   ```

---

### **ER Diagram Representation of the Exception Hierarchy**

```
```
Here's a complete representation of the **Java Exception Hierarchy** with both **checked exceptions (compile-time)** and **unchecked exceptions (run-time)**:

```
```
``
                                 Throwable
                                     |
                ----------------------------------------------------
                |                                                      |
              Error                                             Exception
                |                                                      |
    |-------------------------|                          |--------------------------------------------|
    |                         |                          |                                            |
VirtualMachineError    LinkageError         ( Unchecked or RuntimeException)                       (Checked Exception or Compile Time)
    |                         |                          |                                            |
    |                         |                          |                                            |
OutOfMemoryError    ClassFormatError           ArithmeticException                           IOException
StackOverflowError  NoClassDefFoundError       NullPointerException                          SQLException
InternalError       UnsatisfiedLinkError       ArrayIndexOutOfBoundsException                FileNotFoundException
                   VerifyError                StringIndexOutOfBoundsException               ClassNotFoundException
                                              IllegalArgumentException                      EOFException
                                              IllegalStateException                         CloneNotSupportedException
                                              NumberFormatException                         InterruptedException
                                              UnsupportedOperationException                 MalformedURLException
                                                                                           InstantiationException
```
```
### Explanation:
#### 1. **Throwable**
- The root class of all errors and exceptions in Java.

#### 2. **Error**
- Represents serious problems that applications should not try to catch.
    - **VirtualMachineError**: Represents errors related to the JVM.
        - **OutOfMemoryError**: Thrown when the JVM runs out of memory.
        - **StackOverflowError**: Thrown when the stack overflows due to recursion or deep call chains.
        - **InternalError**: Represents a JVM internal error.
    - **LinkageError**: Problems related to class linking or class definition.
        - **ClassFormatError**
        - **NoClassDefFoundError**: Thrown when the JVM cannot find a required class.
        - **UnsatisfiedLinkError**: Issues with native libraries.
        - **VerifyError**: Class file verification error.

#### 3. **Exception**
- Represents conditions that a reasonable application might want to catch.
    - **RuntimeException (Unchecked)**
        - **ArithmeticException**: Thrown when an exceptional arithmetic condition occurs (e.g., division by zero).
        - **NullPointerException**: When you access non static member with null reference variable we get null pointer exception.
        - **ArrayIndexOutOfBoundsException**: Thrown when trying to access an array index that is out of bounds.
        - **StringIndexOutOfBoundsException**: Thrown when trying to access a string index that is out of bounds.
        - **IllegalArgumentException**: Thrown when a method receives an argument that is inappropriate.
        - **IllegalStateException**: Thrown when a method has been invoked at an illegal or inappropriate time.
        - **NumberFormatException**: When Invalid string to number conversion is done we get number format in the exception
        - **UnsupportedOperationException**: Thrown to indicate that the requested operation is not supported.

    - **Checked Exceptions (Compile-Time)**
        - **IOException**: General I/O failure.
            - **FileNotFoundException**: Thrown when a file is not found.
            - **EOFException**: Thrown when the end of a file is unexpectedly reached.
            - **MalformedURLException**: Thrown when an invalid URL is passed.
        - **SQLException**: Issues related to database access.
        - **ClassNotFoundException**: Thrown when the JVM cannot find a required class.
        - **CloneNotSupportedException**: Thrown when a clone method in a class does not support cloning.
        - **InterruptedException**: Thrown when a thread is interrupted.
        - **InstantiationException**: Thrown when trying to instantiate an abstract class or an interface.

---

### Summary of Exception Types:
1. **Unchecked Exceptions (RuntimeException)**
    - Arithmetic issues (e.g., division by zero)
    - Null pointer access
    - Illegal arguments and states
    - Array and string index out of bounds
    - Number format issues

2. **Checked Exceptions**
    - I/O issues (e.g., file not found)
    - SQL-related issues
    - Class not found or unsupported cloning
    - Interrupted threads


     */
    public static class A2{
        public static void main(String[] args) {
            try{
                int x=10,y=0,z;
                 z=x/y;
                System.out.println(z);
            }catch (ArithmeticException e){
                e.printStackTrace();
            }
            System.out.println("Welcome:");
        }
    }

    public static class A3{
        private boolean x;

        public static void main(String[] args) {
            try{
                A3 a=null;
                System.out.println(a.x);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            System.out.println(999);
        }
    }
    //When an invalid string to number conversion is done we get number format in the exception.
/*
 try{
            String x="122";
            int val=Integer.parseInt(x);
            System.out.println(val);
        }
         try{
            String x="122";
            float val=Float.parseFloat(x);
            System.out.println(val);
        }
         try{
            String x="true";
            boolean val=Boolean.parseBoolean(x);
            System.out.println(val);
        }
 */

    public static class A${
        public static void main(String[] args) {
            try{
                String x="xyz";
                int val=Integer.parseInt(x);
                System.out.println(val);
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
            System.out.println("welcome");
        }
    }

    /*
    Difference between using ExceptionClass and NumberFormat class

    When we you number format exception class in catch block only it can handle number format exception
    If you use exception in catch block it can handle all the exception that then in try block.
     */


    public static class A5{
        int x=8;

        public static void main(String[] args) {
            try{
                int z=12/0;
                A5 a1=null;
                System.out.println(a1.x);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(100);
        }
    }

    /*
    What is the use of try-with resources?
     */
    // Q. Can you write multi catch block?
// Ans: Yes, We can create more than one catch block in try-catch. We can create child-specific exceptions followed by parent exceptions.
    public static class MultiCatchBlock {
        String x;
        public static void main(String[] args) {
            try {
                int z = 10 / 0; // This will throw an ArithmeticException
                Integer.parseInt("xyz"); // This will throw a NumberFormatException
                int a1 = (Integer) null; // This will throw a NullPointerException

            } catch (ArithmeticException e) {
                System.out.println("Caught ArithmeticException: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Caught NumberFormatException: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Caught NullPointerException: " + e.getMessage());
            }
            catch (java.lang.Exception e){
                System.out.println("Exception:"+e.getMessage());
            }
        }
    }

    /*
    1. Is finally block always get executed in Java?
Yes, the finally block is always get executed unless there is an abnormal program
termination either resulting from a jvm crash or from a call to system.exit().
A finally block is always get executed whether exception has occurred or not.

2. Is there a case where finally with not execute?
yes, some case finally block not execute
a. In try and catch block used system.exist() method finally block not execute.
b. Jvm crash, out of memory.
c. forced fully killed java program.
d. deadlock condition not used finally.
e. shutdown system due to power failure.


3. Difference between final,finally, finalize.
finally
1. If you make variable final once initialize then after can not be changed.
2. If you make method final overriding not possible.
3. If you make class final inheritance not possible.
4. If you make static and non static final if not initialized automatically not give default value.

final:
1. It is the extension of try and catch block.
2. When exception happen or not finally block continuous executed.

finalize():
1. Finalize is method.
2. finalize is used to clean activity.
3. when object created they are not in use then jvm will automatically call garbage collector to clean up the un used object.
4. But when garbage collector will be called is quite difficult to predict.

     */


//yes, we write finally without catch block
    public static class A {
        int x = 1;

        public static void main(String[] args) {
            try {
                // This line will throw a NumberFormatException
                Integer.parseInt("xyz");
            } finally {
                // This will always be executed
                System.out.println(1);
            }
            // This line will not be executed because the exception is not caught
            System.out.println(2);
        }
    }

    public static class B {
        //---->Whenever Exception occur or not finally block continuous to execute.
//----> finally is the extension of try and catch block.
        int x = 19;

        public static void main(String[] args) {
            try {
                Integer.parseInt("xad");
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                System.out.println(122);
            }
        }
    }
    /*
    What happens if System.exit() is called in a try block?
When System.exit() is called, the JVM will terminate the program, and no further code (including catch and finally blocks) will be executed.

     */
    public static class Test {
        public static void main(String[] args) {
            try {
                System.out.println("Inside try block");
                System.exit(0); // JVM will terminate here
            } catch (Exception e) {
                System.out.println("Inside catch block");
            } finally {
                System.out.println("Inside finally block");
            }
            System.out.println("This will not execute");
        }
    }


    /*

```markdown
# Throwing an Exception from a Static Block in Java

In Java, exceptions can be thrown from a static block. However, there are some important rules to keep in mind:

- **Unchecked exceptions** (i.e., exceptions that inherit from `RuntimeException`) can be thrown directly from a static block.
- **Checked exceptions** must be handled within the static block because static blocks are not methods, and they do not have a method signature where exceptions can be declared.

Q. Can we throw an exception from a static block?
Yes, exceptions can be thrown from a static block.
However, only unchecked exceptions can be thrown directly from a static block
because checked exceptions must be either caught or declared in a method signature.
Since static blocks are not methods, checked exceptions must be handled within the block.
## Example: Throwing an Unchecked Exception from a Static Block

In the following example, an unchecked exception (`RuntimeException`) is thrown from the static block. Since this is an unchecked exception, it doesn't need to be handled or declared.

```java
public class Test {
    static {
        System.out.println("Inside static block");
        throw new RuntimeException("Unchecked exception from static block");
    }

    public static void main(String[] args) {
        System.out.println("This will not execute");
    }
}
```

### Output:

```
Inside static block
Exception in thread "main" java.lang.RuntimeException: Unchecked exception from static block
    at Test.<clinit>(Test.java:4)
```

### Explanation:
- When the class is loaded, the static block is executed before the `main` method.
- In this case, the static block throws a `RuntimeException`, which is an unchecked exception.
- As a result, the program terminates, and the `main` method is not executed.

## Key Points:
- **Unchecked Exceptions**: You can throw unchecked exceptions (like `RuntimeException` and its subclasses) from a static block without handling them.
- **Checked Exceptions**: If you want to throw a checked exception (like `IOException`), you must catch it inside the static block since there's no way to declare exceptions for a static block.
- **Program Termination**: If an unchecked exception is thrown from a static block, the program will terminate, and any subsequent code (like the `main` method) will not be executed.

## Conclusion:
Static blocks can throw exceptions, but only unchecked exceptions can be thrown without explicit handling. Checked exceptions must be caught within the static block because there's no way to declare exceptions for it.
```


     */
    /*
Java throw Exception
-> throw keyword is used to throw an exception explicitly.
->we can throw either checked or unchacked exception in java by throw keyword.


1. throw keyword used inside a function.
2. throw keyword used only one exception and can not multiple exception.
3. throw keywords help us to take the memory address of exception object give to the catch block.
4. We only to throw but can not propagate exception to calling method.

throw instance i.e:
throw new exception_class("errormanage")
ex:
throw new IOException("error");

 */

    /*
    Q. Give me practically example where finally block can be used.
    Database closing connections
     */
        public static class A12{
            public static void main(String[] args) {
                try {
                    fun();
                } catch (NullPointerException e) {
                    System.out.println("Exception occurs:" + e.getMessage());
                }
            }

            private static void fun() {
                try {
                    throw new NullPointerException("demo");
                } catch (NullPointerException e) {
                    System.out.println("Exception occurs inside fun()::" + e.getMessage());
                }
            }
        }

        public static class B1 {
            public static void main(String[] args) {
                try {
                    int age = 19;
                    validates(age);

                } catch (ArithmeticException e) {
                    System.out.println("Age:::" + e.getMessage());
                }

            }

            private static void validates(int age) {

                if (age < 18) {
                    throw new ArithmeticException("Not Eligible");
                } else {

                    System.out.println("Age Eligible::");
                }
            }
        }

        public static class InssuficientFunds extends Exception {
            InssuficientFunds() {
                System.out.println("Low Balance::");
            }
        }

        public static class Bank {
            public static void main(String[] args) {
                int balance = 10, amount = 1000;
                if (amount > balance) {
                    try {
                        throw new InssuficientFunds();
                    } catch (InssuficientFunds e) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println("Collect Funds::");
                }
            }
        }

        public static class Except {
            public static void main(String[] args) {
                try {
                    throw new Error();
                } catch (Error e) {
                    try {
                        throw new RuntimeException();
                    } catch (Throwable t) {
                    }
                }
                System.out.println("phew");
            }

        }
    }

