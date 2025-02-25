package com.leetcode.leetcode.oops.solidPrinciples;

public class SolidPrinciples {
    /*
     SOLID principles in OOP. Let me start by recalling what each letter stands for.
      1.  S  Single Responsibility Principle
      2.  O  Open/Closed Principle
      3.  L  Liskov Substitution Principle
      4.  I  Interface Segregation Principle
      5.  D  Dependency Inversion Principle

      Advantages
      Helps us to write better code
      Avoid duplicate code
      Easy to maintain
      Easy to understand
      Flexible Software
      Reduce Complexity

     */
    //1. Single Responsibility Principle (SRP)
    //Definition: A class should have only one reason to change (i.e., it should handle a single responsibility).

    // User class to hold user data
    public static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() { return username; }
        public String getPassword() { return password; }
    }

    // Handles authentication responsibilities
    public  static class AuthManager {
        public boolean authenticateUser(User user, String inputPassword) {
            return user.getPassword().equals(inputPassword);
        }
    }

    // Handles user data management responsibilities
   public static class UserDataManager {
        public void saveUserData(User user) {
            // Simulate saving to database/file
            System.out.println("Saving user data for: " + user.getUsername());
            // In real implementation, this would write to a database/file
        }
    }

    // Main class to demonstrate SRP
    public static class SRPDemo {
        public static void main(String[] args) {
            // Create a test user
            User user = new User("john", "password123");

            // Authentication process
            AuthManager authManager = new AuthManager();
            boolean isAuthenticated = authManager.authenticateUser(user, "password123");

            if (isAuthenticated) {
                System.out.println("Authentication successful!");

                // Data saving process
                UserDataManager dataManager = new UserDataManager();
                dataManager.saveUserData(user);
            } else {
                System.out.println("Authentication failed!");
            }

            // Example of password mismatch
            boolean wrongPassword = authManager.authenticateUser(user, "wrongpass");
            System.out.println("Wrong password test: " + (wrongPassword ? "Success!" : "Failure!"));
        }
    }
    //2. Open/Closed Principle (OCP)
    //Definition: Software entities (classes, modules) should be open for extension but closed for modification.

   public static interface PaymentMethod {
        void processPayment(double amount);
    }

    public static class CreditCard implements PaymentMethod {
        private String cardNumber;
        private String cardHolder;

        public CreditCard(String cardNumber, String cardHolder) {
            this.cardNumber = cardNumber;
            this.cardHolder = cardHolder;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
            System.out.println("Cardholder: " + cardHolder);
            System.out.println("Card number: " + maskCardNumber(cardNumber));
            // Actual payment processing logic would go here
        }

        private String maskCardNumber(String number) {
            return "****-****-****-" + number.substring(number.length() - 4);
        }
    }

    public static class PayPal implements PaymentMethod {
        private String email;

        public PayPal(String email) {
            this.email = email;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
            System.out.println("Using account: " + email);
            // Actual PayPal API call would go here
        }
    }

    // New payment method added without modifying existing code
    public static class Cryptocurrency implements PaymentMethod {
        private String walletAddress;

        public Cryptocurrency(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing cryptocurrency payment of $" + amount);
            System.out.println("Wallet address: " + walletAddress);
            // Blockchain transaction logic would go here
        }
    }

    public static  class PaymentProcessor {
        public void process(PaymentMethod method, double amount) {
            method.processPayment(amount);
            System.out.println("Payment processed successfully!\n");
        }
    }

    public static class OCPDemo {
        public static void main(String[] args) {
            PaymentProcessor processor = new PaymentProcessor();

            // Process different payment methods
            PaymentMethod creditCard = new CreditCard("1234567812345678", "John Doe");
            processor.process(creditCard, 100.00);

            PaymentMethod payPal = new PayPal("john.doe@example.com");
            processor.process(payPal, 50.00);

            // New payment method added without changing existing code
            PaymentMethod crypto = new Cryptocurrency("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
            processor.process(crypto, 200.00);
        }
    }

    //3. Liskov Substitution Principle (LSP)
    //Definition: Subtypes must be substitutable for their base types without altering program correctness.

    //If class B is subtype of class A, then we should be able to replace object of A and B without breaking
    //the behaviour of the program.

    // ❌ Violates LSP: Square is not a proper substitute for Rectangle
   public static class Rectangle {
        int width;
        int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int calculateArea() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width;  // Enforce square dimensions
        }

        @Override
        public void setHeight(int height) {
            this.width = height;
            this.height = height;  // Enforce square dimensions
        }
    }

    public static class LSPDemo {
        public static void main(String[] args) {
            // Test with Rectangle
            Rectangle rectangle = new Rectangle();
            testShape(rectangle);

            // Test with Square (should behave like Rectangle)
            Rectangle squareAsRectangle = new Square();
            testShape(squareAsRectangle);
        }

        // Function that works with Rectangle base class
        public static void testShape(Rectangle shape) {
            shape.setWidth(5);
            shape.setHeight(10);

            // We expect area to be 5 * 10 = 50
            int expectedArea = 50;
            int actualArea = shape.calculateArea();

            System.out.println("Expected area: " + expectedArea);
            System.out.println("Actual area: " + actualArea);
            System.out.println("Test passed: " + (expectedArea == actualArea) + "\n");
        }
        //4. Interface Segregation Principle (ISP)
        //Definition: Clients should not be forced to depend on interfaces they don’t use.
        // ❌ Violates ISP: Forces all printers to implement unused methods.
        public static interface Printer {
            void print();
            void scan();
            void fax();
        }

        // ✅ Follows ISP: Split into smaller interfaces.
        public static interface Printers {
            void print();
        }

        public static interface Scanner {
            void scan();
        }

        public static class BasicPrinter implements Printer {
            public void print() { /* ... */ }

            @Override
            public void scan() {

            }

            @Override
            public void fax() {

            }
        }
    }
    //5. Dependency Inversion Principle (DIP)
    //Definition:
    //
    //High-level modules should not depend on low-level modules. Both should depend on abstractions.
    //
    //Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.

    // ❌ Violates DIP: High-level class depends on a low-level MySQL class.
   public static class ReportGenerator {
        private MySQLDatabase db;
        ReportGenerator(MySQLDatabase db) { this.db = db; }
    }

    // ✅ Follows DIP: Depends on an abstraction (DataSource interface).
    public static interface DataSource {
        void fetchData();
    }

    public static class ReportGenerators {
        private DataSource source;
        ReportGenerators(DataSource source) { this.source = source; }
    }

    public static class MySQLDatabase implements DataSource {
        public void fetchData() { /* ... */ }
    }

    public static class APIDataSource implements DataSource {
        public void fetchData() { /* ... */ }
    }


}
