#include <stdio.h>

int main(int argc, char * argv[]) {
    int sum = 0;
    for(int i = 1; i < argc; i++) {
        int x;
        sscanf(argv[i], "%d", &x); //Better than atoi. When using it in different encoding styles, atoi does not perform upto the mark.
        sum += x;
    }
    printf("\nThe sum is : %d\n", sum);
    return 0;
}
