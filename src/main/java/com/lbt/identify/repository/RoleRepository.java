package com.lbt.identify.repository;

import com.lbt.identify.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    boolean existsByName(String name);
}
