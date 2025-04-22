# ✅ Design Patterns Interview Notes (For 4.8 Years Experience)

---

## 🧩 1. What are Design Patterns?
Design Patterns are proven solutions to common problems in software design. They are **templates** or **blueprints**, not code.

---

## 🏗 2. Classification of Design Patterns

| Type            | Description                                     | Common Patterns                               |
|-----------------|--------------------------------------------------|------------------------------------------------|
| **Creational**  | Object creation mechanisms                      | Singleton, Factory, Builder, Prototype        |
| **Structural**  | Object composition & relationships               | Adapter, Decorator, Proxy, Facade, Composite  |
| **Behavioral**  | Object communication and responsibility handling | Strategy, Observer, Command, Template, State  |

---

## 🎯 3. Top 10 Interview-Focused Design Patterns with Real Use Cases

### 🔹 1. Singleton Pattern
- **Goal:** Ensure one instance of a class.
- **Use Case:** Logger, Config Manager, DB Connection Pool.
- **Code Hint:** Private constructor, static instance getter.
- **Interview Tip:** Thread-safe lazy instantiation (use `synchronized` or Bill Pugh method).

### 🔹 2. Factory Pattern
- **Goal:** Delegate object creation logic to a factory class.
- **Use Case:** Payment gateway processor (`createProcessor(String type)`).
- **Code Hint:** Interface + Multiple implementations + Factory class.
- **Interview Tip:** Good for **Open/Closed Principle**.

### 🔹 3. Builder Pattern
- **Goal:** Step-by-step object construction (especially for immutability).
- **Use Case:** DTOs with many optional fields.
- **Code Hint:** Inner static Builder class.
- **Interview Tip:** Used in libraries like Lombok, StringBuilder.

### 🔹 4. Strategy Pattern
- **Goal:** Choose algorithm at runtime.
- **Use Case:** Sorting algorithms, discount strategies, payment flow.
- **Code Hint:** Interface + multiple implementations + runtime selection.
- **Interview Tip:** Enables **Open/Closed Principle**.

### 🔹 5. Observer Pattern
- **Goal:** Notify subscribers when subject changes.
- **Use Case:** Notification system, Kafka listeners.
- **Code Hint:** Subject/Observer interfaces + register/notify methods.
- **Interview Tip:** Used in **event-driven systems**.

### 🔹 6. Decorator Pattern
- **Goal:** Add behavior to objects dynamically.
- **Use Case:** Logging, Security, UI enhancements.
- **Code Hint:** Same interface, wraps another object.
- **Interview Tip:** Alternative to subclassing.

### 🔹 7. Adapter Pattern
- **Goal:** Bridge between incompatible interfaces.
- **Use Case:** Integrating old APIs with new systems.
- **Code Hint:** Wrap existing object and convert interfaces.
- **Interview Tip:** Used heavily in **Spring**, legacy modernization.

### 🔹 8. Command Pattern
- **Goal:** Encapsulate a request as an object.
- **Use Case:** Undo/Redo in editor, Task Queues.
- **Code Hint:** Command interface + Receiver + Invoker.
- **Interview Tip:** Used in job schedulers, UI actions.

### 🔹 9. Proxy Pattern
- **Goal:** Control access to an object (lazy loading, caching, security).
- **Use Case:** Database access, authentication proxy.
- **Code Hint:** Same interface, adds extra logic before delegating.
- **Interview Tip:** Related to **Spring AOP**.

### 🔹 10. Template Method Pattern
- **Goal:** Define skeleton of an algorithm, defer steps to subclasses.
- **Use Case:** Frameworks (Spring `AbstractController`).
- **Interview Tip:** Ensures code reuse and consistency.

---

## 📚 4. Design Pattern Interview Questions (with Best Answers)

| Question | What They Check |
|---------|------------------|
| What is a Singleton and where have you used it? | Basic understanding + practical use |
| How would you design a payment system? | Use of Factory + Strategy |
| How do you avoid tight coupling in design? | Design principles + patterns like Strategy/Observer |
| How would you integrate a legacy system? | Adapter pattern use |
| How do you implement logging dynamically? | Decorator or Proxy |
| Can you design a real-time notification system? | Observer pattern |
| How does Spring use design patterns internally? | Shows framework awareness |
| Have you applied these patterns in real projects? | Experience-based implementation |

---

## 🔁 5. Combine Patterns in Real Systems

### 🧾 Example: Notification Service Design
- **Factory Pattern** → Creates Email/SMS/Push service.
- **Strategy Pattern** → Selects channel based on user preference.
- **Observer Pattern** → Triggers notifications on events.
- **Builder Pattern** → Builds NotificationPayload.

---

## ⚙️ 6. Java Frameworks Using Design Patterns

| Pattern       | Framework Usage                             |
|---------------|---------------------------------------------|
| Singleton     | Spring Beans (Default is Singleton)         |
| Factory       | Spring BeanFactory                          |
| Proxy         | Spring AOP, Hibernate Lazy Loading          |
| Strategy      | Spring Security Filter Chain                |
| Template      | JdbcTemplate, RestTemplate                  |
| Observer      | ApplicationEventPublisher in Spring         |

---

## 📖 7. Tips for Interviews (4.5–5 YOE)
- Focus on **real use cases** from your past projects.
- Explain **why** you chose a pattern, not just what it is.
- Be ready to combine patterns.
- Always relate to **SOLID principles** and **clean code**.

