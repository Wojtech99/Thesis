package com.example.engineerProject.Announcement;

public class AnnouncementMapper {
    public static Announcement map(AnnouncementDto announcementDto) {
        Announcement announcement = new Announcement();

        announcement.setUser(announcementDto.getUser());
        announcement.setId(announcementDto.getId());
        announcement.setAnnouncementType(announcementDto.getAnnouncementType());
        announcement.setAction(announcementDto.getAction());
        announcement.setRegionName(announcementDto.getRegionName());
        announcement.setDistrictName(announcementDto.getDistrictName());
        announcement.setCommuneName(announcementDto.getCommuneName());
        announcement.setCityName(announcementDto.getCityName());
        announcement.setStreet(announcementDto.getStreet());
        announcement.setIdCategory(announcementDto.getIdCategory());
        announcement.setIdAdType(announcementDto.getIdAdType());
        announcement.setIdAgent(announcementDto.getIdAgent());
        announcement.setArea(announcementDto.getArea());
        announcement.setAreaUse(announcementDto.getAreaUse());
        announcement.setPrice(announcementDto.getPrice());
        announcement.setPricePM(announcementDto.getPricePM());
        announcement.setRooms(announcementDto.getRooms());
        announcement.setFloor(announcementDto.getFloor());
        announcement.setTotalFloors(announcementDto.getTotalFloors());
        announcement.setIsElevator(announcementDto.getIsElevator());
        announcement.setIdBuildingType(announcementDto.getIdBuildingType());
        announcement.setYearBuilt(announcementDto.getYearBuilt());
        announcement.setIdConditionType(announcementDto.getIdConditionType());
        announcement.setIsGarageParking(announcementDto.getIsGarageParking());
        announcement.setDescription(announcementDto.getDescription());
        announcement.setIdAvailableFromType(announcementDto.getIdAvailableFromType());
        announcement.setAvailableFromYear(announcementDto.getAvailableFromYear());
        announcement.setAvailableFromMonth(announcementDto.getAvailableFromMonth());
        announcement.setIdOwnershipType(announcementDto.getIdOwnershipType());
        announcement.setIsBalcony(announcementDto.getIsBalcony());
        announcement.setIsBasement(announcementDto.getIsBasement());
        announcement.setLevels(announcementDto.getLevels());
        announcement.setBathRooms(announcementDto.getBathRooms());
        announcement.setIsFurnished(announcementDto.getIsFurnished());
        announcement.setPledge(announcementDto.getPledge());
        announcement.setIdPledgeType(announcementDto.getIdPledgeType());
        announcement.setAdditionalCharges(announcementDto.getAdditionalCharges());
        announcement.setAreaPlot(announcementDto.getAreaPlot());
        announcement.setIsMWater(announcementDto.getIsMWater());
        announcement.setIdWaterType(announcementDto.getIdWaterType());
        announcement.setIdSewageType(announcementDto.getIdSewageType());
        announcement.setIsMElectricity(announcementDto.getIsMElectricity());
        announcement.setIsEnclosure(announcementDto.getIsEnclosure());
        announcement.setIdPlotAccessType(announcementDto.getIdPlotAccessType());
        announcement.setIdPlotShapeType(announcementDto.getIdPlotShapeType());
        announcement.setIdPlotType(announcementDto.getIdPlotType());
        announcement.setIsPlotAccessType(announcementDto.getIsPlotAccessType());
        announcement.setIsMSewage(announcementDto.getIsMSewage());
        announcement.setIdBPDestType(announcementDto.getIdBPDestType());
        announcement.setIdEntryType(announcementDto.getIdEntryType());
        announcement.setIsOwnBgGarageParking(announcementDto.getIsOwnBgGarageParking());
        announcement.setIdRoomCapacity(announcementDto.getIdRoomCapacity());
        announcement.setIdAdCreator(announcementDto.getIdAdCreator());
        announcement.setIsOvnerInHouse(announcementDto.getIsOvnerInHouse());
        announcement.setPhotos(announcementDto.getPhotos());

        return announcement;
    }

