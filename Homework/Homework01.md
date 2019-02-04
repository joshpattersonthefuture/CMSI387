## Homework 1
### By: Alex Richardson and Josh Patterson

1. What is the difference between an operating system and middleware?

Middleware is the intermediary software between application programs and operating systems.

2. What is the relationship between threads and processes?

A process is a container for threads. When a user executes a task via some form of input, like a click or key-press, they start a process which can have one or more threads, concurrent sets of programmed actions. The process would have multiple threads if it needs two or more threads to run synchronously. The operating system naturally runs multiple threads simultaneously, often from many different processes.

3. Of all the topics previewed in chapter one of the text book, which one are you most looking forward to learning more about? Why?

4. Suppose thread A goes through a loop 100 times, each time performing one disk I/O operation, taking 10 milliseconds, and then some computation, taking 1 millisecond. While each 10-millisecond disk operation is in progress, thread A cannot make any use of the processor. Thread B runs for 1 second, purely in the processor, with no I/O. One millisecond of processor time is spent each time the processor switches threads; other than this switching cost, there is no problem with the processor working on thread B during one of thread A's I/O operations. (The processor and disk drive do not contend for memory access bandwidth, for example.)

- Suppose the processor and disk work purely on thread A until its completion, and then the processor switches to thread B and runs all of that thread. What will the total elapsed time be?

- Suppose the processor starts out working on thread A, but every time thread A performs a disk operation, the processor switches to B during the operation and then back to A upon the disk operation's completion. What will the total elapsed time be?

- In your opinion, which do you think is more efficient, and why?

5. Find and read the documentation for pthread_cancel(). Then, using your C programming environment, use the information and the model provided in Figure 2.4 on page 26 of the text book to write a program in which the initial (main) thread creates a second thread. The main thread should read input from the keyboard, waiting until the user presses the Enter key. At that point, it should kill off the second thread and print out a message reporting that it has done so. Meanwhile, the second thread should be in an infinite loop, each time around sleeping five seconds and then printing out a message. Try running your program. Can the sleeping thread print its periodic messages while the main thread is waiting for keyboard input? Can the main thread read input, kill the sleeping thread, and print a message while the sleeping thread is in the early part of one of its five-second sleeps?

6. Suppose a system has three threads (T1, T2, and T3) that are all available to run at time 0 and need one, two, and three seconds of processing, respectively. Suppose each thread is run to completion before starting another. Draw six different Gantt charts, one for each possible order the threads can be run in. or each chart, compute the turnaround time of each thread; that is, the time elapsed from when it was ready (time 0) until it is complete. Also, compute the average turnaround time for each order. Which order has the shortest average turnaround time? What is the name of the scheduling policy that produces this order?

7. Google the C standard library API and find out how to get information from the command line by using a printf() call to display a prompt, then another call [which you will look up] to get the user input. Write a program in C to prompt the user demographic information including name, age, class year, and any three other data times you wish. Structure the program as a call-and-response program such that each data item is a single question with a single answer. When all data has been obtained, display the data on the console. Each data item must be on a separate line, and it must be appropriately labeled. The output must be done using a single printf() statement.

```
#include <stdio.h>
int main()
{
    char name[100];
    int age;
    char classYear[100];
    char from[100]; 
    char gender[100]; 

    printf("What is your name : ");
    scanf("%s", name);
    printf("What is your age : ");
    scanf("%d", &age);
    printf("What is your class year : ");
    scanf("%s", classYear);
    printf("Where are you from : ");
    scanf("%s", from);
    printf("What is your gender : ");
    scanf("%s", gender);

    printf("Your Info: \n\tName: %s \n\tAge:%d \n\tClass Year: %s \n\tFrom: %s \n\tGender: %s \n", name, age, classYear, from, gender);

    return 0;
}
```
