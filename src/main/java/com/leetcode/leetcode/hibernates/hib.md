1. Difference between Hibernate and JDBC?
   JDBC                                       |       Hibernate
 ________________________________________________________________________________________
    1. It is database connectivity Technology  |     1. It is a framework
    2. It does not support Lazy Loading.       |     2. Hibernate support lazy loading
    3. we need to maintain explicit database
    connection and transaction.                |     3.Hibernate itself manage all transaction
    4. Low performance                         |     4. High performance

2. What is Hibernate?
   Hibernate is ORM(object relation Mapping) .It does convert object into table and store data to the table.
   The hole configuration handle by hibernate.cfg xml file.
   ADVANTAGE: I can do transaction to different database more easy.
3. Why we are doing this?
   Because avoid write SQL Query. In JDBC write increasing the number of code and required write the SQL Query.
   Maintain to be default.If update one database to another database to required write SQL Query but hibernate is tranasaction quite easy.
   Hibernate control with annotation. To use hibernate to download Hibernate jar.

4. What is ORM?
   ORM: Object Relation Mapping
   ORM which means translation the object into data base table and then storing the data into table with the help of hibernate.

5. POJO: Plain Old Java Object
   POJO class responsible only initialize the variable and read the variable using setter and getter.
   working with hibernate required pojo.

6. What is JPA?
   JPA(Java Persistence API) is a concept of taking the object content and map it into the database by using ORM.
7. Difference between JPA and Hibernate?
   JPA(Java Persistence API) is a concept of taking the object content and map it into the database by using ORM.
   and implementation done by hibernate.

8. What is Hibernate JPA?
   The implementation of JPA can be done by using Hibernate.

9. JPA annotation:
   @Entity-It defined which java class is mapped to DB table.
   @Table- depend on requirement when db table and table name not requred same.
   @Id-primary key column of DB
   @GeneratedValue-It helps us to auto-increment value of variable in entity class while saving record in DB.

10. What is Dialect?
    It helps us to generate write sql query in particular DB.

11. create Hibernate cfgXmlfile
    To create a Hibernate configuration XML file (hibernate.cfg.xml), you need to define the database connection settings, dialect, and mappings for your entities.
    Here’s a sample hibernate.cfg.xml for the complex banking system defined earlier:

hibernate.cfg.xml
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
    "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <!-- JDBC Database connection settings -->
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/banking_db</property>
        <property name="hibernate.connection.username">your_username</property>
        <property name="hibernate.connection.password">your_password</property>

        <!-- JDBC connection pool settings -->
        <property name="hibernate.c3p0.min_size">5</property>
        <property name="hibernate.c3p0.max_size">20</property>
        <property name="hibernate.c3p0.timeout">300</property>
        <property name="hibernate.c3p0.max_statements">50</property>
        <property name="hibernate.c3p0.idle_test_period">3000</property>

        <!-- SQL dialect -->
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Enable Hibernate's automatic session context management -->
        <property name="hibernate.current_session_context_class">thread</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="hibernate.show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hibernate.hbm2ddl.auto">update</property>

        <!-- Mention annotated classes -->
        <mapping class="com.bankingsystem.Customer"/>
        <mapping class="com.bankingsystem.Account"/>
        <mapping class="com.bankingsystem.Transaction"/>
        <mapping class="com.bankingsystem.Branch"/>
        <mapping class="com.bankingsystem.Employee"/>
        <mapping class="com.bankingsystem.Loan"/>
        <mapping class="com.bankingsystem.CreditCard"/>
    </session-factory>
