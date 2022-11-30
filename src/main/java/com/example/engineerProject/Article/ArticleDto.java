package com.example.engineerProject.Article;

import com.example.engineerProject.User.AppUser;

import java.sql.Date;
import java.util.Objects;

public class ArticleDto {
    Long id;
    String title;
    String picture;
    String description;
    Date date;
    Boolean isApprovedByManager;
    AppUser user;

    public ArticleDto(Long id, String title, String picture, String description,
                      Date date, Boolean isApprovedByManager, AppUser user) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.date = date;
        this.isApprovedByManager = isApprovedByManager;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getApprovedByManager() {
        return isApprovedByManager;
    }

    public void setApprovedByManager(Boolean approvedByManager) {
        isApprovedByManager = approvedByManager;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDto that = (ArticleDto) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) &&
                Objects.equals(picture, that.picture) &&
                Objects.equals(description, that.description) && Objects.equals(date, that.date) &&
                Objects.equals(isApprovedByManager, that.isApprovedByManager) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, picture, description, date, isApprovedByManager, user);
    }
}
