package sortingAlgorithms;

import java.util.Random;

public class quickSort {
    public static void main(String[] args){
        int limit = 100000000;
        for(int n = 1; n < limit; n=n*10){
            long timeSum = 0;
            for(int i = 0; i < 10; i++) {
                int[] arr = randomArray(n);
                long start = System.nanoTime();
                sort(arr, 0, n-1);
                long end = System.nanoTime();
                long elapsed = end - start;
                timeSum += elapsed;
            }
            long timeAvg = timeSum / 10;
            System.out.println("n=" + n + ": " + timeAvg);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void sort(int arr[], int low, int high) {
        if (low < high) {
            // partition index
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
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
