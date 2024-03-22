package com.example.spring_security_core.repo;

import com.example.spring_security_core.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Groups,Long> {
}
