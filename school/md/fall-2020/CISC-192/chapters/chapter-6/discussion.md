---
title: Chapter 6 Discussion
author: Mark Lucernas
date: Nov 11, 2020
---


# Discussion

1. Pass by value: Does not modify the original value of the parameters.

Great function if you don't want to have the parameters be modified inside the
function, and instead make a copy available only within the scope of the
function.

2. Pass by pointer: Takes in pointer parameters then de-reference and modify the
   original value of the parameters.

Useful function for letting the function to modify the values of the original
variables that was passed in.

De-referencing a variable uses `*` sign before the variable name (header and
prototype of the function must us a reference param variables indicated by `&`
before the variable names).

3. Pass by reference: More convenient way to reference and de-reference the
   passed in parameters.

More convenient way of letting the function modify the original values of the
variables. Uses references indicated by `&` only when declaring

the header or prototype of the function. Thereafter, inside the function, param
variables can be used like a regular variable without the `*` sign.

4. Default parameter value: Takes in parameters with default values.

This is very useful if you want to have a default value for the function
parameters, that even passing nothing to the function, it would still work.

5. Ellipsis (requires <cstdarg> preprocessor directive) Takes in arbitrary
   amount of number vars and get the average of all number params.

Also very useful function if you want

to have an arbitrary amount of variables to pass in function.

```cpp
// Fibonacci Sequence program
// Gets the first two parameters and output its fibonacci numbers runCount times
#include <cstdarg>
#include <iostream>
using namespace std;

// Function prototypes
void passByValueFibSequence(int, int, int);
void passByPointerFibSequence(int*, int*, int*);
void passByReferenceFibSequence(int&, int&, int&);
void defaultParamValFibSequence(int=1, int=1, int=10);
void ellipsisGetAverage(int count, ...);

int main()
{
  int num1 = 1;
  int num2 = 1;
  int runCount = 5;

  cout << "Pass by value" << "\n\n";
  passByValueFibSequence(num1, num2, runCount);
  cout << "\n";

  cout << "Pass by pointer" << "\n\n";
  passByPointerFibSequence(&num1, &num2, &runCount);
  cout << "\n";

  cout << "Pass by reference" << "\n\n";
  passByReferenceFibSequence(num1, num2, runCount);
  cout << "\n";

  cout << "Default parameter values" << "\n\n";
  defaultParamValFibSequence();
  cout << "\n";

  cout << "(Optional) Ellipses" << "\n\n";
  ellipsisGetAverage(5, 91, 55, 37, 44, 7);
  cout << "\n";
}

// 1. Pass by value:
// Does not modify the original value of the parameters
void passByValueFibSequence(int num1, int num2, int runCount) {
  int tmpNum;
  for (int i = 0; i < runCount; i++) {
    cout << num1 << " + " << num2 << " = " << num1 + num2 << endl;
    // num1 becomes num2
    // num2 becomes the sum of original num1 and itself
    tmpNum = num1;          // Temporarily store num1 to keep its value
    num1 = num2;            // Assign num2 into num1
    num2 = tmpNum + num2;   // Assign the sum of original num1 (tmpNum) and itself
  }
}

// 2. Pass by pointer:
// Takes in pointer parameters then de-reference and modify
// the original value of the parameters
void passByPointerFibSequence(int *num1, int *num2, int *runCount) {
  int tmpNum;
  // '*' before the pointer var params to de-references and get the value its
  // pointing to
  for (int i = 0; i < *runCount; i++) {
    cout << *num1 << " + " << *num2 << " = " << *num1 + *num2 << endl;
    // num1 becomes num2
    // num2 becomes the sum of original num1 and itself
    tmpNum = *num1;           // Temporarily store num1 to keep its value
    *num1 = *num2;            // Assign num2 into num1
    *num2 = tmpNum + *num2;   // Assign the sum of original num1 (tmpNum) and itself
  }
}

// 3. Pass by reference:
// More convenient way to reference and de-reference the
// passed in parameters
void passByReferenceFibSequence(int &num1, int &num2, int &runCount) {
  int tmpNum;
  // Does not need "*" to deference since the params are not pointers.
  // They are references '&' or sort of a "link" to the original value
  for (int i = 0; i < runCount; i++) {
    cout << num1 << " + " << num2 << " = " << num1 + num2 << endl;
    // num1 becomes num2
    // num2 becomes the sum of original num1 and itself
    tmpNum = num1;          // Temporarily store num1 to keep its value
    num1 = num2;            // Assign num2 into num1
    num2 = tmpNum + num2;   // Assign the sum of original num1 (tmpNum) and itself
  }
}

// 4. Default parameter value:
// Takes in parameters with default values
void defaultParamValFibSequence(int num1, int num2, int runCount) {
  int tmpNum;
  // Does not need "*" to deference since the params are not pointers.
  // They are references '&' or sort of a "link" to the original value
  for (int i = 0; i < runCount; i++) {
    cout << num1 << " + " << num2 << " = " << num1 + num2 << endl;
    // num1 becomes num2
    // num2 becomes the sum of original num1 and itself
    tmpNum = num1;          // Temporarily store num1 to keep its value
    num1 = num2;            // Assign num2 into num1
    num2 = tmpNum + num2;   // Assign the sum of original num1 (tmpNum) and itself
  }
}

// 5. Ellipsis (requires <cstdarg> preprocessor directive)
// Takes in arbitrary amount of number vars and get the average of all number
// params
void ellipsisGetAverage(int count, ...) {
  // Access the ellipsis through a va_list
  va_list list;

  // Initialize the va_list using va_start
  // The first parameter is the list to initialize.
  // The second parameter is the last non-ellipsis parameter that holds the
  // count of arbitrary params
  va_start(list, count);

  double sum = 0; int tmpNum;
  for (int arg = 0; arg < count; arg++) {
    tmpNum = va_arg(list, int);
    sum += tmpNum;

    if (arg == count - 1) {       // Do not print the '+' sign on the last number
      cout << tmpNum << "\n\n";   // Instead, print new line after the last number
    } else {
      cout << tmpNum << " + ";    // Print current param value and a '+' sign
    }
  }

  cout << "Average: " << sum / count << endl;

  // Cleanup the va_list
  va_end(list);
}
```

**OUTPUT**

```
Pass by value

1 + 1 = 2
1 + 2 = 3
2 + 3 = 5
3 + 5 = 8
5 + 8 = 13

Pass by pointer

1 + 1 = 2
1 + 2 = 3
2 + 3 = 5
3 + 5 = 8
5 + 8 = 13

Pass by reference

8 + 13 = 21
13 + 21 = 34
21 + 34 = 55
34 + 55 = 89
55 + 89 = 144

Default parameter values

1 + 1 = 2
1 + 2 = 3
2 + 3 = 5
3 + 5 = 8
5 + 8 = 13
8 + 13 = 21
13 + 21 = 34
21 + 34 = 55
34 + 55 = 89
55 + 89 = 144

(Optional) Ellipses

91 + 55 + 37 + 44 + 7

Average: 46.8
```

