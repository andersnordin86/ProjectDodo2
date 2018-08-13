package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private MembersRepository membersRepository;



    @GetMapping("/login")
    public ModelAndView secret(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        List<Members> members = membersRepository.getLoggdeInMembers();
        if (session.getAttribute("loggedIn") != null) {

            return new ModelAndView("redirect:home").addObject("members",members);

        } else {

            return new ModelAndView("login");
        }
    }
    @PostMapping("/login")
    public String postForm(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpServletRequest request) {
        boolean member = membersRepository.getMember(username, password);
        if (member) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", true);

            return "redirect:home";

        } else {
            return "login";
        }

    }



}
