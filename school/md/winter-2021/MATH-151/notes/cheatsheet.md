---
title: Cheatsheet
subtitle: Formulas, Common Identities, Properties, and more
author: Mark Lucernas
date: Feb 24, 2021
---


# Formulas

## Integration

### Length of a Curve

$$
L = \int_{a}^{b} \sqrt{1 + f^{\prime}(x)^{2}}\;dx
$$

### Area Between Curves

$$
A = \int_{a}^{b} \left | f(x) - g(x) \right |\;dx
$$

### Volume

#### Disk Method (about $x$-axis)

$$
V \int_{a}^{b} \pi f(y)^{2}\;dx
$$

#### Shell Method (about $y$-axis)

$$
V = \int_{a}^{b} 2 \pi xf(x)\;dx \;\;\; \text{ where } 0 \le a \le b
$$

### Reduction Formulas

$$
\begin{array}{ll}
	{\displaystyle \int x^{n}e^{ax}dx} = \dfrac{x^{n}e^{ax}}{a} - \dfrac{n}{a}{\displaystyle \int x^{n - 1}e^{ax}dx} & \text{ for } a \neq 0 \\
	~\\
	{\displaystyle \int \ln^{n}(x)dx} = x\ln^{n}(x) - n {\displaystyle \int \ln^{n - 1}(x)dx} \\
\end{array}
$$

Assume $n$ is a positive integer.

$$
\begin{array}{ll}
	{\displaystyle \int x^{n}\cos(ax)dx} = \dfrac{x^{n}\sin(ax)}{a} - \dfrac{n}{a}{\displaystyle \int x^{n - 1}\sin(ax)d} & \text{ for } a \neq 0 \\
	~\\
	{\displaystyle \int x^{n}\sin(ax)dx} = -\dfrac{x^{n}\cos(ax)}{a} + \dfrac{n}{a}{\displaystyle \int x^{n - 1}\cos(ax)d} & \text{ for } a \neq 0 \\
	~\\
	{\displaystyle \int \tan^{n}(x)\;dx} = \frac{\tan^{n - 1}(x)}{n - 1} - {\displaystyle \int \tan^{n - 2}(x)\;dx} & \text{ for } n \neq 1 \\
	~\\
	{\displaystyle \int \sec^{n}(x)\;dx} = \frac{\sec^{n - 2}(x)\tan(x)}{n - 1} + \frac{n - 2}{n - 1}{\displaystyle \int \sec^{n - 2}(x)\;dx} & \text{ for } n \neq 1 \\
\end{array}
$$


# General

## Logarithmic

$$
\begin{array}{ll}
	\ln(x) &=& \log_{e}(x) \\
	~\\
	\log(x) &=& \log_{10}(x) \\
	~\\
	\log_{b}(x) &=& \dfrac{\ln(x)}{\ln(b)} \\
\end{array}
$$

# Common Identities

## Trigonometric

- [⬇ Famous Trig Identities](file:../../../../files/spring-2020/MATH-141/ch-6/ch-6_handout-24.pdf)
- [⬇ Trig Cheatsheet](file:../../../../files/winter-2021/MATH-151/notes/trig_cheatsheet.pdf)

$\theta = (cos(x), sin(x))$

![Unit Circle](../../../../files/spring-2020/MATH-141/ch-4/unit_circle.png)

| Angle      | $0^{\circ}$ | $30^{\circ}$         | $45^{\circ}$         | $60^{\circ}$         | $90^{\circ}$    | $180^{\circ}$ | $270^{\circ}$     | $360^{\circ}$ |
|:----------:|:-----------:|:--------------------:|:--------------------:|:--------------------:|:---------------:|:-------------:|:-----------------:|:-------------:|
| **Radian** | $0$         | $\frac{\pi}{6}$      | $\frac{\pi}{4}$      | $\frac{\pi}{3}$      | $\frac{\pi}{2}$ | $\pi$         | $\frac{3 \pi}{2}$ | $2 \pi$       |
|            |             |                      |                      |                      |                 |               |                   |               |
| $\sin$     | $0$         | $\frac{1}{2}$        | $\frac{1}{\sqrt{2}}$ | $\frac{\sqrt{3}}{2}$ | $1$             | $0$           | $-1$              | $0$           |
| $\cos$     | $1$         | $\frac{\sqrt{3}}{2}$ | $\frac{1}{\sqrt{2}}$ | $\frac{1}{2}$        | $0$             | $-1$          | $0$               | $1$           |
| $\tan$     | $0$         | $\frac{1}{\sqrt{3}}$ | $1$                  | $\sqrt{3}$           | $\infty$        | $0$           | $\infty$          | $0$           |
| $\cot$     | $\infty$    | $\sqrt{3}$           | $1$                  | $\frac{1}{\sqrt{3}}$ | $0$             | $\infty$      | $0$               | $\infty$      |
| $\sec$     | $1$         | $\frac{2}{\sqrt{3}}$ | $\sqrt{2}$           | $2$                  | $\infty$        | $-1$          | $\infty$          | $1$           |
| $\csc$     | $\infty$    | $2$                  | $\sqrt{2}$           | $\frac{2}{\sqrt{3}}$ | $1$             | $\infty$      | $-1$              | $\infty$      |


