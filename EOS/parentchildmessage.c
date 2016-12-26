#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    int fd[2];
    char message[] = "Hello Parent!";
    pipe(fd);
    if(fork() == 0) {
        close(fd[0]);
        write(fd[1], &message, sizeof(message));
        printf("Child(%d) sent a message : %s\n", getpid(), message);
        close(fd[1]);
    }
    else {
        close(fd[1]);
        read(fd[0], &message, sizeof(message));
        printf("Parent(%d) received message : %s\n", getpid(), message);
        close(fd[0]);
    }
    return 0;
}
