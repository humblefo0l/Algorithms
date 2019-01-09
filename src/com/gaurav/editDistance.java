/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits
(operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations.
Replace 'n' with 'r', insert t, insert a


What are the subproblems in this case?
The idea is process all characters one by one staring from either from left or right sides of both strings.
Let us traverse from right corner, there are two possibilities for every pair of character being traversed.

m: Length of str1 (first string)
n: Length of str2 (second string)
If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining
strings. So we recur for lengths m-1 and n-1.
Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last
character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
Insert: Recur for m and n-1
Remove: Recur for m-1 and n
Replace: Recur for m-1 and n-1

*/

package com.gaurav;

public class editDistance {
    public static void main(String[] args) {
        String string1 = "asdfav";
        String string2 = "asdsev";
//        int n = editDistance(string1, string2, string1.length(), string2.length());
        int n = editDistanceDP(string1, string2, string1.length(), string2.length());
        System.out.println("Min Operation length is: "+n);
    }


    static int editDistance(String string1, String string2, int m, int n){
        /*
        The time complexity of above solution is exponential. In worst case, we may end up doing O(3m) operations.
        The worst case happens when none of characters of two strings match
        */
        if (m == 0)
            return n;

        if (n == 0)
            return m;

        if (string1.charAt(m-1) == string2.charAt(n-1)){
            return editDistance(string1, string2, m-1, n-1);
        }else {
            return 1 + min(editDistance(string1, string2, m, n-1),
                    editDistance(string1, string2, m-1, n),
                    editDistance(string1, string2, m-1, n-1)
                    );
        }
    }



    static int min(int x, int y, int z){
        if (x<=y && y <= z) return x;
        if (y<=x && y<= z) return y;
        else return z;
    }

    static int editDistanceDP(String string1, String string2, int m, int n){
        /*
        Time Complexity: O(m x n)
        Auxiliary Space: O(m x n)

        Applications: There are many practical applications of edit distance algorithm, refer Lucene API
        for sample. Another example, display all the words in a dictionary that are near proximity to a given
        wordincorrectly spelled word.
        */

        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                if (i==0)
                    dp[i][j] = j;

                else if (j==0)
                    dp[i][j] = i;

                else if (string1.charAt(i-1) == string2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }

                else {
                    dp[i][j] = 1 + min(dp[i][j-1],
                                        dp[i-1][j],
                                        dp[i-1][j-1]);
                }
            }
        }

        return dp[m][n];
    }

}
