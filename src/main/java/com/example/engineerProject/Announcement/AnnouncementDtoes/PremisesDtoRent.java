package com.example.engineerProject.Announcement.AnnouncementDtoes;

import com.example.engineerProject.Announcement.AnnouncementDto;
import com.example.engineerProject.Announcement.AnnouncementEnum.AnnouncementType;

import com.example.engineerProject.User.AppUser;
import jakarta.validation.constraints.NotNull;

public class PremisesDtoRent extends AnnouncementDto {
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
    private Float areaUse;
    @NotNull(message = "This field can not be null")
    private Float price;
    @NotNull(message = "This field can not be null")
    private Float pricePM;
    private Integer rooms;
    private Integer floor;
    private Integer totalFloors;
    private Integer isElevator;
    private Integer idBuildingType;
    private Integer idConditionType;
    @NotNull(message = "This field can not be null")
    private String description;
    private Integer idAvailableFromType;
    @NotNull(message = "This field can not be null")
    private Integer availableFromYear;
    @NotNull(message = "This field can not be null")
    private Integer availableFromMonth;
    private Integer idOwnershipType;
    private Integer isBalcony;
    private Integer levels;
    private Integer bathRooms;
    private Integer isFurnished;
    private Float pledge;
    private Integer idPledgeType;
    private String additionalCharges;
    private Integer isMWater;
    private Integer isMElectricity;
    private Integer isMSewage;
    private Integer idBPDestType;
    private Integer idEntryType;
    private Integer isOwnBgGarageParking;

    public PremisesDtoRent() {
        this.announcementType = AnnouncementType.PREMISES_RENT;
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

    public Float getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(Float areaUse) {
        this.areaUse = areaUse;
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

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(Integer totalFloors) {
        this.totalFloors = totalFloors;
    }

    public Integer getIsElevator() {
        return isElevator;
    }

    public void setIsElevator(Integer isElevator) {
        this.isElevator = isElevator;
    }

    public Integer getIdBuildingType() {
        return idBuildingType;
    }

    public void setIdBuildingType(Integer idBuildingType) {
        this.idBuildingType = idBuildingType;
    }

    public Integer getIdConditionType() {
        return idConditionType;
    }

    public void setIdConditionType(Integer idConditionType) {
        this.idConditionType = idConditionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdAvailableFromType() {
        return idAvailableFromType;
    }

    public void setIdAvailableFromType(Integer idAvailableFromType) {
        this.idAvailableFromType = idAvailableFromType;
    }

    public Integer getAvailableFromYear() {
        return availableFromYear;
    }

    public void setAvailableFromYear(Integer availableFromYear) {
        this.availableFromYear = availableFromYear;
    }

    public Integer getAvailableFromMonth() {
        return availableFromMonth;
    }

    public void setAvailableFromMonth(Integer availableFromMonth) {
        this.availableFromMonth = availableFromMonth;
    }

    public Integer getIdOwnershipType() {
        return idOwnershipType;
    }

    public void setIdOwnershipType(Integer idOwnershipType) {
        this.idOwnershipType = idOwnershipType;
    }

    public Integer getIsBalcony() {
        return isBalcony;
    }

    public void setIsBalcony(Integer isBalcony) {
        this.isBalcony = isBalcony;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getBathRooms() {
        return bathRooms;
    }

    public void setBathRooms(Integer bathRooms) {
        this.bathRooms = bathRooms;
    }


}
