package sortingAlgorithms;

import java.util.Random;

public class insertionSort {
    public static void main(String[] args){
        int limit = 10000000;
        for(int n = 1; n < limit; n=n*10){
            long timeSum = 0;
            for(int i = 0; i < 10; i++) {
                int[] arr = randomArray(n);
                long start = System.nanoTime();
                sort(arr);
                long end = System.nanoTime();
                long elapsed = end - start;
                timeSum += elapsed;
            }
            long timeAvg = timeSum / 10;
            System.out.println("n=" + n + ": " + timeAvg);
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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
