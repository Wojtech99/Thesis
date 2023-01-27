package com.example.engineerProject.Data;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FilenameService {
    String PreparedStringToSave(String fileName) {
        StringBuffer stringBuffer = new StringBuffer();

        Arrays.stream(fileName
                .toLowerCase()
                .replace(' ', '_')
                .split(" "))
                .forEach(stringBuffer::append);


        return stringBuffer.toString();
    }
}