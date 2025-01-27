Lombok is a popular Java library used to reduce boilerplate code in Java classes. Here is a list of commonly used Lombok annotations:

1. Getter and Setter Annotations
   •	@Getter
   Generates getter methods for all fields or specific ones.
   •	@Setter
   Generates setter methods for all fields or specific ones.

2. ToString Annotation
   •	@ToString
   Generates a toString() method including or excluding specific fields.
   Example:

@ToString(includeFieldNames = true)

3. Equals and HashCode Annotations
   •	@EqualsAndHashCode
   Generates equals() and hashCode() methods based on fields.

4. Data Annotation
   •	@Data
   A combination of @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor.

5. NoArgsConstructor, AllArgsConstructor, and RequiredArgsConstructor
   •	@NoArgsConstructor
   Generates a no-arguments constructor.
   •	@AllArgsConstructor
   Generates a constructor with all class fields.
   •	@RequiredArgsConstructor
   Generates a constructor for fields marked as final or @NonNull.

6. Builder Annotation
   •	@Builder
   Implements the Builder design pattern for object creation.

7. Log Annotations

Generates logging fields for different logging frameworks:
•	@Slf4j (for SLF4J)
•	@Log4j (for Log4j)
•	@Log4j2 (for Log4j2)
•	@CommonsLog (for Apache Commons Logging)
•	@JavaUtilLog (for java.util.logging).

8. Value Annotation
   •	@Value
   Marks a class as immutable (like making fields final, setting private constructors, etc.).

9. SneakyThrows Annotation
   •	@SneakyThrows
   Allows throwing checked exceptions without explicitly declaring them in the method signature.

10. Cleanup Annotation
    •	@Cleanup
    Automatically calls the close() method on resources (e.g., streams).

11. NonNull Annotation
    •	@NonNull
    Generates null-check statements for fields or method parameters.

12. UtilityClass Annotation
    •	@UtilityClass
    Marks a class as a utility class (making it final, private constructor, and all fields/methods static).

13. Delegate Annotation
    •	@Delegate
    Delegate method calls to another field or class.

14. SuperBuilder Annotation
    •	@SuperBuilder
    Generates builder methods for a class and its superclasses, supporting inheritance.

15. With Annotation
    •	@With
    Generates with methods for immutable classes (e.g., withFieldName).

These annotations reduce boilerplate code significantly and improve readability and maintainability.