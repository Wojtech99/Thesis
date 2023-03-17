package com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Ads;

import com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Ads.PropertyOnlineAdDetails.PropertyOnlineAdDetails;
import com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Ads.PropertyOnlineAdMap.PropertyOnlineAdMap;
import com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Ads.PropertyOnlineAdPhotos.PropertyOnlineAdPhotos;

public class PropertyOnlineAd {
    private PropertyOnlineAdDetails details;
    private PropertyOnlineAdMap map;
    private PropertyOnlineAdPhotos photos;

    public PropertyOnlineAdDetails getDetails() {
        return details;
    }

    public void setDetails(PropertyOnlineAdDetails details) {
        this.details = details;
    }

    public PropertyOnlineAdMap getMap() {
        return map;
    }

    public void setMap(PropertyOnlineAdMap map) {
        this.map = map;
    }

    public PropertyOnlineAdPhotos getPhotos() {
        return photos;
    }

    public void setPhotos(PropertyOnlineAdPhotos photos) {
        this.photos = photos;
    }
}
