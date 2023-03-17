package com.example.engineerProject.Announcement.AnnouncementEnum;

import java.util.ArrayList;
import java.util.List;

public enum AnnouncementType {
    BUILDING_RENT("Budynek - Wynajem",5,2),
    BUILDING_SALE("Budynek - Sprzedaż",5,1),
    FLAT_RENT("Mieszkanie - Wynajem",1,2),
    FLAT_SALE("Mieszkanie - Sprzedaż",1,1),
    HOUSE_RENT("Dom - Wynajem",2,2),
    HOUSE_SALE("Dom - Sprzedaż",2,1),
    PLOT_RENT("Działka - Wynajem",3,2),
    PLOT_SALE("Działka - Sprzedaż",3,1),
    PREMISES_RENT("Lokal - Wynajem",4,2),
    PREMISES_SALE("Lokal - Sprzedaż",4,2),
    ROOM_RENT("Pokój - Wynajem",4,1);

    private String description;
    private Integer idCategory;
    private Integer idAdType;


    AnnouncementType(String description, Integer idCategory, Integer idAdType) {
        this.description = description;
        this.idCategory = idCategory;
        this.idAdType = idAdType;
    }

    public String getDescription() {
        return description;
    }

    public int getIdCategory() {return idCategory;}

    public int getIdAdType() {return idAdType;}

    public static List<String> getAnnouncementsDescription() {
        List<String> descriptionList = new ArrayList<>();

        for (AnnouncementType type : AnnouncementType.values()) {
            descriptionList.add(type.getDescription());
        }

        return descriptionList;
    }

    public static AnnouncementType getTypeByDescription(String typeDescription) {
        for (AnnouncementType type : AnnouncementType.values()) {
            if (type.description.equals(typeDescription)) {
                return type;
            }
        }

        return null;
    }
}
