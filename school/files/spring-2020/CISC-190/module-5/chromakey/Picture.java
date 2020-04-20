import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.lang.Math;

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

  /** Program 32: General Scale Up Method
   * Method to create a new picture that is scaled up by the
   * passed number of times.
   * @return the new scaled up picture
   */
  public Picture scaleUp(int numTimes)
  {
    Picture targetPicture =
      new Picture(this.getWidth() * numTimes,
          this.getHeight() * numTimes);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    int targetX = 0;
    int targetY = 0;

    // loop through the source picture columns
    for (int sourceX = 0;
        sourceX < this.getWidth();
        sourceX++)
    {
      // loop through the source picture rows
      for (int sourceY = 0;
          sourceY < this.getHeight();
          sourceY++)
      {
        // get the source pixelrightPixel
        sourcePixel = this.getPixel(sourceX, sourceY);

        // loop copying to the target y
        for (int indexY = 0; indexY < numTimes; indexY++)
        {
          // loop copying tot the target x
          for (int indexX = 0; indexX < numTimes; indexX++)
          {
            targetX = sourceX * numTimes + indexX;
            targetY = sourceY * numTimes + indexY;
            targetPixel = targetPicture.getPixel(targetX, targetY);
            targetPixel.setColor(sourcePixel.getColor());
          }
        }
      }
    }

    return targetPicture;
  }

  /**
   * Method that adds a vignette filter on a Picture object
   * @param value vignette intensity value
   * @param coverage vignette filter coverage
   */
  public void vignette(int coverage)
  {
    // temp containers
    Pixel p = null;
    int intensity;
    int distance;
    // centers
    double xCenter = this.getWidth() / 2;
    double yCenter = this.getHeight() / 2;

    // distance from center formula with pythagorean theorem
    // formula d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
    int furthestDistance = ((int) Math.sqrt(Math.abs(
            Math.pow(xCenter, 2) + Math.pow(yCenter, 2))));

    for (int y = 0; y < this.getHeight(); y++)
    {
      for (int x = 0; x < this.getWidth(); x++)
      {
        p = this.getPixel(x, y);
        distance = ((int) Math.sqrt(Math.abs(
                Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2)))) + coverage;
        intensity = (furthestDistance - distance);
        if (distance > furthestDistance)
        {
          p.setRed(p.getRed() + intensity);
          p.setGreen(p.getGreen() + intensity);
          p.setBlue(p.getBlue() + intensity);
        }
      }
    }
  }

  /**
   * Method to replace target color with pixels from source picture that are
   * less than the threshold parameter
   * @param targetColor target color to be replaced
   * @param thresh color distance from the target color threshold
   * @param source source picture to replace pixels that satisfies target color
   * threshold
   */
  public void chromakey(Color targetColor, double thresh, Picture source)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x = 0; x < getWidth(); x++)
    {
      //loop through the rows
      for (int y = 0; y < getHeight(); y++)
      {
        //get the current pixel
        currPixel = this.getPixel(x, y);

        /*
         * if the color at the current pixel is mostly blue
         * (blue value is greater than red and green
         * combined), then use new background color
         */
        if (currPixel.colorDistance(targetColor) < thresh)
        {
          newPixel = source.getPixel(x, y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }

} // this } is the end of class Picture, put all new methods before this

