package com.lbt.identify.service;

import com.lbt.identify.dto.request.author.PermissionRequest;
import com.lbt.identify.dto.response.author.PermissionResponse;
import com.lbt.identify.entity.PermissionEntity;
import com.lbt.identify.enums.ErrorCode;
import com.lbt.identify.excep.AppException;
import com.lbt.identify.mapper.PermissionMapper;
import com.lbt.identify.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {

    @Autowired
    PermissionRepository repository;

    @Autowired
    PermissionMapper mapper;

    public PermissionResponse create(PermissionRequest request) {
        if(repository.existsByName(request.getName())) {
            throw new AppException(ErrorCode.PERMISSION_ALREADY_EXISTED);
        }

        PermissionEntity permission = mapper.toEntity(request);
        return mapper.toResponse(repository.save(permission));
    }

    public List<PermissionResponse> getAllPermissions() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public void delete(String name) {
        repository.deleteById(name);
    }
}
