package com.example.engineerProject.Agreement;

import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

public class AgreementDto {
    private Long id;
    private String name;
    private String type;
    private Date uploadDate;
    private byte[] bytes;

    public AgreementDto(){}

    public AgreementDto(Long id, String name, String type, Date uploadDate, byte[] bytes) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgreementDto that = (AgreementDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) && Objects.equals(uploadDate, that.uploadDate) &&
                Arrays.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, type, uploadDate);
        result = 31 * result + Arrays.hashCode(bytes);
        return result;
    }
}
