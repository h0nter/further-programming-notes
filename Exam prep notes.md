# Exam prep notes

### Inheritance
- **Inheritance** - abstraction technique allowing classification according to shared characteristics

##### Wraper classes
- Primitives cannot be used in collections
- Wrap in an object to solve the problem
- Autoboxing/Autounboxing automatically puts primitives in and out of objects

##### Dynamic vs static types
- **Static type** - type of an object, defined in source code, by the programmer
- **Dynamic type** - type of the object defined on run-time, assigned to static type variables

##### Multiple Inheritance
- When a class can inherit from more than one super-class
- **Interfaces** in Java
---
#### LHS instanceof RHS
- Returns true if **dynamic type** of LHS is RHS or any subclass of RHS

---
### Desgin

##### Coupling
- **Coupling** - describes how interconnected classes are
- **Loose coupling** is GOOD
- **Tight coupling** - change in one plcace = change in another
- Private fields reduce coupling

##### Cohesion
- **Cohesion** - number and diversity of tasks a unit of code is repsonsible for
- **ONE THING = ONE JOB** Good
- Easier to reuse and adapt code

---
### Interfaces
```java
public interface Iterable{
  Iterator<T> iterator();
}
```
- only have abstract methods (no implementation)
- a class can implement multiple interfaces

```java
public class Hello extends World implements Uloloyo<E>, RandomAccess{}
```
- interface can be public or package private

##### Interface Inheritance
- Interface can **extend multiple** interfaces
- An **abstract class** can implement an interface and leave **some of its methods empty**

---
#### Factory Methods
- Using the context (when the program is running) to set-up and specialize a particular object

---
### JavaFX - Event Handling

##### Inner Classes
```java
private Button brb = new Button("Big Red Button");
... brb.setOnAction(new BigRedButtonHandler());...

class BigRedButtonHandler implements EventHandler<ActionHandler>{
  public void handle(ActionEvent e){
    // respond to the event
    brb.disarm();
  }
}
```

#### Anonymous classes
```java
private Button brb = new Button("Big Red Button");
... brb.setOnAction(new EventHandler<ActionHandler>() {
      public void handle(ActionEvent e){
        // respond to the event
        brb.disarm();
      }
});...
```

#### Lambda Expressions
```java
private Button brb = new Button("Big Red Button");
... brb.setOnAction((e,k) -> { // brackets can be omitted if there's only one parameter
  // respond to the event
  brb.disarm();
});...
```

---
## Design Patterns
- **Design Patterns** - reusable templates for solving problems
- **NOT a solution**, an approach
- Describe **patterns of relationships** and interactions

### Creational patterns
**Key functions:**
- Encapsulate knowledge of **concrete classes** hiding implementation details with interfaces and abstract classes
- Hide details of creation and composition behind the method

##### Factory Method


##### Abstract factory
- Encapsulates responsibility for creating objects of CC, so only abstract classes are used in client code
- Changing the group of concrete classes only require a change where the factory is instantiated (scope of change controlled)
- Promotes consistency amongst alternative products
- Difficulty to add new kinds of products (abstract and concrete factory need update)

##### Singleton
- Only ever one object of a class can exist at a time
- Use only if it's obvious that having more than one object of a class will always cause an error
- Safe implementation utilises an enum
```java
public enum Singleton{
  INSTANCE;
  // methods go here
}
// Call Singleton.INSTANCE.method() and treat INSTANCE as an object

```

### Structural patterns
##### Composite
- Allows individual objects and compositions of objects to be treated in the same way
- Store a collection of children and apply opeartions to all of them

##### Model-View-Controller
- **Model** - data and methods for manipulating it
- **View** - the visual representation of the data
- **Controller** - handling of user controls (inc. arranging the view into user interface)

**Relationships between components:**
- **View** gets the data to display
- User pases controls to the **Controller**
- **Controller** modifies the data in the **Model**
- Changes in the **Model** are represented by the **View**
- **Controller** might change layout presentation of the **View**
- **View** might send input events to the **Controller** (e.g. TextBoxes)

