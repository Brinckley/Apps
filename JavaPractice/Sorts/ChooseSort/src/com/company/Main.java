package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {1, 77, 55, 896, 52, 84, -1, 0, 67};
        for(int i = 0; i < array.length ; ++i){
            int min = minArr(array, i);
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
        for(int i = 0; i < array.length ; ++i){
            System.out.println(array[i]);
        }
    }

    private static int minArr(int[] array, int startIndex){
        int minIndex = startIndex;
        int minValue = array[startIndex];
        for(int i = startIndex; i < array.length; ++i){
            if(array[i] < minValue){
                minIndex = i;
                minValue = array[i];
            }
        }
        return minIndex;
    }
}
