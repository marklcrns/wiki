---
title: Chapter 5 Notes
subtitle: Looping
author: Mark Lucernas
date: Oct 12, 2020
---


# Chapter 5: Looping

## 5.1 Introduction to Loops: The `while` Loop

**CONCEPT:** A loop is part of a program that repeats.

A loop is a control structure that causes a statement or group of statements to
repeat.  C++ has three looping control structures: the `while` loop, the
`do-while` loop, and the `for` loop.

### The `while` Loop

The while loop has two important parts: (1) an expression that is tested for a
true or false value and (2) a statement or block that is repeated as long as the
expression is true.

```cpp
while (condition)
{
  statement;
  statement;
  // Place as many statements
  // here as necessary
}
```

The first line, sometimes called the _loop header_, consists of the key word
`while` followed by a _condition_ to be tested enclosed in parentheses. The
condition is expressed by any expression that can be evaluated as true or false.
Next comes the _body_ of the loop. This contains one or more C++ _statements_.

> Program 5-1

```cpp
// This program demonstrates a simple while loop.
#include <iostream>
using namespace std;

int main()
{
  int count = 1;

  while (count <= 5)
  {
    cout << "Hello ";
    count = count + 1;
  }
  cout << "\nThat's all!\n";
  return 0;
}
```

> Program 5-1 Output

```
Hello Hello Hello Hello Hello
That's all!
```

### `while` Is a Pretest Loop

The `while` loop is a _pretest_ loop. This means it tests its condition before
each iteration.  If the test expression is false to start with, the loop will
never iterate. So if you want to be sure a `while` loop executes at least once,
you must initialize the relevant data in such a way that the test expression
starts out as true.

### Infinite Loops

If a loop does not have a way of stopping, it is called an infinite loop.
Infinite loops keep repeating until the program is interrupted. Here is an
example:

```cpp
int count = 1;
while (count <= 5)
{
  cout << "Hello ";
}
```

### Be Careful with Semicolons

```cpp
int count = 1;
while (count <= 5); // This semicolon is an ERROR!
{
  cout << "Hello ";
  count = count + 1;
}
```

### Don't Forget the Braces

```cpp
int count = 1;
// This loop is missing its braces!
while (count <= 5)
  cout << "Hello ";
  count = count + 1;
```

### Don't Confuse `=` with `==`

```cpp
while (remainder = 1) // Error: Notice the assignment.
{
  cout << "Enter a number: ";
  cin >> num;
  remainder = num % 2;
}
```

### Programming Style and the `while` Loop

It's possible to create loops that look like this:

```cpp
while (count <= 5) { cout << "Hello "; count = count + 1; }
```

**Avoid this style** of programming, however. The programming layout style you
should use with the `while` loop is similar to that of the `if` statement:

- If there is only one statement repeated by the loop, it should appear on the
  line after the `while` statement and be indented one level.
- If the loop repeats a block of statements, the block should begin on the line
  after the `while` statement, and each line inside the braces should be
  indented.

> Program 5-2

```cpp
// This program uses a loop to compute letter grades for multiple students.
#include <iostream>
using namespace std;

int main()
{
  // Create named constants to hold minimum scores for each letter grade
  const int MIN_A_SCORE = 90,
  MIN_B_SCORE = 80,
  MIN_C_SCORE = 70,
  MIN_D_SCORE = 60,
  MIN_POSSIBLE_SCORE = 0;

  int numStudents, // The total number of students
  student, // The current student being processed
  testScore; // Current student's numeric test score
  char grade; // Current student's letter grade
  bool goodScore = true;

  // Get the number of students
  cout << "How many students do you have grades for? ";
  cin  >> numStudents;

  // Initialize the loop control variable
  student = 1;

  // Loop once for each student
  while (student <= numStudents)
  {
    // Get this student's numeric score
    cout << "\nEnter the numeric test score for student #"
        << student << ": ",
    cin  >> testScore;

    // Determine the letter grade
    if (testScore >= MIN_A_SCORE)
      grade = 'A';
    else if (testScore >= MIN_B_SCORE)
      grade = 'B';
    else if (testScore >= MIN_C_SCORE)
      grade = 'C';
    else if (testScore >= MIN_D_SCORE)
      grade = 'D';
    else if (testScore >= MIN_POSSIBLE_SCORE)
      grade = 'F';
    else
      goodScore = false; // The score was below 0

    // Display the letter grade
    if (goodScore)
      cout << "The letter grade is " << grade << ".\n";
    else
      cout << "The score cannot be below zero. \n";

    // Set student to the next student
    student = student + 1;
  }
  return 0;
}
```

