---
title: MATH 141 Chapter 3 Notes
author: Mark Lucernas
date: 2020-03-04
---


# Chapter 3: System of Equations

## 3.1 Solve By Graphing

### Video Lecture

  - [VIDEO: Learn how to solve a system of equations by graphing](https://www.youtube.com/watch?v=OWS2xr7M6NY)

#### Video Lecture Notes

**Slope-intercept form**. Where $m$ as the slope, and $b$ as the y-intercept
$$
y = mx + b
$$

## 3.2 Solve By Substitution

### Video Lecture

  - [VIDEO: Solving Systems of Equations... Substitution Method](https://www.youtube.com/watch?v=YriMMWbndn0)

#### Video Lecture Notes

In getting the value of $x$ or $y$, when a number equals itself, it means it has
infinitely many solutions (video, 14:30). Conversely, when a number equals to a
different number, the system of equations has no solution (video, 15:25).

## 3.3 Solve By Elimination

### Video Lecture

  - [VIDEO: Solving Systems of Equations... Elimination Method](https://www.youtube.com/watch?v=XOJgzW4P7T8)

#### Video Lecture Notes

Adding or subtracting system of equations to eliminate a variable works the same

## Matrices Introduction


### Video 1 Lecture

  - [PLAYLIST 1: Introduction to Matrices](https://www.youtube.com/watch?v=kqWCwwyeE6k&list=PLBu4cfksLjchoB_Zb5vbTkZ-4y3-ur_6y)

#### Playlist 1 Video 2 Lecture Notes

  - Matrices can be added, subtracted, multiplied together, but cannot be
    divided.
  - Matrices can also be multiplied by a number, called a _scalar_.
  - In multiplying matrices together, you multiply the row of the first matrices
    entry by the column of the second matrices entry, then add the product
    together which becomes the value of the matrix product entry (video 1,
    1:58).
    * Multiplying matrices have to be of the same size.

#### Playlist 1 Video 4 Lecture Notes

  - The values inside a matrix are called _elements_ or _entries_

**Order of matrix**

  - order = rows $\times$ columns
    * e.g., $\boldsymbol{A} = \begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6
      \end{bmatrix}$
      - order of $\boldsymbol{A} = 2 \times 3$
    * e.g., $\boldsymbol{B} = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix}$
      - order of $\boldsymbol{B} = 3 \times 1$

#### Playlist 1 Video 5 Lecture Notes

  - Matrix is a rectangular arrangement of rows and columns.
  - Each row and each column has to have equal number of elements.
    * $\begin{bmatrix} a & b \\ c & d \end{bmatrix}$ is a matrix.
    * $\begin{bmatrix} 1 & 2 \\ 3 & \end{bmatrix}$ is **NOT** a matrix.

#### Playlist 1 Video 7 Lecture Notes

**Equality of Matrices**

  - e.g., $\boldsymbol{A} = \begin{bmatrix} -1 & 2 \\ 3 & -4 \end{bmatrix} \text{
    and } \boldsymbol{B} = \begin{bmatrix} -1 & 2 \\ 3 & -4 \end{bmatrix}$ are
    **EQUAL** to each other
  - e.g., $\boldsymbol{A} = \begin{bmatrix} -1 & 2 \\ 3 & 4 \end{bmatrix} \text{
    and } \boldsymbol{B} = \begin{bmatrix} 1 & -2 \\ 3 & 4 \end{bmatrix}$ are
    **NOT EQUAL** to each other

#### Playlist 1 Video 8 Lecture Notes

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

#### Playlist 2 Video 1 Lecture Notes

  - **Determinants of 2x2**

**Determinant**

  - The determinant of a matrix $\boldsymbol{A}$ is denoted as $det(A), detA, or
    |A|$ (not an absolute value, matrices doesn't have an absolute value).
  - Value that can be computed from the elements of a **square** matrix.
  - It can help you find the inverse of a 2 by 2 square matrix.

Example 1: Given $\boldsymbol{A} = \begin{bmatrix} 2 & -3 \\ -4 & 1
    \end{bmatrix}$, find det(A)

$$
\begin{aligned}
det(A) &= 2(1) - (-4)(-3) \\
 &= 2 - 12 \\
det(A) &= -10
\end{aligned}
$$

Example 2 (video, 3:48): Given $\boldsymbol{D} = \begin{bmatrix} 2 & -3 \\ -4 & 1
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

#### Playlist 2 Video 2 Lecture Notes

  - **Determinants of 3x3**

Formula in finding the determinants of a 3x3 matrix

$$
\left | \boldsymbol{A} \right | =
\begin{vmatrix}
a & b & c \\
d & e & f \\
g & h & i
\end{vmatrix} =
a \begin{vmatrix}
e & f \\
h & i
\end{vmatrix}
- b \begin{vmatrix}
d & f \\
g & i
\end{vmatrix}
+ c \begin{vmatrix}
d & e \\
g & h
\end{vmatrix}
$$

Example 1 (video, 1:52): Find the determinant of the following matrix:
$\boldsymbol{A} \begin{vmatrix} 7 & -4 & 6 \\ 2 & 0 & 3 \\ 4 & 1 & -5
\end{vmatrix}$


Solution:

$$
\begin{aligned}
det(A) &= 7(0 - 3) - -4(-10 - 12) + 6(2 - 0)\\
 &= 7(-3) + 4(-22) + 6(2) \\
 &= -21 - 88 + 12 \\
\left | \boldsymbol{A} \right | &= -97
\end{aligned}
$$

**Minor**

  - A **minor** of a matrix is the determinant of some smaller square matrix,
    cut down from $\boldsymbol{A}$ by removing one row and one column or
    columns.
  - Combining these with **cofactors** determine the formula for finding the
    determinant of a larger matrix.
  - The **minor** $M_{ij}$, is the determinant by deleting the $i$th row and
    $j$th column.

Example 2 (video, 5:47): Given the matrix $\boldsymbol{A} = \begin{vmatrix} -8 &
0 & 6 \\ 4 & -6 & 7 \\ -1 & -3 & 5 \end{vmatrix}$

  - Find $\boldsymbol{M}_{11}$

$$
\begin{aligned}
\boldsymbol{M}_{11} &= (-6)(5) -(-3)(7) \\
 &= (-30) + (-21) \\
\boldsymbol{M}_{11} &= -9
\end{aligned}
$$

  - Find $\boldsymbol{M}_{23}$

$$
\begin{aligned}
\boldsymbol{M}_{23} &= (-8)(-3) - (-1)(0) \\
 &= 24 - 0 \\
\boldsymbol{M}_{23} &= 24
\end{aligned}
$$

**Cofactor**

  - The cofactor $\boldsymbol{A}_{ij}$, is obtained by multiplying the minor by
    $(-1)^{i+j}$, where $i$ represents the row and $j$ represents the column.
    * Hence, $\boldsymbol{A}_{ij} = (-1)^{i+j} \cdot \boldsymbol{M}_{ij}$
  - Note:
    * Taking $(-1)^{\text{even power}} = +$
    * Taking $(-1)^{\text{odd power}} = -$
  - Signs of $(-1)^{i+j}$ of a 3x3 matrix
    * $\begin{bmatrix} + & - & + \\ - & + & - \\ + & - & + \end{bmatrix}$

Example 3 (video, 8:25): Given the matrix $\boldsymbol{A} = \begin{vmatrix} -8 &
0 & 6 \\ 4 & -6 & 7 \\ -1 & -3 & 5 \end{vmatrix}$

  - Find $\boldsymbol{A}_{11}$

$$
\begin{aligned}
\boldsymbol{A}_{11} &= (-1)^{1 + 1} \boldsymbol{M}_{11} \\
 &= (-1)^{2} (-30 + 21) \\
 &= 1(-9) \\
\boldsymbol{A}_{11} &= -9
\end{aligned}
$$

  - Find $\boldsymbol{A}_{23}$

$$
\begin{aligned}
\boldsymbol{A}_{23} &= (-1)^{2 + 3} \boldsymbol{M}_{23} \\
 &= (-1)^{5}(24 - 0) \\
 &= (-1)(24) \\
\boldsymbol{A}_{23} &= -24
\end{aligned}
$$

#### Playlist 2 Video 3 Lecture Notes

**Expanding Method**

Example 1 (video, 0:34): Evaluate $\left | \boldsymbol{A} \right |$ by expanding
across a different row/column other than the first row.
  - $\boldsymbol{A} = \begin{vmatrix} 7 & -4 & 3 \\ 2 & 0 & 3 \\ 4 & 1 & -5
    \end{vmatrix}$

Solution (expanding on the second column):

$$
\begin{aligned}
det(A) &= -4(-1)^{1 + 2}(-10 - 12) + 0(-1)^{2 + 2}(-35 - 24) + 1(-1)^{3 + 2}(21 - 12) \\
 &= 4(-22) + 0 - 1(9) \\
 &= -88 - 9 \\
det(A) &= -97
\end{aligned}
$$

#### Playlist 2 Video 4 Lecture Notes

**Diagonal Method**

Example 1 (video, 0:42): Find the determinant of the following matrix using the
**diagonal method**.

  - $\boldsymbol{A} = \begin{vmatrix} 7 & -4 & 3 \\ 2 & 0 & 3 \\ 4 & 1 & -5
  \end{vmatrix}$

  - Copy the first two columns and place them on the right side of the matrix

$$
\begin{vmatrix}
7 & -4 & 6 \\
2 & 0 & 3 \\
4 & 1 & -5
\end{vmatrix}
\begin{matrix}
7 & -4 \\
2 & 0 \\
4 & 1
\end{matrix}
$$

  - Multiply downwards diagonally to the right starting on the first entry of
    the first row to the last last, overlapping the first two columns copy. Then
    add the result of all products.

$$
0 + -48 + 12 = 36
$$

  - Then, do the same for the bottom row with upwards diagonally to the right
    multiplication, overlapping the first two columns copy. Then add the results
    of all products

$$
0 + 21 + 40 = 61
$$

  - Finally, subtract the result of the top row from the bottom row
    * $\text{Bottom result} - \text{Top result}$

$$
\begin{aligned}
\left | \boldsymbol{A} \right | &= -36 - 61 \\
\left | \boldsymbol{A} \right | &= -97
\end{aligned}
$$


### Video Lecture 3

  - [(Linear Algebra) Properties of Determinants](https://www.youtube.com/watch?v=IjMxFP8AtpA)

#### Video Lecture 3 Notes

Elementary Row Operations

  - $R_{i} \rightarrow R_{i} + cR_{j}$, adding a row to a scaled row
  - $R_{i} \leftrightarrow R_{j}$, row switching
  - $R_{i} \rightarrow cR_{i}$, multiplying entire row by a scalar
  - Note:
    * $\boldsymbol{R}$ represents the row, and its subset as the nth row
    * $\boldsymbol{c}$ represents the multiplier or scalar

Properties of Determinants

  - $\det(B) = \det(A)$
  - $\det(B) = -\det(A)$
  - $\det(B) = c\det(A)$
  - $\det A = \det A^{t}$
  - $\det (AB) = \det (A) \cdot \det (B)$

### Additional Video Lecture

  - [Multiplying Matrices](https://www.youtube.com/watch?v=kuixY2bCc_0)

## 3.5 Cramer's Rule

### Video 1 Lecture

  - [VIDEO 1: Algebra - Solving Linear Equations using Determinants 3/3](https://www.youtube.com/watch?v=IVxMEy4mfhI)

### Video 2 Lecture

  - [VIDEO 2: Determinant of 3x3 matrix](https://www.youtube.com/watch?v=V3e7m-qFDFU)

### Additional Video 1 Lecture

  - [+VIDEO 1: 5.5.6 Cramer's Rule](https://www.youtube.com/watch?v=DQOHnr0byUM)

### Additional Video 2 Lecture

  - [+VIDEO 2: Cramer's Rule to Solve a System of 3 Linear Equations](https://www.youtube.com/watch?v=TtxVGMWXMSE)

#### Additional Video 2 Lecture Notes

$$
x = \frac{D_{x}}{D},\; y = \frac{D_{y}}{D},\; z =\frac{D_{z}}{D}
$$

## 3.6 Solve by Row Reduction

### Video Lecture

  - [VIDEO: Introduction to Echelon Row Reduction, How and Why](https://www.youtube.com/watch?v=06zE9IEv4OA)


References
=====

  - [Pre-calc Textbook Reference 1](file:../../../../files/spring-2020/MATH-141/pre-calc_textbookRef.pdf)
  - [video, Learn how to solve a system of equations by graphing](https://www.youtube.com/watch?v=OWS2xr7M6NY)
  - [video, Solving Systems of Equations... Substitution Method](https://www.youtube.com/watch?v=YriMMWbndn0)
  - [video, Solving Systems of Equations... Elimination Method](https://www.youtube.com/watch?v=XOJgzW4P7T8)
  - [PLAYLIST 1: Introduction to Matrices](https://www.yocube.com/watch?v=kqWCwwyeE6k&list=PLBu4cfksLjchoB_Zb5vbTkZ-4y3-ur_6y)
  - [PLAYLIST 2: Calc 5.5 Determinants and Cramer's Rule](https://www.youtube.com/watch?v=AJi16SLXObk&list=PLaCvjCCHYhspLApshl8YorGhHFpQpN9Tl)
  - [(Linear Algebra) Properties of Determinants](https://www.youtube.com/watch?v=IjMxFP8AtpA)
  - [VIDEO 1: Algebra - Solving Linear Equations using Determinants 3/3](https://www.youtube.com/watch?v=IVxMEy4mfhI)
  - [VIDEO 2: Determinant of 3x3 matrix](https://www.youtube.com/watch?v=V3e7m-qFDFU)
  - [+VIDEO 1: 5.5.6 Cramer's Rule](https://www.youtube.com/watch?v=DQOHnr0byUM)
  - [+VIDEO 2: Cramer's Rule to Solve a System of 3 Linear Equations](https://www.youtube.com/watch?v=TtxVGMWXMSE)
  - [VIDEO: Introduction to Echelon Row Reduction, How and Why](https://www.youtube.com/watch?v=06zE9IEv4OA)

