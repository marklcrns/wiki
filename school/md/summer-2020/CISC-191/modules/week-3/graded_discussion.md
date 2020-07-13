---
title: Week 3 Graded Discussion
author: Mark Lucernas
date: 2020-07-12
summary: Week 3 Graded Discussion entry
---


# Week 3 Graded Discussion

## Part 1: Recursion

**Provide 3 use cases where it makes sense to use recursion over iteration and
justify why. Consider memory usage, speed in terms of compute cycles, code
readability, etc. Here is a website that provides a list of recursion projects:
<https://www.geeksforgeeks.org/recursion-practice-problems-solutions/>.**

1. [Recursive program for prime number](https://www.geeksforgeeks.org/recursive-program-prime-number/)

I pick this one mainly because of its readability and elegant looking in
recursive from. It has 3 base case and a super simple recursive case.
Performance-wise, it's relatively slower than an iterative counterpart because
of repeated method calls which takes up extra space in that stack frame. But
because of readability and much simpler to solve in recursion (for me at least),
I find that this is a great use of recursion.

2. [Sum Triangle from array](https://www.geeksforgeeks.org/sum-triangle-from-array/)

Since this problem requires to create a new array of length N until array length
== 1, to create a triangle shape output with each element of each level is the
summation of the two numbers below it.  At first sight, this calls for a
recursive method because of a pyramid like stack (in this case, stack of arrays)
which is very conducive to when recursion starts returning values, which is way
easier to understand than creating multiple nested for/while loops. Plus, the
recursive solution is way too readable than its iterative counter part

3. [Recursive Tower of Hanoi using 4 pegs / rods](https://www.geeksforgeeks.org/recursive-tower-hanoi-using-4-pegs-rods/)

Obviously, Tower of Hanoi is a recursive problem. Again readability-wise, its
simpler in recursive form because you can focus more on solving the problem with
its recursive cases than worrying about looping over arbitrary amount of moves
in an arbitrary amount of pegs and rods. It would be difficult to create an
iterative form of the solution to this problem and isn't as readable as the
recursive solution. Recursion is almost always slower than iteration because of
extra method calls into the stack frame but the elegance and readability far
outweighs the marginal difference between two approach.

## Part 2: Big-O

**Please review time complexities of data structure operations and sorting
algorithms. These are taken from <https://www.bigocheatsheet.com/> . If you are
preparing for a job coding interview, I suggest you know all of these inside
out. However, for this discussion, please choose and compare:**

  1. **Two linear sorting algorithms.**
  2. **A tree sorting algorithm to a linear algorithm of the same worst time
     complexity.**

In your comparisons:

  1. **Explain the algorithm, using code snippets to help explain.**
  2. **Describe a good use case for each sorting algorithm.**
  3. **Describe a bad use case for each sorting algorithm.**


### Part 2.1: Insertion sort vs Selection sort

**Insertion Sort**

Insertion sort is an algorithm that loops through an array from beginning to end
in a linearly, with each iteration checks to see if the number at the current
index is in the right place going backwards. This algorithm makes sure that as
it goes forward, the numbers behind the current index are already sorted.

```java
public static void insertionSort(int [] numbers) {
  int i, j; // Loop counters
  int temp; // Temporary variable for swap

  for (i = 1; i < numbers.length; ++i) {
    j = i; // Catch up with the current index
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
```

**Selection Sort**

This algorithm, same as insertion sort, the treats the the array as two separate
parts, sorted and unsorted. Its also linear looping through each index of the
array from beginning till the end, making sure that all the numbers that are
passed by the outer loop are sorted. The difference is that selection finds the
smallest number every iteration then place it behind the current index location.

```java
public static void selectionSort(int [] numbers) {
  int i, j; // Loop counters
  int indexSmallest;
  int temp; // Temporary variable for swap

  for (i = 0; i < numbers.length - 1; ++i) {
    // Find index of smallest remaining element
    indexSmallest = i;
    for (j = i + 1; j < numbers.length; ++j) {
      // Make numbers[j] the current indexSmallest yet
      // if its smalle than the current
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
```

**Insertion sort vs. Selection sort**

Both algorithm has the same space complexity and almost the same time
complexity. Both has O(n^2) as worst case scenario, however Insertion sort has
better best case scenario of Ω(n) which is linear. Personally I think selection
sort is simpler than insertion sort because its like how we sort something out
in the real world, finding the smallest then setting them aside. But this
algorithm will regardless inefficiently search for the smallest numbers every
iteration even if it is already sorted. In contrast, however, insertion sort
solves this problem where it only iterate once for an already sorted array
because it compares adjacent indexes instead of looking for the smallest from
the whole array.


### Part 2.2: Tree sort vs a linear of the same worst time complexity.

**Tree Sort**

Tree sort algorithm uses Binary Search Tree. It creates nodes which recursively
caries 2 more nodes, left and right. The left of each node must be less than its
parent node and the right must be greater than the parent node. The sorting
comes in via the in-order traversal, where it would be traversing the tree
starting from the lowest leftmost children node, then up to the root node, then
finally traversing down to the lowest rightmost children node. If done right.
the left-right in-order traversal should produce an ascending array.

Node class for Tree sort algorithm

```java
class Node{
  int value;
  Node left;
  Node right;
  Node(int value){
    this.value = value;
    left = null;
    right = null;
  }
}
```

Tree class for sorting

```java
class Tree{
  Node node;
  Tree(int value){
    node = new Node(value);
  }
  public Node insert(Node node, int value){
    if(node == null){
      return new Node(value);
    }
    // Move to the left if passed value is
    // less than the current node
    if(value < node.value){
      node.left = insert(node.left, value);
    }
    // Move to the right if passed value is
    // greater than the current node
    else if(value > node.value){
      node.right = insert(node.right, value);
    }
    return node;
  }

  // For traversing in order
  public void inOrder(Node node){
    if(node != null){
      inOrder(node.left);
      System.out.print(node.value + " ");
      inOrder(node.right);
    }
  }
```

**Bubble Sort**

Bubble sort is similar to insertion sort in a way that it swaps adjacent
elements if the left is greater than right. the difference is that the outer
loop don't stop iterating after a swap has occurred and sorting all the elements
before the current index. It will continue until the end of the array, pushing
the largest element to the end of the array. Once that biggest element is at the
end of the array, that element is considered sorted and will no longer be
included in the next iterations. The loop will continue until there no more to
swap, which means the array is sorted.

```java
public static void bubbleSort(int[] numbers) {
  // Loop over numbers array
  for (int i = 0; i < numbers.length - 1; i++) {
    // Loop over numbers array, with each outer loop iteration will decrease
    // the length of the inner loop
    for (int j = 0; j < numbers.length - i - 1; j++) {
      // Swap numbers if numbers[j] > numbers[j + 1]
      if (numbers[j] > numbers[j +1]) {
        int temp = numbers[j];
        numbers[j] = numbers[j + 1];
        numbers[j + 1] = temp;
      }
    }
  }
}
```

**Tree sort vs. Bubble sort**

Although both these algorithms has the same worst time complexity, tree sort
will require more memory as it needs to create nodes for each elements. Also,
tree performs worst than bubble sort on its best run time, Ω(n log n) compared
to Ω(n) for bubble sort. Tree sort is one of the slowest sorting algorithm.

A good use case of a tree, is not its sorting capabilities, but searching
elements from a binary tree. Binary search tree creates nodes that is good for
storing data like a collection of person names, where each letter of the word is
its own node. Its a Trie data structure, which is a different story.

Bubble sort is probably the most straight forward of all sorting algorithm. Its
very easy to implement but its relatively slow compared to other algorithms. Its
great for small size arrays but gets terrible as arrays grow bigger.
