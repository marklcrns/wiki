/**
 * A class that defines a Field on a farm.
 *
 * @author Mark Lucernas
 */

public class Field extends Object
{
  //////////////////// fields ////////////////////
  String crop;
  int width;
  int length;

  ///////////////// constructors /////////////////
  /**
   * No-argument constructor
   */
  public Field() {
    this.crop = "corn";
    this.width = 100;
    this.length = 200;
  }

  /**
   * Constructor that takes in only the crop name. Sets the width and length of
   * the crop to default value of 100 and 200 respectively.
   * @param String crop;
   */
  public Field(String crop)
  {
    this.crop = crop;
    this.width = 100;
    this.length = 200;
  }

  /**
   * Constructor that takes in crop's name, width and height.
   * If the width or length of the crop is negative, the constructor sets the
   * values for both variables to default of 100 and 200 respectively.
   * @param String crop;
   * @param int width;
   * @param int length;
   */
  public Field(String crop, int width, int length)
  {
    this.crop = crop;

    // Set to default value if negative
    if (width >= 0) {
      this.width = width;
    } else {
      System.out.println("Incorrect width, width must be positive. Width will be set to default value (100).");
      this.width = 100;
    }
    if (length >= 0) {
      this.length = length;
    } else {
      System.out.println("Incorrect length, length must be positive. length will be set to default value (200).");
      this.length = 200;
    }
  }

  //////////////////// methods ///////////////////
  /**
   * Method that returns the crop of the field.
   * @return crop
   */
  public String getCrop() {
    return this.crop;
  }

  /**
   * Method that returns the width of the field.
   * @return width of the field
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Method that returns the length of the field.
   * @return length of the field
   */
  public int getLength() {
    return this.length;
  }

  /**
   * Method that sets the crop of the field.
   * @param crop new crop of the field
   * @return returns true of successful, else false
   */
  public boolean setCrop(String crop) {
    // set if positive
    if (crop.length() > 0) {
      this.crop = crop;
      return true;
    }
    // else is negative
    return false;
  }

  /**
   * Method that sets the crop of the field.
   * @param width new width of the field
   * @return returns true of successful, else false
   */
  public boolean setWidth(int width) {
    // set if positive
    if (width >= 0) {
      this.width = width;
      return true;
    }
    // else is negative
    return false;
  }

  /**
   * Method that sets the crop of the field.
   * @param width new length of the field
   * @return returns true of successful, else false
   */
  public boolean setLength(int length) {
    // set if positive
    if (length >= 0) {
      this.length = length;
      return true;
    }
    // else is negative
    return false;
  }

  /**
   * Method that returns all the information of the field.
   * @return all the information about the field in String format
   */
  public String toString() {
    return "Growing " + this.crop + " in a " + this.width + " by " + this.length + " field.";
  }

  /**
   * Method that returns the field area.
   * @return field area (width * height)
   */
  public int calculateArea() {
    return this.width * this.length;
  }
}
