#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

struct Stack {
    int top;
    unsigned capacity;
    int *array;
};
//Initial function to create a stack, assign the struct a memory and then give the array inside the stack the space in memory to store integers.
struct Stack * createStack(unsigned capacity) {
    struct Stack *stack = (struct Stack *)malloc(sizeof(struct Stack)); //Initializing memory for the structure.

    if(!stack) return NULL;

    stack->top = -1;
    stack->capacity = capacity;
    stack->array = (int *)malloc(stack->capacity * sizeof(int)); // Initializing the array with the memory - capacity X sizeof(int).

    return stack;
}

int isEmpty(struct Stack *stack) {
    return stack->top == -1;  //Returns true if the top of stack = -1, thus the stack is empty.
}

char pop(struct Stack *stack) {  //Pops the character off the stack and decrements the value of top by 1.
        if(!isEmpty(stack))
            return stack->array[stack->top--];
        return '#';
}

void push(struct Stack *stack, char op) { //Function pushes the new char 'op' into the top of the stack and also increments the stack.
    stack->array[++stack->top] = op;
}

//Function to evaluate the postfix notation of the stack and thus return the result obtained.
int evaluatePostfix(char *x) {
    struct Stack *stack = createStack(strlen(x));
    int i;

    for(int i = 0; x[i]; i++) {
        if(isdigit(x[i])) { //If it is a digit then push it to the top of the stack.
            push(stack, x[i]-'0');
        }
        else {
            int val1 = pop(stack); //Get the top value of the stack into val2
            int val2 = pop(stack); //Get the next top value of the stack in val1
            switch(x[i]){
                case '*' : push(stack, val2 * val1); break; //push the obtained result to the stack.
                case '-' : push(stack, val2 - val1); break;
                case '+' : push(stack, val2 + val1); break;
                case '/' : push(stack, val2 / val1); break;
            }
        }
    }

    return pop(stack);
}

int main() {
    printf("\nProgram to implement stack!");
    char x[] = "231*+9-";
    printf("\nThe result of the stack is : %d\n", evaluatePostfix(x));
    return 0;
}
