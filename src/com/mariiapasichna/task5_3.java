package com.mariiapasichna;

import java.util.Arrays;
import java.util.Random;

public class task5_3 {

    private static final int SIZE = 1000;
    private static int operationCount = 0;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int arr[] = new int[SIZE];
        createArrayAndInit(arr);
        heapSort(arr);
        time(time);
        System.out.println("Operation count heapSort: " + operationCount);
    }

    private static void time(long time) {
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time / 1000.0);
    }

    public static void heapSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heap(arr, length, i);
            operationCount++;
        }
        for (int i = length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heap(arr, i, 0);
            operationCount++;
        }
        //System.out.println(Arrays.toString(arr));
    }

    public static void heap(int[] arr, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;
        if (leftChild < length && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < length && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heap(arr, length, largest);
            operationCount++;
        }
    }

    private static void createArrayAndInit(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        //System.out.println(Arrays.toString(arr));
    }
}
