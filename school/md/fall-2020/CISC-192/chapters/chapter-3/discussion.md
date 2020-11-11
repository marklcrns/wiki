---
title: Chapter 2 & 3 Discussion
author: Mark Lucernas
date: Nov 11, 2020
---


# Discussion

1. Friend Declaration

Usage: Grants a function or another class access of private to protected members of the class where the friend declaration exist.

```cpp
// Simple friend class declaration
#include <iostream>
using namespace std;

class ClassA {
  private:
    int a;

  public:
    ClassA() { a = 0; }
    friend class ClassB;
};

class ClassB {
  private:
    int b;

  public:
    void showA(ClassA& x) {   // '&' after ClassA indicates a 'reference' to ClassA
      // Since class B is a friend of A as declared in line 9, it can therefore
      // acces private members of A
      cout << "ClassA::a = " << x.a;
    }
};

int main() {
  ClassA a;
  ClassB b;
  b.showA(a);
  return 0;
}
```

```
Output:
ClassA::a = 0
```

2. Virtual function specifier

Usage: Virtual function is a member function declared within a "base" class and is overridden by another "derived" class.

```cpp
// Sample Virtual Functions usage
#include <iostream>
using namespace std;

class Base {
  public:
    virtual void print() {
      cout << "print() from Base class" << endl;
    }

    void show() {
      cout << "show() from Base class" << endl;
    }
};

class Derived : public Base {
  public:
    void print() {
      cout << "print() from Derived class" << endl;
    }

    void show() {
      cout << "show() from Derived class" << endl;
    }
};

int main() {
  Base* bptr;   // '*' after Base is a 'pointer' to the memory address of Base class
  Derived d;
  bptr = &d;    // '&' before d is a unique identifier of d required when
                // declaring a pointer '*'

  // Virtual function, binded at runtime
  bptr->print();

  // Non-virtual function, binded at compile time
  bptr->show();
}
```

```
Output:
print() from Derived class
show() rom Base class
```

3. Inline Specifier

Usage: Used to reduce function call overheads. Inline functions are functions expanded "inline" when called at compile time.

```cpp
// Sample usage of inline function
#include <iostream>
using namespace std;

inline int inlineSum(int a, int b) {
  return a + b;
}

int main() {
  int a = 1;
  int b = 2;
  cout << "Sum of " << a << " and " << b << " is = " << inlineSum(1, 2);
}
```

```
Output:
Sum of 1 and 2 is = 3
```

4. goto statement

Usage: The goto statement transfers control to the location specified by label.

```cpp
// Sample usage of goto statement
#include <iostream>
using namespace std;

void checkEvenOrNot(int num) {
  if (num % 2 == 0)
    // jump to even
    goto even;
  else
    // jump to odd
    goto odd;

even:   // even label
  cout << num << " is even" << endl;
  /// return if even
  return;
odd:    // odd label
  cout << num << " is odd" << endl;
}

int main() {
  int num1 = 7, num2 = 10;

  checkEvenOrNot(num1);
  checkEvenOrNot(num2);
  return 0;
}
```

```
Output:
7 is odd
10 is even
```

5. nullptr, the pointer literal

Usage: nullptr keyword retains the the meaning of null pointer even if it is no longer a literal.

```cpp
#include <iostream>
using namespace std;

// Template function to implement clone() with generic data type
// constexpr tells compiler to evaluate the value at compile time
template<class T>
constexpr T clone(const T& t) {
  return t;
}

void g(int*) {
  cout << "Function g called" << endl;
}

int main() {
  g(nullptr);           // Fine
  g(NULL);              // Fine
  g(0);                 // Fine
  g(clone(nullptr));    // Fine
  //  g(clone(NULL));   // ERROR: non-literal zero cannot be a null pointer constant
  //  g(clone(0));      // ERROR: non-literal zero cannot be a null pointer constant
```

```
Output:
Function g called
Function g called
Function g called
Function g called
```

