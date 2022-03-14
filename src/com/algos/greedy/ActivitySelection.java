package com.algos.greedy;

import java.util.Arrays;

public class ActivitySelection {


    public int maxActivities(int[] start, int[] finish, int n) {

        int res = 1;
        //Arrays.sort(start);
        //Arrays.sort(finish);
        int i=0;
        for(int j = 1; j<n; j++) {

            if(start[j] >= finish[i]) {
                System.out.print(j+" ");
                res += 1;
                i = j;
            }
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {

        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};
        int n = s.length;

        ActivitySelection as = new ActivitySelection();
        int res = as.maxActivities(s, f, n);
        System.out.println(res);

    }
}
