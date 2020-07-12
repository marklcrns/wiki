---
title: Generics and Collections
author: Mark Lucernas
date: 2020-07-09
summary: CISC 191 Week 4 Generics and Collections notes
---


# Generics and Collections

  - [*Generics](file:../../../../../../../files/summer-2020/CISC-191/week-4/generics.ppt)
  - [`Java intro to Generics and Collections Framework using LinkedList](https://www.youtube.com/watch?v=0OXZuxe_TVk)
  - [`Java Concurrent Collections: Introduction](https://www.youtube.com/watch?v=8GviG6nSSTA)


## Generics

### Comparable Interface: Sorting an ArrayList

Sorting the elements of an ArrayList into ascending or descending order is a
common programming task. Java's **Collections** class provides static methods
that operate on various types of lists such as an ArrayList. The `sort()` method
sorts collections into ascending order provided that the elements within the
collection implement the Comparable interface (i.e., the elements are also of
the type Comparable). For example, each of the primitive wrapper classes (e.g.,
Integer, Double, etc.) implements the **Comparable** interface, which declares
the `compareTo()` method. Classes implementing the Comparable interface must
define a custom implementation of the `compareTo()` method. A programmer may use
`sort()` to sort an ArrayList in which the elements implement the Comparable
interface (e.g., Integer). The programmer must import java.util.Collections to
use the `sort()` method. The following example demonstrates the use of `sort()`
to sort an ArrayList of Integer objects.

> Collections' `sort()` method operates on lists of Integer objects.

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ArraySorter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int NUM_ELEMENTS = 5;                             // Number of items in array
      ArrayList<Integer> userInts = new ArrayList<Integer>(); // Array of user defined values
      int i;                                                  // Loop index

      // Prompt user for input, add values to array
      System.out.println("Enter " + NUM_ELEMENTS + " numbers...");
      for (i = 1; i <= NUM_ELEMENTS; ++i) {
         System.out.print(i + ": ");
         userInts.add(scnr.nextInt());
      }

      // Sort ArrayList of Comparable elements
      Collections.sort(userInts);

      // Print sorted array
      System.out.print("\nSorted numbers: ");
      for (i = 0; i < NUM_ELEMENTS; ++i) {
         System.out.print(userInts.get(i) + " ");
      }
      System.out.println("");
   }
}
```

The Collections' `sort()` method calls the `compareTo()` method on each object
within the ArrayList to determine the order and produce a sorted list.

The `sort()` method can also be used to sort an ArrayList containing elements of
a user-defined class type. The only requirement, however, is that the
user-defined class must also implement the Comparable interface and override the
`compareTo()` method, which should return a number that determines the ordering
of the two objects being compared as shown below.

`compareTo(otherComparable)` compares a Comparable object to otherComparable,
returning a number indicating if the Comparable object is less than, equal to,
or greater than otherComparable. The method `compareTo()` will return 0 if the
two Comparable objects are equal. Otherwise, `compareTo()` returns a negative
number if the Comparable object is less than otherComparable, or a positive
number if the Comparable object is greater than otherComparable.


> Sorting an ArrayList of employee records.

  - [+EmployeeRecords](employee_records)


Classes that already inherit from a base class can also be defined to implement
an interface. For example, the above EmployeeData class could have been defined
so that it extends a Person class and implements the Comparable interface, as in

```java
public class EmployeeData extends Person implements Comparable<EmployeeData> {
  ...
}
```

Finally, note that Comparable's `compareTo()` method is meant to work with any
class. Thus, a programmer must append the class name in angle brackets to
"Comparable", as in `Comparable<EmployeeData>`, in order to tell the compiler
that the `compareTo()` method requires an argument of the indicated class type.
Generic methods, classes, and interfaces are discussed in more detail elsewhere.

### Generic Method

> Methods may have identical behavior, differing only in data types.

```java
// Find the minimum of three **ints**
public static Integer tripleMinInt(Integer item1, Integer item2, Integer item3) {
   Integer minVal;

   minVal = item1;

   if (item2.compareTo(minVal) < 0) {
      minVal = item2;
   }
   if (item3.compareTo(minVal) < 0) {
      minVal = item3;
   }
   return minVal;
}
```

```java
// Find the minimum of three **chars**
public static Character tripleMinChar(Character item1, Character item2, Character item3) {
   Character minVal;

   minVal = item1;

   if (item2.compareTo(minVal) < 0) {
      minVal = item2;
   }
   if (item3.compareTo(minVal) < 0) {
      minVal = item3;
   }
   return minVal;
}
```

Writing and maintaining redundant methods that only differ by data type can be
time-consuming and error-prone. The language supports a better approach.

A generic method is a method definition having a special type parameter that may
be used in place of types in the method.

> A generic method enables a method to handle various class types.

```java
public class ItemMinimum {
   public static <TheType extends Comparable<TheType>>
   TheType tripleMin(TheType item1, TheType item2, TheType item3) {
      TheType minVal = item1; // Holds min item value, init to first item

      if (item2.compareTo(minVal) < 0) {
         minVal = item2;
      }
      if (item3.compareTo(minVal) < 0) {
         minVal = item3;
      }
      return minVal;
   }

