package com.example.spring_security_core.dto;

import com.example.spring_security_core.entity.Role;

import java.util.ArrayList;
import java.util.List;

public record LoginDto(String username, String password) {
}
