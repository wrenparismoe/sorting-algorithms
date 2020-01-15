# Sorting Algorithm Analysis

This lab provides an in-depth analysis of five sorting algorithms by looking at their elapsed runtimes. The five algorithms are Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, and Quick Sort. Runtimes were recorded for several values of n in order to compute the time complexity of each algorithm.

## Procedure

1. Each sorting algorithm was timed in nanoseconds over ten trials using Java's System.nanoTime(). Below is code for the timing mechanism used to record the algorithm's runtime.
Java code:

``` Java
for(n = 1; n < 10000000; n*10){
        long timeSum = 0;
        for(int i = 0; i < 10; i++) {
                int[] arr = randomArray(n);
                long start = System.nanoTime();
                sort(arr);
                long end = System.nanoTime();
                long elapsed = end – start;
                timeSum += elapsed;
        }
        long timeAvg = timeSum / 10;
        System.out.println("n=" + n + ": " + timeAvg);
}
```
