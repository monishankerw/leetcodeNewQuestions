package com.leetcode.leetcode.oops.MarkerInterfaceAndTransientKeyword.transientKeywords;

import java.io.*;

//During Serialization Transient keyword when  applied on a variable
// it will skip written the content into the object.


// Step 1: Define a class with transient fields
class User implements Serializable {
    private String username;
    private transient String password; // Won't be serialized

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "'}";
    }
}

public class TransientKeywordExample {
    public static void main(String[] args) {
        User user = new User("JohnDoe", "secret123");

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(user);
            System.out.println("Serialized User: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User deserializedUser = (User) ois.readObject();
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}