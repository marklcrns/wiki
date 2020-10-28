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

In general, there are two categories of loops: conditional loops and
count-controlled loops. A _conditional loop_ executes as long as a particular
condition exists. For example, an input validation loop executes as long as the
input value is invalid. When you write a conditional loop, you have no way of
knowing the number of times it will iterate.

Sometimes you know the exact number of iterations that a loop must perform. A
loop that repeats a specific number of times is known as a _count-controlled
loop_. For example, if a loop asks the user to enter the sales amounts for each
month in the year, it will iterate twelve times. In essence, the loop counts to
twelve and asks the user to enter a sales amount each time it makes a count. A
count-controlled loop must possess three elements:

1. It must initialize a counter variable to a starting value.
2. It must test the counter variable by comparing it to a final value. When the
   counter variable reaches its final value, the loop terminates.
3. It must update the counter variable during each iteration. This is usually
   done by incrementing the variable.

Here is the format of the for loop.

```cpp
for (initialization; test; update)
{
  statement;
  statement;
  // Place as many statements
  // here as necessary.
}
```

The first line of the `for` loop is the _loop header_. After the key word for,
there are three expressions inside the parentheses, separated by semicolons.
(Notice that there is no semicolon after the third expression.) The first
expression is the _initialization expression_. It is typically used to
initialize a counter to its starting value. This is the first action performed
by the loop, and it is only done once.

The second expression is the test expression. It tests a condition in the same
way the test expression in the `while` and `do-while` loops do, and controls the
execution of the loop. As long as this condition is true, the body of the `for`
loop will repeat. Like the while loop, the `for` loop is a pretest loop, so it
evaluates the test expression before each iteration.

The third expression is the _update_ expression. It executes at the end of each
iteration, before the test expression is tested again. Typically, this is a
statement that increments the loop’s counter variable.

Here is an example of a simple for loop that prints “Hello” five times:

```cpp
for (count = 1; count <= 5; count++)
  cout << "Hello" << endl;
```

> Program 5-12

```cpp
// This program uses a for loop to display the numbers 1–5
// and their squares.
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{ int num;

  cout << "Number Square\n";
  cout << "--------------\n";

  for (num = 1; num <= 5; num++)
    cout << setw(4) << num << setw(7) << (num * num) << endl;
  return 0;
}
```

### The `for` Loop Is a Pretest Loop

Because the `for` loop tests its test expression before it performs an
iteration, it is possible to write a `for` loop in such a way that it will never
iterate. Here is an example:

```cpp
for (count = 11; count <= 10; count++)
  cout << "Hello" << endl;
```

### Avoid Modifying the Counter Variable in the Body of the `for` Loop

Although it is okay to use the counter variable inside the body of the loop, as
we did in Program 5-12, be careful not to place a statement there that modifies
it. Modifications of the counter variable should only take place in the update
expression, which is automatically executed at the end of each iteration. If a
statement in the body of the loop also modifies the counter variable, the loop
will probably not terminate when you expect it to. The following loop, for
example, increments x twice for each iteration:

```cpp
for (x = 1; x <= 10; x++)
{
  cout << x << endl;
  x++; // Wrong!
}
```

### Other Forms of the Update Expression

You are not limited to incrementing the loop control variable by just 1 in the
update expression. Here is a loop that displays all the even numbers from 2
through 100 by adding 2 to its counter:

```cpp
for (num = 2; num <= 100; num += 2)
  cout << num << endl;
```

And here is a loop that counts backward from 10 down to 0:

```cpp
for (num = 10; num >= 0; num––)
  cout << num << endl;
```

### Defining a Variable in the for Loop's Initialization Expression

Not only may the counter variable be initialized in the initialization expression, it may
be defined there as well. The following code shows an example. This is a modified
version of the loop in Program 5-12.

```cpp
for (int num = 1; num <= 5; num++)
  cout << setw(4) << num << setw(7) << (num * num) << endl;
```