##### Separable Model Architecture
- Used in JavaFX
- **View and Controller** are (almost) undivisible
- Using FXML - better separation of **View**

##### Decorator
- One class wraps around another
- Each class does a distinct thing, but service each other to do what we want together
- The **Decorator** (kind of) extends the functionality of the **Component**, reducing the amount of code
- A single **Decorator** can be used for multiple **Components**

##### Composite

### Behavioural patterns
- Describe patterns of communications between objects

##### Command
- **Decouples** the operation invoker **(View & Controller)** and definition of how to perform the operation **(Model)**
- **Same Command (and Listener)** code can be bounded to multiple places (menu items, buttons, keyboard shortcuts etc.)
- Commands can be **combined** together e.g. search-and-replace
- **Easy to add and modify** commands (at high level, in one place)
- More classes, each quite small (consider **Commands Package**)

##### Iterator
- Sequential access to an aggregate
- Responsibility for traversal moves from a collection to the iterator

##### Observer
- The way the view updates from a model
- When one object updates, it notifies all its observers with one opeartion


##### Inside-Out Development
- Write **Model** code first, then interface (View, Controller)

##### Outside-In Development
- Create the interface first, then Model
- It's clearly stated what functions need to be handled
- Helps to create only the necessary tests and code

---
### Files
##### Writing to files
**Basic write:**
```java
FileWriter fw = new FileWriter(fileName);

while(moreToWrite){
  fw.write(nextPart);
}
fw.close();
```

**Handled write:**
```java
try{
  FileWriter fw = new FileWriter(fileName);
  fw.write(nexPart);
  fw.close()
}catch(IOException e){
  // handle exception
}
```
If something goes wrong -> file might not be closed!\

**Handled write + close:**
```java
  try{
    FileWriter fw = new FileWriter(fileName);
    fw.write(nextPart);
  }catch(IOException e){
    // handle exception
  }finally{
    try{
      fw.close()
    }catch(IOException e){
      // we can't do much anymore
    }
  }
```

**Try-with-resource:**
```java
try(FileWriter fw = new FileWriter(fileName)){
  fw.write(nextPart);
}catch(IOException e){
  //handle the exception
}
```
fw.close() is called automatically!

##### Reading from files
**FileReader wrapped in BufferedReader:**
```java
BufferedReader br = new BufferedReader(new FileReader(fileName));
String line = br.readLine();
while (line != null){
  // process line
  line = br.readLine();
}
br.close();
```

**New default way of getting a BufferedReader**
```java
Charset cs = Charset.forName("US-ASCII");
Path p = Paths.get(fileName);

try (BufferedReader br = Files.newBufferedReader(p,cs)){
  String line = br.readLine();
}catch(Exception e){
  ...
}
```

##### Scanning
- **Scanning** - the process of grouping the individual characters in the input together, into meaningful tokens

##### File Chooser
- Need to handle 'Cancel' button
```java
private File chooseFile(Stage stage){
  FileChooser fc = new FileChooser();
  return fc.showOpenDialog(stage);
}
```

---
### Serialization
- **Serialization** - process of saving the object's state to the disk
- Many objects can be saved to the same file

**Saving to file**
```java
ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file or file_name));
os.writeObject(object);
os.close();
```
**Reading from file**
```java
ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file or file_name));

Object o = ois.readObject();
//Check for type and then use...
os.close()
```

---
##### State Space
- States
- Transitions
- **State Space** - graph of possible states (and transitions between them) in the problem

---
### Search
##### Heuristic
- **Complete** - goal state guaranteed to be found (if it exists)
- **Optimal** - goal state found (out of many possible) will have the least cost possible
- **Admissible** - function never overestimates (may underestimate) the cost of getting to the goal state
- **Consistent** - *h(n) < c(n,s) + h(s)*