# Derivatives

## Polynomial

$$
\begin{array}{ll}
	\dfrac{d}{dx}(x) &=& 1 \\
	~\\
	\dfrac{d}{dx}(x^{2}) &=& 2x \\
	~\\
	\dfrac{d}{dx}(x^{n}) &=& nx^{n - 1} \\
	~\\
	\dfrac{d}{dx}(mx^{n}) &=& mnx^{n - 1} \\
\end{array}
$$

## Trigonometric Functions

$$
\begin{array}{ll}
	\dfrac{d}{dx}(\sin{x}) = \cos{x} & \dfrac{d}{dx}(\csc{x}) = -\csc{x}\cot{x} \\
	~\\
	\dfrac{d}{dx}(\cos{x}) = -\sin{x} & \dfrac{d}{dx}(\sec{x}) = \sec{x}\tan{x} \\
	~\\
	\dfrac{d}{dx}(\tan{x}) = \sec^{2}{x} & \dfrac{d}{dx}(\cot{x}) = -\csc^{2}{x} \\
\end{array}
$$

## Inverse Hyperbolic Functions

$$
\begin{array}{ll}
	\dfrac{d}{dx}(\sinh^{-1}{x}) = \dfrac{1}{\sqrt{1 + x^{2}}} & \dfrac{d}{dx}(\operatorname{csch}^{-1}{x}) = -\dfrac{1}{\left | x \right |\sqrt{x^{2} + 1}} \\
	~\\
	\dfrac{d}{dx}(\cosh^{-1}{x}) = \dfrac{1}{\sqrt{x^{2} - 1}} & \dfrac{d}{dx}(\operatorname{sech}^{-1}{x}) = -\dfrac{1}{x\sqrt{1 - x^{2}}} \\
	~\\
	\dfrac{d}{dx}(\tanh^{-1}{x}) = \dfrac{1}{1 - x^{2}} & \dfrac{d}{dx}(\coth^{-1}{x}) = \dfrac{1}{1 - x^{2}}
\end{array}
$$

## Logarithmic

$$
\begin{array}{ll}
	\dfrac{d}{dx}(\ln(x)) &=& \dfrac{1}{x} \\
	~\\
	\dfrac{d}{dx}(\ln(mx)) &=& \dfrac{1}{x} \\
	~\\
	\dfrac{d}{dx}(\ln(x^{n})) &=& \dfrac{n}{x} \\
	~\\
	\dfrac{d}{dx}(\ln(mx^{n})) &=& \dfrac{n}{x} \\
	~\\
	\dfrac{d}{dx}(\log_{b}(x)) &=& \dfrac{1}{x\ln(b)} \\
	~\\
	\dfrac{d}{dx}(\log_{b}(mx)) &=& \dfrac{1}{x\ln(b)} \\
	~\\
	\dfrac{d}{dx}(\log_{b}(x^{n})) &=& \dfrac{n}{x\ln(b)} \\
	~\\
	\dfrac{d}{dx}(\log_{b}(mx^{n})) &=& \dfrac{n}{x\ln(b)} \\
\end{array}
$$

## Euler's

$$
\begin{array}{ll}
	\dfrac{d}{dx}(e^{x}) &=& e^{x} \\
	~\\
	\dfrac{d}{dx}(e^{nx}) &=& ne^{nx} \\
\end{array}
$$


# Antiderivatives

## Polynomial

$$
\begin{array}{ll}
	\int x\;dx &=& \dfrac{x^{2}}{2} + C \\
	~\\
	\int \sqrt{x}\;dx &=& \dfrac{2}{3}x^{\frac{3}{2}} + C \\
	~\\
	\int x^{n}\;dx &=& \dfrac{x^{n + 1}}{n + 1} + C \\
	~\\
	\int x^{\frac{m}{n}}\;dx &=& \dfrac{x^{\frac{m}{n} + 1}}{\frac{m}{n} + 1} + C = \dfrac{nx\frac{m + n}{n}}{m + n} + C \\
	~\\
	\int mx^{n}\;dx &=& m\dfrac{x^{n + 1}}{n + 1} + C \\
	~\\
	\int \frac{1}{x}\;dx &=& \ln|x| + C \\
