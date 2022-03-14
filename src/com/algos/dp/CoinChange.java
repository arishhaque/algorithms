package com.algos.dp;

import java.util.Arrays;

public class CoinChange {

    public int topDown(int[] coins, int amount) {

        if(amount < 0)
            return -1;

        if(amount == 0)
            return 0;

        int minRes = Integer.MAX_VALUE;
        for(int i=0; i < coins.length; i++) {

            int res = topDown(coins, amount - coins[i]);
            if(res >= 0)
                minRes = 1 + Math.min(minRes, res);
        }
        return minRes == Integer.MAX_VALUE ? -1 : minRes;
    }

    public int topDownWithMemo(int[] coins, int amount, int[] cache) {

        if(amount < 0)
            return -1;

        if(amount == 0)
            return 0;

        if(cache[amount] != 0)
            return cache[amount];

        int minRes = Integer.MAX_VALUE;
        for(int i=0; i < coins.length; i++) {

            int res = topDownWithMemo(coins, amount - coins[i], cache);
            if(res >= 0)
                minRes = 1 + Math.min(minRes, res);
        }
        cache[amount] = minRes == Integer.MAX_VALUE ? -1 : minRes;
        return cache[amount];
    }

    public int topDownWithMemo2(int[] coins, int n, int amount, int[][] memo) {

        if(amount == 0 || n == 0)
            return 0;

        if(memo[n][amount] != 0)
            return memo[n][amount];

        if(amount >= coins[n-1]) {

            memo[n][amount] = Math.min(1 + topDownWithMemo2(coins, n,amount - coins[n-1], memo),
                    topDownWithMemo2(coins, n-1, amount, memo));
        } else {
            memo[n][amount] = topDownWithMemo2(coins, n-1, amount, memo);
        }
        return memo[n][amount];
    }

    public int bottomUp(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i<n+1; i++)
            dp[i][0] = 0;

        for(int j=0; j<amount+1; j++)
            dp[0][j] = Integer.MAX_VALUE - 1;

        for(int i=1; i<n+1; i++) {

            for(int j=1; j<amount+1; j++) {

                if(j >= coins[i-1])
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);

                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {

        CoinChange cc = new CoinChange();
        int[] coins = new int[]{1,2,10};
        int amount = 21;
        int res1 = cc.topDown(coins, amount);
        System.out.println(res1);

        int res2 = cc.topDownWithMemo(coins, amount, new int[amount+1]);
        System.out.println(res2);

        int[][] memo = new int[coins.length+1][amount+1];
        for(int i=0; i<coins.length+1; i++) {
            for(int j=0; j<amount+1; j++)
                memo[i][j] = 0;
        }


        int res3 = cc.topDownWithMemo2(coins, coins.length, amount, memo);
        for(int i=0; i<coins.length+1; i++) {
            for(int j=0; j<amount+1; j++)
                System.out.print(memo[i][j] +" ");

            System.out.println();
        }

        System.out.println("res3: "+res3);

        int res4 = cc.bottomUp(coins, amount);
        System.out.println(res4);
    }
}