**If the counter variable is used only in the loop, it is considered good
programming practice to define it in the loop header**. This makes the
variable’s purpose clearer. However, when a variable is defined in the
initialization expression of a `for` loop, the scope of the variable is limited
to the loop.  This means you cannot access the variable in statements outside
the loop. For example, the following program segment will not compile because
the last `cout` statement cannot access the variable count.

```cpp
for (int count = 1; count <= 10; count++)
  cout << count << endl;

cout << "count is now " << count << endl; // ERROR!
```

### Creating a User-Controlled for Loop

In Program 5-7 we allowed the user to control how many times a while loop should
iterate. This can also be done with a `for` loop by having the user enter the
final value for the counter variable, as illustrated in the following program
segment.

```cpp
// Get the final counter value
cout << "How many times should the loop execute? ";
cin >> finalValue;

for (int num = 1; num <= finalValue; num++)
{
  // Statements in the loop body go here.
}
```

### Using Multiple Statements in the Initialization and Update Expressions

It is possible to execute more than one statement in the initialization
expression and the update expression. When using multiple statements in either
of these expressions, simply separate the statements with commas.

```cpp
for (int x = 1, y = 1; x <= 5; x++)
{
  cout << x << " plus " << y << " equals " << (x + y) << endl;
}
```

The loop’s initialization expression is `int x = 1, y = 1`

We can further modify the loop to execute two statements in the update
expression. Here is an example:

```cpp
for (int x = 1, y = 1; x <= 5; x++, y++)
{
  cout << x << " plus " << y << " equals " << (x + y) << endl;
}
```

### Omitting the `for` Loop's Expressions or Loop Body

Although it is generally considered bad programming style to do so, one or more
of the for loop's expressions, or even its loop body, may be omitted.

```cpp
int num = 1;
for ( ; num <= maxValue; num++)
  cout << num << " " << (num * num) << endl;
```

The update expression may be omitted if it is being performed elsewhere in the
loop or if none is needed. Although this type of code is not recommended, the
following `for` loop works just like a `while` loop:

```cpp
int num = 1;
for ( ; num <= maxValue; )
{ cout << num << " " << (num * num) << endl;
  num++;
}
```

It is also possible, though not recommended, to write a `for` loop that has no
formal body. In this case, all the work of the loop is done by statements in the
loop header. Here is an example that displays the numbers from 1 to 10. The
combined increment operation and `cout` statement in the update expression
perform the work of each iteration.

```cpp
for (number = 1; number <= 10; cout << number++);
```

## 5.9 Deciding Which Loop to Use

**CONCEP:** Although most repetitive algorithms can be written with any of the
three types of loops, each works best in different situations.

Each of C++'s three loops is ideal to use in specific situations. Here's a short
summary of when each loop should be used.

### The `while` Loop

The while loop is a pretest loop. It is ideal in situations where you do not
want the loop to iterate if the test condition is false from the beginning. For
example, validating input that has been read and reading lists of data
terminated by a sentinel value are good applications of the while loop.

```cpp
cout << "This program finds the square of any integer.\n";
cout << "\nEnter an integer, or −99 to quit: ";
cin  >> num;
while (num != −99)
{ cout << num << " squared is " << pow(num, 2.0) << endl;
  cout << "\nEnter an integer, or −99 to quit ";
  cin  >> num;
}
```

### The `do-while` Loop

The do-while loop is a post-test loop. It is ideal in situations where you always want
the loop to iterate at least once. The do-while loop is a good choice for repeating a
menu or for asking users if they want to repeat a set of actions.

```cpp
cout << "This program finds the square of any integer.\n";
do
{ cout << "\nEnter an integer: ";
  cin  >> num;
  cout << num << " squared is " << pow(num, 2.0) << endl;
  cout << "Do you want to square another number? (Y/N) ";
  cin  >> doAgain;
} while (doAgain == 'Y' || doAgain == 'y');
```

### The `for` Loop

The for loop is a pretest loop with built-in expressions for initializing, testing, and
updating a counter variable. The for loop is ideal in situations where the exact number
of iterations is known.

