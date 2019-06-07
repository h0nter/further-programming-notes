# Lecture 3
### Warm up
```java
public class Foo{
  private int bar;
  
  public int getBar(){
    return bar;
  }
  
  public void setBar(int bar){
    this.bar = bar;
  }
}
```

### Inheritance
- public class B **extends A**{...}

### Abstraction
- Key concept on Object Orientation
- Inheritance is an abstraction technique allowing categorization accoding to shared characteristics

### Polymorphism
- Variables can be given a type of a super-class and then passed a sub-class (e.g. Person p = new Student())
- Can be used in collections

**Casting:**
- Putting a type of variable in front of the actual data to ensure the correct data type is used (e.g. (double)5 will produce 5.0)
- Use when there is not enough information for the compiler to figure it out.
- If there is a lot of casting in code - **RETHINK THE DESIGN!**