package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {16, 14, 56, 564, 45654, 6465, 45, 13, 32, 9, -1, 0};
        arr = mergeSort(arr);
        for(int i = 0 ; i < arr.length; ++i){
            System.out.println(arr[i]);
        }
    }

    private static int[] mergeSort(int[] array){
        int[] tmp;
        int[] currentSrcArray = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while(size < array.length){
            for(int i = 0; i < array.length ; i += 2 * size){
                merge(currentSrcArray, i, currentSrcArray, i + size, currentDest, i, size);
            }

            tmp = currentSrcArray;
            currentSrcArray = currentDest;
            currentDest = tmp;

            size *= 2;
        }
        return currentSrcArray;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size){
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start; // total length of their array (src1 + src2)

        for(int i = destStart; i < destStart + iterationCount ; ++i){
            if(index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])){
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
}
