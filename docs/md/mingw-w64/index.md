---
title: Mingw-w64
subtitle: GCC compiler for Windows 64 & 32 bits
author: Mark Lucernas
date: Jun 14, 2021
---


# Mingw-w64: GCC compiler for Windows 64 & 32 bits

Compile with GCC/G++ on Linux for Windows.

- [📄 mingw-w64](http://mingw-w64.org/doku.php/start)

## Installation

### Debian Based

```sh
sudo apt install mingw-w64
```

## Usage

```sh
# 64-bit
x86_64-w64-mingw32-g++ -static-libgcc -static-libstdc++ main.cpp -o target.exe

# 32-bit
i686-w64-mingw32-g++ -static-libgcc -static-libstdc++ main.cpp -o target.exe
```

> NOTE: `-static-libgcc -static-libstdc++` compiler options to link `libgcc`
> and `libstdc++` shared library. Fixes missing library errors.


Ref:

- [📄 How to compile for Windows on Linux with gcc/g++?](https://stackoverflow.com/a/47061145)
- [📄 The program can't start because libgcc_s_dw2-1.dll is missing](https://stackoverflow.com/a/4703059)


<br>

# Resources

- [📄 mingw-w64](http://mingw-w64.org/doku.php/start)
- [📄 How to compile for Windows on Linux with gcc/g++?](https://stackoverflow.com/a/47061145)
- [📄 The program can't start because libgcc_s_dw2-1.dll is missing](https://stackoverflow.com/a/4703059)

