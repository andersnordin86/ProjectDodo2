package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalendarController {

    @Autowired
    private CalendarRepository calendarRepository;

    @PostMapping ("/createevent")
    public String createevent ( @RequestParam String start,
                                @RequestParam String title,
                                @RequestParam String description) {
        calendarRepository.newEvent(start, title, description);
        return "redirect:home";

    }




}
