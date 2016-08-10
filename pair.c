// Q. In a sorted array find a pair who's sum closest to x.
// Eg : 10,20,30,32,60
// x = 53
// Ans : 20,32

#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int a[] = {10,20,30,32,60};
    int x = 65;
    int i = 0;
    int j = (sizeof(a)/sizeof(a[0]));
    int diff = 999999;
    int x1, x2;
    for(i = 0; i < j;) {
            if(abs(a[i] + a[j] - x) < diff) {
                x1 = a[i];
                x2 = a[j];
                diff = abs(a[i] + a[j] - x);
            }
            else if((a[i] + a[j]) > x) j--;
            else i++;
    }
    printf("\nThe resultant pair is : (%d,%d)\n", x1, x2);
}
