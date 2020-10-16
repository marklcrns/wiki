---
title: Chapter 2 Notes
subtitle: Introduction to C++
author: Mark Lucernas
date: Aug 24, 2020
---


# Chapter 2 Introduction to C++

## Textbook

### 2.1 The Parts of a C++ Program

```cpp
// A simple C++ program
#include <iostream>
using namespace std;

int main()
{
  cout << "Programming is great fun!";
  return 0;
}
```

The `//` marks the beginning of a _comment_. The compiler ignores everything
from the double-slash to the end of the line.

When a line begins with a `#` it indicates it is a **preprocessor directive**.
The preprocessor read your program before it is compiled and only executes those
line beginning with a `#` symbol.

The `#include` directive causes the preprocessor to include the contents of
another file, known as a _header_ file, in the program. The word that is
enclosed in brackets, `<iostream>`, is the name of the header file that is to be
included.

> The `iostream` file contains code that allows a C++ program to display output
on the screen and read input from the keyboard.

C++ uses _namespaces_ to organize the names of program entities. The statement
`using namespace std;` declares that the program will be accessing entities
whose names are part of the namespace called `std`. The program needs access to
the `std` namespace because every name created by the `iostream` file is part of
the namespace.

> Table 2-1 Special Characters

<center>

| Character | Name                                | Description                                                                             |
|-----------|-------------------------------------|-----------------------------------------------------------------------------------------|
| `//`      | Double slash                        | Marks the beginning of a comment                                                        |
| `#`       | Pound sign                          | Marks the beginning of a preprocessor directive.                                        |
| `< >`     | Opening and closing brackets        | Encloses a filename when used with the `#include` directive.                            |
| `(  )`    | Opening and closing parentheses     | Used in naming a function, as in `int main()`.                                          |
| `{  }`    | Opening and closing braces          | Encloses a group  of statements, such as the contents of a function.                    |
| `" "`     | Opening and closing quotation marks | Encloses a string of characters, such as a message that is to be printed on the screen. |
| `;`       | Semicolon                           | Marks the end of a complete programming statement.                                      |

</center>

> **NOTE:** Every C++ program must contain a `main` function

### 2.2 The `cout` Object

The simplest type of screen output that a program can display is _console
output_, which is merely plain text.

```cpp
cout << "Programming is great fun!";
```

When the `<<` symbol is used this way, it is called the _stream-insertion
operator_. The item immediately to the right of the operator is _inserted_ into
the output stream that is sent to `cout` to be displayed on the screen.

```cpp
// A well-adjusted printing program
#inlcude <iostream>
using namespace std;

int main()
{
  cout << "The following items were top sellers" << endl;
  cout << "during the month of June:\n";
  cout << "Computer games\nCoffee";
  cout << "\nAspirin\n";
  return 0;
}
```

> `endl` is the same as the newline _escape sequence_ `\n`

> Table 2-2 Common Escape Sequences

| Escape Sequence | Name           | Description                                                                      |
|-----------------|----------------|----------------------------------------------------------------------------------|
| `\n`            | Newline        | Causes the cursor to go to the next line for subsequent printing.                |
| `\t`            | Horizontal tab | Causes the cursor to skip over to the next tab stop.                             |
| `\a`            | Alarm          | Causes the computer to beep.                                                     |
| `\b`            | Backspace      | Causes the cursor to back up (i.e., move left) one position.                     |
| `\r`            | Return         | Causes the cursor to go to the beginning of the current line, not the next line. |
| `\\`            | Backslash      | Causes a backslash to be printed.                                                |
| `\' `           | Single quote   | Causes a single quotation mark to be printed.                                    |
| `\"`            | Double quote   | Causes a double quotation mark to be printed.                                    |

### 2.4 Variables and the Assignment Statement

> Program 2-7

```cpp
// This program has a variable.
#include <iostream>
using namespace std;

int main()
{
  int number;

  number = 5;
  cout << "The value of number is " << number << endl;

  number = 7;
  cout << "Now the value of number is " << number << endl;

  return 0;
}
```

```cpp
int number;
```

This is called a _variable definition_. It tells the compiler the variable's
name and the type of data it will hold.

```cpp
number =  5
```

This is an _assignment statement_, and the `=` sign is called the _assignment
operator_. This operator copies the value on its right `5` into the variable
named on its left `number`.

### 2.5 Literals

A literal is a piece of data written directly into a program's code. One of the
most common uses of literals is to assign a value to a variable.

```cpp
number = 5;
```

### 2.6 Identifiers

An _identifier_ is a programmer-defined name that represents some element of a
program. Variable names are examples of identifiers. You may choose your own
variable names in C++, as long as you do not use any of the C++ key words.

> Table 2-4 The C++ Key Words

