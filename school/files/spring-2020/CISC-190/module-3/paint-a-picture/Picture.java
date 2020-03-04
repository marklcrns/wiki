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

  /** M3 Paint a Picture
   * Paint the whole Picture object by the color components passed in
   * @param red Red component RGB
   * @param green Green component in RGB
   * @param blue Blue component in RGB
   */
  public void createSolid(int red, int green, int blue)
  {

    Pixel[] pixelArray = this.getPixels();
    Color color = new Color(red, green, blue);

    for (Pixel p : pixelArray)
    {
      // Set current pixel color
      p.setColor(color);
    }
  }

  /** M3 Paint a Picture
   * Creates an alternating pattern in which even number pixels are black and
   * odd number pixels will be the RGB color passed in.
   * @param red Red component RGB
   * @param green Green component in RGB
   * @param blue Blue component in RGB
   */
  public void createPattern(int red, int green, int blue)
  {
    Pixel[] pixelArray = this.getPixels();
    Color black = new Color(0, 0, 0);
    Color color = new Color(red, green, blue);
    // Temporary pixel container
    Pixel p = null;

    // Turn even indices to black
    int even = 0;
    while (even < pixelArray.length)
    {
      // Get current pixel
      p = pixelArray[even];
      // Set current pixel color
      p.setColor(black);

      // Increment counter by 2s
      even = even + 2;
    }

    // Turn even indices to color
    int odd = 1;
    while (odd < pixelArray.length)
    {
      // Get current pixel
      p = pixelArray[odd];
      // Set current pixel color
      p.setColor(color);
      // Increment counter by 2s
      odd = odd + 2;
    }
  }

} // this } is the end of class Picture, put all new methods before this

