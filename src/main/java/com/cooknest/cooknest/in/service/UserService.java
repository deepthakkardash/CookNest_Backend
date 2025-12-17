package com.cooknest.cooknest.in.service;


import com.cooknest.cooknest.in.ApiResponse;
import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.entity.User;
import com.cooknest.cooknest.in.mapper.UserMapper;
import com.cooknest.cooknest.in.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;



     public ApiResponse<User> addUser(UserRequest userRequest)
    {

        if(validateSignInForm(userRequest))
        {

        }

        User user=userMapper.toUser(userRequest);

        userRepository.save(user);

        return ApiResponse.success("Successfully Added",user);
    }

    public boolean validateSignInForm(UserRequest userRequest)
    {
//        if(userRequest.getUsername())
        return true;
    }

}
