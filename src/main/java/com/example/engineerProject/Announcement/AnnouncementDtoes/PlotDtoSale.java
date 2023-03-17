package com.example.engineerProject.Announcement.AnnouncementDtoes;

import com.example.engineerProject.Announcement.AnnouncementDto;
import com.example.engineerProject.Announcement.AnnouncementEnum.AnnouncementType;

import com.example.engineerProject.User.AppUser;
import jakarta.validation.constraints.NotNull;

public class PlotDtoSale extends AnnouncementDto {
    private AppUser user;
    @NotNull(message = "This field can not be null")
    private Long id;
    private AnnouncementType announcementType;
    @NotNull(message = "This field can not be null")
    private String action;
    @NotNull(message = "This field can not be null")
    private String regionName;
    @NotNull(message = "This field can not be null")
    private String districtName;
    @NotNull(message = "This field can not be null")
    private String communeName;
    @NotNull(message = "This field can not be null")
    private String cityName;
    private String street;
    @NotNull(message = "This field can not be null")
    private Integer idCategory;
    @NotNull(message = "This field can not be null")
    private Integer idAdType;
    @NotNull(message = "This field can not be null")
    private Integer idAgent;
    @NotNull(message = "This field can not be null")
    private Float area;
    @NotNull(message = "This field can not be null")
    private Float price;
    @NotNull(message = "This field can not be null")
    private Float pricePM;
    @NotNull(message = "This field can not be null")
    private String description;
    private Integer idOwnershipType;
    private Integer isMWater;
    private Integer idWaterType;
    private Integer idSewageType;
    private Integer isMElectricity;
    private Integer isEnclosure;
    private Integer idPlotAccessType;
    private Integer idPlotShapeType;

    @NotNull(message = "This field can not be null")
    private Integer idPlotType;
    private Integer isPlotAccessType;
    private Integer isMSewage;

    public PlotDtoSale() {
        this.announcementType = AnnouncementType.PLOT_SALE;
    }

    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(AnnouncementType announcementType) {
        this.announcementType = announcementType;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdAdType() {
        return idAdType;
    }

    public void setIdAdType(Integer idAdType) {
        this.idAdType = idAdType;
    }

    public Integer getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(Integer idAgent) {
        this.idAgent = idAgent;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPricePM() {
        return pricePM;
    }

    public void setPricePM(Float pricePM) {
        this.pricePM = pricePM;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdOwnershipType() {
        return idOwnershipType;
    }

    public void setIdOwnershipType(Integer idOwnershipType) {
        this.idOwnershipType = idOwnershipType;
    }

    public Integer getIsMWater() {
        return isMWater;
    }

    public void setIsMWater(Integer isMWater) {
        this.isMWater = isMWater;
    }

    public Integer getIdWaterType() {
        return idWaterType;
    }

    public void setIdWaterType(Integer idWaterType) {
        this.idWaterType = idWaterType;
    }

    public Integer getIdSewageType() {
        return idSewageType;
    }

    public void setIdSewageType(Integer idSewageType) {
        this.idSewageType = idSewageType;
    }

    public Integer getIsMElectricity() {
        return isMElectricity;
    }

    public void setIsMElectricity(Integer isMElectricity) {
        this.isMElectricity = isMElectricity;
    }

    public Integer getIsEnclosure() {
        return isEnclosure;
    }

    public void setIsEnclosure(Integer isEnclosure) {
        this.isEnclosure = isEnclosure;
    }

    public Integer getIdPlotAccessType() {
        return idPlotAccessType;
    }

    public void setIdPlotAccessType(Integer idPlotAccessType) {
        this.idPlotAccessType = idPlotAccessType;
    }

    public Integer getIdPlotShapeType() {
        return idPlotShapeType;
    }


}
