package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MembersController {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private MembersRepository membersRepository;

    @PostMapping("/home")
    public String registerMember (@RequestParam String username,
                                  @RequestParam String firstname,
                                  @RequestParam String lastname,
                                  @RequestParam String password,
                                  @RequestParam String email)  {

        Boolean checkMember = loginRepository.checkUsernameAndEmail(username, email);
        if (!checkMember) {
            membersRepository.addMember(username, firstname, lastname, password, email);
            return "home";
        }
        else
            return "/home";
    }
}
