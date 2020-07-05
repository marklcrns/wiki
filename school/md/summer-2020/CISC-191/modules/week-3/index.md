---
title: CISC 191 Week 3
author: Mark Lucernas
date: 2020-06-29
summary: CISC 191 Week 3 notes and activities
---


# Week 3

## Notes

  - [+Week 3: Linked Data Structures and Recursion Notes](notes/index)


## Graded Discussion

Part 1

1. Recursive program for prime number

I pick this one mainly because of its readability and elegant looking in
recursive from. It has 3 base case and a super simple recursive case.
Performance-wise, it's relatively slower than an iterative counterpart because
of repeated method calls which takes up extra space in that stack frame. But
because of readability and much simpler to solve in recursion (for me at least),
I find that this is a great use of recursion.

2. Sum Triangle from array

Since this problem requires to create a new array of length N until array length
== 1, to create a triangle shape output with each element of each level is the
summation of the two numbers below it.  At first sight, this calls for a
recursive method because of a pyramid like stack (in this case, stack of arrays)
which is very conducive to when recursion starts returning values, which is way
easier to understand than creating multiple nested for/while loops. Plus, the
recursive solution is way too readable than its iterative counter part

3. Recursive Tower of Hanoi using 4 pegs / rods

Obviously, Tower of Hanoi is a recursive problem. Again readability-wise, its
simpler in recursive form because you can focus more on solving the problem with
its recursive cases than worrying about looping over arbitrary amount of moves
in an arbitrary amount of pegs and rods. It would be difficult to create an
iterative form of the solution to this problem and isn't as readable as the
recursive solution. Recursion is almost always slower than iteration because of
extra method calls into the stack frame but the elegance and readability far
outweighs the marginal difference between two approach.

Part 2


