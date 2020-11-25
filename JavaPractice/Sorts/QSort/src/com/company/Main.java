package com.company;

import java.util.Arrays.*;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 6, 88, 557, 775, -9, -6, 666};
        qSort(numbers, 0, numbers.length-1);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void qSort(int[] arr, int from, int to) {
        if (from < to) {

            int divideIndex = partition(arr, from, to);

            qSort(arr, from, divideIndex - 1);

            qSort(arr, divideIndex, to);
        }
    }

    private static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] arr, int rightIndex, int leftIndex) {
        int tmp = arr[rightIndex];
        arr[rightIndex] = arr[leftIndex];
        arr[leftIndex] = tmp;
    }
}
