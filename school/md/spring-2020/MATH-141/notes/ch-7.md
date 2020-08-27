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
  - $\theta = 2.5$ [(10:13)](https://www.youtube.com/watch?v=eWFJo--R8w4&t=613)


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

<a name="conjugates-term">**Conjugates**</a>

  - Two binomials with all terms are identical except for the sign in between
    two terms of the binomial are opposite.
  - Only works for $+$ and $-$ sign.


Using Conjugates

  - $(3 + 2i)(3 - 2i)$ [(13:27)](https://www.youtube.com/watch?v=rShl_0B72To&t=807)
  - $\dfrac{3}{2 + 5i}$ [(19:32)](https://www.youtube.com/watch?v=rShl_0B72To&t=1172)


## 7.4 Complex Numbers Part II

  - [Handout 33: More on Complex Numbers exercises v1](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-33.pdf)
  - [Handout 34: More on Complex Numbers exercises v2](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-34.pdf)


### Video Lecture

  - [VIDEO: Converting to Euler form of complex number](https://www.youtube.com/watch?v=IoOKpGrL0RQ)

#### Video Lecture Notes

  - $i = e^{i \cdot 90^{\circ}}$ [(21:26)](https://www.youtube.com/watch?v=IoOKpGrL0RQ&t=1286)
  - $0 = e^{i \pi} + 1$

<a name="euler's-identity-term">**Euler's identity**</a>

  - $e^{i\theta} = \cos(\theta) + i\sin(\theta)$


> Euler's uses **RADIANS** instead of degrees


Converting complex numbers to Euler form

  - $3 + 2i \to re^{i\theta}$ [(14:53)](https://www.youtube.com/watch?v=IoOKpGrL0RQ&t=893)


Converting numbers to complex numbers

  - $-1 \to \mathbb{C}$ (Complex number) [(22:40)](https://www.youtube.com/watch?v=IoOKpGrL0RQ&t=1360)

## 7.5 Eulers Identity

  - [Handout 35: Converting Complex numbers From and To EULER FORM](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-35.pdf)
  - [Handout 36: Euler's Identity](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-36.pdf)


### Video Lecture

  - [VIDEO: Euler's Identity Part 2 Introduction](https://www.youtube.com/watch?v=mrADnifzTy0)

#### Video Lecture Notes

Converting complex numbers in standard form to Euler form and...

Multiplying:

  - $(3 + 2i)(1 + 2i)$ [(1:00)](https://www.youtube.com/watch?v=mrADnifzTy0&t=60)
  - $(\frac{1}{2} + \frac{\sqrt{3}}{2}i)(\frac{\sqrt{3}}{2} + \frac{1}{2}i)$ [(3:26)](https://www.youtube.com/watch?v=mrADnifzTy0&t=206)


> Multiplying numbers with exponents with the same base: add the exponents
together and copy the base.

Dividing:

  - $\dfrac{(3 + 2i)}{(1 + 2i)}$ [(6:14)](https://www.youtube.com/watch?v=mrADnifzTy0&t=374)


> Dividing numbers with exponents with the same base: subtract the exponents
from the subtrahend and copy the base.

Dealing with Complex numbers in standard form with powers:

  - $(3 + 2i)^{10}$ [(10:05)](https://www.youtube.com/watch?v=mrADnifzTy0&t=605)


Dealing with roots of complex numbers:

  - $\sqrt{i} = e^{90^{\circ}i}$ [(14:10)](https://www.youtube.com/watch?v=mrADnifzTy0&t=850)


Roots of unity [(20:00)](https://www.youtube.com/watch?v=mrADnifzTy0&t=1200)

### Daabz Questions

  - $[4e^{i(180^{\circ})}]^{\frac{1}{7}}$
    * $4^{\frac{1}{7}}e^{i(\frac{180^{\circ}}{7})}$
    * $\sqrt[7]{4}e^{i(\frac{180^{\circ}}{7})}$
  - Suppose $-7 + -2i = re^{i\theta}$
    * $\tan(\theta) = \frac{-2}{-7}$
    * $r^{2} = (-7)^{2} + (-2)^{2}$
  - $\sqrt[3]{[9\cos(-180^{\circ}) + i9\sin(-180^{\circ})]}$
    * $\sqrt[3]{9}[\cos(\frac{-180^{\circ}}{3}) + i\sin(\frac{-180^{\circ}}{3}))]$
    * $\sqrt[3]{9}^{i(\frac{-180^{\circ}}{3})}$
    * $9^{\frac{1}{3}}e^{(\frac{-180^{\circ}}{3})}$
  - $9e^{i(-270^{\circ})} \cdot 2e^{i(-180^{\circ})}$
    * $18\cos(-450^{\circ}) + i18\sin(-450^{\circ})$
    * $(9 \cdot 2) \cdot e^{i(-270^{\circ} + (-180^{\circ}))}$
  - $\frac{4\cos(-120^{\circ}) + i4\sin(-120^{\circ})}{5\cos(240^{\circ}) + i5\sin(240^{\circ})}$
    * $\frac{4}{5}\cos(-120^{\circ} - 240^{\circ}) + i\frac{4}{5}\sin(-120^{\circ} - 240^{\circ})$
    * $\frac{4}{5}\cos(-360^{\circ}) + i \cdot \frac{4}{5}\sin(-360^{\circ})$
  - $\sqrt[7]{3e^{i(330^{\circ})}}$
    * $3^{\frac{1}{7}}e^{i(\frac{330^{\circ}}{7})}$
  - $\frac{5e^{i(210^{\circ})}}{8e^{i(-150^{\circ})}}$
    * $\frac{5}{8}\cos(360^{\circ}) + i \cdot \frac{5}{8}\sin(360^{\circ})$
    * $\frac{5}{8}\cos(210^{\circ}- (-150^{\circ}) + i\frac{5}{8}\sin(210^{\circ}) - (-150^{\circ}))$


## 7.6 Introduction To Vectors

  - [Handout 37: Vectors Introduction](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-37.pdf)


### Video Lecture

  - [VIDEO: Introduction to Vectors](https://www.youtube.com/watch?v=PObj5z__5yQ)


#### Video Lecture Notes

<a name="vector-term">**Vector**</a>

  - Represents **direction** and **size/magnitude**.
  - Adding/Subtracting Vectors [(5:00)](https://www.youtube.com/watch?v=PObj5z__5yQ&t=300)
  - Scalars [(10:50)](https://www.youtube.com/watch?v=PObj5z__5yQ&t=650)
    * Scaling the size (flip direction if negative) of a vector
  - Magnitude, Normalize a Vector [(14:07)](https://www.youtube.com/watch?v=PObj5z__5yQ&t=847)
    * Size of the hypotenuse that the vectors make
    * Use pythagorean to get the magnitude
    * Denoted by $\|\vec{V}\|$, where $\vec{V}$ as the vector and $\|\|$ as the
      magnitude of the vector.
    * **Normalized/Unit vector** is a vector that has a magnitude exactly
      equals to 1.
      + $N_{\vec{v}}$ Can be computed as $\dfrac{1}{\|\vec{v}\|}\vec{v}$
      + $N_{\vec{v}}$ only changes the magnitude, therefore, $N_{\vec{v}}$ has
        the same direction as $\vec{v}$


## 7.7 Introduction To The Dot Product

  - [Handout 38: Introduction to the Dot Product](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-38.pdf)


Some famous Dot Product properties

  - $u \cdot v = v \cdot u$
  - $(u + w) \cdot v = u \cdot v + w \cdot v$
  - $u \cdot (cv) = c(u \cdot v)$
  - $u \cdot u \ge 0$
  - $u \cdot u = 0 \Longleftrightarrow u = 0$


### Video Lecture

  - [VIDEO: Intro to Dot Product Full Lecture](https://www.youtube.com/watch?v=VvoUzq6NLr8)

#### Video Lecture Notes

  - $\langle {\color{#ff0000}{1}}, {\color{#00ff00}{5}}, {\color{#0000ff}{0}} \rangle \cdot \langle {\color{#ff0000}{3}}, {\color{#00ff00}{1}}, {\color{#0000ff}{-5}} \rangle$
    * multiply each, ${\color{#ff0000}{3}} + {\color{#00ff00}{5}} + {\color{#0000ff}{0}}$
    * $8$


Magnitude by Dot [(10:35)](https://www.youtube.com/watch?v=VvoUzq6NLr8&t=635)

  - $\|\vec{v}\|^{2} = \vec{v} \cdot \vec{v}$


Distance by Dot

  - $\|\vec{w} - \vec{v}\|^2 = (\vec{w} - \vec{v}) \cdot (\vec{w} - \vec{v})$
  - $\|\vec{w} - \vec{v}\| = \sqrt{(\vec{w} - \vec{v}) \cdot (\vec{w} - \vec{v})}$


Angle between by Dot [(15:34)](https://www.youtube.com/watch?v=vvoUzq6NLr8&t=934)

  - $\cos(\theta) = \dfrac{\vec{v} \cdot \vec{w}}{\|\vec{v}\| \|\vec{w}\|}$


Perpendicular $\perp$ Test by Dot [(24:24)](https://www.youtube.com/watch?v=vvoUzq6NLr8&t=1464)

  - If the **Dot Product is zero**, its **perpendicular**
  - $\vec{v} \perp \vec{w} \Longleftrightarrow \vec{v} \cdot \vec{w} = 0$


Projections by Dot [(28:30)](https://www.youtube.com/watch?v=vvoUzq6NLr8&t=1710)

  - $proj_{\vec{w}}\vec{v} = \dfrac{\vec{v} \cdot \vec{w}}{\|\vec{w}\| \|\vec{w}\|} \cdot \vec{w}$


## Comprehensive Review

### Daabz Questions

  - If the equation of a graph is modified by replacing $x \to 5x -12$, the
    consequences on the graph are
    * shift RIGHT 12 then SCALE $x$'s by $\frac{1}{5}$
  - If the equation of a graph is modified by replacing $y \to 3y -8$, the
    consequences on the graph are
    * shift UP 8 then SCALE $y$'s by $\frac{1}{3}$
  - $\dfrac{\tan(A) - \tan(B)}{1 + \tan(A)\tan(B)}$
    * $\tan(A - B)$
  - $\cot(x)$
    * $\tan(\frac{\pi}{2} - x)$
  - One solution to the equation $0 = \sin(x) is 0$
    * $x = 0 + \pi$
    * $x = \pi$
  - $\cos^{2}(x)$ can be exchanged for
    * $1 - \dfrac{1}{\csc()^{2}(x)}$
  - One slution to the equation $-1 = \sin(x)$ is $-\frac{1}{2}\pi$, What is the
    NEXT real solution to the right?
    * $x = \frac{3}{2}\pi$
    * $x = -\frac{1}{2}\pi + 2\pi$
  - $\frac{d}{dx}[\cos(x)]$
    * $-\sin(x)$
  - $\cos(x)$ can be exchanged for
    * $-\sin(\frac{\pi}{2} - x)$
  - $\sin(2x)$ can be exchanged for
    * $2\sin(x)\cos(x)$

<br>

# Resources

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
  - [Handout 35: Converting Complex numbers From and To EULER FORM](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-35.pdf)
  - [Handout 36: Euler's Identity](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-36.pdf)
  - [VIDEO: Euler's Identity Part 2 Introduction](https://www.youtube.com/watch?v=mrADnifzTy0)
  - [Handout 37: Vectors Introduction](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-37.pdf)
  - [VIDEO: Introduction to Vectors](https://www.youtube.com/watch?v=PObj5z__5yQ)
  - [Handout 38: Introduction to the Dot Product](file:../../../../files/spring-2020/MATH-141/ch-7/ch-7_handout-38.pdf)
  - [VIDEO: Intro to Dot product Full Lecture](https://www.youtube.com/watch?v=VvoUzq6NLr8)
