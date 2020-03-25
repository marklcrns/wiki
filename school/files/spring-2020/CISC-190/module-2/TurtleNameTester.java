/*
 * Filename: TurtleNameTester.java
 *
 * Authors: Mark Lucernas
 *
 * Time spent: 01:00:00 hour
 *
 */

import java.awt.*;

public class TurtleNameTester
{
  public static void main(String[] args) {
    // Line 71-108 for displaySecondHalfOfName and displayLastNthOfName method
    // Still prints the result of the required results in the console
    String markName = "mark";

    // Adjust me from numbers 1-4 to see something cool! :)
    // Only fit for the turtle name "mark"
    int nth = 3;






    // ==================================================== //
    // Extra codes salvaged from previous homework DrawName //
    // ==================================================== //

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

    /* ==========INITIALIZE WORLD AND TURTLES========= */
    World w = new World(worldMaxWidth, worldMaxHeight);
    Turtle mark = new Turtle(w);
    Turtle mikko = new Turtle(w);
    Turtle chesca = new Turtle(w);
    Turtle ermats = new Turtle(w);
    mark.setName(markName);

    // Tree required Turtles
    String mikkoName = "Mikko";
    String chescaName = "Franchesca";
    String ermatsName = "Ermats";
    int mikkoNth = 1;
    int chescaNth = 6;
    int ermatsNth = 2;
    mikko.setName(mikkoName);
    chesca.setName(chescaName);
    ermats.setName(ermatsName);

    // Mark
    System.out.println("\nSecond half of: " + markName);
    mark.displaySecondHalfOfName();
    System.out.println("Last " + nth);
    mark.displayLastNthOfName(nth);
    // Mikko
    System.out.println("\nSecond half of: " + mikkoName);
    mikko.displaySecondHalfOfName();
    System.out.println("Last " + mikkoNth);
    mikko.displayLastNthOfName(mikkoNth);
    // Franchesca
    System.out.println("\nSecond half of: " + chescaName);
    chesca.displaySecondHalfOfName();
    System.out.println("Last " + chescaNth);
    chesca.displayLastNthOfName(chescaNth);
    // Ellen
    System.out.println("\nSecond half of: " + ermatsName);
    ermats.displaySecondHalfOfName();
    System.out.println("Last " + ermatsNth);
    ermats.displayLastNthOfName(ermatsNth);

    mark.hide();
    mikko.hide();
    chesca.hide();
    ermats.hide();

    /* ==========LETTERING GRID GUIDE========= */
    mark.penUp();
    mark.setColor(grid);
    // OUTER BORDER
    mark.moveTo(leftBound, upperBound);
    mark.penDown();
    mark.moveTo(leftBound, lowerBound);
    mark.moveTo(rightBound, lowerBound);
    mark.moveTo(rightBound, upperBound);
    mark.moveTo(leftBound, upperBound);
    mark.penUp();
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
      mark.moveTo(letterLeftBound, upperBound);
      mark.penDown();
      mark.moveTo(letterLeftBound, lowerBound);
      mark.moveTo(letterRightBound, lowerBound);
      mark.moveTo(letterRightBound, upperBound);
      mark.penUp();

      // Draw letter box grid
      mark.moveTo(letterXCenter, upperBound);
      mark.penDown();
      mark.moveTo(letterXCenter, lowerBound);
      mark.penUp();
      mark.moveTo(letterLeftBound, letterYCenter);
      mark.penDown();
      mark.moveTo(letterRightBound, letterYCenter);
      mark.penUp();
    }

