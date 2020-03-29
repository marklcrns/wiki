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

  /*
   * Method that turns the picture object into grayscale
   */
  public void grayscale()
  {
    Pixel[] pixelArray = this.getPixels();
    // Temporary pixel container
    Pixel p = null;
    // Temporary intensity container
    int intensity = 0;

    // Loop over specified start until specified end
    int index = 0;
    while (index < pixelArray.length - 1)
    {
      // Get current pixel
      p = pixelArray[index];

      // Compute the average of the three RGB components to get the grayscale intensity
      intensity = (int) ((p.getRed() + p.getGreen() + p.getBlue()) / 3);

      p.setColor(new Color(intensity, intensity, intensity));

      index++;
    }
  }

  /** Module 5 Program 38: Convert a Picture to Sepia-Tones
   * Method to change the current picture to a sepia
   * tint (modify the middle colors to a light brown and
   * the light colors to a light yellow and make the
   * shadows darker)
   */
  public void sepiaTint()
  {
    Pixel pixel = null;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // first change the current picture to grayscale
    this.grayscale();

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
        // get the current pixel and color values
        pixel = this.getPixel(x, y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // tint the shadow darker
        if (redValue < 60)
        {
          redValue = redValue * 0.9;
          greenValue = greenValue * 0.9;
          blueValue = blueValue * 0.9;
        }

        // tint the midtones a light brown
        // by reducing the blue
        else if (redValue < 190)
        {
          blueValue = blueValue * 0.8;
        }

        // tint the highlights a light yellow
        // by reducing the blue
        else
        {
          blueValue = blueValue * 0.9;
        }

        // set the colors
        pixel.setRed((int) redValue);
        pixel.setGreen((int) greenValue);
        pixel.setBlue((int) blueValue);
      }
    }
  }

  /** Module 5 Program 40: Posterize by Levels
   * Method to posterize (reduce the number of colors) in
   * the picture
   * @param numLevels the number of color levels to use
   */
  public void posterize(int numLevels)
  {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int increment = (int) (256.0 / numLevels);
    int bottomValue, topValue, middleValue = 0;

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
        // get the current pixel and colors
        pixel = this.getPixel(x, y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // loop through the number of levels
        for (int i = 0; i < numLevels; i++)
        {
          // compute the bottom, top, and middle values
          bottomValue = i * increment;
          topValue = (i + 1) * increment;
          middleValue = (int) ((bottomValue + topValue - 1)
                                / 2.0);
          /*
           * check if current values are in current range and
           * if so set them to the middle value
           */
          if (bottomValue <= redValue &&
              redValue < topValue)
            pixel.setRed(middleValue);
          if (bottomValue <= greenValue &&
              greenValue < topValue)
            pixel.setGreen(middleValue);
          if (bottomValue <= blueValue &&
              blueValue < topValue)
            pixel.setBlue(middleValue);
        }
      }
    }
  }

  /** Module 5 Program 41: Highllght Extreme
   * Method to replace the pixel colors in the current
   * picture object that have a color distance less than
   * the passed amount to white or black with the passed
   * replacement color
   * @paran replacementColor the new color to use
   */
  public void hightlightLightAndDark(double amount,
                                     Color replacementColor) {
    Pixel pixel = null;
    // loop through all the pixels in the x direction
    for (int x = 0; x < getWidth(); x++) {
      // loop through all the pixels in the y direction
      for (int y = 0; y < getHeight(); y++) {
        // get the current pixel
        pixel = getPixel(x, y);

        // if the distance from white or black is Tess than the
        // passed anount use the replace co1or instead
        if (pixel.colorDistance(Color.white) < amount ||
            pixel.colorDistance(Color.black) < amount) {
          pixel.setColor(replacementColor);
        }
      }
    }
  }


} // this } is the end of class Picture, put all new methods before this

