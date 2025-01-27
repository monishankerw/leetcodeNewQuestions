# Java Database Connectivity (JDBC)

JDBC (Java Database Connectivity) is a Java API used to connect and execute queries with a database. It provides methods to interact with relational databases and perform operations like saving, updating, deleting, and retrieving data.

## Steps to Connect to a Database

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc",
                    "root",
                    "12Rose#2323");

            System.out.println("Connection established: " + connection);

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish connection.", e);
        }
    }
}
```

## CRUD Operations
- **C:** CREATE
- **R:** READ
- **U:** UPDATE
- **D:** DELETE

### JDBC Methods
- `executeUpdate()` - Used for CREATE, UPDATE, and DELETE operations.
- `executeQuery()` - Used for SELECT queries.

### Example

```java
package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class B {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/VarshaPatel",
                    "root",
                    "12Rose#2323");
            Statement statement = connection.createStatement();

            boolean isResultSet = statement.execute("CREATE TABLE maniShanker (id INT, name VARCHAR(50))");
            System.out.println("DDL Statement executed: " + isResultSet);

            int rowsAffected = statement.executeUpdate("INSERT INTO maniShanker VALUES (1, 'VarshaMani')");
            System.out.println("DML Statement executed. Rows affected: " + rowsAffected);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM maniShanker");
            System.out.println("DQL Statement executed.");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

# Servlets

Servlets are Java classes extending `HttpServlet` used to develop backend logic. They handle communication between the frontend and backend.

## Servlet Lifecycle
1. **init()**: Called once when the servlet is first loaded.
2. **service()**: Handles requests (via `doGet()` and `doPost()` methods).
3. **destroy()**: Called once before the servlet is removed.


create Servlet--->start server--->Tomcat Container--->init()--->service method(doGet(),doPost())--->destroy()--->end
When first time start Tomcat server its loaded in tomcat container, tomcat container is area logical implementation is we develop to run servlet,once's will tomcat started very first
method in servlet call as init() and this method run's one after init() called the services method are called servel times(service method doget() and dopost()) then called any number of time depending on bussiness requirement finally destroy() will executed servlet life cycle cames to end.


## Servlet Example

```java
@WebServlet("/verifyLogin")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String jdbcUrl = "jdbc:mysql://localhost:3306/loginPage";
        String dbUsername = "root";
        String dbPassword = "12Rose#2323";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        response.sendRedirect("success.html");
                    } else {
                        response.sendRedirect("login.html?error=1");
                    }
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database access error", e);
        }
    }
}
```

# JSP (Jakarta Server Pages)

JSP allows embedding Java code in HTML to generate dynamic web content.

## JSP Tags
1. **Scriptlet Tag (`<% %>`)**: Contains Java code for execution.
2. **Declaration Tag (`<%! %>`)**: Declares methods and variables.
3. **Expression Tag (`<%= %>`)**: Outputs a value to the client.
4. **Directive Tag (`<%@ %>`)**: Used for configuration (e.g., imports).

### Example

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
    <% int x = 10; %>
    <p>The value of x is: <%= x %></p>
</body>
</html>
```

## JSP Lifecycle
1. **JSP to Servlet Translation**: Converts JSP into a servlet.
2. **`jspInit()`**: Called once when JSP is loaded.
3. **`_jspService()`**: Handles requests.
4. **`jspDestroy()`**: Called before JSP is removed.

JSP LIFE CYCLE

                  .jsp                  Request
         JAVA CODE------->jsp Translator------->jsp Init(),jsp Service(),jsp Destroy()(Servlet)
                                       <---------
                                         Response

When java code write in .jsp file with help us to jsp Translator then java code converted into servlet and servlet has three method jspinit(),jspService(),jsp Destroy()
jspinit() run only one's after Tomcat will started.
Service() run any number of time depending on bussiness required.
when Dedtroyed() run it means life cycle of jsp comes to end.


JSTL (JavaServer Pages Standard Tag Library) is a set of tags that provide common functionalities to simplify JSP (JavaServer Pages) development. It allows you to use tags to control flow, format data, work with XML, and more, reducing the need for Java code directly embedded in JSPs. Here's a breakdown of some key features and how to use JSTL in JSP files.

### 1. **Adding JSTL Dependencies**
Before using JSTL in a JSP file, you need to include the necessary libraries in your project. If you're using Maven, you can include JSTL using the following dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

### 2. **Importing JSTL Core Library**
At the beginning of your JSP file, you need to declare the JSTL tag library. The core library prefix (`c`) is used for common functions like conditionals and loops:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

### 3. **Common JSTL Tags**

#### a. **Conditional Tag: `c:if`**
The `<c:if>` tag is used to perform conditional logic, similar to an `if` statement in Java.

**Example:**
```jsp
<c:if test="${user != null}">
    Welcome, ${user.name}!
