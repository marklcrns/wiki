/**
 * FieldTester.java
 *
 * A class that tests the correctness of a Field class.
 *
 * @author Tasha Frankie
 */

public class FieldTester
{

  // fields
  private static String defaultCrop = "corn";
  private static int defaultWidth = 100;
  private static int defaultLength = 200;

  private static int numberPassed = 0;
  private static int numberFailed = 0;

  // no constructors for the tester class

  // methods

  /**
   * Method to test no-arg constructor, using getters to retrieve fields.
   */
  public static void testNoArgConstructor() {
    System.out.println("Creating a Field with the no-arg constructor.");
    Field fieldNoArg = new Field();

    System.out.println("Checking that the no-arg Field has the correct values.");
    if (fieldNoArg.getCrop().equals(defaultCrop)
          && fieldNoArg.getWidth() == defaultWidth
          && fieldNoArg.getLength() == defaultLength)
    {
      numberPassed++;
      System.out.println("No-arg constructor test PASSED\n");
    } else {
      numberFailed++;
      System.out.println("No-arg  constructor test FAILED\n");
    }
  }


  /**
   * Method to test one-arg constructor, using getters to retrieve fields.
   */
  public static void testOneArgConstructor() {
    System.out.println("Creating a Field with the one-arg constructor.");
    Field fieldNoArg = new Field("artichoke");

    System.out.println("Checking that the one-arg Field has the correct values.");
    if (fieldNoArg.getCrop().equals("artichoke")
          && fieldNoArg.getWidth() == defaultWidth
          && fieldNoArg.getLength() == defaultLength)
    {
      numberPassed++;
      System.out.println("One-arg constructor test PASSED\n");
    } else {
      numberFailed++;
      System.out.println("One-arg constructor test FAILED\n");
    }
  }

  /**
   * Method to test three-arg constructor, using getters to retrieve fields.
   * Note that it is possible to pass this test without the code being fully
   * correct.
   */
  public static void testThreeArgConstructor() {
    System.out.println("Creating a Field with the three-arg constructor.");
    Field fieldThreeArg = new Field("wheat", -10, 50);

    System.out.println("Checking that the three-arg Field has the correct values.");
    if (fieldThreeArg.getCrop().equals("wheat")
          && fieldThreeArg.getWidth() == defaultWidth
          && fieldThreeArg.getLength() == 50)
    {
      numberPassed++;
      System.out.println("Three-arg constructor test PASSED\n");
    } else {
      numberFailed++;
      System.out.println("Three-arg  constructor test FAILED\n");
    }
  }

  /**
   * Method to test setters, using getters to retrieve fields.
   */
  public static void testSetters() {
    System.out.println("Creating a Field with the no-arg constructor.");
    Field fieldNoArg = new Field();

    // test the crop setter
    System.out.println("Setting a new crop");
    fieldNoArg.setCrop("tomato");
    System.out.println("Checking that the new crop has the correct values.");
    if (fieldNoArg.getCrop().equals("tomato") )
    {
      numberPassed++;
      System.out.println("Crop setter test PASSED\n");
    } else {
      numberFailed++;
      System.out.println("Crop setter test FAILED\n");
    }

    // test the width setter, first with a valid value and then with an invalid value
    System.out.println("Setting a new valid width");
    if(fieldNoArg.setWidth(42)){
      System.out.println("Checking that the new width has the correct values.");
      if (fieldNoArg.getWidth() == 42) {
        numberPassed++;
        System.out.println("Width setter with valid value test PASSED\n");
      } else {
        numberFailed++;
        System.out.println("Width setter with valid value test FAILED");
        System.out.println("Width should be 42, but getter reports " + fieldNoArg.getWidth() + "\n");
      }
    } else {
      numberFailed++;
      System.out.println("Width setter with valid value test FAILED");
      System.out.println("Unable to set new width to 42\n");
    }
    // invalid width value now
    System.out.println("Setting a new invalid width.  This test will fail if the previous test failed.");
    if(fieldNoArg.setWidth(-10)){
      numberFailed++;
      System.out.println("Width setter with invalid value test FAILED");
      System.out.println("Should not be able to set new width to -10\n");
    } else {
      System.out.println("Checking that the width value was not changed.");
      if (fieldNoArg.getWidth() == 42) {
        numberPassed++;
        System.out.println("Width setter with invalid value test PASSED\n");
      } else {
        numberFailed++;
        System.out.println("Width setter with invalid value test FAILED");
        System.out.println("Width should still be 42, but getter reports " + fieldNoArg.getWidth() + "\n");
      }
    }


    // test the length setter, first with a valid value and then with an invalid value
    System.out.println("Setting a new valid length");
    if(fieldNoArg.setLength(26)){
      System.out.println("Checking that the new length has the correct values.");
      if (fieldNoArg.getLength() == 26) {
        numberPassed++;
        System.out.println("Length setter with valid value test PASSED\n");
      } else {
        numberFailed++;
        System.out.println("Length setter with valid value test FAILED");
        System.out.println("Length should be 26, but getter reports " + fieldNoArg.getLength() + "\n");
      }
    } else {
      numberFailed++;
      System.out.println("Length setter with valid value test FAILED");
      System.out.println("Unable to set new length to 26\n");
    }
    // invalid length value now
    System.out.println("Setting a new invalid length.  This test will fail if the previous test failed.");
    if(fieldNoArg.setLength(-5)){
      numberFailed++;
      System.out.println("Length setter with invalid value test FAILED");
      System.out.println("Should not be able to set new length to -5\n");
    } else {
      System.out.println("Checking that the length value was not changed.");
      if (fieldNoArg.getLength() == 26) {
        numberPassed++;
        System.out.println("Length setter with invalid value test PASSED\n");
      } else {
        numberFailed++;
        System.out.println("Length setter with invalid value test FAILED");
        System.out.println("Length should still be 26, but getter reports " + fieldNoArg.getLength() + "\n");
      }
    }
  }

  /**
   * Method to test calculateArea.
   */
  public static void testCalculateArea() {
    System.out.println("Creating a Field with the no-arg constructor.");
    Field fieldNoArg = new Field();

    System.out.println("Calculating the area of the no-arg field\n");
    if (fieldNoArg.calculateArea() == defaultWidth * defaultLength)
    {
      numberPassed++;
      System.out.println("Calculate area test PASSED\n");
    } else {
      numberFailed++;
      System.out.println("Calculate area test FAILED\n");
    }
  }

  /**
   * Method to test toString.
   */
  public static void testToString() {
    System.out.println("Creating a Field with the three-arg constructor.");
    Field fieldNoArg = new Field("lettuce", 300, 500);

    System.out.println("Verifying that toString returns the correct String");
    if (fieldNoArg.toString().equals("Growing lettuce in a 300 by 500 field."))
    {
      numberPassed++;
      System.out.println("toString test PASSED\n");
    } else {
      numberFailed++;
      System.out.println("toString test FAILED\n");
    }
  }


  public static void main(String[] args)
  {
    testNoArgConstructor();
    testOneArgConstructor();
    testThreeArgConstructor();
    testSetters();
    testCalculateArea();
    testToString();

    System.out.println(numberPassed + " tests out of " + (numberPassed + numberFailed) + " tests passed");

  }
}
