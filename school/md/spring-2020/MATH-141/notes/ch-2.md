---
title: MATH 141 Chapter 2 Notes
author: Mark Lucernas
date: 2020-02-18
---

# Chapter 2: Functions

## 2.1 Vocabulary and Notations

#### Video Lecture

[VIDEO: What are functions?](https://www.youtube.com/watch?v=52tpYl2tTqk)

Video lecture notes:

**Function** - something that relates one set into another set:

  - Input set, also called as the **Domain**.
  - Output set, also called as the **Range**
  - Function notation: $f(x) = y$, where $x$ is the input and $y$ is the range.

**Set** - a collection of values.

  - a set can be a _finite_ or _infinite_.

> A function can only have **ONE** output for every input. Having an input
outputs to more than one solution is NOT considered a function.

**Vertical line test**

  - A graphing test to see if there's more than one output to every input ($y's$
    to every $x$ in an ordered pair) of a function.

#### Video Lecture 1

[VIDEO 1: Surjective and Injective functions](https://www.youtube.com/watch?v=xKNX8BUWR0g)

Video lecture notes:

**Surjective (onto)**

  - A function is _surjective_ if every member of a set of _range_ ($y$) maps to **at
    least one** _domain_ ($x$).

**Injective (one-to-one)**

  - A function is _injective_ if a member of a set of _range_ maps to only one
    _domain_.

#### Video Lecture 2

[VIDEO 2: How To Find The Inverse of a Function](https://www.youtube.com/watch?v=2zeYEx4eTdc)

## 2.2 Polynomial Functions

#### Video Lecture

[VIDEO: What are polynomials](https://www.youtube.com/watch?v=ffLLmV4mZwU)

**Terms**

  - Mathematical expressions that has a number and a variable(s) multiplied
    together.

**Coefficient**

  - A number without a variable

**Polynomials**

  - Combination of terms joined together by addition or subtraction.
    * _Monomial_: has only one term
    * _Binomial_: has two terms
    * _Trinomial_: has three terms

## 2.3 Rational Functions

  - A rational function is any function which can be specified by a rule written
    as $f(x) = \frac{P(x)}{Q(x)}$, where $P(x)$ and $Q(x)$ are polynomial
    functions.

Example 1:

$$
f(x) = \frac{12}{x}, g(x) = \frac{x^2}{x^2 - 9}, h(x) = \frac{(x + 1)(x -
4)}{x(x - 2)(x + 3)}, k(x) = \frac{3x}{x^2 + 4}
$$

These are examples of rational functions. The domains are, respectively:

  - for $f$, $\big\{x \in \mathbb{R} \mid x \neq 0\big\}$
  - for $g$, $\big\{x \in \mathbb{R} \mid x \neq \pm 3\big\}$
  - for $h$, $\big\{x \in \mathbb{R} \mid x \neq 0,2,-3\big\}$
  - for $k$, $\mathbb{R}$ (since the denominator polynomial is never 0)


## 2.4 Linear Functions

### Video Lecture

[VIDEO: Linear Functions](https://www.youtube.com/watch?v=AqIMrHOBM4g)

Video lecture notes

**Linear function**

  - A _linear function_ is any function specified by a rule of the form $f: x
    \to mx + b$, where $m \neq  0$. if $m = 0$, the function is not considered
    to be a linear function.
  - The graph of a linear function is always a **straight line**.
  - Equation: $f(x) ax + b$, $y$ as the independent variable and $x$ as the
    dependent variable, and $b$ as the constant

**Slope**

$$
m = \frac{y_2 - y_1}{x_2 - x_1} = \frac{rise}{run}
$$

**Horizontal and vertical lines**

  - A _horizontal line_ (a line parallel to the x-axis) **has slope 0**, since any
    two points on the line have the same y coordinates.
    * Equation: $y = k$
  - A _vertical line_ (a line parallel to the y-axis) **has undefined slope**,
    since any two points on the line have the same x coordinates.
    * Equation: $x = h$

The equation of a line can be written in several forms:

<a name="slope-intercept-form-term">**Slope-intercept form**</a>

- $y = mx + b$


<a name="point-slope-form-term">**Point-slope form**</a>

- $y - y_0 = m(x - x_{1})$


<a name="standard-form-term">**Standard form**</a>

- $Ax + By = C$, where $A, B, C$ are integers with no common factors; $A$ and
  $B$ are not both zero.

**Parallel and Perpendicular Lines**

  - If two non-vertical lines are parallel, their slopes are equal. Conversely,
    if two lines have the same slope, they are parallel; two vertical lines are
    also parallel.

If a line is horizontal, any line perpendicular to it is vertical, and
conversely. If two nonvertical lines, with slopes $m_1$ and $m_2$, are
perpendicular, the their slopes satisfy $m_1m_2 = -1$ or $m_2 = -1/m_1$


## 2.6 Exponential Function and Factorials

### Exponential Function

#### Video Lecture

[VIDEO: Solving Exponential Equations With Different Bases Using Logarithms](https://www.youtube.com/watch?v=oVUJMVR1JpA)

Timestamps

  - Problem 1: 0:00
    * $3^x = 5$
  - Problem 2: 2:14
    * $5^{2x + 3} = 8$
  - Problem 3: 3:44
    * $3^{x + 2} = 4^{2 - x}$
  - Problem 4: 6:02
    * $27^{x + 1} = 9^{3 - x}$
  - Problem 5: 7:23
    * $4^{x + 2} = 8^{3x - 1}$
  - Problem 6: 9:22
    * $16^{5x - 2} = 32^{3x + 1}$

Video Lecture Notes:

Quick solution

  - $3^x = 5$
  - $x = \frac{\log 5}{\log 3}$

Manual Solution

  - $3^x = 5$
  - $x\log3 = \log5$
  - $x\frac{\log3}{\log3} = \frac{\log5}{\log3}$
  - $x = \frac{\log 5}{\log 3}$

### Additional

- [🎬 Solving Exponential Equations - Some Basic Examples](https://www.youtube.com/watch?v=M6f6dANVyxA)
- [🎬 How to solve an exponential equation with two different bases](https://www.youtube.com/watch?v=oM25leefVRQ)

### Factorials

#### Video Lecture

[VIDEO: Factorials](https://www.youtube.com/watch?v=pxh__ugRKz8)

Timestamps

  - Problem 1 2:26
    * $\frac{9!}{7!}$
  - Problem 2 3:21
    * $\frac{4! \cdot 5!}{6!}$
  - Problem 3 4:25
    * $\frac{12!}{3! \cdot 10!}$
  - Problem 4 5:10
    * $\frac{(n + 1)!}{n!}$
  - Problem 5 7:32
    * $\frac{(n - 1)!}{n!}$
  - Problem 6 8:53
    * $\frac{(n + 2)!}{n!}$
  - Problem 7 10:19
    * $\frac{(2n + 1)!}{(2n)!}$

Video Lecture Notes

  - $0! = 1$
  - $4! = 4 \cdot 3 \cdot 2 \cdot 1$
    * $24$
  - $6! = 6 \cdot 5 \cdot 4 \cdot 3 \cdot 2 \cdot 1$
    * $720$
  - $\frac{9!}{7!} = \frac{9 \cdot 8 \cdot 7!}{7!}$
    * $9 \cdot 8 = 72$


## 2.7 Logarithmic Functions

### Logarithm Basics

A logarithmic function, $f(x) = \log_{a}x, a > 0, a \neq 1$, is the inverse
function to an exponential function $F(x) = a^x$. Thus, if $y = \log_{a}x$, then
$x = a^y$. That is, the logarithm of $x$ to the base $a$ is the exponent to
which $a$ must be raised to obtain $x$. Conversely, if $x = a^y$, then $y =
\log_{a}x$. Therefore the relation between logarithmic and exponential functions
can be described as:

$$
\log_{a}a^x = x \text{ and } a^{\log_{a}x} = x
$$

Logarithmic expressions can be rewritten in terms of other bases by means of the
change-of-base formula:

$$
\log_{a}x = \frac{\log_{b}x}{\log_{b}a}
$$

#### Video Lecture 1

[VIDEO 1: Logarithms... How? (NancyPi)](https://www.youtube.com/watch?v=Zw5t6BTQYRU)

Video 1 Lecture Notes:

  - $\log_{b}m = x,\text{ is the inverse of exponential function } b^x = m$

#### Video Lecture 2

[VIDEO 2: Solving Logarithmic Equations | Khan Academy](https://www.youtube.com/watch?v=Kv2iHde7Xgw)

Timestamps

  - Problem 1: 0:00
    * $log\ x + log\ 3 = 2\ log\ 4 - log\ 2$

Video 2 Lecture Notes:

  - $log$ without a base $log_b$ or common log, it is implicit to have a base of
    10, $log_{10}$.

#### Video Lecture 3

[VIDEO 3: Solving Logarithmic Equations... How? (NancyPi)](https://www.youtube.com/watch?v=rBnQiLa2TYo)

Timestamps

  - Equality Property 3:00
  - Product Property 5:59
  - Power Property 10:30
  - Quotient Property 12:47

Video 3 Lecture Notes:

  - $\log$ of a negative number is undefined, so you would have to throw out
    that number.

  - **Logarithmic Properties:**
    * _Equality Property_
      - $\log_{b}m = \log_{b}n \Longleftrightarrow m = n$
      - Only for bases that are positive and not equal to 1
    * _Product Property_
      - $\log_{a}b + \log_{a}c = \log_{a}bc$
    * _Power Property_
      - $\log_{b}a^p = p\log_{b}a$
    * _Quotient Property_
      - $\log_{a}b - \log_{a}c = \log_{a}\frac{b}{c}$
    * Additional Properties
      - $\log_{a}1 = 0$
      - $\log_{a}a = 1$

### Logarithmic Equations

#### Video Lecture

[VIDEO: Solving Logarithmic Equations With Logs on Both Sides ...](https://www.youtube.com/watch?v=G_kHwdrxyeU)

Timestamps

  - Problem 1 0:00
    * $\log_{4}(2x +7) = 2$
  - Problem 2 1:17
    * $\ln_{e}(\sqrt{5x - 4})$
  - Problem 3 3:04
    * $\ln (x^3)= 8$
  - Problem 4 4:17
    * $\log_{5}(8x - 7) = \log_{5}(2x + 13)$
  - Problem 5 5:50
    * $\log_{2}(x + 5) + \log_{2}(x + 1) + 5$
  - Problem 6 9:45
    * $\log_{3}(5x + 7) - \log_{3}(x + 5) = x - 3$
    * $\log_{3}(5x + 7) - \log_{3}(x + 5) = 1$

Video Lecture Notes

  - $\log_{3}9 = 2$
    * $3^2 = 9$
  - $\log_{4}(2x + 7) = 2$
    * $4^2 = 2x + 7$
    * $16 = 2x + 7$
    * $\frac{9}{2} = \frac{2x}{2}$
    * $x = \frac{9}{2}$

$\ln$ is a natural log and always has a base of $e$, $\ln_{e}$

### Daabz Questions

  - $\frac{d}{dx}\ln a$
    * Solution: $\frac{\frac{d}{dx}a}{a}$
  - $\frac{1}{\log_{a}(4)}$
    * Solution: $\log_{4}(a)$
  - $\log_{a}(x) = \frac{\log_{\theta}(x)}{\log_{\theta}(a)} = \frac{\log(x)}{\log(a)}$
    * Solution: true
  - $\log_{2}(A)$
    * Solution: $\frac{\ln(A)}{\ln(2)}$ or $\frac{\log(A)}{\log(2)}$
  - $\log_{5}(A)$
    * Solution: $\frac{\log (A)}{\log (5)}$
  - $\frac{d}{dx}\ln^2[e^x]$
    * Solution: $2\ln^1[e^x] \cdot \frac{1}{[e^x]}\frac{d}{dx}[e^x]$
  - $\frac{d}{dw}\ln^{10}\alpha$
    * $10\ln^9\alpha \cdot \frac{1}{\alpha}\frac{d}{dw}\alpha$

### Additional

- [🎬 (Hard) Log/Exponential Equations Example](https://www.youtube.com/watch?v=HgJF4gSVGfA)
- [🎬 Solving (Challenging) Log Equations Different Bases](https://www.youtube.com/watch?v=xx80CyHZfLQ)


<br>

# References

- [⬇ Pre-calc Textbook Reference 1](file:../../../../files/spring-2020/MATH-141/pre-calc_textbookRef.pdf)
    * Chapter 5 pages 61 - 77
    * Chapter 6 page 80
- [🎬 What are functions?](https://www.youtube.com/watch?v=52tpYl2tTqk)
- [🎬 VIDEO 1: Surjective and Injective functions](https://www.youtube.com/watch?v=xKNX8BUWR0g)
- [🎬 VIDEO 2: How To Find The Inverse of a Function](https://www.youtube.com/watch?v=2zeYEx4eTdc)
- [🎬 Solving Exponential Equations With Different Bases Using Logarithms](https://www.youtube.com/watch?v=oVUJMVR1JpA)
- [🎬 Solving Exponential Equations - Some Basic Examples](https://www.youtube.com/watch?v=M6f6dANVyxA)
- [🎬 Factorials](https://www.youtube.com/watch?v=pxh__ugRKz8)
- [🎬 VIDEO 1: Logarithms... How? (NancyPi)](https://www.youtube.com/watch?v=Zw5t6BTQYRU)
- [🎬 VIDEO 2: Solving Logarithmic Equations | Khan Academy](https://www.youtube.com/watch?v=Kv2iHde7Xgw)
- [🎬 VIDEO 3: Solving Logarithmic Equations... How? (NancyPi)](https://www.youtube.com/watch?v=rBnQiLa2TYo)
- [🎬 Solving Logarithmic Equations With Logs on Both Sides ...](https://www.youtube.com/watch?v=G_kHwdrxyeU)
- [🎬 (Hard) Log/Exponential Equations Example](https://www.youtube.com/watch?v=HgJF4gSVGfA)
- [🎬 Solving (Challenging) Log Equations Different Bases](https://www.youtube.com/watch?v=xx80CyHZfLQ)
