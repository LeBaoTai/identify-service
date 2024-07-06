package com.lbt.identify.mapper;

import com.lbt.identify.dto.request.user.UserCreationRequest;
import com.lbt.identify.dto.request.user.UserUpdateRequest;
import com.lbt.identify.dto.response.user.UserResponse;
import com.lbt.identify.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roles", ignore = true)
    void update(@MappingTarget UserEntity entity, UserUpdateRequest request);

    @Mapping(target = "roles", ignore = true)
    UserEntity toEntity(UserCreationRequest request);
    UserResponse toResponse(UserEntity userEntity);
}
