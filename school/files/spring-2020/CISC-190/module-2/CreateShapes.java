/*
 * Filetype: CreateShapes.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 2020-02-22
 *
 */

import java.awt.*;

public class CreateShapes
{
	public static void main(String[] args)
  {
    /* ==========WORLD MEASUREMENTS========= */
    int worldMaxWidth = 1000;
    int worldMaxHeight = 800;
    int worldMinWidth = 1;
    int worldMinHeight = 1;
    // World bounds (north, south, east, west, respectively)
    int worldNBound= worldMinHeight;
    int worldSBound = worldMaxHeight - worldMinHeight;
    int worldEBound = worldMaxWidth - worldMinWidth;
    int worldWBound = worldMinWidth;

    int worldXRange = worldMaxWidth - worldMinWidth + 1;
    int worldYRange = worldMaxHeight - worldMinHeight + 1;
    int worldXCenter = worldMaxWidth / 2;
    int worldYCenter = worldMaxHeight / 2;

    // WORLD QUADTRANTS MEASUREMENTS
    // Upper left quadrant
    int worldQuadULNBound = worldNBound;
    int worldQuadULSBound = worldXCenter;
    int worldQuadULEBound = worldYCenter;
    int worldQuadULWBound = worldWBound;
    int worldQuadULXCenter = worldXCenter - (worldXCenter / 2);
    int worldQuadULYCenter = worldYCenter - (worldYCenter / 2);

    // Upper right quadrant
    int worldQuadURNBound = worldNBound;
    int worldQuadURSBound = worldXCenter;
    int worldQuadUREBound = worldEBound;
    int worldQuadURWBound = worldYCenter;
    int worldQuadURXCenter = worldXCenter - (worldXCenter / 2);
    int worldQuadURYCenter = worldYCenter + (worldYCenter / 2);

    // Lower left quadrant
    int worldQuadLLNBound = worldXCenter;
    int worldQuadLLSBound = worldSBound;
    int worldQuadLLEBound = worldYCenter;
    int worldQuadLLWBound = worldWBound;
    int worldQuadLLXCenter = worldXCenter + (worldXCenter / 2);
    int worldQuadLLYCenter = worldYCenter - (worldYCenter / 2);

    // Lower right quadrant
    int worldQuadLRNBound = worldXCenter;
    int worldQuadLRSBound = worldSBound;
    int worldQuadLREBound = worldEBound;
    int worldQuadLRWBound = worldYCenter;
    int worldQuadLRXCenter = worldXCenter + (worldXCenter / 2);
    int worldQuadLRYCenter = worldYCenter + (worldYCenter / 2);

    /* ==========COLORS========= */
    Color red = new Color(255, 120, 120);
    Color green = new Color(120, 255, 120);
    Color blue = new Color(120, 120, 255);
    Color yellow = new Color(250, 250, 120);
    Color black = new Color(0, 0, 0);

    // ====================INIT WORLD AND TURTLE==================== //
    World jadePalace = new World(worldMaxWidth, worldMaxHeight);
    // For drawing shapes
    Turtle oogway = new Turtle(jadePalace);
    // For drawing canvas grid
    Turtle po = new Turtle(jadePalace);
    // Extra turtles I don't need
    Turtle bodyGuard1 = new Turtle(jadePalace);
    Turtle bodyGuard2 = new Turtle(jadePalace);
    Turtle bodyGuard3 = new Turtle(jadePalace);
    Turtle bodyGuard4 = new Turtle(jadePalace);
    bodyGuard4.setColor(red);
    bodyGuard3.setColor(blue);
    bodyGuard2.setColor(green);
    bodyGuard1.setColor(yellow);


    // ====================CANVAS GRID GUIDE==================== //
    po.drawGrid(worldMaxWidth, worldMaxHeight, 20);
    po.hide();

    // ====================DRAW TURTLE SHAPE==================== //
    int turtleX = worldXCenter;
    int size;
    int turtleYShift;
    int turtleY = worldYCenter;

    // First inner layer
    size = 1;
    // Incremental downward shift relative to iterator
    turtleYShift = (worldYCenter / 6) * size;
    // Draw turtle incrementing scale relative to iterator
    bodyGuard1.drawShapes(turtleX, turtleY, 1 + size, 0, turtleYShift);
    bodyGuard1.moveTo(worldXCenter, worldYCenter);

    // Seccond inner layer
    size = 2;
    // Incremental downward shift relative to iterator
    turtleYShift = (worldYCenter / 6) * size;
    // Draw turtle incrementing scale relative to iterator
    bodyGuard2.drawShapes(turtleX, turtleY, 1 + size, 0, turtleYShift);
    bodyGuard2.moveTo(worldXCenter, worldYCenter);

    // Third inner layer
    size = 3;
    // Incremental downward shift relative to iterator
    turtleYShift = (worldYCenter / 6) * size;
    // Draw turtle incrementing scale relative to iterator
    bodyGuard3.drawShapes(turtleX, turtleY, 1 + size, 0, turtleYShift);
    bodyGuard3.moveTo(worldXCenter, worldYCenter);

    // Outer layer
    size = 4;
    // Incremental downward shift relative to iterator
    turtleYShift = (worldYCenter / 6) * size;
    // Draw turtle incrementing scale relative to iterator
    bodyGuard4.drawShapes(turtleX, turtleY, 1 + size, 0, turtleYShift);
    bodyGuard4.moveTo(worldXCenter, worldYCenter);

    bodyGuard1.moveTo(worldQuadLRXCenter, worldQuadLRYCenter);
    bodyGuard2.moveTo(worldQuadLLXCenter, worldQuadLLYCenter);
    bodyGuard3.moveTo(worldQuadURXCenter, worldQuadURYCenter);
    bodyGuard4.moveTo(worldQuadULXCenter, worldQuadULYCenter);
	}
}
