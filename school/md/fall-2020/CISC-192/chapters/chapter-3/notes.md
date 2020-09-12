---
title: Chapter 3 Notes
subtitle: Expressions and Interactivity
author: Mark Lucernas
date: Sep 10, 2020
---


# Chapter 3: Expression and Interactivity

## Textbook

### 3.1 The `cin` Object

**CONCEPT:** `cin` can be used to read data typed at the keyboard.

> You can think of the word `cin` as meaning console **in**put. `#include
<iostream>` header file is required.

> Program 3-1

```cpp
// This program calculates and displays the area of a rectangle.
#include <iostream>
using namespace std;

int main()
{
  int length, width, area;

  cout << "This program calculates the area of a rectangle.\n";

  // Have the user input the rectangle's length and width
  cout << "What is the length of the rectangle? ";
  cin  >> length;
  cout >> "What is the width of the rectangle? ";
  cin  >> width;

  // Compute and display the area
  area = length * width;
  cout << "The area of the rectangle is " << area << endl;
  return 0;
}
```

The `>>` symbol is the _stream extraction operator_, which _extracts_
characters from the input stream so they can be used in the program.

#### Entering Multiple Values

> Program 3-3

```cpp
// This program calculates and displays the area of a rectangle.
#include <iostream>
using namespace std;

int main()
{
  int length, width, area;

  cout << "This program calculates the area of a rectangle.\n";

  // Have the user input the rectangle's length and width
  cout << "Enter the length and width of the rectangle ";
  cout << "separated by a space.\n";
  cin  >> length >> width;

  // Compute and display the area
  area = length * width;
  cout << "The area of the rectangle is " << area << endl;
  return 0;
}
```

> Program 3-4

```cpp
// This program demonstrates how cin can read multiple values
// of different data types.
#include <iostream>
using namespace std;

int main()
{
  int whole;
  double fractional;
  char letter;

  cout << "Enter an integer, a double, and a character: ";
  cin  >> whole >> fractional >> letter;

  cout << "whole: " << whole << endl;
  cout << "fraction: " << fractional << endl;
  cout << "letter: " << letter << endl;
  return 0;
}
```

![Figure 3.1](../../../../../files/fall-2020/CISC-192/chapter-3/3.1_figure-3.1.png)

### 3.2 Mathematical Expressions

**CONCEPT:** C++ allows you to construct complex mathematical expression using
multiple operators and grouping symbols

In Chapter 2 you were introduced to the basic mathematical operators, which are
used to build mathematical expression. An _expression_ is something that can be
evaluated to produce a single value.

Here are some additional assignment statements where the variable result is
being assigned the value of an expression.

```cpp
result = x;
result = 4;
result = 15 / 3;
result = 22 * number;
result = sizeof(int);
result = a + b + c;
```

> Program 3-5

```cpp
// This program displays the decimal value of a fraction.
#include <iostream>
using namespace std;

int main()
{
  double numerator, denominator;

  cout << "This program shows the decimal value of a fraction.\n";
  cin  >> numerator;
  cout << "Enter the denominator: ";
  cin  >> denominator;

  // Compute and display the decimal value
  cout << "The decimal value is " << (numerator / denominator) << endl;
  return 0;
}
```

#### Operator Precedence

**Table 3-1** Precedence of Arithmetic Operators (Highest to Lowest)

<center>

|             |        |                                                    |
|-------------|--------|----------------------------------------------------|
| `(  )`      |        | Expressions within parentheses are evaluated first |
| `-`         | unary  | Negation of a value, e.g., -6                      |
| `*   /   %` | binary | Multiplication, division, and modulus              |
| `+   -`     | binary | Addition and subtraction                           |

</center>

#### Associativity

**Table 3-3** Associativity of Arithmetic Operators

<center>

| Operator             | Associativity |
|----------------------|---------------|
| (unary negation) `-` | Right to left |
| `*   /   %`          | Left to right |
| `+   -`              | Left to right |

</center>

#### Grouping with parentheses

**Table 3-4** More Arithmetic Expression and Their Values

<center>

| Expression              | Value |
|-------------------------|-------|
| `(5 + 2) * 4`           | 28    |
| `10 / (5 - 3)`          | 5     |
| `8 + 12 * (6 - 2)`      | 56    |
| `(4 + 17) % 2 - 1`      | 0     |
| `(6 - 3) * (2 + 7) / 3` | 9     |

