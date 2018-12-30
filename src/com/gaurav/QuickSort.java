package com.gaurav;

public class QuickSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        QuickSort obj = new QuickSort();

        int arr[] = {3,5,6,7,1,44};

        obj.quickSort(arr, 0, 5);
        selectionSort.printResult(arr);
    }

    void quickSort(int[] arr, int start, int end){
        if (start<end){
            int partitionIndex = Partition(arr, start, end);

            quickSort(arr, start, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    int Partition(int[] arr, int start, int end){
        int partitionIndex = start;
        int pivot = arr[end];

        for (int i=0; i<arr.length; i++){

            if(arr[partitionIndex] < pivot){
                swap(arr, partitionIndex, i);
                partitionIndex++;
            }
        }

        swap(arr, partitionIndex, end);
        return partitionIndex;

    }

    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}