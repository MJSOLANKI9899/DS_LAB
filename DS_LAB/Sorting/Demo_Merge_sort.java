package Lab_21;

import java.io.*;

public class Demo_Merge_sort {
    public static void main(String[] args) {
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.println("the array before merge sort is :  ");
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("the array after merge sort is : ");
        sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + ",");
        }

    }

    public static void sort(int[] arr, int l, int r) {

        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }

    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] start = new int[n1];
        int[] end = new int[n2];

        for (int i = 0; i < n1; ++i) {
            start[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            end[j] = arr[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if(start[i]<=end[j]){
                arr[k] = start[i];
                i++;
            }
            else{
                arr[k] = end[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = start[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = end[j];
            j++;
            k++;
        }

    }
}
