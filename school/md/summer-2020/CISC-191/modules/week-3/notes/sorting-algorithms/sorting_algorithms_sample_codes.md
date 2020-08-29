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

## Quicksort

```java
public class QuickSort {
  public static int partition(int [] numbers, int i, int k) {
    int l;
    int h;
    int midpoint;
    int pivot;
    int temp;
    boolean done;

    /* Pick middle element as pivot */
    midpoint = i + (k - i) / 2;
    pivot = numbers[midpoint];

    done = false;
    l = i;
    h = k;

    while (!done) {
      /* Increment l while numbers[l] < pivot */
      while (numbers[l] < pivot) {
        ++l;
      }

      /* Decrement h while pivot < numbers[h] */
      while (pivot < numbers[h]) {
        --h;
      }

      /* If there are zero or one items remaining,
         all numbers are partitioned. Return h */
      if (l >= h) {
        done = true;
      }
      else {
        /* Swap numbers[l] and numbers[h],
           update l and h */
        temp = numbers[l];
        numbers[l] = numbers[h];
        numbers[h] = temp;

        ++l;
        --h;
      }
    }

    return h;
  }

  public static void quicksort(int [] numbers, int i, int k) {
    int j;

    /* Base case: If there are 1 or zero entries to sort,
       partition is already sorted */
    if (i >= k) {
      return;
    }

    /* Partition the data within the array. Value j returned
       from partitioning is location of last item in low partition. */
    j = partition(numbers, i, k);

    /* Recursively sort low partition (i to j) and
       high partition (j + 1 to k) */
    quicksort(numbers, i, j);
    quicksort(numbers, j + 1, k);
  }

  public static void main(String [] args) {
    int [] numbers = {10, 2, 78, 4, 45, 32, 7, 11};
    int i;

    System.out.print("UNSORTED: ");
    for (i = 0; i < numbers.length; ++i) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    /* Initial call to quicksort */
    quicksort(numbers, 0, numbers.length - 1);

    System.out.print("SORTED: ");
    for (i = 0; i < numbers.length; ++i) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();
  }
}
```

## Merge Sort

```java
public class MergeSort {
  public static void merge(int [] numbers, int i, int j, int k) {
    int mergedSize = k - i + 1;       // Size of merged partition
    int mergedNumbers [] = new int[mergedSize]; // Temporary array for merged numbers
    int mergePos;                     // Position to insert merged number
    int leftPos;                      // Position of elements in left partition
    int rightPos;                     // Position of elements in right partition

    mergePos = 0;
    leftPos = i;                      // Initialize left partition position
    rightPos = j + 1;                 // Initialize right partition position

    // Add smallest element from left or right partition to merged numbers
    while (leftPos <= j && rightPos <= k) {
      if (numbers[leftPos] < numbers[rightPos]) {
        mergedNumbers[mergePos] = numbers[leftPos];
        ++leftPos;
      } 
      else {
        mergedNumbers[mergePos] = numbers[rightPos];
        ++rightPos;
      }
      ++mergePos;
    }

    // If left partition is not empty, add remaining elements to merged numbers
    while (leftPos <= j) {
      mergedNumbers[mergePos] = numbers[leftPos];
      ++leftPos;
      ++mergePos;
    }

    // If right partition is not empty, add remaining elements to merged numbers
    while (rightPos <= k) {
      mergedNumbers[mergePos] = numbers[rightPos];
      ++rightPos;
      ++mergePos;
    }

    // Copy merge number back to numbers
    for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
      numbers[i + mergePos] = mergedNumbers[mergePos];
    }
  }

  public static void mergeSort(int [] numbers, int i, int k) {
    int j;

    if (i < k) {
      j = (i + k) / 2;  // Find the midpoint in the partition

      // Recursively sort left and right partitions
      mergeSort(numbers, i, j);
      mergeSort(numbers, j + 1, k);

      // Merge left and right partition in sorted order
      merge(numbers, i, j, k);
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

    /* initial call to selection sort with index */
    mergeSort(numbers, 0, numbers.length - 1);

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

+ [🌎 Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 17 Searching and Sorting Algorithms
