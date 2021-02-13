---
title: Lecture 4
subtitle: Kinematics
author: Mark Lucernas
date: Feb 12, 2021
---


# Lecture 4: Kinematics

## 2.1 Position, Displacement, and Average Velocity

### Motion

<a name="kinematics-term">**Kinematics**</a>

- The classification and comparison of motions.

**Properties of Motion**

1. The motion is along a straight line only.
2. Forces (pushes and pulls) cause motion.
3. The moving object is either a **particle** or an object that moveds like
	 a particle.

### Position and Displacement

To locate an object means to find its position relative to some reference point,
ofthen the origin (or zero point) if an axis such as the x axis.

- **poisitive direction** is to the right
- **negativee directrion** is to the left

<a name="displacement-term">**Displacement**</a>

- A change from position $x_{1}$ to position $x_{2}$. 

$$
\Delta{x} = x_{2} - x_{1}
$$

A plus sign for a displacement need not be shown, but a minus sign must always
be shown. If we ignore the sign (and thus the direction) of a displace- ment, we
are left with the **magnitude** (or absolute value) of the displacement.  For
example, a displacement of $\Delta{x} = -4m$ has a magnitude of $4m$.

### Average Velocity and Average Speeed

Several quantities are associated with the phrase "how fast." One of them is the
**average velocity** $V_{avg}$ or ($\overline{a}$).

$$
V_{avg} = \frac{\Delta{x}}{\Delta{t}} = \frac{x_{2} - x_{1}}{t_{2} - t_{1}}
$$

**Average speed** $S_{avg}$ is a different way of describing "how fast"
a particle moves. Whereas the average velocity involves the particle's
displacement $\Delta{x}$, the average speed involves the total distance covered.

$$
S_{avg} = \frac{\text{total distance}}{\Delta{t}}
$$

> Average speed does _not_ include direction, it lacks any algebraic sign.


## 2.2 Instantaneous Velocity and Speed

### Instantaneous Velocity and Speed

The phrase "how fast" more commonly refers to how fast a particle is moving at
a given instant -- its **instantaneous velocity** (or simply **velocity)** $v$.

$$
v = \lim_{\Delta{t} \to 0} \frac{\Delta{x}}{\Delta{t}} = \frac{dx}{dt}
$$

> Note that $v$ is the rate at which position $x$ with respect to $t$. Also note
that $v$ at any instant is the slope of the position-time curve at the point
representing that instant.

**Speed** is the magnitude of velocity; that is, speed is velocity that has been
stripped of any indication of direction.


## 2.3 Acceleration

### Acceleration

When a particle's velocity changes, the particle is said to undergo
**acceleration**. For motion along an axis, the **average acceleration**
$a_{avg}$ over a time interval $\Delta{t}$ is

$$
a_{avg} = \frac{v_{2} - v_{1}}{t_{2} - t_{1}} = \frac{\Delta{v}}{\Delta{t}}
$$

where the particle has velocity $v_{1}$ at time $t_{1}$ and then velocity
$v_{2}$ at time $t_{2}$. The **instantaneous acceleration** (or simply
**acceleration**) is

$$
a = \frac{dv}{dt} = \frac{d^{2}x}{dt^{2}}
$$

**g Units.** Large accelerations are sometimes expressed in terms of g units (gravity),
with

$$
1g = 9.8m/s^{2}
$$


## 2.4 Constant Acceleration

The following five equations describe the motion of a particle with constant acceleration:

