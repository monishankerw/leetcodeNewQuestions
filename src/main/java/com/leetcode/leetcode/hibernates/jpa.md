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