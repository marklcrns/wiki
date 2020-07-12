---
title: Recursion Java Sample Codes
author: Mark Lucernas
date: 2020-06-30
summary: Recursion Java Sample Codes
---


# Recursion Java Sample Codes

## Recursive Methods

```java
public class RecursiveCalls {
   public static void backwardsAlphabet(char currLetter) {
      if (currLetter == 'a') {
         System.out.println(currLetter);
      }
      else {
         System.out.print(currLetter + " ");
         backwardsAlphabet((char)(currLetter - 1));
      }
   }

   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      char startingLetter;

      startingLetter = scnr.next().charAt(0);

      backwardsAlphabet(startingLetter);
   }
}
```

### Recursive Method with Binary Search Algorithm.

```java
import java.util.Scanner;

public class NumberGuessGame {
   public static void guessNumber(int lowVal, int highVal, Scanner scnr) {
      int midVal;            // Midpoint of low..high
      char userAnswer;       // User response

      midVal = (highVal + lowVal) / 2;

      // Prompt user for input
      System.out.print("Is it " + midVal + "? (l/h/y): ");
      userAnswer = scnr.next().charAt(0);

      if ((userAnswer != 'l') && (userAnswer != 'h')) { // Base case: found number
         System.out.println("Thank you!");
      }
      else {                                            // Recursive case: split into lower OR upper half
         if (userAnswer == 'l') {                       // Guess in lower half
            guessNumber(lowVal, midVal, scnr);                // Recursive call
         }
         else {                                         // Guess in upper half
            guessNumber(midVal + 1, highVal, scnr);           // Recursive call
         }
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // Print game objective, user input commands
      System.out.println("Choose a number from 0 to 100.");
      System.out.println("Answer with:");
      System.out.println("   l (your num is lower)");
      System.out.println("   h (your num is higher)");
      System.out.println("   any other key (guess is right).");

      // Call recursive function to guess number
      guessNumber(0, 100, scnr);
   }
}
```

### Recursively Searching a Sorted List

```java
import java.util.Scanner;
import java.util.ArrayList;

public class NameFinder {
   /* Finds index of string in vector of strings, else -1.
      Searches only with index range low to high
      Note: Upper/lower case characters matter
   */
   public static int findMatch(ArrayList<String> stringList, String itemMatch,
                               int lowVal, int highVal) {
      int midVal;        // Midpoint of low and high values
      int itemPos;       // Position where item found, -1 if not found
      int rangeSize;     // Remaining range of values to search for match

      rangeSize = (highVal - lowVal) + 1;
      midVal = (highVal + lowVal) / 2;

      if (itemMatch.equals(stringList.get(midVal))) {           // Base case 1: item found at midVal position
         itemPos = midVal;
      }
      else if (rangeSize == 1) {                                // Base case 2: match not found
         itemPos = -1;
      }
      else {                                                    // Recursive case: search lower or upper half
         if (itemMatch.compareTo(stringList.get(midVal)) < 0) { // Search lower half, recursive call
            itemPos = findMatch(stringList, itemMatch, lowVal, midVal);
         }
         else {                                                 // Search upper half, recursive call
            itemPos = findMatch(stringList, itemMatch, midVal + 1, highVal);
         }
      }

      return itemPos;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> attendeesList = new ArrayList<String>(); // List of attendees
      String attendeeName;                                       // Name of attendee to match
      int matchPos;                                              // Matched position in attendee list

      // Omitting part of program that adds attendees
      // Instead, we insert some sample attendees in sorted order
      attendeesList.add("Adams, Mary");
      attendeesList.add("Carver, Michael");
      attendeesList.add("Domer, Hugo");
      attendeesList.add("Fredericks, Carlos");
      attendeesList.add("Li, Jie");

      // Prompt user to enter a name to find
      System.out.print("Enter person's name: Last, First: ");
      attendeeName = scnr.nextLine(); // Use nextLine() to allow space in name

      // Call function to match name, output results
      matchPos = findMatch(attendeesList, attendeeName, 0, attendeesList.size() - 1);
      if (matchPos >= 0) {
         System.out.println("Found at position " + matchPos + ".");
      }
      else {
         System.out.println("Not found.");
      }
   }
}
```

#### Debugging Recursive Methods with Print Statements

