#include <stdio.h>
#include <stdlib.h>

int main( int argc, char * argv[] ) {

  char str[50];
  printf("\n\n Enter a planet : \n\n");
  gets(str);

  printf(" \n\n You said: Hello %s \n\n", str);
  return(0);

}