   public static void main(String[] args) {
      Integer num1 = 55;    // Test case 1, item1
      Integer num2 = 99;    // Test case 1, item2
      Integer num3 = 66;    // Test case 1, item3

      Character let1 = 'a'; // Test case 2, item1
      Character let2 = 'z'; // Test case 2, item2
      Character let3 = 'm'; // Test case 2, item3

      String str1 = "zzz";  // Test case 3, item1
      String str2 = "aaa";  // Test case 3, item2
      String str3 = "mmm";  // Test case 3, item3

      // Try tripleMin method with Integers
      System.out.println("Items: " + num1 + " " + num2 + " " + num3);
      System.out.println("Min: " + tripleMin(num1, num2, num3) + "\n");

      // Try tripleMin method with Characters
      System.out.println("Items: " + let1 + " " + let2 + " " + let3);
      System.out.println("Min: " + tripleMin(let1, let2, let3) + "\n");

      // Try tripleMin method with Strings
      System.out.println("Items: " + str1 + " " + str2 + " " + str3);
      System.out.println("Min: " + tripleMin(str1, str2, str3) + "\n");
   }
}
```

The method return type is preceded by `<TheType extends Comparable<TheType>>`,
where TheType can be any identifier. That type is known as a **type parameter**
and can be used throughout the method for any parameter types, return types, or
local variable types. The identifier is known as a template parameter, and may
be various reference types or even another template parameter.

A type parameter may be associated with a **type bound** to specify the class types
for which a type parameter is valid. Type bounds are specified using the extends
keyword and appear after the corresponding type parameter. For example, the code
`<TheType extends Comparable<TheType>>` specifies that TheType is bounded by the
type bound Comparable<TheType>. Thus, TheType may only represent types that
implement the Comparable interface. If the type bound is a class type (e.g., the
Number class), the type parameter may only represent types that are of the type
specified by the type bound or any derived classes.

Type bounds are also necessary to enable access to the class members of the
class specified by the type bound (e.g., `compareTo()`) via a variable of a
generic type (e.g., item1, item2, item3, and min). By bounding TheType to the
Comparable interface, the programmer is able to invoke the Comparable
interface's `compareTo()` method with the generic types, as in
item2.compareTo(min);. Attempting to invoke a class member via a generic type
without specifying the appropriate type bound results in a compiler error.

Importantly, type arguments cannot be primitive types such as int, char, and
double. Instead, the type arguments must be reference types. If primitive types
are desired, a programmer should use the corresponding primitive wrapper classes
(e.g., Integer, Character, Double, etc.), discussed elsewhere.

Programmers optionally may explicitly specify the generic type as a special
argument, as in ItemMinimum.<Integer>tripleMin(num1, num2, num3);.

A generic method may have multiple parameters:

> Method definition with multiple generics.

```java
modifiers <Type1 extends BoundType1, Type2 extends BoundType2>
ReturnType methodName(parameters) {
   ...
}
```

### Generic Class

Multiple classes may be nearly identical, differing only in their data types.
The following shows a class managing three Integer numbers, and a nearly
identical class managing three Short numbers.

> Classes may be nearly identical, differing only in data type.

```java
public class TripleInt {
   private Integer item1; // Data value 1
   private Integer item2; // Data value 2
   private Integer item3; // Data value 3

   public TripleInt(Integer i1, Integer i2, Integer i3) {
      item1 = i1;
      item2 = i2;
      item3 = i3;
   }

   // Print all data member values
   public void printAll() {
      System.out.println("(" + item1 + "," + item2 + "," + item3 + ")");
   }

   // Return min data member value
   public Integer minItem() {
      Integer minVal;         // Holds min item value, init to first item

      minVal = item1;

      if (item2.compareTo(minVal) < 0) {
         minVal = item2;
      }
      if (item3.compareTo(minVal) < 0) {
         minVal = item3;
      }
      return minVal;
   }
}
```

```java
public class TripleShort {
   private Short item1; // Data value 1
   private Short item2; // Data value 2
   private Short item3; // Data value 3

