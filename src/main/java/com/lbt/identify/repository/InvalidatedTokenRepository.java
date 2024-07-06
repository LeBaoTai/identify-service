package com.lbt.identify.repository;

import com.lbt.identify.entity.InvalidatedTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedTokenEntity, String> {
}
