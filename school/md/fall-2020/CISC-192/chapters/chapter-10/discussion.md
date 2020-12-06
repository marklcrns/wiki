---
title: Chapter 10 Discussion
author: Mark Lucernas
date: Dec 03, 2020
---


# Discussion

1. Compare and contrast the 3 base smart pointer types in the Gaddis textbook
   and 1 more from [📄
   Boost](https://www.boost.org/doc/libs/1_73_0/libs/smart_ptr/doc/html/smart_ptr.html).
2. Explain one good use case for each of the 4 smart pointer types. Feel free to
   use diagrams or sample code to help justify each use case. Copy and pasted
   research is welcomed, but make sure to cite your sources.

Smart pointers are objects that wraps an ordinary pointer to an owned object.
They help solve the problems with memory management such as _memory leaks_,
_dangling pointers_, _double deletion_, etc., which can be problematic if not
managed properly.

The central concpet behind smart pointers is _ownership of dynamically allocated
memory_. A smart pointer is said to _own_ or _manage_ the object that it points
to.


**NOTE: To avoid memory leaks, objects that are managed by smart pointers should
have no other references to them.**

`unique_ptr`

Unique pointers are used when a dynamically allocated object is to be owned by a
single pointer. `unique_ptr` cannot be initialized with the value of another
`unique_ptr` object. Similarly, you cannot assign one `unique_ptr` object to
another.

```cpp
#include <memory>
#include <iostream>
using namespace std;

int main() {
  /* Pointer to a dynamically allocated storage should immediately be passed to
     a smart pointer constructor without first assigning it to a pointer
     variable to avoid memory leaks. */
  unique_ptr<int> uPtr(new int);
  *uPtr = 99;

  cout << *uPtr << endl;  // Prints: 99

  uPtr = nullptr;

  // With Arrays

  const int SIZE = 5;
  unique_ptr<int[]> uPtrArr(new int[SIZE]);

  // Set array elements 0 - 4
  for (int i = 0; i < SIZE; i++) {
    uPtrArr[i] = i;
  }

  // Print the array elements
  for (int i = 0; i < SIZE; i++) {
    cout << uPtrArr[i] << " ";  // Prints: 0 1 2 3 4
  }
  cout << endl;

  return 0;
}
```

However, C++ provides a `move()` library function that can be used to transfer
ownership from one unique pointer to another.

```cpp
unique_ptr<int> uPtr1(new int);
*uPtr1 = 15;

// unique_ptr<int> uPtr3 = uPtr1; // Illegal initialization
unique_ptr<int> uPtr3;            // Ok
uPtr3 = move(uPtr1);              // Transfer ownership from uptr1 to uptr3

cout << *uPtr3 << end;            // Prints: 15
```

Additionally, `make_unique<T>()` or `make_unique<T []>()` is used to create a
unique pointer to an object or array of objects of type _T_

```cpp
// Creates unique pointer of type Thing
unique_ptr<Thing> uPtr = make_unique<Thing>();
// Creates unique array pointer of type Thing of size 5
unique_ptr<Thing[]> uPtrArr = make_unique<Thing[]>(5);
```

`shared_ptr`

Shared pointers jointly maintain a count of the pointers that currently share
ownership of an object. this _reference count_ increases as additional pointers
are set to point to the objet and decreases as pointers detach frm the object

```cpp
#include <memory>
#include <iostream>
using namespace std;

int main() {
  int* rPtr = new int(99);
  shared_ptr<int> sPtr1(rPtr);
  shared_ptr<int> sPtr2 = sPtr1;  // Becomes a member of the same group as sPtr1
  shared_ptr<int> sPtr3 = sPtr2;  // Becomes a member of the same group as sPtr2
  // shared_ptr<int> sptr4(rPtr); // Error: Double dipping. Not allowed

  cout << *rPtr << endl;  // Prints: 99
  cout << *sPtr1 << endl; // Prints: 99
  cout << *sPtr2 << endl; // Prints: 99
  cout << *sPtr3 << endl; // Prints: 99

  return 0;
}
```

Similar to `make_unique`, shared pointers has `make_shared` constructor to
initialize objects of type _T_.

```cpp
// Creates int shared pointer with a value of 99
shared_ptr<int> sPtrInt = make_shared<int>(99);
// Creates int shared pointer array of size 5
shared_ptr<int[]> sPtrArrInt = make_shared<int[]>(5);

// Creates shared pointer of type Person
shared_ptr<Person> sPtrPerson = make_shared<Person>();
// Creates shared pointer array of type Person of size 5
shared_ptr<Person[]> sPtrArrPerson = make_shared<Person[]>(5);
```

`weak_ptr`

Smart pointer that holds a non-owning ("weak") reference to an object that is
managed by `shared_ptr`. It must be converted to `shared_ptr` in order to access
the referenced object.

Weak pointer holds temporary ownership when an object needs to be accessed only
if it exists, and it may be deleted at any time by someone else. Needs to be
converted to `shared_ptr` to assume temporary ownership.

Weak pointer is useful for locating objects if it's still around but doesn't
keep it around if nothing else needs it. Great for caching.

```cpp
#include <memory>
#include <iostream>
using namespace std;

int main() {
  shared_ptr<int> sPtr(new int(5));

  weak_ptr<int> wPtr1;
  weak_ptr<int> wPtr2 (wPtr1);
  weak_ptr<int> wPtr3 (sPtr);

  /* use_count() is a member function of weak_ptr that returns the number of
     shared_ptr objects that share ownership over the same pointer as this
     object. */
  cout << "use_count:" << endl;
  cout << "wPtr1: " << wPtr1.use_count() << endl; // Prints: wPtr1: 0
  cout << "wPtr2: " << wPtr2.use_count() << endl; // Prints: wPtr2: 0
  cout << "wPtr3: " << wPtr3.use_count() << endl; // Prints: wPtr3: 1

  cout << endl;

  cout << "Pointer value:" << endl;

  // Convert weak pointer to shared pointer
  if (shared_ptr<int> tmp = wPtr1.lock())   // Check if wPtr1 is expired
    cout << "wPtr1: " << *tmp << endl;      // Print pointer value if not expired
  else
    cout << "wPtr1 is expired" << endl;     // wPtr1 is expired

  // Convert weak pointer to shared pointer
  if (shared_ptr<int> tmp = wPtr2.lock())   // Check if wPtr2 is expired
    cout << "wPtr2: " << *tmp << endl;      // Print pointer value if not expired
  else
    cout << "wPtr2 is expired" << endl;     // wPtr2 is expired

  // Convert weak pointer to shared pointer
  if (shared_ptr<int> tmp = wPtr3.lock())   // Check if wPtr3 is expired
    cout << "wPtr3: " << *tmp << endl;      // Print pointer value if not expired
  else
    cout << "wPtr3 is expired" << endl;     // wPtr3 is expired

  cout << "sPtr: " << *sPtr << endl;        // Prints sPtr pointer value

  return 0;
}
```

OUTPUT

```
use_count:
wPtr1: 0
wPtr2: 0
wPtr3: 1

Pointer value:
wPtr1 is expired
wPtr2 is expired
wPtr3: 5
sPtr: 5
```

Sources:

- [📄 cppreference - weak_ptr](https://en.cppreference.com/w/cpp/memory/weak_ptr)
- [📄 When is std::weak_ptr useful?](https://stackoverflow.com/a/21877073/11850077)


`scoped_ptr`

Stores a pointer to a dynamically allocated object. The object pointed to is
guaranteed to be deleted, either on destruction of the `scopted_ptr`, or via an
explicit reset.

`scoped_ptr` is a simple solution for simple needs. It supplies a basic
"resource acquisition is initialization" facility, without shared-ownership or
transfer-of-ownership semantics.

```cpp
#include <boost/scoped_ptr.hpp>
#include <iostream>

struct Shoe { ~Shoe() { std::cout << "Buckle my shoe\n"; } };

class MyClass {
    boost::scoped_ptr<int> ptr;
  public:
    MyClass() : ptr(new int) { *ptr = 0; }
    int add_one() { return ++*ptr; }
};

int main()
{
    boost::scoped_ptr<Shoe> x(new Shoe);
    MyClass my_instance;
    std::cout << my_instance.add_one() << '\n';
    std::cout << my_instance.add_one() << '\n';
}
```

OUTPUT

```
1
2
Buckle my shoe
```

The primary reason to use scoped_ptr rather than `std::auto_ptr` or
`std::unique_ptr` is to let readers of your code know that you intend "resource
acquisition is initialization" to be applied only for the current scope, and
have no intent to transfer ownership.

Source:

- [📄 Boost - scoped_ptr: Scoped Object Ownership](https://www.boost.org/doc/libs/1_73_0/libs/smart_ptr/doc/html/smart_ptr.html#scoped_ptr)



<br>

# Resources

- [📄 Boost](https://www.boost.org/doc/libs/1_73_0/libs/smart_ptr/doc/html/smart_ptr.html)
- [📄 cppreference - weak_ptr](https://en.cppreference.com/w/cpp/memory/weak_ptr)
- [📄 When is std::weak_ptr useful?](https://stackoverflow.com/a/21877073/11850077)

Textbook:

- Starting Out with C++: Early Objects by Tony Gaddis, Judy Walters, Godfrey
  Muganda
