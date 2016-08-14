#include <stdio.h>
#include <string.h>

int strcmper() {
    return 0;
}

int inter() {
    return 0;
}

void sorter(int arr[], int n, int (*fp)) {
    for(int i = 0; i < n; i++) {
        printf("\nHello ");
    }
}

//Driver Program
int main(int argc, char *argv[]) {

    int arr[] = {1,2,3,2,4,4,3,2};
    int n = sizeof(arr)/sizeof(arr[0]);
    int *fp;
    if(!strcmp(argv[1],"-n")) {
        sorter(arr,n,inter);
    }
    if(!strcmp(argv[1],"-f")) {

    }
    if(!strcmp(argv[1],"-r")) {

    }
    return 0;
}
