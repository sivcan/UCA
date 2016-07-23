 #include <stdio.h>

 //Time Complexity : O(logN)
 //Approach Used : Binary Search

int mid;
int first(int arr[], int low, int high, int x)
{
	mid = (low+high)/2;
	if( (mid == 0 || x > arr[mid-1] ) && arr[mid] == x )
	{
		return mid;
	}
	else if( arr[mid] < x )
	{
		return first(arr, mid + 1, high, x);
	}
	else
	{
		return first(arr, low, mid - 1, x);
	}
	return -1;
}

int last(int arr[], int low, int high, int x)
{
	mid = (low + high)/2;
	if( ( mid == high || x < arr[mid+1] ) && arr[mid] == x )
	{
		return mid;
	}
	else if( arr[mid] > x )
	{
		return last(arr, low, (mid - 1), x);
	}
	else
	{
		return last(arr, (mid + 1), high, x);
	}
	return -1;
}

int binary(int arr[], int data, int end)
{
	int low = first(arr, 0, end-1, data);
	//printf("\nThe location of low = %d", low);
	if(low == -1)
		return low;
	int high = last(arr, low, end-1, data);
	return (high-low+1);
}

int main(void) {
	int arr[] = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
	int x = 1;
	int n = sizeof(arr)/sizeof(arr[0]);
	printf("\nThe number of occurences  : %d\n", binary(arr,x,n));
	return 0;
}
