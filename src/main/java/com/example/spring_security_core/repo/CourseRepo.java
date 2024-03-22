package com.example.spring_security_core.repo;

import com.example.spring_security_core.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
