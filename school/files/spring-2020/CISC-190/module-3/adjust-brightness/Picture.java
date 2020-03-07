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

  /**
   * Adjust the Picture object's brightness
   * @param intensity percentage
   */
  public void adjustBrightness(int intensity)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int r = 0;
    int g = 0;
    int b = 0;
    float percentage = (float) intensity / 100;
    int index = 0;

    // Loop through all the pixels
    while(index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // get the RGB values
      r = pixel.getRed();
      g = pixel.getGreen();
      b = pixel.getBlue();

      // adjust RGB values by intensity
      r = (int) (r * percentage);
      g = (int) (g * percentage);
      b = (int) (b * percentage);

      // set the red value of the current pixel to the new value
      pixel. setRed(r);
      pixel. setGreen(g);
      pixel. setBlue(b);

      index++;
    }
  }

} // this } is the end of class Picture, put all new methods before this

