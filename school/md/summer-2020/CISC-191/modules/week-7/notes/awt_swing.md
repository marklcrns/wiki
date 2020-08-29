---
title: AWT and Swing GUI
author: Mark Lucernas
date: 2020-07-27
summary: AWT and Swing GUI notes
---


# AWT and Swing

## Basic Graphics

Java supports a set of objects for developing **graphical applications**. A
graphical application is a program that displays drawings and other graphical
objects. Graphical applications display their contents inside a window called a
**frame** using a **JFrame** object. The following program shows how to create
and configure an JFrame object to display an empty application window.

> Creating a JFrame object for a graphical application.

```java
import javax.swing.JFrame;

public class EmptyFrame {
   public static void main(String[] args) {

      // Construct the JFrame object
      JFrame appFrame = new JFrame();

      // Set the frame's width (400) and height (250) in pixels
      appFrame.setSize(400, 250);

      // Set the frame's title
      appFrame.setTitle("An Empty Frame");

      // Set the program to exit when the user
      // closes the frame
      appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Make the frame visible to the user
      appFrame.setVisible(true);
   }
}
```

A JFrame can be used to draw graphical objects, such as rectangles, circles, and
lines. To display graphical objects, a programmer can add a custom JComponent
object to a frame. A **JComponent** is a blank graphical component that a
programmer extends (or customizes) with custom code in order to draw basic
shapes.

> Basic example showing how to create a class extending JComponent to draw 2D
graphics.

```java
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class MyCustomJComponent extends JComponent {

   @Override
   public void paintComponent(Graphics g) {
      // Cast to Graphics2D
      Graphics2D graphicsObj = (Graphics2D)g;

      // Write your drawing instructions
   }
}
```

> Drawing a histogram in a frame.

HistogramComponent.java

```java
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

// HistogramComponent extends the functionality of a JComponent
// in order to draw a histogram.
public class HistogramComponent extends JComponent {

   // Paints a histogram with three bins
   @Override
   public void paintComponent(Graphics g) {
      // Cast to Graphics2D
      Graphics2D graphicsObj = (Graphics2D) g;

      // Draw 1st bin as an olive colored rectangle at (10,10)
      // with width = 200 and height = 50
      Rectangle binRectangle1 = new Rectangle(10, 10, 200, 50);
      Color binColor1 = new Color(128, 128, 0);
      graphicsObj.setColor(binColor1);
      graphicsObj.fill(binRectangle1);

      // Draw 2nd bin as a teal blue rectangle at (10,75)
      // with width = 150 and height = 50
      Rectangle binRectangle2 = new Rectangle(10, 75, 150, 50);
      Color binColor2 = new Color(0, 200, 200);
      graphicsObj.setColor(binColor2);
      graphicsObj.fill(binRectangle2);

      // Draw 3rd bin as a gray rectangle at (10,140)
      // with width = 350 and height = 50
      Rectangle binRectangle3 = new Rectangle(10, 140, 350, 50);
      Color binColor3 = new Color(100, 100, 100);
      graphicsObj.setColor(binColor3);
      graphicsObj.fill(binRectangle3);
   }
}
```

HistogramViewer.java

```java
import javax.swing.JFrame;

public class HistogramViewer {
   public static void main(String[] args) {
      JFrame appFrame = new JFrame();
      HistogramComponent histogramComponent = new HistogramComponent();

      appFrame.setSize(400, 250);
      appFrame.setTitle("Histogram Viewer");
      appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Add the HistogramComponent object to the frame
      appFrame.add(histogramComponent);

      // Set the frame and its contents visible
      appFrame.setVisible(true);
   }
}
```

## Introduction to Graphical User Interfaces

Java supports a set of components, called **Swing GUI components**, for the
development of custom GUIs. A GUI, or **graphical user interface**, enables the
user to interface with a program via the use of graphical components such as
windows, buttons, text boxes, etc. as opposed to text-based interfaces like the
traditional command line. The following example calculates a yearly salary based
on an hourly wage and utilizes Swing GUI components in order to create a GUI
that displays the program's output.

> Displaying a yearly salary using a GUI.

```java
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SalaryGUI {
   public static void main(String[] args) {
      int hourlyWage;
      JFrame topFrame = null;        // Application window
      JTextField outputField = null; // Displays output salary

      hourlyWage = 20;

      // Create text field
      outputField = new JTextField();
      // Display program output using the text field
      outputField.setText("An hourly wage of " + hourlyWage + "/hr" +
                          " yields $" + (hourlyWage * 40 * 50) + "/yr.");

      // Prevent user from editing output text
      outputField.setEditable(false);

      // Create window
      topFrame = new JFrame("Salary");

      // Add text field to window
      topFrame.add(outputField);

      // Resize window to fit components
      topFrame.pack();

      // Set program to terminate when window is closed
      topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Display window
      topFrame.setVisible(true);
   }
}
```

> Experimenting with JFrame's pack() method.

```md
JFrame's pack() method uses the preferred size of its contained components in
order to determine the appropriate size for the window. Try removing the
statement frame.pack() from the above program and observe the effect. Notice how
the window no longer displays the entire text of the JTextField component.
Instead, the window defaults to a default size without considering the size of
the frame's contained components.

Now restore the program to the original state and try moving the statement
outputField.setText("An hourly wage ..."); after the call to pack() (i.e., after
the statement frame.pack();). Run the program once again and observe the output.
Although the program invoked the pack() method, the text field is not displayed
properly within the window. The statement order matters. The pack() method
resizes the window according to the current state of the frame's components.
Thus, changing the amount of text displayed by a JTextField component after the
call to pack() will not automatically resize the window in order to fit the
text.
```

By default, closing a GUI window does not terminate the program. Thus, the
statement `frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);` is required so
that the program terminates properly when the GUI window is closed. Lastly, the
statement `frame.setVisible(true);` makes the frame visible on the screen.


## Positioning GUI components using a GridBagLayout

A **layout manager** affords programmers control over the positioning and layout
of GUI components within a JFrame or other such containers. A **GridBagLayout**
positions GUI components in a two-dimensional grid and is one of the layout
managers supported by Java. The following example demonstrates the use of a
GridBagLayout to position GUI components for a program that displays an hourly
wage and the associated yearly salary.

