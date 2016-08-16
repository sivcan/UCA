#include <stdio.h>
#include "stack.h"
#include <stdlib.h>
//Client file
int main() {
    push(3);
    push(5);
    push(7);
    printf("%d\n", pop());
    return 0;
}

//Command to compile this code :
//gcc stack.c -L. -libstack
