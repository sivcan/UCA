#include <stdio.h>
#include <string.h>

int main() {
    char input[100];
    char res[100];
    int max = 0;
    while(1) {
        scanf("%s", input);
        if(input[0] == '\0')
            break;
        if(strlen(input) > max) {
            max = strlen(input);
            strcpy(res, input);
        }

    }

    printf("%s", input);
}