   public TripleShort(Short i1, Short i2, Short i3) {
      item1 = i1;
      item2 = i2;
      item3 = i3;
   }

   // Print all data member values
   public void printAll() {
      System.out.println("(" + item1 + "," + item2 + "," + item3 + ")");
   }

   // Return min data member value
   public Short minItem() {
      Short minVal;         // Holds min item value, init to first item

      minVal = item1;

      if (item2.compareTo(minVal) < 0) {
         minVal = item2;
      }
      if (item3.compareTo(minVal) < 0) {
         minVal = item3;
      }
      return minVal;
   }
}
```

Writing and maintaining redundant classes that only differ by data type can be
time-consuming and error-prone. The language supports a better approach.

A **generic class** is a class definition having a special type parameter that
may be used in place of types in the class. A variable declared of that
**generic** class type must indicate a specific type.

> A generic class enables one class to handle various data types.

TripleItem.java

```java
public class TripleItem <TheType extends Comparable<TheType>> {
   private TheType item1; // Data value 1
   private TheType item2; // Data value 2
   private TheType item3; // Data value 3

   public TripleItem(TheType i1, TheType i2, TheType i3) {
      item1 = i1;
      item2 = i2;
      item3 = i3;
   }

   // Print all data member values
   public void printAll() {
      System.out.println("(" + item1 + "," + item2 + "," + item3 + ")");
   }

   // Return min data member value
   public TheType minItem() {
      TheType minVal;        // Holds min item value, init to first item

      minVal = item1;

      if (item2.compareTo(minVal) < 0) {
         minVal = item2;
      }
      if (item3.compareTo(minVal) < 0) {
         minVal = item3;
      }
      return minVal;
   }
}
```

```java
public class TripleItemManager {
   public static void main(String[] args) {

      // TripleItem class with Integers
      TripleItem<Integer> triInts = new TripleItem<Integer>(9999, 5555, 6666);

      // TripleItem class with Shorts
      TripleItem<Short> triShorts = new TripleItem<Short>((short)99, (short)55, (short)66);

      // Try methods from TripleItem
      triInts.printAll();
      System.out.println("Min: " + triInts.minItem() + "\n");

      triShorts.printAll();
      System.out.println("Min: " + triShorts.minItem());
   }
}
```

Output

```
(9999,5555,6666)
Min: 5555

(99,55,66)
Min: 55
```

The class name is succeeded by `<TheType ... >`, where TheType can be any
identifier. That type is known as a **type parameter** and can be used
throughout the class, such as for parameter types, method return types, or field
types. An object of this class can be instantiated by appending after the class
name a specific type in angle brackets, such as

```java
TripleItem<Short> triShorts = new TripleItem<Short>((short)99, (short)55, (short)66);
```

Each type parameter can be associated with type bounds to specify the data types
a programmer is allowed to use for the type arguments. As with generic methods,
type bounds also allow a programmer to utilize the class members specified by
the bounding type with variables of a generic type (e.g., item1, item2, item3,
and min). Thus, above, TripleItem is a generic class whose instances expect type
arguments that implement the `Comparable<TheType>` interface. By bounding the
generic class's type parameter to the Comparable interface, a programmer can
invoke the Comparable interface's `compareTo()` method with the generic types,
as in `item2.compareTo(min)`.

A generic class may have multiple type parameters, separated by commas.
Additionally, each type parameter may have type bounds.

> Generic class template with multiple parameters.

```java
public class ClassName <Type1 extends BoundType1, Type2 extends BoundType2> {
   ...
}
```

Importantly, type arguments cannot be primitive types such as int, char, and
double. Instead, the type arguments must be reference types. If primitive types
are desired, a programmer should use the corresponding primitive wrapper classes
(e.g., Integer, Char, Double, etc.), discussed elsewhere.

Note that Java's ArrayList class is a generic class, which is why a variable
declared as an ArrayList indicates the type in angle brackets, as in
ArrayList<Integer> nums = new ArrayList<Integer>();.

## Collections

### Enhanced for loop

The **enhanced for loop** is a for loop that iterates through each element in an
array or Collection. An enhanced for loop is also known as a **for each loop**.
The enhanced for loop declares a new variable that will be assigned with each
successive element of a container object, such as an array or ArrayList. The
enhanced for loop only allows elements to be accessed forward from the first
element to the last element.

> The enhanced for loop declares a new variable and assigns the variable with
each successive element of the container object.

```java
ArrayList<String> teamRoster = new ArrayList<String>();

