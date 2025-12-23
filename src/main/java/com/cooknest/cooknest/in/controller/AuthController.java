package com.cooknest.cooknest.in.controller;


import com.cooknest.cooknest.in.ApiResponse;
import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.dto.UserRequestLogin;
import com.cooknest.cooknest.in.entity.User;
import com.cooknest.cooknest.in.security.CustomUserDetailsService;
import com.cooknest.cooknest.in.security.JwtUtil;
import com.cooknest.cooknest.in.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cooknest")
public class AuthController {

    @Autowired
    private UserService userService;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService  customUserDetailsService;



    @GetMapping("/getmessage")
    public String GetMessage()
    {
        return "Hello From Deep";
    }


    @PostMapping("/register")
    public ApiResponse<User> AddUser(@RequestBody UserRequest userRequest)
    {//@Valid Removed from parameter part
        log.info("Comes in controller");
        return userService.addUser(userRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody UserRequestLogin userRequestLogin, HttpServletResponse response){

//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestLogin.getUsername(),userRequestLogin.getPassword()));
//
//            String token=jwtUtil.GenerateToken(userRequestLogin.getUsername());
//
//            Cookie cookie=new Cookie("jwt",token);
//            cookie.setHttpOnly(true);
//            cookie.setSecure(false);
//            cookie.setPath("/");
//            cookie.setMaxAge(24*60*60);
//
//            response.addCookie(cookie);

//        return ResponseEntity.ok(new ApiResponse<String>().success("LoginSuccess",token));

        return userService.LoginUser(userRequestLogin.getUsername(),userRequestLogin.getPassword(),response);
    }
}
