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

For 64-bit system

```sh
# compile and link
x86_64-w64-mingw32-g++ -static-libgcc -static-libstdc++ main.cpp -o target.exe
# compile and link separately
x86_64-w64-mingw32-g++ -c main.cpp
x86_64-w64-mingw32-g++ -static-libgcc -static-libstdc++ -g main.o -o target.exe
```

For 32-bit system

```sh
# compile and link
i686-w64-mingw32-g++ -static-libgcc -static-libstdc++ main.cpp -o target.exe
# compile and link separately
i686-w64-mingw32-g++ -c main.cpp
i686-w64-mingw32-g++ -static-libgcc -static-libstdc++ -g main.o -o target.exe
```

> NOTE: `-static-libgcc -static-libstdc++` compiler options to link the C and
> C++ standard libraries statically. Fixes missing library errors.

Ref:

- [📄 Compiling, Linking and Building C/C++ Applications](https://www3.ntu.edu.sg/home/ehchua/programming/cpp/gcc_make.html)
- [📄 How to compile for Windows on Linux with gcc/g++?](https://stackoverflow.com/a/47061145)
- [📄 libstdc++-6.dll not found](https://stackoverflow.com/a/21077837)
- [📄 The program can't start because libgcc_s_dw2-1.dll is missing](https://stackoverflow.com/a/4703059)


<br>

# Resources

- [📄 mingw-w64](http://mingw-w64.org/doku.php/start)
- [📄 Compiling, Linking and Building C/C++ Applications](https://www3.ntu.edu.sg/home/ehchua/programming/cpp/gcc_make.html)
- [📄 How to compile for Windows on Linux with gcc/g++?](https://stackoverflow.com/a/47061145)
- [📄 libstdc++-6.dll not found](https://stackoverflow.com/a/21077837)
- [📄 The program can't start because libgcc_s_dw2-1.dll is missing](https://stackoverflow.com/a/4703059)

