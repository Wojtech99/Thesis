package com.example.engineerProject.Announcement;

import com.example.engineerProject.Announcement.AnnouncementEnum.AnnouncementType;
import com.example.engineerProject.Announcement.Photo.Photo;
import com.example.engineerProject.Announcement.Photo.PhotoDto;
import com.example.engineerProject.Announcement.Photo.PhotoService;
import com.example.engineerProject.Data.ImageService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Controller
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final ImageService imageService;
    private final PhotoService photoService;

    public AnnouncementController(AnnouncementService announcementService, ImageService imageService,
                                  PhotoService photoService) {
        this.announcementService = announcementService;
        this.imageService = imageService;
        this.photoService = photoService;
    }

    @GetMapping("/new-announcement")
    String newAnnouncement(Model model) {
        List<String> announcementsType = AnnouncementType.getAnnouncementsDescription();

        model.addAttribute("announcementsTypeList", announcementsType);

        return "choose-announcement-type";
    }

    @GetMapping("/add-announcement")
    String addAnnouncement(@RequestParam("announcementType") String announcementTypeDescription, Model model) {
        AnnouncementType announcementType = AnnouncementType.getTypeByDescription(announcementTypeDescription);

        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setAnnouncementType(announcementType);

        String returnSite = switch (announcementDto.getAnnouncementType()) {
            case HOUSE_RENT ->"form-house-rent";
            case HOUSE_SALE ->"form-house-sale";
            case BUILDING_RENT -> "form-building-rent";
            case BUILDING_SALE -> "form-building-sale";
            case FLAT_RENT ->"form-flat-rent";
            case FLAT_SALE ->"form-flat-sale";
            case PLOT_RENT ->"form-plot-rent";
            case PLOT_SALE ->"form-plot-sale";
            case PREMISES_RENT ->"form-premises-rent";
            case PREMISES_SALE ->"form-premises-sale";
            case ROOM_RENT ->"form-room-rent";
        };

        model.addAttribute("property", announcementDto);


        return returnSite;

    }

    @PostMapping("/add-announcement/save")
    String saveAnnouncement(@Valid @ModelAttribute("property") AnnouncementDto announcementDto,
                            @RequestParam("files") List<MultipartFile> imageFiles,
                            @Param("photos") List<String> imageNames,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new-announcementDto-form";
        }

        if (imageFiles.size() != 0) {
            imageNames.forEach(photoName -> {
                try {
                    imageService.deleteData(photoName);

                    photoService.deletePhotoByName(photoName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        announcementService.setPrimaryInformation(announcementDto);

        if(imageFiles.size() != 0) {
            Announcement savedAnnouncement = announcementService.saveAnnouncement(announcementDto);

            imageFiles.forEach(imageFile -> {
                try {
                    String imagePath = imageService.saveData(imageFile);


                    Photo savedPhoto = photoService.savePhoto(new PhotoDto(imagePath, savedAnnouncement));
                    announcementDto.addPhoto(savedPhoto);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            announcementDto.setId(savedAnnouncement.getId());
        }

        announcementService.saveAnnouncement(announcementDto);

        return "redirect:/all-user-announcement";
    }

    @GetMapping("/edit-announcement/{id}")
    String editAnnouncement(@PathVariable("id") Long announcementId, Model model) {
        Optional<AnnouncementDto> optionalAnnouncementDto = announcementService.findAnnouncementById(announcementId);

        if (optionalAnnouncementDto.isEmpty()) {
            return "redirect:/all-user-announcement";
        }

        AnnouncementDto announcementDto = optionalAnnouncementDto.get();
        model.addAttribute("property", announcementDto);

        return "form-building-rent";
    }

    @RequestMapping(
            value = "/all-user-announcement/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteAnnouncement(@PathVariable("id") Long announcementId) {
        Optional<AnnouncementDto> optionalAnnouncementDto = announcementService.findAnnouncementById(announcementId);

        if (optionalAnnouncementDto.isEmpty()) {
            return "redirect:/all-user-announcement";
        }

        AnnouncementDto announcementDto = optionalAnnouncementDto.get();

        if (announcementDto.getPhotos().size() != 0) {
            announcementDto.getPhotos().forEach(photo -> {
                try {
                    imageService.deleteData(photo.getName());

                    photoService.deletePhotoByName(photo.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        announcementService.deleteAnnouncement(announcementId);

        return "redirect:/all-user-announcement";
    }

    @GetMapping("/all-user-announcement")
    String takeAllUserAnnouncements(Model model) {
        Set<AnnouncementDto> announcementDtoSet = new HashSet<>();
        announcementService.announcementByUser().ifPresent(announcementDtoSet::addAll);

        model.addAttribute("announcementSet", announcementDtoSet);

        return "agent-announcement-list";
    }

    @GetMapping("/announcements")
    String takeAllAnnouncements(Model model) {
        Set<AnnouncementDto> announcementDtoSet = announcementService.getAllAnnouncement();

        model.addAttribute("announcementSet",announcementDtoSet);

        return "announcement-list";
    }

    @GetMapping("/announcement/{id}")
    String singleAnnouncement(@PathVariable("id") Long announcementId, Model model) {
        Optional<AnnouncementDto> optionalAnnouncementDto = announcementService.findAnnouncementById(announcementId);

        if (optionalAnnouncementDto.isEmpty()) {
            return "redirect:/announcements";
        }

        AnnouncementDto announcementDto = optionalAnnouncementDto.get();
        model.addAttribute("announcement", announcementDto);

        return "single-announcement";
    }

    @GetMapping("/choose-announcements")
    String chooseAnnouncementsOnMaiSite(Model model) {
        Set<AnnouncementDto> announcementDtoSet = announcementService.getAllAnnouncement();

        model.addAttribute("properties", announcementDtoSet);

        return "choose-highlighted-announcements-form";
    }

    @PostMapping("/choose-announcements/save")
    String saveHighlightedAnnouncements(@RequestParam("selectedProperties") Set<Long> choseAnnouncements) {
        int maximumHighlightedAnnouncements = 3;

        if (choseAnnouncements.stream().count() > maximumHighlightedAnnouncements) {
            return "choose-highlighted-announcements-form";
        }

        announcementService.highlightChoseAnnouncements(choseAnnouncements);

        return "redirect:/";
    }

}
