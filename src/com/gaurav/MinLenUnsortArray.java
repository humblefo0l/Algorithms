/*
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that
sorting this subarray makes the whole array sorted.

Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to
find that the subarray lies between the indexes 3 and 8.

2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find that
the subarray lies between the indexes 2 and 5.
*/
package com.gaurav;

public class MinLenUnsortArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,5,7,4,3};
//        int[] array = new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
//        int[] array = new int[]{1,2,3};
        printMinLenUnsortedArray(array);
    }

    private static void printMinLenUnsortedArray(int[] array) {
        int max, min;
        int start, end;

        for (start = 0; start < array.length - 1; start++)
            if (array[start] > array[start + 1])
                break;

        if (start+1 == array.length) {
            System.out.println("Array is sorted");
            return;
        }

        for (end = array.length - 1; end > 0; end--)
            if (array[end] < array[end - 1])
                break;

        max = array[start];
        min = array[end];

        for (int i = start + 1; i <= end; i++) {
            if (max < array[i])
                max = array[i];

            if (min > array[i])
                min = array[i];
        }


        for (int i = 0; i < start; i++){
            if (array[i] > min) {
                start = i;
                break;
            }
        }

        for (int i=array.length-1; i>=end+1; i--) {
            if (array[i] <= max) {
                end = i;
                break;
            }
        }

        System.out.println("Subarray lies between indexes: "+start +", "+end);
    }
}
