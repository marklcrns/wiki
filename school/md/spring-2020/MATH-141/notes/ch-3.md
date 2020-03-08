---
title: MATH 141 Chapter 3 Notes
author: Mark Lucernas
date: 2020-03-04
---


# Chapter 3: System of Equations

## 3.1 Solve By Graphing

### Video Lecture

  - [VIDEO: Learn how to solve a system of equations by graphing](https://www.youtube.com/watch?v=OWS2xr7M6NY)

Video Lecture Notes

**Slope-intercept form**. Where $m$ as the slope, and $b$ as the y-intercept
$$
y = mx + b
$$

## 3.2 Solve By Substitution

### Video Lecture

  - [VIDEO: Solving Systems of Equations... Substitution Method](https://www.youtube.com/watch?v=YriMMWbndn0)

Video Lecture Notes

In getting the value of $x$ or $y$, when a number equals itself, it means it has
infinitely many solutions (VIDEO, 14:30). Conversely, when a number equals to a
different number, the system of equations has no solution (VIDEO, 15:25).

## 3.3 Solve By Elimination

### Video Lecture

  - [VIDEO: Solving Systems of Equations... Elimination Method](https://www.youtube.com/watch?v=XOJgzW4P7T8)

Video Lecture Notes

Adding or subtraction system of equations to eliminate a variable works the same

## Matrices Introduction


### Video 1 Lecture

  - [PLAYLIST 1: Introduction to Matrices](https://www.youtube.com/watch?v=kqWCwwyeE6k&list=PLBu4cfksLjchoB_Zb5vbTkZ-4y3-ur_6y)

Playlist 1 Video 2 Lecture Notes

  - Matrices can be added, subtracted, multiplied together, but cannot be
    divided.
  - Matrices can also be multiplied by a number, called a _scalar_.
  - In multiplying matrices together, you multiply the row of the first matrices
    entry by the column of the second matrices entry, then add the product
    together which becomes the value of the matrix product entry (VIDEO 1,
    1:58).
    * Multiplying matrices have to be of the same size.

Playlist 1 Video 4 Lecture Notes

  - The values inside a matrix are called _elements_ or _entries_

**Order of matrix**

  - order = rows $\times$ columns
    * e.g., $\boldsymbol{A} = \begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6
      \end{bmatrix}$
      - order of $\boldsymbol{A} = 2 \times 3$
    * e.g., $\boldsymbol{B} = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix}$
      - order of $\boldsymbol{B} = 3 \times 1$

Playlist 1 Video 5 Lecture Notes

  - Matrix is a rectangular arrangement of rows and columns.
  - Each row and each column has to have equal number of elements.
    * $\begin{bmatrix} a & b \\ c & d \end{bmatrix}$ is a matrix.
    * $\begin{bmatrix} 1 & 2 \\ 3 & \end{bmatrix}$ is **NOT** a matrix.

Playlist 1 Video 7 Lecture Notes

**Equality of Matrices**

  - e.g., $\boldsymbol{A} = \begin{bmatrix} -1 & 2 \\ 3 & -4 \end{bmatrix} \text{
    \& } \boldsymbol{B} = \begin{bmatrix} -1 & 2 \\ 3 & -4 \end{bmatrix}$ are
    **EQUAL** to each other
  - e.g., $\boldsymbol{A} = \begin{bmatrix} -1 & 2 \\ 3 & 4 \end{bmatrix} \text{
    \& } \boldsymbol{B} = \begin{bmatrix} 1 & -2 \\ 3 & 4 \end{bmatrix}$ are
    **NOT EQUAL** to each other

Playlist 1 Video 8 Lecture Notes

**Square Matrix**

  - $\begin{bmatrix} 1 \end{bmatrix} => 1 \times 1$
  - $\begin{bmatrix} 1 & 2 \\ 3 & 4 \end{bmatrix} => 2 \times 2$
  - $\begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6 \\ 7 & 8 & 9 \end{bmatrix} => 3
    \times 3$

**Rectangular Matrix**

  - $\begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6 \end{bmatrix} => 2 \times 3$

**Row Matrix**

  - $\begin{bmatrix} 1 & 2 & 3 \end{bmatrix} => 1 \times 3$

**Column Matrix**

  - $\begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix} => 3 \times 1$

**Null Matrix / Zero Matrix**

  - $\begin{bmatrix} 0 & 0 & 0 \end{bmatrix} => 0_{1 \times 3}$

**Principal Diagonal Matrix**

  - $\begin{bmatrix} \boldsymbol{1} & 2 & 3 \\ 4 & \boldsymbol{5} & 6 \\ 7 & 8 &
    \boldsymbol{9} \end{bmatrix} 1 + 5 + 9$. $trace \boldsymbol{A} = 15$

**Scalar Matrix**

  - $\begin{bmatrix} 2 & 0 & 0 \\ 0 & 2 & 0 \\ 0 & 0 & 2 \end{bmatrix}$

**Diagonal Matrix**

  - $\begin{bmatrix} 2 & 0 & 0 \\ 0 & -1 & 0 \\ 0 & 0 & 1 \end{bmatrix}$

**Triangular Matrix**

  - $\begin{bmatrix} 1 & \boldsymbol{0} & \boldsymbol{0} \\ 4 & 5 &
    \boldsymbol{0} \\ 7 & 8 & 9 \end{bmatrix} \text{Lower Triangular Matrix}$
  - $\begin{bmatrix} 1 & 2 & 3 \\ \boldsymbol{0} & 5 & 6 \\ \boldsymbol{0} &
    \boldsymbol{0} & 9 \end{bmatrix} \text{Upper Triangular Matrix}$

**Identity Matrix / Unit Matrix**

  - $\begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} =>
    \boldsymbol{I_{3}}$

**Transpose of a Matrix**

  - Transpose each row to column
    - $\boldsymbol{A} = \begin{bmatrix} 1 & 2 \\ 3 & 4 \\ 5 & 6 \end{bmatrix}$
    - $\boldsymbol{A^{T}} = \begin{bmatrix} 1 & 3 & 5 \\ 2 & 4 & 6 \end{bmatrix}$

  - Transpose each column to row
    * $\boldsymbol{B} = \begin{bmatrix} a & b & c \\ d & e & f \end{bmatrix}$
    * $\boldsymbol{B^{T}} = \begin{bmatrix} a & d \\ b & e \\ c & f
      \end{bmatrix}$

**Symmetric Matrix**

  - A matrix is symmetric when the transposed is still equals to the original.
    $\boldsymbol{A} = \boldsymbol{A^{T}}$
    * $\boldsymbol{A} = \begin{bmatrix} 2 & 3 & 1 \\ 3 & 4 & 5 \\ 1 & 5 & 7
      \end{bmatrix}$
    * $\boldsymbol{A^{T}} = \begin{bmatrix} 2 & 3 & 1 \\ 3 & 4 & 5 \\ 1 & 5 & 7
      \end{bmatrix}$


### Video 2 Lecture

  - [PLAYLIST 2: Calc 5.5 Determinants and Cramer's Rule](https://www.youtube.com/watch?v=AJi16SLXObk&list=PLaCvjCCHYhspLApshl8YorGhHFpQpN9Tl)

Playlist 2 Video 1 Lecture Notes

**Determinant**

  - The determinant of a matrix $\boldsymbol{A}$ is denoted as $det(A), detA, or
    |A|$ (not an absolute value, matrices doesn't have an absolute value).
  - Value that can be computed from the elements of a **square** matrix.
  - It can help you find the inverse of a 2 by 2 square matrix.

Example 1: Given $\boldsymbol{A} = \begin{bmatrix} 2 & -3 \\ -4 & 1
    \end{bmatrix}$, find det(A)

$$
\begin{align}
det(A) &= 2(1) - (-4)(-3) \\
 &= 2 - 12 \\
det(A) &= -10
\end{align}
$$

Example 2: Given $\boldsymbol{D} = \begin{bmatrix} 2 & -3 \\ -4 & 1
\end{bmatrix}$, find $D^{-1}$

**Method 1: Echelon Row Reduce**

  - Multiply row 1 by 2  and add the result to the bottom row to turn $D(2,1)$,
    -4, into zero

$$
\left[\begin{matrix}
2 & -3 \\
-4 & 1
\end{matrix}\right|
\left.\begin{matrix}
1 & 0 \\
0 & 1
\end{matrix}\right]
r_{1}(2) + r_{2} \to R_{2}
$$

  - Divide row 1 by 2 to and row 2 by -5 to turn $D(1,1)$, 2, and $D(2,2)$, -5,
    into 1

$$
\left[\begin{matrix}
2 & -3 \\
0 & -5
\end{matrix}\right|
\left.\begin{matrix}
1 & 0 \\
2 & 1
\end{matrix}\right]
\frac{r_{1}}{2} \to R_{1} \text{ and } \frac{r_{2}}{-5} \to R_{2}
$$

  - Multiply row 2 by $\tfrac{-3}{2}$ and add the result to row 1 to turn
    $D(1,2)$, $\tfrac{-3}{2}$, into zero

$$
\left[\begin{matrix}
1 & \frac{-3}{2} \\
0 & 1
\end{matrix}\right|
\left.\begin{matrix}
\frac{1}{2} & 0 \\
\frac{-2}{5} & \frac{-1}{5}
\end{matrix}\right]
r_{2}(\tfrac{3}{2}) + r_{1} \to R_{1}
$$

$$
\left[\begin{matrix}
1 & 0 \\
0 & 1
\end{matrix}\right|
\left.\begin{matrix}
\frac{-1}{10} & \frac{-3}{10} \\
\frac{-2}{5} & \frac{-1}{5}
\end{matrix}\right]
$$

  - $\boldsymbol{D^{-1}} = \begin{bmatrix} \frac{-1}{10} & \frac{-3}{10} \\
    \frac{-2}{5} & \frac{-1}{5} \end{bmatrix}$

**Method 2: Using Determinants**

$\boldsymbol{D} = \begin{bmatrix} 2 & -3 \\ -4 & 1
\end{bmatrix}$

Inverse determinant formula
  - $\begin{bmatrix} a & b \\ c & d \end{bmatrix}^{-1} = \frac{1}{det}
    \begin{bmatrix} d & -b \\ -c & a \end{bmatrix}$

$$
\left | D \right | = 2 - 12 = -10
$$

$$
D^{-1} = \tfrac{1}{10}
\begin{bmatrix}
1 & 3 \\
4 & 2
\end{bmatrix}
$$

  - $\boldsymbol{D^{-1}} = \begin{bmatrix} \frac{-1}{10} & \frac{-3}{10} \\
  \frac{-2}{5} & \frac{-1}{5} \end{bmatrix}$

### Video Lecture 3

  - [[Linear Algebra] Properties of Determinants](https://www.youtube.com/watch?v=IjMxFP8AtpA)


References
=====

  - [Pre-calc Textbook Reference 1](file:../../../../files/spring-2020/MATH-141/pre-calc_textbookRef.pdf)
  - [VIDEO: Learn how to solve a system of equations by graphing](https://www.youtube.com/watch?v=OWS2xr7M6NY)
  - [VIDEO: Solving Systems of Equations... Substitution Method](https://www.youtube.com/watch?v=YriMMWbndn0)
  - [VIDEO: Solving Systems of Equations... Elimination Method](https://www.youtube.com/watch?v=XOJgzW4P7T8)
  - [PLAYLIST 1: Introduction to Matrices](https://www.youtube.com/watch?v=kqWCwwyeE6k&list=PLBu4cfksLjchoB_Zb5vbTkZ-4y3-ur_6y)
  - [PLAYLIST 2: Calc 5.5 Determinants and Cramer's Rule](https://www.youtube.com/watch?v=AJi16SLXObk&list=PLaCvjCCHYhspLApshl8YorGhHFpQpN9Tl)

