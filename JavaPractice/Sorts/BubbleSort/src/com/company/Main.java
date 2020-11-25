package com.company;
import java.util.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; ++i){
            numbers[i] = in.nextInt();
        }
        boolean flag = true;
        while(flag) {
            for (int i = 1; i < n; ++i) {
                if (numbers[i] < numbers[i - 1]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = tmp;
                    flag = false;
                }
            }
            if(!flag){
                flag = true;
            } else {
               break;
            }
        }
        for(int i = 0; i < n; ++i){
            System.out.println(numbers[i]);
        }
    }
}
