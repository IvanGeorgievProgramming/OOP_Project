package com.example.springtest.mapper;

import com.example.springtest.resources.UserResource;
import com.example.springtest.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User fromUserResource(UserResource userResource);

    UserResource toUserResource(User user);

    List<UserResource> toUserResources(List<User> users);
}
