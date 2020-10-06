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

<a href="Concurrency-Vogella/src/main/java/CrawledSites.java">Code</a>

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

<a href="Concurrency-Vogella/src/main/java/MyList.java">Code</a>

### Threads in Java
The base means for concurrency is the java.lang.Thread class. 
A thread executes an object of type java.lang.Runnable

Runnable is an interface which defines the run() method.
This method is called by the Thread object and contains the work which should be done

<a href="Concurrency-Vogella/src/main/java/MyRunnable.java">Code</a>

Using the Thread class directly has the following disadvantages:
1. Creating a new thread causes performance overhead.
2. Too many threads can lead to reduced performance, as the CPU needs to switch between these threads.
3. You cannot easily control the number of threads, therefore you may run into out of memory errors due to too many threads.

**The `java.util.concurrent` package offers improved support for concurrency compared to the direct usage of `Threads`.
This package is described in the next section.**

### Thread Pools with the Executor Framework
Thread pools manage a pool of worker threads. The thread pools contain a work queue which holds the tasks waiting to get executed.

<a href="Concurrency-Vogella/src/main/java/ExampleExecutor.java">Code</a>

### Completable Future
Any time consuming task should be preferably done asynchronously. 
Two basic approaches for this that are available in java are :
1. application logic blocks until a task completes.
2. application logic is called once the task completes, i.e, a nonblocking approach.

CompletableFuture that extends Future interface supports async calls. 
It implements the CompletionStage interface. This interface offers methods that lets you attach callbacks that will 
be executed on completion.

CompletableFuture supports both blocking and non blocking approaches, including regular callbacks.
This callback can be executed in another thread as the thread in which the CompletableFuture is executed.

Creating a basic CompletableFuture
<br>

`CompletableFuture.supplyAsync(this::doSomething)`<br>
This runs the task asynchronously on the default thread pool of java.
It has the option to supply your custom executor to define ThreadPool.

<a href="Concurrency-Vogella/src/main/java/ExampleCompletableFuture.java">Code</a>

The `thenApply` can be used to define a callback which is executed once the `CompletableFuture.supplyAsync` finishes.

<a href="Concurrency-Vogella/src/main/java/ExampleCompletableFutureThenApply.java">Code</a>

You can also start a CompletableFuture delayed as of Java9.
<a href="Concurrency-Vogella/src/main/java/ExampleCompletableFutureDelayed.java">Code</a>

### Non-Blocking Algorithms
Non blocking algorithms are typically faster than blocking algorithms, 
as the synchronization of threads appear on a much finer level (hardware).

 <a href="Concurrency-Vogella/src/main/java/ExampleCompletableFutureThenApply.java">Code</a>