```cpp
cout << "This program finds the squares of the integers "
     << "from 1 to 8.\n\n";
for (num = 1; num <= 8; num++)
{
  cout << num << " squared is " << pow(num, 2.0) << endl;
}
```

## 5.10 Nested Loops

**CONCEPT:** A loop that is inside another loop is called _nested loop_

It is also possible to nest one loop inside another loop. The first loop is
called the _outer loop_. The one nested inside it is called the _inner loop_.
This is illustrated by the following two while loops. Notice how the inner loop
must be completely contained within the outer one.

```cpp
while (condition1)   // Beginning of the outer loop
{ ---
  while (condition2) // Beginning of the inner loop
  { ---
    ---
  }                  // End of the inner loop
}                    // End of the outer loop
```

> Program 5-13

```cpp
// This program averages test scores. It asks the user for the
// number of students and the number of test scores per student.
#include <iostream>
using namespace std;

int main()
{
  int numStudents, // Number of students
  numTests; // Number of tests per student
  double average; // Average test score for a student

  // Get the number of students
  cout << "This program averages test scores.\n";
  cout << "How many students are there? ";
  cin  >> numStudents;

  // Get the number of test scores per student
  cout << "How many test scores does each student have? ";
  cin  >> numTests;
  cout << endl;

  // Read each student's scores and compute their average
  for (int snum = 1; snum <= numStudents; snum++) // Outer loop
  { double total = 0.0; // Initialize accumulator

    for (int test = 1; test <= numTests; test++) // Inner loop
    { int score;

      // Read a score and add it to the accumulator
      cout << "Enter score " << test << " for ";
      cout << "student " << snum << ": ";
      cin >> score;
      total += score;
    }                                           // End inner loop
    // Compute and display the student's average
    average = total / numTests;
    cout << "The average score for student " << snum;
    cout << " is " << average << "\n\n";
  }                                             // End outer loop
  return 0;
}
```

## 5.11 Breaking Out of a Loop

**CONCEPT:** C++ provides ways to break out of a loop or out of a loop iteration
early.

Here is an example of a loop with a `break` statement. The `while` loop in the
following program segment appears to execute 10 times, but the `break` statement
causes it to stop after the fifth iteration.

```cpp
int count = 1;
while (count <= 10)
{
  cout << count << endl;
  count++;
  if (count == 6)
  break;
}
```

> Program 5-14

```cpp
// This program is supposed to find the square root of 5 numbers
// entered by the user. However, if a negative number is entered
// an error message displays and a break statement is used to
// stop the loop early.
#include <iostream>
#include <cmath>
using namespace std;

int main()
{
  double number;

  cout << "Enter 5 positive numbers separated by spaces and \n"
       << "I will find their square roots: ";

  for (int count = 1; count <= 5; count++)
  {
    cin >> number;
    if (number >= 0.0)
    { cout << "\nThe square root of " << number << " is "
      << sqrt(number);
    }
    else
    { cout << "\n\n" << number << " is negative. "
      << "I cannot find the square root \n"
      << "of a negative number. The program is terminating.\n";
      break;
    }
  }
  return 0;
}
```

### Using `break` in a Nested Loop

In a nested loop, the `break` statement only interrupts the loop it is placed
in.  The following program segment displays three rows of asterisks on the
screen.  The outer loop controls the number of rows, and the inner loop controls
the number of asterisks in each row. The inner loop is designed to display
twenty asterisks, but the `break` statement stops it during the eleventh
iteration.

```cpp
for (row = 0; row < 3; row++)
{ for (star = 0; star < 20; star++)
  { cout << '*';
    if (star == 10)
      break;
  }
  cout << endl;
}
```

### The `continue` Statement

