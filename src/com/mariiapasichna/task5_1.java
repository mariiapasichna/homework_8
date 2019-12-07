package com.mariiapasichna;

import java.util.Arrays;
import java.util.Random;

public class task5_1 {

    /*5*) Реализовать 3 сложные сортировки массива, сравнить их по быстродействию:
Quick, Heap, Merge*/

    private static final int SIZE = 1000;
    private static int operationCount = 0;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int arr[] = new int[SIZE];
        int left = 0;
        int right = arr.length - 1;
        createArrayAndInit(arr);
        mergeSort(arr, left, right);
        //System.out.println(Arrays.toString(arr));
        System.out.println("Operation count mergeSort: " + operationCount);
        time(time);
    }

    private static void time(long time) {
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time / 1000.0);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        operationCount++;
        mergeSort(arr, mid + 1, right);
        operationCount++;
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int lenghtLeft = mid - left + 1;
        int lenghtRight = right - mid;
        int leftArr[] = new int[lenghtLeft];
        int rightArr[] = new int[lenghtRight];
        for (int i = 0; i < lenghtLeft; i++) {
            operationCount++;
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < lenghtRight; i++) {
            operationCount++;
            rightArr[i] = arr[mid + i + 1];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = left; i < right + 1; i++) {
            operationCount++;
            if (leftIndex < lenghtLeft && rightIndex < lenghtRight) {
                if (leftArr[leftIndex] < rightArr[rightIndex]) {
                    arr[i] = leftArr[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = rightArr[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < lenghtLeft) {
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            } else if (rightIndex < lenghtRight) {
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }
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
