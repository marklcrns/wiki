---
title: JavaFX GUI
author: Mark Lucernas
date: 2020-07-27
summary: Java JavaFX GUIi notes
---


# JavaFX

- [⬇ JavaFX Basics](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_basics.pdf)
- [⬇ JavaFX UI Controls and Multimedia](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_UIControls_and_multimedia.pdf)
- [⬇ JavaFX Advanced](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_advanced.pdf)
- [📺 JavaFX Java GUI Design Tutorials](https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG)


## Introduction to graphical user interfaces with JavaFX

**JavaFX** is a set of packages and APIs for developing programs with graphical
user interfaces, 3D graphics, etc. A **graphical user interface**, or **GUI**,
enables the user to interface with a program using graphical components, such as
windows, buttons, text boxes, etc., as opposed to text-based interfaces like the
command line. The following program calculates a yearly salary based on an
hourly wage and utilizes JavaFX GUI components to display the program's output.

> Displaying a yearly salary using a GUI.

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

public class SalaryGuiFx extends Application {
   @Override
   public void start(Stage applicationStage) {
      int hourlyWage;
      int yearlySalary;
      Scene scene = null;                  // Scene contains all content
      Pane pane = null;                    // Positions components within scene
      TextField outputField = null;        // Displays output salary

      pane = new Pane();                   // Create an empty pane
      scene = new Scene(pane);             // Create a scene containing the pane

      // Calculate yearly salary
      hourlyWage = 20;
      yearlySalary = hourlyWage * 40 * 50;

      // Create text field and display program output using the text field
      outputField = new TextField();
      outputField.setText("An hourly wage of $" + hourlyWage + "/hr " +
                          "yields $" + yearlySalary + "/yr.");
      outputField.setEditable(false);      // Prevent user from editing text
      outputField.setPrefColumnCount(22);

      pane.getChildren().add(outputField); // Add text field to pane

      applicationStage.setScene(scene);    // Set window's scene
      applicationStage.setTitle("Salary"); // Set window's title
      applicationStage.show();             // Display window
   }

   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
```



A JavaFX GUI uses four classes/objects, namely Application, Stage, Scene, and Pane, to display graphical components. The following outlines one approach to create a JavaFX GUI, using the SalaryGuiFx class as the example application.

1. Extend and launch the application: An `Application` is a JavaFX class that
   provides the basic functionality for a JavaFX program and is available via
   the import statement `javafx.application.Application;`. The SalaryGuiFx class
   is derived from the Application class by appending extends Application after
   SalaryGuiFx in the class definition, as in class SalaryGuiFx extends
   Application. The SalaryGuiFx class inherits the functionality of the
   Application class, so that SalaryGuiFx can display a GUI. The concept of
   class inheritance is explained in more detail elsewhere.

   - The `main()` method calls the `launch()` method using the statement
     `launch(args);`. The `launch()` method creates a SalaryGuiFx object and
     calls the SalaryGuiFx object's `start()` method.

2. Override the `start()` method: A JavaFX Application starts by executing the
   `start()` method, which must be overridden in the derived Application class.
   The `start()` method takes a Stage parameter, has a return type of void, as
   in `public void start(Stage applicationStage) {...}`, and is preceded by the
   annotation @Override. A Stage is a JavaFX top-level container that contains
   all content within a window and is available via the import statement `import
   javafx.stage.Stage;`.

3. Create a pane and scene: A `Scene` is a JavaFX component that contains all
   graphical components that are displayed together and is available via the
   import statement `import javafx.scene.Scene;`. An application can have
   multiple scenes, but only one scene may be visible at a time. A `Pane` is a
   JavaFX component that controls the layout, i.e., position and size, of
   graphical components and is available via the import statement `import
   javafx.scene.layout.Pane;`. The statement `pane = new Pane();` creates an
   empty Pane object. The statement `scene = new Scene(pane);` creates a new
   Scene containing the pane object.

4. Create and add graphical components to a pane: A TextField is a JavaFX GUI
   component that enables a programmer to display a line of text and is
   available via the import statement `import javafx.scene.control.TextField;`.
   The statement `outputField = new TextField();` creates a TextField object. A
   TextField's `setText()` method specifies the text that will be displayed. Ex:
   `outputField.setText("An hourly ... ");`. By default, a TextField allows
   users to modify the text for the purposes of input (discussed elsewhere). A
   program can use TextField's `setEditable()` method with an argument of false
   to prevent users from editing the text, as in
   `outputField.setEditable(false);`. A TextField's width can be set using the
   `setPrefColumnCount()` method. Ex: `outputField.setPrefColumnCount(22)` sets
   the width to 22 columns.

   - Graphical components are added to a scene by adding the components to the
     scene's pane. A pane can contain numerous graphical components, which are
     called children. The `statement pane.getChildren().add(outputField);` adds
     a TextField object named outputField to the pane's list of children.

5. Set and display scene: Stage's `setScene()` method sets the scene that will
   be displayed, as in `applicationStage.setScene(scene);`. The `setTitle()`
   method specifies the text that will be displayed as the application's title.
   Ex: `applicationStage.setTitle("Salary");` displays "Salary" in the
   application's title bar. Stage's `show()` method makes the stage visible,
   which displays the application's window to the user. Ex:
   `applicationStage.show();` displays the application's window with the title
   "Salary" and text "An hourly wage of $20/hr yields $40000/yr."


## Positioning GUI Components Using a GridPane

A `GridPane` is a JavaFX Pane component that positions graphical components in a
two-dimensional grid. The following program demonstrates the use of a GridPane
to position graphical components in a GUI that displays an hourly wage and the
associated yearly salary.

> Using a GridPane to arrange graphical components.

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SalaryLabelGuiFx extends Application {
   @Override
   public void start(Stage applicationStage) {
      int hourlyWage;
      int yearlySalary;
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene
      Label wageLabel = null;     // Label for hourly salary
      Label salaryLabel = null;   // Label for yearly salary
      TextField salField = null;  // Displays yearly salary
      TextField wageField = null; // Displays hourly wage
      Insets gridPadding = null;

      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane); // Create scene containing the grid pane

      // Calculate yearly salary
      hourlyWage = 20;
      yearlySalary = hourlyWage * 40 * 50;

      // Set hourly and yearly salary
      wageLabel = new Label("Hourly wage:");
      salaryLabel = new Label("Yearly salary:");

      // Create wage and salary text fields
      wageField = new TextField();
      wageField.setPrefColumnCount(15);
      wageField.setEditable(false);
      wageField.setText(Integer.toString(hourlyWage));

      salField = new TextField();
      salField.setPrefColumnCount(15);
      salField.setEditable(false);
      salField.setText(Integer.toString(yearlySalary));

      gridPane.add(wageLabel, 0, 0);   // Add wage label to location (0, 0)
      gridPane.add(wageField, 1, 0);   // Add wage text field to location (1, 0)
      gridPane.add(salaryLabel, 0, 1); // Add salary label to location (0, 1)
      gridPane.add(salField, 1, 1);    // Add salary text field to location (1, 1)

      gridPadding = new Insets(10, 10, 10, 10); // Padding values for top, right, bottom, and left
      gridPane.setPadding(gridPadding);         // Set padding around  grid
      gridPane.setHgap(10);                     // Spacing between columns
      gridPane.setVgap(10);                     // Spacing between rows

      applicationStage.setScene(scene);    // Set window's scene
      applicationStage.setTitle("Salary"); // Set window's title
      applicationStage.show();             // Display window
   }

   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
```

A `Label` is a JavaFX component that displays non-editable text and is available
via the import statement import javafx.scene.control.Label;. Labels are
typically for describing, or labeling, other GUI components. For example, the
SalaryLabelGuiFx program uses two Labels, wageLabel and salaryLabel, to describe
the contents of the wage and salary text fields, respectively.


## Input and Event Handlers

A `Button` is a JavaFX GUI component that represents a labeled button that a
user can press to interact with a program. A JavaFX GUI component that supports
user input generates an **action event** to notify the program when a user
interacts with the component, such as when pressing a button. An **event
handler** defines how the program should respond to action events. The following
GUI uses a text field to enable the user to enter an hourly wage as an input for
the calculation of a yearly salary, which is triggered by a button press.

> Using a Button to trigger a yearly salary calculation.

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SalaryCalcButtonGuiFx extends Application {
   private Label wageLabel;     // Label for hourly salary
   private Label salLabel;      // Label for yearly salary
   private TextField salField;  // Displays hourly salary
   private TextField wageField; // Displays yearly salary
   private Button calcButton;   // Triggers salary calculation

   @Override
   public void start(Stage applicationStage) {
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene

      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane); // Create scene containing the grid pane

      // Set hourly and yearly salary
      wageLabel = new Label("Hourly wage:");
      salLabel = new Label("Yearly salary:");

      wageField = new TextField();
      wageField.setPrefColumnCount(15);
      wageField.setEditable(true);
      wageField.setText("0");

      salField = new TextField();
      salField.setPrefColumnCount(15);
      salField.setEditable(false);

      // Create a "Calculate" button
      calcButton = new Button("Calculate");

      gridPane.setPadding(new Insets(10, 10, 10, 10)); // Padding around  grid
      gridPane.setHgap(10);                            // Spacing between columns
      gridPane.setVgap(10);                            // Spacing between rows

      gridPane.add(wageLabel, 0, 0);  // Add wage label to location (0, 0)
      gridPane.add(wageField, 1, 0);  // Add wage text field to location (1, 0)
      gridPane.add(salLabel, 0, 1);   // Add salary label to location (0, 1)
      gridPane.add(salField, 1, 1);   // Add salary text field to location (1, 1)
      gridPane.add(calcButton, 0, 2); // Add calculate button to location (0, 2)

      // Set an event handler to handle button presses
      calcButton.setOnAction(new EventHandler<ActionEvent>() {
         /* Method is automatically called when an event
            occurs (e.g, button is pressed) */
         @Override
         public void handle(ActionEvent event) {
            String userInput;
            int hourlyWage;
            int yearlySalary;

            // Get user's wage input and calculate yearly salary
            userInput = wageField.getText();
            hourlyWage = Integer.parseInt(userInput);
            yearlySalary = hourlyWage * 40 * 50;

            // Display calculated salary
            salField.setText(Integer.toString(yearlySalary));
         }
      });

      applicationStage.setScene(scene);    // Set window's scene
      applicationStage.setTitle("Salary"); // Set window's title
      applicationStage.show();             // Display window
   }

   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
```

> Displaying an Alert for invalid wage inputs.

```java
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SalaryCalcButtonErrorAlertGuiFx extends Application {
   private Label wageLabel;     // Label for hourly salary
   private Label salLabel;      // Label for yearly salary
   private TextField salField;  // Displays hourly salary
   private TextField wageField; // Displays yearly salary
   private Button calcButton;   // Triggers salary calculation

   @Override
   public void start(Stage applicationStage) {
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene

      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane); // Create scene containing the grid pane

      // Set hourly and yearly salary
      wageLabel = new Label("Hourly wage:");
      salLabel = new Label("Yearly salary:");

      wageField = new TextField();
      wageField.setPrefColumnCount(15);
      wageField.setEditable(true);
      wageField.setText("0");

      salField = new TextField();
      salField.setPrefColumnCount(15);
      salField.setEditable(false);

      // Create a "Calculate" button
      calcButton = new Button("Calculate");

      gridPane.setPadding(new Insets(10, 10, 10, 10)); // Padding around  grid
      gridPane.setHgap(10);                            // Spacing between columns
      gridPane.setVgap(10);                            // Spacing between rows

      gridPane.add(wageLabel, 0, 0);  // Add wage label to location (0, 0)
      gridPane.add(wageField, 1, 0);  // Add wage text field to location (1, 0)
      gridPane.add(salLabel, 0, 1);   // Add salary label to location (0, 1)
      gridPane.add(salField, 1, 1);   // Add salary text field to location (1, 1)
      gridPane.add(calcButton, 0, 2); // Add calculate button to location (0, 2)

      // Set an event handler to handle button presses
      calcButton.setOnAction(new EventHandler<ActionEvent>() {
         /* Method is automatically called when an event
            occurs (e.g, button is pressed) */
         @Override
         public void handle(ActionEvent event) {
            String userInput;
            int hourlyWage;
            int yearlySalary;

            // Get user's wage input and calculate yearly salary
            userInput = wageField.getText();
            hourlyWage = Integer.parseInt(userInput);
            yearlySalary = hourlyWage * 40 * 50;

            if (hourlyWage >= 0) {
               // Display calculated salary
               salField.setText(Integer.toString(yearlySalary));
            }
            else {
               // Display an alert dialog
               Alert alert = new Alert(AlertType.ERROR,
                                       "Enter a positive hourly wage value.");
               alert.showAndWait();
            }
         }
      });

      applicationStage.setScene(scene);    // Set window's scene
      applicationStage.setTitle("Salary"); // Set window's title
      applicationStage.show();             // Display window
   }

   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
```

An `Alert` is a separate JavaFX window, also known as a dialog or pop-up window,
that displays a message to the user. Ex: `Alert alert = new
Alert(AlertType.ERROR, "Enter a positive hourly wage value.");` creates an Alert
object that displays an error message with the text "Enter a positive hourly
wage value.". The first argument specifies the Alert's type. Ex:
`AlertType.ERROR` specifies that the Alert window should indicate an error.

Alert's `showAndWait()` method makes the Alert visible to the user and waits for
the user's response. The program resumes execution after the user presses the
Alert's "OK" button, which closes the Alert window.


## Basic Graphics with JavaFX

JavaFX provides a set of objects for graphical applications. A **graphical
application** is a program that displays drawings and other graphical objects.
Graphical applications display their contents inside a Canvas object that is
added to the JavaFX application.

> Template for creating a JavaFX application to draw 2D graphics.

```java


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class EmptyCanvasFx extends Application {
   @Override
   public void start(Stage applicationStage) {
      Pane pane = new Pane();                    // Create an empty pane
      Scene scene = new Scene(pane);             // Create a scene containing the pane
      Canvas canvas = new Canvas(400, 200);      // Create a canvas in which to draw

      // Get the canvas' graphics context to draw
      GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

      // Write your drawing instructions here

      pane.getChildren().add(canvas);            // Add canvas to pane
      applicationStage.setTitle("Empty canvas"); // Set window's title
      applicationStage.setScene(scene);          // Set window's scene
      applicationStage.show();                   // Display window
   }

   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
```

> Drawing a histogram.

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HistogramViewerFx extends Application {
   @Override
   public void start(Stage applicationStage) {
      Pane pane = new Pane();                    // Create an empty pane
      Scene scene = new Scene(pane);             // Create a scene containing the pane
      Canvas canvas = new Canvas(400, 200);      // Create a canvas in which to draw

      // Get the canvas' graphics context to draw
      GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

      // Draw 1st bin as an olive colored rectangle at (10,10)
      // with width = 200 and height = 50
      Color binColor1 = Color.rgb(128, 128, 0);
      graphicsContext.setFill(binColor1);
      graphicsContext.fillRect(10, 10, 200, 50);

      // Draw 2nd bin as a teal blue rectangle at (10,75)
      // with width = 150 and height = 50
      Color binColor2 = Color.rgb(0, 200, 200);
      graphicsContext.setFill(binColor2);
      graphicsContext.fillRect(10, 75, 150, 50);

      // Draw 3rd bin as a gray rectangle at (10,140)
      // with width = 350 and height = 50
      Color binColor3 = Color.rgb(100, 100, 100);
      graphicsContext.setFill(binColor3);
      graphicsContext.fillRect(10, 140, 350, 50);

      pane.getChildren().add(canvas);                // Add canvas to pane
      applicationStage.setTitle("Histogram viewer"); // Set window's title
      applicationStage.setScene(scene);              // Set window's scene
      applicationStage.show();                       // Display window
   }

   public static void main(String [] args) {
       launch(args); // Launch application
   }
}
```


<br>

# Resources

- [⬇ JavaFX Basics](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_basics.pdf)
- [⬇ JavaFX UI Controls and Multimedia](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_UIControls_and_multimedia.pdf)
- [⬇ JavaFX Advanced](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_advanced.pdf)
- [📺 JavaFX Java GUI Design Tutorials](https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG)


Textbook

+ [📄 Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 16 JavaFX

