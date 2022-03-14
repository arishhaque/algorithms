package com.algos.dp;

public class Fibonacci {


    private int topDown(int n) {

        if(n <= 1)
            return n;

        return topDown(n-1) + topDown(n-2);
    }

    private int topDownWithMemo(int n, int[] A) {

        if(n <= 1)
            return n;

        if(A[n] != 0)
            return A[n];

        A[n] = topDownWithMemo(n-1, A) + topDownWithMemo(n-2, A);
        return A[n];
    }

    private int bottomUp(int n) {

        int[] A = new int[n];
        A[0] = 1;
        A[1] = 1;
        for(int i=2; i<n; i++) {

            A[i] = A[i-1] + A[i-2];
        }
        return A[n-1];
    }

    public static void main(String[] args) {

        Fibonacci fb = new Fibonacci();

        // top down without memoization
        int res1 = fb.topDown(7);
        System.out.println("Without memo "+res1);

        // top down with memoization
        int[] A = new int[9];
        int res2 = fb.topDownWithMemo(8, A);
        System.out.println("With memo "+res2);

        // bottom up
        int res3 = fb.bottomUp(9);
        System.out.println("Bottom Up "+res3);
    }
}
