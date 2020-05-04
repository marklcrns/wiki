/**
 * A class that describes a Participant and gets its BMI.
 *
 * Instance of a Participant can take in the name, weight and height of the
 * participant to calculate its BMI (Body Mass Index).
 *
 * @author Mark Lucernas
 */

import java.lang.Math;

public class Participant extends Object
{
  //////////////////// fields ////////////////////
  String name;
  int weight;
  double height;

  ///////////////// constructors /////////////////
  /**
   * No-argument constructor
   */
  public Participant() {
    this.name = "Joe Schmoe";
    this.weight = 200;
    this.height = 6.0;
  }

  /**
   * Constructor that takes in only the participant's name. Sets the weight
   * and height of the participant to default value of 200 and 6.0 respectively.
   * @param name participant's name
   */
  public Participant(String name)
  {
    this.name = name;
    this.weight = 200;
    this.height = 6.0;
  }

  /**
   * Constructor that takes in the name, weight and height of a participant.
   * If the weight or height of the participant is negative, it sets the values
   * for both variables to default of 200 and 6.0 respectively.
   * @param name participant's name
   * @param weight participant's weight in pounds (lbs)
   * @param height participant's height in feet (ft)
   */
  public Participant(String name, int weight, double height)
  {
    this.name = name;

    // Set to default value if negative
    if (weight < 0) {
      this.weight = 200;
      System.out.println(
          "Incorrect weight, weight must be positive. Weight will be set to default value (200).");
    } else {
      this.weight = weight;
    }
    if (height < 0) {
      this.height = 6.0;
      System.out.println(
          "Incorrect height, height must be positive. Height will be set to default value (6.0).");
    } else {
      this.height = height;
    }
  }

  //////////////////// methods ///////////////////
  /**
   * Method that returns the name of the participant.
   * @return name of the participant
   */
  public String getName() {
    return this.name;
  }

  /**
   * Method that returns the weight of the participant in pounds.
   * @return weight of the participant
   */
  public int getWeight() {
    return this.weight;
  }

  /**
   * Method that returns the height of the participant in feet.
   * @return height of the participant
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Method that sets the name of the participant.
   * @param name new name of the participant
   * @return returns true of successful, else false
   */
  public boolean setName(String name) {
    // set if name is valid or at least one character
    if (name.length() > 0) {
      this.name = name;
      return true;
    }
    // else is invalid
    return false;
  }

  /**
   * Method that sets the weight of the participant
   * @param weight new weight of the participant in pounds (lbs)
   * @return returns true of successful, else false
   */
  public boolean setWeight(int weight) {
    // set if positive
    if (weight >= 0) {
      this.weight = weight;
      return true;
    }
    // else is negative
    System.out.println(
        "Incorrect weight, weight must be positive. Weight will not be updated.");
    return false;
  }

  /**
   * Method that sets the height of the participant
   * @param height new height of the participant in feet (ft)
   * @return returns true of successful, else false
   */
  public boolean setHeight(double height) {
    // set if positive
    if (height >= 0) {
      this.height = height;
      return true;
    }
    // else is negative
    System.out.println(
        "Incorrect height, height must be positive. Height will not be updated.");
    return false;
  }

  /**
   * Method that returns all the information of the participant
   * @return all the information about the participant in String format
   */
  public String toString() {
    return "Participant:\nName: " + this.name +
           "\nWeight: " + this.weight +
           "\nHeight: " + this.height +
           "\n";
  }

  /**
   * Method that returns the BMI (Body Mass Index) of the participant.
   * @return the BMI of the participant (weight/height^2) * 703)
   */
  public double getBMI() {
    return (this.weight/Math.pow(this.height, 2)) * 703;
  }
}
