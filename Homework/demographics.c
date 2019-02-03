#include <stdio.h>
int main()
{
    char name[100];
    int age;
    char classYear[100];
    char from[100]; 

    printf("What is your name : ");
    scanf("%s", name);
    printf("What is your age : ");
    scanf("%d", &age);
    printf("What is your class year : ");
    scanf("%s", classYear);
    printf("Where are you from : ");
    scanf("%s", from);

    printf("Name: %s, Age:%d, Class Year: %s, From: %s \n", name, age, classYear, from);

    return 0;
}