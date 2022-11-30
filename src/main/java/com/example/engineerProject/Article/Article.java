package com.example.engineerProject.Article;

import com.example.engineerProject.User.AppUser;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    AppUser user;
    String title;
    String picture;
    String description;
    Date date;
    Boolean isApprovedByManager;

    public Article(){}

    public Article(Long id, String title, String picture, String description, Date date) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.date = date;
        this.isApprovedByManager = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
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
}