\end{array}
$$

## Trigonometric

$$
\begin{array}{ll}
	{\displaystyle \int \sin(x)} = -\cos(x) + C & {\displaystyle \int \cos(x)} = \sin(x) + C \\
	~\\
	{\displaystyle \int \sin(2x)} = -\dfrac{1}{2}cos(2x) + C & {\displaystyle \int \cos(2x)} = \dfrac{1}{2}\sin(2x) + C \\
\end{array}
$$

## Logarithmic

$$
\begin{array}{ll}
	\int \ln(x)\;dx &=& x\ln(x) - x + C \\
	~\\
	\int \ln(x^{n})\;dx &=& nx\ln(nx) - nx + C \\
	~\\
	\int \ln(mx)\;dx &=& x\ln(mx) - x + C \\
	~\\
	\int ln(mx^{n})\;dx &=& x\ln(m) + nx\ln(x) - nx + C \\
	~\\
	\int log_{b}(x)\;dx &=& {\displaystyle \int \frac{\ln(x)}{ln(b)}} = x\log_{b}(x) - \dfrac{x}{\ln(b)} + C \\
	~\\
	\int \log_{b}(x^{n})\;dx &=& n\left ( x\log_{b}(x) - \dfrac{x}{\ln(b)} \right ) + C \\
	~\\
	\int log_{b}(mx)\;dx &=& x\log_{b}(mx) - \dfrac{x}{\ln(b)} + C \\
	~\\
	\int log_{b}(mx^{n})\;dx &=& x\log_{b}(m) + n\left ( xlog_{b}(x) - \dfrac{x}{\ln(b)} \right ) + C \\
\end{array}
$$


# Integrals

## Common Integration Formulas

![Table 8.1](../../../../files/winter-2021/MATH-151/notes/ch-8/sec_8-1_table-1.png)

## Common Indefinite Integrals

$$
\begin{array}{ll}
  \int cf(x)dx = c \int f(x)dx & \int [f(x) + g(x)]dx = \int f(x)dx + \int g(x)dx \\
	~\\
  \int k\;dx = kx + C \\
	~\\
  \int x^{n}dx = \dfrac{x^{n + 1}}{n + 1} + C(n \neq - 1) & \int \dfrac{1}{x}dx = \ln |x| + C\\
	~\\
  \int e^{x}dx = e^{x} + C & \int b^{x}dx = \dfrac{b^{x}}{\ln(b)} + C \\
	~\\
  \int \sin(x)\;dx = -\cos(x) + C & \int \cos(x)dx = \sin(x) + C \\
	~\\
  \int \sec^{2}(x)dx = \tan(x) + C & \int \csc^{2}(x)dx = -\cot(x) + C \\
	~\\
  \int \sec(x)\tan(x)dx = \sec(x) + C & \int \csc(x)\cot(x)dx = - \csc(x) + C \\
	~\\
  \int \dfrac{1}{x^{2} + 1}dx = \tan^{-1}(x) + C & \int \dfrac{1}{\sqrt{1 - x^{2}}}dx = \sin^{-1}(x) + C \\
	~\\
  \int \sinh(x)dx = \cosh(x) + C & \int \cosh(x)dx = \sinh(x) + C
\end{array}
$$

## Integral by Parts Formula

Use the acronym "LIPET" to help choosing the value when substituting for $u$.

- **L**ogarithmic -- e.g. $\ln(x)$
- **I**nverse Trigonometric -- e.g. $\tan^{-1}(x)$
- **P**olynomial -- e.g. $x^{2}$
- **E**xponential -- e.g. $e^{x}$
- **T**rigonometric -- e.g. $\cos(x)$

to prioritize choosing $u$ in the order of **LIPET**, **L** being the first
priority and **T** being the last.


**Integral by Parts for Indefinite Integrals**

$$
\int u\;dv = uv - \int v\;du
$$

**Integral by Parts for Definite Integrals**

$$
\int_{a}^{b} u(x)v^{\prime} (dx)dx = \left . u(x)v(x) \right |_{a}^{b} - \int_{a}^{b} v(x)u^{\prime}(x)dx
$$