## Using the `while` Loop for Input Validation

**CONCEPT:** The while loop can be used to create input routines that repeat
until acceptable data is entered.

> Program 5-3

```cpp
// This program calculates the number of soccer teams a
// youth league can create from the number of available
// players. It performs input validation using while loops.
#include <iostream>
using namespace std;

int main()
{
  // Constants for minimum and maximum players per team
  const int MIN_PLAYERS = 9,
  MAX_PLAYERS = 15;

  // Variables
  int players, // Number of available players
  teamSize, // Number of desired players per team
  numTeams, // Number of teams
  leftOver; // Number of players left over

  // Get the number of players per team
  cout << "How many players do you wish per team?\n";
  cout << "(Enter a value in the range "
       << MIN_PLAYERS << " − " << MAX_PLAYERS << "): ";
  cin  >> teamSize;

  // Validate the input
  while (teamSize < MIN_PLAYERS || teamSize > MAX_PLAYERS)
  {
    cout << "\nTeam size should be "
         << MIN_PLAYERS << " to " << MAX_PLAYERS << " players.\n";
    cout << "How many players do you wish per team? ";
    cin  >> teamSize;
  }
  // Get and validate the number of players available
  cout << "\nHow many players are available? ";
  cin  >> players;

  while (players <= 0)
  {
    cout << "Please enter a positive number: ";
    cin  >> players;
  }
  // Calculate the number of teams and number of leftover players
  numTeams = players / teamSize;
  leftOver = players % teamSize;

  // Display the results
  cout << "\nThere will be " << numTeams << " teams with ";
  cout << leftOver << " players left over.\n";
  return 0;
}
```

## 5.3 The Increment and Decrement Operators

**CONCEPT:** C++ provides a pair of operators for incrementing and decrementing
variables.

To _increment_ a value means to increase it, and to _decrement_ a value means to
decrease it. In the example below, `qtyOrdered` is incremented by 10 and
`numSold` is decremented by 3.

```cpp
qtyOrdered = qtyOrdered + 10;
numSold = numSold − 3;
```

> Program 5-4

```cpp
// This program has two loops. The first displays the numbers
// from 1 up to 5. The second displays the numbers from 5 down to 1.
// The program uses the ++ and −− operators to change the value
// of the loop control variable.
#include <iostream>
using namespace std;

int main()
{
  int count = 1; // Initialize the loop control variable to 1
  while (count < 6)
  {
    cout << count << " ";
    count++;     // The ++ operator increments count
  }
  cout << endl;

  count = 5;     // Re-initialize the loop control variable to 5
  while (count > 0)
  {
    cout << count << " ";
    count--;     // The -- operator decrements count
  }
  cout << endl;
  return 0;
}
```

### Postfix and Prefix Modes

Our examples so far show the increment and decrement operators used in _postfix
mode_, which means the operator is placed after the variable. The operators also
work in _prefix mode_, where the operator is placed before the variable name.
The statements on lines 14 and 22 of Program 5-4 could have been written like
this:

```cpp
++countUp;
--countDown;
```

```cpp
// This program demonstrates the postfix and prefix
// modes of the increment and decrement operators.
#include <iostream>
using namespace std;

int main()
{
  int num = 4;

  // Illustrate postfix and prefix ++ operator
  cout << num << " ";    // Displays 4
  cout << num++ << " ";  // Displays 4, then adds 1 to num
  cout << num << " ";    // Displays 5
  cout << ++num << "\n"; // Adds 1 to num, then displays 6

                         // Illustrate postfix and prefix -- operator
  cout << num << " ";    // Displays 6
  cout << num-- << " ";  // Displays 6, then subtracts 1 from num
  cout << num << " ";    // Displays 5
  cout << --num << "\n"; // Subtracts 1 from num, then displays 4

  return 0;
}
```

