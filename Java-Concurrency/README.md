Reference:
https://www.vogella.com/tutorials/JavaConcurrency/article.html

Concurrency is the ability to run several program or several parts of the program in parallel.

A process runs independently and isolated. 
A thread is a lightweight process. It has its own call stack, 
but can access shared data of other threads in the same process.

By default a Java application runs in a single process.

2 basic problems with thread are visibility and access.
A visibility problem occurs if Thread A reads shared data which is later changed by Thread B and Thread A is unaware of this change.
An access problem can occur if several threads access and change the same shared data at the same time.

This can lead to liveness failure, that is, program can go in deadlock, and safety failure, that is, the program creates incorrect data.

### Synchronized Keyword

The simplest way of locking a certain method or a class is to define the method or the class with synchronized keyword.
This keyword ensures that 
* only a single thread can execute the block of code at the same time.
* each thread entering the block sees the effects of all previous modifications that were guarded by the same lock.

### Volatile Keyword

If a variable is declared with the volatile keyword then it is guaranteed that any thread that reads the field will see the most recent change. 
Write access to a volatile variable will also update non volatile variables which were modified by the same thread.

### Atomic Operation
An atomic operation is an operation which is performed as a single unit of work without the possibility of interference from other operations.

### Immutability
Simplest way to avoid problems with concurrency is to share only immutable data between threads.
For all mutable fields e.g Arrays that are passed from the outside to the class during the construction phase, the class needs to make a defensive copy of the elements to make sure that no other object from the outside can change the data.

### Defensive copies
To protect your class against change in data in an unexpected way, always copy data that you receive and only return copies of data to calling code.

### Threads in Java
The base means for 