package com.example.spring_security_core.repo;

import com.example.spring_security_core.entity.Days;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepo extends JpaRepository<Days,Long> {

    Optional<Days> findByDay(String day);
}