</hibernate-configuration>


    Explanation of Configuration Properties
    JDBC Database connection settings:

    hibernate.connection.driver_class: Specifies the JDBC driver class for the database.
    hibernate.connection.url: The URL of the database.
    hibernate.connection.username: The username to connect to the database.
    hibernate.connection.password: The password to connect to the database.
    JDBC connection pool settings:

    hibernate.c3p0.min_size: The minimum size of the connection pool.
    hibernate.c3p0.max_size: The maximum size of the connection pool.
    hibernate.c3p0.timeout: The maximum time in seconds a connection can remain idle in the pool before being removed.
    hibernate.c3p0.max_statements: The number of prepared statements that will be cached.
    hibernate.c3p0.idle_test_period: The number of seconds between testing idle connections.
    SQL dialect:

    hibernate.dialect: Specifies the SQL dialect for the database (in this case, MySQL).
    Enable Hibernate's automatic session context management:

    hibernate.current_session_context_class: The strategy for the current session context (using thread-based context management).
    Echo all executed SQL to stdout:

    hibernate.show_sql: When set to true, Hibernate will print all SQL statements to the console.
    Drop and re-create the database schema on startup:

    hibernate.hbm2ddl.auto: Setting this to update means Hibernate will update the database schema when the application starts.
    Mapping annotated classes:

    <mapping class="com.bankingsystem.EntityClass"/>: Specifies the entity classes that Hibernate should manage.
    Usage
    Place this hibernate.cfg.xml file in the src/main/resources directory of your project. Ensure that the Customer, Account, Transaction, Branch, Employee, Loan, and CreditCard classes are properly annotated with @Entity and have the necessary mappings as defined previously.

12. Hibernate Architecture:
    four layer
1. Java application Layer
2. Hibernate Framework Layer.
3. Backend Api Layer.
4. Database Layer.

13. HQL: Hibernate Query Language
    It is help us to perform CRUD operation.
    CRUD-create,retrieve,update, Delete

14. Hibernate Query Language (HQL) is an object-oriented query language similar to SQL, but it operates on the objects and their properties rather than directly on database tables. HQL is case-insensitive, except for the names of Java classes and properties. Here are some examples of HQL queries for the complex banking system described earlier:
    Basic HQL Queries
    Select All Customers
    String hql = "FROM Customer";
    Query query = session.createQuery(hql);
    List<Customer> customers = query.list();
    Select a Customer by ID
    String hql = "FROM Customer WHERE id = :customerId";
    Query query = session.createQuery(hql);
    query.setParameter("customerId", 1L);
    Customer customer = (Customer) query.uniqueResult();
    Select All Accounts for a Specific Customer
    String hql = "FROM Account WHERE customer.id = :customerId";
    Query query = session.createQuery(hql);
    query.setParameter("customerId", 1L);
    List<Account> accounts = query.list();
    Joins
    Inner Join to Fetch Customers with Their Accounts

String hql = "SELECT c FROM Customer c INNER JOIN c.accounts a";
Query query = session.createQuery(hql);
List<Customer> customers = query.list();

Fetch Accounts and Their Branch Details
String hql = "SELECT a FROM Account a INNER JOIN a.branch b";
Query query = session.createQuery(hql);
List<Account> accounts = query.list();

Filtering and Sorting
Fetch Transactions for an Account within a Date Range
String hql = "FROM Transaction t WHERE t.account.id = :accountId AND t.date BETWEEN :startDate AND :endDate";
Query query = session.createQuery(hql);
query.setParameter("accountId", 1L);
query.setParameter("startDate", startDate);
query.setParameter("endDate", endDate);
List<Transaction> transactions = query.list();


Fetch All Customers Ordered by Name
String hql = "FROM Customer c ORDER BY c.name";
Query query = session.createQuery(hql);
List<Customer> customers = query.list();

Pagination
Fetch Customers with Pagination
String hql = "FROM Customer";
Query query = session.createQuery(hql);
query.setFirstResult(0); // starting index
query.setMaxResults(10); // number of records to fetch
List<Customer> customers = query.list();

15. Session and SessionFactory in hibernate.
    -->It is available for the whole application while a session is only available for particular transaction.
    --->Session is short-lived while session factory objects are long lived.
    --->Session factory provided a second level catch and session provided a first level cache.

Session and Transaction Management
16. What is the role of SessionFactory in Hibernate?

