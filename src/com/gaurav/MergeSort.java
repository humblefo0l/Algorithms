/*
Merge Sort
Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for
the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The
merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted
sub-arrays into one. See following C implementation for details.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
The following diagram from wikipedia shows the complete merge sort process for an example array
{38, 27, 43, 3, 9, 82, 10}. If we take a closer look at the diagram, we can see that the array is recursively divided
in two halves till the size becomes 1. Once the size becomes 1, the merge processes comes into action and starts
merging arrays back till the complete array is merged.

*/

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