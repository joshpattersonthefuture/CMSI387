//Authors: Joshua Patterson & Alex Richardson
//Date: Apr 5, 2019
//Purpose: To solve the Dining Philosophers problem with deadlock avoidance
#include <stdio.h>
#include <time.h>
#include <pthread.h>

#define Philo 5   //5 philosophers number 0-4
pthread_t philosophers[Philo];
pthread_mutex_t forks[Philo];
pthread_attr_t tattr[Philo];
void *philosopher(void *);
void think(int);
void grab(int);
void eat(int);
void drop(int);

void think(int seat) {
	printf("Philosopher %d thinks...\n", seat);
  sleep(5);
}

void eat(int seat) {
	printf("Philosopher %d eats \n", seat);
	sleep(5);
}
void grab(int seat) {
	int forkRight = (seat + 1) % Philo;
	int forkLeft = (seat + Philo) % Philo;
	if (seat & 1) {
		printf("Philosopher %d wants fork %d\n", seat, forkRight);
		pthread_mutex_lock(&forks[forkRight]);
		printf("Philosopher %d grabbed fork %d\n", seat, forkRight);
		printf("Philosopher %d wants fork %d\n", seat, forkLeft);
		pthread_mutex_lock(&forks[forkLeft]);
		printf("Philosopher %d grabbed fork %d\n", seat, forkLeft);
	}
	else {
		printf("Philosopher %d wants fork %d\n", seat, forkLeft);
		pthread_mutex_lock(&forks[forkLeft]);
		printf("Philosopher %d grabbed fork %d\n", seat, forkLeft);
		printf("Philosopher %d wants fork %d\n", seat, forkRight);
		pthread_mutex_lock(&forks[forkRight]);
		printf("Philosopher %d grabbed fork %d\n", seat, forkRight);
	}
}


void drop(int seat) {
  int seats= seat+1;
	printf("Philosopher %d dropped their fork \n", seat);
	pthread_mutex_unlock(&forks[(Philo + seat) % Philo]);
	pthread_mutex_unlock(&forks[(seats) % Philo]);
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
	int k;
	for (k = 0; k < Philo; ++k) {
		pthread_mutex_init(&forks[k], 0);
	}
	for (k = 0; k < Philo; ++k) {
		pthread_create(&philosophers[k], &tattr[k], philosopher, (void *)(k));
	}
	for (k = 0; k < Philo; ++k) {
		pthread_join(philosophers[k], 0);
	}
	return 0;
}