</c:if>
```

#### b. **Loop Tag: `c:forEach`**
The `<c:forEach>` tag is used to iterate over collections such as lists, arrays, or even a range of numbers.

**Example:**
```jsp
<ul>
    <c:forEach var="item" items="${itemList}">
        <li>${item}</li>
    </c:forEach>
</ul>
```

In this example, `itemList` is a collection passed from the backend, and `item` is the variable used to access each element of the list.

#### c. **Setting Variables: `c:set`**
The `<c:set>` tag is used to assign a value to a variable in the scope of the JSP page.

**Example:**
```jsp
<c:set var="discount" value="10"/>
<p>The discount is ${discount}%</p>
```

#### d. **Conditional Tag: `c:choose`, `c:when`, `c:otherwise`**
The `<c:choose>` tag works like a `switch` statement in Java. It includes `c:when` for conditions and `c:otherwise` for the default case.

**Example:**
```jsp
<c:choose>
    <c:when test="${age >= 18}">
        <p>You are an adult.</p>
    </c:when>
    <c:otherwise>
        <p>You are a minor.</p>
    </c:otherwise>
</c:choose>
```

#### e. **Displaying Internationalized Messages: `fmt:message`**
If you're working with internationalization (i18n), the `fmt:message` tag is used to display localized messages.

**Example:**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:message key="welcome.message"/>
```

This requires a properties file (e.g., `messages_en.properties`) with the `welcome.message` key.

### 4. **Full Example Using JSTL**
Here’s a simple example where we use various JSTL tags in a JSP file:

```jsp
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSTL Example</title>
</head>
<body>
    <h1>Welcome Page</h1>
    
    <!-- Conditionally render content -->
    <c:if test="${user != null}">
        <p>Hello, ${user.name}!</p>
    </c:if>
    
    <!-- Set a variable -->
    <c:set var="price" value="100" />
    <p>Price: ${price}</p>
    
    <!-- Iterate over a list -->
    <h2>Items List</h2>
    <ul>
        <c:forEach var="item" items="${itemList}">
            <li>${item}</li>
        </c:forEach>
    </ul>
    
    <!-- Conditional logic with choose, when, otherwise -->
    <c:choose>
        <c:when test="${user.age >= 18}">
            <p>You are an adult.</p>
        </c:when>
        <c:otherwise>
            <p>You are a minor.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
```

In this example:
- We greet the user by name if the `user` object is available.
- We set and display a variable (`price`).
- We loop through an `itemList` and display each item in a list.
- We conditionally display content based on the user's age.

### 5. **EL (Expression Language)**
JSTL works well with JSP Expression Language (EL), which allows you to access JavaBeans properties, collections, and scoped variables directly in JSP. For instance:
- `${user.name}` accesses the `name` property of the `user` object.
- `${itemList}` refers to a list or collection passed into the JSP page.

### Advantages of Using JSTL:
- **Less Java code in JSP:** Simplifies JSP by avoiding Java code embedded in the page.
- **Reusability and readability:** JSTL makes JSPs more readable and maintainable by using tag-based logic.
- **Predefined functionalities:** Tags like iteration, conditionals, and formatting provide commonly needed functionalities in a standardized way.

# Spring MVC Overview

Spring MVC (Model-View-Controller) is a part of the Spring Framework that helps developers create flexible and loosely coupled web applications.

---

## Key Features
- Separation of concerns via the MVC pattern.
- Simplified development with annotations.
- Support for RESTful web services.
- Easy integration with various view technologies (JSP, Thymeleaf, etc.).

---

## Core Concepts

### 1. **Model**
Represents the application data and business logic. It is often a combination of Java objects and services that handle the core functionality.

