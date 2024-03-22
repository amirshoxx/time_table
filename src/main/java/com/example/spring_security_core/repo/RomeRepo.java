package com.example.spring_security_core.repo;

import com.example.spring_security_core.entity.Rome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RomeRepo extends JpaRepository<Rome,Long> {
}
