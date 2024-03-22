package com.example.spring_security_core.Controller;

import com.example.spring_security_core.dto.GroupDto;
import com.example.spring_security_core.dto.TimeTableDto;
import com.example.spring_security_core.entity.TimeTable;
import com.example.spring_security_core.servise.TimeTableServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/timeTable")
@RestController
public class TimeTableController {
    @Autowired
    TimeTableServise timeTableServise;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?> getTimeTables(){
        return ResponseEntity.ok(timeTableServise.getAllTimeTable());
    }
    @GetMapping("/byId")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?> getTimeTablesById(@RequestParam Long groupId){
        return ResponseEntity.ok(timeTableServise.getAllByGroupId(groupId));
    }
    @PostMapping("/post")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?>postTimeTable(@RequestBody TimeTableDto dto){
        return ResponseEntity.ok(timeTableServise.postTimeTable(dto));
    }

}
