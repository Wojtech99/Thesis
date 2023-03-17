package com.example.engineerProject.Announcement.Photo;

import com.example.engineerProject.Announcement.Announcement;
import com.example.engineerProject.Announcement.AnnouncementDto;

import java.util.Objects;

public class PhotoDto {
    private Long id;
    private String name;
    private Announcement announcement;

    public PhotoDto() {}

    public PhotoDto(String name, Announcement announcement) {
        this.name = name;
        this.announcement = announcement;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoDto photoDto)) return false;
        return Objects.equals(name, photoDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