    public static AnnouncementDto map(Announcement announcement) {
        AnnouncementDto announcementDto = new AnnouncementDto();

        announcementDto.setUser(announcement.getUser());
        announcementDto.setId(announcement.getId());
        announcementDto.setAnnouncementType(announcement.getAnnouncementType());
        announcementDto.setAction(announcement.getAction());
        announcementDto.setRegionName(announcement.getRegionName());
        announcementDto.setDistrictName(announcement.getDistrictName());
        announcementDto.setCommuneName(announcement.getCommuneName());
        announcementDto.setCityName(announcement.getCityName());
        announcementDto.setStreet(announcement.getStreet());
        announcementDto.setIdCategory(announcement.getIdCategory());
        announcementDto.setIdAdType(announcement.getIdAdType());
        announcementDto.setIdAgent(announcement.getIdAgent());
        announcementDto.setArea(announcement.getArea());
        announcementDto.setAreaUse(announcement.getAreaUse());
        announcementDto.setPrice(announcement.getPrice());
        announcementDto.setPricePM(announcement.getPricePM());
        announcementDto.setRooms(announcement.getRooms());
        announcementDto.setFloor(announcement.getFloor());
        announcementDto.setTotalFloors(announcement.getTotalFloors());
        announcementDto.setIsElevator(announcement.getIsElevator());
        announcementDto.setIdBuildingType(announcement.getIdBuildingType());
        announcementDto.setYearBuilt(announcement.getYearBuilt());
        announcementDto.setIdConditionType(announcement.getIdConditionType());
        announcementDto.setIsGarageParking(announcement.getIsGarageParking());
        announcementDto.setDescription(announcement.getDescription());
        announcementDto.setIdAvailableFromType(announcement.getIdAvailableFromType());
        announcementDto.setAvailableFromYear(announcement.getAvailableFromYear());
        announcementDto.setAvailableFromMonth(announcement.getAvailableFromMonth());
        announcementDto.setIdOwnershipType(announcement.getIdOwnershipType());
        announcementDto.setIsBalcony(announcement.getIsBalcony());
        announcementDto.setIsBasement(announcement.getIsBasement());
        announcementDto.setLevels(announcement.getLevels());
        announcementDto.setBathRooms(announcement.getBathRooms());
        announcementDto.setIsFurnished(announcement.getIsFurnished());
        announcementDto.setPledge(announcement.getPledge());
        announcementDto.setIdPledgeType(announcement.getIdPledgeType());
        announcementDto.setAdditionalCharges(announcement.getAdditionalCharges());
        announcementDto.setAreaPlot(announcement.getAreaPlot());
        announcementDto.setIsMWater(announcement.getIsMWater());
        announcementDto.setIdWaterType(announcement.getIdWaterType());
        announcementDto.setIdSewageType(announcement.getIdSewageType());
        announcementDto.setIsMElectricity(announcement.getIsMElectricity());
        announcementDto.setIsEnclosure(announcement.getIsEnclosure());
        announcementDto.setIdPlotAccessType(announcement.getIdPlotAccessType());
        announcementDto.setIdPlotShapeType(announcement.getIdPlotShapeType());
        announcementDto.setIdPlotType(announcement.getIdPlotType());
        announcementDto.setIsPlotAccessType(announcement.getIsPlotAccessType());
        announcementDto.setIsMSewage(announcement.getIsMSewage());
        announcementDto.setIdBPDestType(announcement.getIdBPDestType());
        announcementDto.setIdEntryType(announcement.getIdEntryType());
        announcementDto.setIsOwnBgGarageParking(announcement.getIsOwnBgGarageParking());
        announcementDto.setIdRoomCapacity(announcement.getIdRoomCapacity());
        announcementDto.setIdAdCreator(announcement.getIdAdCreator());
        announcementDto.setIsOvnerInHouse(announcement.getIsOvnerInHouse());
        announcementDto.setPhotos(announcement.getPhotos());

        return announcementDto;
    }
}
