package com.example.spring_security_core.servise;

import com.example.spring_security_core.dto.TimeTableStudentDto;
import com.example.spring_security_core.entity.TimeTableStudent;
import com.example.spring_security_core.entity.TimeTableStudentProjection;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TimeTableStudentServise {
    List<TimeTableStudentProjection> getTimeTable(Long id);
    TimeTableStudent postTimeTableStudent(TimeTableStudentDto dto);
}
