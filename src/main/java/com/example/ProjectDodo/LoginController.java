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
    private LoginRepository loginRepository;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postForm(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpServletRequest request) {
        boolean member = loginRepository.getMember(username, password);
        if (member) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", true);
            return "redirect:home";

        } else {
            return "login";
        }

    }

    @GetMapping("/home")
    public String secret(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("loggedIn") != null)
            return "home";
        else
            return "redirect:login";
    }
    @PostMapping("/home")
    public String registerMember (@RequestParam String username,
                                @RequestParam String firstname,
                                @RequestParam String lastname,
                                @RequestParam String password,
                                 @RequestParam String email)  {

        Boolean checkMember = loginRepository.checkMember(username, email);
        if (!checkMember) {
            loginRepository.addMember(username, firstname, lastname, password, email);
            return "home";
        }
        else
        return "/home";
    }
}
