package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class pageController {

    @Autowired
    private photoRepository pr;

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
    public ModelAndView getPhotos() {
        List<photos> photos = pr.getphotos();
        return new ModelAndView("photos").addObject("photos", photos);
    }
    @GetMapping("/players")
    public String getPlayers() {
        return "players";
    }
}
