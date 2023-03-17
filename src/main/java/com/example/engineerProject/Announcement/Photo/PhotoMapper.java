package com.example.engineerProject.Announcement.Photo;

public class PhotoMapper {
    public static Photo map(PhotoDto photoDto) {
        Photo photo = new Photo(photoDto.getName());
        photo.setId(photoDto.getId());
        photo.setAnnouncement(photoDto.getAnnouncement());

        return photo;
    }

    public static PhotoDto map(Photo photo) {
        PhotoDto photoDto = new PhotoDto(photo.getName(), photo.getAnnouncement());
        photoDto.setId(photo.getId());

        return photoDto;
    }
}
