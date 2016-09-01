mergeSort(int a[],int aux[],int start, int end){
	if(end<=start) return 0;
	int mid = (end+start)/2;
	mergeSort(a,aux,start,mid);
	mergeSort(a,aux,mid+1,end);
	merge(a,aux,start,mid,end);
}

merge(int a[],int aux[],int start, int mid, int end){
	int i = start;
	int j = mid+1;
	int k;
	for(k = start; k <= end; k++){
		if(i>mid)
			aux[k] = a[j++];
		else if(j>end)
			aux[k] = a[i++];
		else if(a[i]>a[j])
			aux[k] = a[j++];
		else
			aux[k] = a[i++];
	}
	for(k=start;k<=end;k++){
		a[k] = aux[k];
	}
}
