package com.cooknest.cooknest.in.controller;


import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.entity.User;
import com.cooknest.cooknest.in.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cooknest")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/getmessage")
    public String GetMessage()
    {
        return "Hello From Deep";
    }


    @PostMapping("/registeruser")
    public User AddUser(@RequestBody UserRequest userRequest)
    {
        return userService.addUser(userRequest);
    }

}
