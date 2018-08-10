package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;


@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;


    @PostMapping("/createstory")

    public String createstory (   @RequestParam String headline,
                                  @RequestParam String storytext){
                   newsRepository.addNews(headline,storytext);
                   return "redirect:home";
    }
}
