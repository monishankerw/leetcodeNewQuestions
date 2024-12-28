package com.leetcode.leetcode.oops.serializationAndDeserilization;

import java.io.*;

// Step 1: Make the class implement Serializable
class Student implements Serializable {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }


    public static class Main {
        public static void main(String[] args) {
            Student student = new Student("John", 20);
//here we store the store of an object presently in a file by translating the object 0s and 1.
            // Step 2: Serialize the object
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
                oos.writeObject(student);
                System.out.println("Object Serialized: " + student);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //in deserialization we read binary from file and reconstruct the object back.
            // Step 3: Deserialize the object
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
                Student deserializedStudent = (Student) ois.readObject();
                System.out.println("Object Deserialized: " + deserializedStudent);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}