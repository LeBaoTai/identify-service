package com.lbt.identify.mapper;

import com.lbt.identify.dto.request.author.PermissionRequest;
import com.lbt.identify.dto.response.author.PermissionResponse;
import com.lbt.identify.entity.PermissionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionEntity toEntity(PermissionRequest request);
    PermissionResponse toResponse(PermissionEntity entity);
}