When continue is encountered, all the statements in the body of the loop that
appear after it are ignored, and the loop prepares for the next iteration. In a
`while` loop, this means the program jumps to the test expression at the top of
the loop. If the expression is still true, the next iteration begins. Otherwise,
the loop is exited. In a `do-while` loop, the program jumps to the test
expression at the bottom of the loop, which determines if the next iteration
will begin. In a `for` loop, `continue` causes the update expression to be
executed, and then the test expression to be evaluated. The following program
segment demonstrates the use of `continue` in a `while` loop:

```cpp
int testVal = 0;
while (testVal < 10)
{
  testVal++;
  if (testVal) == 4
    continue; // Terminate this iteration of the loop
  cout << testVal << " ";
}
```

## 5.12 Using Files for Data Storage

**CONCEPT:** When a program needs to save data for later use, it writes the data
in a file. The data can be read from the file at a later time.

The programs you have written so far require the user to reenter data each time
the program runs because data kept in variables is stored in RAM and disappears
once the program stops running. If a program is to retain data between the times
it runs, it must have a way of saving it. Data written into a file, which is
usually stored on a computer's disk, will remain there after the program stops
running. That data can then be retrieved and used at a later time.

- **Word processors**: Word processing programs are used to write letters,
  memos, reports, and other documents. The documents are then saved in files so
  they can be viewed, edited, and printed at a later time.
- **Spreadsheets**: Spreadsheet programs are used to work with numerical data.
  Numbers and mathematical formulas can be inserted into the rows and columns of
  the spreadsheet. The spreadsheet can then be saved in a file for later use.
- **Image editors**: Image editing programs are used to draw graphics and edit
  images, such as the ones that you take with a digital camera. The images that
  you create or edit with an image editor are saved in files.
- **Business operations software**: Programs used in daily business operations
  rely extensively on files. Payroll programs keep employee data in files,
  inventory programs keep data about a company's products in files, accounting
  systems keep data about a company's financial operations in files, and so on.
- **Web browsers**: Sometimes when you visit a Web page, the browser stores a
  small file known as a _cookie_ on your computer. Cookies typically contain
  information about the browsing session, such as the contents of a shopping
  cart.
- **Games**: Many computer games keep data stored in files. For example, some
  games keep a list of player names with their scores stored in a file. These
  games typically display the players' names in the order of their scores, from
  highest to lowest. Some games also allow you to save your current game status
  in a file so you can quit the game and then resume playing it later without
  having to start from the beginning.

Programmers usually refer to the process of saving data in a file as _writing
data_ to the file. When a piece of data is written to a file, it is copied from
a variable in RAM to the file. This is illustrated in Figure 5-8. The term
_output file_ is used to describe a file that data is written to. It is called
an output file because the program stores output in it.

The process of retrieving data from a file is known as _reading data_ from the
file. When a piece of data is read from a file, it is copied from the file into
a variable in RAM. See Figure 5-9 for an illustration. The term _input_ file is
used to describe a file that data is read from. It is called an input file
because the program gets input from the file.

### Types of Files

In general, there are two types of files: text and binary. A _text file_
contains data that has been encoded as text, using a scheme such ASCII or
Unicode. Even if the file contains numbers, those numbers are stored in the file
as a series of characters. As a result, the file may be opened and viewed in a
text editor such as Notepad. A _binary file_ contains data that has not been
converted to text. As a consequence, you cannot view the contents of a binary
file with a text editor.

### File Access Methods

There are two general ways to access data stored in a file: sequential access
and direct access. When you work with a _sequential access file_, you access
data from the beginning of the file to the end of the file. If you want to first
read a piece of data that is stored at the very end of the file, you have to
first read all of the data that comes before it. You cannot jump directly to the
desired data. This is similar to the way cassette tape players work. If you want
to listen to the last song on a cassette tape, you have to either fastforward
over all of the songs that come before it or listen to them. There is no way to
jump directly to a specific song.

When you work with a _random access file_ (which is also known as a _direct
access file_), you can directly access any piece of data in the file without
reading the data that comes before it. This is similar to the way a CD player or
an MP3 player works. You can jump directly to any song that you want to listen
to.

### Filenames and File Stream Objects

