/*
We have discussed Overlapping Subproblems and Optimal Substructure properties.

Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic
Programming.
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for
{10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
longest-increasing-subsequence

More Examples:

Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

Optimal Substructure:
Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the
last element of the LIS.
Then, L(i) can be recursively written as:
L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
L(i) = 1, if no such j exists.
To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be solved using
solutions to subproblems.


Overlapping Subproblems:
Considering the above implementation, following is recursion tree for an array of size 4. lis(n) gives us the length
of LIS for arr[].

              lis(4)
        /        |
      lis(3)    lis(2)   lis(1)
     /           /
   lis(2) lis(1) lis(1)
   /
lis(1)

We can see that there are many subproblems which are solved again and again. So this problem has Overlapping
Substructure property and recomputation of same subproblems can be avoided by either using Memoization or Tabulation.

*/

package com.gaurav;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] array = {2,4,51,64,17,89,90};
//        int[] array = { 10, 22, 9, 33, 21, 50, 41, 60 };

        System.out.println("The longest increasing sequence is: " +lis(array));
    }

    static int lis(int[] array){
        int length = array.length;
        int[] temp_lis = new int[length];
        int max = Integer.MIN_VALUE;

        for (int i=0; i<length; i++){
            temp_lis[i] = 1;
        }


        for (int i=1; i<length; i++){
            for (int j=0; j<i; j++){
                if ((array[i] > array[j]) && (temp_lis[i] < temp_lis[j] +1)){
                    temp_lis[i] += 1;
                }
            }
        }

        for (int i: temp_lis) {
            if (max < i)
                max = i;
        }

        return max;
    }
}
