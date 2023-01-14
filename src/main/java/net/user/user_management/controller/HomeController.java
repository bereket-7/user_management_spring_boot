package net.user.user_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import net.user.user_management.model.User;
import net.user.user_management.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";

    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, HttpSession session) {
        boolean b = userService.checkEmail(user.getEmail());
        if (b) {
            session.setAttribute("msg", "user with this email already exists");
        } else {

            User userData = userService.createUser(user);
            if (userData != null) {
                System.out.println("Registered successfully");

            } else {
                System.out.println("some error in the server please try again");
            }
        }
        return "redirect:/register";

    }
}
