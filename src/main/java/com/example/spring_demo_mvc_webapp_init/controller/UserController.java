package com.example.spring_demo_mvc_webapp_init.controller;

import com.example.spring_demo_mvc_webapp_init.model.User;
import com.example.spring_demo_mvc_webapp_init.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public String getListUsers(Model model){
        model.addAttribute("users",userService.getUsers());
        return "list_users";
    }
    @GetMapping("/add")
    public String addUserForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "add_user";
    }

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute("user") User user){
        System.out.println(user.toString());
        userService.addUser(user);
        return "redirect:/users";
    }

}
