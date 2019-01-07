/*
LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of
length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences
between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

The naive solution for this problem is to generate all subsequences of both given sequences and find the longest
matching subsequence. This solution is exponential in term of time complexity. Let us see how this problem possesses
both important properties of a Dynamic Programming (DP) Problem.

1) Optimal Substructure:
Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. And let L(X[0..m-1], Y[0..n-1])
be the length of LCS of the two sequences X and Y. Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).

If last characters of both sequences match (or X[m-1] == Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )

Examples:
1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can
be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
longest-common-subsequence
2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS
can be written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )

So the LCS problem has optimal substructure property as the main problem can be solved using solutions to subproblems.

*/
package com.gaurav;

public class longestCommonSequence {
    public static void main(String[] args) {

        String string1 = "afsdsb";
        String string2 = "sfvsbdb";
        System.out.println("Longest Common Sequence is: " + lcs(string1, string2));
    }

    static int lcs(String string1, String string2){
        char[] char1 = string1.toCharArray();
        char[] char2 = string2.toCharArray();

        int length1 = char1.length;
        int length2 = char2.length;

//        return _lcs_TC_OofnSquare(char1, char2, length1, length2);
        return _lcs_TC_OofLength1Length2(char1, char2, length1, length2);
    }

    /*
        Time complexity of the below naive recursive approach is O(2^n) in worst case and worst case happens when
        all characters of X and Y mismatch i.e., length of LCS is 0.
    */
    static int _lcs_TC_OofnSquare(char[] char1, char[] char2, int length1, int length2){

        if (length1 == 0 || length2 == 0)
            return 0;

        if (char1[length1-1] == char2[length2-1]){
            return 1 + _lcs_TC_OofnSquare(char1, char2, length1-1, length2-1);
        }else {
            return max(_lcs_TC_OofnSquare(char1, char2, length1, length2-1), _lcs_TC_OofnSquare(char1, char2, length1-1, length2));
        }

    }

    static int max(int a, int b){
        return a > b ? a: b ;
    }


    /*
    2) Overlapping Subproblems:
        Following is simple recursive implementation of the LCS problem. The implementation simply follows the
        recursive structure mentioned below.

    Considering the above implementation, following is a partial recursion tree for input strings “AXYT” and “AYZX”

                             lcs("AXYT", "AYZX")
                           /
             lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
             /                              /
    lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")


    In the above partial recursion tree, lcs(“AXY”, “AYZ”) is being solved twice. If we draw the complete recursion
    tree, then we can see that there are many subproblems which are solved again and again. So this problem has
    Overlapping Substructure property and recomputation of same subproblems can be avoided by either using
    Memoization or Tabulation. Following is a tabulated implementation for the LCS problem.

    Time Complexity of the below implementation is O(mn) which is much better than the worst-case time complexity
    of Naive Recursive implementation.


    */
    static int _lcs_TC_OofLength1Length2(char[] chars1, char[] chars2, int length1, int length2){

        int[][] lcsTemp = new int[length1+1][length2+1];

        for (int i=0; i<=length1; i++){
            for (int j=0; j<=length2; j++){
                if (i == 0 || j == 0){
                    lcsTemp[i][j] = 0;
                }else if (chars1[i-1] == chars2[j-1]){
                    lcsTemp[i][j] = lcsTemp[i-1][j-1] + 1 ;
                }else {
                    lcsTemp[i][j] = max(lcsTemp[i-1][j], lcsTemp[i][j-1]);
                }
            }
        }

        return lcsTemp[length1][length2];
    }
}
