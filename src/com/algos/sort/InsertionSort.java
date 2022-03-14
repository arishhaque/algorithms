package com.algos.sort;

public class InsertionSort {

    private void sort(int[] arr) {

        int n = arr.length;
        for(int i=1; i<n; i++) {

            int j = i-1;
            int t = arr[i];
            while(j >= 0 && t < arr[j]) {
                    arr[j+1] = arr[j];
                    j--;
            }
            arr[j+1] = t;
        }
    }

    public static void main(String[] args) {

        InsertionSort is = new InsertionSort();
        int[] arr = { 4, 3, 2, 1, 3};

        is.sort(arr);

        System.out.println("Sorted array is ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] +" ");
    }
}
