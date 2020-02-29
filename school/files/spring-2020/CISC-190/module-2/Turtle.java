import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, 
                 ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }  
  
  /////////////////// methods ///////////////////////


  public static void main(String[] args)
  {
    World earth = new World();
    Turtle t1 = new Turtle(earth);
    t1.forward();
  }

  // Module 2: Program 2 exercise
  public void drawSquare()
  {
    this.turnRight();
    this.forward(30);
    this.turnRight();
    this.forward(30);
    this.turnRight();
    this.forward(30);
    this.turnRight();
    this.forward(30);
  }


  // Module 2: Program 3 exercise
  public void drawSquare2()
  {
    int width = 30;
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
  }

  /** Module 2: Program 4 exercise
   * Method to draw a square with a width and height
   * of some passed amount.
   * @param width
   */
  public void drawSquare(int width)
  {
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
  }

  /** Module 2: Draw rectangle exercise
   * Method to draw a rectangle with specified width and height plus a bonus
   * direction
   * @param width
   * @param height
   * @param direction
   */
  public void drawRectangle(int width, int height, String direction)
  {
    // specify direction
    if (direction == "left")
    {
      this.turn(-180);
    } else if (direction == "right")
    {
      this.turn(180);
    }

    // draw rectangle in clockwise direction
    this.forward(width);
    this.turn(90);
    this.forward(height);
    this.turn(90);
    this.forward(width);
    this.turn(90);
    this.forward(height);
    this.turn(90);
  }

  /** Draw world grid guide lines
   * @param worldWidth world width size
   * @param worldHeight world height size
   * @param gridLines grid line amount
   */
  public void drawGrid(int worldWidth, int worldHeight, int gridLines)
  {
    /* ==========WORLD MEASUREMENTS========= */
    int worldMaxWidth = worldWidth;
    int worldMaxHeight = worldHeight;
    int worldMinWidth = 1;
    int worldMinHeight = 1;
    int worldLowerBound = worldMaxHeight - worldMinHeight;
    int worldUpperBound= worldMinHeight;
    int worldLeftBound = worldMinWidth;
    int worldRightBound = worldMaxWidth - worldMinWidth;
    int worldXRange = worldMaxWidth - worldMinWidth + 1;
    int worldYRange = worldMaxHeight - worldMinHeight + 1;
    int worldXCenter = worldMaxWidth / 2;
    int worldYCenter = worldMaxHeight / 2;

    int gridSpacing = worldXRange / gridLines;
    Color grid = new Color(240, 240, 240);
    Color centerGrid = new Color(230, 230, 230);


    this.setColor(centerGrid);
    // ====================CENTER GRIDS==================== //
    // World Center grid
    this.penUp();
    this.moveTo(worldXCenter, worldLowerBound);
    this.penDown();
    this.moveTo(worldXCenter, worldUpperBound);
    this.penUp();
    this.moveTo(worldLeftBound, worldYCenter);
    this.penDown();
    this.moveTo(worldRightBound, worldYCenter);

    this.setColor(grid);
    // ====================VERTICAL GRID==================== //
    for (int i=0; i < gridLines; i++) {
      // From left to right, draw vertical grid in upward stroke
      int startXPosition = worldLeftBound + gridSpacing + (gridSpacing * i);
      int startYPosition = worldLowerBound;
      int endXPosition = worldLeftBound + gridSpacing + (gridSpacing * i);
      int endYPosition = worldUpperBound;
      this.penUp();
      this.moveTo(startXPosition, startYPosition);
      this.penDown();
      this.moveTo(endXPosition, endYPosition);
    }

    // ====================HORIZONTAL GRID==================== //
    // Center horizontal grid
    int hGridLines = worldYRange / gridSpacing;
    int hGridLinesRange = hGridLines * gridSpacing;
    // horizontal padding for centering
    int offset = (worldYRange - hGridLinesRange) / 2;

    for (int i=0; i <= hGridLines; i++) {
      int startXPosition = worldLeftBound;
      int startYPosition = worldUpperBound + offset + (gridSpacing * i);
      int endXPosition = worldRightBound;
      int endYPosition = worldUpperBound + offset + (gridSpacing * i);
      this.penUp();
      this.moveTo(startXPosition, startYPosition);
      this.penDown();
      this.moveTo(endXPosition, endYPosition);
    }
  }

  /**
   * Method for drawing line strokes
   * @param length the length of the stroke or the number of iterations
   * @param angle the angle of the stroke
   * @param steps the steps per loop iteration
   * @param scale the steps multiplier for scaling
   * For better scaling, scale should only be even numbers
   */
  public void drawStroke(int length, int steps, int angle, int scale)
  {
    this.penDown();
    // Turtle head
    for (int i=0; i < length; i++)
    {
      this.forward(steps * scale);
      this.turn(angle);
    }
    this.penUp();
  }

  /**
   * Module 2 CreateShapes: Turtle-shaped drawing
   * @param x the x coordinate
   * @param y the y coordinate
   * @param scale the size of the shape
   * @param xShift offsets the x coordinate
   * @param yShift offsets the y coordinate
   */
  public void drawShapes(int x, int y, int scale, int xShift, int yShift)
  {
    int face = -1;

    for (int i=0; i < 2; i++)
    {
      if (i == 1)
      {
        face = i;
      }
      this.penUp();
      // LOWER BODY
      // ====================
      this.moveTo(x + xShift, y + yShift);
      this.penDown();
      // TAIL
      this.turn(45 * face);
      this.drawStroke(3, 2, 0 * face, scale);
      this.drawStroke(4, 1, 25* face, scale);
      // FEET
      this.drawStroke(2, 2, 0 * face, scale);
      this.drawStroke(5, 1, 8 * face, scale);
      // toes
      this.drawStroke(3, 1, -30 * face, scale);
      this.drawStroke(4, 2, 10 * face, scale);
      this.drawStroke(2, 1, -45 * face, scale);
      this.drawStroke(4, 1, 10 * face, scale);
      this.drawStroke(9, 1, -15 * face, scale);
      // shin
      this.drawStroke(4, 4, 10 * face, scale);

      // TORSO
      // ====================
      this.turn(60 * face);
      this.drawStroke(5, 6, -5 * face, scale);
      this.drawStroke(7, 6, -10 * face, scale);
      // LIMBS
      // lower limb
      this.turn(90 * face);
      this.drawStroke(2, 1, 0 * face, scale);
      this.turn(50 * face);
      this.drawStroke(4, 2, 8 * face, scale);
      this.drawStroke(10, 1, 1 * face, scale);
      this.drawStroke(12, 1, 0 * face, scale);
      this.drawStroke(6, 1, 1 * face, scale);
      // hands
      this.drawStroke(10, 1, 1 * face, scale);
      this.drawStroke(5, 1, -6 * face, scale);
      this.drawStroke(4, 1, -24 * face, scale);
      this.drawStroke(5, 2, -8 * face, scale);
      // shoulders
      this.drawStroke(10, 3, -2 * face, scale);
      this.drawStroke(15, 3, -8 * face, scale);
      // neck
      this.turn(100 * face);
      this.drawStroke(10, 1, 0 * face, scale);
      this.drawStroke(10, 1, 6 * face, scale);
      this.drawStroke(8, 1, 2 * face, scale);
      this.drawStroke(2, 1, -2 * face, scale);

      // HEAD
      // ====================
      this.drawStroke(6, 1, -5 * face, scale);
      this.drawStroke(15, 1, -2 * face, scale);
      this.drawStroke(5, 1, -5 * face, scale);
      this.drawStroke(6, 1, -3 * face, scale);

      // Reset position to face north
      this.penUp();
      this.turn(84 * face);
    }

  }

  public void displaySecondHalfOfName()
  {
    // Fetch Turtle's name
    String name = this.getName();
    // Get name's length and divide by two
    int half = name.length() / 2;
    // Splice string name in half
    String nameHalf = name.substring(half);

    System.out.println(nameHalf);
  }

  public void displayLastNthOfName(int n)
  {
    // Fetch Turtle's name
    String name = this.getName();
    // Splice string name from n char to the last
    int lastNthName = name.length() - (n);
    String nthName = name.substring(lastNthName);

    System.out.println(nthName);
  }

} // this } is the end of class Turtle, put all new methods before this
