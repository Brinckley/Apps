package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; ++i){
            numbers[i] = in.nextInt();
        }
        int index = 0;
        int min = numbers[0];
        for(int i = 1; i < n; ++i){
            if(numbers[i] < min){
                index = i;
                min = numbers[i];
            }
        }
        System.out.println(index);
        System.out.println(min);
    }
}
