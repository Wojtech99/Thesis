package com.example.engineerProject.Announcement;

import com.example.engineerProject.Announcement.AnnouncementEnum.AnnouncementType;
import com.example.engineerProject.Announcement.Photo.PhotoService;
import com.example.engineerProject.User.AppUser;
import com.example.engineerProject.User.AppUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final PhotoService photoService;
    private final AppUserService userService;

    public AnnouncementService(AnnouncementRepository announcementRepository,
                               PhotoService photoService, AppUserService userService) {
        this.announcementRepository = announcementRepository;
        this.photoService = photoService;
        this.userService = userService;
    }

    @Transactional
    Announcement saveAnnouncement(AnnouncementDto announcementDto){
        Announcement announcementToSave = AnnouncementMapper.map(announcementDto);
        return announcementRepository.save(announcementToSave);
    }

    @Transactional
    void deleteAnnouncement(Long announcementId) {
        announcementRepository.deleteById(announcementId);
    }

    void setPrimaryInformation(AnnouncementDto announcementDto) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser currentUser = userService.getUserToAnnouncementByEmail(currentUserEmail);

        AnnouncementType announcementType = announcementDto.getAnnouncementType();

        announcementDto.setUser(currentUser);
        announcementDto.setIdCategory(announcementType.getIdCategory());
        announcementDto.setIdAdType(announcementType.getIdAdType());
    }

    Optional<Set<AnnouncementDto>> announcementByUser(){
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Long currentUserId = userService.getUserIdByEmail(currentUserEmail);


        return Optional.of(announcementRepository.findAllByUser_Id(currentUserId).stream()
                .map(AnnouncementMapper::map)
                .collect(Collectors.toSet()));
    }

    Set<AnnouncementDto> getAllAnnouncement(){
        Set<AnnouncementDto> announcementDtoSet = new HashSet<>();

        announcementRepository.getAll().forEach(announcement -> {
            announcementDtoSet.add(AnnouncementMapper.map(announcement));
        });

        return announcementDtoSet;
    }

    Optional<AnnouncementDto> findAnnouncementById(Long announcementId) {
        Optional<Announcement> announcement = announcementRepository.findById(announcementId);

        if (announcement.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(AnnouncementMapper.map(announcement.get()));
    }

    void highlightChoseAnnouncements(Set<Long> choseAnnouncements) {
        Set<Announcement> previouslyHighlightedAnnouncements = announcementRepository.findAllByIsHighlighted(true);

        previouslyHighlightedAnnouncements.forEach(announcement -> {
            announcement.setHighlighted(false);
            announcementRepository.save(announcement);
        });

        choseAnnouncements.forEach(announcementId -> {
            Optional<Announcement> optionalAnnouncement = announcementRepository.findById(announcementId);

            if (optionalAnnouncement.isPresent()){
                Announcement announcement = optionalAnnouncement.get();
                announcement.setHighlighted(true);

                announcementRepository.save(announcement);
            }
        });
    }

    public Set<AnnouncementDto> getHighlightedAnnouncements() {
        Set<AnnouncementDto> highlightedDtoAnnouncements = new HashSet<>();

        announcementRepository.findAllByIsHighlighted(true).forEach(announcement -> {
           highlightedDtoAnnouncements.add(AnnouncementMapper.map(announcement));
        });

        return highlightedDtoAnnouncements;
    }
}