</center>

#### Converting Algebraic Expression to Programming Statements

**Table 3-5** Comparison of Algebraic and C++ Multiplication Expressions

<center>

| Algebraic Expression | Operation         | C++ Equivalent |
|----------------------|-------------------|----------------|
| 6B                   | 6 times B         | `6 * B`        |
| (3)(12)              | 3 times 12        | `3 * 12`       |
| 4xy                  | 4 times x times y | `4 * x  * y`   |

</center>

**Table 3-6** More Algebraic and C++ Expressions

<center>

| Agebraic Expression         | C++ Expression                  |
|-----------------------------|---------------------------------|
| $y = 3\frac{x}{2}$          | `y = x / 2 * 3;`                |
| $z = 3bc + 4$               | `z = 3 * b * c + 4;`            |
| $a = \frac{3x + 2}{4a - 1}$ | `a = (3 * x + 2) / (4 * a - 1)` |

</center>

**No Exponents Please!**. Use `pow()` function from the `cmath` C++ library
instead:

```cpp
area = pow(4.0, 2);
```

This mathematical expression can be interpreted as $4^{2}$

> Program 3-6

```cpp
// This program calculates the area of a circle. The formula for the
// area of a circle is PI times the radius squared. PI is 3.14159.
#include <iostream>
include <cmath>   // Needed for the pow function
using namespace std;

int main()
{
  double area, radius;

  cout << "This program calculates the area of a circle.\n";

  // Get the radius
  cout << "What is the radius of the circle? ";
  cin  >> radius;

  // Compute and display the area
  area = 3.14159 * pow(radius, 2);
  cout << "The area is " << area << endl;
  return 0;
}
```

### 3.3 Data Type Conversion and Type Casting

**CONCEPT:** Sometimes it is necessary to convert a value from one data type to
another. C++ provides ways to do this.

**Table 3-7** Data Type Ranking

<center>

|                          |
|--------------------------|
| `long double`            |
| `double`                 |
| `float`                  |
| `unsigned long long int` |
| `long long int`          |
| `unsigned long int`      |
| `long int`               |
| `unsigned int`           |
| `int`                    |

</center>

One exception to the ranking in Table 3-7 is when an int and a long int are the
same size. In that case, an unsigned int outranks a long int because it can
hold a higher value.

When C++ is working with an operator, it strives to convert the operands to the
same type. This implicit, or automatic, conversion is known as _type coercion_.
When a value is converted to a higher data type, it is said to be _promoted_. To
_demote_ a value means to convert it to a lower data type.

- **Rule 1:** `char`, `short`, and `unsigned short` values are automatically
  promoted to `int` values.

`char`, `short`, and `unsigned short` do not appear in Table 3-7 because anytime
values of these data types are used in a mathematical expression, thay are
automatically promoted to an int.

> The only exception to this rules is when an `unsigned short` holds a value
larger than can be held by an `int`. This can happen on systems where a `short`
is the same size as an `int`. In this case, the `unsigned short` is promoted to
`unsigned int`.

- **Rule 2:** When an operator works with two values of different data types,
  the lower-ranking value is promoted to the type of the higher-ranking value.

- **Rule 3:** When the final value of an expression is assigned to a variable,
  ti will be converted to the data type of that variable.

#### Type Casting

A _type cast expression_ lets you manually promote to demote a value. Its
general format is

```cpp
static_cast<DataType>(Value)
```

where _Value_ is a variable or literal value that you wish to convert and
_DataType_ is the data type you wish to convert it to.

```cpp
double number = 3.7;
int val;
val = static_cast<int>(number);
```

Type cast expression are useful in situations where C++ will not perform the
desired conversion automatically.

> Program 3-7

```cpp
// This program uses a type cast to avoid an integer division.
#include <iostream>
using namespace std;

int main()
{
  int    books,
         months;
  double booksPerMonth;

  // Get user inputs
  cout << "How many books do you plan to read? ";
  cin  >> books;
  cout << "How many months will it take you to read them? ";
  cin  >> months;

  // Compute and display books read per month
  booksPerMonth = static_cast<double>(books) / months;
  cout << "That is " << booksPerMonth << " books per month.\n";
  return 0;
}
```

> **WARNING!** To prevent the integer division from taking place, one of the
operands should be converted to a double prior to the division operation. This
forces C++ to automatically convert the value of the other operand to a double.





## Videos


<br>

# Resources