### 2. **View**
Responsible for rendering the user interface. Examples: JSP, Thymeleaf, or any other templating engine.

### 3. **Controller**
Handles user requests and interacts with the model to prepare data for the view.

---

## Spring MVC Workflow

1. **Request**: A user sends an HTTP request to the server.
2. **DispatcherServlet**: Central servlet that intercepts all requests and routes them to the appropriate controller.
3. **Controller**: Processes the request, interacts with the model, and returns a `ModelAndView` object.
4. **View Resolver**: Resolves the view name to an actual view (like a JSP file).
5. **View**: Generates the HTML response sent back to the user.

---

## Setting Up Spring MVC

### 1. **Dependencies**
Add the necessary dependencies to your `pom.xml` (Maven):

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.30</version>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### 2. **Configuration**
#### Using Java Config:

```java
@EnableWebMvc
@Configuration
@ComponentScan("com.example.controller")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
```

### 3. **Controller**

```java
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC!");
        return "home"; // View name
    }
}
```

### 4. **View**
Place the `home.jsp` file in `WEB-INF/views/`:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>${message}</h1>
</body>
</html>
```

---

## RESTful Web Services in Spring MVC

### Controller Example:

```java
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hello, RESTful World!");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody Data data) {
        // Handle data
        return ResponseEntity.ok("Data saved successfully!");
    }
}
```

---

## Annotations Overview

| Annotation         | Description                                             |
|--------------------|---------------------------------------------------------|
| `@Controller`      | Marks a class as a Spring MVC controller.               |
| `@RestController`  | A specialized controller that returns JSON/XML directly.|
| `@RequestMapping`  | Maps HTTP requests to handler methods or classes.       |
| `@GetMapping`      | Shortcut for `@RequestMapping` for GET requests.        |
| `@PostMapping`     | Shortcut for `@RequestMapping` for POST requests.       |
| `@PathVariable`    | Binds a URI template variable to a method parameter.    |
| `@RequestParam`    | Binds a request parameter to a method parameter.        |
| `@RequestBody`     | Binds the body of the HTTP request to a method parameter.|

---

## Advantages
- Simplified request handling.
- Support for REST APIs.
- Flexible configuration (XML, Java Config).
- Integration with other Spring modules like Spring Security and Spring Data.

---

## Common Issues and Tips
1. **DispatcherServlet Not Found**:
  - Ensure it is configured in `web.xml` or `SpringBootApplication` class.

2. **404 Error for Views**:
  - Check the view resolver prefix and suffix.

3. **Annotation Scanning**:
  - Verify the `@ComponentScan` path in your configuration.

---

Spring MVC is a powerful framework for building web applications. With proper understanding and configuration, you can create efficient, scalable, and maintainable applications.

# Unit Testing
Unit testing ensures individual components function as expected. It involves:
- Writing test cases for each functionality.
- Using frameworks like JUnit or TestNG.

Unit tests help identify bugs early and improve code quality.




# Hibernate and JPA FAQ

## Q. What is JPA?
Java Persistence API (JPA) is a concept of taking object content and mapping it into a database using Object-Relational Mapping (ORM).

## Q. What is Hibernate JPA?
Hibernate is an implementation of JPA.

## Q. JPA Annotations
- `@Entity`: Defines which Java class is mapped to a database table.
- `@Table`: Used when the database table name and entity class name differ.
- `@Column`: Maps an entity class variable to a database column.
- `@Id`: Marks a primary key.
- `@GeneratedValue`: Helps auto-increment primary keys.

## Q. Difference Between JPA and Hibernate
- **JPA**: A specification for mapping objects to database tables.
- **Hibernate**: An implementation of JPA.

## Q. Spring Data JPA
It uses the `javax.persistence` package to integrate JPA into Spring applications.

## Q. Difference Between JPA Repository and Crud Repository
JPA Repository extends Crud Repository with additional functionality like pagination and batch operations.

## Q. What is Hibernate?
Hibernate is an ORM (Object-Relational Mapping) framework that simplifies database interaction by mapping Java objects to database tables.

## Q. What is ORM?
ORM (Object-Relational Mapping) translates objects into database tables and vice versa using frameworks like Hibernate.

## Q. Hibernate vs JDBC
### Hibernate:
1. Framework.
2. Supports lazy loading.
3. Manages transactions internally.
4. High performance.

### JDBC:
1. Database connectivity technology.
2. Does not support lazy loading.
3. Requires explicit management of database connections.
4. Lower performance.

## Q. Advantages of Hibernate over JDBC
- Open-source ORM framework.
- Supports inheritance and polymorphism.
- Includes its own query language (HQL).
- Offers relationship mappings like OneToOne, OneToMany, ManyToOne, and ManyToMany.
- Supports annotations and XML configurations.
- Enables lazy loading.

## Q. What is a POJO?
A Plain Old Java Object (POJO) is responsible for initializing variables and accessing them using getters and setters. Hibernate requires POJOs for mapping.

## Q. What is a Dialect?
A Hibernate Dialect generates SQL queries specific to the target database.

## Q. Use of Hibernate
Hibernate removes dependency on manually handling database connections and configurations by using the `hibernate.cfg.xml` file.

## Q. Hibernate Architecture
1. **Java Application Layer**
2. **Hibernate Framework Layer**
3. **Backend API Layer**
4. **Database Layer**

## Q. Session and SessionFactory in Hibernate
- **SessionFactory**:
    - Creates Session objects.
    - Available for the entire application.
    - Provides second-level cache.

- **Session**:
    - Available only for a specific transaction.
    - Provides first-level cache.

### Q. What is a Session in Hibernate?
The Session interface (API) is the primary tool used to communicate with Hibernate and obtain a physical connection to the database.

### Q. How to Create a Session Object?
```java
HttpSession mySession = request.getSession();
```

## Q. Components of Hibernate
1. Entity class
2. `application.properties` file

## Q. HQL
Hibernate Query Language (HQL) is an object-oriented query language similar to SQL but tailored for Hibernate.

## Q. Lazy Loading vs Eager Loading
### Lazy Loading:
1. Associated data is loaded only when explicitly accessed (e.g., calling `getter` or `size` methods).
2. Default strategy for `ManyToMany` and `OneToMany` associations.
3. Enabled using the annotation parameter: `fetch=FetchType.LAZY`.
4. Initial load time is smaller than Eager loading.

### Eager Loading:
1. Associated data is loaded immediately when the parent entity is fetched.
2. Default strategy for `ManyToOne` and `OneToOne` associations.
3. Enabled using the annotation parameter: `fetch=FetchType.EAGER`.
4. Loading unnecessary data might impact performance.

## Q. Caching in Hibernate
Caching is a mechanism to enhance the performance of a system. It is a buffer memory that lies between the application and the database. Cache memory stores recently used data items in order to reduce the number of database hits as much as possible.

### Types:
1. **First-Level Caching**: Maintained at the session level and accessible only within the session.
2. **Second-Level Caching**: Maintained at the SessionFactory level and available to all sessions.

## Q. Methods of Hibernate
- `save()`
- `update()`
- `saveOrUpdate()`
- `merge()`
- `delete()`

## Q. State of Object in Hibernate
1. **Transient State**
2. **Persistent State**
3. **Detached State**

## Q. How to Create an Immutable Class in Hibernate?
1. Avoid providing any method which modifies the object's state.
2. Make all fields private.
3. Make all fields final.
4. Ensure the class cannot be extended.

## Q. Difference Between `get` and `load` Methods in Hibernate
- **`get()`**: Returns `null` if no row is available in the database.
- **`load()`**: Throws `ObjectNotFoundException` if the entity is not found.

## Q. Types of Inheritance in Hibernate
1. **Table per Class**: Using XML file.
2. **Table per Subclass Hierarchy**: XML file and annotations.
3. **Table per Concrete Class Hierarchy**.

## Q. Core Interfaces of Hibernate
- Configuration Interface
- Transaction Interface
- Session Interface
- SessionFactory Interface

## Q. Types of Hibernate Mapping
### Primitive Type Mapping:
Maps primitive types like `int`, `long`, `short`, and `boolean`.

### Date and Time Mapping:
- Maps `java.util.Date`, `Calendar`, and JDK 8+ classes like `LocalDate` and `LocalTime`.

### Binary and Large Object Types:
- Maps binary data types like `byte[]` and large text as `LOB`.

### JDK-Related Types:
- Maps Java classes and utilities such as `Class` and `TimeZone`.

---

## Q. Implementing Different Types of Mappings

### 1. OneToOne Mapping
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    // Getters and Setters
}

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String phone;

    // Getters and Setters
}
```

