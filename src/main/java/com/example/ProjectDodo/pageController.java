package com.example.ProjectDodo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {

    @GetMapping("/about")
    public String getAbout() {
        return "aboutus";
    }

    @GetMapping("/news")
    public String getNews() {
        return "news";
    }
    @GetMapping("/contactinformation")
    public String getContactinformation() {
        return "contactinformation";
    }
    @GetMapping("/calendar")
    public String getCalendar() {
        return "calendar";
    }
    @GetMapping("/pakaaa")
    public String getPakaaa() {
        return "pakaaa";
    }
    @GetMapping("/photos")
    public String getPhotos() {
        return "photos";
    }
    @GetMapping("/players")
    public String getPlayers() {
        return "players";
    }
}
