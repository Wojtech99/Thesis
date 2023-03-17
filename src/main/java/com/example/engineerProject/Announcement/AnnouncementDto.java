package com.example.engineerProject.Announcement;

import com.example.engineerProject.Announcement.AnnouncementEnum.AnnouncementType;
import com.example.engineerProject.Announcement.Photo.Photo;
import com.example.engineerProject.User.AppUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnnouncementDto {
    private Long id;
    private AppUser user;
    private AnnouncementType announcementType;
    private Boolean isHighlighted;
    private String action;
    private String regionName;
    private String districtName;
    private String communeName;
    private String cityName;
    private String street;
    private Integer idCategory;
    private Integer idAdType;
    private Integer idAgent;
    private Float area;
    private Float areaUse;
    private Float price;
    private Float pricePM;
    private Integer rooms;
    private Integer floor;
    private Integer totalFloors;
    private Integer isElevator;
    private Integer idBuildingType;
    private Integer yearBuilt;
    private Integer idConditionType;
    private Integer isGarageParking;
    private String description;
    private Integer idAvailableFromType;
    private Integer availableFromYear;
    private Integer availableFromMonth;
    private Integer idOwnershipType;
    private Integer isBalcony;
    private Integer isBasement;
    private Integer levels;
    private Integer bathRooms;
    private Integer isFurnished;
    private Float pledge;
    private Integer idPledgeType;
    private String additionalCharges;
    private Float areaPlot;
    private Integer isMWater;
    private Integer idWaterType;
    private Integer idSewageType;
    private Integer isMElectricity;
    private Integer isEnclosure;
    private Integer idPlotAccessType;
    private Integer idPlotShapeType;
    private Integer idPlotType;
    private Integer isPlotAccessType;
    private Integer isMSewage;
    private Integer idBPDestType;
    private Integer idEntryType;
    private Integer isOwnBgGarageParking;
    private Integer idRoomCapacity;
    private Integer idAdCreator;
    private Integer isOvnerInHouse;
    private List<Photo> photos;

    public AnnouncementDto() {
        this.isHighlighted = false;
        this.photos = new ArrayList<>();
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

    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(AnnouncementType announcementType) {
        this.announcementType = announcementType;
    }

    public Boolean getHighlighted() {
        return isHighlighted;
    }

    public void setHighlighted(Boolean highlighted) {
        isHighlighted = highlighted;
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

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Integer getIdConditionType() {
        return idConditionType;
    }

    public void setIdConditionType(Integer idConditionType) {
        this.idConditionType = idConditionType;
    }

    public Integer getIsGarageParking() {
        return isGarageParking;
    }

    public void setIsGarageParking(Integer isGarageParking) {
        this.isGarageParking = isGarageParking;
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

    public Integer getIsBasement() {
        return isBasement;
    }

    public void setIsBasement(Integer isBasement) {
        this.isBasement = isBasement;
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

    public Integer getIsFurnished() {
        return isFurnished;
    }

    public void setIsFurnished(Integer isFurnished) {
        this.isFurnished = isFurnished;
    }

    public Float getPledge() {
        return pledge;
    }

    public void setPledge(Float pledge) {
        this.pledge = pledge;
    }

    public Integer getIdPledgeType() {
        return idPledgeType;
    }

    public void setIdPledgeType(Integer idPledgeType) {
        this.idPledgeType = idPledgeType;
    }

    public String getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(String additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    public Float getAreaPlot() {
        return areaPlot;
    }

    public void setAreaPlot(Float areaPlot) {
        this.areaPlot = areaPlot;
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

    public void setIdPlotShapeType(Integer idPlotShapeType) {
        this.idPlotShapeType = idPlotShapeType;
    }

    public Integer getIdPlotType() {
        return idPlotType;
    }

    public void setIdPlotType(Integer idPlotType) {
        this.idPlotType = idPlotType;
    }

    public Integer getIsPlotAccessType() {
        return isPlotAccessType;
    }

    public void setIsPlotAccessType(Integer isPlotAccessType) {
        this.isPlotAccessType = isPlotAccessType;
    }

    public Integer getIsMSewage() {
        return isMSewage;
    }

    public void setIsMSewage(Integer isMSewage) {
        this.isMSewage = isMSewage;
    }

    public Integer getIdBPDestType() {
        return idBPDestType;
    }

    public void setIdBPDestType(Integer idBPDestType) {
        this.idBPDestType = idBPDestType;
    }

    public Integer getIdEntryType() {
        return idEntryType;
    }

    public void setIdEntryType(Integer idEntryType) {
        this.idEntryType = idEntryType;
    }

    public Integer getIsOwnBgGarageParking() {
        return isOwnBgGarageParking;
    }

    public void setIsOwnBgGarageParking(Integer isOwnBgGarageParking) {
        this.isOwnBgGarageParking = isOwnBgGarageParking;
    }

    public Integer getIdRoomCapacity() {
        return idRoomCapacity;
    }

    public void setIdRoomCapacity(Integer idRoomCapacity) {
        this.idRoomCapacity = idRoomCapacity;
    }

    public Integer getIdAdCreator() {
        return idAdCreator;
    }

    public void setIdAdCreator(Integer idAdCreator) {
        this.idAdCreator = idAdCreator;
    }

    public Integer getIsOvnerInHouse() {
        return isOvnerInHouse;
    }

    public void setIsOvnerInHouse(Integer isOvnerInHouse) {
        this.isOvnerInHouse = isOvnerInHouse;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnnouncementDto that)) return false;
        return isHighlighted == that.isHighlighted && Objects.equals(user, that.user) && announcementType == that.announcementType && Objects.equals(action, that.action) && Objects.equals(regionName, that.regionName) && Objects.equals(districtName, that.districtName) && Objects.equals(communeName, that.communeName) && Objects.equals(cityName, that.cityName) && Objects.equals(street, that.street) && Objects.equals(idCategory, that.idCategory) && Objects.equals(idAdType, that.idAdType) && Objects.equals(idAgent, that.idAgent) && Objects.equals(area, that.area) && Objects.equals(areaUse, that.areaUse) && Objects.equals(price, that.price) && Objects.equals(pricePM, that.pricePM) && Objects.equals(rooms, that.rooms) && Objects.equals(floor, that.floor) && Objects.equals(totalFloors, that.totalFloors) && Objects.equals(isElevator, that.isElevator) && Objects.equals(idBuildingType, that.idBuildingType) && Objects.equals(yearBuilt, that.yearBuilt) && Objects.equals(idConditionType, that.idConditionType) && Objects.equals(isGarageParking, that.isGarageParking) && Objects.equals(description, that.description) && Objects.equals(idAvailableFromType, that.idAvailableFromType) && Objects.equals(availableFromYear, that.availableFromYear) && Objects.equals(availableFromMonth, that.availableFromMonth) && Objects.equals(idOwnershipType, that.idOwnershipType) && Objects.equals(isBalcony, that.isBalcony) && Objects.equals(isBasement, that.isBasement) && Objects.equals(levels, that.levels) && Objects.equals(bathRooms, that.bathRooms) && Objects.equals(isFurnished, that.isFurnished) && Objects.equals(pledge, that.pledge) && Objects.equals(idPledgeType, that.idPledgeType) && Objects.equals(additionalCharges, that.additionalCharges) && Objects.equals(areaPlot, that.areaPlot) && Objects.equals(isMWater, that.isMWater) && Objects.equals(idWaterType, that.idWaterType) && Objects.equals(idSewageType, that.idSewageType) && Objects.equals(isMElectricity, that.isMElectricity) && Objects.equals(isEnclosure, that.isEnclosure) && Objects.equals(idPlotAccessType, that.idPlotAccessType) && Objects.equals(idPlotShapeType, that.idPlotShapeType) && Objects.equals(idPlotType, that.idPlotType) && Objects.equals(isPlotAccessType, that.isPlotAccessType) && Objects.equals(isMSewage, that.isMSewage) && Objects.equals(idBPDestType, that.idBPDestType) && Objects.equals(idEntryType, that.idEntryType) && Objects.equals(isOwnBgGarageParking, that.isOwnBgGarageParking) && Objects.equals(idRoomCapacity, that.idRoomCapacity) && Objects.equals(idAdCreator, that.idAdCreator) && Objects.equals(isOvnerInHouse, that.isOvnerInHouse) && Objects.equals(photos, that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, announcementType, isHighlighted, action, regionName, districtName, communeName, cityName, street, idCategory, idAdType, idAgent, area, areaUse, price, pricePM, rooms, floor, totalFloors, isElevator, idBuildingType, yearBuilt, idConditionType, isGarageParking, description, idAvailableFromType, availableFromYear, availableFromMonth, idOwnershipType, isBalcony, isBasement, levels, bathRooms, isFurnished, pledge, idPledgeType, additionalCharges, areaPlot, isMWater, idWaterType, idSewageType, isMElectricity, isEnclosure, idPlotAccessType, idPlotShapeType, idPlotType, isPlotAccessType, isMSewage, idBPDestType, idEntryType, isOwnBgGarageParking, idRoomCapacity, idAdCreator, isOvnerInHouse, photos);
    }
}
