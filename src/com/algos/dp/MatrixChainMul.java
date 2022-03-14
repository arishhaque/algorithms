package com.algos.dp;

public class MatrixChainMul {

    public int topDown(int[] array, int i, int j) {

        if(i >= j)
            return 0;

        int res = Integer.MAX_VALUE - 1;
        for(int k=i; k<j; k++) {

            int tempRes = topDown(array, i, k) + topDown(array, k+1, j) +
                    array[i-1] * array[k] * array[j];
            res = Math.min(res, tempRes);

        }
        return res;
    }

    public int topDownWithMemo(int[] array, int i, int j, int[][] memo) {

        if(i >= j)
            return 0;

        if(memo[i][j] != -1)
            return memo[i][j];

        int res = Integer.MAX_VALUE - 1;
        for(int k=i; k<j; k++) {

            int tempRes = topDown(array, i, k) + topDown(array, k+1, j) +
                    array[i-1] * array[k] * array[j];
            res = Math.min(res, tempRes);

        }
        return memo[i][j] = res;
    }

    public int bottomUp(int[] array) {

        int n = array.length;
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++)
                dp[i][j] = 0;
        }


        for (int L = 2; L < n; L++)
        {
            for (int i = 1; i < n - L + 1; i++)
            {
                int j = i + L - 1;
                if (j == n)
                    continue;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++)
                {
                    // q = cost/scalar multiplications
                    int q = dp[i][k] + dp[k + 1][j]
                            + array[i - 1] * array[k] * array[j];
                    if (q < dp[i][j])
                        dp[i][j] = q;
                }
            }
        }

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++)
                System.out.print(dp[i][j] +" ");

            System.out.println();
        }
        return dp[n][n];
    }

    public static void main(String[] args) {

        MatrixChainMul mcm = new MatrixChainMul();
        int[] arr = {40, 20, 30, 10, 30}; //{10, 30, 5, 60}=4500
        int n = arr.length;
        int res1 = mcm.topDown(arr, 1, n-1);
        System.out.println(res1);

        int[][] memo = new int[n+1][n+1];
        for(int i=0; i< n+1; i++) {
            for (int j=0; j<n+1; j++) {

                memo[i][j] = -1;
            }
        }

        int res2 = mcm.topDownWithMemo(arr, 1, n-1, memo);
        System.out.println(res2);

        int res3 = mcm.bottomUp(arr);
        System.out.println(res3);
    }
}
