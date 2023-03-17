package com.example.engineerProject.Web;

import com.example.engineerProject.Announcement.AnnouncementDto;
import com.example.engineerProject.Announcement.AnnouncementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {
    private final AnnouncementService announcementService;

    public HomeController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/")
    String home(Model model) {
        Set<AnnouncementDto> announcementDtoSet = announcementService.getHighlightedAnnouncements();

        model.addAttribute("properties", announcementDtoSet);

        return "index";
    }
}
