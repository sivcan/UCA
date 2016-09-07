#include <stdio.h>
////////////////////////////// BUBBLE SORT ///////////////////////////////////////
/*void bubblesort(int arr[])
{
	int i, j, temp;
	for(i = 0; i < 6; i++)
	{
		for(j= 0; j < 5 - i; j++)
		{
			if(arr[j] > arr[j+1])
			{
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
	for(i = 0; i < 6; i++)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
}*/
///////////////////////////////////////////////////////////////////////////////////////

////////////////////////// INSERTION SORT /////////////////////////////////////////////
/*void insertionsort(int arr[])
{
	int i, j, hole, value;
	for(i = 1; i < 6; i++)
	{
		value = arr[i];
		hole = i;
		while(hole > 0 && arr[hole - 1] > value)
		{
			arr[hole] = arr[hole - 1];
			hole = hole - 1;
		}
		arr[hole] = value;
	}
	for(i = 0; i < 6; i++)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
}*/
//////////////////////////////////////////////////////////////////////////////////////

////////////////////////////// SELECTION SORT ////////////////////////////////////////
/*void selectionsort(int arr[])
{
	int i, j, min, temp;
	for(i = 0; i < 6; i++)
	{
		min = i;
		for(j = i+1; j < 6; j++)
		{
			if(arr[min] > arr[j])
			{
				min = j;
			}
		}
		temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
	for(i = 0; i < 6; i++)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
}*/
//////////////////////////////////////////////////////////////////////////////////////

int main()
{
	int arr[] = {8, 4, 9, 10, 5, 6};
	//bubblesort(arr);
	//insertionsort(arr);
	selectionsort(arr);
    return 0;
}