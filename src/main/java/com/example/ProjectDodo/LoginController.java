package com.example.ProjectDodo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


    @GetMapping("/index")
    public String getindex() {
        return "index";
    }
/*
    @PostMapping("/login")
    public String postForm(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpServletRequest request) {
        Members member = loginRepository.getUser(username, password);
        if (member == null) {
            return "login";
        } else if (username.equals(member.getUsername()) && password.equals(member.getPassword())) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", true);
            return "redirect:welcome";
        }
        return "login";
    }
*/
    @GetMapping("/home")
    public String secret(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("loggedIn") != null)
            return "home";
        else
            return "redirect:login";
    }
}
