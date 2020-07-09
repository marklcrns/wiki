---
title: List Stacks and Queues
author: Mark Lucernas
date: 2020-07-07
summary: CISC 191 Week 3 List Stacks and Queues Notes
---


# List, Stacks, and Queues

  - [*List, Stacks, and Queues](file:../../../../../../../files/summer-2020/CISC-191/week-3/list-and-queues.ppt)
  - [`Linked List in Java](https://www.youtube.com/watch?v=195KUinjBpU)


## Lists

There are two ways to implement a list.

Using arrays. One is to use an array to store the elements. The array is
dynamically created. If the capacity of the array is exceeded, create a new
larger array and copy all the elements from the current array to the new array.

Using linked list. The other approach is to use a linked structure. A linked
structure consists of nodes. Each node is dynamically created to hold an
element. All the nodes are linked together to form a list.

### Array Lists

Array is a fixed-size data structure. Once an array is created, its size cannot
be changed. Nevertheless, you can still use array to implement dynamic data
structures. The trick is to create a new larger array to replace the current
array if the current array cannot hold new elements in the list.

#### Insertion

Before inserting a new element at a specified index, shift all the elements
after the index to the right and increase the list size by 1.

#### Deletion

To remove an element at a specified index, shift all the elements after the
index to the left by one position and decrease the list size by 1.


## Linked Lists

Since MyArrayList is implemented using an array, the methods get(int index) and
set(int index, Object o) for accessing and modifying an element through an index
and the add(Object o) for adding an element at the end of the list are
efficient. However, the methods add(int index, Object o) and remove(int index)
are inefficient because it requires shifting potentially a large number of
elements. You can use a linked structure to implement a list to improve
efficiency for adding and removing an element anywhere in a list.

### Nodes in Linked Lists

A linked list consists of nodes. Each node contains an element, and each node is
linked to its next neighbor. Thus a node can be defined as a class, as follows:

```java
class Node<E> {
  E element;
  Node<E> next;

  public Node(E o ) {
    element = 0;
  }
}
```

### Adding Three Nodes

The variable **head** refers to the first node in the list, and the variable
**tail** refers to the last node in the list. If the list is empty, both are
`null`. For example, you can create three nodes to store three strings in a
list, as follows: 

Step 1: Declare `head` and `tail`

```java
Node<String> head = null;
Node<String> tail = null;
```

Step 2: Create the first node and insert it to the list:

```java
head = new Node<>("Chicago");
tail = head;
```

Step 3: Create the second node and insert it to the list:

```java
tail.next = new Node<>("Denver");
tail = tail.next
```

Step 4: Create the third node and insert it to the list:

```java
tail.next = new Node<>("Dallas");
tail = tail.next;
```

### Traversing All Elements in the List

```java
Node<E> current = head;
while (current != null) {
  System.out.println(current.element);
  current = current.next;
}
```

### Circular Linked Lists

A _circular_, _singly linked_ list is like a singly linked list, except that the
pointer of the last node points back to the first node.

### Doubly Linked Lists

A _doubly linked list_ contains the nodes with two pointers. One points to the
next node and the other points to the previous node. These two pointers are
conveniently called a forward pointer and a backward pointer. So, a doubly
linked list can be traversed forward and backward.

### Circular Double Linked Lists

A circular, doubly linked list is doubly linked list, except that the forward
pointer of the last node points to the first node and the backward pointer of
the first pointer points to the last node.


## Stacks

A stack can be viewed as a special type of list, where the elements are
accessed, inserted, and deleted only from the end, called the top, of the stack.

> A stack is LIFO, last in first out

## Queues

A queue represents a waiting list. A queue can be viewed as a special type of
list, where the elements are inserted into the end (tail) of the queue, and are
accessed and deleted from the beginning (head) of the queue.

> A queue is FIFO, first in first out

### Priority Queue

A regular queue is a first-in and first-out data structure. Elements are
appended to the end of the queue and are removed from the beginning of the
queue. In a priority queue, elements are assigned with priorities. When
accessing elements, the element with the highest priority is removed first. A
**priority queue** has a largest-in, first-out behavior. For example, the
emergency room in a hospital assigns patients with priority numbers; the patient
with the highest priority is treated first.


<br>

# Resources

  - [*List, Stacks, and Queues](file:../../../../../../../files/summer-2020/CISC-191/week-3/list-and-queues.ppt)
  - [`Linked List in Java](https://www.youtube.com/watch?v=195KUinjBpU)