```java
import java.util.Scanner;
import java.util.ArrayList;

public class NameFinder {
   /* Finds index of string in vector of strings, else -1.
      Searches only with index range low to high
      Note: Upper/lower case characters matter
   */
   public static int findMatch(ArrayList<String> stringList, String itemMatch,
                               int lowVal, int highVal, String indentAmt) { // indentAmt used for print debug
      int midVal;        // Midpoint of low and high values
      int itemPos;       // Position where item found, -1 if not found
      int rangeSize;     // Remaining range of values to search for match

      System.out.println(indentAmt + "Find() range " + lowVal + " " + highVal);
      rangeSize = (highVal - lowVal) + 1;
      midVal = (highVal + lowVal) / 2;

      if (itemMatch.equals(stringList.get(midVal))) {           // Base case 1: item found at midVal position
         System.out.println(indentAmt + "Found person.");
         itemPos = midVal;
      }
      else if (rangeSize == 1) {                                // Base case 2: match not found
         System.out.println(indentAmt + "Person not found.");
         itemPos = -1;
      }
      else {                                                    // Recursive case: search lower or upper half
         if (itemMatch.compareTo(stringList.get(midVal)) < 0) { // Search lower half, recursive call
            System.out.println(indentAmt + "Searching lower half.");
            itemPos = findMatch(stringList, itemMatch, lowVal, midVal, indentAmt + "   ");
         }
         else {                                                 // Search upper half, recursive call
            System.out.println(indentAmt + "Searching upper half.");
            itemPos = findMatch(stringList, itemMatch, midVal + 1, highVal, indentAmt + "   ");
         }
      }

      System.out.println(indentAmt + "Returning pos = " + itemPos + ".");
      return itemPos;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> attendeesList = new ArrayList<String>(); // List of attendees
      String attendeeName;                                       // Name of attendee to match
      int matchPos;                                              // Matched position in attendee list

      // Omitting part of program that adds attendees
      // Instead, we insert some sample attendees in sorted order
      attendeesList.add("Adams, Mary");
      attendeesList.add("Carver, Michael");
      attendeesList.add("Domer, Hugo");
      attendeesList.add("Fredericks, Carlos");
      attendeesList.add("Li, Jie");

      // Prompt user to enter a name to find
      System.out.print("Enter person's name: Last, First: ");
      attendeeName = scnr.nextLine(); // Use nextLine() to allow space in name

      // Call function to match name, output results
      matchPos = findMatch(attendeesList, attendeeName, 0, attendeesList.size() - 1, "   ");
      if (matchPos >= 0) {
         System.out.println("Found at position " + matchPos + ".");
      }
      else {
         System.out.println("Not found.");
      }
   }
}
```

### Double Pennies

```java
import java.util.Scanner;

public class CalculatePennies {
// Returns number of pennies if pennies are doubled numDays times
   public static long doublePennies(long numPennies, int numDays) {
      long totalPennies;

      /* Your solution goes here  */
      if (numDays == 0) {
         return numPennies;
      } else {
         totalPennies = doublePennies((numPennies * 2), numDays - 1);
      }

      return totalPennies;
   }

// Program computes pennies if you have 1 penny today,
// 2 pennies after one day, 4 after two days, and so on
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      long startingPennies;
      int userDays;

      startingPennies = scnr.nextLong();
      userDays = scnr.nextInt();
      System.out.println("Number of pennies after " + userDays + " days: "
           + doublePennies(startingPennies, userDays));
   }
}
```


## Recursive Math Methods

### Factorial

```java
import java.util.Scanner;

public class RecursivelyPrintFactorial {
   public static void printFactorial(int factCounter, int factValue) {
      int nextCounter;
      int nextValue;

      if (factCounter == 0) { // Base case: 0! = 1
         System.out.println("1");
      }
      else if (factCounter == 1) { // Base case: Print 1 and result
         System.out.println(factCounter + " = " + factValue);
      }
      else { // Recursive case
         System.out.print(factCounter + " * ");
         nextCounter = factCounter - 1;
         nextValue = nextCounter * factValue;

         printFactorial(nextCounter, nextValue);

      }
   }

   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      int userVal;

      userVal = scnr.nextInt();
      System.out.print(userVal + "! = ");
      printFactorial(userVal, userVal);
   }
}
```

### Fibonacci Sequence

