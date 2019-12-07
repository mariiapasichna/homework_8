package com.mariiapasichna;

import java.util.Arrays;
import java.util.Random;

public class task5_2 {

    private static final int SIZE = 1000;
    private static int operationCount = 0;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int arr[] = new int[SIZE];
        createArrayAndInit(arr);
        //System.out.println(Arrays.toString(arr));
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        //System.out.println(Arrays.toString(arr));
        System.out.println("Operation count quickSort: " + operationCount);
        time(time);
    }

    private static void time(long time) {
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time / 1000.0);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int opora = arr[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            operationCount++;
            while (arr[i] < opora) {
                operationCount++;
                i++;
            }
            while (arr[j] > opora) {
                operationCount++;
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
            operationCount++;
        }
        if (high > i) {
            quickSort(arr, i, high);
            operationCount++;
        }
    }

    private static void createArrayAndInit(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }
}
