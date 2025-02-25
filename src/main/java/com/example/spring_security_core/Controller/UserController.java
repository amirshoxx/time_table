package com.example.spring_security_core.Controller;

import com.example.spring_security_core.dto.LoginDto;
import com.example.spring_security_core.dto.RegisterDto;
import com.example.spring_security_core.entity.User;
import com.example.spring_security_core.repo.UserRepo;
import com.example.spring_security_core.servise.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserServise service;

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto dto){
        Optional<User> register = service.register(dto);
        register.orElseThrow();
        return ResponseEntity.status(200).body("Registered user - "+register.get());
    }

    @PostMapping("/loginA")
    public HttpEntity<?> login(@RequestBody LoginDto dto){
        return ResponseEntity.status(200).body(service.login(dto));
    }
    @PostMapping("/refresh")
    public HttpEntity<?>refresh(@RequestHeader String Authorization){
      return ResponseEntity.ok(service.refreshToken(Authorization));
    }

    @GetMapping("/settings")
    public HttpEntity<?>settings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?>getAllUser(){
        return ResponseEntity.ok(service.allUsers());
    }

    @PatchMapping("/change")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  HttpEntity<?>patch(@RequestParam Long id){
        try {
            service.patchUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/deletes")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity<?>deleteUser(@RequestParam long id ){
      service.deleteUserById(id);
      return ResponseEntity.ok("success");
    }

}
    