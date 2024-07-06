package com.lbt.identify.service;


import com.lbt.identify.dto.request.author.RoleRequest;
import com.lbt.identify.dto.response.author.RoleResponse;
import com.lbt.identify.entity.PermissionEntity;
import com.lbt.identify.entity.RoleEntity;
import com.lbt.identify.mapper.RoleMapper;
import com.lbt.identify.repository.PermissionRepository;
import com.lbt.identify.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class RoleService {
    @Autowired
    RoleRepository repository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleMapper mapper;

    public RoleResponse create(RoleRequest request) {
        RoleEntity role = mapper.toEntity(request);

        List<PermissionEntity> permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        return mapper.toResponse(repository.save(role));
    }

    public List<RoleResponse> getAllRoles() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public void delete(String name) {
        repository.deleteById(name);
    }
}
