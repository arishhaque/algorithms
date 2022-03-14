package com.algos.sort;

public class CountingSort {


    private void sort(int[] arr) {

        int n = arr.length;
        int[] count = new int[100];
        int[] res = new int[n];
        for(int i=0; i<n; i++)
            count[i] = 0;

        for(int i=0; i<n; i++)
            count[arr[i]] += 1;

        for(int i=1; i<100; i++)
            count[i] = count[i] + count[i-1];

        for(int i=n-1; i>=0; i--) {
            res[count[arr[i]] - 1] = arr[i];
            count[arr[i]] -= 1;
        }
        for(int i=0; i<n; i++)
            arr[i] = res[i];
            //System.out.print(res[i] +" ");
    }

    public static void main(String[] args) {

        CountingSort cs = new CountingSort();
        int[] arr = { 1, 4, 1, 2, 7, 5, 2 };

        cs.sort(arr);

        System.out.println("Sorted array is ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] +" ");
    }
}
