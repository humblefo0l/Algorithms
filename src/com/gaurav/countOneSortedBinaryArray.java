/*
Count 1’s in a sorted binary array
Given a binary array sorted in non-increasing order, count the number of 1’s in it.
Examples:

Input: arr[] = {1, 1, 0, 0, 0, 0, 0}
Output: 2

Input: arr[] = {1, 1, 1, 1, 1, 1, 1}
Output: 7

Input: arr[] = {0, 0, 0, 0, 0, 0, 0}
Output: 0
A simple solution is to linearly traverse the array. The time complexity of the simple solution is O(n).
We can use Binary Search to find count in O(Logn) time. The idea is to look for last occurrence of 1 using Binary
Search. Once we find the index last occurrence, we return index + 1 as count.
*/

package com.gaurav;

public class countOneSortedBinaryArray {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 0, 0, 0};
        int n = arr.length;
        int count = countOnes(arr, 0, n-1);
        System.out.println("Count of 1's in given array is " + (count+1));
    }

    static int countOnes(int[] array, int start, int end){
        if (end > start) {

            if (array[end] == 1)
                return end;

            int mid = start + (end - start) / 2;

            if ((mid == end || array[mid + 1] == 0) && (array[mid] == 1))
                return mid;

            if (array[mid] != 1) {
                return countOnes(array, start, mid - 1);
            } else {
                return countOnes(array, mid + 1, end);
            }
        }
        return 0;
    }
}
