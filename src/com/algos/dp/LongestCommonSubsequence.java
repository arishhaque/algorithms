package com.algos.dp;

public class LongestCommonSubsequence {

    public int topDown(String s1, String s2, int i, int j) {

        if(i == 0 || j == 0)
            return 0;

        if(s1.charAt(i-1) == s2.charAt(j-1))
            return 1 + topDown(s1, s2,i-1, j-1);

        else
            return Math.max(topDown(s1, s2,i-1, j), topDown(s1, s2, i, j-1));
    }


    public int topDownWithMemo(String s1, String s2, int i, int j, int[][] cache) {

        if(i == 0 || j == 0)
            return 0;

        if(cache[i][j] != 0)
            return cache[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1))
            cache[i][j] = 1 + topDown(s1, s2,i-1, j-1);
        else
            cache[i][j] = Math.max(topDown(s1, s2,i-1, j), topDown(s1, s2, i, j-1));

        return cache[i][j];
    }

    public int bottomUp(String s1, String s2, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        // initialize 0th row and column with 0
        for(int i=0; i<1; i++) {

            for(int j=0; j<1; j++)
                    dp[i][j] = 0;
        }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        for(int i=0; i<m+1; i++) {

            for(int j=0; j<n+1; j++)
                System.out.print(dp[i][j] +" ");

            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {


        String s1 = "aceg"; //abcdefgh
        String s2 = "abcdefgh"; //aceg

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int res1 = lcs.topDown(s1, s2, s1.length(), s2.length());
        System.out.println(res1);

        int m = s1.length();
        int n = s2.length();
        int res2 = lcs.topDownWithMemo(s1, s2, s1.length(), s2.length(), new int[m+1][n+1]);
        System.out.println(res2);

        int res3 = lcs.bottomUp(s1, s2, s1.length(), s2.length());
        System.out.println(res3);
    }
}
