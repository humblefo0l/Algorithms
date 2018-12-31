/*
* Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n-1]’ is
* sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
Examples:

 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
                 {20, 5, 10, 2, 80, 6, 100, 3} OR
                 any other array that is in wave form

 Input:  arr[] = {20, 10, 8, 6, 4, 2}
 Output: arr[] = {20, 8, 10, 4, 6, 2} OR
                 {10, 8, 20, 2, 6, 4} OR
                 any other array that is in wave form

 Input:  arr[] = {2, 4, 6, 8, 10, 20}
 Output: arr[] = {4, 2, 8, 6, 20, 10} OR
                 any other array that is in wave form

 Input:  arr[] = {3, 6, 5, 10, 7, 20}
 Output: arr[] = {6, 3, 10, 5, 20, 7} OR
any other array that is in wave form

A Simple Solution is to use sorting. First sort the input array, then swap all adjacent elements.

For example, let the input array be {3, 6, 5, 10, 7, 20}. After sorting, we get {3, 5, 6, 7, 10, 20}. After swapping adjacent elements, we get {5, 3, 7, 6, 20, 10}.

Below are implementations of this simple approach.
*/

package com.gaurav;

import java.util.Arrays;

public class sortArrayInWaveForm {
    public static void main(String[] args) {
        int[] array = {10, 90, 49, 2, 1, 5, 23};

//        sortArrayInWaveForm(array);
        sortArrayinWaveFormInOofN(array);
        for (int i: array){
            System.out.print(i + " ");
        }
    }

    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void sortArrayInWaveForm(int[] array){

        Arrays.sort(array);

        for (int i=0; i<array.length-1; i+=2){
            swap(array, i, i+1);
        }

    }

    /*
      This can be done in O(n) time by doing a single traversal of given array. The idea is based on the fact that
      if we make sure that all even positioned (at index 0, 2, 4, ..) elements are greater than their adjacent
      odd elements, we don’t need to worry about odd positioned element. Following are simple steps.
        1) Traverse all even positioned elements of input array, and do following.
        ….a) If current element is smaller than previous odd element, swap previous and current.
        ….b) If current element is smaller than next odd element, swap next and current.
    */

    private static void sortArrayinWaveFormInOofN(int[] array){

        for (int i=0; i<array.length-1; i+=2){
            if (i>0 && array[i-1] > array[i]){
                swap(array, i-1, i);
            }

            if (i<array.length-1 &&  array[i] < array[i+1]){
                swap(array, i, i+1);
            }
        }
    }
}