|          |              |           |                  |          |
|----------|--------------|-----------|------------------|----------|
| alignas  | const        | for       | private          | throw    |
| alignof  | constexpr    | friend    | protected        | true     |
| and      | const_cast   | goto      | public           | try      |
| and_eq   | continue     | if        | register         | typedef  |
| asm      | decltype     | inline    | reinterpret_cast | typeid   |
| auto     | default      | int       | return           | typename |
| bitand   | delete       | long      | short            | union    |
| bitor    | do           | mutable   | signed           | unsigned |
| bool     | double       | namespace | sizeof           | using    |
| break    | dynamic_cast | new       | static           | virtual  |
| case     | else         | noexcept  | static_assert    | void     |
| catch    | enum         | not       | static_cast      | volatile |
| char     | explicit     | not_eq    | struct           | wchar_t  |
| char16_t | export       | nullptr   | switch           | while    |
| char32_t | extern       | operator  | template         | xor      |
| class    | false        | or        | this             | xor_eq   |
| compl    | float        | or_eq     | thread_local     |          |

> Table 2-6 Integer Data Types

| Data Type                | Typical Size | Typical Range                                           |
|--------------------------|--------------|---------------------------------------------------------|
| `short int`              | 2 bytes      | -32,768 to +32,767                                      |
| `unsigned short int`     | 2 bytes      | 0 to +65,535                                            |
| `int`                    | 4 bytes      | -2,147,483,648 to +2,147,483,647                        |
| `unsigned int`           | 4 bytes      | 0 to 4,294,967,295                                      |
| `long int`               | 4 bytes      | -2,147,483,648 to +2,147,483,647                        |
| `unsigned long int`      | 4 bytes      | 0 to 4,294,967,295                                      |
| `long long int`          | 8 bytes      | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |
| `unsigned long long int` | 8 bytes      | 0 to +8,446,744,073,709,551,615                         |

> Program 2-9

```cpp
// This program has variables of several of the integer types.
#include <iostream>
using namespace std;

int main()
{
  int checking;
  unsigned int miles;
  long diameter;

  checking = -20;
  miles = 4276;
  diameter = 100000;

  cout << "We have made a journey of " << miles << " miles.\n";
  cout << "Our checking account balance is " << checking << " dollars.\n";
  cout << "The Milky Way galaxy is about " << diameter;
  cout << "light years in diameter.\n";
  return 0;
}
```

> Program 2-10

```cpp
// This program defines three variables in the same statement.
// They are given initial values at the time they are defined.
#include <iostream>
using namespace std;

int main()
{
  int floors = 15,
  rooms = 300,
  suites = 30;

  cout << "The Grande Hotel has " << floors << " floors\n";
  cout << "with " << rooms << " rooms and " << suites;
  cout << " suites.\n";
  return 0;
}
```

#### Hexadecimal and Octal Literals (enrichment)

Programmers commonly express values in numbering systems other than decimal (or
base 10). Hexadecimal (base 16) and octal (base 8) are popular because they
make certain programming tasks more convenient than decimal numbers do.

By default, C++ assumes that all integer literals are expressed in decimal. If
you want to indicate that a literal value is a hexadecimal number, you must
place 0x in front of it. (This is zero-x, not oh-x.) Here is how the
hexadecimal number F4 would be expressed in C++:

```
0xF4
```

Octal numbers must be preceded by a 0 (zero, not oh). For example, the octal 31
would be written

```
031
```

### 2.8 Floating-Point Data Types

In programming terms, these are called floating-point numbers.

Internally, floating-point numbers are stored in a manner similar to
_scientific notation_. Take the number 47,281.97. In scientific notation this
number is 4.728197 * 104. (104 is equal to 10,000, and 4.728197 * 10,000 is
47,281.97.) The first part of the number, 4.728197, is called the _mantissa_.
The mantissa is multiplied by a power of 10.

Computers typically use _E notation_ to represent floating-point values. In E
notation, the number 47,281.97 would be `4.728197E4`. The part of the number
before the E is the mantissa, and the part after the E is the power of 10.

| Data Type             | Key Word    | Size     | Range                                            | Significant Digits |
|-----------------------|-------------|----------|--------------------------------------------------|--------------------|
| Single precision      | float       | 4 bytes  | Numbers between $\pm 3.4E-38$ and $\pm 3.4E38$   | 7                  |
| Double precision      | double      | 8 bytes  | Numbers between $\pm 1.7E-308$ and $\pm 1.7E308$ | 16                 |
| Long double precision | long double | 8 bytes* | Numbers between $\pm 1.7E-308$ and $\pm 1.7E308$ | 16                 |

> *Some compilers use more than 8 bytes for a long double. This allows a greater
range.

You will notice there are no unsigned floating-point data types. On all
machines, variables of the float, double, and long double data type can store
both positive and negative numbers.

> Program 2-11