Files on a disk are identified by a _filename_. For example, when you create a
document with a word processor and then save the document in a file, you have to
specify a filename. When you use a utility such as Windows Explorer to examine
the contents of your disk, you see a list of filenames.

Each operating system has its own rules for naming files. Many systems,
including Windows, support the use of _filename extensions_, which are short
sequences of characters that appear at the end of a filename preceded by a
period. e.g, `.jpg`, `.txt`, and `.doc`.

In order for a program to work with a file on the computer's disk, the program
must create a file stream object in memory. A _file stream_ object is an object
that is associated with a specific file and provides a way for the program to
work with that file. It is called a "stream" object because it enables streams
of data to be copied from memory to a file and from a file to memory.

### Setting Up a Program for File Input/Output

Five steps must be taken when a file is used by a program:

1. Include the header file needed to perform file input/output.
2. Define a file stream object.
3. Open the file.
4. Use the file.
5. Close the file.

Just as you need to include the iostream file in your program to use cin and
cout, you need another header file to use files. The `fstream` file contains all
the declarations necessary for file operations. You can include it with the
following statement:

```cpp
#include <fstream>
```


The `fstream` header file defines the data types `ofstream`, `ifstream`, and
`fstream`. Before a C++ program can work with a file, it must define an object
of one of these data types. The object will be "linked" with an actual file on
the computer's disk, and the operations that may be performed on the file depend
on which of these three data types you pick for the file stream object.



<center>

| File Stream Data Type | Description                                                                                                                                                 |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `ofstream`            | This stands for output file stream and is pronounced ‘o’ ‘f’ stream. An object of this data type can be used to create a file and write data to it.         |
| `ifstream`            | This stands for input file stream and is pronounced ‘i’ ‘f’ stream. An object of this data type can be used to open an existing file and read data from it. |
| `fstream`             | This stands for file stream and is pronounced ‘f’ stream. An object of this data type can be used to open files for reading, writing, or both.              |

</center>

### Creating a File Stream Object and Opening a File

Before data can be written to or read from a file, two things must happen:

- A file stream object must be created.
- The file must be opened and linked to the file stream object.

The following code shows an example of opening a file for input (reading).

```cpp
ifstream inputFile;
inputFile.open("customers.txt");
```

The following code shows an example of opening a file for output (writing).

```cpp
ofstream outputFile;
outputFile.open("employees.txt");
```

Sometimes, when opening a file, you will need to specify its full path as well
as its name. For example, on a Windows system the following statement opens the
file `C:\data\inventory.txt` and links it with `inputFile`

```cpp
inputFile.open("C:\\data\\inventory.txt");
```

It is possible to define a file stream object and open a file all in one
statement. Here is an example that defines an `ifstream` object named inputFile,
opens the `customers.txt` file, and associates `inputFile` with it:

```cpp
ifstream inputFile("customers.txt");
```

And here is an example that defines an `ofstream` object named outputFile, opens
the `employees.txt` file, and associates `outputFile` with it:

```cpp
ofstream outputFile("employees.txt");
```

### Closing a File

The opposite of opening a file is closing it. Although a program’s files are automatically
closed when the program shuts down, it is a good programming practice to write
statements that explicitly close them. Here are two reasons a program should close files
when it is finished using them:

- Most operating systems temporarily store data in a _file buffer_ before it is
  written to a file. A file buffer is a small "holding section" of memory that
  file-bound data is first written to. The data is not actually written to the
  file until the buffer is full. This is done to improve the system's
  performance because doing file I/O is much slower than processing data in
  memory. Closing a file causes any unsaved data still in a buffer to be written
  out to its file. This ensures that all the data the program intended to write
  to the file is actually in it if you need to read it back in later in the same
  program.
- Some operating systems limit the number of files that may be open at one time.
  When a program closes files that are no longer being used, it will not deplete
  more of the operating system's resources than necessary.

Calling the file stream object’s `close` member function closes the file
associated with it.  Here is an example:

```cpp
inputFile.close();
```

