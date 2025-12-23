package com.cooknest.cooknest.in.service;


import com.cooknest.cooknest.in.ApiResponse;
import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.entity.User;
import com.cooknest.cooknest.in.exception.InvalidCredentialsException;
import com.cooknest.cooknest.in.exception.UserNotFoundException;
import com.cooknest.cooknest.in.mapper.UserMapper;
import com.cooknest.cooknest.in.repository.UserRepository;
import com.cooknest.cooknest.in.security.JwtUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {


    private final UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public ApiResponse<User> addUser(UserRequest userRequest)
    {

        System.out.println(userRequest);
        User user=userMapper.toUser(userRequest);

        userRepository.save(user);

        return ApiResponse.success("Successfully Added",user);
    }


    public ResponseEntity<ApiResponse<String>> LoginUser(String username, String password, HttpServletResponse response) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

         if(user.getPassword().equals(password)) {
             String Token = jwtUtil.GenerateToken(username);

             ResponseCookie jwtCookie = ResponseCookie.from("Authorization", Token)
                     .httpOnly(true)
                     .secure(false)          // set true in HTTPS
                     .path("/")
                     .maxAge(5 * 60 * 60)    // 5 hours
                     .sameSite("None")        // or "None" if frontend on different domain
                     .build();


             response.addHeader("Set-Cookie", jwtCookie.toString());

             ApiResponse<String> res = new ApiResponse<>().success("Logged Successfully!!", Token);
             return ResponseEntity.ok(res);
         }
        throw new InvalidCredentialsException("Invalid Credentials");
    }
}
