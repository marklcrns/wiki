---
title: Chapter 6 Discussion
author: Mark Lucernas
date: Nov 11, 2020
---


# Discussion

1. What happens when you reference an array index that is out of bounds? For example,

```cpp
int score[5] = {90,80,88,76,58};
cout << score[5];
```

- The program will still compile and run but the out of bounds array reference
  would access unexpected value, given that array values are contiguous, array
  reference greater than the array size would likely access value next to the
  array in memory or garbage value.

2. What happens when you assign an array to a new variable? Explain what are the
   contents of both variables after the assignment.

int oldScores[5] = {90,80,88,76,58};
int newScores[5];
newScores = oldScores;

- The program would produce an error since you CAN'T assign array variables into
  another array because array variables are just mere reference to a specific
  address in memory and does not contain the value(s) assigned to it. Therefore,
  the example above `newScores = oldScores` does not assign `oldScores` to
  `newScores` the values of `oldScores`, but rather its memory address which is
  invalid variable assignment operation and would produce compilation error.

3. What are ways you could pass arrays to functions? Please provide use cases
   for each way, justifying why the method is better.

```cpp
#include <iostream>
using namespace std;

// Prototypes
void foo(int* arr);        // Reference to a memory address containing int value
void bar(int arr[]);       // Reference to array variable
void baz(int arr[5]);      // Reference to array variable with fixed size
void qux(const int arr[]); // Reference to array variable with immutable param

void printArrayValues(int [], unsigned int);

int main()
{
  int numArr1[] = {1, 2, 3, 4, 5};
  int numArr2[] = {1, 2, 3, 4, 5};
  int numArrSized1[5] = {1, 2, 3, 4, 5};
  int numArrSized2[5] = {1, 2, 3, 4, 5};

  cout << "Pass by pointer" << endl;
  foo(numArr1);
  printArrayValues(numArr1, 5);

  cout << "Pass by unsized array" << endl;
  bar(numArr2);
  printArrayValues(numArr2, 5);

  cout << "Pass by sized array" << endl;
  baz(numArrSized1);
  printArrayValues(numArrSized1, 5);

  cout << "Pass by const array" << endl;
  qux(numArrSized2);
  printArrayValues(numArrSized2, 5);
}

// They don't make much difference since array params all turn into a pointers.
// So `int arr[]` will transform into `int* arr`.
// Pass by array or array pointers can be used to modify the original value of
// the array.
void foo(int* arr)    { arr[0] = 99; }  // Pass by pointer
void bar(int arr[])   { arr[0] = 99; }  // Pass by unsized array. Turns into a pointer
void baz(int arr[5])  { arr[0] = 99; }  // Pass by fixed size array. Turns into a pointer

// However, const arrays, while still decay into a pointer, the value(s) its
// pointing to cannot be reassigned. This is great if you don't want your array
// to be modified inside a function.
void qux(const int arr[]) {
  // arr[0] = 99;     // ERROR! const param cannot be mutated

  int temp = arr[0];  // Alternative way to access and modify
  temp = 99;
}

///////////////////////////////// IGNORE ///////////////////////////////////////

// Neatly prints array values
void printArrayValues(int arr[], unsigned int arrSize) {
  cout << "Array Values: ";
  for (int i = 0; i < arrSize; i++)
    cout << arr[i] << " ";
  cout << "\n\n";
}
```

4. What are 3 differences and similarities between arrays and vectors? Provide
   one use case for each and justify why the data structure fits better than the
   other. Please use code to illustrate.

Similarities

- Both array and vector holds a sequence of values, or elements
- Stores elements in a continuous (side by side) memory locations.
- Both use `[]` operator to index an element in an array or vector.

Differences

- Vectors do not have to declare the number of elements that a vector will have.
  While arrays also do not require the array size when being declared, arrays
  automatically set the size when initialized which cannot be resized.
- Vectors can increase its size automatically when adding elements using its
  member functions such as `push_back()`. Arrays size are fixed.
- Vectors can report the number of elements they contain with `capacity()`
  member function.

```cpp
#include <iostream>
#include <vector>
using namespace std;

int main()
{
  /** Use case #1
   * Vectors are usefull if you are having an arbitrary amount of elements to
   * store in a data structure. e.g. Online shopping cart.
   *
   * Arrays, however fixed in size, is also useful if you know how many elements
   * to store and would not want to add additional elemnts. e.g. Chess pieces.
   */

  vector<int> vec1; // Does not require size when declaring
  int arr1[5];      // Requires to declare array size

  //////////////////////////////////////////////////////////////////////////////

  /** Use case #2
   * Vectors can add (push) and remove (pop) any elements stored in a vector.
   * e.g. Add to cart functionality.
   *
   * Arrays cannot add or remove an element once initialized. In order to add
   * another element, you need to copy all elements of an array into another a
   * new array with size of the old array plus new elements (or minus the
   * elements to remove).
   */
  vector<char> vec2 {1, 2, 3, 4, 5};
  int arr2[5] = {1, 2, 3, 4, 5};

  vec2 = {1, 2, 3, 4, 5};
  vec2.push_back(6); // Appends 6 into vec2 elements

  arr2[0] = 1;
  arr2[1] = 2;
  arr2[2] = 3;
  arr2[3] = 4;
  arr2[4] = 5;
  arr2[5] = 6; // OUT OF BOUNDS!

  //////////////////////////////////////////////////////////////////////////////

  /** Use case #3
   * Vectors has various useful member functions that reports or modify elements
   * stored in a vector such as capacity(), push_back(), pop_back(), etc.
   *
   * Arrays do not have the functionality vectors therefore arrays are more
   * lightweight. Additionally, there are workarounds that programmers can
   * implement to have the same functionality as vectors have.
   */
  vector<char> vec3 {1, 2, 3, 4, 5};
  int arr3[5] = {1, 2, 3, 4, 5};

  int vectorSize = vec3.capacity(); // Returns number of elements in vec3;
  cout << "Vector size: " + to_string(vectorSize) << endl;

  // total size of arr3 elements divided by
  // the size of arr3 first element
  // = number of array elements
  int arrSize = sizeof(arr3) / sizeof(arr3[0]); // Workaround to get the size of an array
  cout << "Array Size: " + to_string(arrSize) << endl;
}
```