```java
import java.util.Scanner;

public class FibonacciSequence {
   /* Output the Fibonacci sequence step-by-step.
      Fibonacci sequence starts as:
      0 1 1 2 3 5 8 13 21 ... in which the first
      two numbers are 0 and 1 and each additional
      number is the sum of the previous two numbers
   */
   public static void computeFibonacci(int fibNum1, int fibNum2, int runCnt) {
      System.out.println(fibNum1 + " + " + fibNum2 + " = " +
                         (fibNum1 + fibNum2));

      if (runCnt <= 1) { // Base case: Ran for user specified
                         // number of steps, do nothing
      }
      else {             // Recursive case: compute next value
         computeFibonacci(fibNum2, fibNum1 + fibNum2, runCnt - 1);
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int runFor;     // User specified number of values computed

      // Output program description
      System.out.println("This program outputs the\n" +
                         "Fibonacci sequence step-by-step,\n" +
                         "starting after the first 0 and 1.\n");

      // Prompt user for number of values to compute
      System.out.print("How many steps would you like? ");
      runFor = scnr.nextInt();

      // Output first two Fibonacci values, call recursive function
      System.out.println("0\n1");
      computeFibonacci(0, 1, runFor);
   }
}
```

### Greatest Common Divisor

```java
import java.util.Scanner;

public class GCDCalc {
   /* Determine the greatest common divisor
      of two numbers, e.g. GCD(8, 12) = 4
   */
   public static int gcdCalculator(int inNum1, int inNum2) {
      int gcdVal;     // Holds GCD results

      if (inNum1 == inNum2) {   // Base case: Numbers are equal
         gcdVal = inNum1;       // Return value
      }
      else {                    // Recursive case: subtract smaller from larger
         if (inNum1 > inNum2) { // Call function with new values
            gcdVal = gcdCalculator(inNum1 - inNum2, inNum2);
         }
         else { // n1 is smaller
            gcdVal = gcdCalculator(inNum1, inNum2 - inNum1);
         }
      }

      return gcdVal;
   }

   public static void main (String[] args) {
      Scanner scnr = new Scanner(System.in);
      int gcdInput1;     // First input to GCD calc
      int gcdInput2;     // Second input to GCD calc
      int gcdOutput;     // Result of GCD

      // Print program function
      System.out.println("This program outputs the greatest \n" +
                         "common divisor of two numbers.");

      // Prompt user for input
      System.out.print("Enter first number: ");
      gcdInput1 = scnr.nextInt();

      System.out.print("Enter second number: ");
      gcdInput2 = scnr.nextInt();

      // Check user values are > 1, call recursive GCD function
      if ((gcdInput1 < 1) || (gcdInput2 < 1)) {
         System.out.println("Note: Neither value can be below 1.");
      }
      else {
         gcdOutput = gcdCalculator(gcdInput1, gcdInput2);
         System.out.println("Greatest common divisor = " +  gcdOutput);
      }
   }
}
```

### Exponent

```java
import java.util.Scanner;

public class ExponentMethod {
   public static int raiseToPower(int baseVal, int exponentVal) {
      int resultVal;

      if (exponentVal == 0) {
         resultVal = 1;
      }
      else {
         resultVal = baseVal * raiseToPower(baseVal, exponentVal - 1);
      }

      return resultVal;
   }

   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      int userBase;
      int userExponent;

      userBase = scnr.nextInt();
      userExponent = scnr.nextInt();
      System.out.println(userBase + "^" + userExponent + " = "
        + raiseToPower(userBase, userExponent));
   }
}
```


## Recursive Exploration

### Word Scrambler

```java
import java.util.Scanner;

public class WordScrambler {
   /* Output every possible combination of a word.
      Each recursive call moves a letter from
      remainLetters" to scramLetters".
   */
   public static void scrambleLetters(String remainLetters,  // Remaining letters
                                      String scramLetters) { // Scrambled letters
      String tmpString;      // Temp word combinations
      int i;                 // Loop index

      if (remainLetters.length() == 0) { // Base case: All letters used
         System.out.println(scramLetters);
      }
      else {                             // Recursive case: move a letter from
                                         // remaining to scrambled letters
         for (i = 0; i < remainLetters.length(); ++i) {
            // Move letter to scrambled letters
            tmpString = remainLetters.substring(i, i + 1);
            remainLetters = removeFromIndex(remainLetters, i);
            scramLetters = scramLetters + tmpString;

            scrambleLetters(remainLetters, scramLetters);

            // Put letter back in remaining letters
            remainLetters = insertAtIndex(remainLetters, tmpString, i);
            scramLetters = removeFromIndex(scramLetters, scramLetters.length() - 1);
         }
      }
   }

   // Returns a new String without the character at location remLoc
   public static String removeFromIndex(String origStr, int remLoc) {
      String finalStr;      // Temp string to extract char

      finalStr = origStr.substring(0, remLoc);                     // Copy before location remLoc
      finalStr += origStr.substring(remLoc + 1, origStr.length()); // Copy after location remLoc

      return finalStr;
   }

   // Returns a new String with the character specified by insertStr
   // inserted at location addLoc
   public static String insertAtIndex(String origStr, String insertStr, int addLoc) {
      String finalStr;      // Temp string to extract char

      finalStr = origStr.substring(0, addLoc);                 // Copy before location addLoc
      finalStr += insertStr;                                   // Copy character to location addLoc
      finalStr += origStr.substring(addLoc, origStr.length()); // Copy after location addLoc

      return finalStr;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String wordScramble;      // User defined word to scramble

      // Prompt user for input
      System.out.print("Enter a word to be scrambled: ");
      wordScramble = scnr.next();

      // Call recursive method
      scrambleLetters(wordScramble, "");
   }
}
```