> Using a GridBagLayout to arrange GUI components.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryLabelGUI {

   public static void main(String[] args) {
      int hourlyWage;
      JFrame topFrame = null;                // Application window
      JLabel wageLabel = null;               // Label for hourly salary
      JLabel salLabel = null;                // Label for yearly salary
      JTextField salField = null;            // Displays hourly salary
      JTextField wageField = null;           // Displays yearly salary
      GridBagConstraints layoutConst = null; // GUI component layout

      hourlyWage = 20;

      // Set hourly and yearly salary
      wageLabel = new JLabel("Hourly wage:");
      salLabel = new JLabel("Yearly salary:");

      wageField = new JTextField(15);
      wageField.setEditable(false);
      wageField.setText(Integer.toString(hourlyWage));

      salField = new JTextField(15);
      salField.setEditable(false);
      salField.setText(Integer.toString((hourlyWage * 40 * 50)));

      // Create frame and add components using GridBagLayout
      topFrame = new JFrame("Salary");

      // Use a GridBagLayout
      topFrame.setLayout(new GridBagLayout());

      // Create GridBagConstraints
      layoutConst = new GridBagConstraints();

      // Specify component's grid location
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;

      // 10 pixels of padding around component
      layoutConst.insets = new Insets(10, 10, 10, 10);

      // Add component using the specified constraints
      topFrame.add(wageLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      topFrame.add(wageField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      topFrame.add(salLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      topFrame.add(salField, layoutConst);

      // Terminate program when window closes
      topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Resize window to fit components
      topFrame.pack();

      // Display window
      topFrame.setVisible(true);
   }
}
```

> Using an alternative coding style that defines a custom JFrame class.

```java
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryLabelFrame extends JFrame {
   private JLabel wageLabel;     // Label for hourly salary
   private JLabel salLabel;      // Label for yearly salary
   private JTextField salField;  // Displays hourly salary
   private JTextField wageField; // Displays yearly salary

   /* Constructor initializes the SalaryLabelFrame,
      creates GUI components, and adds them
      using a GridBagLayout. */
   SalaryLabelFrame() {
      int hourlyWage;                  // Hourly wage
      GridBagConstraints layoutConst;  // Used to specify GUI component layout

      hourlyWage = 20;

      // Set frame's title
      setTitle("Salary");

      // Set hourly and yearly salary
      wageLabel = new JLabel("Hourly wage:");
      salLabel = new JLabel("Yearly salary:");

      wageField = new JTextField(15);
      wageField.setEditable(false);
      wageField.setText(Integer.toString(hourlyWage));

      salField = new JTextField(15);
      salField.setEditable(false);
      salField.setText(Integer.toString((hourlyWage * 40 * 50)));

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      // Create GridBagConstraints
      layoutConst = new GridBagConstraints();

      // Specify component's grid location
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;

      // 10 pixels of padding around component
      layoutConst.insets = new Insets(10, 10, 10, 10);

      // Add component using the specified constraints
      add(wageLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(wageField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(salLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(salField, layoutConst);
   }

   /* Creates a SalarLabelFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SalaryLabelFrame and its components
      SalaryLabelFrame myFrame = new SalaryLabelFrame();

      // Terminate program when window closes
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Resize window to fit components
      myFrame.pack();

      // Display window
      myFrame.setVisible(true);
   }
}
```

## GUI input and ActionListeners

> Using a JTextField to enter a wage for a yearly salary calculation.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalcFrame extends JFrame implements ActionListener {
   private JLabel wageLabel;     // Label for hourly salary
   private JLabel salLabel;      // Label for yearly salary
   private JTextField salField;  // Displays hourly salary
   private JTextField wageField; // Displays yearly salary


   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SalaryCalcFrame() {
      // Used to specify GUI component layout
      GridBagConstraints layoutConst = null;

      // Set frame's title
      setTitle("Salary");

      wageLabel = new JLabel("Hourly wage:");
      salLabel = new JLabel("Yearly salary:");

      // Set hourly and yearly salary
      wageField = new JTextField(15);
      wageField.setEditable(true);
      wageField.setText("0");
      wageField.addActionListener(this);

      salField = new JTextField(15);
      salField.setEditable(false);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      layoutConst = new GridBagConstraints();

      // Specify component's grid location
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;

      // 10 pixels of padding around component
      layoutConst.insets = new Insets(10, 10, 10, 10);

      // Add component using the specified constraints
      add(wageLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(wageField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(salLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(salField, layoutConst);
   }

   /* Method is automatically called when an event
    occurs (e.g, Enter key is pressed) */
   @Override
   public void actionPerformed(ActionEvent event) {
      String userInput;      // User specified hourly wage
      int hourlyWage;        // Hourly wage

      // Get user's wage input
      userInput = wageField.getText();

      // Convert from String to an integer
      hourlyWage = Integer.parseInt(userInput);

      // Display calculated salary
      salField.setText(Integer.toString(hourlyWage * 40 * 50));
   }

   /* Creates a SalaryCalculatorFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SalaryLabelFrame and its components
      SalaryCalcFrame myFrame = new SalaryCalcFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

> Using a JButton to trigger a yearly salary calculation.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalcButtonFrame extends JFrame implements ActionListener {
   private JLabel wageLabel;     // Label for hourly salary
   private JLabel salLabel;      // Label for yearly salary
   private JTextField salField;  // Displays hourly salary
   private JTextField wageField; // Displays yearly salary
   private JButton calcButton;   // Triggers salary calculation

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SalaryCalcButtonFrame() {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set frame's title
      setTitle("Salary");

      // Set hourly and yearly salary labels
      wageLabel = new JLabel("Hourly wage:");
      salLabel = new JLabel("Yearly salary:");

      wageField = new JTextField(15);
      wageField.setEditable(true);
      wageField.setText("0");

      salField = new JTextField(15);
      salField.setEditable(false);

      // Create a "Calculate" button
      calcButton = new JButton("Calculate");

      // Use "this" class to handle button presses
      calcButton.addActionListener(this);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      // Specify component's grid location
      positionConst.gridx = 0;
      positionConst.gridy = 0;

      // 10 pixels of padding around component
      positionConst.insets = new Insets(10, 10, 10, 10);

      // Add component using the specified constraints
      add(wageLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(wageField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(salLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(salField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 2;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(calcButton, positionConst);
   }

   /* Method is automatically called when an event
      occurs (e.g, button is pressed) */
   @Override
   public void actionPerformed(ActionEvent event) {
      String userInput;      // User specified hourly wage
      int hourlyWage;        // Hourly wage

      // Get user's wage input
      userInput = wageField.getText();

      // Convert from String to an integer
      hourlyWage = Integer.parseInt(userInput);

      // Display calculated salary
      salField.setText(Integer.toString(hourlyWage * 40 * 50));
   }

   /* Creates a SalaryCalculatorFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SalaryLabelFrame and its components
      SalaryCalcButtonFrame myFrame = new SalaryCalcButtonFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

## GUI Input with Formatted Text Fields

A **JFormattedTextField** is a Swing GUI component that extends a JTextField in
order to enable a programmer to specify the appropriate types and sequence of
characters (i.e., the character format) that a text field component can display
or accept as input.

> Using a JFormattedTextField to enter a formatted distance value for a travel
time calculation.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FlyDriveFrame extends JFrame implements ActionListener {
   private JButton calcButton;            // Triggers time calculation
   private JLabel distLabel;              // Label for distance input
   private JLabel hrsFlyLabel;            // Label for fly time
   private JLabel hrsDriveLabel;          // Label for drive time
   private JTextField hrsFlyField;        // Displays fly time
   private JTextField hrsDriveField;      // Displays drive time
   private JFormattedTextField distField; // Holds distance input

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   FlyDriveFrame() {
      // Used to specify GUI component layout
      GridBagConstraints layoutConst = null;

      // Set frame's title
      setTitle("Fly Drive Travel Time Calculator");

      // Create labels
      distLabel = new JLabel("Distance (miles):");
      hrsFlyLabel = new JLabel("Flight time (hrs):");
      hrsDriveLabel = new JLabel("Driving time (hrs):");

      // Create button and add action listener
      calcButton = new JButton("Calculate");
      calcButton.addActionListener(this);

      // Create flight time filed
      hrsFlyField = new JTextField(15);
      hrsFlyField.setEditable(false);

      // Create driving time field
      hrsDriveField = new JTextField(15);
      hrsDriveField.setEditable(false);

      // Create and set-up an input field for numbers (not text)
      distField = new JFormattedTextField(NumberFormat.getNumberInstance());
      distField.setEditable(true);
      distField.setText("0");
      distField.setColumns(15); // Initial width of 10 units

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      // Specify component's grid location
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(distLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(distField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 5, 10, 10);
      layoutConst.gridx = 2;
      layoutConst.gridy = 0;
      add(calcButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 0, 1, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(hrsFlyLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 0, 10, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(hrsFlyField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 0, 1, 10);
      layoutConst.gridx = 2;
      layoutConst.gridy = 1;
      add(hrsDriveLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 0, 10, 10);
      layoutConst.gridx = 2;
      layoutConst.gridy = 2;
      add(hrsDriveField, layoutConst);
   }

   /* Method is automatically called when an event
      occurs (e.g, Enter key is pressed) */
   @Override
   public void actionPerformed(ActionEvent event) {
      double totMiles;     // Distance to travel
      double hrsFly;       // Corresponding hours to fly
      double hrsDrive;     // Corresponding hours to drive

      // Get value from distance field
      totMiles = ((Number) distField.getValue()).doubleValue();

      // Check if miles input is positive
      if (totMiles >= 0.0) {
         hrsFly = totMiles / 500.0;
         hrsDrive = totMiles / 60.0;

         hrsFlyField.setText(Double.toString(hrsFly));
         hrsDriveField.setText(Double.toString(hrsDrive));
      }
      else {
         // Show failure dialog
         JOptionPane.showMessageDialog(this, "Enter a positive distance value!");
      }
   }

   /* Creates a FlyDriveFrame and makes it visible */
   public static void main(String[] args) {
      // Creates FlyDriveFrame and its components
      FlyDriveFrame myFrame = new FlyDriveFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

## GUI input with JSpinners

A **JSpinner** is a Swing GUI component that supports user input by enabling the
user to select, or enter, a specific value from within a predetermined range of
values. A JSpinner supports dual functionalities, allowing the user to enter a
value into a formatted text field or cycle through available values by pressing
one of two buttons.

> Using a JSpinner to enter a dog's age for a GUI that converts a dog's age into
human years.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DogYearsFrame extends JFrame implements ChangeListener {
   private JSpinner yearsSpinner;    // Triggers travel time calculation
   private JTextField ageHumanField; // Displays dog's age in human years
   private JLabel yearsLabel;        // Label for dog years
   private JLabel ageHumanLabel;     // Label for human years

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   DogYearsFrame() {
      int initYear;     // Spinner initial value display
      int minYear;      // Spinner min value
      int maxYear;      // Spinner max value
      int stepVal;      // Spinner step

      initYear = 0;
      minYear = 0;
      maxYear = 30;
      stepVal = 1;

      // Used to specify GUI component layout
      GridBagConstraints layoutConst = null;

      // Specifies the types of values displayed in spinner
      SpinnerNumberModel spinnerModel = null;

      // Set frame's title
      setTitle("Dog's age in human years");

      // Create labels
      yearsLabel = new JLabel("Select dog's age (years):");
      ageHumanLabel = new JLabel("Age (human years):");

      // Create a spinner model, the spinner, and set the change listener
      spinnerModel = new SpinnerNumberModel(initYear, minYear, maxYear, stepVal);
      yearsSpinner = new JSpinner(spinnerModel);
      yearsSpinner.addChangeListener(this);

      // Create field
      ageHumanField = new JTextField(15);
      ageHumanField.setEditable(false);
      ageHumanField.setText("0 - 15");

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      // Specify component's grid location
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(yearsLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(yearsSpinner, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(ageHumanLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(ageHumanField, layoutConst);
   }

   @Override
   public void stateChanged(ChangeEvent event) {
      Integer dogAgeYears;     // Dog age input

      dogAgeYears = (Integer) yearsSpinner.getValue();

      // Choose output based on dog's age component
      switch (dogAgeYears) {
         case 0:
            ageHumanField.setText("0 - 15");
            break;

         case 1:
            ageHumanField.setText("15");
            break;

         case 2:
            ageHumanField.setText("24");
            break;

         case 3:
            ageHumanField.setText("28");
            break;

         case 4:
            ageHumanField.setText("32");
            break;

         case 5:
            ageHumanField.setText("37");
            break;

         case 6:
            ageHumanField.setText("42");
            break;

         case 7:
            ageHumanField.setText("47");
            break;

         case 8:
            ageHumanField.setText("52");
            break;

         case 9:
            ageHumanField.setText("57");
            break;

         case 10:
            ageHumanField.setText("62");
            break;

         case 11:
            ageHumanField.setText("67");
            break;

         case 12:
            ageHumanField.setText("72");
            break;

         case 13:
            ageHumanField.setText("77");
            break;

         case 14:
            ageHumanField.setText("82");
            break;

         default:
            ageHumanField.setText("That's a long life!");
      }
   }

   /* Creates a DogYearsFrame and makes it visible */
   public static void main(String[] args) {
      // Creates DogYearsFrame and its components
      DogYearsFrame myFrame = new DogYearsFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

A JSpinner generates **change events** that notify the underlying program of a
change in the value displayed by the spinner. A **ChangeListener object** is
used within a program to handle change events, defining a `stateChanged()`
method that dictates how the program should respond to a change event.

In constructing the GUI's layout, notice that the DogYearsFrame() constructor
utilizes two layout constraints: `fill` and `anchor`. Fill allows the programmer
to specify the cardinal direction in which to resize a component. The fill value
`HORIZONTAL` tells the layout manager to resize the component horizontally so
that the component is wide enough to fill the cell. A fill value of `VERTICAL`
tells the layout manager to resize the component in the vertical direction. The
fill value BOTH stretches a component in both directions to fill the entire
cell. The default value for the fill is `NONE`, which sizes a component
according to the component's default preferred size. In the above program, the
spinner and text field components use a horizontal fill so that they appear
wider to the viewer.

The other layout constraint, anchor, allows the programmer to specify the
location of a component within the component's containing cell. Some of the
possible values are `LINE_START`, `LINE_END`, `PAGE_START`, `PAGE_END`, and the
default `CENTER`. These anchor values place a component at the left, right, top,
bottom, and center of the cell respectively. In the above program, the labels
use an anchor value of `LINE_END` so that they are aligned on the right side of
their containing cells and thus appear closer to the components which they
describe.

## Displaying multi-line text in a JTextArea

A `JTextArea` is a Swing GUI component that supports the display of multiple
lines of text. The following program uses a JTextArea to display the amount of
money in a savings account per year based on the user-specified number of years,
initial savings amount, and yearly interest rate.

> Using a JTextArea to display the amount of money in a savings account per
year.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SavingsInterestCalcFrame extends JFrame implements ActionListener {
   private JTextArea outputArea;                  // Displays yearly savings
   private JButton calcButton;                    // Triggers savings calculation
   private JFormattedTextField initSavingsField;  // Holds savings amount
   private JFormattedTextField interestRateField; // Holds interest amount
   private JFormattedTextField yearsField;        // Holds num years

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SavingsInterestCalcFrame() {
      GridBagConstraints layoutConst = null; // Used to specify GUI component layout
      JScrollPane scrollPane = null;         // Container that adds a scroll bar
      JLabel initSavingsLabel = null;        // Label for savings
      JLabel interestRateLabel = null;       // Label for interest
      JLabel yearsLabel = null;              // Label for num years
      JLabel outputLabel = null;             // Label for yearly savings

      // Format for the savings input
      NumberFormat currencyFormat = null;

      // Format for the interest rate input
      NumberFormat percentFormat = null;

      // Format for the years input
      NumberFormat integerFormat = null;

      // Set frame's title
      setTitle("Savings calculator");

      // Create labels
      initSavingsLabel = new JLabel("Initial savings:");
      interestRateLabel = new JLabel("Interest rate:");
      yearsLabel = new JLabel("Years:");
      outputLabel = new JLabel("Yearly savings:");

      // Create output area and add it to scroll pane
      outputArea = new JTextArea(10, 15);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);

      calcButton = new JButton("Calculate");
      calcButton.addActionListener(this);

      // Create savings field and specify the currency format
      currencyFormat = NumberFormat.getCurrencyInstance();
      initSavingsField = new JFormattedTextField(currencyFormat);
      initSavingsField.setEditable(true);
      initSavingsField.setColumns(10); // Initial width of 10 units
      initSavingsField.setValue(0);

      // Create rate field and specify the percent format
      percentFormat = NumberFormat.getPercentInstance();
      percentFormat.setMinimumFractionDigits(1);
      interestRateField = new JFormattedTextField(percentFormat);
      interestRateField.setEditable(true);
      interestRateField.setValue(0.0);

      // Create years field and specify the default number (for doubles) format
      integerFormat = NumberFormat.getIntegerInstance();
      yearsField = new JFormattedTextField(integerFormat);
      yearsField.setEditable(true);
      yearsField.setValue(0);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(initSavingsLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(initSavingsField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(interestRateLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(interestRateField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 10, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      add(yearsLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(yearsField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 0, 10);
      layoutConst.fill = GridBagConstraints.BOTH;
      layoutConst.gridx = 2;
      layoutConst.gridy = 1;
      add(calcButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 4;
      layoutConst.gridwidth = 3; // 3 cells wide
      add(scrollPane, layoutConst);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      int i;                       // Loop index
      double savingsDollars;       // Yearly savings
      double interestRate;         // Annual interest rate
      int numYears;                // Num years to calc savings

      // Get values from fields
      savingsDollars = ((Number) initSavingsField.getValue()).intValue();
      interestRate = ((Number) interestRateField.getValue()).doubleValue();
      numYears = ((Number) yearsField.getValue()).intValue();

      // Clear the text area
      outputArea.setText("");

      // Calculate savings iteratively in a while loop
      i = 1;
      while (i <= numYears) {
         outputArea.append("Savings in year " + i +
                           ": $" + savingsDollars + "\n");
         savingsDollars = savingsDollars + (savingsDollars * interestRate);

         i = i + 1;
      }
   }

   /* Creates a SavingsInterestCalcFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SavingsInterestCalcFrame and its components
      SavingsInterestCalcFrame myFrame = new SavingsInterestCalcFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

The GUI uses a large text area for displaying multiple lines of output (i.e.,
savings amount per year). The statement `outputArea = new JTextArea(10,15);`
creates a `JTextArea` object and assigns it to the variable outputArea. The two
literals within parentheses denote the dimensions (i.e., number of rows and
columns) of the outputArea, therefore this particular text area has 10 rows and
15 columns. By default, a user can edit the text displayed by a JTextArea
component. Because the above program only utilizes the text area for output, the
program calls JTextArea's `setEditable()` method with a boolean argument of
false, as in `outputArea.setEditable(false);`, in order to make the text area
uneditable.

In order to enable scrolling, a programmer must add a JTextArea component to a
JScrollPane. A `JScrollPane` is a Swing GUI component that provides a scrollable
view to the underlying component JScrollPane manages, also called a client. The
statement `scrollPane = new JScrollPane(outputArea);` assigns a new JScrollPane
object to the variable scrollPane. The argument within parentheses specifies the
scroll pane's client, which in this case corresponds to the outputArea
`JTextArea` object.

## Using Tables in GUIs

Tables are convenient structures for organizing and displaying information. A
`JTable` is a Swing GUI component that displays data in a table, optionally
allowing the GUI user to edit the data by entering new values into the table.
The following program finds the maximum integer value within a user-specified
array, whose elements are displayed using an editable JTable.

> Calculating the maximum array value for an array displayed in a JTable.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ArrayMaxFrame extends JFrame implements ActionListener {
   private JLabel maxLabel;              // Label for max array element
   private JFormattedTextField maxField; // Holds max array element
   private JButton maxButton;            // Triggers search for max array element
   private JTable arrayValsTable;        // Table of array values
   private final int numElements = 8;    // Number of array elemeents
   private String[] columnHeadings;      // Stores the table's column headings
   private String[][] tableVals;         // Stores the table's values

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   ArrayMaxFrame() {
      GridBagConstraints layoutConst = null; // GUI component layout
      int i;

      // Set frame's title
      setTitle("Array maximum");

      // Create label
      maxLabel = new JLabel("Max:");

      // Create field
      maxField = new JFormattedTextField(NumberFormat.getIntegerInstance());
      maxField.setColumns(15);
      maxField.setEditable(false);
      maxField.setValue(0);

      // Create button
      maxButton = new JButton("Find max");
      maxButton.addActionListener(this);

      // Table headings and values
      columnHeadings = new String[1];
      tableVals = new String[8][1];

      // Initialize column heading(s)
      columnHeadings[0] = "Element";

      // Initialize table values
      for (i = 0; i < numElements; ++i) {
         tableVals[i][0] = "0";
      }

      // Create a table with the specified values and column headings
      arrayValsTable = new JTable(tableVals, columnHeadings);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      // Add table header
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 2;
      add(arrayValsTable.getTableHeader(), layoutConst);

      // Add table itself
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.gridwidth = 2;
      add(arrayValsTable, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      add(maxButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(maxLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 2;
      add(maxField, layoutConst);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      int i;               // Loop index
      int maxElement;      // Max value found
      String strElem;      // Array element value (string)
      int elemVal;         // Array element value (int)

      strElem = tableVals[0][0];              // Get table value (String)
      maxElement = Integer.parseInt(strElem); // Convert to Integer

      // Iterate through table values to find max
      for (i = 1; i < numElements; ++i) {
         strElem = tableVals[i][0];           // Get table value (String)
         elemVal = Integer.parseInt(strElem); // Convert to Integer
         if (elemVal > maxElement) {          // Check if new max value found
            maxElement = elemVal;             // If so, update max
         }
      }

      // Display maximum value
      maxField.setValue(maxElement);
   }

   /* Creates a ArrayMaxFrame and makes it visible */
   public static void main(String[] args) {
      // Creates ArrayMaxFrame and its components
      ArrayMaxFrame myFrame = new ArrayMaxFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

The program uses the array tableVals to store the elements that the user edits.
Although one would expect to use a one-dimensional array of integer values,
notice that tableVals is a two-dimensional array of String elements. Because a
table typically consists of a two-dimensional grid of table elements, also known
as table cells, a programmer may only display elements stored in a
two-dimensional array in order to ensure a direct mapping between an array
element's index to a table's cell index (e.g., the element given by
`tableVals[i][j];` is associated with the table cell in the ith row and jth
column). Thus, tableVals is initialized as a two-dimensional array with 8 rows
and 1 column, as in `tableVals = new String[8][1];`, instead of a one-dimensional
array with 8 elements.

By default, a JTable uses a simple table model, which is an object responsible
for managing the table's data. The table model interprets all table cell values
using a String representation. The above program stores the array elements as
Strings and converts these elements to integers, when necessary, by using the
Integer class's `parseInt()` method (e.g., `max = Integer.parseInt(strElem);`).

Note that the default table model can actually display array elements of any
reference data type (e.g., Integer, Double) because all reference types
implicitly define the `toString()` method, which returns a String representation
of the object. However, the default table model does not perform this conversion
in the other direction. In other words, the table model does not convert a
cell's text back into the appropriate data type.

After properly initializing the data array, the program creates a JTable object
and assigns the object to the variable arrayValsTable via the statement
`arrayValsTable = new JTable(tableVals, columnHeadings);`. The first argument
within parentheses, i.e., tableVals, corresponds to the array that the
programmer wants to display within the table. The second argument, i.e.,
columnHeadings, is a one-dimensional String array that contains the names, or
headings, of each column. Table headings are contained in a separate area of the
table known as the header. The columnHeadings array, for example, contains a
single String, "Element", corresponding to the heading of the table's only
column. In order to use a JTable, the program must include the import statement
`import javax.swing.JTable;`.

A JTable requires the programmer to specify separate layout constraints (i.e.,
position, size, etc.) for the table's header and the table's cells. The above
program uses a GridBagLayout, as usual, to place the header in the grid cell
just above the table's cells. JTable's `getTableHeader()` method returns a
reference to the header and the statement add(arrayValsTable.getTableHeader(),
layoutConst); uses this method to add the table's header to the frame using the
constraints specified by layoutConst. A programmer can then add the table's
cells to a frame by using the JTable variable on its own, as in
add(arrayValsTable, layoutConst);. One alternative that does not require
separate treatment of the table's header and cells is to use a JScrollPane as
that table's container, as in `JScrollPane scrollPane = new
JScrollPane(arrayValsTable);`, and then add the JScrollPane to the frame.
Lastly, a programmer can also choose not to add a table's header to the frame,
which results in a valid GUI that only displays the table's cells.

## Using Sliders in GUIs

A `JSlider` is a Swing GUI component that allows users to select a numeric value
from within a predefined range. For example, the following GUI program uses a
JSlider component to allow the user to enter a person's height in U.S. units
(feet and inches). The program then converts the input height into centimeters.

> Using JSliders to enter height in feet and inches.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HeightConverterFrame extends JFrame implements ActionListener, ChangeListener {
   private JTextField heightCmField;  // Holds height output value in cm
   private JTextField heightFtField;  // Holds height input value in feet
   private JTextField heightInField;  // Holds heigth input value in inches
   private JLabel feetLabel;          // Label for heigth input in feet
   private JLabel inchesLabel;        // Label for height input in inches
   private JLabel cmLabel;            // Label for heigth in cm
   private JButton convertButton;     // Triggers heigth conversion
   private JSlider heightFtSlider;    // Slider for feet input
   private JSlider heightInSlider;    // Slider for inches input

   final static double CM_PER_IN = 2.54; // Centimeters per inch
   final static int IN_PER_FT = 12;      // Inches per foot

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   HeightConverterFrame() {
      int feetMin = 0;    // Feet slider min value
      int feetMax = 10;   // Feet slider max value
      int feetInit = 5;   // Feet slider initial value
      int inchesMin = 0;  // Inches slider min value
      int inchesMax = 11; // Inches slider max value
      int inchesInit = 8; // Inches sldier initial value
      GridBagConstraints layoutConst = null; // GUI component layout

      // Set frame's title
      setTitle("Height converter");

      // Create labels
      feetLabel = new JLabel("Enter feet:");
      inchesLabel = new JLabel("Enter inches:");
      cmLabel = new JLabel("Centimeters:");

      heightCmField = new JTextField(10);
      heightCmField.setEditable(false);

      convertButton = new JButton("Convert");
      convertButton.addActionListener(this);

      // Create slider that enables user to enter height in feet
      heightFtSlider = new JSlider(feetMin, feetMax, feetInit);
      heightFtSlider.addChangeListener(this); // Use HeightConverter's stateChanged()
      heightFtSlider.setMajorTickSpacing(10);
      heightFtSlider.setMinorTickSpacing(1);
      heightFtSlider.setPaintTicks(true);
      heightFtSlider.setPaintLabels(true);

      heightFtField = new JTextField(10);
      heightFtField.setEditable(false);
      heightFtField.setText("5");

      // Creates slider that enables user to enter height in inches
      heightInSlider = new JSlider(inchesMin, inchesMax, inchesInit);
      heightInSlider.addChangeListener(this); // Use HeightConverter's stateChanged()
      heightInSlider.setMajorTickSpacing(10);
      heightInSlider.setMinorTickSpacing(1);
      heightInSlider.setPaintTicks(true);
      heightInSlider.setPaintLabels(true);

      heightInField = new JTextField(10);
      heightInField.setEditable(false);
      heightInField.setText("8");

      // Create frame and add components using GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 1);
      layoutConst.anchor = GridBagConstraints.LINE_START;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 1;
      add(feetLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 1);
      layoutConst.anchor = GridBagConstraints.LINE_START;
      layoutConst.gridx = 2;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 1;
      add(inchesLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 1, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 1;
      add(heightFtField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 1;
      add(heightInField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.gridwidth = 2;
      add(heightFtSlider, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 1;
      layoutConst.gridwidth = 2;
      add(heightInSlider, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 5);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.gridwidth = 1;
      add(convertButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      layoutConst.gridwidth = 1;
      add(cmLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 2;
      layoutConst.gridwidth = 2;
      add(heightCmField, layoutConst);
   }

   /* Converts a height in feet/inches to centimeters. */
   public static double HeightFtInToCm(int ft, int in) {
      int totIn;              // Total inches input by user
      double cmHeight;        // Corresponding height in cm

      totIn = (ft * IN_PER_FT) + in; // Total inches
      cmHeight = totIn * CM_PER_IN;  // Conver to cm
      return cmHeight;
   }

   /* Called as slider value changes. Updates fields to display
      the numerical representation of the slider settings. */
   @Override
   public void stateChanged(ChangeEvent event) {
      int sliderVal;            // Slider value (int)
      String strSliderVal;      // Slider value (string)

      // Get source of event (2 sliders in GUI)
      JSlider sourceEvent = (JSlider) event.getSource();

      if (sourceEvent == heightFtSlider) {
         sliderVal = heightFtSlider.getValue();      // Get slider value
         strSliderVal = Integer.toString(sliderVal); // Conver to int
         heightFtField.setText(strSliderVal);        // Update display
      }
      else if (sourceEvent == heightInSlider) {
         sliderVal = heightInSlider.getValue();
         strSliderVal = Integer.toString(sliderVal);
         heightInField.setText(strSliderVal);
      }

   }

   /* Called when button is pressed. Converts height to cm. */
   @Override
   public void actionPerformed(ActionEvent event) {
      int ftVal;          // User defined height in feet
      int inVal;          // User defined height in inches
      double cmVal;       // Corresponding height in cm

      ftVal = heightFtSlider.getValue();    // Get ft slider value
      inVal = heightInSlider.getValue();    // Get in slider vlaue
      cmVal = HeightFtInToCm(ftVal, inVal); // Convert ft/in to cm, update cmVal

      heightCmField.setText(Double.toString(cmVal)); // Update cm heigth
   }

   /* Creates a HeightConverterFrame and makes it visible */
   public static void main(String[] args) {
      // Creates HeightConverterFrame and its components
      HeightConverterFrame myFrame = new HeightConverterFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

To use the JSlider class, the program must include the import statement import
javax.swing.JSlider;. The statement `heightFtSlider = new JSlider(feetMin,
feetMax, feetInit);` assigns a newly created JSlider object to the variable
heightFtSlider, with the arguments feetMin, feetMax, and feetInit specifying the
slider's minimum, maximum, and initial values respectively. The heightFtSlider
slider can represent values between 0 and 10 feet, and the heightInSlider slider
allows inputs between 0 and 11 inches.

By default, JSlider components do not show tick marks. The JSlider class's
`setMajorTickSpacing()` method allows the programmer to specify the value
spacing between consecutive tick marks as an integer argument. For example, the
statement `heightFtSlider.setMajorTickSpacing(10);` configures the
heightFtSlider slider to display major tick marks every 10 feet. Similarly,
JSlider's `setMinorTickSpacing()` method allows the programmer to specify the
spacing between minor tick marks, as in the statement
`heightFtSlider.setMinorTickSpacing(1);`, which sets minor tick marks at every
foot value. Minor and major tick marks differ solely in their displayed size,
with major tick marks being larger than minor tick marks. After specifying tick
mark spacings, the programmer must invoke JSlider's `setPaintTicks()` with the
boolean literal true as an argument in order to show the tick marks.
Additionally, JSlider's `setPaintLabels()` method takes a boolean value as an
argument in order to allow the programmer to specify whether the JSlider
component should display a value at every major tick. Thus, the statement
`heightInSlider.setPaintLabels(true);` tells the GUI to display the values at
every major tick mark, i.e., every 10 feet.

The `HeightConverterFrame` class implements both an `ActionListener` and a
`ChangeListener` in order to detect events from the button and sliders
respectively. Both `JSlider` components register the current
`HeightConverterFrame` object as the designated change listener. Thus, the
program invokes the `stateChanged()` method whenever the user selects a height
value using either slider. Because the `stateChanged()` method handles change
events from two different sources (i.e., both sliders), the method first gets
the source of the event via ChangeEvent's getSource() method, as in `JSlider
sourceEvent = (JSlider) event.getSource();`, and stores the returned reference
to the source component in the local JSlider variable called sourceEvent. Next,
the `stateChanged()` method compares the source with the slider variables
heightFtSlider and heightInSlider in order to determine which slider the user
changed. Once the method determines the source component, the method uses
JSlider's `getValue()` method to extract the slider's value, `sliderVal =
heightFtSlider.getValue();`, and then displays the value in the appropriate text
field. Thus, the program can dynamically update the heightFtField and
heightInField text fields with the current values entered into the
heightFtSlider and heightInSlider sliders, respectively.

## GUI tables, fields, and buttons: A seat reservation example

> A seat reservation GUI involving a table, fields, and buttons.

SeatInfo.java

```java
public class SeatInfo {
   private String firstName; // First name
   private String lastName;  // Last name
   private int amtPaid;      // Amount paid

   // Method to initialize Seat fields
   public void reserveSeat(String inFirstName, String inLastName, int ticketCost) {
      firstName = inFirstName;
      lastName = inLastName;
      amtPaid = ticketCost;
   }

   // Method to empty a Seat
   public void makeEmpty() {
      firstName = "empty";
      lastName = "empty";
      amtPaid = 0;
   }

   // Method to check if Seat is empty
   public boolean isEmpty() {
      return firstName.equals("empty");
   }

   // Method to print Seat fields
   public void printSeatInfo() {
      System.out.print(firstName + " ");
      System.out.print(lastName + " ");
      System.out.println("Paid: " + amtPaid);
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public int getAmountPaid() {
      return amtPaid;
   }
}
```

SeatReservationFrame.java

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SeatReservationFrame extends JFrame implements ActionListener {
   private JTextField firstNameField;             // Holds first name
   private JTextField lastNameField;              // Holds last name
   private JFormattedTextField seatNumField;      // Holds seat number
   private JFormattedTextField amountPaidField;   // Holds ticket cost
   private JLabel tableLabel;                     // Label for table display
   private JLabel seatNumLabel;                   // Label for seat number
   private JLabel firstNameLabel;                 // Label for first name
   private JLabel lastNameLabel;                  // Label for last name
   private JLabel amountPaidLabel;                // Label for amount paid
   private JButton reserveButton;                 // Triggers seat reservation
   private JButton quitButton;                    // Triggers termination of GUI
   private JTable seatStatusTable;                // Table tracks seat reservations
   private final static int NUM_SEATS = 5;        // Number of seat in reservation system
   private static ArrayList<SeatInfo> seatResArr; // ArrayList of Seat objects

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SeatReservationFrame() {
      Object[][] tableVals = new Object[5][4];                // Seat reservation table
      String[] columnHeadings = {"Seat Number", "First Name", // Column headings for reservation table
                                 "Last Name", "Amount Paid"};
      GridBagConstraints layoutConst = null;                  // GUI component layout
      NumberFormat currencyFormat = null;                     // Format for amount paid

      // Set frame's title
      setTitle("Seat reservation");

      // Add 5 seat objects to ArrayList
      seatResArr = new ArrayList<SeatInfo>();
      seatsAddElements(seatResArr, NUM_SEATS);

      // Make all seats empty
      seatsMakeEmpty(seatResArr);

      // Create seat reservation table
      tableLabel = new JLabel("Seat reservation status:");
      seatNumLabel = new JLabel("Seat Number:");
      firstNameLabel = new JLabel("First Name:");
      lastNameLabel = new JLabel("Last Name:");
      amountPaidLabel = new JLabel("Amount Paid:");

      seatNumField = new JFormattedTextField(NumberFormat.getIntegerInstance());
      seatNumField.setEditable(true);
      seatNumField.setValue(0);

      firstNameField = new JTextField(20);
      firstNameField.setEditable(true);
      firstNameField.setText("John");

      lastNameField = new JTextField(20);
      lastNameField.setEditable(true);
      lastNameField.setText("Doe");

      currencyFormat = NumberFormat.getCurrencyInstance();
      currencyFormat.setMaximumFractionDigits(0);
      amountPaidField = new JFormattedTextField(currencyFormat);
      amountPaidField.setEditable(true);
      amountPaidField.setValue(0.0);

      reserveButton = new JButton("Reserve");
      reserveButton.addActionListener(this);

      quitButton = new JButton("Quit");
      quitButton.addActionListener(this);

      // Initialize table
      seatStatusTable = new JTable(tableVals, columnHeadings);
      seatStatusTable.setEnabled(false); // Prevent user input via table

      // Add components using GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(tableLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.gridwidth = 4;
      add(seatStatusTable.getTableHeader(), layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.gridwidth = 4;
      add(seatStatusTable, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(seatNumLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 4;
      add(seatNumField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 3;
      add(firstNameLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 4;
      add(firstNameField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 3;
      add(lastNameLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 4;
      add(lastNameField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 3;
      add(amountPaidLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 4;
      add(amountPaidField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 10, 10, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 4;
      add(reserveButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 5;
      layoutConst.gridy = 4;
      add(quitButton, layoutConst);
   }

   /* Called when either button is pressed. */
   @Override
   public void actionPerformed(ActionEvent event) {
      SeatInfo seatElement;  // Seat information
      String firstName;      // First name
      String lastName;       // Last name
      int seatNum;           // Seat number
      int amtPaid;           // Amount paid

      // Get source of event (2 buttons in GUI)
      JButton sourceEvent = (JButton) event.getSource();

      // User pressed the reserve button
      if (sourceEvent == reserveButton) {
         seatNum = ((Number) seatNumField.getValue()).intValue();

         // User tried to reserve non-existing seat
         if (seatNum >= NUM_SEATS) {
            // Show failure dialog
            JOptionPane.showMessageDialog(this, "Seat doesn't exist!");
         }
         // User tried to reserve a non-empty seat
         else if (!(seatResArr.get(seatNum).isEmpty())) {
            // Show failure dialog
            JOptionPane.showMessageDialog(this, "Seat is not empty!");
         }
         // Reserve the specified seat
         else {
            firstName = firstNameField.getText();
            lastName = lastNameField.getText();
            amtPaid = ((Number) amountPaidField.getValue()).intValue();

            seatElement = new SeatInfo();         // Create new Seat object
            seatElement.reserveSeat(firstName, lastName, amtPaid);
            seatResArr.set(seatNum, seatElement); // Add seat to ArrayList

            updateTable();                        // Synchronize table with sts ArrayList

            // Show success dialog
            JOptionPane.showMessageDialog(this, "Seat reservation completed.");
         }
      }
      else if (sourceEvent == quitButton) {
         dispose();                               // Terminate program
      }
   }

   /* Updates the reservation information displayed by the table */
   public void updateTable() {
      final int seatNumCol = 0;   // Col num for seat numbers
      final int firstNameCol = 1; // Col num for first names
      final int lastNameCol = 2;  // Col num for last names
      final int paidCol = 3;      // Col num for amount paid
      int i;                      // Loop index

      for (i = 0; i < NUM_SEATS && i < seatResArr.size(); ++i) {
         if (seatResArr.get(i).isEmpty()) { // Clear table entries
            seatStatusTable.setValueAt(null, i, seatNumCol);
            seatStatusTable.setValueAt(null, i, firstNameCol);
            seatStatusTable.setValueAt(null, i, lastNameCol);
            seatStatusTable.setValueAt(null, i, paidCol);
         }
         else {                             // Update table with content in the seatResArr ArrayList
            seatStatusTable.setValueAt(i, i, seatNumCol);
            seatStatusTable.setValueAt(seatResArr.get(i).getFirstName(), i, firstNameCol);
            seatStatusTable.setValueAt(seatResArr.get(i).getLastName(), i, lastNameCol);
            seatStatusTable.setValueAt(seatResArr.get(i).getAmountPaid(), i, paidCol);
         }
      }
   }

   /* Makes seats empty */
   public static void seatsMakeEmpty(ArrayList<SeatInfo> seatsRes) {
      int i;      // Loop index

      for (i = 0; i < seatsRes.size(); ++i) {
         seatsRes.get(i).makeEmpty();
      }
   }

   /* Adds empty seats to ArrayList */
   public static void seatsAddElements(ArrayList<SeatInfo> seatsRes, int numSeats) {
      int i;     // Loop index

      for (i = 0; i < numSeats; ++i) {
         seatsRes.add(new SeatInfo());
      }
   }

   /* Creates a SeatReservationFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SeatReservationFrame and its components
      SeatReservationFrame myFrame = new SeatReservationFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```

## Reading files with a GUI

A `JFileChooser` is a Swing GUI component that supports directory navigation and
file selection. The following example presents a GUI that allows the user to
select a file with a JFileChooser component and then prints the file's contents
as Unicode characters.

> Using a JFileChooser to select a file for reading.

```java
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileReadFrame extends JFrame implements ActionListener {
   private JScrollPane scrollPane;       // Container adds scroll bar
   private JTextArea outputArea;         // Holds file output
   private JLabel selectedFileLabel;     // Label for file name
   private JLabel outputLabel;           // Label for file contents
   private JTextField selectedFileField; // Holds name of file
   private JFileChooser fileChooser;     // Enables user to select file
   private JButton openFileButton;       // Trigger file open

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   FileReadFrame() {
      GridBagConstraints layoutConst = null; // GUI component layout

      // Set frame's title
      setTitle("File reader");

      outputLabel = new JLabel("File contents:");
      selectedFileLabel = new JLabel("Selected file:");

      selectedFileField = new JTextField(20);
      selectedFileField.setEditable(false);
      selectedFileField.setText("...");

      outputArea = new JTextArea(10, 25);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);

      openFileButton = new JButton("Open file");
      openFileButton.addActionListener(this);

      // Create file chooser. It's not added to this frame.
      fileChooser = new JFileChooser();

      // Add components using GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 5, 5);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(openFileButton, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 5, 5, 1);
      layoutConst.anchor = GridBagConstraints.LINE_END;
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(selectedFileLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 0;
      layoutConst.gridwidth = 2;
      layoutConst.gridheight = 1;
      add(selectedFileField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(5, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(outputLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.gridheight = 2;
      layoutConst.gridwidth = 4;
      add(scrollPane, layoutConst);
   }

   /* Called when openFileButton is pressed. */
   @Override
   public void actionPerformed(ActionEvent event) {
      FileInputStream fileByteStream = null; // File input stream
      Scanner inFS = null;                   // Scanner object
      String readLine;                       // Input from file
      File readFile = null;                  // Input file
      int fileChooserVal;                    // File chooser

      // Open file chooser dialog and get the file to open
      fileChooserVal = fileChooser.showOpenDialog(this);

      // Check if file was selected
      if (fileChooserVal == JFileChooser.APPROVE_OPTION) {
         readFile = fileChooser.getSelectedFile();

         // Update selected file field
         selectedFileField.setText(readFile.getName());

         // Ensure file is valid
         if (readFile.canRead()) {
            try {
               fileByteStream = new FileInputStream(readFile);
               inFS = new Scanner(fileByteStream);

               // Clear output area
               outputArea.setText("");

               // Read until end-of-file
               while (inFS.hasNext()) {
                  readLine = inFS.nextLine();
                  outputArea.append(readLine + "\n");
               }

            } catch (IOException e) {
               outputArea.append("\n\nError occurred while creating file stream! " + e.getMessage());
            }
         }
         else { // Can't read file
            // Show failure dialog
            JOptionPane.showMessageDialog(this, "Can't read file!");
         }
      }
   }

   /* Creates a FileReadFrame and makes it visible */
   public static void main(String[] args) {
      // Creates FileReadFrame and its components
      FileReadFrame myFrame = new FileReadFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
```


<br>

# Resources

Textbook

+ [🌎 Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 15 GUI

