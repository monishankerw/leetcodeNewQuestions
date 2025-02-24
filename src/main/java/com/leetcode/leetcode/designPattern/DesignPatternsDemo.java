package com.leetcode.leetcode.designPattern;
import java.util.*;

public class DesignPatternsDemo {

    // 1. Singleton Pattern: Ensures that a class has only one instance and provides a global access point.
    public static class Singleton {
        private static Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Singleton Instance");
        }
    }

    // 2. Factory Pattern: Provides an interface for creating objects but lets subclasses decide the concrete class.
    interface Shape {
        void draw();
    }

    public static class Circle implements Shape {
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    public static class Rectangle implements Shape {
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    public static class ShapeFactory {
        public static Shape getShape(String type) {
            if (type.equalsIgnoreCase("CIRCLE")) {
                return new Circle();
            } else if (type.equalsIgnoreCase("RECTANGLE")) {
                return new Rectangle();
            }
            return null;
        }
    }

    // 3. Abstract Factory Pattern: Creates families of related objects without specifying their concrete classes.
    interface Animal {
        void makeSound();
    }

    public static class Dog implements Animal {
        public void makeSound() {
            System.out.println("Bark");
        }
    }

    public static class Cat implements Animal {
        public void makeSound() {
            System.out.println("Meow");
        }
    }

    public static abstract class AnimalFactory {
        abstract Animal createAnimal();
    }

    public static class DogFactory extends AnimalFactory {
        public Animal createAnimal() {
            return new Dog();
        }
    }

    public static class CatFactory extends AnimalFactory {
        public Animal createAnimal() {
            return new Cat();
        }
    }

    // 4. Builder Pattern: Used to construct complex objects step by step.
    public static class Car {
        private String engine;
        private int wheels;

        private Car(CarBuilder builder) {
            this.engine = builder.engine;
            this.wheels = builder.wheels;
        }

        public static class CarBuilder {
            private String engine;
            private int wheels;

            public CarBuilder setEngine(String engine) {
                this.engine = engine;
                return this;
            }

            public CarBuilder setWheels(int wheels) {
                this.wheels = wheels;
                return this;
            }

            public Car build() {
                return new Car(this);
            }
        }

        public void showCar() {
            System.out.println("Car with Engine: " + engine + ", Wheels: " + wheels);
        }
    }

    // 5. Prototype Pattern: Creates new objects by copying an existing object.
    public static abstract class PrototypeAnimal implements Cloneable {
        public String name;

        public abstract void makeSound();

        public PrototypeAnimal clone() throws CloneNotSupportedException {
            return (PrototypeAnimal) super.clone();
        }
    }

    public static class Sheep extends PrototypeAnimal {
        public Sheep() {
            this.name = "Sheep";
        }

        public void makeSound() {
            System.out.println("Baa Baa");
        }
    }

    public static class PrototypeRegistry {
        private static Map<String, PrototypeAnimal> registry = new HashMap<>();

        static {
            registry.put("Sheep", new Sheep());
        }

        public static PrototypeAnimal getClone(String type) throws CloneNotSupportedException {
            return registry.get(type).clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        // Testing Singleton Pattern
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();

        // Testing Factory Pattern
        Shape shape1 = ShapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = ShapeFactory.getShape("RECTANGLE");
        shape2.draw();

        // Testing Abstract Factory Pattern
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.makeSound();
        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();

        // Testing Builder Pattern
        Car car = new Car.CarBuilder().setEngine("V8").setWheels(4).build();
        car.showCar();

        // Testing Prototype Pattern
        PrototypeAnimal clonedSheep = PrototypeRegistry.getClone("Sheep");
        clonedSheep.makeSound();
    }
    /*
    Explanation of Each Design Pattern

1️⃣ Singleton Pattern
	•	Purpose: Ensures a class has only one instance and provides a global access point.
	•	Use Case: Database connections, logging framework, thread pools.
	•	Key Concept: A private constructor and a static method to return the same instance.

2️⃣ Factory Pattern
	•	Purpose: Provides a way to create objects without exposing the object creation logic.
	•	Use Case: When we need to create multiple types of related objects dynamically.
	•	Key Concept: A static method that returns an instance based on input.

3️⃣ Abstract Factory Pattern
	•	Purpose: A factory of factories. It helps create families of related objects without specifying concrete classes.
	•	Use Case: UI libraries supporting multiple themes, cross-platform development.
	•	Key Concept: Each factory creates a specific type of object.

4️⃣ Builder Pattern
	•	Purpose: Used to construct complex objects step by step.
	•	Use Case: Creating objects with multiple optional parameters.
	•	Key Concept: Uses a nested static class to construct an object in a readable manner.

5️⃣ Prototype Pattern
	•	Purpose: Creates new objects by copying an existing object, reducing the overhead of object creation.
	•	Use Case: When object creation is expensive (e.g., cloning database records).
	•	Key Concept: Implements Cloneable and overrides clone() method.


🚀 Interview Tips
	1.	Singleton Pattern
	•	Q: How do you make Singleton thread-safe?
	•	A: Use synchronized in getInstance() or use double-checked locking.
	2.	Factory Pattern
	•	Q: Difference between Factory and Abstract Factory?
	•	A: Factory creates objects of one family; Abstract Factory creates multiple related families.
	3.	Builder Pattern
	•	Q: When do you use the Builder pattern?
	•	A: When there are many optional parameters in a constructor.
	4.	Prototype Pattern
	•	Q: How does the Prototype pattern help?
	•	A: Reduces object creation cost by cloning existing objects.
     */
}
