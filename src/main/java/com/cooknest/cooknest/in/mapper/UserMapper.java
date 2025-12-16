package com.cooknest.cooknest.in.mapper;


import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequest toUserRequestDto(User user);

    User toUser(UserRequest userRequest);


}