### Writing Data to a File

Assuming `outputFile` is an `ofstream` object, the following statement
demonstrates using the `<<` operator to write a string literal to a file:

```cpp
outputFile << "I love C++ programming\n";
```

Program 5-15 demonstrates opening a file, writing data to the file, and closing
the file.  After this code has executed, we can open the `demofile.txt` file using
a text editor, look at its contents, and print it if we wish.

> Program 5-15

```cpp
// This program writes data to a file.
#include <iostream>
#include <fstream> // Needed to use files
using namespace std;

int main()
{
  ofstream outputFile;

  // Open the output file
  outputFile.open("demofile.txt");

  cout << "Now writing data to the file.\n";

  // Write four names to the file
  outputFile << "Bach\n";
  outputFile << "Beethoven\n";
  outputFile << "Mozart\n";
  outputFile << "Schubert\n";

  // Close the file
  outputFile.close();

  cout << "Done.\n";
  return 0;
}
```

> Program 5-16

```cpp
// This program writes user input to a file.
#include <iostream>
#include <fstream> // Needed to use files
#include <string>
using namespace std;

int main()
{
  ofstream outputFile;
  string name;

  // Open the output file
  outputFile.open("friends.txt");

  // Use a loop to get the names of three friends
  // and write each name in the output file
  cout << "Enter the names of three friends.\n";

  for (int count = 1; count <= 3; count++)
  {
    cout << "Friend #" << count << ": ";
    cin  >> name;
    outputFile << name << endl;
  }

  // Close the file
  outputFile.close();

  cout << "The names were saved to a file.\n";
  return 0;
}
```

### Reading Data from a File

Assuming `inputFile` is an `fstream` or `ifstream` object, the following
statement will read a string from the file and store it in the string variable
name.

```cpp
inputFile >> name;
```

> Program 5-17

```cpp
// This program reads data from a file.
#include <iostream>
#include <fstream> // Needed to use files
#include <string>
using namespace std;

int main()
{
  ifstream inputFile;
  string name;

  // Open the input file
  inputFile.open("friends.txt");

  cout << "Here are the names stored in the friends.txt file.\n";

  for (int count = 1; count <= 3; count++)
  {
    inputFile >> name; // Read the next name from the file
    cout << name << endl; // and display it
  }

  inputFile.close(); // Close the file
  return 0;
}
```

### The Read Position

When a file has been opened for input, the file stream object internally
maintains a special value known as a read position. A file's read position marks
the location of the next byte that will be read from the file. When an input
file is opened, its read position is initially set to the first byte in the
file. So the first read operation extracts data starting at the first byte.  As
data is read from the file, the read position moves forward, toward the end of
the file.

### Letting the User Specify a Filename

```cpp
// This program sums the numeric values stored in a file.
// It lets the user specify the name of the file, as well as
// the number of values to read from it.
#include <string>
#include <iostream>
#include <fstream> // Needed to use files
using namespace std;

int main()
{
  ifstream inputFile; // File stream object
  string fileName; // Holds the user entered file name
  int numValues; // Number of values to read
  double value, // A single value read
  total = 0.0; // Accumulator

  // Prompt the user to enter the data file name
  cout << "This program reads and sums the values in a data file.\n";
  cout << "Enter the name of the file to read from: ";
  cin  >> fileName;

  // Get the number values to read
  cout << "How many values are stored in your file? ";
  cin  >> numValues;

  // Open the input file
  inputFile.open(fileName);

  // Loop once for each piece of data to read
  for (int count = 1; count <= numValues; count++)
  {
    // Read a value from the file and add it to the sum
    inputFile >> value;
    total += value;
  }
  cout << "\nThe total of the " << numValues << " values is "
       << total << endl;

  // Close the file
  inputFile.close();
  return 0;
}
```

### Using the `c_str` Member Function in Older Versions of C++

In older versions of the C++ language (prior to C++ 11), a file stream object's
open member function will not accept a `string` object as an argument.

