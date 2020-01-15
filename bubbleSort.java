package sortingAlgorithms;

import java.util.Random;

public class bubbleSort {
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
            System.out.println("n="+ n +": " + timeAvg);
        }
    }

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
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
