/*
 * Filename: CreateMultipleShapes.java
 *
 * Date: 2020-03-20
 *
 * Description: This class is designed to create multiple shapes with parameters
 * passed in the command line using the Scanner class from java.util.
 *
 */

import java.util.Scanner;
import java.awt.Color;

public class CreateMultipleShapes
{
  public static void main(String[] args)
  {
    /* Creating a World with one Turtle in it and initializing variables. */
    // ===========WORLD MEASUREMENTS=========== //
    int worldMaxWidth = 800;
    int worldMaxHeight = 600;

    World canvas = new World(worldMaxWidth, worldMaxHeight);
    Turtle turtle = new Turtle(canvas);
    turtle.drawGrid(worldMaxWidth, worldMaxHeight, 50);

    Scanner input = new Scanner(System.in);

    // Grettings message
    String greetings = "Welcome to CreateMultipleShapes.java";
    String separators = "\n************************************\n";
    System.out.printf("%s%s%s", separators, greetings, separators);

    // Print out world size info for reference
    System.out.printf("World size: %dx%d\n", worldMaxWidth, worldMaxHeight);

    // Ask user for number of shapes to draw, and get response
    System.out.println("\nHow many times do you want to draw the shape?");
    int numberShapes = input.nextInt();

    int xCoordinate, yCoordinate, size, colorR, colorG, colorB;

    for (int i = 0; i < numberShapes; i++)
    {
      System.out.println(separators + "Shape number " + (i + 1) + "\n");

      // Get the x, y coordinates for where to draw the shape
      System.out.printf(
          "Suggested location for best result: around %dx%d\n",
          worldMaxWidth / 2, (worldMaxHeight / 2) + (worldMaxHeight / 3));
      System.out.println("Enter the x-coordinate:");
      xCoordinate = input.nextInt();
      System.out.println("Enter the y-coordinate:");
      yCoordinate = input.nextInt();

      // Get the size to draw the shape
      System.out.println("Enter the size (recommended size 1-4):");
      size = input.nextInt();

      // Get shape color
      System.out.println("Enter shape color in RGB format");
      System.out.println("Red value (0-255):");
      colorR = input.nextInt();
      System.out.println("Green value (0-255):");
      colorG = input.nextInt();
      System.out.println("Blue value (0-255):");
      colorB = input.nextInt();

      // Draw the shape
      turtle.setColor(new Color(colorR, colorG, colorB));
      turtle.drawShapes(xCoordinate, yCoordinate, size, 0, 0);
    }
    // Close scanner end of program
    System.out.println("\nAll done!\n");
    input.close();
  }
}
