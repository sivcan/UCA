#include <stdio.h>

int find_max(int x, int y) {
    int c = (x - y) >> 31 & 0x1;
    return x-c*(x-y);
}

int main() {
    printf("\nFind max of two numbers without if else etc.");
    printf("\nThe max of 6 and 7 is : %d\n", find_max(6,7));
    return 0;
}
