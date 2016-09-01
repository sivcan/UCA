#include <stdio.h>

void merge(int arr[], int beg, int mid, int end)
{
	int i = beg;
	int j = mid + 1, k = beg, brr[100];
	while(i <= mid && j <= end)
	{
		if(arr[i] < arr[j])
		{
			brr[k] = arr[i];
			i++;
		}
		else
		{
			brr[k] = arr[j];
			j++;
		}
		k++;
	}

	if(i>mid) {
		while(j <= end) {
			brr[k++] = arr[j++];
		}
	}

	else {
		while(i <= mid) {
			brr[k++] = arr[i++];
		}
	}

	for(i = beg; i < k; i++)
	{
		arr[i] = brr[i];
	}
}

void merge_sort(int arr[], int beg, int end)
{
	int mid;
	if(beg < end)
	{
		mid = (beg + end)/2;
		merge_sort(arr, beg, mid);
		merge_sort(arr, mid + 1, end);
		merge(arr, beg, mid, end);
	}
}

int main()
{
	int arr[10];
	int n, i, j, beg, end;

	scanf("%d", &n);

	for(i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}

	beg = 0;
	end = n-1;

	merge_sort(arr, beg, end);

	for(i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
