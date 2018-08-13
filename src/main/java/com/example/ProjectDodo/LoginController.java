package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private MembersRepository membersRepository;



    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    @PostMapping("/login")
    public String postForm(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpServletRequest request) {
        boolean member = membersRepository.getMember(username, password);
        if (member) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", true);
            session.setAttribute(session.getId(), );
            session.getId()
            return "redirect:home";

        } else {
            return "login";
        }

    }



}
