---
title: Chapter 9 Discussion
author: Mark Lucernas
date: Nov 18, 2020
---


# Discussion

- [📺 Big-O notation in 5 minutes -- The basics](https://www.youtube.com/watch?v=__vX2sjlpXU)
  [![Big-O notation in 5 minutes -- The basics](https://img.youtube.com/vi/__vX2sjlpXU/0.jpg)](https://www.youtube.com/watch?v=__vX2sjlpXU "Big-O notation in 5 minutes -- The basics")

**Please review time complexities of data structure operations and sorting
algorithms. These are taken from <https://www.bigocheatsheet.com/> . If you are
preparing for a job coding interview, I suggest you know all of these inside
out. However, for this discussion, please choose and compare:**

  1. **Two linear sorting algorithms**
  2. **Two tree sorting algorithms**

In your comparisons:

  1. **Explain the algorithm, using code snippets to help explain.**
  2. **Describe a good use case for each sorting algorithm.**
  3. **Describe a bad use case for each sorting algorithm.**

### Two linear sorting algorithms

**Insertion Sort**

Insertion sort is an algorithm that loops through an array from beginning to end
linearly, with each iteration checks to see if the number at the current index
is in the right place going backwards. This algorithm makes sure that as it goes
forward, the numbers behind the current index are already sorted.

```cpp
#include <iostream>
using namespace std;

void insertionSort(int [], int);
void printArrayValues(int [], unsigned int);

int main() {
  int arr[] = { 5, 4, 3, 1, 2 };
  int nArr = sizeof(arr) / sizeof(arr[0]);

  // Print pre-sorted array
  printArrayValues(arr, nArr);

  insertionSort(arr, nArr);

  // Print sorted array
  printArrayValues(arr, nArr);
}

void insertionSort(int numbers[], int size) {
  int i, j; // Loop counters
  int tmp;  // Temporary variable for swap

  for (i = 1; i < size; i++) {
    j = i; // Catch up with the current index
    // Insert numbers[i] into sorted part
    // stopping once numbers[i] in correct position
    while (j > 0 && numbers[j] < numbers[j - 1]) {
      // Swap numbers[j] and numbers[j - 1]
      tmp = numbers[j];
      numbers[j] = numbers[j - 1];
      numbers[j - 1] = tmp;
      j--;
    }
  }
}

// Prints all array elements in array param
void printArrayValues(int arr[], unsigned int arrSize) {
  for (unsigned int i = 0; i < arrSize; i++)
    cout << arr[i] << " ";
  cout << "\n";
}
```

OUTPUT

```
5 4 3 1 2
1 2 3 4 5
```

**Selection Sort**

This algorithm, same as insertion sort, the treats the the array as two separate
parts, sorted and unsorted. Its also linear looping through each index of the
array from beginning till the end, making sure that all the numbers that are
passed by the outer loop are sorted. The difference is that selection finds the
smallest number every iteration then place it behind the current index location.

```cpp
#include <iostream>
using namespace std;

void selectionSort(int [], int);
void printArrayValues(int [], unsigned int);

int main() {
  int arr[] = { 5, 4, 3, 1, 2 };
  int nArr = sizeof(arr) / sizeof(arr[0]);

  // Print pre-sorted array
  printArrayValues(arr, nArr);

  selectionSort(arr, nArr);

  // Print sorted array
  printArrayValues(arr, nArr);
}

void selectionSort(int numbers[], int size) {
  int i, j; // Loop counters
  int indexSmallest;
  int temp; // Temporary variable for swap

  for (i = 0; i < size - 1; ++i) {
    // Find index of smallest remaining element
    indexSmallest = i;
    for (j = i + 1; j < size; ++j) {
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

// Prints all array elements in array param
void printArrayValues(int arr[], unsigned int arrSize) {
  for (unsigned int i = 0; i < arrSize; i++)
    cout << arr[i] << " ";
  cout << "\n";
}
```

OUTPUT

```
5 4 3 1 2
1 2 3 4 5
```

**Insertion sort vs. Selection sort**

Both algorithm has the same space complexity and almost the same time
complexity. Both has O(n^2) as worst case scenario, however Insertion sort has
better best case scenario of Ω(n) which is linear. Personally I think selection
sort is simpler than insertion sort because its like how we sort something out
in the real world, finding the smallest then setting them aside. But this
algorithm will inefficiently search for the smallest numbers every iteration
even if it is already sorted. In contrast, however, insertion sort solves this
problem where it only iterate once for an already sorted array because it
compares adjacent indexes instead of looking for the smallest from the whole
array.

A good use case of insertion sort is when you want to implement an easy sorting
algorithm with a relatively faster time complexity. However, because this
algorithm is linear, as the size of the array gets bigger, it becomes less
efficient.

Selection sort however, is also a good algorithm for a quick and easy
implementation for small arrays. Selection sort will always have O(n^2) for
best, average and worst time complexity. Much more predictable but less
inefficient. Finally, Just like insertion sort, the bigger the array gets, the
more data processing this algorithm will require. Definitely appropriate for
sorting arrays with millions of elements.

### Two tree sorting algorithms

**Tree Sort**

Tree sort algorithm uses Binary Search Tree. It creates nodes which recursively
caries 2 more nodes, left and right. The left of each node must be less than its
parent node and the right must be greater than the parent node. The sorting
comes in via the in-order traversal, where it would be traversing the tree
starting from the lowest leftmost children node, then up to the root node, then
finally traversing down to the lowest rightmost children node. If done right.
the left-right in-order traversal should produce an ascending array.

```cpp
#include <iostream>
using namespace std;

struct Node {
  // Tree node scafolding
  int key;
  struct Node *left, *right;
};

/* A utility function to create a new BST Node */
struct Node *newNode(int item) {
  struct Node *temp = new Node;
  temp->key = item;                 // Set item as key of Node
  temp->left = temp->right = NULL;  // Initialize left and right to NULL
  return temp;
}

// -------------------- PROTOTYPES -------------------- //

void treeSort(int [], int);
void printArrayValues(int [], unsigned int);
void storeSorted(Node*, int [], int&);
Node* insert(Node*, int );

// -------------------- MAIN -------------------- //

int main() {
  int arr[] = { 5, 4, 3, 1, 2 };
  int nArr = sizeof(arr) / sizeof(arr[0]);

  // Print pre-sorted array
  printArrayValues(arr, nArr);

  treeSort(arr, nArr);

  // Print sorted array
  printArrayValues(arr, nArr);
}

// -------------------- FUNCTIONS -------------------- //

// Stores in-oder traversal of the BST in arr[]
void storeSorted(Node *root, int arr[], int &i) {
  if (root != NULL) {
    storeSorted(root->left, arr, i);
    arr[i++] = root->key;
    storeSorted(root->right, arr, i);
  }
}

// A utility function to insert a new Node with given key in BST
Node* insert(Node* node, int key) {
  // If the tree is empty, return a new Node
  if (node == NULL) return newNode(key);

  // Otherwise, recur down the tree
  if (key < node->key)
    node->left  = insert(node->left, key);
  else if (key > node->key)
    node->right = insert(node->right, key);

  // return the (unchanged) Node pointer
  return node;
}

// This function sorts arr[0 ... n-1] using Tree Sort
void treeSort(int arr[], int n) {
  struct Node *root = NULL;

  // Construct the BST
  root = insert(root, arr[0]);
  for (int i=1; i<n; i++)
    root = insert(root, arr[i]);

  // Store in-oder traversal of the BST in arr[]
  int i = 0;  // index loop counter
  storeSorted(root, arr, i);
}

// Prints all array elements in array param
void printArrayValues(int arr[], unsigned int arrSize) {
  for (unsigned int i = 0; i < arrSize; i++)
    cout << arr[i] << " ";
  cout << "\n";
}
```

OUTPUT

```
5 4 3 1 2
1 2 3 4 5
```

Ref:

- [📄 Tree Sort](https://www.geeksforgeeks.org/tree-sort/)

**AVL Tree Sort**

AVL Tree is a self-balancing Binary Search Tree where the difference between
heights of left and right subtrees cannot be more than one for all nodes.

Tree rotation is an operation that the structure without interfering with the
order of the elements on an AVL tree. wt moves one node up in the tree and one
node down. It is used to change the shape of the tree, and to decrease its
height by moving smaller subtrees down and larger subtrees up, resulting in
improved performance of many tree operations.

Because the AVL Tree implementation is too long for this discussion I will just
link really great implementation of an AVL Tree in C++:

- [📄 Implementation of AVL Tree in C++](https://www.tutorialspoint.com/cplusplus-program-to-implement-avl-tree)

**Tree sort vs. AVL Tree Sort**

Both the Tree sort and AVL Tree requires more memory to create nodes for the
elements. The difference is that the AVL tree does extra work on balancing the
height of the tree so that one side of the root node or a sub-node won't be too
"heavy" or too much sub-nodes to make tree traversal be more consistent. Tree
sort does not self-balance its nodes making tree traversal potentially
inconsistent as some tree nodes might have more sub-nodes than the others.

A good use case of Tree sort I can think of is when you are in need of a sorting
algorithm that also stores value in a data structure such as the Binary Search
Tree. Tree sort is just as worst in sorting as some of the sorting algorithms
such as the Quicksort but the tree consisting of nodes can also be used
retreiving data that is relatively faster than retrieving data from an array.
Furthermore, an AVL Tree sort which balances the height of its nodes, at the
cost of more data processing, will make for a more consistent and better time
complexity.

However, using both of this sorting algorithms without regards for retrieving
values from the data structure would be a waste of memory. There are other
faster sorting algorithms such as Mergesort or Heapsort that can perform better
than Tree Sort and AVL Tree Sort.


<br>

# Resources

- [📺 Big-O notation in 5 minutes -- The basics](https://www.youtube.com/watch?v=__vX2sjlpXU)
- [📄 Tree Sort](https://www.geeksforgeeks.org/tree-sort/)
- [📄 Implementation of AVL Tree in C++](https://www.tutorialspoint.com/cplusplus-program-to-implement-avl-tree)

