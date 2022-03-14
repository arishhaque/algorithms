package com.algos.greedy;

import java.util.Arrays;

public class MinimumPlatform {

    public int minPlatform(int[] arrival, int[] departure, int n) {

        Arrays.sort(arrival); Arrays.sort(departure);

        int currPlatform = 1, minPlatform = 1;
        int i=1, j=0;
        while(i < n && j < n) {

            if(arrival[i] <= departure[j]) {
                i++;
                currPlatform++;
            } else {
                j++;
                currPlatform--;
            }

            minPlatform = Math.max(minPlatform, currPlatform);
        }
        System.out.println(minPlatform);
        return minPlatform;
    }

    public static void main(String[] args) {

        int[] arrival = new int[]{900, 915, 1030, 1045};
        int[] departure = new int[]{ 930, 1300, 2300, 1145};

        MinimumPlatform mp = new MinimumPlatform();
        mp.minPlatform(arrival, departure, arrival.length);
    }
}
