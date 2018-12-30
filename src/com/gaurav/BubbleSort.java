package com.gaurav;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        int arr[] = {22,3,44,6,5,88,1,9,9,9,-1};
        obj.bubbleSort(arr);
        selectionSort.printResult(arr);
    }


    private void bubbleSort(int arr[]){
        int len = arr.length;

        for (int i=0; i<len-1; i++){
            for (int j=i+1; j<len; j++){
                System.out.println('-');
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}