---
title: Wiki Diary
author: Mark Lucernas
date: 2020-02-05
---


# Reminders

## To-do

- [ ] Fix colors when using Goyo
- [X] Fix vimwiki snippets
- [X] Fix vimwiki table mappings
  * [X] Change iA or i to wA
- [ ] Learn shell script
  * [ ] Study sed perl and awk
- [ ] Windows Laptop
  * [ ] Dotfiles
    - [ ] Tmux update
    - [ ] bash_aliases Update
- [ ] Linux Laptop
  * [ ] Zathura configs
  * [ ] Copy zsh history configs from Pengwin
- [ ] Make thinkvim and pandoc-goodies private repos
- [ ] Fix R-pandoc resource output path
- [ ] Create index page for wiki repo
  * [ ] Rename wiki to personal wiki and isolate
  * [ ] Transfer vim and tmux wiki to references
- [ ] Study vim-abolish plugin

# Diary

## 2020

### March
  * [To-do 2020-03-16](2020-03-16)
  * [To-do 2020-03-15](2020-03-15)
  * [To-do 2020-03-14](2020-03-14)
  * [To-do 2020-03-13](2020-03-13)
  * [To-do 2020-03-12](2020-03-12)
  * [To-do 2020-03-11](2020-03-11)
  * [To-do 2020-03-10](2020-03-10)
  * [To-do 2020-03-09](2020-03-09)
  * [To-do 2020-03-08](2020-03-08)
  * [To-do 2020-03-07](2020-03-07)
  * [To-do 2020-03-06](2020-03-06)
  * [To-do 2020-03-05](2020-03-05)
  * [To-do 2020-03-04](2020-03-04)
  * [To-do 2020-03-03](2020-03-03)
  * [To-do 2020-03-02](2020-03-02)
  * [To-do 2020-03-01](2020-03-01)

### February
  * [To-do 2020-02-29](2020-02-29)
  * [To-do 2020-02-28](2020-02-28)
  * [To-do 2020-02-27](2020-02-27)
  * [To-do 2020-02-26](2020-02-26)
  * [To-do 2020-02-25](2020-02-25)
  * [To-do 2020-02-24](2020-02-24)
  * [To-do 2020-02-17](2020-02-17)
  * [To-do 2020-02-14](2020-02-15)
  * [To-do 2020-02-13](2020-02-13)
  * [To-do 2020-02-12](2020-02-12)
  * [To-do 2020-02-10](2020-02-11)
  * [To-do 2020-02-10](2020-02-10)
  * [To-do 2020-02-09](2020-02-09)
  * [To-do 2020-02-08](2020-02-08)
  * [To-do 2020-02-07](2020-02-07)
  * [To-do 2020-02-06](2020-02-06)
  * [To-do 2020-02-05](2020-02-05)

$$
\begin{aligned}
\det A &=\left.
\begin{array}{c}
\;\;\text{*)} \\
-1\text{)} \\
-2\text{)} \\
-2\text{)}
\end{array}
\right.
\begin{vmatrix}
1 & 3 & 2 & -6 \\
1 & 2 & -2 & -5 \\
2 & 4 & -2 & -9 \\
2 & 4 & -6 & -9
\end{vmatrix}
=
\begin{vmatrix}
1 & 3 & 2 & -6 \\
0 & -1 & -4 & 1 \\
0 & -2 & -6 & 3 \\
0 & -2 & -10 & 3
\end{vmatrix}
\\
&& \\
&=\left.
\begin{array}{c}
\;\;\text{*)} \\
-2\text{)} \\
-2\text{)}
\end{array}
\right.
\begin{vmatrix}
1 & 4 & 1 \\
2 & 6 & 3 \\
2 & 10 & 3
\end{vmatrix}
=
\begin{vmatrix}
1 & 4 & 1 \\
0 & -2 & 1 \\
0 & 2 & 1
\end{vmatrix}
=
\begin{vmatrix}
-2 & 1 \\
2 & 1
\end{vmatrix}
=-4
\end{aligned}
$$

~~~ {.Rplot}
require(stats)
D = 150
T = 10
t = seq(0, 80, 0.01)
x = -D*exp(-(t/T))+D
v = (D/T)*exp(-(t/T))
plot(t, x, type="l", main="position through time", xlab="time (s)", ylab="position (m)", xlim=c(0,80), ylim=c(0, D+10),  xaxs = "i", yaxs = "i")
~~~
