---
title: MATH 141 Chapter 7 Notes
author: Mark Lucernas
date: 2020-04-29
summary: Misc Topics
---

# Chapter 7: Misc Topics

## 7.1 Polar Coordinates Intro

  - [Handout 27: Intro to Polar Coordinates](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-27.pdf)
  - [Handout 28: Chapter 7 Review](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-28.pdf)
  - [Handout 29: Euler's Identity: Solutions to some exercises](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-29.pdf)

### Video Lecture

  - [VIDEO: TRIGONOMETRY intro to POLAR COORDINATES](https://www.youtube.com/watch?v=6RmC_k4xBSk)

#### Video Lecture Notes

Polar coordinate system

  - $(r, \theta)$, where $r$ as the _radius_ and $\theta$ as the _angle_ form
    the origin.


## 7.2 Polar Graphs

- [Handout 30: Converting Equations Polar & Cartesian](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-30.pdf)

``` {.Rplot}
x <- seq(-pi, pi, 0.1)
plot(x, sin(x),
main="The Sine Function",
ylab="sin(x)")
```

### Video Lecture 1

  - [VIDEO 1: Polar graphs intro](https://www.youtube.com/watch?v=u_Y7V5CSCcc)

#### Video Lecture 1 Notes

  - Plotting points [(3:04)](https://www.youtube.com/watch?v=u_Y7V5CSCcc&t=184)

  - To get the shape of a polar equation, for example $r = 7 + 10\cos(\theta)$,
    plot the $0^{\circ}, 90^{\circ}, 180^{\circ}, 270^{\circ}$ [(10:58)](https://www.youtube.com/watch?v=u_Y7V5CSCcc&t=658)

  - $-1 \ge \sin(\theta) \le 1$ [(17:40)](https://www.youtube.com/watch?v=u_Y7V5CSCcc&t=1060)
  - $-1 \ge \cos(\theta) \le 1$ [(25:14)](https://www.youtube.com/watch?v=u_Y7V5CSCcc&t=1514)

### Video Lecture 2

  - [VIDEO 2: TRIGONOMETRY intro to POLAR equations converting](https://www.youtube.com/watch?v=eWFJo--R8w4)

#### Video Lecture 2 Notes

Converting Cartesian to Polar Coordinates

| $x$           | $r\cos(\theta)$          |
|---------------|--------------------------|
| $y$           | $r\sin(\theta)$          |
| $r^{2}$       | $x^{2} + y^{2}$          |
| $r$           | $\sqrt{x^{2} + y^{2}}$   |
| $\theta$      | $\tan^{-1}(\frac{y}{x})$ |
| $\frac{y}{x}$ | $\tan(\theta)$           |

Examples of Cartesian to Polar

  - $y = x^{2}$ [(3:07)](https://www.youtube.com/watch?v=eWFJo--R8w4&t=187)
    * $r\sin(\theta) = r^{2}\cos^{2}(\theta)$
  - $r = 5$ [(4:41)](https://www.youtube.com/watch?v=eWFJo--R8w4&t=281)
    * $x^{2} + y^{2} = 25$

Examples of Polar to Cartesian

  - $r = 6\cos(\theta)$ [(5:52)](https://www.youtube.com/watch?v=eWFJo--R8w4&t=352)
    * ${\color{#ff0000}{r}} \cdot r = {\color{#ff0000}{r}} \cdot 6\cos(\theta)$
    * $r^{{\color{#ff0000}{2}}} = 6 \cdot r\cos(\theta)$
    * ${\color{#ff0000}{x^{2} + y^{2}}} = 6{\color{#ff0000}{x}}$
  - $\theta = 2.5$ [(10:13)](https://www.youtube.com/watch?v=eWFJo--R8w4&t=613)
    * ${\color{#ff0000}{\tan(}}\theta{\color{#ff0000}{)}} = {\color{#ff0000}{\tan(}}2.5{\color{#ff0000}{)}}$
    * ${\color{#ff0000}{\frac{y}{x}}} = \tan(2.5)$
    * $y = \tan(2.5) \cdot {\color{#ff0000}{x}}$


## 7.3 Complex Numbers Intro

  - [Handout 31: Intro to Complex Numbers exercises v1](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-31.pdf)
  - [Handout 32: Intro to Complex Numbers exercises v2](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-32.pdf)


### Video Lecture

  - [VIDEO: INTRODUCTION To complex numbers](https://www.youtube.com/watch?v=rShl_0B72To)

#### Video Lecture Notes

|           |               |
| :-------: | :-----------: |
| $i$       | $i$           |
| $i^{2}$   | $\text{-}1$   |
| $i^{3}$   | $\text{-}i$   |
| $i^{4}$   | $1$           |
| $i^{5}$   | $i$           |
| $i^{6}$   | $\text{-}1$   |
| $i^{7}$   | $\text{-}i$   |
| $i^{8}$   | $1$           |
| $i^{9}$   | $i$           |
| ...       | ...           |

$$
\begin{aligned}
i^{103} &= i^{100} \cdot i^{3} \\
 &= (i^{4})^{25} \cdot \\
 &= i^{25} \cdot i^{3} \\
 &=  1 \cdot i^{3} \\
 &= -i
\end{aligned}
$$

Using Conjugates

  - $(3 + 2i)(3 - 2i)$ [(13:27)](https://www.youtube.com/watch?v=rShl_0B72To&t=807)
  - $\dfrac{3}{2 + 5i}$ [(19:32)](https://www.youtube.com/watch?v=rShl_0B72To&t=1172)


<a name="conjugates-term">**Conjugates**</a>

  - Two binomials with all terms are identical except for the sign in between
    two terms of the binomial are opposite.
  - Only works for $+$ and $-$ sign.


## 7.4 Complex Numbers Part II

  - [Handout 33: More on Complex Numbers exercises v1](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-33.pdf)
  - [Handout 34: More on Complex Numbers exercises v2](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-34.pdf)


### Video Lecture

  - [VIDEO: Converting to Euler form of complex number](https://www.youtube.com/watch?v=IoOKpGrL0RQ)

#### Video Lecture Notes

  - $i = e^{i \cdot 90^{\circ}}$ [(21:26)](https://www.youtube.com/watch?v=IoOKpGrL0RQ&t=1286)
  - $0 = e^{i\p} + 1$

<a name="euler's-identity-term">**Euler's identity**</a>

  - $e^{i\theta} = \cos(\theta) + i\sin(\theta)$


> Euler's uses **RADIANS** instead of degrees


Converting complex numbers to Euler form

  - $3 + 2i \to re^{i\theta}$ [(14:53)](https://www.youtube.com/watch?v=IoOKpGrL0RQ&t=893)


Converting numbers to complex numbers

  - $-1 \to \mathbb{C}$ (Complex number) [(22:40)](https://www.youtube.com/watch?v=IoOKpGrL0RQ&t=1360)

## 7.5 Eulers Identity

## 7.6 Introduction To Vectors

## 7.7 Introduction To The Dot Product


<br>

# References

  - [Handout 27: Intro to Polar Coordinates](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-27.pdf)
  - [Handout 28: Chapter 7 Review](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-28.pdf)
  - [Handout 29: Euler's Identity: Solutions to some exercises](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-29.pdf)
  - [VIDEO: TRIGONOMETRY intro to POLAR COORDINATES](https://www.youtube.com/watch?v=6RmC_k4xBSk)
  - [Handout 30: Converting Equations Polar & Cartesian](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-30.pdf)
  - [VIDEO 1: Polar graphs intro](https://www.youtube.com/watch?v=u_Y7V5CSCcc)
  - [VIDEO 2: TRIGONOMETRY intro to POLAR equations converting](https://www.youtube.com/watch?v=eWFJo--R8w4)
  - [Handout 31: Intro to Complex Numbers exercises v1](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-31.pdf)
  - [Handout 32: Intro to Complex Numbers exercises v2](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-32.pdf)
  - [VIDEO: INTRODUCTION To complex numbers](https://www.youtube.com/watch?v=rShl_0B72To)
  - [Handout 33: More on Complex Numbers exercises v1](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-33.pdf)
  - [Handout 34: More on Complex Numbers exercises v2](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-34.pdf)
  - [VIDEO: Converting to Euler form of complex number](https://www.youtube.com/watch?v=IoOKpGrL0RQ)
