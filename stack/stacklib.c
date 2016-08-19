//Implementing stack.h file.
//Design Paradigm is "Modular Programming"
//Modular Programming is the dissociation of interface from definition
#include <stdlib.h>

struct Node {
    int item;
    struct Node *next;
};

static struct Node *first = NULL;
static int n = 0;

void push(int item) {
    struct Node *oldFirst = first;
    first = (struct Node *)malloc(sizeof(struct Node));
    first->item = item;
    first->next = oldFirst;
    n++; //Size of the stack incremented
}

int pop() {
    struct Node *oldFirst = first;
    int item = oldFirst->item;
    first = first->next;
    oldFirst->next = NULL; //Advisable to do so because different languages have different garbage management.
    n--; // Size of the stack decremented
    free(oldFirst);
    return item;
}

int size() {
    return n;
}

//Command for linking the stack to it is : gcc -c stack.c
//This creates an object file "stack.o"
//Command : ar -cvr library_name( libstack.a )  stack.o
//This will create a library which will contain "stack.o"
//Now you can include that library with the code that you want to use your library with.