### 2. OneToMany Mapping
```java
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // Getters and Setters
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and Setters
}
```

### 3. ManyToOne Mapping
Covered in the `Employee` above.

### 4. ManyToMany Mapping
```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    // Getters and Setters
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Getters and Setters
}
```
# Spring Framework Overview

## 1. What is Spring?
Spring is a Dependency Injection framework used to make Java applications loosely coupled. The Spring framework facilitates easy development of Java EE applications.

---

## 2. Dependency Injection
Dependency Injection is the core of the Spring framework. It is used to inject beans inside a given reference variable.

---

## 3. What is Spring Boot?
Spring Boot is a module of Spring that speeds up application development. It simplifies the setup, configuration, and development of Spring applications.

---

## 4. Important Features of Spring Boot:
- Easy creation of stand-alone applications.
- Production-grade Spring-based applications that "just run."
- Faster setup and configuration for simple and web-based applications.

---

## 5. Advantages Of Spring Boot:
- Creates stand-alone Spring applications that can be started using `java -jar`.
- Simplifies configuration with `application.properties`.
- Embedded Tomcat is used for easy deployment.
- No need for XML configuration.

---

## 6. Important Goals of Spring Boot:
- Rapid Application Development.
- Opinionated defaults out of the box.
- Provides common non-functional features for large projects.