Answer: SessionFactory is a factory for Session objects.
It is a heavyweight object that is usually created once during application startup.
It holds the configuration settings and provides methods to obtain Session instances for interacting with the database.

17.What is the difference between Session.get() and Session.load() methods?

Answer: Session.get() retrieves an entity by its identifier, returning null if the entity does not exist.
It always hits the database to fetch the entity.

Session.load() returns a proxy object without hitting the database immediately;
the database is queried only when the object is accessed. If the entity does not exist, it throws an exception.

18. What is hibernate.hbm2ddl.auto property and what are its values?

    Answer: The hibernate.hbm2ddl.auto property is used to specify how Hibernate should handle the database schema. Its values include:
    validate: Validate the schema, makes no changes to the database.
    update: Update the schema, keeping existing data.
    create: Creates the schema, destroying existing data.
    create-drop: Create the schema and drop it when the SessionFactory is closed.


Sure! Here are some theory questions related to Hibernate that are commonly asked in interviews, along with brief answers to help you prepare:

Basic Concepts
What is Hibernate?

Answer: Hibernate is an open-source Object-Relational Mapping (ORM) framework for Java applications. It provides a framework for mapping an object-oriented domain model to a relational database and handles the conversion between Java objects and database tables.
What are the advantages of using Hibernate?

Answer: Hibernate offers several advantages, including:
Simplifies complex database operations by handling SQL generation.
Provides an abstraction layer that hides database-specific details.
Supports lazy loading and caching to improve performance.
Offers automatic table creation and schema validation.
Provides support for HQL (Hibernate Query Language) and Criteria API for querying the database.
What is the difference between Hibernate and JDBC?

Answer: JDBC (Java Database Connectivity) is a low-level API for interacting with databases using SQL. Hibernate, on the other hand, is a high-level ORM framework that abstracts away the details of database interactions and allows developers to work with objects rather than SQL statements.
Configuration and Setup
What is a Hibernate configuration file and what does it contain?

Answer: A Hibernate configuration file (hibernate.cfg.xml) contains configuration settings for Hibernate, such as database connection details, dialect, and mappings for entity classes. It is used to configure Hibernate SessionFactory.
What is hibernate.hbm2ddl.auto property and what are its values?

Answer: The hibernate.hbm2ddl.auto property is used to specify how Hibernate should handle the database schema. Its values include:
validate: Validate the schema, makes no changes to the database.
update: Update the schema, keeping existing data.
create: Creates the schema, destroying existing data.
create-drop: Create the schema and drop it when the SessionFactory is closed.
Mapping and Annotations
What is the difference between @Entity and @Table annotations?

Answer: The @Entity annotation is used to mark a Java class as an entity (a persistent class). The @Table annotation is used to specify the table name in the database that the entity is mapped to. If @Table is not specified, the table name defaults to the entity class name.
Explain the difference between @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany annotations.

Answer:
@OneToOne: A one-to-one association between two entities.
@OneToMany: A one-to-many association, where one entity is associated with a collection of another entity.
@ManyToOne: A many-to-one association, where many instances of one entity are associated with a single instance of another entity.
@ManyToMany: A many-to-many association between two entities, often involving a join table to manage the relationships.
Session and Transaction Management
What is the role of SessionFactory in Hibernate?

Answer: SessionFactory is a factory for Session objects. It is a heavyweight object that is usually created once during application startup. It holds the configuration settings and provides methods to obtain Session instances for interacting with the database.
What is the difference between Session.get() and Session.load() methods?

Answer: Session.get() retrieves an entity by its identifier, returning null if the entity does not exist. It always hits the database to fetch the entity. Session.load() returns a proxy object without hitting the database immediately; the database is queried only when the object is accessed. If the entity does not exist, it throws an exception.
Querying
What is HQL and how does it differ from SQL?

Answer: HQL (Hibernate Query Language) is an object-oriented query language similar to SQL but operates on entity objects and their properties instead of database tables and columns. HQL queries are translated to SQL queries by Hibernate.
Explain the Criteria API in Hibernate.

