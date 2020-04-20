/*
 * Boundaries.java
 *
 * Name: Mark Lucernas
 *
 * Date: 2020-04-18
 *
 * Description: This method takes in a picture object and prompts user the
 * parameters to draw 3 solid-colored boxes.
 *
 */

import java.util.Scanner;
import java.awt.Color;

public class Boundaries
{
  public static void main(String[] args)
  {
    /* Connecting a Scanner object to the keyboard */
    Scanner keyboard = new Scanner(System.in);

    // default box colors
    Color[] boxColors = {Color.RED, Color.GREEN, Color.BLUE};

    /* Choosing a picture and initializing variables. */
    Picture pic = new Picture(FileChooser.pickAFile());
    pic.explore();

    int pictureWidth = pic.getWidth();
    int pictureHeight = pic.getHeight();

    // Box measurements
    int x = 0;
    int y = 0;
    int width = 0;
    int height = 0;

    System.out.println("Picture loaded...\nWidth: " + pictureWidth +
                                        "\nHeight: " + pictureHeight);

    // Attempt to draw 3 boxes
    int boxesDrawn = 1;
    while (boxesDrawn <= 3)
    {
      checkStatus(x, y, width, height, boxesDrawn);

      /* Prompting the user for coordinates. */

      String prompt = "Please enter the upper left corner (first x, then y)\n";
      prompt += "of the box to draw.\n";
      System.out.println(prompt);

      /* Converting coordinates to ints. */

      // prompt x coord
      System.out.println("Enter X coordinate 0 to " + (pictureWidth - 1) + "...");
      x = promptInt(x, pictureWidth - 1, "X");
      checkStatus(x, y, width, height, boxesDrawn);

      // prompt y coord
      System.out.println("Enter Y coordinate 0 to " + (pictureHeight - 1) + "...");
      y = promptInt(y, pictureHeight - 1, "Y");
      checkStatus(x, y, width, height, boxesDrawn);

      /* Prompting the user for width and height. */

      // prompt box width
      System.out.println("Please enter the WIDTH of the box...");
      width = promptInt(width, pictureWidth - x - 1, "Width");
      checkStatus(x, y, width, height, boxesDrawn);

      // prompt box height
      System.out.println("Please enter the HEIGHT of the box...");
      height = promptInt(height, pictureHeight - y - 1, "Height");
      checkStatus(x, y, width, height, boxesDrawn);

      // prompt if specify box color
      System.out.println("Would you like to specify the box color (true/false)...");
      boolean isColor = keyboard.nextBoolean();
      if (isColor)
      {
        int red = 0;
        int green = 0;
        int blue = 0;

        System.out.println("\nPlease enter RGB values");

        // red component
        System.out.println("enter RED value...");
        red = promptInt(red, 255, "Red");

        // green component
        System.out.println("enter GREEN value...");
        green = promptInt(green, 255, "Green");

        // blue component
        System.out.println("enter BLUE value...");
        blue = promptInt(blue, 255, "Blue");

        System.out.println("Red: " + red + ", Green: " + green + ", blue: " + blue);
        pic.drawBoxAtOffset(x, y, width, height, new Color(red, green, blue));
      }
      else
      {
        // use default colors
        System.out.println("...using default box color");
        pic.drawBoxAtOffset(x, y, width, height, boxColors[boxesDrawn]);
      }

      /* Repainting the picture with the box drawn. */
      pic.repaint();

      // draw next box
      boxesDrawn++;
    }

    System.out.println("\n...DONE!");
  }

  /**
   * Method that checks the current passed in params of box measurements
   * @param x box left corner x coordinate
   * @param y box left corner y coordinate
   * @param width box width
   * @param height box height
   */
  public static void checkStatus(int x, int y, int width, int height, int boxNum)
  {
    String status = "\n*BOX " + boxNum + " STATUS*\n";
    status += "X: " + x + ", Y: " + y + ", Width: " + width + ", Height: " + height;
    // visual separator that adjusts to the length of status string
    status += "\n" + "-".repeat(status.length()) + "\n";
    // print status
    System.out.println(status);
  }

  public static int promptInt(int targetInt, int restriction, String targetName)
  {
    Scanner keyboard = new Scanner(System.in);
    String promptError = "...please enter valid " + targetName + " within int " + restriction;
    int tmpInt;
    while(true)
    {
      tmpInt = keyboard.nextInt();
      if (tmpInt <= restriction)
      {
        targetInt = tmpInt;
        return targetInt;
      }
      System.out.println(promptError);
    }
  }
}