### Using `++` and `--` in Mathematical Expressions

The increment and decrement operators can also be used on variables in
mathematical expressions. Consider the following program segment:

```cpp
a = 2;
b = 5;
c = a * b++;
cout << a << " " << b << " " << c;
```

variable `b` would be incremented before it was multiplied by `a`

You can pack a lot of action into a single statement using the increment and
decrement operators, but don't get too tricky with them. You might be tempted to
try something like the following, thinking that c will be assigned 11:

```cpp
a = 2;
b = 5;
c = ++(a * b); // Error!
```

### Using `++` and `--` in Relational Expressions

The ++ and −− operators may also be used in relational expressions. Just as in
arithmetic expressions, the difference between postfix and prefix mode is
critical. Consider the following program segment:

```cpp
x = 10;
if (x++ > 10)
  cout << "x is greater than 10.\n";
```

## 5.4 Counters

**CONCEPT:** A counter is a variable that is regularly incremented or
decremented each time a loop iterates.

> Program 5-6

```cpp
// This program uses a while loop to display
// the numbers 1–5 and their squares.
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{ int num = 1;

  cout << "Number Square\n";
  cout << "--------------\n";
  while (num <= 5)
  {
    cout << setw(4) << num << setw(7) << (num * num) << endl;
    num++; // Increment counter
  }
  return 0;
}
```

### Letting the User Control the Loop

```cpp
// This program displays integer numbers and their squares, beginning
// with one and ending with whatever number the user requests.
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
  int num, // Counter telling what number to square
  lastNum; // The final integer value to be squared

  // Get and validate the last number in the table
  cout << "This program will display a table of integer\n"
       << "numbers and their squares, starting with 1.\n"
       << "What should the last number be?\n"
       << "Enter an integer between 2 and 10: ";
  cin  >> lastNum;

  while ((lastNum < 2) || (lastNum > 10))
  {
    cout << "Please enter an integer between 2 and 10: ";
    cin >> lastNum;
  }
  // Display the table
  cout << "\nNumber Square\n";
  cout << "--------------\n";

  num = 1; // Set the counter to the starting value
  while (num <= lastNum)
  {
    cout << setw(4) << num << setw(7) << (num * num) << endl;
    num++; // Increment the counter
  }
  return 0;
}
```

## 5.5 Keeping a Running Total

**CONCEPT:** A running total is a sum of numbers that accumulates with each
iteration of a loop. The variable used to keep the running total is called an
accumulator.

> Program 5-8

```cpp
// This program takes daily sales figures for
// a 5-day sales week and calculates their total.
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
  const int NUM_DAYS = 5;
  int day;           // The day being processed
  double dailySales, // The sales amount for a single day
  totalSales = 0.0;  // Accumulator, initialized with 0

  // Get the sales for each day and accumulate a total
  // The loop control variable, day, is a counter
  day = 1;
  while (day <= NUM_DAYS)
  {
    cout << "Enter the sales for day " << day << ": ";
    cin  >> dailySales;
    totalSales = totalSales + dailySales; // Accumulate the total
    day++;                                // Increment the counter
  }
  // Display the total sales
  cout << fixed << showpoint << setprecision(2);
  cout << "\nTotal sales: $" << totalSales << endl;

  return 0;
}
```

## 5.6 Sentinels

**CONCEPT:** A sentinel is a special value that marks the end of a list of
values.

A _sentinel_ is a special value that cannot be mistaken for a member of the list
and that signals that there are no more values to be entered. The loop that
allows the data to be input continues iterating until the user enters the
sentinel. Then the loop terminates. This type of loop is called a
_sentinel-controlled loop_.

```cpp
// This program uses a sentinel-controlled loop. It calculates the total
// number of points a soccer team has earned so far this season. The user
// enters the points earned for each game, then enters −1 when finished.
#include <iostream>
using namespace std;

int main()
{
  int game = 1, // Game counter
  points,       // Holds number of points for a specific game
  total = 0;    // Accumulates total points for all games

  // Read in the points for game 1
  cout << "Enter the number of points your team earned for each\n";
  cout << "game so far this season. Then enter −1 when finished.\n\n";
  cout << "Enter the points for game " << game << ": ";
  cin  >> points;

  // Loop as long as the end sentinel has not yet been entered
  while (points != −1)
  { // Add point just read in to the accumulator
    total += points;

    // Enter the points for the next game
    game++;
    cout << "Enter the points for game " << game << ": ";
    cin  >> points;
  }
  // Display the total points
  cout << "\nThe team has earned " << total << "points so far. \n";
  return 0;
}
```

