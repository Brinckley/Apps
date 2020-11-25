package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        searchFiles(new File("D:\\"), fileList);
        for(File file : fileList){
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void searchFiles(File rootFile, List<File> fileList){
        if(rootFile.isDirectory()){
            File[] listOfFiles = rootFile.listFiles();
            if(listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
