---
title: Recursion
author: Mark Lucernas
date: 2020-07-04
summary: CISC 191 Week 3 Recursion Notes
---


# Recursion

- [⬇ Recursion](file:../../../../../../../files/summer-2020/CISC-191/week-3/recursion.ppt)
- [🎬 Java Recursion](https://www.youtube.com/watch?v=neuDuf_i8Sg)


## Recursion Java Sample Codes

- [↪ Recursion Java Sample Codes](recursion_sample_codes)


## Stack Overflow

Recursion enables an elegant solution to some problems. But, for large problems,
deep recursion can cause memory problems. Part of a program's memory is reserved
to support function calls. Each method call places a new **stack frame** on the
stack, for local parameters, local variables, and more method items. Upon
return, the frame is deleted.

Deep recursion could fill the stack region and cause a stack overflow, meaning a
stack frame extends beyond the memory region allocated for stack, **Stack
overflow** usually causes the program to crash and report an error like: stack
overflow error or stack overflow exception.

<br>

# Resources

- [⬇ Recursion](file:../../../../../../../files/summer-2020/CISC-191/week-3/recursion.ppt)
- [🎬 Java Recursion](https://www.youtube.com/watch?v=neuDuf_i8Sg)

Textbook

+ [🌎 Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 11 Recursion
