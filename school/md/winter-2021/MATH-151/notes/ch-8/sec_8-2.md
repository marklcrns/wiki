---
title: Section 8.2
subtitle: Integration by Parts
author: Mark Lucernas
date: Feb 22, 2021
---


# Section 8.2: Integration by Parts

## Integration by Parts for Indefinite Integrals

Suppose $u$ and $v$ are differentiable functions. Then

$$
\int u\;dv = uv - \int v\;du
$$

![Example 1](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-1.png)
![Example 2](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-2.png)
![Example 3.1](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-3.1.png)
![Example 3.2](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-3.2.png)
![Example 4](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-4.png)

### Tips for Choosing $u$ When Integrating by Parts

Use the acronym "LIPET" to help choosing the value when substituting for $u$.

- **L**ogarithmic -- e.g. $\ln(x)$
- **I**nverse Trigonometric -- e.g. $\tan^{-1}(x)$
- **P**olynomial -- e.g. $x^{2}$
- **E**xponential -- e.g. $e^{x}$
- **T**rigonometric -- e.g. $\cos(x)$

to prioritize choosing $u$ in the order of **LIPET**, **L** being the first
priority and **T** being the last.


## Integration by Parts for Definite Integrals

Let $u$ and $v$ be differentiable. Then

$$
\int_{a}^{b} u(x)v^{\prime}(dx)\;dx = \left . u(x)v(x) \right |_{a}^{b} - \int_{a}^{b} v(x)u^{\prime}(x)\;dx
$$

![Example 5](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-5.png)

### Integral of $\ln(x)$

$$
\ln(x)\;dx = x\ln(x) - x + C
$$

![Example 6.1](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-6.1.png)
![Example 6.2](../../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-2_example-6.2.png)


## External Video Lectures

[📺 Using integration by parts](https://www.khanacademy.org/math/ap-calculus-bc/bc-integration-new/bc-6-11/v/deriving-integration-by-parts-formula)

<br>

# Resources

- [📺 Using integration by parts](https://www.khanacademy.org/math/ap-calculus-bc/bc-integration-new/bc-6-11/v/deriving-integration-by-parts-formula)

Textbook

+ Calculus, Early Transcendentals 3rd Edition - Briggs, Cochran, and Gillet
