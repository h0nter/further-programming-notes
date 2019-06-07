# Lecture 6 - User Interfaces in JavaFX
### Contents
- GUI
- JavaFX
- Stages, Scenes and the Scene Graph
- Controls and components
- Layout and Panes

---
### A first Application
- JavaFX applications extend the: javafx.application.Application class
- The main() method calls the static launch() method in the **Application**
  - Creates the instance of the specified app
  - The method **init()** on the instance is called - this should only create controls, **not scenes and stages**

```java
@Override
public void start (Stage ps) {
  Label txt = new Label("Hello World!");
  FlowPane root = new FlowPane();
  root.getChildren().add(txt);
  ...
}
```

### Stages and Scenes
- **Stage** - a default OS window (close, minimize, fullscreen)
- **Scene** - container for all the content
- **Stage contains the Scene**

### JFX Controls
 - **Buttons**
```java
@Override
public void start (Stage primaryStage) {
  Label l = new Label("Hello World!");
  Button b = new Button("Press me");
  Pane root = new FlowPane(); //Polymorphism
  root.getChildren().add(txt);
  root.getChildren().add(b);
  
  Scene scene = new Scene(root);
  
  primaryStage.setTile("Hello World! window");
  primaryStage.setScene(scene);
  primaryStage.show();
}
```
- Toggle Button
- Hyperlink
- CheckBox (Normal/Undefined/Selected)
- Radio Button
- Menu Buttons
- ScrollView
- ProgressBar
- ListView
- TextArea

### JFX Layout
- Add **Controls** to **Panes** - a subclass of **Regions**
- Different **Pane** classes have different Layout algorithms
- Layout examples: rows, columns, stacks, tiles and others
- **Parent** has an **ObservableList** of children - accessed by **getChildren()** and **add()** to append another to the list.

**HBox**
- Fixes the height as the height of the largest

**VBox**
- fixes the width as the width of the widest

**FlowPane**
- components in either horizontal or vertical orientation
- preferred width or height determines the wrap round point
- components are resized if the box is shrunk

**BorderPane**
- lays out children in top, bottom, left, right and center positions
- top/bottom - extend width
- left/right - extend height
- center - extend height and width

**StackPane**
- lays out children in order in the z-plane (one on top of another)

**TilePane**
- sets either the preferred number of columns or rows (depending on orientation)
- Components are then laid out in equal areas calculated by largest height/width

**GridPane**
- allows for full flexibility of dimensions and allignment of each square in a grid
- Excelent for GUI builder - not so much fun by hand

**TabPane**
- switching views through tabs
- each tab has a lable and a **Node** as its contents

---
### Summary
- Introduced the components for programmatic construction
- In JavaFX, the scenegraph is a tree with child nodes contained in an ObservableList - needed for capturing events
- Utilise Panes with built in Layout algorithms to produce interfaces