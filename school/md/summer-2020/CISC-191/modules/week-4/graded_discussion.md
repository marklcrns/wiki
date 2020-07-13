---
title: Week 4 Graded Discussion
author: Mark Lucernas
date: 2020-07-12
summary: Week 4 Graded Discussion entry
---


# Week 4 Graded Discussion

1. **What are the differences between List, Set, and Map? They are interfaces
   included with JDK, what are they used for?**


List, as compared with Set, is used to store Generic type with or without
redundant values. While Set can only store a value once and will not include
redundant value. Map on the other hand, stores a key-value pair value, where the
"key" is used to reference a certain "value". For time complexity, accessing
List and Set has O(n) while Map only has O(1).

These are only interfaces included with JDK that are the blueprint to create
something more appropriate for specific purpose. For instance, LinkedList is one
of the many class types that implements List interface that create nodes that
stores the value and a pointer to the next value address, creating a dynamic
"chained list of values".


2. **How does a HashMap store items in memory? Be sure to explain HashTable,
   HashCodes, and collisions.**


HashMap stores a key-value pair in memory to which the values can be accessed at
a constant time O(1) using the "key". HashMap supports different types of key
and values.

HashTable is another implementation of Map interface that is similar to HashMap
but older and with few differences. First, HashTable does not allow "null" as
key while HashMap allows for it. Also, like HashMap, HashTable stores key-value
pair in an array but with the help of a Hash function. Hash function helps
calculate the best index an element should go into the array. This means array
size should be fixed. However, hash functions sometimes generate index value
that already exists and causes "collisions".

hashCode() is a method that is used in a HashTable, HashMap or HashSet when
inserting into a the Map structure. Simply put, hashCode method generates a
a unique hash code that points to the specific memory location. That is why
accessing values in memory is very fast because it can jump right away to a
specific value in the memory, as opposed to iterating each value in an array.


3. **What are Comparators for? Write a comparator that sorts students by Last
   and First name in ascending order.**


Comparator interface are widely used to sort user defined Generic types based on
any type of conditions you specify.

```java
import java.util.Comparator;

public class SortStudent implements Comparator<String> {

  @Override
  public int compare(String studentName1, String studentName2) {
    /*
      compareTo is a java built-in method that returns 0 if studentName1 is the
      same as studentName2, positive number of studentName1 goes AFTER
      studentName2, and negative number if student 1 goes BEFORE studentName 2.
    */
    return studentName1.compareTo(studentName2);
  }

}
```

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> studentList = new ArrayList<String>();

    studentList.add("Max");
    studentList.add("Son");
    studentList.add("Bruno");
    studentList.add("Rupert");
    studentList.add("Vladimir");

    System.out.println("Before sort: " + studentList);

    Collections.sort(studentList, new SortStudent());

    System.out.println("After sort: " + studentList);
  }
}
```

Output

```
Before sort: [Max, Son, Bruno, Rupert, Vladimir]
After sort: [Bruno, Max, Rupert, Son, Vladimir]
```


4. **See the java.io class hierarchy below. What is the purpose of the first
   layer of abstract classes used for? For example, InputStream and
   OutputStream? What are the similarities and differences between Character and
   Byte streams? Name an example usage of each. What are Buffered streams used
   for?**


java.io's first abstract layer are used as a framework to create a more concrete
I/O classes tailored to specific purposes. For instance, InputStream is used as a
blueprint to create FileInputStream, ObjectInputStream, etc. and OutputStream a
blueprint for FileOutputStream, ObjectOutputStream, and more.

In I/O Stream, byte stream read/write in chunks of 8-bits, or 1 byte. Thus,
read() method read the first 8-bit ASCII value from the input stream and writes
every 8-bit into the output stream.

Because reading and writing happens really fast under the hood, reading from an
input stream and then writing into an output stream at the same time can couse
inefficiency in the program. It's like InputStream is a guy working with
OutputStream, where OutputStream guy is constantly waiting for InputStream guy
to finish reading inputs before outputting something. Hence, Buffered streams
are invented. Buffered streams takes input or output into an area in the memory
called "buffer" that temporarily stores data. Once streams are into the buffer,
it will now be read which is much faster than reading directly from the
underlying stream because its already in the memory, much like the OutputStream
guy constantly outputting stuff without waiting for the InputStream guy to
finished because its already there.


