# Lecture 4 - Inheritance Continued
### What is a wrapper class
- A primitive types can be **wrapped** in an object
- Can be **unwrapped** by using a getter to pull out a primitive data type
---

### Inheritance
- The root for all inheritance is the **Object** class
- Provides few common methods (e.g. toString(), equals())

**Overriding:**
- add @Override before the method signature
---

### toString() method
When calling
```java
String name = "Random Bash"
System.out.println(name);
```
Reference to the ***name*** actually calls the **toString()** method of the **String** (not Object) class.

---

### equals() method
By default it returns true **if and only if** two objects are **exactly the same (i.e. stored in the exact same memory location)**

- Not what's required most of the times

---

### Accessing Privates
- public
  - Available to all subclasses without reference to the class
  - Available to all other classes
- private
  - Only available within that one class
  - Subclasses can't access the field
  - Most appropriate in most casses, where knowledge of implementation is required to use the field.

---

### Summary

---

### Coursework
- Futoshiki logic puzzle
- Cells that can be filed with numbers
- Constraints between cells, which limit the numbers which can be input
- Use logic and deduction to complete the entire grid

**Mark breakdown:**
- Part 1 - A simple model
  - Data representation - 0% (already done!)
  - Tests and simple manipulation - 20%
  - Peer assesment - 5%
- Part 2 - A text version
  - More complex tests and manipulation - 20%
  - Refactor: introduce objects - 5%
- Part 3 - A graphical game
  - Graphical User Interface in JavaFX - 40%
  - Solving the puzzle! - 10%

**Use 3 x 2D arrays:**
- grid of digits using a doubly-indexed array of ints. Zero means empty
- Second array for horizontal constraints
- Third array for vertical constraints