OUTPUT

```
Vector size: 5
Array Size: 5
```

5. Lets say you have an array with integers 0-9, and you want to remove items
   greater than 5. What is a good way to do this? Please use code to illustrate.

```cpp
#include <iostream>
using namespace std;

void printArrayValues(int [], unsigned int);

int main()
{
  int arr1[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // Test 1: Array sorted
  int arr2[10] = {0, 5, 1, 6, 4, 7, 9, 1, 8, 0}; // Test 2: Array unsorted
  int arr3[10] = {0, 3, 2, 3, 4, 5, 5, 1, 8, 0}; // Test 3: Array unsorted with duplicates
  int j; // Counter for elements greater than 5
  int k; // Counter for new array elements

  // Size of elements
  // divided by
  // the size of an element
  // = Total number of elements
  int arr1Size = sizeof(arr1) / sizeof(arr1[0]);
  int arr2Size = sizeof(arr2) / sizeof(arr2[0]);
  int arr3Size = sizeof(arr3) / sizeof(arr3[0]);

  /////////////////////// TEST 1
  cout << "TEST 1" << endl;

  // Count all elements greater than 5
  for (int i = 0; i < arr1Size; i++)
    if (arr1[i] > 5)
      j++;

  // Initialize new array
  int newArr1[arr1Size - j];
  int newArr1Size = sizeof(newArr1) / sizeof(newArr1[0]);
  // Assign elements less than or equal to 5 into new array
  for (int i = 0; i < arr1Size; i++) {
    if (arr1[i] <= 5) {
      newArr1[k] = arr1[i];
      k++;
    }
  }
  cout << "Old array 1 Values: ";
  printArrayValues(arr1, arr1Size);
  cout << "New array 1 Values: ";
  printArrayValues(newArr1, newArr1Size);

  cout << endl;

  /////////////////////// TEST 2
  j = 0; k = 0;
  cout << "TEST 2" << endl;

  // Count all elements greater than 5
  for (int i = 0; i < arr2Size; i++)
    if (arr2[i] > 5)
      j++;

  // Initialize new array
  int newArr2[arr2Size - j];
  int newArr2Size = sizeof(newArr2) / sizeof(newArr2[0]);
  // Assign elements less than or equal to 5 into new array
  for (int i = 0; i < arr2Size; i++) {
    if (arr2[i] <= 5) {
      newArr2[k] = arr2[i];
      k++;
    }
  }
  cout << "Old array 2 Values: ";
  printArrayValues(arr2, arr2Size);
  cout << "New array 2 Values: ";
  printArrayValues(newArr2, newArr2Size);

  cout << endl;

  /////////////////////// TEST 3
  j = 0; k = 0;
  cout << "TEST 3" << endl;

  // Count all elements greater than 5
  for (int i = 0; i < arr3Size; i++)
    if (arr3[i] > 5)
      j++;

  // Initialize new array
  int newArr3[arr3Size - j];
  int newArr3Size = sizeof(newArr3) / sizeof(newArr3[0]);
  // Assign elements less than or equal to 5 into new array
  for (int i = 0; i < arr3Size; i++) {
    if (arr3[i] <= 5) {
      newArr3[k] = arr3[i];
      k++;
    }
  }
  cout << "Old array 3 Values: ";
  printArrayValues(arr3, arr3Size);
  cout << "New array 3 Values: ";
  printArrayValues(newArr3, newArr3Size);
}

// Prints all array elements in array param
void printArrayValues(int arr[], unsigned int arrSize) {
  for (int i = 0; i < arrSize; i++)
    cout << arr[i] << " ";
  cout << "\n";
}
```

OUTPUT

```
TEST 1
Old array 1 Values: 0 1 2 3 4 5 6 7 8 9
New array 1 Values: 0 1 2 3 4 5

TEST 2
Old array 2 Values: 0 5 1 6 4 7 9 1 8 0
New array 2 Values: 0 5 1 4 1 0

TEST 3
Old array 3 Values: 0 3 2 3 4 5 5 1 8 0
New array 3 Values: 0 3 2 3 4 5 5 1 0
```
