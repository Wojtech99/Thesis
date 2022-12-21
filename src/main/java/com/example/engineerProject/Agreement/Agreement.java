package com.example.engineerProject.Agreement;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Date uploadDate;
    @Lob()
    private byte[] bytes;

    public Agreement(){}

    public Agreement(Long id, String name, String type, Date uploadDate, byte[] bytes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.uploadDate = uploadDate;
        this.bytes = bytes;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
