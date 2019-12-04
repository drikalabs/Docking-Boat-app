package com.enigma;

import com.enigma.process.CommandsProcessor;
import com.enigma.process.CommandsProcessorImplementation;
import com.enigma.process.FileProcessor;
import com.enigma.process.FileProcessorImplementation;

public class MainApplication {
    private static final String ADDITIONAL_PATH="/commands-file/";
    public static void main(String[] args) {
        System.out.println(args[0]);
        String pathFile = System.getProperty("user.dir");
        FileProcessor fileProcessor= new FileProcessorImplementation(pathFile+ADDITIONAL_PATH+args[0]);
        CommandsProcessor commandsProcessor=new CommandsProcessorImplementation();
        commandsProcessor.executeCommand(fileProcessor.readFile());
    }
}
