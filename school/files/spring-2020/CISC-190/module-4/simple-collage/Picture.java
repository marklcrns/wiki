import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  /** M5 Simple Collage First Filter
   * Turns Picture object into negative.
   * @param start start location of pixel to filter
   * @param end end location of pixel to filter
   */
  public void negative(int start, int end)
  {
    Pixel[] pixelArray = this.getPixels();
    // Temporary pixel container
    Pixel p = null;
    // Temporary RGB components container
    int redVal, blueVal, greenVal = 0;

    // Loop over specified start until specified end
    int index = start;
    while (index < end)
    {
      // Get current pixel
      p = pixelArray[index];

      // Get RGB Components
      redVal = p.getRed();
      greenVal = p.getGreen();
      blueVal = p.getBlue();

      // Set pixel's color to negative by subtracting components to its max value
      p.setColor(new Color(
            255 - redVal,
            255 - greenVal,
            255 - blueVal));

      index++;
    }
  }

  /** M5 Simple Collage Second Custom Filter
   * Turns Picture object into personal custom filter, which alternatively
   * applies negative and grayscale filter row by row, and switches n row with
   * n+1 row.
   * @param start start location of pixel to filter
   * @param end end location of pixel to filter
   */
  public void myFilter(int start, int end)
  {
    // Picture object Pixel array
    Pixel[] pixelArray = this.getPixels();

    // Temporary pixel containers
    Pixel p1 = null;
    Pixel p2 = null;

    // Temporary intensity container for grayscale filter
    int intensity = 0;

    // Temporary RGB components container for negative filter
    int redVal, blueVal, greenVal = 0;

    // ========2D ARRAY LOOP======== //
    int pixelRange = end - start;
    int row = this.getWidth();
    int column = pixelRange / row;
    int startRow = 0;
    int endRow = 0;
    int index = 0;
    // Loop over pixel columns with specified start offset until specified end
    while (index < column - 1)
    {
      // Get start and end of row
      startRow = start + (row * index);
      endRow = startRow + row;
      // Loop over pixel rows
      while (startRow < endRow)
      {
        // Get current pixel
        p1 = pixelArray[startRow];
        p2 = pixelArray[startRow + 1];

        // Get the average of the three p1 RGB components for grayscale intensity
        intensity = (int) ((p1.getRed() + p1.getGreen() + p1.getBlue()) / 3);

        // Get p2 RGB Components
        redVal = p2.getRed();
        greenVal = p2.getGreen();
        blueVal = p2.getBlue();

        // Set p1 grayscale intensity into p2 pixel color
        p2.setColor(new Color(intensity, intensity, intensity));

        // Set p2 negative colors into p1 RGB components
        p1.setColor(new Color(
              255 - redVal,
              255 - greenVal,
              255 - blueVal));

        startRow = startRow + 2;
      }

      index++;
    }
  }

  /** M5 Simple Collage Third Filter
   * Program 21: Mirror Pixels Horizontally, Bottom-to-Top
   * Method to mirror around a horizontal line in the middle
   * based on the height of the picture. It copies the bottom
   * to the top.
   */
  public void mirrorHorizontalBottomToTop()
  {
    int height = this.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;

    for (int x = 0; x <getWidth(); x++)
    {
      // loop through the columns
      for (int y = 0; y < mirrorPoint; y++)
      {
        topPixel = getPixel(x, y);
        bottomPixel = getPixel(x, height - 1 - y);
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }

  /** M5 Simple Collage
   * Combines 3 pictures into one placing them side by side.
   * @param pic1 Picture object 1
   * @param pic2 Picture object 2
   * @param pic3 Picture object 3
   */
  public Picture collage(Picture pic1, Picture pic2, Picture pic3) {
    int picWidth = pic1.getWidth();
    int picHeight = pic1.getHeight();

    Picture canvas = new Picture(picWidth * 3, picHeight);

    Pixel srcPixel, tgtPixel = null;
    int sourceX, sourceY, targetX, targetY;

    // First picture
    for(sourceX = 0, targetX = 0; sourceX < picWidth; sourceX++, targetX++)
    {
      for(sourceY = 0, targetY = 0; sourceY < picHeight; sourceY++, targetY++)
      {
        // Copies every pixel from pic3 onto the final third of the canvas
        srcPixel = pic1.getPixel(sourceX, sourceY);
        tgtPixel = canvas.getPixel(targetX, targetY);
        tgtPixel.setColor(srcPixel.getColor());
      }
    }

    // Second picture
    for(sourceX = 0, targetX = picWidth; sourceX < picWidth; sourceX++, targetX++)
    {
      for(sourceY = 0, targetY = 0; sourceY < picHeight; sourceY++, targetY++)
      {
        // Copies every pixel from pic2 onto the second third of the canvas
        srcPixel = pic2.getPixel(sourceX, sourceY);
        tgtPixel = canvas.getPixel(targetX, targetY);
        tgtPixel.setColor(srcPixel.getColor());
      }
    }

    // Third picture
    for(sourceX = 0, targetX = 2*picWidth; sourceX < picWidth; sourceX++, targetX++)
    {
      for(sourceY = 0, targetY = 0; sourceY < picHeight; sourceY++, targetY++)
      {
        // Copies every pixel from pic3 onto the final third of the canvas
        srcPixel = pic3.getPixel(sourceX, sourceY);
        tgtPixel = canvas.getPixel(targetX, targetY);
        tgtPixel.setColor(srcPixel.getColor());
      }
    }
    return canvas;
  }

} // this } is the end of class Picture, put all new methods before this

