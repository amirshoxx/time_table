package com.example.spring_security_core.security;

import com.example.spring_security_core.entity.User;
import com.example.spring_security_core.repo.UserRepo;
import com.example.spring_security_core.security.filter.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class Security_config {
    private final UserRepo user_repo;
    private final Filter filter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/loginA").permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/refresh").permitAll()
                        .requestMatchers("/settings").permitAll()
                        .requestMatchers("/deletes").permitAll()
                        .requestMatchers("/user").permitAll()
                        .requestMatchers("/change").permitAll()
                        .requestMatchers("/groups","/groups/post").permitAll()
                        .requestMatchers("/timeTable","timeTable/byId","/timeTable/post").permitAll()
                        .requestMatchers("/timeStudent","/timeStudent/by","/timeStudent/post").permitAll()

                        .anyRequest().authenticated()
        ).addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
    @Bean
    public UserDetailsService inMemoryUsers(){
     return username -> {
         User user = user_repo.findByEmail(username).get();
         return new org.springframework.security.core.userdetails
                 .User(user.getUsername(),user.getPassword(), List.of());
     };
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
}