### Shopping Spree Combinations

```java
public class GroceryItem {
   public String itemName;  // Name of item
   public int priceDollars; // Price of item
}
```

```java
import java.util.ArrayList;

public class ShoppingSpreeCombinations {
   public static final int MAX_SHOPPING_BAG_SIZE = 3; // Max number of items in shopping bag

   /* Output every combination of items that fit
      in a shopping bag. Each recursive call moves
      one item into the shopping bag.
   */
   public static void shoppingBagCombinations(ArrayList<GroceryItem> currBag,          // Bag contents
                                              ArrayList<GroceryItem> remainingItems) { // Available items
      int bagValue;               // Cost of items in shopping bag
      GroceryItem tmpGroceryItem; // Grocery item to add to bag
      int i;                      // Loop index

      if (currBag.size() == MAX_SHOPPING_BAG_SIZE) {   // Base case: Shopping bag full
         bagValue = 0;
         for (i = 0; i < currBag.size(); ++i) {
            bagValue += currBag.get(i).priceDollars;
            System.out.print(currBag.get(i).itemName + "  ");
         }
         System.out.println("= $" + bagValue);
      }
      else {                                           // Recursive case: move one
         for (i = 0; i < remainingItems.size(); ++i) { // item to bag
            // Move item into bag
            tmpGroceryItem = remainingItems.get(i);
            remainingItems.remove(i);
            currBag.add(tmpGroceryItem);

            shoppingBagCombinations(currBag, remainingItems);

            // Take item out of bag
            remainingItems.add(i, tmpGroceryItem);
            currBag.remove(currBag.size() - 1);
         }
      }
   }

   public static void main(String[] args) {
      ArrayList<GroceryItem> possibleItems = new ArrayList<GroceryItem>(); // Possible shopping items
      ArrayList<GroceryItem> shoppingBag = new ArrayList<GroceryItem>();   // Current shopping bag
      GroceryItem tmpGroceryItem;                                          // Temp item

      // Populate grocery with different items
      tmpGroceryItem = new GroceryItem();
      tmpGroceryItem.itemName = "Milk";
      tmpGroceryItem.priceDollars = 2;
      possibleItems.add(tmpGroceryItem);

      tmpGroceryItem = new GroceryItem();
      tmpGroceryItem.itemName = "Belt";
      tmpGroceryItem.priceDollars = 24;
      possibleItems.add(tmpGroceryItem);

      tmpGroceryItem = new GroceryItem();
      tmpGroceryItem.itemName = "Toys";
      tmpGroceryItem.priceDollars = 19;
      possibleItems.add(tmpGroceryItem);

      tmpGroceryItem = new GroceryItem();
      tmpGroceryItem.itemName = "Cups";
      tmpGroceryItem.priceDollars = 12;
      possibleItems.add(tmpGroceryItem);

      // Try different combinations of three items
      shoppingBagCombinations(shoppingBag, possibleItems);
   }
}
```

### Traveling Salesman Paths

