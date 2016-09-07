#include<stdio.h>

int main(){ //Program for bubble sort
    int size;
    printf("\nEnter the size of the array : ");
    scanf("%d",&size);
    int arr[size];
    printf("\nEnter the elements : ");

    for(int i=0; i<size; i++){
            scanf("%d",&arr[i]);
    }
    int flag=0;
    for(int i=0; i<size-1; i++){
        flag=0;
        for(int j=0; j<size-1; j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                    flag=1;
                }
        }
        if(flag==0){
            break;
        }
    }

    //Print the sorted array.
    for(int i=0; i<size; i++){
        printf("%d ",arr[i]);
    }
    print("\n");
    return 0;
}
