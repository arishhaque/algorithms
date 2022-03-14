package com.algos.sort;

public class MergeSort {

    private void sort(int[] arr, int l, int h) {

            if(l < h) {

                int mid = (l+h) / 2;
                sort(arr, l, mid);
                sort(arr, mid+1, h);

                merge(arr, l, mid, h);
            }
    }

    private void merge(int[] arr, int l, int m, int h) {

        int n1 = m + 1 - l ;
        int n2 = h - m;

        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        for(int i=0; i < n1; i++) {
            a1[i] = arr[i + l];
        }
        for(int j=0; j < n2; j++) {
            a2[j] = arr[m+1+j];
        }

        int i=0, j=0, k=l;
        while(i < n1 && j < n2) {

            if(a1[i] <= a2[j]) {
                arr[k] = a1[i];
                i++;
            } else {
                arr[k] = a2[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = a1[i];
            k++;
            i++;
        }

        while(j < n2) {
            arr[k] = a2[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {

        MergeSort ms = new MergeSort();
        int[] arr = { 4, 3, 3, 1, 5, 2 }; //1, 4, 1, 2, 7, 5, 2

        ms.sort(arr, 0, arr.length-1);

        System.out.println("Sorted array is ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] +" ");
    }
}
