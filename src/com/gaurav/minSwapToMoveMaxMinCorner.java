/*
Minimum adjacent swaps to move maximum and minimum to corners
Given N number of elements, find the minimum number of swaps required so that the maximum element is at the
beginning and the minimum element is at last with the condition that only swapping of adjacent elements is allowed.

Examples:

Input: a[] = {3, 1, 5, 3, 5, 5, 2}
Output: 6
Step 1: Swap 5 with 1 to make the array as {3, 5, 1, 3, 5, 5, 2}
Step 2: Swap 5 with 3 to make the array as {5, 3, 1, 3, 5, 5, 2}
Step 3: Swap 1 with 3 at its right to make the array as {5, 3, 3, 1, 5, 5, 2}
Step 4: Swap 1 with 5 at its right to make the array as {5, 3, 3, 5, 1, 5, 2}
Step 5: Swap 1 with 5 at its right to make the array as {5, 3, 3, 5, 5, 1, 2}
Step 6: Swap 1 with 2 at its right to make the array as {5, 3, 3, 5, 5, 2, 1}
After performing 6 swapping operations 5 is at the beginning and 1 at the end

Input: a[] = {5, 6, 1, 3}
Output: 2

The approach will be to find the index of the largest element(let l). Find the index of the leftmost largest element
if largest element appears in the array more than once. Similarly, find the index of the rightmost smallest
element(let r). There exists two cases to solve this problem.

Case 1: If l < r: Number of swaps = l + (n-r-1)
Case 2: If l > r: Number of swaps = l + (n-r-2), as one swap has already been performed while swapping the larger
element to the front
*/

package com.gaurav;

public class minSwapToMoveMaxMinCorner {
    public static void main(String[] args) {
        int a[] = { 5, 6, 1, 3 };
        minimumSwaps(a);
    }

    static void minimumSwaps(int[] array){
        int length = array.length;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int r=-1,l=-1;
        for (int i=0; i<array.length; i++){
            if (array[i]>max){
                max = array[i];
                l=i;
            }

            if (array[i]<min){
                min = array[i];
                r=i;
            }
        }

        System.out.println("Minimum adjacent swaps to move maximum and minimum to corners: ");
        if (l < r)
            System.out.println(l + (length-r-1));
        else
            System.out.println(l + (length-r-2));
    }
}
