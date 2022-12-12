package com.example.engineerProject.Announcement;

import com.example.engineerProject.User.AppUser;
import jakarta.persistence.*;

@Entity(name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    AppUser user;
}
