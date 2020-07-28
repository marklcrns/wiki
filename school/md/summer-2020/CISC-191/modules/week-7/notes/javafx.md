---
title: JavaFX GUI
author: Mark Lucernas
date: 2020-07-27
summary: JavaFX GUIi notes
---


# JavaFX

  - [*JavaFX Basics](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_basics.pdf)
  - [*JavaFX UI Controls and Multimedia](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_UIControls_and_multimedia.pdf)
  - [*JavaFX Advanced](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_advanced.pdf)
  - [`JavaFX Java GUI Design Tutorials](https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG)


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


<br>

# Resources

  - [*JavaFX Basics](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_basics.pdf)
  - [*JavaFX UI Controls and Multimedia](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_UIControls_and_multimedia.pdf)
  - [*JavaFX Advanced](file:../../../../../../files/summer-2020/CISC-191/week-7/javafx_advanced.pdf)
  - [`JavaFX Java GUI Design Tutorials](https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG)


Textbook

  + [Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 16 JavaFX

