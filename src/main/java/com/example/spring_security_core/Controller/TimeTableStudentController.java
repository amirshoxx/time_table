package com.example.spring_security_core.Controller;

import com.example.spring_security_core.dto.TimeTableStudentDto;
import com.example.spring_security_core.servise.TimeTableStudentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/timeStudent")
@RestController
public class TimeTableStudentController {
    @Autowired
    TimeTableStudentServise timeTableStudentServise;

    @GetMapping("/by")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?> getTimeTableById(@RequestParam Long timeId){
        return ResponseEntity.ok(timeTableStudentServise.getTimeTable(timeId));
    }
    @PostMapping("/post")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?>postTime(@RequestBody TimeTableStudentDto dto){
        return ResponseEntity.ok(timeTableStudentServise.postTimeTableStudent(dto));
    }
}
