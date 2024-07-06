package com.lbt.identify.mapper;

import com.lbt.identify.dto.request.author.RoleRequest;
import com.lbt.identify.dto.response.author.RoleResponse;
import com.lbt.identify.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    RoleEntity toEntity(RoleRequest request);

    RoleResponse toResponse(RoleEntity entity);
}
