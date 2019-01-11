package com.gaurav;

public class test {
    public static void main(String[] args) {

        System.out.println("Hello World");
        int[] v = {60, 100, 120};
        int[] wt = {10,20,30};
        int n = v.length;
        int cap = 50;
        System.out.println(knapsack(wt, v, cap, n));
    }

    private static int knapsack(int[]wt, int[] v, int cap, int n){
        int[][] k = new int[n+1][cap+1];

        for (int i=0; i<=n;i++){
            for (int w=0; w<=cap; w++){
                if (i==0 || w==0)
                    k[i][w] = 0;
                else if (wt[i-1] <= w){
                    k[i][w] = knapsackProblem.max(k[i-1][w-wt[i-1]] + v[i-1], k[i-1][cap]);
                }else {
                    k[i][w] = k[i-1][w];
                }
            }
        }
        return k[n][cap];

    }
}
