package com.example.engineerProject.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Objects;

@Service
public class ImageService implements Data{

    @Value("${staticImageDirectory}")
    private String IMAGES_PATH;

    public String UPLOAD_DIRECTORY = System.getProperty("user.dir");
    private final FilenameService filenameService;

    public ImageService(FilenameService filenameService) {
        this.filenameService = filenameService;
    }

    @Override
    public String saveData(MultipartFile imageFile) throws IOException {
        byte[] bytes = imageFile.getBytes();

        String filenameToSave = "/" + filenameService.PreparedStringToSave(Objects.requireNonNull(
                imageFile.getOriginalFilename()));

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        String datePath = year + "/" + month;

        Path path = Paths.get(UPLOAD_DIRECTORY + IMAGES_PATH + datePath);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        Path pathToSave = Paths.get(UPLOAD_DIRECTORY + IMAGES_PATH + datePath + filenameToSave);

        Files.write(pathToSave, bytes);

        return datePath + filenameToSave;
    }

    @Override
    public void deleteData(String picturePath) throws IOException {
        Path path = Path.of(UPLOAD_DIRECTORY + IMAGES_PATH + picturePath);
        Files.delete(path);
    }
}
