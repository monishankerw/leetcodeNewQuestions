
```markdown
# Run Time Polymorphism

- **Definition**: It is also known as Dynamic Method Dispatch. During runtime, if a child class object is assigned to a reference variable, the method call is resolved based on the actual object, leading to runtime polymorphism.

## Example 1: Basic Runtime Polymorphism

```java
public class A {
    public void test() {
        System.out.println(100);
    }

    public static class B extends A {
        @Override
        public void test() {
            System.out.println(100);
        }

        public static void main(String[] args) {
            A a = new A();
            a.test(); // Output: 100
        }
    }
}
```

## Example 2: Extended Runtime Polymorphism

```java
package com.crudExample.corejava.oops.polymorphism.RunTimePolymorphism;

public class Parent {
    public void test() {
        System.out.println("Parent Class:");
    }

    // Adding the print method to the Parent class
    public void print() {
        System.out.println("Parent Class print method");
    }

    public static class Subclass1 extends Parent {
        @Override
        public void print() {
            System.out.println("Subclass1:");
        }
    }

    public static class Subclass2 extends Parent {
        @Override
        public void print() {
            System.out.println("Subclass2:");
        }

        public static void main(String[] args) {
            Parent parent = new Subclass1();
            parent.print(); // Output: Subclass1:

            Parent parent1 = new Subclass2();
            parent1.print(); // Output: Subclass2:
        }
    }
}
```

## Rules of Method Overloading

1. **Overriding and Access Modifiers**:
   - The access modifier for an overriding method can allow more, but not less, access than the overridden method.
   - Example: A `protected` instance method in the superclass can be made `public` but not `private`.

   ```java
   package com.crudExample.corejava.oops.polymorphism.RunTimePolymorphism;

   public class B {
       private void m1() { // private methods are not overridden
           System.out.println("A");
       }

       protected void m2() {
           System.out.println("B");
       }

       public static class C extends B {
           public void m1() {
               System.out.println("C");
           }

           @Override
           public void m2() { // overriding method with more accessibility
               System.out.println("D");
           }
       }

       public static void main(String[] args) {
           B b = new B();
           b.m2(); // Output: B
           B b1 = new C();
           b1.m2(); // Output: D
       }
   }
   ```

2. **Final Method Cannot Be Overridden**:
   - A `final` method cannot be overridden, and inheritance is not possible.

   ```java
   public class C {
       final void show() {
           System.out.println("Final Method");
       }

       public static class D extends C {
           // This would result in a compilation error
           // void show() {
           //     System.out.println("Overridden Final Method");
           // }
       }
   }
   ```

3. **Static Method Cannot Be Overridden**:
   - Defining a static method with the same signature as a static method in the base class is known as method hiding, not overriding.

4. **Private Method Cannot Be Overridden**:
   - Private methods cannot be overridden as they are bound during compile-time, so overriding private methods in a subclass is not possible.

5. **The Overriding Method Must Have the Same Return Type (or Subtype)**.

6. **Invoking Overridden Method from Subclass**:
   - You can call the parent class method in the overriding method using the `super` keyword.

   ```java
   public class D {
       void show1() {
           System.out.println("D");
       }

       public static class E extends D {
           @Override
           void show1() {
               System.out.println("E");
               super.show1(); // Calls parent class method
           }
       }

       public static void main(String[] args) {
           D d = new E();
           d.show1(); // Output: E \n D
       }
   }
   ```

7. **We Cannot Have Constructors with the Same Signature in Parent and Child Classes**.

8. **Abstract Methods in an Interface or Abstract Class**:
   - Abstract methods in an interface or abstract class must be overridden in derived concrete classes; otherwise, a compile-time error will be thrown.

## Q&A: Overriding vs Overloading

- **Overloading**:
   - Involves methods with the same name but different signatures (parameter types or number).
   - It is an example of compile-time polymorphism.

- **Overriding**:
   - Involves methods with the same name and signature in different classes connected through inheritance.
   - It is an example of runtime polymorphism.

### Q: Can we overload the `main()` method in Java?
- **A**: Yes.

### Q: Does Java support operator overloading?
- **A**: No.

### Q: Can we overload methods on return type?
- **A**: No.

## Example: Banking Project

```java
package com.crudExample.corejava.oops.polymorphism.RunTimePolymorphism.bankingProject;

public class GoldAccount {
    public void onlineBanking() {
        System.out.println("Yes");
    }

    public void chqBooks() {
        System.out.println("2/years");
    }

    public void rateOfInterest() {
        System.out.println("Nil");
    }

    public static class PlatinumAccount extends GoldAccount {
        @Override
        public void chqBooks() {
            System.out.println("Unlimited");
        }

        @Override
        public void rateOfInterest() {
            System.out.println("6% PA");
        }

        public static void main(String[] args) {
            GoldAccount goldAccount = new GoldAccount();
            goldAccount.onlineBanking(); // Output: Yes
            goldAccount.rateOfInterest(); // Output: Nil
            goldAccount.chqBooks(); // Output: 2/years

            GoldAccount platinumAccount = new PlatinumAccount();
            platinumAccount.onlineBanking(); // Output: Yes (from GoldAccount)
            platinumAccount.rateOfInterest(); // Output: 6% PA (from PlatinumAccount)
            platinumAccount.chqBooks(); // Output: Unlimited (from PlatinumAccount)
        }
    }
}
```
```

