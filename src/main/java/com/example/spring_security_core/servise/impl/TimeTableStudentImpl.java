package com.example.spring_security_core.servise.impl;

import com.example.spring_security_core.dto.TimeTableStudentDto;
import com.example.spring_security_core.entity.TimeTable;
import com.example.spring_security_core.entity.TimeTableStudent;
import com.example.spring_security_core.entity.TimeTableStudentProjection;
import com.example.spring_security_core.entity.User;
import com.example.spring_security_core.repo.TimeTableRepo;
import com.example.spring_security_core.repo.TimeTableStudentRepo;
import com.example.spring_security_core.repo.UserRepo;
import com.example.spring_security_core.servise.TimeTableStudentServise;
import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
@Service
@RequiredArgsConstructor
public class TimeTableStudentImpl implements TimeTableStudentServise {
    @Autowired
    TimeTableStudentRepo timeTableStudentRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TimeTableRepo timeTableRepo;

    @Override
    public List<TimeTableStudentProjection> getTimeTable(Long id) {
        return timeTableStudentRepo.getMyTimeTableStudent(id);
    }

    @Override
    public TimeTableStudent postTimeTableStudent(TimeTableStudentDto dto) {
        User user = userRepo.findById(dto.studentId()).orElseThrow();
        TimeTable time = timeTableRepo.findById(dto.timeId()).orElseThrow();
        TimeTableStudent timeTableStudent = TimeTableStudent.builder()
                .archive(true)
                .paid(dto.paid())
                .student(user)
                .time(time)
                .build();
        return timeTableStudentRepo.save(timeTableStudent) ;
    }
}
