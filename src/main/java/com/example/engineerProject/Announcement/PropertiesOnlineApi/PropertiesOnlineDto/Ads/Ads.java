package com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Ads;

import java.util.List;

public class Ads {
    private List<PropertyOnlineAd> ad;

    public List<PropertyOnlineAd> getAd() {
        return ad;
    }

    public void setAd(List<PropertyOnlineAd> ad) {
        this.ad = ad;
    }

    public void addPropertyOnlineAdDtoToAdList(PropertyOnlineAd singleAd) {
        this.ad.add(singleAd);
    }
}
