package com.example.engineerProject.Article;

import com.example.engineerProject.OwnValidatior.Lang;
import com.example.engineerProject.OwnValidatior.SqlInjectionProtector;
import com.example.engineerProject.User.AppUser;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.util.Objects;

public class ArticleDto {
    private Long id;
    @NotNull
    @Size(min = 3, max = 150)
    @SqlInjectionProtector(lang = Lang.INJECTION_WORDS)
    private String title;
    private String picture;
    @NotNull
    @Size(max = 3500)
    @SqlInjectionProtector(lang = Lang.INJECTION_WORDS)
    private String description;
    private Date date;
    private Boolean approvedByManager;
    private AppUser user;

    public ArticleDto(){}

    public ArticleDto(Long id, String title, String picture, String description,
                      Date date, AppUser user) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.date = date;
        this.approvedByManager = false;
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
        return approvedByManager;
    }

    public void setApprovedByManager(Boolean approvedByManager) {
        this.approvedByManager = approvedByManager;
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
                Objects.equals(approvedByManager, that.approvedByManager) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, picture, description, date, approvedByManager, user);
    }
}
