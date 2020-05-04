/**
 * ParticipantTester.java
 *
 * A class that tests the correctness of a Participant class.
 *
 * @author Sat Garcia
 */

public class ParticipantTester
{
 private static int numPassed = 0;
 private static int numFailed = 0;
 private static int testNumber = 0;
 private static final String defaultName = "Joe Schmoe";
 private static final int defaultWeight = 200;
 private static final double defaultHeight = 6.0;
 private static final double defaultBMI = 3905.55;

 /**
  * Method to test default constructor, using getters to retrieve fields.
  */
 public static void testDefaultConstructor() {
  System.out.println("Creating a default participant\n");

  Participant participant = new Participant();

  System.out.println("Test #" + testNumber++ + ": Testing correct default name using the getName method\n");
  if(participant.getName().equals(defaultName)) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant.getName() + " is incorrect, the default name should be " + defaultName + "\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing correct default weight using the getWeight method\n");
  if(participant.getWeight() == defaultWeight) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant.getWeight() + " is incorrect, the default weight should be defaultWeight\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing correct default height using the getHeight method\n");
  if(participant.getHeight() == defaultHeight) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant.getHeight() + " is incorrect, the default height should be " + defaultHeight + "\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing the getBMI method on the first participant\n");
  if(Math.abs(participant.getBMI() - defaultBMI) < 0.01) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant.getBMI() + " is incorrect, the default BMI should be " + defaultBMI + "\n");
   numFailed++;
  }
 }

 /**
  * Method to test the participant's "setter" methods.
  */
 public static void testSetters() {
  System.out.println("Test #" + testNumber++ + ": Testing each set method using a default participant\n");
  Participant participant = new Participant();

  participant.setName("Sally Jane");
  System.out.println("Test #" + testNumber++ + ": Testing setName(\"Sally Jane\") method using the getName method\n");
  if(participant.getName().equals("Sally Jane")) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant.getName() + " is incorrect, the updated name should be Sally Jane\n");
   numFailed++;
  }

  participant.setWeight(100);
  System.out.println("Test #" + testNumber++ + ": Testing setWeight(100) method using the getWeight method\n");
  if(participant.getWeight() == 100) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant.getWeight() + " is incorrect, the updated weight should be 100\n");
   numFailed++;
  }

  participant.setHeight(5.0);
  System.out.println("Test #" + testNumber++ + ": Testing setHeight(5.0) using the getHeight method\n");
  if(participant.getHeight() == 5.0) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant.getHeight() + " is incorrect, the updated height should be 5.0\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing the getBMI method on the first participant after changing weight and height\n");
  if(participant.getBMI() == 2812.0) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: "+participant.getBMI() +" is incorrect, the default BMI should be 2812.0\n");
   numFailed++;
  }
 }

 /**
  * Method to test the single argument Participant constructor, which takes
  * in only the name of the participant.
  */
 public static void testSingleParamConstructor() {
  System.out.println("Creating a new participant using the single parameter constructor\n");

  Participant participant2 = new Participant("Sean Connery");

  System.out.println("Test #" + testNumber++ + ": Testing correct name using the getName method\n");
  if(participant2.getName().equals("Sean Connery")) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant2.getName() + " is incorrect, the name should be Sean Connery\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing correct default weight using the getWeight method\n");
  if(participant2.getWeight() == defaultWeight) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant2.getWeight() + " is incorrect, the default weight should be " + defaultWeight + "\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing correct default height using the getHeight method\n");
  if(participant2.getHeight() == defaultHeight) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant2.getHeight() + " is incorrect, the default height should be " + defaultHeight + "\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing the getBMI method on the second participant\n");
  if(Math.abs(participant2.getBMI() - defaultBMI) < 0.01) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant2.getBMI() + " is incorrect, the default BMI should be " + defaultBMI + "\n");
   numFailed++;
  }
 }

 /**
  * Method to test the three argument Participant constructor, which takes
  * in the name, height, and weight of the participant.
  */
 public static void testThreeParamConstructor() {
  System.out.println("Creating a new participant\n");
  Participant participant3 = new Participant("Alex Baldwin", 150, 5.0);
  System.out.println("Test #" + testNumber++ + ": Testing correct name using the getName method\n");

  if(participant3.getName().equals("Alex Baldwin")) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant3.getName() + " is incorrect, the name should be Alex Baldwin\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing correct weight using the getWeight method\n");
  if(participant3.getWeight() == 150) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant3.getWeight() + " is incorrect, the weight should be 150\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing correct height using the getHeight method\n");
  if(participant3.getHeight() == 5.0) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant3.getHeight() + " is incorrect, the height should be 5.0\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing the getBMI method on the third participant\n");
  if(participant3.getBMI() == 4218.0) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant3.getBMI() + " is incorrect, the default BMI should be 4218.0\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing the toString method\n");
  if(participant3.toString().equals("Participant:\nName: Alex Baldwin\nWeight: 150\nHeight: 5.0\n")) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant3.toString() + "\nis incorrect, the string should read:\nParticipant:\nName: Alex Baldwin\nWeight: 150\nHeight: 5.0\n");
   numFailed++;
  }
 }

 /**
  * Method to test setting weight/height to negative values; this will test
  * negative values in both the three parameter constructor and the setter
  * methods.
  */
 public static void testNegatives() {
  System.out.println("Test #" + testNumber++ + ": Testing three parameter constructor with negative height\n");
  System.out.println("Should print \"Incorrect height, height must be positive. Height will be set to default value (" + defaultHeight + ").\"");
  Participant participant4 = new Participant("Negative Height", 100, -5.0);
  System.out.println();
  if(participant4.getHeight() == defaultHeight) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant4.getHeight() + " is incorrect, the height should be " + defaultHeight + "\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing setWeight method with negative weight\n");
  System.out.println("Should print \"Incorrect weight, weight must be positive. Weight will not be updated.\"");
  System.out.println();
  participant4.setWeight(-150);
  if(participant4.getWeight() == 100) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant4.getWeight() + " is incorrect, the weight should be 100\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing three parameter constructor with negative weight\n");
  System.out.println("Should print \"Incorrect weight, weight must be positive. Weight will be set to default value (" + defaultWeight + ").\"");
  Participant participant5 = new Participant("Negative Weight", -100, 5.0);
  System.out.println();
  if(participant5.getWeight() == defaultWeight) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant5.getWeight() + " is incorrect, the weight should be " + defaultWeight + "\n");
   numFailed++;
  }

  System.out.println("Test #" + testNumber++ + ": Testing setHeight method with negative height\n");
  System.out.println("Should print \"Incorrect height, height must be positive. Height will not be updated.\"");
  participant5.setHeight(-6.0);
  System.out.println();
  if(participant5.getHeight() == 5.0) {
   System.out.println("\tTest PASSED!\n");
   numPassed++;
  }
  else
  {
   System.out.println("\tTest FAILED!\n");
   System.out.println("\tReason: " + participant5.getHeight() + " is incorrect, the weight should be 5.0\n");
   numFailed++;
  }
 }

 public static void main(String [] args)
 {
  testDefaultConstructor();
  testSetters();
  testSingleParamConstructor();
  testThreeParamConstructor();
  testThreeParamConstructor();
  testNegatives();

  System.out.println("*****************************************************");
  System.out.println("Final Testing Results:");
  System.out.println("*****************************************************");
  System.out.println(numPassed + " passed, " + numFailed + " failed");
 }
}
