//Authors: Alex Richardson & Joshua Patterson
//Date: February 6, 2019
//Purpose: To write a program in C to prompt the user demographic information including name, age, class year, and any three other data times you wish.
//Question # 7

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
