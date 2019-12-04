package com.enigma;

import com.enigma.process.FileProcessor;
import com.enigma.process.FileProcessorImplementation;

public class MainApplication {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessorImplementation("/home/drika/myProject/boating-app/comans-file/file_inpust.txt");
        for (String text:fileProcessor.readFile()) {
            System.out.println(text);
        }
    }
}
