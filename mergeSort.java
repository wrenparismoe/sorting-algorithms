package sortingAlgorithms;

import java.util.Random;

public class mergeSort {
    public static void main(String[] args){
        int limit = 1000000000;
        for(int n = 1; n < limit; n=n*10){
            long timeSum = 0;
            for(int i = 0; i < 10; i++) {
                int[] arr = randomArray(n);
                long start = System.nanoTime();
                sort(arr, 0, arr.length-1);
                long end = System.nanoTime();
                long elapsed = end - start;
                timeSum += elapsed;
            }
            long timeAvg = timeSum / 10;
            System.out.println("n=" + n + ": " + timeAvg);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int val = rand.nextInt(1000);
            arr[i] = val;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
