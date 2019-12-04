package com.enigma.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileProcessorImplementation implements FileProcessor{
    private String pathFile;
    private List<String>fileTexts= new ArrayList<String>();

    public FileProcessorImplementation(String pathFile) {
        this.pathFile = pathFile;
    }
    public List<String>readFile(){
    try {
        BufferedReader reader = new BufferedReader(new FileReader(this.pathFile));
        boolean readingFile =true;
         while (readingFile){
           String text = reader.readLine();
           if (text != null){
               fileTexts.add(text);
           }else {
               readingFile=false;
           }
       }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return this.fileTexts;
    }
}