---

## 7. Spring vs. Spring Boot:
| Feature                | Spring                                          | Spring Boot                                 |
|------------------------|-------------------------------------------------|---------------------------------------------|
| Dependency Injection   | Complex due to XML-based configuration         | Simple and easier                           |
| Configuration          | Requires XML file configuration                | Uses `application.properties` file          |
| Tomcat Configuration   | Needs to be done separately                     | Embedded Jasper Tomcat, easy configuration  |
| Starter Tags           | No starter tags                                | Provides Spring starter tags                |

---

## 8. Spring Initializer:
Spring Initializer is used to create a Spring Boot project with pre-configured dependencies and settings.

---

## 9. What is Spring IOC Container?
Spring IOC (Inversion of Control) container consists of logic to perform Dependency Injection and manage Bean life cycles. There are two types:
1. **BeanFactory**
2. **ApplicationContext**

---

## 10. BeanFactory vs. ApplicationContext:
- **ApplicationContext** offers advanced features, whereas **BeanFactory** offers basic features.
- **ApplicationContext** implements the **BeanFactory** interface.

---

## 11. Bean Life Cycle:
1. IOC Container Started
2. Bean Instantiated
3. Dependency Injection
4. Custom `init()` method
5. Utility Methods
6. Custom `destroy()` method

---

## 12. Dependency Injection:
Dependency Injection is the core of the Spring framework and is used to inject beans into a given reference variable.

---

## 13. Session Management in Spring Boot:
1. Create a Spring Boot project using Spring Initializer.
2. Add Spring Session JDBC dependency in `pom.xml`.
3. Add JDBC properties in `application.properties`.

---

## 14. Session Tracking System:
Session Tracking is a way to maintain the state (data) of a user.

---

## 15. Spring Boot Scope:
The available scopes are:
- Singleton
- Prototype
- Request
- Session
- Global Session

---

## 16. Actuator in Spring Boot:
Actuator is used to expose operational information. It is a sub-project of Spring Boot.

---

## 17. Starter Tags in Spring Boot:
Spring Boot provides default configurations for Hibernate and other dependencies using starter tags.

---

## 18. `get()` vs. `load()`:

### `get()`:
1. Fetches data from the database for the given identifier.
2. Returns `null` if the object is not found.
3. Returns a fully initialized object (eager loading).
4. Slower than `load()` because it initializes objects fully.
5. Use `get()` when unsure if the object exists.

### `load()`:
1. Fetches data for the given identifier.
2. Throws an `ObjectNotFoundException` if the object does not exist.
3. Returns a proxy object (lazy loading).
4. Slightly faster than `get()`.
5. Use `load()` when sure the object exists.

