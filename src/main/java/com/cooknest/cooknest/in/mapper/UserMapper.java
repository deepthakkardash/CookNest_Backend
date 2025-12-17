package com.cooknest.cooknest.in.mapper;


import com.cooknest.cooknest.in.dto.UserRequest;
import com.cooknest.cooknest.in.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserRequest toUserRequestDto(User user);
    User toUser(UserRequest userRequest);
    //UserResponse toUserResponse(User user);
}