Answer: The Criteria API is a programmatic way to create queries in Hibernate. It allows developers to build queries using a fluent API, providing a more flexible and type-safe approach compared to HQL. Criteria API is useful for creating dynamic queries.
Caching
What is caching in Hibernate and what are its types?

Answer: Caching in Hibernate improves performance by reducing the number of database hits. Hibernate supports two levels of caching:
First-level cache: The session-level cache that is enabled by default. It caches entities within a single session.
Second-level cache: A global cache that can be configured for the entire application. It caches entities across multiple sessions.
Explain the concept of lazy loading in Hibernate.

Answer: Lazy loading is a design pattern used to defer initialization of an object until it is needed. In Hibernate, lazy loading means that associated entities are not loaded from the database until they are accessed. This helps to improve performance by avoiding unnecessary database queries.
Miscellaneous
What is the N+1 Select problem in Hibernate and how can it be avoided?

Answer: The N+1 Select problem occurs when Hibernate executes one query to load a parent entity and then N additional queries to load associated child entities. This can be avoided using fetching strategies such as fetch join in HQL, @Fetch annotation, or batch fetching.
What is the difference between merge() and update() methods in Hibernate?

Answer: merge() copies the state of a detached entity into the persistent context, returning a managed entity instance. It can be used for both new and detached entities. update() is used to associate a detached entity with the current session, and it assumes that the entity is already present in the database.
These questions cover a wide range of Hibernate topics, providing a solid foundation for preparing for Hibernate-related interview questions.

Querying
Q. What is HQL and how does it differ from SQL?

Answer: HQL (Hibernate Query Language) is an object-oriented query language similar to SQL but operates on entity objects and their properties instead of database tables and columns. HQL queries are translated to SQL queries by Hibernate.

Q. Explain the Criteria API in Hibernate.

Answer: The Criteria API is a programmatic way to create queries in Hibernate. It allows developers to build queries using a fluent API, providing a more flexible and type-safe approach compared to HQL. Criteria API is useful for creating dynamic queries.

Caching
Q. What is caching in Hibernate and what are its types?

Answer: Caching in Hibernate improves performance by reducing the number of database hits. Hibernate supports two levels of caching:
First-level cache: The session-level cache that is enabled by default. It caches entities within a single session.
Second-level cache: A global cache that can be configured for the entire application. It caches entities across multiple sessions.

Q.Explain the concept of lazy loading in Hibernate.

Answer: Lazy loading is a design pattern used to defer initialization of an object until it is needed. In Hibernate, lazy loading means that associated entities are not loaded from the database until they are accessed. This helps to improve performance by avoiding unnecessary database queries.
Miscellaneous

Q. What is the N+1 Select problem in Hibernate and how can it be avoided?

Answer: The N+1 Select problem occurs when Hibernate executes one query to load a parent entity and then N additional queries to load associated child entities. This can be avoided using fetching strategies such as fetch join in HQL, @Fetch annotation, or batch fetching.

Q. What is the difference between merge() and update() methods in Hibernate?

Answer: merge() copies the state of a detached entity into the persistent context, returning a managed entity instance. It can be used for both new and detached entities. update() is used to associate a detached entity with the current session, and it assumes that the entity is already present in the database.




Example HQL Usage in a DAO Class
Here’s how you can use HQL in a DAO class:

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class CustomerDAO {

    private SessionFactory sessionFactory;

    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> getAllCustomers() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Customer";
            Query query = session.createQuery(hql);
            return query.list();
        }
    }

    public Customer getCustomerById(Long customerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Customer WHERE id = :customerId";
            Query query = session.createQuery(hql);
            query.setParameter("customerId", customerId);
            return (Customer) query.uniqueResult();
        }
    }

    public List<Account> getAccountsByCustomerId(Long customerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Account WHERE customer.id = :customerId";
            Query query = session.createQuery(hql);
            query.setParameter("customerId", customerId);
            return query.list();
        }
    }

    // Other DAO methods
}
<dependencies>
<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-core</artifactId>
<version>5.4.32.Final</version>
</dependency>
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.23</version>
</dependency>
<dependency>
<groupId>javax.persistence</groupId>
<artifactId>javax.persistence-api</artifactId>
<version>2.2</version>
</dependency>
<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-c3p0</artifactId>
<version>5.4.32.Final</version>
</dependency>
</dependencies>