```cpp
// This program uses two floating-point data types, float and double.
#include <iostream>
using namespace std;

int main()
{
  float distance = 1.496E8; // in kilometers
  double mass = 1.989E30; // in kilograms

  cout << "The Sun is " << distance << " kilometers away.\n";
  cout << "The Sun\'s mass is " << mass << " kilograms.\n";
  return 0;
}
```

#### Floating-Point Literals

All of the following floating-point literals are equivalent:

```
1.496E8
1.496e8
1.496E+8
1.496e+8
149600000.0
```

Floating-point literals are normally stored in memory as doubles. If you need
one to be stored as a float, you can append the letter `F` or `f` to the end of
it.  For example, the following literals would be stored as float numbers:

```
1.2F
45.907f
```

Lf you want to force a value to be stored as a long double, append an `L` to it,
as shown here:

```
1034.56L
```

#### Assigning Floating-Point Values to Integer Variables

When a floating-point value is assigned to an integer variable, the fractional
part of the value (the part after the decimal point) is discarded.

```cpp
int number;
number = 7.8;  // Assigns 7 to number
```

### 2.9 The `char` Data Type

The simplest character data type is the char data type. A variable of this type
can hold only a single character and, on most systems, uses just one byte of
memory.

> Program 2-12

```cpp
// This program uses a char variable and several character literals.
#include <iostream>
using namespace std;

int main()
{
  char letter;

  letter = 'A';
  cout << letter << endl;

  letter = 'B';
  cout << letter << endl;
  return 0;
}
```

> Program 2-13

```cpp
// This program demonstrates that characters are actually
// stored internally by their ASCII integer value.
#include <iostream>
using namespace std;

int main()
{
  char letter;

  letter = 65; // 65 is the ASCII code for the character A
  cout << letter << endl;

  letter = 66; // 66 is the ASCII code for the character B
  cout << letter << endl;
  return 0;
}
```

#### The Difference Between Character Literals and String Literals

Because a string literal can be virtually any length, there must be some way for
the program to know how long it is. In C++ this is done by appending an extra
byte to its end and storing the number 0 in it. This is called the _null
terminator_ or _null character_ `\0` and marks the end of the string.

The null terminator is another example of something that sits quietly in the
background. It doesn't print on the screen when you display a string, but
nevertheless, it is there silently doing its job.

> Some character literals may be confused as a string literal like the `'\n'`
which is a character literal that only represents one character.

### 2.10 The C++ `string` Class

#### Using the `string` Class

The first step in using the string class is to `#include` the string header
file.  This is accomplished with the following preprocessor directive:

```cpp
#include <string>
```

> Program 2-15

```cpp
// This program demonstrates the string class.
#include <iostream>
#include <string> // Required for the string class.
using namespace std;

int main()
{
  string movieTitle;

  movieTitle = "Wheels of Fury";
  cout << "My favorite movie is " << movieTitle << endl;
  return 0;
}
```

### 2.11 The `bool` Data Type

Boolean variables are set to either `true` or `false`.

### 2.12 Determining the Size of A Data Type

The `sizeof` operator may be used to determine the size of a data type on any
system.

> Program 2-17

```cpp
// This program displays the size of various data types.
#include <iostream>
using namespace std;

int main()
{
  double apple;

  cout << "The size of a short integer is " << sizeof(short)
       << " bytes.\n";

  cout << "The size of a long integer is " << sizeof(long)
       << " bytes.\n"

  cout << "An apple can be eaten in " << sizeof(apple)
       << " bytes!\n"
}
```

### 2.13 More on Variable Assignments and Initialization

A variable can be assigned a value at the time it is defined. This is called
variable initialization.

```cpp
string month = "February";
```

#### Declaring Variables with the `auto` Key Word

```cpp
auto amount = 100;        // int
auto stockCode = 'D';     // char
auto customerNum = 459L;  // long
auto interestRate = 12.0; // double
```

### 2.14 Scope

A variable's scope is the part of the program that has access to the variable.

```cpp
// This program can't find its variable.
#include <iostream>
using namespace std;

int main()
{
  cout << value;      // ERROR! value has not been defined yet!

  int value = 100;
  return 0;
}
```

### 2.15 Arithmetic Operators

| Operator | Meaning        | Example                     |
|----------|----------------|-----------------------------|
| `+`      | Addition       | `total = cost + tax;`       |
| `-`      | Subtraction    | `cost = total - tax;`       |
| `*`      | Multiplication | `tax = cost * rate;`        |
| `/`      | Division       | `salePrice = original / 2;` |
| `%`      | Modulus        | `remainder = value % 3;`    |

### 2.16 Comments

#### Single Line Comments

```cpp
// this is a sample of single line comment
```

#### Multi-line Comments

```cpp
/* This is a sample of a
   multi-line comment */
```


## Video Lectures

