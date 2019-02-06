#include <pthread.h>
#include <unistd.h>
#include <stdio.h>
static void *child(void *ignored) {
        sleep(3);
        printf("Child is done sleeping 3 seconds. \n");
        return NULL;
  }


int main(int argc, char *argv[]){
    char str[50];
    pthread_t child_thread;
    pthread_create(&child_thread, NULL, child, NULL);
    printf("Press Enter to KILL the thread. \n");
    scanf("%c", str);
    pthread_cancel(child_thread);
    printf("Thread has been KILLED. \n");
    return 0;
}
