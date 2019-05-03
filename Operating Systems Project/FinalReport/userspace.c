#include <linux/kernel.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/syscall.h>

int main()
{
         long int Test = syscall(548);
         printf("system call sys_hello = %ld\n", Test);
         return 0;
}
