package com.enigma.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileProcessorImplementation implements FileProcessor{
    private String pathFile;

    public FileProcessorImplementation(String pathFile) {
        this.pathFile = pathFile;
    }
    public List<String>readFile(){
        List<String>fileTexts= new ArrayList<String>();
    try {
        BufferedReader reader = new BufferedReader(new FileReader(this.pathFile));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return fileTexts;
    }
}