package com.bankingsystem.dao;

import com.bankingsystem.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BankingDAO {

    private SessionFactory sessionFactory;

    public BankingDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Customer Operations
    public List<Customer> getAllCustomers() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Customer";
            Query<Customer> query = session.createQuery(hql, Customer.class);
            return query.list();
        }
    }

    public Customer getCustomerById(Long customerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Customer WHERE id = :customerId";
            Query<Customer> query = session.createQuery(hql, Customer.class);
            query.setParameter("customerId", customerId);
            return query.uniqueResult();
        }
    }

    public void saveCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Long customerId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                session.delete(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Account Operations
    public List<Account> getAccountsByCustomerId(Long customerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Account WHERE customer.id = :customerId";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("customerId", customerId);
            return query.list();
        }
    }

    public Account getAccountById(Long accountId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Account.class, accountId);
        }
    }

    public void saveAccount(Account account) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteAccount(Long accountId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Account account = session.get(Account.class, accountId);
            if (account != null) {
                session.delete(account);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Transaction Operations
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Transaction WHERE account.id = :accountId";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("accountId", accountId);
            return query.list();
        }
    }

    public void saveTransaction(Transaction transaction) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(transaction);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Branch Operations
    public List<Branch> getAllBranches() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Branch";
            Query<Branch> query = session.createQuery(hql, Branch.class);
            return query.list();
        }
    }

    public Branch getBranchById(Long branchId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Branch.class, branchId);
        }
    }

    public void saveBranch(Branch branch) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(branch);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteBranch(Long branchId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Branch branch = session.get(Branch.class, branchId);
            if (branch != null) {
                session.delete(branch);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Employee Operations
    public List<Employee> getAllEmployees() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Employee";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            return query.list();
        }
    }

    public Employee getEmployeeById(Long employeeId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, employeeId);
        }
    }

    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Long employeeId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Loan Operations
    public List<Loan> getLoansByCustomerId(Long customerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Loan WHERE customer.id = :customerId";
            Query<Loan> query = session.createQuery(hql, Loan.class);
            query.setParameter("customerId", customerId);
            return query.list();
        }
    }

    public Loan getLoanById(Long loanId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Loan.class, loanId);
        }
    }

    public void saveLoan(Loan loan) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(loan);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteLoan(Long loanId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Loan loan = session.get(Loan.class, loanId);
            if (loan != null) {
                session.delete(loan);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // CreditCard Operations
    public CreditCard getCreditCardByCustomerId(Long customerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM CreditCard WHERE customer.id = :customerId";
            Query<CreditCard> query = session.createQuery(hql, CreditCard.class);
            query.setParameter("customerId", customerId);
            return query.uniqueResult();
        }
    }

    public void saveCreditCard(CreditCard creditCard) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(creditCard);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteCreditCard(Long creditCardId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CreditCard creditCard = session.get(CreditCard.class, creditCardId);
            if (creditCard != null) {
                session.delete(creditCard);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
Notes
This DAO class assumes that the Hibernate SessionFactory is properly configured and injected.
Each method opens a new session and manages transactions within the session.
The sessionFactory should be initialized in a configuration class or utility class and passed to the DAO class.


Configuration and Initialization
Ensure you have a utility class to create the SessionFactory. Here’s an example:
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

Here’s an example of how you might use the BankingDAO class:

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        BankingDAO dao = new BankingDAO(sessionFactory);

        // Example: Fetch all customers
        List<Customer> customers = dao.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }

        // Example: Save a new customer
        Customer newCustomer = new Customer();
        newCustomer.setName("John Doe");
        dao.saveCustomer(newCustomer);

        // Other operations...
    }
}




