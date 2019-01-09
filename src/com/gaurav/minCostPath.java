/*
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost
path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total
cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You
can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j),
cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?


The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2).
The cost of the path is 8 (1 + 2 + 2 + 3).



* */

package com.gaurav;

public class minCostPath {
    public static void main(String[] args) {

        int[][] cost = { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };


        int r = minCostPathDP(cost, cost.length-1 , cost[0].length-1);
        System.out.println("Min cost to travel is: " + r);
    }

    static int minCostPathDP(int[][] cost, int m, int n){
        /*
        Time Complexity of the DP implementation is O(mn) which is much better than Naive Recursive
        implementation.
        */
        int[][] minCostDP = new int[m+1][n+1];
        minCostDP[0][0] = cost[0][0];

        for (int i=1; i<=m; i++)
            minCostDP[i][0] = minCostDP[i-1][0] + cost[i][0];

        for (int j=1; j<=n; j++)
            minCostDP[0][j] = minCostDP[0][j-1] + cost[0][j];


        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                minCostDP[i][j] = min(minCostDP[i-1][j],
                                        minCostDP[i][j-1],
                                        minCostDP[i-1][j-1]) + cost[i][j];
            }
        }

        return minCostDP[m][n];
    }

    static int min(int x, int y, int z){
        if (x<y && x<z)
            return x;
        else if (y<x && y< z)
            return y;
        else
            return z;
    }

}
