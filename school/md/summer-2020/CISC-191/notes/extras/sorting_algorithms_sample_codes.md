---
title: Sorting Algorithms Java Sample Codes
author: Mark Lucernas
date: 2020-07-03
summary: Sorting Algorithms Java Sample Codes
---


# Sorting Algorithms Java Sample Codes

## Selection Sort

```java
public class SelectionSort {
   public static void selectionSort(int [] numbers) {
      int i;
      int j;
      int indexSmallest;
      int temp;      // Temporary variable for swap

      for (i = 0; i < numbers.length - 1; ++i) {

         // Find index of smallest remaining element
         indexSmallest = i;
         for (j = i + 1; j < numbers.length; ++j) {

            if (numbers[j] < numbers[indexSmallest]) {
               indexSmallest = j;
            }
         }

         // Swap numbers[i] and numbers[indexSmallest]
         temp = numbers[i];
         numbers[i] = numbers[indexSmallest];
         numbers[indexSmallest] = temp;
      }
   }

   public static void main(String [] args) {
      int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
      int i;

      System.out.print("UNSORTED: ");
      for (i = 0; i < numbers.length; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      /* initial call to selection sort with index */
      selectionSort(numbers);

      System.out.print("SORTED: ");
      for (i = 0; i < numbers.length; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();
   }
}
```

## Insertion Sort

```java
public class InsertionSort {
   public static void insertionSort(int [] numbers) {
      int i;
      int j;
      int temp;      // Temporary variable for swap

      for (i = 1; i < numbers.length; ++i) {
         j = i;
         // Insert numbers[i] into sorted part 
         // stopping once numbers[i] in correct position
         while (j > 0 && numbers[j] < numbers[j - 1]) {

            // Swap numbers[j] and numbers[j - 1]
            temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            --j;
         }
      }
   }

   public static void main(String [] args) {
      int [] numbers = {10, 2, 78, 4, 45, 32, 7, 11};
      int i;

      System.out.print("UNSORTED: ");
      for (i = 0; i < numbers.length; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      insertionSort(numbers);

      System.out.print("SORTED: ");
      for (i = 0; i < numbers.length; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();
   }
}
```


<br>

# Resources

  + [Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 17 Searching and algorithms
