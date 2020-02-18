/*
 * Filename: DrawMark.java
 * Authors: Mark Lucernas
 * Date: 2020-02-16
 *
 * Session 1
 * Started coding: 2020-02-16 14:00
 * Ended coding: 2020-02-16 17:15
 *
 * Session 2
 * Started coding: 2020-02-16 22:00
 * Ended coding: 2020-02-16 23:00
 *
 * Total Session Duration: 04:15:00 hours
 *
 */

import java.awt.*;

public class DrawMark
{
  public static void main (String[] args)
  {
    /* ==========WORLD MEASUREMENTS========= */
    int worldMaxWidth = 800;
    int worldMaxHeight = 600;
    int worldMinWidth = 1;
    int worldMinHeight = 1;
    int xRange = worldMaxWidth - worldMinWidth + 1;
    int yRange = worldMaxHeight - worldMinHeight + 1;
    int xCenter = worldMaxWidth / 2;
    int yCenter = worldMaxHeight / 2;

    /* ==========LETTERING MEASUREMENTS / DYNAMIC LETTER COUNT========= */
    int letterCount = 4;
    int letterMarginWidth = 10;
    int xBoxMargin = (worldMaxWidth - worldMinWidth) / 12;
    int yBoxMargin = (worldMaxHeight - worldMinHeight) / 3;
    int leftBound= (worldMinWidth + xBoxMargin);
    int rightBound = (worldMaxWidth - xBoxMargin);
    int upperBound = (worldMinHeight + yBoxMargin);
    int lowerBound = (worldMaxHeight - yBoxMargin);
    int lettersXRange = rightBound - leftBound;
    int lettersYRange = lowerBound - upperBound;
    int lettersXCenter = leftBound - (lettersXRange / 2);
    int lettersYCenter = upperBound + (lettersYRange / 2);
    int letterMargin = (lettersXRange / letterCount) / letterMarginWidth;
    int letterBoxWidth = (lettersXRange / letterCount);
    int letterWidth = (lettersXRange / letterCount) - (letterMargin * 2);

    /* ==========COLORS========= */
    Color red = new Color(255, 120, 120);
    Color darkred = new Color(180, 0, 0);
    Color green = new Color(120, 255, 120);
    Color blue = new Color(120, 120, 255);
    Color yellow = new Color(255, 255, 120);
    Color black = new Color(0, 0, 0);
    Color gold = new Color(212, 175, 55);
    Color grid = new Color(230, 230, 230);

    /* ==========INITIALIZE WORLD AND TURTLE========= */
    World w = new World(worldMaxWidth, worldMaxHeight);
    Turtle turtle1 = new Turtle(w);

    /* ==========BACKGROUND========= */
    // Color Switch
    boolean moveRed = true;
    boolean moveGreen = false;
    boolean moveBlue = false;
    boolean moveYellow= false;

    int starsCount = 250;

    // Create small stars at random locations within the World
    for (int i=0; i<=starsCount; i++)
    {
      // Cycle colors
      if (moveRed)
      {
        moveRed = false;
        moveGreen = true;
        moveBlue = false;
        moveYellow = false;
        turtle1.setColor(green);
      }
      else if (moveGreen)
      {
        moveRed = false;
        moveGreen = false;
        moveBlue = true;
        moveYellow = false;
        turtle1.setColor(blue);
      }
      else if (moveBlue)
      {
        moveRed = false;
        moveGreen = false;
        moveBlue = false;
        moveYellow = true;
        turtle1.setColor(red);
      }
      else if (moveYellow)
      {
        moveRed = true;
        moveGreen = false;
        moveBlue = false;
        moveYellow = false;
        turtle1.setColor(yellow);
      }

      // Random number generator with Java Math class for spiral coordinates
      int x = (int)((Math.random() * xRange) + worldMinWidth);
      int y = (int)((Math.random() * yRange) + worldMinHeight);
      turtle1.penUp();
      turtle1.moveTo(x, y);
      turtle1.penDown();

      // Draw small stars
      for (int j=0; j<=20; j++)
      {
        turtle1.turn(45);
        turtle1.forward(2);
        turtle1.turn(-90);
        turtle1.forward(-2);
      }

      turtle1.penUp();
    }

    /* ==========LETTERING GRID GUIDE========= */
    turtle1.penUp();
    turtle1.setColor(grid);
    // OUTER BORDER
    turtle1.moveTo(leftBound, upperBound);
    turtle1.penDown();
    turtle1.moveTo(leftBound, lowerBound);
    turtle1.moveTo(rightBound, lowerBound);
    turtle1.moveTo(rightBound, upperBound);
    turtle1.moveTo(leftBound, upperBound);
    turtle1.penUp();
    // INNER GRID
    int order;
    int letterLeftBound;
    int letterRightBound;
    int letterXCenter;
    int letterYCenter;
    for (int i=0; i < letterCount; i++)
    {
      // letter order starts from 0
      order = i;
      letterLeftBound = (leftBound + letterMargin) + (order * letterBoxWidth);
      letterRightBound = letterLeftBound + letterWidth;
      letterXCenter = letterLeftBound + (letterWidth / 2);
      letterYCenter = lettersYCenter;

      // Draw letter box Border
      turtle1.moveTo(letterLeftBound, upperBound);
      turtle1.penDown();
      turtle1.moveTo(letterLeftBound, lowerBound);
      turtle1.moveTo(letterRightBound, lowerBound);
      turtle1.moveTo(letterRightBound, upperBound);
      turtle1.penUp();

      // Draw letter box grid
      turtle1.moveTo(letterXCenter, upperBound);
      turtle1.penDown();
      turtle1.moveTo(letterXCenter, lowerBound);
      turtle1.penUp();
      turtle1.moveTo(letterLeftBound, letterYCenter);
      turtle1.penDown();
      turtle1.moveTo(letterRightBound, letterYCenter);
      turtle1.penUp();
    }

    /* ==========DRAW MY NAME========= */
    int letterWeight = 5;
    int xShiftSpacing = 5;
    // First letter "M"
    turtle1.setColor(black);
    order = 0;
    int firstXShift;
    for (int i=0; i < letterWeight; i++)
    {
      firstXShift = letterMargin + xShiftSpacing * i;
      int firstLeftBound = (leftBound + firstXShift) + (order * letterBoxWidth);
      int firstRightBound = firstLeftBound + letterWidth;
      int firstXCenter = firstLeftBound + (letterWidth / 2);
      int firstYCenter = lettersYCenter;
      firstXShift = letterMargin;

      turtle1.moveTo(firstLeftBound, lowerBound);
      turtle1.penDown();
      turtle1.moveTo(firstLeftBound, upperBound);
      turtle1.moveTo(firstXCenter, lowerBound);
      turtle1.moveTo(firstRightBound, upperBound);
      turtle1.moveTo(firstRightBound, lowerBound);
      turtle1.penUp();
    }
    // Second letter "A"
    order = 1;
    turtle1.setColor(darkred);
    int secondXShift;
    for (int i=0; i < letterWeight; i++)
    {
      secondXShift = letterMargin + xShiftSpacing * i;
      int secondLeftBound = (leftBound + secondXShift) + (order * letterBoxWidth);
      int secondRightBound = secondLeftBound + letterWidth;
      int secondXCenter = secondLeftBound + (letterWidth / 2);
      int secondYCenter = lettersYCenter;
      secondXShift = letterMargin;

      turtle1.moveTo(secondLeftBound, lowerBound);
      turtle1.penDown();
      turtle1.moveTo(secondXCenter, upperBound);
      turtle1.moveTo(secondRightBound, lowerBound);
      turtle1.penUp();
    }

    // Third letter "R"
    order = 2;
    turtle1.setColor(black);
    int thirdXShift;
    for (int i=0; i < letterWeight; i++)
    {
      thirdXShift = letterMargin + xShiftSpacing * i;
      int thirdLeftBound = (leftBound + thirdXShift) + (order * letterBoxWidth);
      int thirdRightBound = thirdLeftBound + letterWidth;
      int thirdXCenter = thirdLeftBound + (letterWidth / 2);
      int thirdYCenter = lettersYCenter;
      thirdXShift = letterMargin;

      turtle1.moveTo(thirdLeftBound, lowerBound);
      turtle1.penDown();
      turtle1.moveTo(thirdLeftBound, upperBound);
      turtle1.moveTo(thirdRightBound, upperBound);
      turtle1.moveTo(thirdRightBound, thirdYCenter);
      turtle1.moveTo(thirdLeftBound, thirdYCenter);
      turtle1.moveTo(thirdXCenter, thirdYCenter);
      turtle1.moveTo(thirdRightBound, lowerBound);
      turtle1.penUp();
    }

    // Fourth letter "K"
    order = 3;
    int fourthXShift;
    for (int i=0; i < letterWeight; i++)
    {
      fourthXShift = letterMargin + xShiftSpacing * i;
      int fourthLeftBound = (leftBound + fourthXShift) + (order * letterBoxWidth);
      int fourthRightBound = fourthLeftBound + letterWidth;
      int fourthXCenter = fourthLeftBound + (letterWidth / 2);
      int fourthYCenter = lettersYCenter;
      fourthXShift = letterMargin;

      turtle1.moveTo(fourthLeftBound, lowerBound);
      turtle1.penDown();
      turtle1.moveTo(fourthLeftBound, upperBound);
      turtle1.penUp();
      turtle1.moveTo(fourthRightBound, upperBound);
      turtle1.penDown();
      turtle1.moveTo(fourthXCenter, fourthYCenter);
      turtle1.moveTo(fourthRightBound, lowerBound);
      turtle1.penUp();
    }

    // Center the turtle back
    turtle1.moveTo(xCenter, yCenter);
    turtle1.setColor(gold);
  }
}
