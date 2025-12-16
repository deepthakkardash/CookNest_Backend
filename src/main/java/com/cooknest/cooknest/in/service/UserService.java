package com.cooknest.cooknest.in.service;


import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.entity.User;
import com.cooknest.cooknest.in.mapper.UserMapper;
import com.cooknest.cooknest.in.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    public User addUser(UserRequest userRequest)
    {
        User user=userMapper.toUser(userRequest);
        userRepository.save(user);
        return user;
    }

}
