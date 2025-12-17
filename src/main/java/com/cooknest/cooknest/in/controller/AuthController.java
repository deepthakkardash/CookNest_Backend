package com.cooknest.cooknest.in.controller;


import com.cooknest.cooknest.in.ApiResponse;
import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.entity.User;
import com.cooknest.cooknest.in.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
    public ApiResponse<User> AddUser(@RequestBody UserRequest userRequest)
    {
        log.info("Comes in controller");
        return userService.addUser(userRequest);
    }

}
