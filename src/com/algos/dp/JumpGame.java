package com.algos.dp;

import java.util.Arrays;

public class JumpGame {


    public int topDown(int[] nums, int i, int count) {

        if(i >= nums.length || (nums[i] == 0 && i != nums.length-1))
            return Integer.MAX_VALUE;;

        if(i == nums.length - 1)
            return count;

        int minCount =  Integer.MAX_VALUE;;
        for(int j=1; j<=nums[i]; j++) {

            int c = topDown(nums, i+j, count+1);
            if(c >= 0)
                minCount = Math.min(minCount, c);
        }
        return minCount;
    }

    public int topDownWithMemo(int[] nums, int i, int count, int[] cache) {


        if(i >= nums.length || (nums[i] == 0 && i != nums.length-1))
            return Integer.MAX_VALUE;

        if(i == nums.length - 1)
            return count;

        if(cache[i] != 0)
            return cache[i];

        int minCount =  Integer.MAX_VALUE;
        for(int j=1; j <= nums[i]; j++) {

            int c = topDownWithMemo(nums, i+j,  count+1, cache);
            if(c >= 0)
                minCount = Math.min(minCount, c);
        }
        cache[i] = minCount;
        /*for(int j=0; j < cache.length; j++) {
            System.out.println(cache[j]);
        }*/
        return minCount;
    }

    public int bottomUp(int[] nums, int n) {

        if(n < 0)
            return 0;

        if(n == 1)
            return 1;

        if(nums[0] <= 0)
            return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<n; i++) {

            for(int j=1; j<=nums[i]; j++) {

                if(i+j < n) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        for(int j=0; j < dp.length; j++) {
            System.out.println(dp[j]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

        JumpGame jg = new JumpGame();
        int[] nums = new int[]{3,1,2,1,4};

        // top-down without memo
        //int res1 = jg.topDown(nums, 0, 0);
        //System.out.println(res1);

        // top-down with memo
        //int res2 = jg.topDownWithMemo(nums, 0,  0, new int[nums.length]);
        //System.out.println(res2);

        // bottom-up
        int res3 = jg.bottomUp(nums, nums.length);
        System.out.println(res3);

    }
}
