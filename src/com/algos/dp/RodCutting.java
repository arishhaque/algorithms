package com.algos.dp;

public class RodCutting {


    public int topDown(int[] p, int n) {

        if(n == 0)
            return 0;

        int q = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            q = Math.max(q, p[i] + topDown(p, n - i - 1));
        }
        return q;
    }

    public int topDownWithMemo(int[] p, int n, int[] cache) {

        if(n == 0)
            return 0;

        if(cache[n] != 0)
            return cache[n];

        int q = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            q = Math.max(q, p[i] + topDown(p, n - i - 1));
        }
        cache[n] = q;
        return q;
    }

    public int topDownWithMemo2(int[] p, int n, int maxLen, int[][] memo) {

        if(n == 0 || maxLen <= 0)
            return 0;

        if(memo[n][maxLen] != 0)
            return memo[n][maxLen];

        if(n-1 <= maxLen) {

            memo[n][maxLen] = Math.max(p[n-1] + topDownWithMemo2(p, n, maxLen - n - 1, memo),
                    topDownWithMemo2(p, n-1, maxLen, memo));
        }else {
            memo[n][maxLen] =  topDownWithMemo2(p, n-1, maxLen, memo);
        }

        return memo[n][maxLen];
    }

    public int bottomUp(int[] p, int n) {

        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {

            dp[i] = Integer.MIN_VALUE;
            for(int j=0; j<i; j++)
                dp[i] = Math.max(dp[i], p[j] + dp[i-j-1]);
        }
        return dp[n];
    }

    public int bottomUp2(int[] p, int n, int maxLen) {

        int[][] dp = new int[n+1][maxLen+1];
        for(int i=0; i< n+1; i++)
            dp[i][0] = 0;

        for(int j=0; j<maxLen+1; j++)
            dp[0][j] = 0;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<maxLen+1; j++) {

                if(i <= j)
                    dp[i][j] = Math.max(p[i-1] + dp[i][j-i], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<maxLen+1; j++){

                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }

        return dp[n][maxLen];
    }


    public static void main(String[] args) {

        RodCutting rc = new RodCutting();
        int[] price = new int[] {2, 5, 9, 10, 12};
        int res1 = rc.topDown(price, price.length);
        System.out.println(res1);

        int res2 = rc.topDownWithMemo(price, 5, new int[6]);
        System.out.println(res2);

        int[][] memo = new int[price.length+1][price.length+1];
        int res3 = rc.topDownWithMemo2(price, price.length, price.length, memo);
        System.out.println(res3);

        int res4 = rc.bottomUp(price, 5);
        System.out.println(res4);

        int res5 = rc.bottomUp2(price, price.length, price.length);
        System.out.println(res5);
    }
}
