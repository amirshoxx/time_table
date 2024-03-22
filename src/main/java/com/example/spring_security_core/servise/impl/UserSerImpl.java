package com.example.spring_security_core.servise.impl;

import com.example.spring_security_core.dto.LoginDto;
import com.example.spring_security_core.dto.RegisterDto;
import com.example.spring_security_core.entity.Role;
import com.example.spring_security_core.entity.User;
import com.example.spring_security_core.entity.UserProject;
import com.example.spring_security_core.repo.RoleRepo;
import com.example.spring_security_core.repo.UserRepo;
import com.example.spring_security_core.security.servise.JwtServise;
import com.example.spring_security_core.servise.UserServise;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserSerImpl implements UserServise {
    private final UserRepo userRepo;
    private final RoleRepo role_repo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtServise jwtServise;

    @Override
    public Optional<User> register(RegisterDto dto) {
        Optional<Role> roleUser = role_repo.findByName("ROLE_USER");
        if (roleUser.isPresent()){
            User user=new User();
            user.setFullName(dto.fullName());
            user.setEmail(dto.email());
            user.setAge(dto.age());
            user.setPassword(passwordEncoder.encode(dto.password()));
            user.setRoles(List.of(roleUser.get()));
            user.setTrue(true);
            User save = userRepo.save(user);
            return Optional.of(save);
        }else {
            Role role = new Role("ROLE_USER");
            role_repo.save(role);
            Optional<Role> roleUser1 = role_repo.findByName("ROLE_USER");
            User user=new User();
            user.setFullName(dto.fullName());
            user.setEmail(dto.email());
            user.setAge(dto.age());
            user.setPassword(passwordEncoder.encode(dto.password()));
            user.setRoles(List.of(roleUser1.get()));
            user.setTrue(true);
            User save = userRepo.save(user);
            return Optional.of(save);
        }
    }

    @Override
    public Map<String, String> login(LoginDto dto) {
        Optional<User> user = userRepo.findByEmail(dto.username());
          if(user.isPresent() && user.get().isTrue()){
              Long id=user.get().getId();
              authenticationManager.authenticate(
                      new UsernamePasswordAuthenticationToken(
                              dto.username(),
                              dto.password()
                      )
              );
              String jwt = jwtServise.generateJwt(id.toString());
              String refreshJwt = jwtServise.generateRefreshJwt(id.toString());
//              User byId = user_repo.findById(id).orElseThrow();
              Map<String,String> token =Map.of("access_token", jwt,"refresh_token",refreshJwt);
              return  token;
          }else return null;

    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public String refreshToken(String token) {
        Claims payload = jwtServise.extractJwt(token).getPayload();
        String id =payload.getSubject();
        String newJwt = jwtServise.generateJwt(id);
        return newJwt;
    }

    @Override
    public List<UserProject> allUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public void patchUser(Long id) {
        userRepo.updateUserIsTrue(id);
    }

    @Override
    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }


}
