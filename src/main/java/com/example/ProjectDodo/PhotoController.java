package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhotoController {
    @Autowired
    private photoRepository photoRepository;



    @PostMapping("/addnewphoto")

    public String addnewphoto (   @RequestParam String url,
                                  @RequestParam String title){
        photoRepository.addNewPhoto(url,title);
        return "redirect:home";
    }
}
