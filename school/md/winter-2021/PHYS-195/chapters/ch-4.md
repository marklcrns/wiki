---
title: Chapter 4
subtitle: Motion in Two and Three Dimensions
author: Mark Lucernas
date: Feb 16, 2021
---


# Chapter 4: Motion in Two and Three Dimensions

## 4.1 Position and Displacement

**Position vector** $\vec{r}$ can be written in unit-vector notation

$$
\vec{r} = x\hat{i} + y\hat{j} + z\hat{k}
$$

**Displacement** $\vec{r}$

$$
\Delta{\vec{r}} = \vec{r}_{2} - \vec{r}_{1} \\
~\\
\text{or as} \\
~\\
\begin{aligned}
\Delta{\vec{r}} &= (x_{2} - x_{1})\hat{i} + (y_{2} - y_{1})\hat{j} + (z_{2} - z_{1})\hat{k} \\
	 &= \Delta{x}\hat{i} + \Delta{y}\hat{j} + \Delta{z}\hat{k} \\
\end{aligned}
$$


## 4.2 Average Velocity and Instantaneous Velocity

**Average velocity** $\vec{V}_{avg}$

$$
\begin{aligned}
\vec{V}_{avg} &= \frac{\Delta{\vec{r}}}{\Delta{t}} \\
	 &= \frac{\Delta{x}\hat{i} + \Delta{y}\hat{j} \Delta{z}\hat{k}}{\Delta{t}} \\
\end{aligned}
$$

**Instantanous velocity** $\vec{v}$

$$
\vec{v} = \frac{d\vec{r}}{dt}
$$

> **NOTE:** The direction of the instantaneous velocity $\vec{v}$ of a particle
is always tangent to the particle's path at the particle's position.


## 4.3 Average Acceleration and Instantaneous Acceleration

**Average acceleration** $\vec{a}_{avg}$

$$
\vec{a}_{avg} = \frac{\vec{v}_{2} - \vec{v}_{1}}{\Delta{t}} = \frac{\Delta{\vec{v}}}{\Delta{t}}
$$

**Instantaneous acceleration** $\vec{a}$

$$
\vec{a} = \frac{d\vec{v}}{dt}
$$


## 4.4 Projectile Motion

A particle moves in a vertical plane with some initial velocity $\vec{v}_{0}$
but its acceleration is always the free-fall acceleration $\vec{g}$, which is
downward. Such a partical is called **projectile**, and its motion is called
**projectile motion**

### Two Golf Balls

the golf balls have the same vertical motion, both falling through the same
vertical distance int the same interval of time. _The fact that one ball is
moving horizontally while it is falling has no effect on its vertical motion_;
that is, the horizontal and vertical motions are independent of each other.

### The Horizontal Motion

$$
x - x_{0} = (v_{0}\cos(\theta)_{0})t
$$

### The Vertical Motion

$$
\begin{aligned}
y - y_{0} &= (v_{0}\sin(\theta)_{0})t - \frac{1}{2}gt^{2}, \\
v_{y} &= v_{0}\sin(\theta)_{0} - gt, \\
v_{y}^{2} &= (v_{0}\sin(\theta)_{0})^{2} - 2g(y - y_{0}). \\
\end{aligned}
$$

### The Equation of the Path

The projectile's path, also called **trajectory**.

$$
y = (\tan(\theta)_{0})x - \frac{gx^{2}}{2(v_{0}\cos(\theta)_{0})^{2}}
$$

### The Horizontal Range

The _horizontal range_ $R$ of the projectile is the _horizontal_ distance the
projectile has traveled when it returns to its initial height

$$
R = \frac{v_{0}^{2}}{g}\sin(2\theta)_{0}
$$

> **NOTE:** The horizontal range $R$ is maximum for a launch angle of
$45^{\circ}$. However, when the launch and landing heights differ, $45^{\circ}$
does not yield the maximum horizontal distance.


## External Resources

[📄 Two-dimensional motion](https://www.khanacademy.org/science/physics/two-dimensional-motion#two-dimensional-projectile-mot)

<br>

# Resources

- [📄 Two-dimensional motion](https://www.khanacademy.org/science/physics/two-dimensional-motion#two-dimensional-projectile-mot)

Textbook

+ [⬇ Fundamentals of Physics 10th Edition](file:../../../../files/winter-2021/PHYS-195/FundamentalsOfPhysics_10thEdition.pdf)