// Adding player names
teamRoster.add("Mike");
teamRoster.add("Scottie");
teamRoster.add("Toni");

System.out.println("Current roster:");

for (String playerName : teamRoster) {
   System.out.println(playerName);
}
```

### List: LinkedList

A LinkedList is one of several types that implement the List interface. The
LinkedList type is an ADT implemented as a generic class that supports different
types of elements. A LinkedList can be declared and created as:

```java
LinkedList<T> linkedList = new LinkedList<T>();
```

where `T` represents the LinkedList's type, such as Integer or String. The
statement `import java.util.LinkedList;` enables use of a `LinkedList` within a
program.

> LinkedList: `add()` method adds elements to end of list or at specified index.

```java
LinkedList<String> authorsList = new LinkedList<String>();

authorsList.add("Gamow");
authorsList.add("Penrose");
authorsList.add("Hawking");

authorsList.add(1, "Greene");
```

> LinkedList: `get()` returns elements at specified location and set`()`
replaces element at specified location.

```java
System.out.println(authorsList.get(2));

authorsList.set(2, "Sagan");

System.out.println(authorsList.get(2));
```

> LinkedList: `remove()` method removes element from specified position.

```java
System.out.println(authorsList.get(1));

authorsList.remove(1);

System.out.println(authorsList.get(1));
```

#### Iterating through a list

LinkedList methods with index parameters, such as `get()` or `set(),` cause the list
to be traversed from the first element to the specified element each time the
method is called. **Thus, using the LinkedLists' `get()` or `set()` methods within a
loop that iterates through all list elements is inefficient.**

```java
LinkedList<String> authorsList = new LinkedList<String>();
String authorName;
int i;

authorsList.add("Gamow");
authorsList.add("Greene");
authorsList.add("Penrose");

for (i = 0; i < authorsList.size(); ++i) {
   authorName = authorsList.get(i);
   System.out.println(authorName);
}
```

Efficient iteration through a LinkedList necessitates keeping track of the
current position in the loop without using an index. A **ListIterator** is an
object that points to a location in a List and provides methods to access an
element and advance the ListIterator to the next position in the list.

LinkedList's `listIterator()` method returns a ListIterator object for
traversing a list. The statement `import java.util.ListIterator;` enables use of
a `ListIterator` in a program.

```java
LinkedList<String> authorsList = new LinkedList<String>();
String authorName;
ListIterator<String> listIterator;

authorsList.add("Gamow");
authorsList.add("Greene");
authorsList.add("Penrose");

listIterator = authorsList.listIterator();

while (listIterator.hasNext()) {
   authorName = listIterator.next();
   System.out.println(authorName);
}
```

A ListIterator is located between two elements in a list. The `next()` method
returns the next element in the list and moves the ListIterator to the next
location. The `hasNext()` method returns true if there is a next element, and
false otherwise. A good practice is to always call `hasNext()` before calling
`next()` to ensure a list element exists.

### Map: HashMap

<a name="map-container-term">**Map container**</a>

  - A programmer may wish to lookup values or elements based on another value,
    such as looking up an employee's record based on an employee ID. The **Map**
    interface within the Java Collections Framework defines a Collection that
    associates (or maps) keys to values. The statement `import
    java.util.HashMap;` enables use of a HashMap.

The HashMap type is an ADT implemented as a generic class that supports
different types of keys and values. Generically, a HashMap can be declared and
created as `HashMap<K, V> hashMap = new HashMap<K, V>();` where K represents the
HashMap's key type and V represents the HashMap's value type.

The `put()` method associates a key with the specified value. If the key does
not already exist, a new entry within the map is created. If the key already
exists, the old value for the key is replaced with the new value. Thus, a map
associates at most one value for a key.

The `get()` method returns the value associated with a key, such as
`statePopulation.get("CA")`.

> A HashMap allows a programmer to map keys to values.

```java
HashMap<String, Integer> statePopulation = new HashMap<String, Integer>();

// 2013 population data from census.gov
statePopulation.put("CA", 38332521);
statePopulation.put("AZ", 6626624);
statePopulation.put("MA", 6692824);

