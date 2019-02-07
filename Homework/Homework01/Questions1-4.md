## Homework 1
### By: Alex Richardson and Josh Patterson

1. What is the difference between an operating system and middleware?

Middleware is the intermediary software between application programs and operating systems.

2. What is the relationship between threads and processes?

A process is a container for threads. When a user executes a task via some form of input, like a click or key-press, they start a process which can have one or more threads, concurrent sets of programmed actions. The process would have multiple threads if it needs two or more threads to run synchronously. The operating system naturally runs multiple threads simultaneously, often from many different processes.

3. Of all the topics previewed in chapter one of the text book, which one are you most looking forward to learning more about? Why?

Josh: I am looking forward to learning more about security for operating systems and middleware. Having a more broad view of system security would allow me to be more productive for a future in software development and website database building.

4. Suppose thread A goes through a loop 100 times, each time performing one disk I/O operation, taking 10 milliseconds, and then some computation, taking 1 millisecond. While each 10-millisecond disk operation is in progress, thread A cannot make any use of the processor. Thread B runs for 1 second, purely in the processor, with no I/O. One millisecond of processor time is spent each time the processor switches threads; other than this switching cost, there is no problem with the processor working on thread B during one of thread A's I/O operations. (The processor and disk drive do not contend for memory access bandwidth, for example.)

- Suppose the processor and disk work purely on thread A until its completion, and then the processor switches to thread B and runs all of that thread. What will the total elapsed time be?

1 iteration = 10 ms Thread A disk I/O + 1 ms Thread A computation

100 * (10 + 1 ms) + 1000 ms + 1ms = 2.101 sec

- Suppose the processor starts out working on thread A, but every time thread A performs a disk operation, the processor switches to B during the operation and then back to A upon the disk operation's completion. What will the total elapsed time be?

1 iteration = 10 ms Thread A disk I/O while 10 ms Thread B computation + 1 ms switch + 1 ms Thead A computation  + 1 ms switch

100 * (10 ms + 1 ms + 1 ms + 1 ms) = 1.3 sec

- In your opinion, which do you think is more efficient, and why?

It is more efficient to work on Thread B while Thread A is doing disk I/O because the switch time is much less than the disk I/O time. Since a switch takes 1 ms and Thread A's disk I/O takes 10 ms, that's 8 ms that would be wasted doing nothing if you didn't switch the processor over.
