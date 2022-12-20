package com.example.engineerProject.Data;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface Data {
    String saveData(MultipartFile multipartFile) throws IOException;

    void deleteData(String filePath) throws IOException;

}