---

## Spring Boot Annotations

### 1. Core Annotations
- **@SpringBootApplication**: Combines:
    - `@Configuration`: Marks a class as a source of bean definitions.
    - `@EnableAutoConfiguration`: Enables Spring Boot’s auto-configuration mechanism.
    - `@ComponentScan`: Scans for Spring components in the package and sub-packages.

---

### 2. Stereotype Annotations
- **@Component**: Marks a class as a Spring-managed component.
- **@Service**: Specialized `@Component` for service layer beans.
- **@Repository**: Specialized `@Component` for data access layer beans, also provides exception translation.
- **@Controller**: Specialized `@Component` for web controllers (used in MVC).
- **@RestController**: Combines `@Controller` and `@ResponseBody` for REST APIs.

---

### 3. Dependency Injection Annotations
- **@Autowired**: Automatically injects dependencies by type.
- **@Qualifier**: Used to disambiguate when multiple beans of the same type exist.
- **@Primary**: Indicates which bean should be given preference during autowiring.
- **@Lazy**: Creates beans lazily when needed.
- **@Value**: Injects values from application properties or environment variables.
- You can access the properties defined in application.properties or application.yml 
  in your Java classes by using @Value or the @ConfigurationProperties annotation.
- You can map properties to a Java class using @ConfigurationProperties
- Enable @ConfigurationProperties support in your main class using @EnableConfigurationProperties

---
### Exception in SpringBoot
- **ExceptionHandler**: It is used to handle exception locally or specific controller
- **@ControllerAdvice**: is used to handle exceptions globally across all controllers. You can use it to centralize your exception handling logic.
### 4. Configuration and Bean Management Annotations
- **@Configuration**: Indicates a class provides Spring bean definitions.
- **@Bean**: Defines a Spring-managed bean.
- **@Scope**: Specifies the scope of a bean (e.g., `singleton`, `prototype`).

---

### 5. Aspect-Oriented Programming (AOP) Annotations
- **@Aspect**: Marks a class as an aspect for AOP.
- **@Before**: Executes advice before a method execution.
- **@After**: Executes advice after a method execution.
- **@Around**: Wraps advice around method execution.
- **@Pointcut**: Defines reusable pointcuts.

---

### 6. Data Access (Spring Data JPA) Annotations
- **@Entity**: Marks a class as a JPA entity.
- **@Table**: Specifies the table name for a JPA entity.
- **@Id**: Marks the primary key field of an entity.
- **@GeneratedValue**: Specifies how the primary key should be generated.
- **@Column**: Maps a field to a table column.
- **@Transient**: Prevents a field from being persisted in the database.
- **@Repository**: Marks a class as a Spring Data repository.

---

### 7. Web Annotations
- **@RequestMapping**: Maps HTTP requests to handler methods.
- **@GetMapping**: Shortcut for `@RequestMapping` with `GET` method.
- **@PostMapping**: Shortcut for `@RequestMapping` with `POST` method.
- **@PutMapping**: Shortcut for `@RequestMapping` with `PUT` method.
- **@DeleteMapping**: Shortcut for `@RequestMapping` with `DELETE` method.
- **@PatchMapping**: Shortcut for `@RequestMapping` with `PATCH` method.
- **@PathVariable**: Extracts values from the URI path.
- **@RequestParam**: Binds query parameters from the request URI.
- **@RequestBody**: Maps the HTTP request body to a method parameter.
- **@ResponseBody**: Binds a method return value to the HTTP response body.
- **@CrossOrigin**: Enables Cross-Origin Resource Sharing (CORS) for a method or controller.

---

### 8. Validation Annotations
- **@Valid**: Triggers validation for a method parameter or field.
- **@NotNull**, **@Size**, **@Pattern**, etc.: Hibernate Validator annotations for field validation.

---

### 9. Security Annotations
- **@EnableWebSecurity**: Enables Spring Security for the application.
- **@PreAuthorize**: Adds method-level security with SpEL expressions.
- **@PostAuthorize**: Adds post-execution security with SpEL.
- **@Secured**: Restricts access based on roles.
- **@RolesAllowed**: Similar to `@Secured` but follows JSR-250 standards.

---

