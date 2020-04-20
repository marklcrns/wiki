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

  /** M3 Tri-Effect: Negative Method
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
  }

  /** Module 5 Program 42: A Simple Blur
   * Method to blur the pixels
   * @param numPixels the number of pixels to average in all
   * directions so if the numPixels is 2 then we will average
   * all pixels in the rectangle defined by 2 before the
   * current pixel to 2 after the current pixel
   */
  public void blur(int numPixels)
  {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
        // get the current pixel
        pixel = this.getPixel(x, y);

        // reset the count and red, green, and blue values
        count = 0;
        redValue = greenValue = blueValue = 0;

        /*
         * loop through pixel numPixels before x to
         * numPixels after x
         */
        for (int xSample = x - numPixels;
             xSample <= x + numPixels;
             xSample++)
        {
          for (int ySample = y - numPixels;
               ySample <= y + numPixels;
               ySample++)
          {
            /*
             * check that we are in the range of acceptable
             * pixels
             */
            if (xSample >= 0 && xSample < this.getWidth() &&
                ySample >= 0 && ySample < this.getHeight())
            {
              samplePixel = this.getPixel(xSample, ySample);
              redValue = redValue + samplePixel.getRed();
              greenValue = greenValue + samplePixel.getGreen();
              blueValue = blueValue + samplePixel.getBlue();
              count = count + 1;
            }
          }
        }

        // use average color of surrounding pixels
        Color newColor = new Color(redValue / count,
                                   greenValue / count,
                                   blueValue / count);
        pixel.setColor(newColor);
      }
    }
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

  /** M5 AdvancedCollage
   * Method that collage five Picture objects and apply various filters
   * @param pic1 top left Picture object 1
   * @param pic2 top right Picture object 2
   * @param pic3 bottom left Picture object 3
   * @param pic4 bottom right Picture object 4
   * @param pic5 center Picture object 5
   * @return collaged Picture object
   */
  public static Picture createCollage(Picture pic1, Picture pic2,
                                      Picture pic3, Picture pic4,
                                      Picture pic5)
  {
    // collage picture
    Picture collage = new Picture(504, 684);
    // collage measurements
    int collageWidth = collage.getWidth();
    int collageHeight = collage.getHeight();

    // create copies of passed in Picture objects and
    // scale them up to make sure array index does not
    // get out of bounds
    Picture p1 = new Picture(pic1).scaleUp(2);
    Picture p2 = new Picture(pic2).scaleUp(2);
    Picture p3 = new Picture(pic3).scaleUp(2);
    Picture p4 = new Picture(pic4).scaleUp(2);
    Picture p5 = new Picture(pic5).scaleUp(2);

    // apply filters
    p1.negative(1, p1.getPixels().length - 1);
    p2.negative(1, p2.getPixels().length - 1);
    p3.negative(1, p3.getPixels().length - 1);
    p4.negative(1, p4.getPixels().length - 1);
    p5.blur(5);

    // temp pixel containers
    Pixel pix = null;
    Pixel pix1 = null;
    Pixel pix2 = null;
    Pixel pix3 = null;
    Pixel pix4 = null;
    Pixel pix5 = null;


    // Center picture5 into collage canvas
    int collageWidthPadding = 0;
    int collageHeightPadding = 0;
    int pic5WidthPadding = 0;
    int pic5HeightPadding = 0;
    // width padding
    if (collage.getWidth() >= p5.getWidth())
    {
      // if collage width is wider than pic5
      collageWidthPadding = (collage.getWidth() - p5.getWidth());
    }
    else
    {
      // if collage width is narrower than pic5
      pic5WidthPadding = (p5.getWidth() - collage.getWidth());
    }
    // height padding
    if (collage.getHeight() >= p5.getHeight())
    {
      // if collage height is taller than pic5
      collageHeightPadding = (collage.getHeight() - p5.getHeight());
    }
    else
    {
      // if collage height is shorter than pic5
      pic5HeightPadding = (p5.getHeight() - collage.getHeight());
    }

    // paste picture5 onto collage canvas
    for (int y = 0; y < collage.getHeight() - (collageHeightPadding * 2); y++)
    {
      for (int x = 0; x < collage.getWidth() - (collageWidthPadding * 2); x++)
      {
        // apply padding to center onto the collage canvas
        pix = collage.getPixel(x + (collageWidthPadding / 2), y + (collageHeightPadding / 2));
        pix5 = p5.getPixel(x + (pic5WidthPadding / 2), y + (pic5HeightPadding / 2));
        pix.setColor(pix5.getColor());
      }
    }


    // 4 picture diamond collage effect
    int spacing = 1;
    int collageHalfWidth = collageWidth / 2;
    for (int y = 0; y < collageHeight - 1; y++)
    {
      // top left
      for (int x = collageHalfWidth - 1; x >= 0; x -= spacing)
      {
        // place pic1 pixel to collage canvas
        pix = collage.getPixel(x, y);
        pix1 = p1.getPixel(x, y);
        pix.setColor(pix1.getColor());
      }
      // top right
      for (int x = collageWidth - (collageHalfWidth - 1); x < collageWidth - 1; x += spacing)
      {
        // place pic2 pixel to collage canvas
        pix = collage.getPixel(x, y);
        pix2 = p2.getPixel(x, y);
        pix.setColor(pix2.getColor());
      }
      // bottom left
      for (int x = collageHalfWidth - 1; x >= 0; x -= spacing)
      {
        // place pic3 pixel to collage canvas
        pix = collage.getPixel(x, (collageHeight - 1) - y);
        pix3 = p3.getPixel(x, y);
        pix.setColor(pix3.getColor());
      }
      // bottom right
      for (int x = collageWidth - (collageHalfWidth - 1); x < collageWidth - 1; x += spacing)
      {
        // place pic4 pixel to collage canvas
        pix = collage.getPixel(x, (collageHeight - 1) - y);
        pix4 = p4.getPixel(x, y);
        pix.setColor(pix4.getColor());
      }
      collageHalfWidth--;
    }

    // apply vignette filter to collage
    collage.vignette(200);

    // return collage result
    return collage;
  }

} // this } is the end of class Picture, put all new methods before this
