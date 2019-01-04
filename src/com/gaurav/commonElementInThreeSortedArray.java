/*
Find common elements in three sorted arrays
Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
Examples:

ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80

ar1[] = {1, 5, 5}
ar2[] = {3, 4, 5, 5, 10}
ar3[] = {5, 5, 10, 20}
Output: 5, 5

A simple solution is to first find intersection of two arrays and store the intersection in a temporary array,
then find the intersection of third array and temporary array. Time complexity of this solution is O(n1 + n2 + n3)
where n1, n2 and n3 are sizes of ar1[], ar2[] and ar3[] respectively.

The above solution requires extra space and two loops, we can find the common elements using a single loop and without
extra space. The idea is similar to intersection of two arrays. Like two arrays loop, we run a loop and traverse three
arrays.

Let the current element traversed in ar1[] be x, in ar2[] be y and in ar3[] be z. We can have following cases inside
the loop.
1) If x, y and z are same, we can simply print any of them as common element and move ahead in all three arrays.
2) Else If x < y, we can move ahead in ar1[] as x cannot be a common element.
3) Else If y and y > z), we can simply move ahead in ar3[] as z cannot be a common element.

Time complexity of the above solution is O(n1 + n2 + n3). In worst case, the largest sized array may have all small
elements and middle sized array has all middle elements.

*/


package com.gaurav;

public class commonElementInThreeSortedArray {
    public static void main(String[] args) {
        int array1[] = {1, 5, 10, 20, 40, 80};
        int array2[] = {6, 7, 20, 80, 100};
        int array3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.print("Common elements are ");
        findCommonElement(array1, array2, array3);
    }

    static void findCommonElement(int[] array1, int[] array2, int[] array3){
        int i=0,j=0,k=0;

        while (i<array1.length && j<array2.length && k<array3.length){
            if (array1[i] == array2[j] && array2[j] == array3[k]){
                System.out.print(array1[i] + " ");
                j++; i++;
                k++;
            }else if (array1[i] < array2[j]){
                i++;
            }
            else if (array2[j] < array3[k]){
                j++;
            }
            else {
                k++;
            }
        }
    }
}
