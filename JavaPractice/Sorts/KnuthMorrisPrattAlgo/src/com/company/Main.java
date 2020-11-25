package com.company;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // Дана строка и подстрока
    // Найти все вхожения данной подстроки в строку
    public static int[] PrefixFunction(String sample){
        int[] array = new int[sample.length()];
        for(int i = 1; i < sample.length(); ++i){
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)){
                array[i + j] = Math.max(array[i + j], j + 1);
                j++;
            }
        }
        return array;
    }
    public static ArrayList<Integer> KMPSearch1(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = PrefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample){
        ArrayList<Integer> found = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int[] prefixFunc = PrefixFunction(sample);

        while (i < text.length()){
            if(text.charAt(i) == sample.charAt(j)){
                i++;
                j++;
            }
            if(j == sample.length()){
                found.add(i - j); // beginning of sample
                j = prefixFunc[j - 1];
            } else { if( i < text.length() && text.charAt(i) != sample.charAt(j)){
                        if(j != 0){
                            j = prefixFunc[j - 1];
                        } else {
                        i++;
                        }
                    }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        String text =   "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";
        int[] arr = new int[text.length()];
        arr = PrefixFunction(sample);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));
    }
}
