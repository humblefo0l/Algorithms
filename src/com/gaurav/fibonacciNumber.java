/*
Program for Fibonacci numbers
The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation

    Fn = Fn-1 + Fn-2
with seed values

   F0 = 0 and F1 = 1.


Given a number n, print n-th Fibonacci Number.
Examples:

Input  : n = 2
Output : 1

Input  : n = 9
Output : 34
*/
package com.gaurav;

public class fibonacciNumber {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibonacciNum(n));
    }

    static int fibonacciNum(int n){
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
