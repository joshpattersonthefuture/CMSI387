#include <stdio.h>
#include <linux/kernel.h>
#include <sys/syscall.h>
#include <unistd.h>
int main()
{
         long int test = syscall(548);
         printf("System call sys_hello returned %ld\n", test);
         return 0;
}