## 5.7 `do-while` Loop

**CONCEPT:** The `do-while` loop is a post-test loop, which means its expression
is tested after each iteration.

```cpp
do
{ statement;
  statement;
  // Place as many statements
  // here as necessary.
} while (condition);
```

Besides the way it looks, the difference between the `do-while` loop and the
`while` loop is that `do-while` is a post-test loop. This means it tests its
expression at the end of the loop, after each iteration is complete. Therefore a
`do-while` always performs at least one iteration, even if the test expression
is false at the start.

> Program 5-10

```cpp
// This program averages 3 test scores. It uses a do-while loop
// that allows the code to repeat as many times as the user wishes.
#include <iostream>
using namespace std;

int main()
{
  int score1, score2, score3; // Three test scores
  double average;             // Average test score
  char again;                 // Loop again? Y or N

  do
  { // Get three test scores
    cout << "\nEnter 3 scores and I will average them: ";
    cin >> score1 >> score2 >> score3;

    // Calculate and display the average
    average = (score1 + score2 + score3) / 3.0;
    cout << "The average is " << average << "\n\n";

    // Does the user want to average another set?
    cout << "Do you want to average another set? (Y/N) ";
    cin  >> again;
  } while (again == 'Y' || again == 'y');
  return 0;
}
```

### The `toupper` Function

This function is passed a character and returns the integer ASCII code of a
character. If the character it receives is a lowercase letter, it returns the
ASCII code of its uppercase equivalent. If the character it receives is not a
lowercase letter, it returns the ASCII code for the same character it was
passed.

If the value returned by `toupper` were printed, it is the ASCII code that would
print.  However, if it is assigned to a `char` variable, which is then printed,
the character itself will print. The following examples illustrate this.

```cpp
char letter1, letter2, letter3;
letter1 = toupper('?');
cout << letter1;      // This displays ?
letter2 = toupper('A');
cout << letter2;      // This displays A
letter3 = toupper('b');
cout << letter3;      // This displays B
cout << toupper('c'); // This displays 67, the ASCII code for C
```

### Using `do-while` with Menus

> Program 5-11

```cpp
// This menu-driven Health Club membership program carries out the
// appropriate actions based on the menu choice entered. A do-while loop
// allows the program to repeat until the user selects menu choice 4.
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
  // Constants for membership rates
  const double ADULT_RATE = 120.0;
  const double CHILD_RATE = 60.0;
  const double SENIOR_RATE = 100.0;

  int choice; // Menu choice
  int months; // Number of months
  double charges; // Monthly charges

  do
  { // Display the menu and get the user's choice
    cout << "\n Health Club Membership Menu\n\n";
    cout << "1. Standard Adult Membership\n";
    cout << "2. Child Membership\n";
    cout << "3. Senior Citizen Membership\n";
    cout << "4. Quit the Program\n\n";
    cout << "Enter your choice: ";
    cin  >> choice;

    // Validate the menu selection
    while ((choice < 1) || (choice > 4))
    {
      cout << "Please enter 1, 2, 3, or 4: ";
      cin >> choice;
    }
    // Process the user's choice
    if (choice != 4)
    { cout << "For how many months? ";
      cin >> months;

      // Compute charges based on user input
      switch (choice)
      {
        case 1: charges = months * ADULT_RATE;
        break;
        case 2: charges = months * CHILD_RATE;
        break;
        case 3: charges = months * SENIOR_RATE;
      }
      // Display the monthly charges
      cout << fixed << showpoint << setprecision(2);
      cout << "The total charges are $" << charges << endl;
    }
  } while (choice != 4); // Loop again if the user did not
  // select choice 4 to quit
  return 0;
}
```

## 5.8 The `for` Loop



<br>

# Resources

Textbook

- Starting Out with C++: Early Objects by Tony Gaddis, Judy Walters, Godfrey
  Muganda

