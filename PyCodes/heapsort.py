#Program for HeapSort
#Time Complexity : O(nlogn)
#Language : Python 2.7


def max_heapify(i,n):
    left = 2*i
    right = 2*i + 1
    largest = i
    if left < n and arr[left] > arr[i] :
        largest = left
    if right < n and arr[right] > arr[largest] :
        largest = right

    if largest != i :
        arr[i],arr[largest] = arr[largest],arr[i]
        max_heapify(largest,n)

def build_maxheap():
    for i in range(l/2-1, 0,-1):
        max_heapify(i,l)

def display():
    for i in range(1,len(arr)):
        print arr[i],
        print " ",

def heapSort():
    build_maxheap()
    heap_size = len(arr)
    l = len(arr)
    for i in range(l-1,1,-1) :
        arr[1], arr[i] = arr[i], arr[1]
        heap_size -= 1
        max_heapify(1,heap_size)
    display()

arr = [0,3,4,5,6,4,4,3,2,9,1,11]
l = len(arr)
heapSort()
