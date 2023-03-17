package com.example.engineerProject.Announcement.Photo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Transactional
    public Photo savePhoto(PhotoDto photoDto) {
        Photo photoToSave = PhotoMapper.map(photoDto);
        Photo savedPhoto = photoRepository.save(photoToSave);

        return savedPhoto;
    }

    @Transactional
    public void deletePhoto(PhotoDto photoDto) {
        photoRepository.deleteById(photoDto.getId());
    }

    @Transactional
    public void deletePhotoByName(String photoName) {
        photoRepository.deleteByName(photoName);
    }
}
