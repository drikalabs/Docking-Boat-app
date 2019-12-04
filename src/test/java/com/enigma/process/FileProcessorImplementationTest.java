package com.enigma.process;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileProcessorImplementationTest {
private static final String pathFileTest="/home/drika/myProject/boating-app/src/test/test-file/file-test.txt";
    @Test
    public void readFile_should_be_able_to_return_listFromFile() {
        FileProcessor fileProcessor= new FileProcessorImplementation(pathFileTest);
        List<String>expected =new ArrayList<>();
        expected.add("create_boating_dock 6");
        expected.add("dock KA-01-HH-1234");
        expected.add("dock KA-01-HH-9999");
        expected.add("dock KA-01-BB-0001");
        expected.add("leave 4");
        expected.add("reserve KA-09-HH-7788");
        expected.add("reserve KA-09-HH-0123");
        expected.add("dock KA-09-HH-0987");
        expected.add("status");
        assertEquals(expected,fileProcessor.readFile());
    }
}