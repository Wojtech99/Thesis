package com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Agents;

public class PropertiesOnlineAgent {
    private Integer idAgent;
    private Integer isProAgentDeclaration;
    private String name;
    private String surname;
    private Integer phone;
    private String email;
    private Integer licenseNr;

    public void setIdAgent(Integer idAgent) {
        this.idAgent = idAgent;
    }

    public void setIsProAgentDeclaration(Integer isProAgentDeclaration) {
        this.isProAgentDeclaration = isProAgentDeclaration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLicenseNr(Integer licenseNr) {
        this.licenseNr = licenseNr;
    }
}
