package com.lbt.identify.config;

import com.lbt.identify.entity.RoleEntity;
import com.lbt.identify.entity.UserEntity;
import com.lbt.identify.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AppInit {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository repository) {
        return args -> {
            if (repository.findByUsername("admin").isEmpty()) {
                Set<RoleEntity> roles = new HashSet<>();
                UserEntity user = UserEntity.builder()
                        .firstname("ADMIN")
                        .lastname("ADMIN")
                        .username("admin")
                        .password(passwordEncoder.encode("password@123"))
//                        .roles(roles)
                        .build();

                repository.save(user);
                log.info("create admin user");
            }
        };
    }
}