    /* ==========DRAW MY NAME========= */
    int letterWeight = 5;
    int xShiftSpacing = 5;
    // First letter "M"
    order = 0;
    int firstXShift;
    for (int i=0; i < letterWeight; i++)
    {
      firstXShift = letterMargin + xShiftSpacing * i;
      int firstLeftBound;
      int firstRightBound;
      int firstXCenter;
      int firstYCenter;
      if (nth - 1 == order)
      {
        mark.setColor(darkred);
        firstRightBound = (leftBound + firstXShift) + (order * letterBoxWidth);
        firstLeftBound = firstRightBound + letterWidth;
        firstXCenter = firstRightBound + (letterWidth / 2);
        firstYCenter = lettersYCenter;
      }
      else
      {
        mark.setColor(black);
        firstLeftBound = (leftBound + firstXShift) + (order * letterBoxWidth);
        firstRightBound = firstLeftBound + letterWidth;
        firstXCenter = firstLeftBound + (letterWidth / 2);
        firstYCenter = lettersYCenter;
      }
      firstXShift = letterMargin;

      mark.moveTo(firstLeftBound, lowerBound);
      mark.penDown();
      mark.moveTo(firstLeftBound, upperBound);
      mark.moveTo(firstXCenter, lowerBound);
      mark.moveTo(firstRightBound, upperBound);
      mark.moveTo(firstRightBound, lowerBound);
      mark.penUp();
    }
    // Second letter "A"
    order = 1;
    int secondXShift;
    for (int i=0; i < letterWeight; i++)
    {
      secondXShift = letterMargin + xShiftSpacing * i;
      int secondLeftBound;
      int secondRightBound;
      int secondXCenter;
      int secondYCenter;
      // Flip letter and color out when the nth == order
      if (nth - 1 == order)
      {
        secondRightBound = (leftBound + secondXShift) + (order * letterBoxWidth);
        secondLeftBound = secondRightBound + letterWidth;
        secondXCenter = secondRightBound + (letterWidth / 2);
        secondYCenter = lettersYCenter;
        mark.setColor(darkred);
      }
      else
      {
        secondLeftBound = (leftBound + secondXShift) + (order * letterBoxWidth);
        secondRightBound = secondLeftBound + letterWidth;
        secondXCenter = secondLeftBound + (letterWidth / 2);
        secondYCenter = lettersYCenter;
        mark.setColor(black);
      }
      secondXShift = letterMargin;

      // start drawing
      mark.moveTo(secondLeftBound, lowerBound);
      mark.penDown();
      mark.moveTo(secondXCenter, upperBound);
      mark.moveTo(secondRightBound, lowerBound);
      mark.penUp();
    }

    // Third letter "R"
    order = 2;
    int thirdXShift;
    // Flip letter and color out when the nth == order
    for (int i=0; i < letterWeight; i++)
    {
      thirdXShift = letterMargin + xShiftSpacing * i;
      int thirdLeftBound;
      int thirdRightBound;
      int thirdXCenter;
      int thirdYCenter;
      if (nth - 1 == order)
      {
        mark.setColor(darkred);
        thirdRightBound = (leftBound + thirdXShift) + (order * letterBoxWidth);
        thirdLeftBound = thirdRightBound + letterWidth;
        thirdXCenter = thirdRightBound + (letterWidth / 2);
        thirdYCenter = lettersYCenter;
      }
      else
      {
        mark.setColor(black);
        thirdLeftBound = (leftBound + thirdXShift) + (order * letterBoxWidth);
        thirdRightBound = thirdLeftBound + letterWidth;
        thirdXCenter = thirdLeftBound + (letterWidth / 2);
        thirdYCenter = lettersYCenter;
      }
      thirdXShift = letterMargin;

      // start drawing
      mark.moveTo(thirdLeftBound, lowerBound);
      mark.penDown();
      mark.moveTo(thirdLeftBound, upperBound);
      mark.moveTo(thirdRightBound, upperBound);
      mark.moveTo(thirdRightBound, thirdYCenter);
      mark.moveTo(thirdLeftBound, thirdYCenter);
      mark.moveTo(thirdXCenter, thirdYCenter);
      mark.moveTo(thirdRightBound, lowerBound);
      mark.penUp();
    }

    // Fourth letter "K"
    order = 3;
    int fourthXShift;
    // Flip letter and color out when the nth == order
    for (int i=0; i < letterWeight; i++)
    {
      fourthXShift = letterMargin + xShiftSpacing * i;
      int fourthRightBound;
      int fourthLeftBound;
      int fourthXCenter;
      int fourthYCenter;
      if (nth - 1 == order)
      {
        mark.setColor(darkred);
        fourthRightBound = (leftBound + fourthXShift) + (order * letterBoxWidth);
        fourthLeftBound = fourthRightBound + letterWidth;
        fourthXCenter = fourthRightBound + (letterWidth / 2);
        fourthYCenter = lettersYCenter;
      }
      else
      {
        mark.setColor(black);
        fourthLeftBound = (leftBound + fourthXShift) + (order * letterBoxWidth);
        fourthRightBound = fourthLeftBound + letterWidth;
        fourthXCenter = fourthLeftBound + (letterWidth / 2);
        fourthYCenter = lettersYCenter;
      }
      fourthXShift = letterMargin;

      // start drawing
      mark.moveTo(fourthLeftBound, lowerBound);
      mark.penDown();
      mark.moveTo(fourthLeftBound, upperBound);
      mark.penUp();
      mark.moveTo(fourthRightBound, upperBound);
      mark.penDown();
      mark.moveTo(fourthXCenter, fourthYCenter);
      mark.moveTo(fourthRightBound, lowerBound);
      mark.penUp();
    }
	}
}
