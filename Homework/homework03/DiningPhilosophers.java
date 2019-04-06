//Authors: Joshua Patterson & Alex Richardson
//Date: Apr 5, 2019
//Purpose: To solve the Dining Philosophers problem with deadlock avoidance
#include <time.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

#define Philo 5   //5 philosophers number 0-4
pthread_t philosophers[Philo];
pthread_mutex_t chopsticks[Philo];
pthread_attr_t tattr[Philo];
void *philosopher(void *);
void think(int);
void grab(int);
void eat(int);
void drop(int);

void think(int seat) {
	int random = rand() % 5 + 1;
	printf("Philosopher %d thinking for %d seconds\n", seat, random);
	sleep(random);
}

void grab(int seat) {
	int right = (seat + 1) % Philo;
	int left = (seat + Philo) % Philo;
	if (seat & 1) {
		printf("Philosopher %d wants chopstick %d\n", seat, right);
		pthread_mutex_lock(&chopsticks[right]);
		printf("Philosopher %d grabbed chopstick %d\n", seat, right);
		printf("Philosopher %d wants chopstick %d\n", seat, left);
		pthread_mutex_lock(&chopsticks[left]);
		printf("Philosopher %d grabbed chopstick %d\n", seat, left);
	}
	else {
		printf("Philosopher %d wants chopstick %d\n", seat, left);
		pthread_mutex_lock(&chopsticks[left]);
		printf("Philosopher %d grabbed chopstick %d\n", seat, left);
		printf("Philosopher %d wants chopstick %d\n", seat, right);
		pthread_mutex_lock(&chopsticks[right]);
		printf("Philosopher %d grabbed chopstick %d\n", seat, right);
	}
}

void eat(int seat) {
	int random2 = rand() % 5 + 1;
	printf("Philosopher %d eating for %d seconds\n", seat, random2);
	sleep(random2);
}

void drop(int seat) {
	printf("Philosopher %d dropped their chopstick! \n", seat);
	pthread_mutex_unlock(&chopsticks[(seat + 1) % Philo]);
	pthread_mutex_unlock(&chopsticks[(seat + Philo) % Philo]);
}


void *philosopher(void *seat) {
	while (1) {
		think(seat);
		grab(seat);
		eat(seat);
		drop(seat);
	}
}

int main() {
	int i;
	for (i = 0; i < Philo; ++i) {
		pthread_mutex_init(&chopsticks[i], NULL);
	}
	for (i = 0; i < Philo; ++i) {
		pthread_attr_init(&tattr[i]);
	}
	for (i = 0; i < Philo; ++i) {
		pthread_create(&philosophers[i], &tattr[i], philosopher, (void *)(i));
	}
	for (i = 0; i < Philo; ++i) {
		pthread_join(philosophers[i], NULL);
	}
	return 0;
}
