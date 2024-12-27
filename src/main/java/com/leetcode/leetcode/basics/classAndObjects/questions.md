## 8. Why Java Doesn’t Use Pointers
Java handles memory management internally to prevent accidental memory manipulation and improve security. It uses references instead of explicit pointers.

---

## 9. Out of Memory Error
Occurs when JVM cannot allocate space for an object due to insufficient heap memory, resulting in a runtime error.
```
```
### Q. Is Java Pass-by-Value or Pass-by-Reference?
- Java is **pass-by-value**.
  - For **primitive types** (e.g., `int`, `double`): A copy of the value is passed, so changes inside a method don’t affect the original variable.
  - For **objects**: A copy of the reference (not the object itself) is passed, meaning you can modify the object's data, but not the reference itself.

---

### Q. Is Java Call-by-Value or Call-by-Reference?
- Java is **call-by-value** for both primitive types and objects:
  - For **primitives**: A copy of the value is passed.
  - For **objects**: A copy of the reference is passed. You can modify the object's internal state, but reassigning it won’t change the original reference outside the method.

---

### Q. Shallow Copy and Deep Copy
- **Shallow Copy**: Copies only the top-level object. Nested objects are shared, so changes to them affect both the original and the copy. Example: `Object.clone()`.
- **Deep Copy**: Copies the entire object graph, including nested objects. Changes to the copy do not affect the original. Requires custom code or serialization.

---

### Q. Object Cloning and How to Achieve it in Java
**Object Cloning** in Java is creating a copy of an object with the same properties and state. It is mainly achieved using the `clone()` method from the `Cloneable` interface.

#### How to Achieve Cloning
1. **Implement `Cloneable` Interface**: Marks the class as "cloneable."
2. **Override `clone()` Method**: Make it `public`.
3. **Call `super.clone()`**: Performs a shallow copy.


```
```
Q. Cloning?
The Process of creating the replicable of a particular object by coping the context of one object completly into another object.

#### Types of Cloning
- **Shallow Copy**: Default behavior of `super.clone()`; copies only the object's immediate properties.
- **Deep Copy**: Manually clone nested objects within `clone()`.

> **Note**: Deep cloning can also be achieved using serialization libraries like Apache Commons or custom code.

---
