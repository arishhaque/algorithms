package com.algos.dp;

public class Knapsack01 {

    public int topDownWithMemo(int[] wt, int[] val, int W, int n, int[][] memo) {

        if(n == 0 || W == 0)
            return 0;

        if(memo[n][W] != 0)
            return memo[n][W];

        if(wt[n-1] <= W) {

            return memo[n][W] = Math.max(val[n-1] + topDownWithMemo( wt, val, W - wt[n-1],n-1, memo),
                            topDownWithMemo(wt, val, W,n-1, memo));
        }
        return memo[n][W] = topDownWithMemo(wt, val, W,n-1, memo);
    }

    public int bottomUp(int[] wt, int[] val, int W) {

        int n = wt.length;
        int[][] dp = new int[n+1][W+1];

        for(int j=0; j<W+1; j++) {
            dp[0][j] = 0;
        }

        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<W+1; j++){

                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }

        for(int i=1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                if(wt[i-1] <= j) {

                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println();
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<W+1; j++){

                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }

        return dp[n][W];
    }


    public static void main(String[] args) {

        Knapsack01 ks = new Knapsack01();
        int[] val = {1,2,3};//{2, 3, 1, 5, 4, 7}
        int[] wt = {1, 4, 5};//{4, 5, 1, 3, 2, 5}
        int W = 6; //15
        int n = wt.length;

        int[][] memo = new int[n+1][W+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<W+1; j++) {

                if(i==0 || j == 0)
                    memo[i][j] = 0;

            }
        }
        int res1 = ks.topDownWithMemo(wt, val, W, n, memo);
        System.out.println(res1);

        int res2 = ks.bottomUp(wt, val, W);
        System.out.println(res2);

    }
}
