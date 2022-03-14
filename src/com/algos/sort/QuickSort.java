package com.algos.sort;

public class QuickSort {

    private void quickSort(int[] arr, int l, int h) {

        if(l < h) {

            int p = partition(arr, l, h);

            quickSort(arr, l, p - 1);
            quickSort(arr, p+1, h);
        }
    }

    private int partition(int[] arr, int l, int h) {

        int p = arr[h];
        int i = l-1;
        for (int j=l; j<h; j++) {

            if(arr[j] < p) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        QuickSort qs = new QuickSort();
        int[] arr = {10, 30, 80, 90, 40, 50, 70};

        qs.quickSort(arr, 0 , arr.length-1);

        System.out.println("Sorted array is ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] +" ");
    }
}
