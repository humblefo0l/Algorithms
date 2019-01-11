/*
Longest Palindromic Subsequence | DP-12
Given a sequence, find the length of the longest palindromic subsequence in it.

longest-palindromic-subsequence

As another example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest
palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not
the longest ones.

The naive solution for this problem is to generate all subsequences of the given sequence and find the longest
palindromic subsequence. This solution is exponential in term of time complexity. Let us see how this problem
possesses both important properties of a Dynamic Programming (DP) Problem and can efficiently solved using Dynamic
Programming.

1) Optimal Substructure:
Let X[0..n-1] be the input sequence of length n and L(0, n-1) be the length of the longest palindromic subsequence
of X[0..n-1].

If last and first characters of X are same, then L(0, n-1) = L(1, n-2) + 2.
Else L(0, n-1) = MAX (L(1, n-1), L(0, n-2)).

// Every single character is a palindrome of length 1
L(i, i) = 1 for all indexes i in given sequence

// IF first and last characters are not same
If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)}

// If there are only 2 characters and both are same
Else if (j == i + 1) L(i, j) = 2

// If there are more than two characters, and first and last
// characters are same
Else L(i, j) =  L(i + 1, j - 1) + 2
2) Overlapping Subproblems
Following is simple recursive implementation of the LPS problem. The implementation simply follows the recursive
structure mentioned above.

Considering the above implementation, following is a partial recursion tree for a sequence of length 6 with all
different characters.

               L(0, 5)
             /        \
            /          \
        L(1,5)          L(0,4)
       /    \            /    \
      /      \          /      \
  L(2,5)    L(1,4)  L(1,4)  L(0,3)
In the above partial recursion tree, L(1, 4) is being solved twice. If we draw the complete recursion tree, then
we can see that there are many subproblems which are solved again and again. Since same suproblems are called again,
this problem has Overlapping Subprolems property. So LPS problem has both properties (see this and this) of a dynamic
programming problem. Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be
avoided by constructing a temporary array L[][] in bottom up manner.

Time Complexity of the above implementation is O(n^2) which is much better than the worst case time complexity of
Naive Recursive implementation.

*/

package com.gaurav;

import java.util.Arrays;

public class longestPalindromicSubsequence {

    public static void main(String[] args) {
        String string = "GEEKSFORGEEKS";
//        String string = "abaab";
        int length = string.length();
        System.out.println(findLongestPanlindromicSubsequence(string.toCharArray(), 0, length-1));
        System.out.println(findLongestPanlindromicSubsequenceDP(string.toCharArray(), 0, length));
    }

    static int findLongestPanlindromicSubsequence(char[] chars, int start, int end){

        if (start<= end && end >=0){
                if (start == end)
                    return 1;

                else if (chars[start] == chars[end] && (start+1 == end)){
                    return 2;
                }
                else if (chars[start] == chars[end]){
                    return 2 + findLongestPanlindromicSubsequence(chars, start+1, end-1);
                }

                else {
                    return Math.max(findLongestPanlindromicSubsequence(chars, start+1, end),
                            findLongestPanlindromicSubsequence(chars, start, end-1));
                }
        }
        return 0;
    }

    static int findLongestPanlindromicSubsequenceDP(char[] chars, int start, int end){
        int[][] dp = new int[end][end];

        for (int i=0; i<end; i++)
                dp[i][i] = 1;

        for (int i=2; i<=end; i++){
            for (int j=0; j<end-i+1 ; j++){
                int l = j+i-1;

                if (chars[j] == chars[l] && i==2)
                    dp[j][l] = 2;

                else if (chars[j] == chars[l]){
                    dp[j][l] = dp[j+1][l-1] + 2;
                }
                else {
                    dp[j][l] = Math.max(dp[j+1][l], dp[j][l-1]);
                }
            }
        }


        return dp[0][end-1];
    }


}