### 10. Scheduling and Asynchronous Processing Annotations
- **@EnableScheduling**: Enables scheduling support in Spring.
- **@Scheduled**: Defines scheduled tasks.
- **@Async**: Enables asynchronous processing for methods.

---

### 11. Actuator Annotations
- **@Endpoint**: Custom actuator endpoints.
- **@ReadOperation**, **@WriteOperation**: Define read/write operations for actuator endpoints.

---

### 12. Spring Cloud Annotations
- **@EnableEurekaClient**: Enables a service to register with a Eureka server.
- **@EnableConfigServer**: Turns the application into a configuration server.
- **@HystrixCommand**: Used for circuit breaker patterns.

---

### 13. Test Annotations
- **@SpringBootTest**: Boots up the full application context for testing.
- **@MockBean**: Creates a mock of a bean in the application context.
- **@WebMvcTest**: Tests Spring MVC controllers without starting the entire context.
- **@DataJpaTest**: Tests JPA repositories with minimal configurations.
- **@TestPropertySource**: Specifies property files or inline properties for tests.

---
### 1.WebServices
- Web services help us to integrate hetrogeneous and homogeneous applications.
Boooking Ticket,Amozan Web Services

### Type of WebServices
Two Ways:
1. SOAP: Simple Object Access Protocol :
exchange data between application using Xml file.
implementation of webservices complex
2. RESTFull: Representational state Transfer:
exchange data between using json object
also suport xml files.
easy

# Unit Testing in Spring Boot

Unit testing in Spring Boot ensures that individual components of your application work as expected in isolation. This guide covers key concepts, setup, and examples for effective unit testing.

---

## **Key Concepts of Unit Testing in Spring Boot**
1. **Purpose**: Verify the smallest units (classes or methods) in isolation.
2. **Frameworks**:
  - **JUnit**: For writing and executing tests.
  - **Mockito**: For mocking dependencies.
3. **Annotations**:
  - `@Test`: Marks a test method.
  - `@Mock`: Creates a mock instance of a class.
  - `@InjectMocks`: Injects mocks into the class being tested.
  - `@BeforeEach`: Executes code before each test.
  - `@ExtendWith`: Integrates JUnit 5 with Spring Boot or Mockito.

---

## **Setup**
### **Include Dependencies**
Add these dependencies in your `pom.xml` or `build.gradle` file:

#### **Maven**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <scope>test</scope>
</dependency>
```

#### **Gradle**
```gradle
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.mockito:mockito-core'
```

### **Test Class Structure**
Store your test classes in `src/test/java`.

---

## **Steps to Write Unit Tests**

1. **Mock Dependencies**: Use `@Mock` or `Mockito.mock()` to create fake instances of dependencies.

2. **Inject Mocks**: Use `@InjectMocks` to inject mocked dependencies into the class under test.

3. **Write Test Cases**: Use assertions (`Assertions` in JUnit) to verify expected outcomes.

4. **Run Tests**: Use IDE features, `mvn test`, or `gradle test` commands to execute.

---

## **Example: Service Layer Test**

### **Service Code**
```java
@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public BankAccount getAccountDetails(String accountId) {
        return bankRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}
```

### **Test Code**
```java
@ExtendWith(MockitoExtension.class)
class BankServiceTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankService bankService;

    @Test
    void getAccountDetails_ReturnsAccount_WhenAccountExists() {
        // Arrange
        String accountId = "12345";
        BankAccount account = new BankAccount(accountId, "John Doe", 1000.0);
        Mockito.when(bankRepository.findById(accountId)).thenReturn(Optional.of(account));

        // Act
        BankAccount result = bankService.getAccountDetails(accountId);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(accountId, result.getId());
    }

    @Test
    void getAccountDetails_ThrowsException_WhenAccountNotFound() {
        // Arrange
        String accountId = "12345";
        Mockito.when(bankRepository.findById(accountId)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> bankService.getAccountDetails(accountId));
    }
}
```

---

## **Tips for Effective Unit Testing**

1. **Test Edge Cases**: Cover positive and negative scenarios.
2. **Mock External Interactions**: Avoid calling actual databases or services.
3. **Keep Tests Isolated**: Ensure one test doesn't affect others.
4. **Follow Naming Conventions**:
  - Use descriptive names (e.g., `methodName_StateUnderTest_ExpectedBehavior`).
5. **Measure Coverage**: Use tools like JaCoCo or SonarQube for coverage analysis.

---



# Git Commands Guide

## **Getting Started with Git**

### **1. Install Git**
- Download from [Git Website](https://git-scm.com/).
- Follow the installation process (Windows, macOS, Linux instructions).

### **2. Configure Git (Global Settings)**
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
git config --global core.editor "code"  # Optional: Set VS Code or any editor
```