System.out.print("Population of Arizona in 2013 is ");
System.out.print(statePopulation.get("AZ"));
System.out.println(".");
```

### Set: HashSet

<a name="set-container-term">**Set container**</a>

  - The **Set** interface defined within the Java Collections Framework defines
    a Collection of unique elements. The Set interface supports methods for
    adding and removing elements, as well as querying if a set contains an
    element. For example, a programmer may use a set to store employee names and
    use that set to determine which customers are eligible for employee
    discounts.


The HashSet type is an ADT implemented as a generic class that supports
different types of elements. A HashSet can be declared and created as
`HashSet<T> hashSet = new HashSet<T>();` where T represents the HashSet's type,
such as Integer or String. The statement `import java.util.HashSet;` enables use
of a HashSet within a program.

#### add() and remove() Methods

The `add()` method does not add duplicate elements to a set. If a programmer
tries to add a duplicate element, the `add()` method fails and returns false.
Otherwise, `add()` returns true.

The `remove()` method only removes elements that exist within the set. If the
element exists, the `remove()` method removes the element and returns true.
Otherwise, `remove()` returns false.

### Queue Interface

The **Queue** interface defined within the Java Collections Framework defines a
Collection of ordered elements that supports element insertion at the tail and
element retrieval from the head.

A LinkedList is one of several types that implements the Queue interface. A
LinkedList implementation of a Queue can be declared and created as `Queue<T>
queue = new LinkedList<T>();` where T represents the element's type, such as
Integer or String. Java supports automatic conversion of an object, e.g.,
LinkedList, to a reference variable of an interface type, e.g., Queue, as long
as the object implements the interface.

The statements `import java.util.LinkedList;` and `import java.util.Queue;`
enable use of a `LinkedList` and `Queue` within a program.

A Queue's `add()` method adds an element to the tail of the queue and increases
the queue's size by one. A Queue's `remove()` method removes and returns the
element at the head of the queue. If the queue is empty, `remove()` throws an
exception.

> Queue: add() method adds an element to the tail of the queue, and remove()
method returns and removes the element at the head of the queue.

```java
Queue<String> waitList = new LinkedList<String>();

waitList.add("Neumann party of 1");
waitList.add("Amdahl party of 2");
waitList.add("Flynn party of 4");

System.out.println("Serving: " + waitList.remove());
System.out.println("Serving: " + waitList.remove());
System.out.println("Serving: " + waitList.remove());
```

Output

```
Serving:
Neumann party of 1
Serving:
Amdahl party of 2
Serving:
Flynn party of 4
```

### Deque Interface

The **Deque** (pronounced "deck") interface defined within the Java Collections
Framework defines a Collection of ordered elements that supports element
insertion and removal at both ends (i.e., at the head and tail of the deque).

A LinkedList is one of several types that implements the Deque interface. A
LinkedList implementation of a Deque can be declared and created as `Deque<T>
deque = new LinkedList<T>();` where T represents the element's type, such as
Integer or String. Java supports automatic conversion of an object, e.g.,
LinkedList, to a reference variable of an interface type, e.g., Deque, as long
as the object implements the interface.

The statements import java.util.LinkedList; and import java.util.Deque; enable
use of a LinkedList and Deque within a program.

Deque's `addFirst()` and `removeFirst()` methods allow a Deque to be used as a
**stack**. A stack is an ADT in which elements are only added or removed from
the top of a stack. Deque's `addFirst()` method adds an element at the head of the
deque and increases the deque's size by one. The `addFirst()` method shifts
elements in the deque to make room for the new element. The `removeFirst()` method
removes and returns the element at the head of the deque. If the deque is empty,
`removeFirst()` throws an exception.

```java
Deque<String> tripRoute = new LinkedList<String>();

System.out.println("Depart Tokyo");
tripRoute.addFirst("Tokyo");

System.out.println("Transfer at Osaka");
tripRoute.addFirst("Osaka");

System.out.println("Arrive in Nara");
tripRoute.addFirst("Nara");

System.out.println("\nReturn trip: ");
System.out.println("Depart " + tripRoute.removeFirst());
System.out.println("Transfer at " + tripRoute.removeFirst());
System.out.println("Arrive in " + tripRoute.removeFirst());
```

Output

```
Depart Tokyo
Transfer at Osaka
Arrive in Nara

Return trip:
Depart Nara
Transfer at Osaka
Arrive in Tokyo
```


<br>

# Resources

  - [*Generics](file:../../../../../../../files/summer-2020/CISC-191/week-4/generics.ppt)
  - [`Java intro to Generics and Collections Framework using LinkedList](https://www.youtube.com/watch?v=0OXZuxe_TVk)
  - [`Java Concurrent Collections: Introduction](https://www.youtube.com/watch?v=8GviG6nSSTA)


Textbook

  * [Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 13 Generics
    - Chapter 14 Collections