- [🎬 CISC 192 Section 2.1 Parts of a C++ Program](https://www.youtube.com/watch?v=4aA7KjUv06Y)
- [🎬 CISC 192 Section 2.2 The cout Object Part 1](https://www.youtube.com/watch?v=1kR48PDLK9M)
- [🎬 CISC 192 Section 2.2 The cout Object Part 2](https://www.youtube.com/watch?v=f4fD-P1YNok)
- [🎬 CISC 192 Section 2.3 The include Directive](https://www.youtube.com/watch?v=vovxUk6aebY)
- [🎬 Sections 2.4 - 2.5 Variables and the Assignment Statement and Literals](https://www.youtube.com/watch?v=-xmhYxptGBY)
- [🎬 CISC 192 Section 2.6 Identifiers](https://www.youtube.com/watch?v=U75E1wa0wME)
- [🎬 CISC 192 Section 2.7 Integer Data Types](https://www.youtube.com/watch?v=I_y_HZQhDEs)
- [🎬 CISC 192 Section 2.8 Floating Point Data Types](https://www.youtube.com/watch?v=jD2J29uo99Q)
- [🎬 CISC 192 Section 2.9 The char Data Type](https://www.youtube.com/watch?v=c-1XpkSpoow)
- [🎬 CISC 192 Section 2.10 The C++ string Class](https://www.youtube.com/watch?v=PxLFI9R2VB0)
- [🎬 CISC 192 Section 2.11 The bool Data Type](https://www.youtube.com/watch?v=NB_SdFxj_os)
- [🎬 CISC 192 Section 2.12 Determining the Size of a Data Type](https://www.youtube.com/watch?v=iMjmdOAhgPs)
- [🎬 CISC 2.13 More on Variable Assignments and Initialization](https://www.youtube.com/watch?v=kO-api2o4A4)
- [🎬 CISC 192 Section 2.14 Scope](https://www.youtube.com/watch?v=1tw6qUUsnZ8)
- [🎬 CISC 192 Setion 2.14 Comments](https://www.youtube.com/watch?v=dxsaZJYAkys)
- [🎬 CISC 192 Section 2.15 Named Constants using const Keyword](https://www.youtube.com/watch?v=IkAc8g5AKaY)
- [🎬 CISC 192 Section 2.16 Programming Style](https://www.youtube.com/watch?v=8rDCKXbXFeA)

<br>

# Resources

- [🎬 CISC 192 Section 2.1 Parts of a C++ Program](https://www.youtube.com/watch?v=4aA7KjUv06Y)
- [🎬 CISC 192 Section 2.2 The cout Object Part 1](https://www.youtube.com/watch?v=1kR48PDLK9M)
- [🎬 CISC 192 Section 2.2 The cout Object Part 2](https://www.youtube.com/watch?v=f4fD-P1YNok)
- [🎬 CISC 192 Section 2.3 The include Directive](https://www.youtube.com/watch?v=vovxUk6aebY)
- [🎬 Sections 2.4 - 2.5 Variables and the Assignment Statement and Literals](https://www.youtube.com/watch?v=-xmhYxptGBY)
- [🎬 CISC 192 Section 2.6 Identifiers](https://www.youtube.com/watch?v=U75E1wa0wME)
- [🎬 CISC 192 Section 2.7 Integer Data Types](https://www.youtube.com/watch?v=I_y_HZQhDEs)
- [🎬 CISC 192 Section 2.8 Floating Point Data Types](https://www.youtube.com/watch?v=jD2J29uo99Q)
- [🎬 CISC 192 Section 2.9 The char Data Type](https://www.youtube.com/watch?v=c-1XpkSpoow)
- [🎬 CISC 192 Section 2.10 The C++ string Class](https://www.youtube.com/watch?v=PxLFI9R2VB0)
- [🎬 CISC 192 Section 2.11 The bool Data Type](https://www.youtube.com/watch?v=NB_SdFxj_os)
- [🎬 CISC 192 Section 2.12 Determining the Size of a Data Type](https://www.youtube.com/watch?v=iMjmdOAhgPs)
- [🎬 CISC 2.13 More on Variable Assignments and Initialization](https://www.youtube.com/watch?v=kO-api2o4A4)
- [🎬 CISC 192 Section 2.14 Scope](https://www.youtube.com/watch?v=1tw6qUUsnZ8)
- [🎬 CISC 192 Setion 2.14 Comments](https://www.youtube.com/watch?v=dxsaZJYAkys)
- [🎬 CISC 192 Section 2.15 Named Constants using const Keyword](https://www.youtube.com/watch?v=IkAc8g5AKaY)
- [🎬 CISC 192 Section 2.16 Programming Style](https://www.youtube.com/watch?v=8rDCKXbXFeA)

Textbook

- Starting Out with C++: Early Objects by Tony Gaddis, Judy Walters, Godfrey
  Muganda