- Check configurations:
```bash
git config --list
```

---

## **Basic Commands**

### **1. Initialize Repository**
```bash
git init
```
- Creates a new empty Git repository in the current directory.

### **2. Clone a Repository**
```bash
git clone <repository-url>
```
- Copies an existing repository to your local system.

### **3. Check Repository Status**
```bash
git status
```
- Shows changes to tracked and untracked files in the repository.

### **4. Add Files to Staging**
```bash
git add <file-name>  # Stage specific file
git add .            # Stage all changes
```

### **5. Commit Changes**
```bash
git commit -m "Your commit message"
```
- Saves changes with a descriptive message.

### **6. View Commit History**
```bash
git log             # Full commit history
git log --oneline   # Compact one-line history
```

---

## **Branching and Merging**

### **1. Create a New Branch**
```bash
git branch <branch-name>
```

### **2. Switch to a Branch**
```bash
git checkout <branch-name>
```

### **3. Create and Switch to a Branch**
```bash
git checkout -b <branch-name>
```

### **4. Merge Branch**
```bash
git merge <branch-name>
```
- Merges specified branch into the current branch.

### **5. Delete a Branch**
```bash
git branch -d <branch-name>  # Delete locally
git push origin --delete <branch-name>  # Delete from remote
```

---

## **Remote Repositories**

### **1. Add Remote Repository**
```bash
git remote add origin <repository-url>
```

### **2. Push Changes to Remote**
```bash
git push origin <branch-name>   # Push specific branch
git push -u origin main         # First push, sets upstream
```

### **3. Pull Changes from Remote**
```bash
git pull origin <branch-name>
```

### **4. Fetch Changes (Without Merge)**
```bash
git fetch origin
```

---

## **Undoing Changes**

### **1. Discard Changes**
```bash
git checkout -- <file-name>
```

### **2. Unstage a File**
```bash
git reset <file-name>
```

### **3. Reset Commit**
```bash
git reset --soft HEAD~1  # Keep changes in staging
git reset --hard HEAD~1  # Discard changes permanently
```

### **4. Revert Commit**
```bash
git revert <commit-hash>
```
- Creates a new commit that undoes the specified commit.

---

## **Stashing**

### **1. Stash Changes**
```bash
git stash
```

### **2. List Stashed Changes**
```bash
git stash list
```

### **3. Apply Stashed Changes**
```bash
git stash apply
```

---

## **Collaborating with Others**

### **1. Check Remote Repositories**
```bash
git remote -v
```

### **2. View Difference**
```bash
git diff
```

### **3. Resolve Merge Conflicts**
- Open conflicting files.
- Manually resolve conflicts (`HEAD`, branch name).
- Add the resolved file:
```bash
git add <file-name>
```
- Commit changes:
```bash
git commit
```

---

## **Advanced Commands**

### **1. Amend Last Commit**
```bash
git commit --amend -m "New commit message"
```

### **2. Create a Tag**
```bash
git tag <tag-name>
git push origin <tag-name>
```

### **3. Rebase Branch**
```bash
git rebase <branch-name>
```
- Reapply commits on top of another base branch.

### **4. Cherry-Pick Commit**
```bash
git cherry-pick <commit-hash>
```
- Apply a specific commit to the current branch.

---

## **Best Practices**
1. **Use Descriptive Commit Messages**:
  - Follow the format: `<type>(<scope>): <subject>`.
  - Example: `fix(auth): resolve login bug`.

2. **Pull Before Pushing**:
   ```bash
   git pull origin <branch-name>
   git push origin <branch-name>
   ```

3. **Avoid Force Push**:
   ```bash
   git push -f  # Use sparingly; may overwrite others' changes.
   ```

4. **Work with Feature Branches**:
  - Avoid directly working on `main`.

---



