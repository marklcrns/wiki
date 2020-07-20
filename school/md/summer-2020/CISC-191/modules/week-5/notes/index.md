---
title: Concurrency, Threads and Multiprocessing
author: Mark Lucernas
date: 2020-07-14
summary: Week 5 Concurrency, Threads and Multiprocessing
---


# Week 5: Concurrency, Threads and Multiprocessing

  - [*Concurrency](file:../../../../../../files/summer-2020/CISC-191/week-5/concurrency.ppt)
    - [TaskThreadDemo.java](https://liveexample.pearsoncmg.com/html/TaskThreadDemo.html)
    - [FlashTest.java](https://liveexample.pearsoncmg.com/html/FlashText.html)
    - [ExecutorDemo.java](https://liveexample.pearsoncmg.com/html/ExecutorDemo.html)
    - [AccountWithoutSync.java](https://liveexample.pearsoncmg.com/html/AccountWithoutSync.html)
    - [AccountWithSyncUsingLock](https://liveexample.pearsoncmg.com/html/AccountWithSyncUsingLock.html)
    - [ThreadCooperation.java](https://liveexample.pearsoncmg.com/html/ThreadCooperation.html)
    - [ConsumerProducer.java](https://liveexample.pearsoncmg.com/html/ConsumerProducer.html)
    - [ConsumerProducerUsingBlockingQueue.java](https://liveexample.pearsoncmg.com/html/ConsumerProducerUsingBlockingQueue.html)
    - [ParallelMergeSort](https://liveexample.pearsoncmg.com/html/ParallelMergeSort.html)
    - [ParallelMax](https://liveexample.pearsoncmg.com/html/ParallelMax.html)
  - [`Basic Threading](https://www.youtube.com/watch?v=F-CkaU8aQZI)
  - [`Advanced Threading: Locking, ThreadPools](https://www.youtube.com/watch?v=G2Xd5avyk_0)
  - [`Advanced Java: Multi-threading Playlist](https://www.youtube.com/watch?v=YdlnEWC-7Wo&list=PLBB24CFB073F1048E&index=1)


## The Thread Class

### The Static yield() Method

You can use the `yield()` method to temporarily release time for other threads.

### The Static sleep(milliseconds) Method

The `sleep(long mills)` method puts the thread to sleep for the specified time
in milliseconds.

### The join() Method

You can use the `join()` method to force one thread to wait for another thread
to finish.

### isAlive(), interrupt(), and isInterrupted()

The `isAlive()` method is used to find out the state of a thread. It returns
true if a thread is in the Ready, Blocked, or Running state; it returns false if
a thread is new and has not started or if it is finished.

The `interrupt()` method interrupts a thread in the following way: If a thread
is currently in the Ready or Running state, its interrupted flag is set; if a
thread is currently blocked, it is awakened and enters the Ready state, and an
java.io.InterruptedException is thrown.

The `isInterrupt()` method tests whether the thread is interrupted.


## Thread Pools

Starting a new thread for each task could limit throughput and cause poor
performance. A thread pool is ideal to manage the number of tasks executing
concurrently. JDK 1.5 uses the Executor interface for executing tasks in a
thread pool and the ExecutorService interface for managing and controlling
tasks. ExecutorService is a subinterface of Executor.


### Thread Synchronization

A shared resource may be corrupted if it is accessed simultaneously by multiple
threads. For example, two unsynchronized threads accessing the same bank account
may cause conflict.

### Race Condition

The problem is that Task 1 and Task 2 are accessing a common resource in a way
that causes conflict. This is a common problem known as a `race condition` in
multithreaded programs.

A class is said to be thread-safe if an object of the class does not cause a
race condition in the presence of multiple threads.

### The synchronized keyword

To avoid race conditions, more than one thread must be prevented from
simultaneously entering certain part of the program, known as critical region.
The critical region in the Listing 32.5 is the entire deposit method. You can
use the `synchronized` keyword to synchronize the method so that only one thread
can access the method at a time. There are several ways to correct the problem
in Listing 32.5, one approach is to make Account thread-safe by adding the
`synchronized` keyword in the deposit method in Line 45 as follows:

```java
public synchronized void deposit(double amount)
```

### Synchronizing Instance Methods and Static Methods

A synchronized method acquires a lock before it executes. In the case of an
instance method, the lock is on the object for which the method was invoked. In
the case of a static method, the lock is on the class. If one thread invokes a
synchronized instance method (respectively, static method) on an object, the
lock of that object (respectively, class) is acquired first, then the method is
executed, and finally the lock is released. Another thread invoking the same
method of that object (respectively, class) is blocked until the lock is
released.

### Synchronizing Statements

**Invoking a synchronized instance method of an object acquires a lock on the
object, and invoking a synchronized static method of a class acquires a lock on
the class.** A synchronized statement can be used to acquire a lock on any
object, not just this object, when executing a block of the code in a method.
This block is referred to as a synchronized block. The general form of a
synchronized statement is as follows:

```java
synchronized (expr) {
  statements;
}
```

The expression expr must evaluate to an object reference. If the object is
already locked by another thread, the thread is blocked until the lock is
released. When a lock is obtained on the object, the statements in the
synchronized block are executed, and then the lock is released.

### Synchronizing Statements vs. Methods

Any synchronized instance method can be converted into a synchronized statement.
Suppose that the following is a synchronized instance method:

```java
public synchronized void xMethod() {
  // method body
}
```

This method is equivalent to

```java
public void xMethod() {
  synchronized (this) {
    // method body
  }
}
```

### Synchronization Using Locks

A synchronized instance method implicitly acquires a lock on the instance before
it executes the method.

JDK 1.5 enables you to use locks explicitly. The new locking features are
flexible and give you more control for coordinating threads. A lock is an
instance of the Lock interface, which declares the methods for acquiring and
releasing locks. A lock may also use the `newCondition()` method to create any
number of Condition objects, which can be used for thread communications.

### Fairness Policy

`ReentrantLock` is a concrete implementation of `Lock` for creating mutual
exclusive locks. You can create a lock with the specified fairness policy.
**True fairness policies guarantee the longest-wait thread to obtain the lock
first.** False fairness policies grant a lock to a waiting thread without any
access order.  Programs using fair locks accessed by many threads may have poor
overall performance than those using the default setting, but have smaller
variances in times to obtain locks and guarantee lack of starvation.

### Cooperation Among Threads

The conditions can be used to facilitate communications among threads. A thread
can specify what to do under a certain condition. Conditions are objects created
by invoking the `newCondition()` method on a Lock object. Once a condition is
created, you can use its `await(),` `signal(),` and `signalAll()` methods for
thread communications. The `await()` method causes the current thread to wait
until the condition is signaled. The `signal()` method wakes up one waiting
thread, and the `signalAll()` method wakes all waiting threads.

### Java's Built-in Monitors

Locks and conditions are new in Java 5. Prior to Java 5, thread communications
are programmed using object's built-in monitors. Locks and conditions are more
powerful and flexible than the built-in monitor. For this reason, this section
can be completely ignored. However, if you work with legacy Java code, you may
encounter the Java's built-in monitor. A monitor is an object with mutual
exclusion and synchronization capabilities. Only one thread can execute a method
at a time in the monitor. A thread enters the monitor by acquiring a lock on the
monitor and exits by releasing the lock. Any object can be a monitor. An object
becomes a monitor once a thread locks it. Locking is implemented using the
synchronized keyword on a method or a block. A thread must acquire a lock before
executing a synchronized method or block. A thread can wait in a monitor if the
condition is not right for it to continue executing in the monitor.

#### wait(), notify(), and notifyAll()

Use the `wait(),` `notify(),` and `notifyAll()` methods to facilitate
communication among threads.

The `wait(),` `notify(),` and `notifyAll()` methods must be called in a
synchronized method or a synchronized block on the calling object of these
methods.  Otherwise, an IllegalMonitorStateException would occur.

The `wait()` method lets the thread wait until some condition occurs. When it
occurs, you can use the `notify()` or `notifyAll()` methods to notify the
waiting threads to resume normal execution. The `notifyAll()` method wakes up
all waiting threads, while `notify()` picks up only one thread from a waiting
queue.

### Blocking Queues

A blocking queue causes a thread to block when you try to add an element to a
full queue or to remove an element from an empty queue.

#### Concrete Blocking Queues

Three concrete blocking queues `ArrayBlockingQueue`, `LinkedBlockingQueue`, and
`PriorityBlockingQueue` are supported in JDK 1.5. All are in the
`java.util.concurrent` package. `ArrayBlockingQueue` implements a blocking queue
using an array. You have to specify a capacity or an optional fairness to
construct an `ArrayBlockingQueue.` `LinkedBlockingQueue` implements a blocking
queue using a linked list. You may create an unbounded or bounded
`LinkedBlockingQueue.` `PriorityBlockingQueue` is a priority queue. You may
create an unbounded or bounded priority queue.

### Semaphores

Semaphores can be used to restrict the number of threads that access a shared
resource. Before accessing the resource, a thread must acquire a permit from the
semaphore. After finishing with the resource, the thread must return the permit
back to the semaphore.

#### Creating Semaphores

To create a semaphore, you have to specify the number of permits with an
optional fairness policy. A task acquires a permit by invoking the semaphore's
`acquire()` method and releases the permit by invoking the semaphore's
`release()` method. Once a permit is acquired, the total number of available
permits in a semaphore is reduced by 1. Once a permit is released, the total
number of available permits in a semaphore is increased by 1.

### Deadlock

Sometimes two or more threads need to acquire the locks on several shared
objects. This could cause deadlock, in which each thread has the lock on one of
the objects and is waiting for the lock on the other object. Consider the
scenario with two threads and two objects. Thread 1 acquired a lock on object1
and Thread 2 acquired a lock on object2. Now Thread 1 is waiting for the lock on
object2 and Thread 2 for the lock on object1. The two threads wait for each
other to release the in order to get the lock, and neither can continue to run.

Thread 1

```java
synchronized (object1) {
  // do something here
  synchronized (object2) { // Wait for Thread 2 to release the lock on object 2
    // do something here
  }
}
```

Thread 2

```java
synchronized (object2) {
  // do something here
  synchronized (object1) { // Wait for Thread 1 to release the lock on object 1
    // do something here
  }
}
```

#### Preventing Deadlock

Deadlock can be easily avoided by using a simple technique known as resource
ordering. With this technique, you assign an order on all the objects whose
locks must be acquired and ensure that each thread acquires the locks in that
order. For the example, suppose the objects are ordered as object1 and object2.
Using the resource ordering technique, Thread 2 must acquire a lock on object1
first, then on object2. Once Thread 1 acquired a lock on object1, Thread 2 has
to wait for a lock on object1. So Thread 1 will be able to acquire a lock on
object2 and no deadlock would occur.

### Thread States

A thread can be in one of five states: New, Ready, Running, Blocked, or
Finished.

### Synchronized Collections

The classes in the Java Collections Framework are not thread-safe, i.e., the
contents may be corrupted if they are accessed and updated concurrently by
multiple threads. You can protect the data in a collection by locking the
collection or using synchronized collections.

The Collections class provides six static methods for wrapping a collection into
a synchronized version. The collections created using these methods are called
synchronization wrappers.

### The Fork/Join Framework

The widespread use of multicore systems has created a revolution in software. In
order to benefit from multiple processors, software needs to run in parallel.

JDK 7 introduces the new Fork/Join Framework for parallel programming, which
utilizes the multicore processors.

### Vector, Stack, and Hashtable

Invoking synchronizedCollection(Collection c) returns a new Collection object,
in which all the methods that access and update the original collection c are
synchronized. These methods are implemented using the synchronized keyword. For
example, the add method is implemented like this:

```java
public boolean add(E o) {
  synchronized (this) { return c.add(o); }
}
```

The synchronized collections can be safely accessed and modified by multiple
threads concurrently.

The methods in java.util.Vector, java.util.Stack, and Hashtable are already
synchronized. These are old classes introduced in JDK 1.0. In JDK 1.5, you
should use java.util.ArrayList to replace Vector, java.util.LinkedList to
replace Stack, and java.util.Map to replace Hashtable. If synchronization is
needed, use a synchronization wrapper.

### Fail-Fast

The synchronization wrapper classes are thread-safe, but the iterator is
fail-fast. This means that if you are using an iterator to traverse a collection
while the underlying collection is being modified by another thread, then the
iterator will immediately fail by throwing
`java.util.ConcurrentModificationException`, which is a subclass of
`RuntimeException`. To avoid this error, you need to create a synchronized
collection object and acquire a lock on the object when traversing it. For
example, suppose you want to traverse a set, you have to write the code like
this:

```java
Set hashSet = Collections.synchronizedSet(new HashSet());
synchronized (hashSet) { // Must synchronize it
  Iterator iterator = hashSet.iterator();
  while (iterator.hasNext()) {
    System.out.println(iterator.next());
  }
}
```

Failure to do so may result in nondeterministic behavior, such as
`ConcurrentModificationException`.


<br>

# Resources

  - [*Concurrency](file:../../../../../../files/summer-2020/CISC-191/week-5/concurrency.ppt)
    - [TaskThreadDemo.java](https://liveexample.pearsoncmg.com/html/TaskThreadDemo.html)
    - [FlashTest.java](https://liveexample.pearsoncmg.com/html/FlashText.html)
    - [ExecutorDemo.java](https://liveexample.pearsoncmg.com/html/ExecutorDemo.html)
    - [AccountWithoutSync.java](https://liveexample.pearsoncmg.com/html/AccountWithoutSync.html)
    - [AccountWithSyncUsingLock](https://liveexample.pearsoncmg.com/html/AccountWithSyncUsingLock.html)
    - [ThreadCooperation.java](https://liveexample.pearsoncmg.com/html/ThreadCooperation.html)
    - [ConsumerProducer.java](https://liveexample.pearsoncmg.com/html/ConsumerProducer.html)
    - [ConsumerProducerUsingBlockingQueue.java](https://liveexample.pearsoncmg.com/html/ConsumerProducerUsingBlockingQueue.html)
  - [`Basic Threading](https://www.youtube.com/watch?v=F-CkaU8aQZI)
  - [`Advanced Threading: Locking, ThreadPools](https://www.youtube.com/watch?v=G2Xd5avyk_0)
  - [`Advanced Java: Multi-threading Playlist](https://www.youtube.com/watch?v=YdlnEWC-7Wo&list=PLBB24CFB073F1048E&index=1)

