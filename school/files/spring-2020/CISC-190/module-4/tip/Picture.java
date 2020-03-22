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

  /** Module 4 TIP Practice
   * 2D approach method to swap red and green component of the top half, and
   * green and blue for the bottom half of the calling Picture object.
   */
	public void swapColors2D() {
    int picWidth = this.getWidth();
    int picHeight = this.getHeight();

    int halfOfPic = picHeight / 2;
    // temp pixel containers
		Pixel p = null;

    for (int y = 0; y < halfOfPic; y++)
    {
      for (int x = 0; x < picWidth; x++)
      {
        p = getPixel(x, y);
        // swap red and green value
        p.setRed(p.getGreen());
        p.setGreen(p.getRed());
      }
    }

    for (int y = 0; y < halfOfPic * 2; y++)
    {
      for (int x = 0; x < picWidth; x++)
      {
        p = getPixel(x, y);
        // swap green and blue value
        p.setGreen(p.getBlue());
        p.setBlue(p.getGreen());
      }
    }
	}

  public void editLeftHalf()
  {
    int picWidth = this.getWidth();
    int picHeight = this.getHeight();
    int verticalHalf = picWidth / 2;

    // temp containers
    Pixel p = null;
    int initRed, initGreen = 0;

    // loop through the left half of the calling Picture object
    for (int y = 0; y < picHeight; y++)
    {
      for (int x = 0; x < verticalHalf; x++)
      {
        p = this.getPixel(x, y);
        initRed = p.getRed();
        initGreen = p.getGreen();

        // set red to half of the green value
        p.setRed(initGreen / 2);
        // set green to three times the initial value of red
        p.setGreen(initRed * 3);
      }
    }
  }

} // this } is the end of class Picture, put all new methods before this

