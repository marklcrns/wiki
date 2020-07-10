---
title: Generics and Collections
author: Mark Lucernas
date: 2020-07-09
summary: CISC 191 Week 4 Generics and Collections notes
---


# Generics and Collections

  - [*Generics](file:../../../../../../../files/summer-2020/CISC-191/week-4/generics.ppt)
  - [`Java intro to Generics and Collections Framework using LinkedList](https://www.youtube.com/watch?v=0OXZuxe_TVk)
  - [`Java Concurrent Collections: Introduction](https://www.youtube.com/watch?v=8GviG6nSSTA)


## Generics

### Comparable Interface: Sorting an ArrayList

Sorting the elements of an ArrayList into ascending or descending order is a
common programming task. Java's **Collections** class provides static methods
that operate on various types of lists such as an ArrayList. The sort() method
sorts collections into ascending order provided that the elements within the
collection implement the Comparable interface (i.e., the elements are also of
the type Comparable). For example, each of the primitive wrapper classes (e.g.,
Integer, Double, etc.) implements the **Comparable** interface, which declares
the compareTo() method. Classes implementing the Comparable interface must
define a custom implementation of the compareTo() method. A programmer may use
sort() to sort an ArrayList in which the elements implement the Comparable
interface (e.g., Integer). The programmer must import java.util.Collections to
use the sort() method. The following example demonstrates the use of sort() to
sort an ArrayList of Integer objects.

> Collections' sort() method operates on lists of Integer objects.

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ArraySorter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int NUM_ELEMENTS = 5;                             // Number of items in array
      ArrayList<Integer> userInts = new ArrayList<Integer>(); // Array of user defined values
      int i;                                                  // Loop index

      // Prompt user for input, add values to array
      System.out.println("Enter " + NUM_ELEMENTS + " numbers...");
      for (i = 1; i <= NUM_ELEMENTS; ++i) {
         System.out.print(i + ": ");
         userInts.add(scnr.nextInt());
      }

      // Sort ArrayList of Comparable elements
      Collections.sort(userInts);

      // Print sorted array
      System.out.print("\nSorted numbers: ");
      for (i = 0; i < NUM_ELEMENTS; ++i) {
         System.out.print(userInts.get(i) + " ");
      }
      System.out.println("");
   }
}
```


<br>

# Resources

  - [*Generics](file:../../../../../../../files/summer-2020/CISC-191/week-4/generics.ppt)

