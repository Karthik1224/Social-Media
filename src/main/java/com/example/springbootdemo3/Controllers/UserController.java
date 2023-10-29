package com.example.springbootdemo3.Controllers;


import com.example.springbootdemo3.Models.User;
import com.example.springbootdemo3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping("/NoOfNotifications")
    public Integer NoOfNotifications()
    {
         return userService.NoOfNotifications();
    }
}
