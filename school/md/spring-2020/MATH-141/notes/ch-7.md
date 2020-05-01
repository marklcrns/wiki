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

## 7.4 Complex Numbers Part II

## 7.5 Eulers Identity

## 7.6 Introduction To Vectors

## 7.7 Introduction To The Dot Product


<br>

# References

  - [Handout 27: Intro to Polar Coordinates](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-27.pdf)
  - [VIDEO: TRIGONOMETRY intro to POLAR COORDINATES](https://www.youtube.com/watch?v=6RmC_k4xBSk)