Fortunately, `string` objects have a member function named `c_str` that returns
the contents of the object formatted as a null-terminated C-string. Here is the
general format of how you call the function:

```cpp
stringObject.c_str()
```

In the general format, `stringObject` is the name of a string object. The `c_str` function
returns a copy of the string stored in `stringObject` as a null-terminated C-string.

### Detecting the End of the File

Program 5-18 asked the user how many values were in the file, and that is how
many data items it read in. However, when reading data from a file, it is not
necessary for the user to specify how many data values there are or where the
data ends. This is because files have an end of file (EOF) mark at their end.
You cannot see it, but it is there, and a program can test to see whether or not
it has been reached. This test is important because an error will occur if the
program attempts to read beyond the end of the file.

The easiest way to test if the end of the file has been reached is with the >>
operator.  This operator not only can read data from a file, but it also returns
a true or false value indicating whether or not the data was successfully read.
If the operator returns true, then a value was successfully read. If the
operator returns false, it means that no value was read from the file. The EOF
has been reached.

> Program 5-19

```cpp
// This program reads and sums the numeric values stored in a file.
// It reads until the end of the file (EOF) is reached.
#include <string>
#include <iostream>
#include <fstream> // Needed to use files
using namespace std;

int main()
{
  ifstream inputFile; // File stream object
  string fileName;    // Holds the user entered file name
  int numValues = 0;  // Counts the number of values read
  double value,       // A single value read
  total = 0.0;        // Accumulator

  // Prompt the user to enter the data file name
  cout << "This program reads and sums the values in a data file.\n";
  cout << "Enter the name of the file to read from: ";
  cin  >> fileName;

  // Open the input file
  inputFile.open(fileName);

  // Loop until the EOF is reached
  while (inputFile >> value) // If a value was read, execute the
  { numValues++;             // loop again to count the value and
    total += value;          // add it to the total
  }
  cout << "\nThe total of the " << numValues << " values is "
       << total << endl;

  // Close the file
  inputFile.close();
  return 0;
}
```

### Testing for File Open Errors

Under certain circumstances, the `open` member function will not work.

Fortunately, there is a way to determine whether the `open` member function
successfully opened the file. After you call the `open` member function, you can
test the file stream object as if it were a Boolean expression. Program 5-20
shows how to do this.

> Program 5-20

```cpp
// This program tests for file open errors.
#include <iostream>
#include <fstream> // Needed to use files
using namespace std;

int main()
{
  ifstream inputFile;
  int number;

  // Attempt to open the input file
  inputFile.open("list_of_numbers.txt");

  // If the file successfully opened, process it
  if (inputFile)
  {
    // Read the numbers from the file and display them
    while (inputFile >> number)
    cout << number << endl;

    // Close the file
    inputFile.close();
  }
  else // The file could not be found and opened
  {
    // Display an error message
    cout << "Error opening the file.\n";
  }
  return 0;
}
```

Another way to detect a failed attempt to open a file is with an `ifstream`
class member function named fail, as shown in the following code:

```cpp
ifstream inputFile;
inputFile.open("customers.txt");
if (inputFile.fail())
  cout << "Error opening file.\n";
else
{
  // Process the file
}
```

The `fail` member function returns true when an attempted file operation fails
(i.e., is unsuccessful) and returns false otherwise. When using file I/O, it is
a good idea to always test the file stream object to make sure the file was
opened successfully before attempting to use it. If the file could not be
opened, the user should be informed and the program should handle the situation
in an appropriate manner.

## 5.13 Focus on Testing and Debugging: Creating Good Test Data

**CONCEPT:** Thorough testing of a program requires good test data.

> Program 5-21

