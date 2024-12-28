# Access Modifiers in Java

| **Modifier**       | **Class** | **Package** | **Subclass (Different Package)** | **World (Other Classes)** |
|---------------------|-----------|-------------|-----------------------------------|---------------------------|
| **`public`**        | ✔         | ✔           | ✔                                 | ✔                         |
| **`protected`**     | ✔         | ✔           | ✔                                 | ✘                         |
| **Default** (No Modifier) | ✔         | ✔           | ✘                                 | ✘                         |
| **`private`**       | ✔         | ✘           | ✘                                 | ✘                         |

## Explanation of Modifiers

1. **`public`**:
    - Accessible from **anywhere** in the program.
    - Example:
      ```java
      public class Example {
          public String name = "Public";
      }
      ```

2. **`protected`**:
    - Accessible:
        - Within the same class.
        - Within the same package.
        - By subclasses (even in different packages).
    - Example:
      ```java
      public class Example {
          protected String name = "Protected";
      }
      ```

3. **Default** (No Modifier):
    - If no modifier is specified, the member is package-private.
    - Accessible:
        - Within the same class.
        - Within the same package.
    - Example:
      ```java
      class Example {
          String name = "Default";
      }
      ```

4. **`private`**:
    - Accessible only within the class it is declared in.
    - Ensures encapsulation.
    - Example:
      ```java
      public class Example {
          private String name = "Private";
      }
      ```

## Visual Representation

```plaintext
+-----------------------------------------------------+
|                    Access Levels                   |
+---------------+-----------+------------+-----------+
| Modifier      | Class     | Package    | Subclass  |
+---------------+-----------+------------+-----------+
| public        | ✅        | ✅         | ✅        |
| protected     | ✅        | ✅         | ✅        |
| default       | ✅        | ✅         | ❌        |
| private       | ✅        | ❌         | ❌        |
+---------------+-----------+------------+-----------+