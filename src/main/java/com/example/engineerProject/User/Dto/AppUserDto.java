package com.example.engineerProject.User.Dto;

import com.example.engineerProject.Announcement.Announcement;
import com.example.engineerProject.Article.Article;
import com.example.engineerProject.User.Role;

import java.util.Objects;
import java.util.Set;

public class AppUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private String password;
    private Set<Announcement> announcements;
    private Set<Article> articles;
    private Role role;

    public AppUserDto(){}

    public AppUserDto(Long id, String firstName, String lastName, Integer phoneNumber,
                      String email, String password, Set<Announcement> announcements, Set<Article> articles, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.announcements = announcements;
        this.articles = articles;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDto appUserDto = (AppUserDto) o;
        return Objects.equals(id, appUserDto.id) && Objects.equals(firstName, appUserDto.firstName) &&
                Objects.equals(lastName, appUserDto.lastName) &&
                Objects.equals(phoneNumber, appUserDto.phoneNumber) &&
                Objects.equals(email, appUserDto.email) &&
                Objects.equals(password, appUserDto.password) &&
                Objects.equals(announcements, appUserDto.announcements) &&
                Objects.equals(articles, appUserDto.articles) && role == appUserDto.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email,
                password, announcements, articles, role);
    }
}
