#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int value = 5;
int main() {
	int pid_t, childId;
	childId = fork();
	printf("\nThe child id is : %d\n", childId);
	if(childId == 0) {
		value += 10;
        printf("Hi I am child process and value is : %d\n", value);
		return 0;
	} else {
		wait(NULL);
		printf("Hi, I am parent process and value is : %d\n",value); 
		return 0;
	}
}
