# Lecture 5 - Design, Composition and Interfaces
### Contents
- Design
  - CRC Cards
  - Composition versus Inheritance
- Mulitple Inheritance
- Interfaces
- Statics
  - Factory Methods
- Enums

---
### Warmup
**Write down the possible actions when buying a rail tickets from a machine:**
- select a destination
- time of travel
- ticket type
- railcards
- number of tickets
- select a specific train service and destination
- select payment method
- pay
- print the tickets
- collect the tickets, receipt
- collect change

---
### Design
**Responsibilities:**
- a class should be responsible for handling its own data
- don't hand-off your work to another class

**Coupling:**
- describes how interconnected the classes are
- **loose coupling** is good
- **tight coupling** -> change in one place = change in another place - **BAD!!!**
- **private fields** reduce coupling

**Cohesion:**
- the number and diversity of tasks a unit of code is responsible for
- consider classes and methods
- **one thing - one job** = GOOD

---
### Composition vs Inheritance
- "Prefer composition over inheritance"
- Inheritance is good when:
  - the possible subclass will usefully expose all the public interface of the superclass
  - the public interface of the superclass is general enough that you won't be changing it much and you're happy to be stuck

---
### CRC Cards

---
### Multiple Inheritance
- Java doesn't allow for direct multiple parents

**Interfaces:**
- abstract class with only abstract methods
e.g.
```java
public interface Iterarable{
  Iterator<T> iterator;
}
```
**Interface features:**
- no instance definitions
- no constructors
- no need to say a mathod is abstract (they all are)
- abstract methods are all **public**
- interface itself can be **public or package-private*

**Interface demo:**
```java
public interface Foo{
  public String displayString(); //CANNOT HAVE BODY
}

...

public class InterfaceDemo implements Foo {
  public static void main(String[] args){
    InterfaceDemo id = new InterfaceDemo();
    System.out.println(id.displayString());
  }
  
  @Override
  public String displayString(){
    return "I am a Foo";
  }
}
```

**Interface Inheritance:**
- **interface can extend multiple interfaces**
- an abstract class can implement an interface but leave some of the interface's methods as abstract

**Interface types:**
- interface defines a type in the same way as a class
- can use interface names in polymorphic variables and method calls int eh same way as class names
e.g.
```java
public class InterfaceDemo implements Foo,List {
  public static void main(String[] args){
    Foo id = new InterfaceDemo();
    System.out.println(id.displayString());
  }
  
  @Override
  public String displayString(){
    return "I am a Foo";
  }
```

### Interfaces Summary
- Allow us to specify required method signatures separately from their implementations
- Allow classes to take mulitple types
- The encapsulation of an interface can help good design with loose coupling

---
### Statics
**Static** - method that is defined once for the class - you don't need an instance

**Factory Methods:**
- Method defined at the class level
- Creates a new object of the class type
- Perform actions on it to it to ensure proper setup

e.g.
```java
public class Food{
  private String food;
  private Food(String meal){
    
  }
  
  public static Food getFood(){
    Food f = new Food();
    if (System.currentTimeMillis() > 1000) {
      f.food = "late";
    }else {
      f.food = "early";
    }
    return f;
  }
}
```

---
### *enum* types
**enum** - a way of defining a new "enumerated" type - a set of named values. **NOT A PRIMITIVE, NOT AS COMPLEX AS A CLASS**

**Syntax:**
```java
public enum VehicleType{
  CAR, TRUCK, BICYCLE;
}
```

**enum Points:**
- reference enum values by Type.VALUE syntax
- there is only ever one instance of a given value