```cpp
// This program attempts to average 2 test scores for each
// student in a class. However, it contains logic errors.
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main()
{
  string name;    // Student first name

  int count = 1,  // Student counter
  score,          // An individual score read in
  totalScore = 0; // Total of a student's 2 scores
  double average; // Average of a student's 2 scores

  cout << fixed << showpoint << setprecision(1);
  cout << "Enter the first name of student " << count
       << " (or Q to quit): ";
  cin  >> name;

  while (name != "Q" && name != "q")
  {
    // Get and validate the first score
    cout << "Enter score 1: ";
    cin  >> score;
    if (score <= 0 || score >= 100)
    { cout << "Score must be between 0 and 100. Please reenter: ";
      cin  >> score;
    }
    totalScore += score; // Add the first score onto the total

    // Get and validate the second score
    cout << "Enter score 2: ";
    cin  >> score;
    if (score <= 0 || score >= 100)
    { cout << "Score must be between 0 and 100. Please reenter: ";
      cin  >> score;
    }
    totalScore += score; // Add the second score onto the total

    // Calculate and print average
    average = totalScore / 2;
    cout << name << setw(6) << average << endl;

    // Get the next student name
    cout << "Enter the first name of student " << count++
         << " (or Q to quit): ";
    cin  >> name;
  }
  return 0;
}
```

## 5.14 Central Mountain Credit Union Case Study

> Program 5-22

```cpp
// This program produces a loan amortization table
// for the Central Mountain Credit Union.
#include <iostream>
#include <iomanip>
#include <cmath> // Needed for the pow function
using namespace std;

int main()
{
  double loan,     // Loan amount
  rate,            // Annual interest rate
  moInterestRate,  // Monthly interest rate
  years,           // Years of loan
  balance,         // Monthly balance
  term,            // Used to calculate payment
  payment;         // Monthly payment
  int numPayments; // Number of payments

  // Get loan information
  cout << "Loan amount: $";
  cin  >> loan;
  cout << "Annual interest rate (entered as a decimal): ";
  cin  >> rate;
  cout << "Years of loan: ";
  cin  >> years;

  // Calculate monthly payment
  numPayments = static_cast<int>(12 * years);
  moInterestRate = rate / 12.0;
  term = pow((1 + moInterestRate), numPayments);
  payment = (loan * moInterestRate * term) / (term − 1.0);

  // Display monthly payment
  cout << fixed << showpoint << setprecision(2);
  cout << "Monthly payment: $" << payment << endl;

  // Display report header
  cout << endl;
  cout << setw(5) << "Month" << setw(10) << "Interest";
  cout << setw(10) << "Principal" << setw(9) << "Balance" << endl;
  cout << "----------------------------------\n";

  balance = loan; // Remaining balance starts out as full loan amount

  // Produce a listing for each month
  for (int month = 1; month <= numPayments; month++)
  {
    double moInterest, // Amount of pmt that pays interest
    principal;         // Amount of pmt that lowers the balance

    // Calculate amount paid for this month's interest and principal
    moInterest = moInterestRate * balance; // Calculate interest first
    if (month != numPayments)              // If not the final month
      principal = payment − moInterest;    // rest of pmt goes
                                           // to principal

    else                                   // It's the last month so
    { principal = balance;                 // pay exact final balance
      payment = balance + moInterest;
    }
    // Calculate new loan balance          // Only principal reduces the
    balance −= principal;                  // balance, not the whole pmt

    // Display this month's payment figures
    cout << setw(4) << month << setw(10) << moInterest;
    cout << setw(10) << principal << setw(10) << balance << endl;
  }
  return 0;
}
```

## Video Lectures

- [📺 cpp sections 5-1 to 5-4](https://www.youtube.com/watch?v=FeGUmf5iKXs)
- [📺 CISC 192 5.5 - 5.8](https://www.youtube.com/watch?v=Lj2CVTR9Ux0)
- [📺 CISC 192 Sections 5.8 - 5.10](https://www.youtube.com/watch?v=XSVAdVa5VDg&feature=emb_title)
- [📺 CISC 192 Section 5.11 Example 1](https://www.youtube.com/watch?v=vQb8SQNB6io)

<br>

# Resources

Textbook

- Starting Out with C++: Early Objects by Tony Gaddis, Judy Walters, Godfrey
  Muganda

