---
title: Search Algorithms Sample Codes
author: Mark Lucernas
date: 2020-07-02
summary: Search Algorithms Sample Codes
---


# Search Algorithms Sample Codes

## Linear Search Algorithm

```java
import java.util.Scanner;
public class LinearSearch {
   public static int linearSearch(int [] numbers, int key) {
      int i;

      for (i = 0; i < numbers.length; ++i) {
         if (numbers[i] == key) {
            return i;
         }
      }

      return -1; /* not found */
   }

   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      int [] numbers = {2, 4, 7, 10, 11, 32, 45, 87};
      int i;
      int key;
      int keyIndex;

      System.out.print("NUMBERS: ");
      for (i = 0; i < numbers.length; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      System.out.print("Enter a value: ");
      key = scnr.nextInt();

      keyIndex = linearSearch(numbers, key);

      if (keyIndex == -1) {
         System.out.println(key + " was not found.");
      }
      else {
         System.out.println("Found " + key + " at index " + keyIndex + ".");
      }
   }
}
```


## Binary Search Algorithm

```java
import java.util.Scanner;

public class BinarySearch {
   public static int binarySearch(int [] numbers, int key) {
      int mid;
      int low;
      int high;

      low = 0;
      high = numbers.length - 1;

      while (high >= low) {
         mid = (high + low) / 2;
         if (numbers[mid] < key) {
            low = mid + 1;
         }
         else if (numbers[mid] > key) {
            high = mid - 1;
         }
         else {
            return mid;
         }
      }

      return -1; // not found
   }

   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      int [] numbers = {2, 4, 7, 10, 11, 32, 45, 87};
      int i;
      int key;
      int keyIndex;

      System.out.print("NUMBERS: ");
      for (i = 0; i < numbers.length; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      System.out.print("Enter a value: ");
      key = scnr.nextInt();

      keyIndex = binarySearch(numbers, key);

      if (keyIndex == -1) {
         System.out.println(key + " was not found.");
      }
      else {
         System.out.println("Found " + key + " at index " + keyIndex + ".");
      }
   }
}
```

<br>

# Resources

+ [🌎 Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 17 Searching and algorithms
