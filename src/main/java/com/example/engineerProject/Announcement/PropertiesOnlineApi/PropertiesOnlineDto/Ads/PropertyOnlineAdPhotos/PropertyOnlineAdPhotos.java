package com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Ads.PropertyOnlineAdPhotos;

import java.util.List;

public class PropertyOnlineAdPhotos {
    private List<String> photo;

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

    public void addToPhoto(String newPhoto) {
        this.photo.add(newPhoto);
    }
}