| Equation                                 | Missing Quantity |
|------------------------------------------|------------------|
| $v = v_{0} + a$                          | $x - x_{0}$      |
| $x - x_{0} = v_{0}t + \frac{1}{2}at^{2}$ | $v$              |
| $v^{2} = v_{0}^{2} + 2a(x - x_{0}$       | $t$              |
| $x - x_{0} = \frac{1}{2}(v_{0} + v)t$    | $a$              |
| $x - x_{0} = vt - \frac{1}{2}at^{2}$     | $v_{0}$          |

These are _note_ valid when the acceleration is not constant.

Another equation for constant acceleration through Integration

$$
x = v_{0}t + \frac{1}{2}at^{2} + C^{\prime}
$$


## 2.5 Free-Fall Acceleration

**Free-fall acceleration** is the downward acceleration at a certain constant
rate, and its magnitude is represented by $g$ (gravity), $9.8 m/s^{2}$.

- The directions of the motion is along a vertical $y$ axis instead of the $x$ axis,
	with the positive direction of $y$ upward.
- The free-fall acceleration is negative, that is, downward on the $y$ axis.


## Graphical Integration in Motion Analysis

On a graph of acceleration $a$ versus time $t$, the change in the velocity is
given by

$$
v_{1} - v_{0} = \int_{t_{0}}^{t_{1}} a\;dt
$$

On a graph of velocity $v$ versus time $t$, the change in the position is given
by

$$
x_{1} - x_{0} = \int_{t_{0}}^{t_{1}} v\;dt
$$


## Video Lectures

- [⬇ Lecture 4.1](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.1.pdf)
- [⬇ Lecture 4.1 Clean](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.1_clean.pdf)
- [⬇ Lecture 4.2](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.2.pdf)
- [⬇ Lecture 4.2 Clean](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.2_clean.pdf)
- [📺 Lecture 4.1 Part 1](https://drive.google.com/file/d/1APFYIbEFyxzcmFMqljqQMYBRQWaX2Nyc/view?usp=sharing)
- [📺 Lecture 4.1 Part 2](https://drive.google.com/file/d/14ZJyfvN2-f-S0frohQLHNER3ym0Ah08t/view?usp=sharing)
- [📺 Lecture 4.1 Part 3](https://drive.google.com/file/d/1C0Ubm41nujzieApezR9ZEiyjJMo-j5XN/view?usp=sharing)
- [📺 Lecture 4.2 Part 1](https://drive.google.com/file/d/1Ls9oy7qtmKCXqdpX6XF-7CKsn3OG_NfZ/view?usp=sharing)
- [📺 Lecture 4.2 Part 2](https://drive.google.com/file/d/1qYT5847woAA6vW7mMXEB7Hxcqe4DfW8w/view?usp=sharing)
- [📺 Lecture 4.2 Part 3](https://drive.google.com/file/d/1GhnGQwtfn9lCnSxUYzlFy194_39SpFoH/view?usp=sharing)

<br>

# Resources

- [⬇ Lecture 4.1](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.1.pdf)
- [⬇ Lecture 4.1 Clean](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.1_clean.pdf)
- [⬇ Lecture 4.2](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.2.pdf)
- [⬇ Lecture 4.2 Clean](file:../../../../files/winter-2021/PHYS-195/lectures/lecture4.2_clean.pdf)
- [📺 Lecture 4.1 Part 1](https://drive.google.com/file/d/1APFYIbEFyxzcmFMqljqQMYBRQWaX2Nyc/view?usp=sharing)
- [📺 Lecture 4.1 Part 2](https://drive.google.com/file/d/14ZJyfvN2-f-S0frohQLHNER3ym0Ah08t/view?usp=sharing)
- [📺 Lecture 4.1 Part 3](https://drive.google.com/file/d/1C0Ubm41nujzieApezR9ZEiyjJMo-j5XN/view?usp=sharing)
- [📺 Lecture 4.2 Part 1](https://drive.google.com/file/d/1Ls9oy7qtmKCXqdpX6XF-7CKsn3OG_NfZ/view?usp=sharing)
- [📺 Lecture 4.2 Part 2](https://drive.google.com/file/d/1qYT5847woAA6vW7mMXEB7Hxcqe4DfW8w/view?usp=sharing)
- [📺 Lecture 4.2 Part 3](https://drive.google.com/file/d/1GhnGQwtfn9lCnSxUYzlFy194_39SpFoH/view?usp=sharing)

Textbook

+ [⬇ Fundamentals of Physics 10th Edition](file:../../../../files/winter-2021/PHYS-195/FundamentalsOfPhysics_10thEdition.pdf)
