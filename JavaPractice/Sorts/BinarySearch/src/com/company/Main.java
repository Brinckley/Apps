package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {85, 5, 66, 666, -6, 8, -8, -96, 0, 75, 81};
        bubbleSort(array);
        Scanner in = new Scanner(System.in);
        int find = in.nextInt();
        find = searchBinary(array, 0, array.length - 1, find);
        if(find != -1){
            System.out.println("Ok. Number = " + find + "!");
        } else {
            System.out.println("No");
        }
    }

    private static int searchBinary(int[] array, int from, int to, int find){
        if(from > to) {return -1;}
        while (to >= from){
            int m = from + (to - from) / 2;

            if(array[m] == find){ return m; }
            if(array[m] < find){
                from = m + 1;
            } else {
                to = m - 1;
            }
        }
        return -1;
    }

    private static int searchBinaryRecursive(int[] array, int from, int to, int find){
        if(to >= from){
            int m = from + (to - from) / 2;

            if(array[m] == find){
                return m;
            }

            if(array[m] > find){
                return searchBinaryRecursive(array, from, m - 1, find);
            } else {
                return searchBinaryRecursive(array, m + 1, to,find);
            }
        }
        return -1;
    }

    private static void bubbleSort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    sorted = false;
                }
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
