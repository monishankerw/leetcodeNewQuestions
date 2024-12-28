package com.leetcode.leetcode.oops.MarkerInterfaceAndTransientKeyword;

/*
Empty interface is called marker interface
example: Serializable,cloneable,Random access etc
 */


// Step 1: Create a marker interface
interface AdminAccess {}

// Step 2: Define a class for a regular user
class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// Step 3: Define an Admin class that implements the marker interface
class Admin extends User implements AdminAccess {
    public Admin(String username) {
        super(username);
    }
}

// Step 4: Check privileges using the marker interface
public class PrivilegeCheckExample {
    public static void main(String[] args) {
        User regularUser = new User("JohnDoe");
        Admin adminUser = new Admin("AdminJane");

        checkAccess(regularUser);
        checkAccess(adminUser);
    }

    public static void checkAccess(User user) {
        if (user instanceof AdminAccess) {
            System.out.println(user.getUsername() + " has admin privileges.");
        } else {
            System.out.println(user.getUsername() + " is a regular user.");
        }
    }
}