package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class pageController {

    @Autowired
    private CalendarRepository events;

    @Autowired
    private photoRepository pr;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private MembersRepository membersRepository;

    private List<Stories> allStories = new ArrayList<>();

    @GetMapping("/home")
    public ModelAndView secret(HttpServletRequest request) {
        System.out.println("fel");
        HttpSession session = request.getSession(true);
        List<Members> members = membersRepository.getAllMembers();
        if (session.getAttribute("loggedIn") != null) {
            System.out.println("fel2");
            return new ModelAndView("home").addObject("members",members);

        } else {
            System.out.println("fel3");
            return new ModelAndView("login");
        }
    }


    @GetMapping("/about")
    public String getAbout() {
        return "aboutus";
    }

    @GetMapping("/news")
    public ModelAndView getNews() {

        allStories = newsRepository.getStories();
        return new ModelAndView("news").addObject("allStories",allStories);
    }

    @GetMapping("/contactinformation")
    public String getContactinformation() {
        return "contactinformation";
    }

    @GetMapping("/calendar")
    public String getCalendar(Model model) {
        List <Calendar> allEvents = new ArrayList<>();
        allEvents = events.getEvents();
        model.addAttribute("allEvents",allEvents);
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

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

}