```java
import java.util.ArrayList;

public class TravelingSalesmanPaths {
   public static final int NUM_CITIES = 3;                                // Number of cities
   public static int[][] cityDistances = new int[NUM_CITIES][NUM_CITIES]; // Distance between cities
   public static String[] cityNames = new String[NUM_CITIES];             // City names

   /* Output every possible travel path.
      Each recursive call moves to a new city.
   */
   public static void travelPaths(ArrayList<Integer> currPath,
                                  ArrayList<Integer> needToVisit) {
      int totalDist;     // Total distance given current path
      int tmpCity;       // Next city distance
      int i;             // Loop index

      if ( currPath.size() == NUM_CITIES ) { // Base case: Visited all cities
         totalDist = 0;                      // Return total path distance
         for (i = 0; i < currPath.size(); ++i) {
            System.out.print(cityNames[currPath.get(i)] + "   ");

            if (i > 0) {
               totalDist += cityDistances[currPath.get(i - 1)][currPath.get(i)];
            }
         }

         System.out.println("= " + totalDist);
      }
      else {                                 // Recursive case: pick next city
         for (i = 0; i < needToVisit.size(); ++i) {
            // add city to travel path
            tmpCity = needToVisit.get(i);
            needToVisit.remove(i);
            currPath.add(tmpCity);

            travelPaths(currPath, needToVisit);

            // remove city from travel path
            needToVisit.add(i, tmpCity);
            currPath.remove(currPath.size() - 1);
         }
      }
   }

   public static void main (String[] args) {
      ArrayList<Integer> needToVisit = new ArrayList<Integer>(); // Cities left to visit
      ArrayList<Integer> currPath = new ArrayList<Integer>();    // Current path traveled

      // Initialize distances array
      cityDistances[0][0] = 0;
      cityDistances[0][1] = 960;  // Boston-Chicago
      cityDistances[0][2] = 2960; // Boston-Los Angeles
      cityDistances[1][0] = 960;  // Chicago-Boston
      cityDistances[1][1] = 0;
      cityDistances[1][2] = 2011; // Chicago-Los Angeles
      cityDistances[2][0] = 2960; // Los Angeles-Boston
      cityDistances[2][1] = 2011; // Los Angeles-Chicago
      cityDistances[2][2] = 0;

      cityNames[0] = "Boston";
      cityNames[1] = "Chicago";
      cityNames[2] = "Los Angeles";

      needToVisit.add(new Integer(0)); // Boston
      needToVisit.add(new Integer(1)); // Chicago
      needToVisit.add(new Integer(2)); // Los Angeles

      // Explore different paths
      travelPaths(currPath, needToVisit);
   }
}
```

### Number Scrambler

```java
import java.util.Scanner;
import java.util.ArrayList;

public class NumScrambler {
   public static void scrambleNums(ArrayList<Integer> remainNums,
                                   ArrayList<Integer> scramNums) {
      ArrayList<Integer> tmpRemainNums;
      int tmpRemovedNum;
      int i;

      if (remainNums.size() == 0) {
         System.out.print(scramNums.get(0));
         System.out.print(scramNums.get(1));
         System.out.println(scramNums.get(2));
      }
      else {
         for (i = 0; i < remainNums.size(); ++i) {
            tmpRemainNums = new ArrayList<Integer>(remainNums); // Make a copy.
            tmpRemovedNum = tmpRemainNums.remove(i);
            scramNums.add(tmpRemovedNum);
            scrambleNums(tmpRemainNums, scramNums);
            scramNums.remove(scramNums.size() - 1);
         }
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<Integer> numsToScramble = new ArrayList<Integer>();
      ArrayList<Integer> resultNums = new ArrayList<Integer>();

      numsToScramble.add(2);
      numsToScramble.add(4);
      numsToScramble.add(9);

      scrambleNums(numsToScramble, resultNums);
   }
}
```

## All Permutations of Names

Write a program that lists all ways people can line up for a photo (all
permutations of a list of Strings). The program will read a list of one word
names (until -1), and use a recursive method to create and output all possible
orderings of those names, one ordering per line.

When the input is:

```
Julia Lucas Mia -1
```

then the output is (must match the below ordering):

```
Julia Lucas Mia
Julia Mia Lucas
Lucas Julia Mia
Lucas Mia Julia
Mia Julia Lucas
Mia Lucas Julia
```

```java
import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

   public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
      ArrayList<String> tmpRemainNames;
      String tmpRemovedName;
      int i;

      if (nameList.size() == 0) {
         for (int j = 0; j < permList.size(); j++) {
            System.out.print(permList.get(j) + " ");
         }
         System.out.println();
      }
      else {
         for (i = 0; i < nameList.size(); ++i) {
            tmpRemainNames = new ArrayList<String>(nameList); // Make a copy.
            tmpRemovedName = tmpRemainNames.remove(i);
            permList.add(tmpRemovedName);
            allPermutations(permList, tmpRemainNames);
            permList.remove(permList.size() - 1);
         }
      }

   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> nameList = new ArrayList<String>();
      ArrayList<String> permList = new ArrayList<String>();
      String name;

      name = scnr.nextLine();
      String[] names = name.split(" ");
      int ct = 0;
      while (!names[ct].equals("-1")){
         nameList.add(names[ct]);
         ct++;
      }

      allPermutations(permList, nameList);
   }
}
```

<br>

# Resources

Textbook

  + [Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 11 Recursion
