package com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Ads.PropertyOnlineAdDetails;

import java.util.List;

public class PropertyOnlineAdDetailsJHeatingType {
    private List<Integer> v;

    public List<Integer> getV() {
        return v;
    }

    public void setV(List<Integer> v) {
        this.v = v;
    }

    public void addToV(Integer jHeatingType) {
        this.v.add(jHeatingType);
    }
}
