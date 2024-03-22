package com.example.spring_security_core.loaders;

import com.example.spring_security_core.entity.*;
import com.example.spring_security_core.repo.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class Loader implements CommandLineRunner {
    private final RoleRepo repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        List<Role> all = repo.findAll();
        if (all.isEmpty()) {
            List<Role>   roles = repo.saveAll(List.of(
                     Role.builder()
                             .name("ROLE_ADMIN").build()
                    ,
                    Role.builder()
                            .name("ROLE_SUPER_ADMIN").build()
                    ,
                    Role.builder()
                            .name("ROLE_USER").build()
            ));
        }
    }
}
