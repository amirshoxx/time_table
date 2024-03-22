package com.example.spring_security_core.servise;

import com.example.spring_security_core.dto.LoginDto;
import com.example.spring_security_core.dto.RegisterDto;
import com.example.spring_security_core.entity.User;
import com.example.spring_security_core.entity.UserProject;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserServise {
    Optional<User> register(RegisterDto dto);
    Map<String, String> login(LoginDto dto);
    Optional<User> findUserById(Long id);
    String refreshToken(String jwt);

    List<UserProject> allUsers();
    void patchUser(Long id);

    void deleteUserById(long id);
}
