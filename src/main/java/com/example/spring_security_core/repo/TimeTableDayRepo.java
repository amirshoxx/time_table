package com.example.spring_security_core.repo;

import com.example.spring_security_core.entity.TimeTableDay;
import com.example.spring_security_core.entity.TimeTableDayProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeTableDayRepo extends JpaRepository<TimeTableDay,Long> {
    List<TimeTableDayProjection> getMyTimeDay();
}
