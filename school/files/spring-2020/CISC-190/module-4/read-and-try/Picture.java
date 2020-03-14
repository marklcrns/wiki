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

  /** M4 Read and Try
   * Method to crop from a picture source in rectangle shape
   * @param src Source picture obect
   * @param srcLoc array of x1, x2, y1, y2 coordinates of the source rectangle
   * to be cropped
   * @param tgtLoc array of x and y target coordinates from where to start
   * pasting the cropped rectangle
   */
  public void cropFromSource(Picture src, int[] srcLoc, int[] tgtLoc)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // source parameters
    int sourceXStart = srcLoc[0];
    int sourceXEnd = srcLoc[1];
    int sourceYStart = srcLoc[2];
    int sourceYEnd = srcLoc[3];

    // target parameters
    int targetXStart = tgtLoc[0];
    int targetYStart = tgtLoc[1];

    for (int sourceX = sourceXStart, targetX = targetXStart;
        sourceX < sourceXEnd; sourceX++, targetX++)
    {
      // loop through the rows
      for (int sourceY = sourceYStart, targetY = targetYStart;
          sourceY < sourceYEnd; sourceY++, targetY++)
      {
        //set the target pixel color to the source pixel color
        sourcePixel = src.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
} // this } is the end of class Picture, put all new methods before this

