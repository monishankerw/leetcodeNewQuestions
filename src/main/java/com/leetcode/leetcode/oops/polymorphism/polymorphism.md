    
----
     -> Developing a feature such that it can take more than one form depending on sistuation is called Polymorphism.
     -> In java polymorphism is mainly divided into two types:
        1. compile time polymorphism
        2. Run time polymorphism

1. Compile time polymorphism(static,Earlybinding,Method Overloading): 
    This type of polymorphism is achieved by function overloading or operator overloading.
    But Java does not support the operator overloading.

METHOD OVERLOADING: Here we create more than one method same class with same name they have provided
different number of argument and different type of argument is called as method overloading.

    METHOD OVERLOADING CAN BE POSSIBLE
1. The return type of the overload function
2. The Type of the parameter pass to the function
3. The Number of parameter pass to the function

```java


public class A {
    public int add(int a, int b){
        return a+b;
    }
    public int add(int a, int b, int c){
        return a+b+c;
    }
    static  class B{
  public static void main(String[] args) {
               A a1=new A();
            System.out.println(a1.add(10,20));
            System.out.println(a1.add(10,20,30));
        }
    }
}

---> Yes, We can overload static method.


Q. Can we overload methods that differ only be static keywords?
no

