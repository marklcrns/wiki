---
title: Lecture 3
subtitle: Vectors
author: Mark Lucernas
date: Feb 02, 2021
---


# Lecture 3: Vectors

## My Notes

### Scalars and Vectors

<a name="scalar-term">**Scalar**</a>

- a quantity that has only magnitude (size, amount, #), **but no direction**.
- Ex: volume, length, distance, mass, time, speed

<a name="vector-term">**vector**</a>

- a quantity that has both magnitude and direction.
- Ex: Force, displacement, velocity, acceleration, magnetic field

| Scalar              | Vector                                   |
|---------------------|------------------------------------------|
| distance = 100 feet | displacement = 100 feet $\angle{}$ east  |
| speed = 3 mph       | velocity = 3 mph $\angle{}$ east         |
| mass = 20 kg        | force = 8 pounds $\angle{}$ $20^{\circ}$ |

> **NOTE:** A vector $\vec{A}$ is represented by an arrow of certain length
(magnitude) & orientation (direction).

#### Vector Addition

Displacement is the Vector sum, AKA the **Resultant**

$$
\vec{R} \text{ (Resultant) } = \vec{A} + \vec{B}
$$

<a name="displacement-term">**displacement**</a>

- The change in position.
- Vector

<a name="distance-term">**distance**</a>

- Length of the path taken by an object.
- Scalar

**Method 1: Head-to-tail**

Calculating displacement is like calculating for the hypotenuse: $\vec{R}
= \sqrt{\vec{A}^{2} + \vec{B}^{2}}$

> A negative vector $-\vec{A}$ is the same as a positive vector $\vec{A}$ but in
the opposite direction

> **NOTE:** we can add (or subtract) only vectors of the same kind. For example,
we can add two displacements, or two velocities, but adding a displacement and
velocity makes no sense.

**Method 2: Tail-to-tail**

Make a parallelogram and $\vec{A} + \vec{B}$ is the body diagonal or the
resultant $\vec{R}$

**Method 3: Component (Algebraic) Method**

$$
\begin{aligned}
\vec{A} &= A_{x}\hat{x} + A_{y}\hat{y} \\
\vec{B} &= B_{x}\hat{x} + B_{y}\hat{y} \\
\end{aligned}
$$

Just simply add $A_{x}\hat{x} + B_{x}\hat{x}$ and $B_{x}\hat{x} + B_{y}\hat{y}$.

$$
\vec{R} = \vec{A} + \vec{B} = (A_{x}\hat{x} + B_{x}\hat{x}) + (A_{y}\hat{y} + B_{y}\hat{y})
$$


#### Vector Subtraction

**Method 1**

$$
\vec{R} = \vec{A} - \vec{B} \\
\text{or} \\
\vec{R} = \vec{A} + (-\vec{B})
$$

#### Components of Vectors

<a name="Component-term">**component**</a>

- A component of a vector is the projection of the vector on an axis. e.g., the
	x and y component along an axis.
- A component of a vector has the same direction (along an axis) as the vector:
	negative vector has an opposite direction.

<a name="resolving-the-vector-term">**Resolving the vector**</a>

- The process of finding the component of a vector.


#### Unit Vectors

<a name="unit-vector-term">**Unit Vector**</a>

- is a vector that has a magnitude of exactly 1 and points in a particular
	direction.
- It lacks both dimension and unit. Its sole purpose is to point, that is to
	specify a direction.
- Unit vectors in the positive direction of the x, y, and z axes are labeled as
	$\hat{i}$, $\hat{j}$, or $\hat{k}$.

Examples

$$
\vec{a} = a_{x}\hat{i} + a_{y}\hat{j} \\
\vec{b} = b_{x}\hat{i} + b_{y}\hat{j}
$$

#### Vector Multiplication

##### Multiply a Vector by a Scalar

Multiplying a Vector by a Scalar If we multiply a vector $\vec{a}$ by a scalar
$s$, we get a new vector. Its magnitude is the product of the magnitude of
$\vec{a}$ and the absolute value of $s$. Its direction is the direction of
$\vec{a}$ if $s$ is positive but the opposite direction if $s$ is negative. To
divide $\vec{a}$ by $s$, we multiply $\vec{a}$ by $1/s$.

##### Multiplying a Vector by a Vector

There are two ways to multiply a vector by a vector: one way produces a scalar
(called the _scalar_ product), and the other produces a new vector (called the
_vector_ product).

<a name="scalar-product-term">**Scalar product**</a>

$$
\vec{a} \cdot \vec{b} = ab\cos(\phi)
$$

where a is the magnitude of $\vec{a}$, b is the magnitude of $\vec{b}$, and
$\phi$ is the angle between $\vec{a}$ and $\vec{b}$ (or, more properly, between
the directions of $\vec{a}$ and $\vec{b}$ ). There are actually two such angles:
$\phi$ and $360^{\circ}	- \phi$.

Note that there are only scalars on the right side. Thus $\vec{a} \cdot \vec{b}$
on the left side represents a _scalar_ quantity. Because of the notation,
$\vec{a} \cdot \vec{b}$ is also known as the **dot product** and is spoken as "a
dot b."

> If the angle $\phi$ between two vectors is $0^{\circ}$, the component of one
vector along the other maximum, and so also is the dot product of the vectors.
If, instead, $\phi$ is $90^{\circ}$, the component of one vector along the other
is zero, and so is the dot product.

The equation can be rewritten as follows:

$$
\vec{a} \cdot \vec{b} = (a\cos(\phi))(b) = (a)(b\cos(\phi))
$$

Commutative law applies to a scalar product:

$$
\vec{a} \cdot \vec{b} = \vec{b} \cdot \vec{c}
$$

When two vectors are in unit-vector notation, we write their dot product as:

$$
\vec{a} \cdot \vec{b} = (a_{x}\hat{i} + a_{y}\hat{j} + a_{z}\hat{k}) \cdot (b_{x}\hat{i} + b_{y}\hat{j} + b_{z}\hat{k})
$$

which we can expand according to distributive law:

$$
\vec{a} \cdot \vec{b} = a_{x}b_{x} + a_{y}b_{y} + a_{z}b_{z}
$$

<a name="vector-product-term">**Vector product**</a>

$$
c = ab\sin(\phi)
$$

where $\phi$ is the smaller of the two angles between $\vec{a}$ and $\vec{b}$.
(You must use the smaller of the two angles between the vectors because
$\sin(\phi)$ and $sin(360^{\circ} - \phi)$ differ in algegraic sign.) Because of
the notation, $\vec{a} \times \vec{b}$ is also known as the **cross product**,
and in speech it is "a cross b".

> If $\vec{a}$ and $\vec{b}$ are parallel or antiparallel, $\vec{a} \times
\vec{b} = 0$. The magnitude of $\vec{a} \times \vec{b}$, which can be written as
$\left | \vec{a} \times \vec{b} \right |$, is maximum when $\vec{a}$ and
$\vec{b}$ are perpendicular to each other.

Commutative law does not apply to a vector product.

In unit-vector notation, we write:

$$
\vec{a} \times \vec{b} = (a_{x}\hat{i} + a_{y}\hat{j} + a_{z}\hat{k}) \times
(b_{x}\hat{i} + b_{y}\hat{j} + b_{z}\hat{k})
$$

which can be expanded according to the distributive law:

$$
a_{x}\hat{i} \times b_{x}\hat{i} = a_{x}b_{x}(\hat{i} \times \hat{i}) = 0,
$$

because the two unit vectors $\hat{i}$ and $\hat{i}$ are parallel and thus have
a zero cross product. Similarly, we have

$$
a_{x}\hat{i} \times b_{y}\hat{j} = a_{x}b_{y}(\hat{i} \times \hat{j}) = a_{x}b_{y}\hat{k}
$$

Continuing to expand:

$$
\vec{a} \times \vec{b} = (a_{y}b_{z} - b_{y}a_{z})\hat{i} + (a_{z}b_{x} - b_{z}a_{x})\hat{j} + (a_{x}b_{y} - b_{x}a_{y})\hat{k}
$$

- [📺 The dot product]()
- [📺 Dot vs. cross product](https://www.khanacademy.org/science/physics/magnetic-forces-and-magnetic-fields/electric-motors/v/dot-vs-cross-product)
- [📺 Calculating dot and cross products with unit vector notation](https://www.khanacademy.org/science/physics/magnetic-forces-and-magnetic-fields/electric-motors/v/calculating-dot-and-cross-products-with-unit-vector-notation)


## Video Lectures

- [⬇ Lecture 3](file:../../../../files/winter-2021/PHYS-195/lectures/lecture3.pdf)
- [⬇ Lecture 3 Clean](file:../../../../files/winter-2021/PHYS-195/lectures/lecture3_clean.pdf)
- [📺 Lecture 3 Part 1](https://drive.google.com/file/d/1Kbng4zR8iJw5Rt1GwBcjI-N9TI5dCVag/view?usp=sharing)
- [📺 Lecture 3 Part 2](https://drive.google.com/file/d/1jLlcpN0YcOU2cKDcK9UO1AYY0uKz5tv7/view?usp=sharing)
- [📺 Lecture 3 Part 3](https://drive.google.com/file/d/1eJ-BYS1UKg3_I5HmcL1KFD4grT4YTQcr/view?usp=sharing)
- [📺 Lecture 3 Part 4](https://drive.google.com/file/d/1gC5FKiTO5FtSgzqxWcQpswEP958LkRZS/view?usp=sharing)

<br>

# Resources

- [📺 The dot product]()
- [📺 Dot vs. cross product](https://www.khanacademy.org/science/physics/magnetic-forces-and-magnetic-fields/electric-motors/v/dot-vs-cross-product)
- [📺 Calculating dot and cross products with unit vector notation](https://www.khanacademy.org/science/physics/magnetic-forces-and-magnetic-fields/electric-motors/v/calculating-dot-and-cross-products-with-unit-vector-notation)
- [⬇ Lecture 3](file:../../../../files/winter-2021/PHYS-195/lectures/lecture3.pdf)
- [⬇ Lecture 3 Clean](file:../../../../files/winter-2021/PHYS-195/lectures/lecture3_clean.pdf)
- [📺 Lecture 3 Part 1](https://drive.google.com/file/d/1Kbng4zR8iJw5Rt1GwBcjI-N9TI5dCVag/view?usp=sharing)
- [📺 Lecture 3 Part 2](https://drive.google.com/file/d/1jLlcpN0YcOU2cKDcK9UO1AYY0uKz5tv7/view?usp=sharing)
- [📺 Lecture 3 Part 3](https://drive.google.com/file/d/1eJ-BYS1UKg3_I5HmcL1KFD4grT4YTQcr/view?usp=sharing)
- [📺 Lecture 3 Part 4](https://drive.google.com/file/d/1gC5FKiTO5FtSgzqxWcQpswEP958LkRZS/view?usp=sharing)

Textbook

+ [⬇ Fundamentals of Physics 10th Edition](file:../../../../files/winter-2021/PHYS-195/FundamentalsOfPhysics_10thEdition.pdf)
