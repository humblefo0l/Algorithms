/*
Find k closest elements to a given value
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
Examples:

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42,
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
It is assumed that all elements of array are distinct.
 */

package com.gaurav;

public class kClosestElementInArray {
    public static void main(String[] args) {
        int[] array = new int[]{10,20,30,35,40};
        int x = 32;
        int k = 3;
        printKClosestElement(array, x, k);
    }

    private static void printKClosestElement(int[] array, int x, int k){
        int right, left;
        int mid = findCrossOverPoint(array, 0, array.length-1, x);

        right = mid+1;
        left = mid;

        if (array[mid] == x)
            left--;

        int count=0;
        while ((left >= 0) && (right <= array.length) && (count++<k)){

            if ((array[mid]-array[left]) <= (array[right] - array[mid]))
                System.out.print(array[left--] + " ");
            else
                System.out.print(array[right++] + " ");
        }


        while ((left >=0) && (count++ < k)){
            System.out.print(array[left--] + " ");
        }

        while ((right < array.length) && (count++ < k)){
            System.out.print(array[right++] + " ");
        }

    }

    private static int findCrossOverPoint(int[] array, int low, int high, int x){
        if (array[high] <= x)
            return high;

        if (array[low] >x)
            return low;

        int mid = (low+high)/2;

        if (array[mid] <= x && array[mid+1] > x){
            return mid;
        }

        if (array[mid] < x)
            return findCrossOverPoint(array, mid+1, high, x);

        return findCrossOverPoint(array, low, mid-1, x);
    }
}
