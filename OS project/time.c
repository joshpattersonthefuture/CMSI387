#include <stdio.h>
#include <time.h>
#include <string.h>

int main(int argc, char *argv[])
{
  time_t now;
  struct tm *tm_now;
  char buff[BUFSIZ];

  now = time ( NULL );
  tm_now = localtime ( &now );

    if (argc == 2){
      if (!strncmp(argv[1], "12hr", 4)) {
        strftime ( buff, sizeof buff, "%A, %x %I:%M:%S %p", tm_now ); //12
        printf ( "%s\n", buff );
        /* code */
      }
      if (!strncmp(argv[1], "24hr", 4)) {
        strftime ( buff, sizeof buff, "%A, %x %H:%M:%S", tm_now ); //24
        printf ( "%s\n", buff );
      }
    }
  return 0;
}
