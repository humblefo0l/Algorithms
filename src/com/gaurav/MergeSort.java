package com.gaurav;

public class MergeSort {

    public static void main(String[] args) {

        MergeSort obj = new MergeSort();
        SelectionSort selectionSort = new SelectionSort();

//        int[] arr = {4,3,7,5,99,1,12};
        int arr[] = {3,4,6,7,1,3,5,66};
        int start = 0;
        int end = arr.length -1;
        obj.mergeSort(arr, start, end);
        selectionSort.printResult(arr);
    }

    private void mergeSort(int[] arr, int start, int end){
        if(start<end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }


    private void merge(int[] arr, int start, int mid, int end){

        int n1 = mid-start+1;
        int n2 = end-mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i=0; i <n1; i++){
            L[i] = arr[start +i];
        }

        for (int j=0; j<n2; j++){
            R[j] = arr[mid+1+j];
        }

        int i=0, j=0;
        int k = start;

        while (i<n1 && j <n2){
            if(L[i] >= R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}