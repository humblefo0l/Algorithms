/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length
of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is
22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.




A naive solution for this problem is to generate all configurations of different pieces and find the highest
priced configuration. This solution is exponential in term of time complexity. Let us see how this problem possesses
both important properties of a Dynamic Programming (DP) Problem and can efficiently solved using Dynamic Programming.

1) Optimal Substructure:
We can get the best price by making a cut at different positions and comparing the values obtained after a cut. We
can recursively call the same function for a piece obtained after a cut.

Let cutRod(n) be the required (best possible price) value for a rod of length n. cutRod(n) can be written as following.

cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}

2) Overlapping Subproblems
Following is simple recursive implementation of the Rod Cutting problem. The implementation simply follows the
recursive structure mentioned above.

Considering the above implementation, following is recursion tree for a Rod of length 4.

cR() ---> cutRod()

                             cR(4)
                  /        /
                 /        /
             cR(3)       cR(2)     cR(1)   cR(0)
            /  |         /         |
           /   |        /          |
      cR(2) cR(1) cR(0) cR(1) cR(0) cR(0)
     /        |          |
    /         |          |
  cR(1) cR(0) cR(0)      cR(0)
   /
 /
CR(0)
In the above partial recursion tree, cR(2) is being solved twice. We can see that there are many subproblems
which are solved again and again. Since same suproblems are called again, this problem has Overlapping Subprolems
property. So the Rod Cutting problem has both properties (see this and this) of a dynamic programming problem.
Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by constructing
a temporary array val[] in bottom up manner.



*/
package com.gaurav;

public class cuttingRod {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        int size = price.length;

        System.out.println(cutRod(price, size));
        System.out.println(cutRodDP(price, size));
    }

    private static int cutRod(int[] price, int size){
        if (size <=0){
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int i=1; i<size; i++){
            max  = Math.max(max, price[i]+ cutRod(price, size-i-1));
        }

        return max;
    }

    private static int cutRodDP(int[] price, int size){
        /*
        Time Complexity of the above implementation is O(n^2) which is much better than the worst-case time
        complexity of Naive Recursive implementation.
        */
        int[] dp = new int[size+1];


        dp[0] = 0;

        for (int i=1; i<=size; i++){
            int max = Integer.MIN_VALUE;

            for (int j=0; j<i; j++){
                max  = Math.max(max, price[j] + dp[i-j-1]);
            }

            dp[i] = max;
        }

        return dp[size];
    }
}
