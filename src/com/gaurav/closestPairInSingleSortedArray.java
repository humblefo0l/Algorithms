/*
Given a sorted array and a number x, find the pair in array whose sum is closest to x
Given a sorted array and a number x, find a pair in array whose sum is closest to x.
Examples:

Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
A simple solution is to consider every pair and keep track of closest pair (absolute difference between pair sum and x is minimum). Finally print the closest pair. Time complexity of this solution is O(n2)

An efficient solution can find the pair in O(n) time. The idea is similar to method 2 of this post. Following is detailed algorithm.

1) Initialize a variable diff as infinite (Diff is used to store the
   difference between pair and x).  We need to find the minimum diff.
2) Initialize two index variables l and r in the given sorted array.
       (a) Initialize first to the leftmost index:  l = 0
       (b) Initialize second  the rightmost index:  r = n-1
3) Loop while l < r.
       (a) If  abs(arr[l] + arr[r] - sum) < diff  then
           update diff and result
       (b) Else if(arr[l] + arr[r] <  sum )  then l++
       (c) Else r--
*/

package com.gaurav;

public class closestPairInSingleSortedArray {
    public static void main(String[] args) {
        int[] array = {1,4,5,6,8,9,10,20,30};
        int x = 15;

        printClosestPair(array, x);
    }

    static void printClosestPair(int[] array, int x){
        int r=0, l = array.length-1;
        int s=0, h=0;
        int min = Integer.MAX_VALUE;
        while (r<array.length && l>=0){
            int total = array[r] + array[l];
            int diff = Math.abs(total - x);
            if (diff < min){
                min = diff;
                s = r;
                h = l;
            }

            if (total < x)
                r++;
            else
                l--;
        }

        System.out.println("Closest Pair is: " + array[s] + " and " + array[h]);
    }
}
