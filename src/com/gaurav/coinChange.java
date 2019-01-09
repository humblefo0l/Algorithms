/*
Coin Change | DP-7
Given a value N, if we want to make change for N cents, and we have infinite supply of each of
S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should
be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
So the output should be 5

Time Complexity: O(mn)

*/

package com.gaurav;

public class coinChange {
    public static void main(String[] args) {
        int[] coin = {1,2,5};
        int value = 12;

        int n = coinChangeDP(coin, value);
        System.out.println("Total Coin Change: " + n);
    }

    static int coinChangeDP(int[] coins, int value){
        int[] combinations = new int[value+1];
        combinations[0] = 1;

        for (int coin: coins){
            for (int i=1; i<combinations.length; i++){
                if (i >= coin)
                    combinations[i] += combinations[i-coin];
            }
        }

        return combinations[value];
    }

}
