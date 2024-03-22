package com.example.spring_security_core.servise;

import com.example.spring_security_core.dto.TimeTableDto;
import com.example.spring_security_core.entity.TimeTable;
import com.example.spring_security_core.entity.TimeTableProjection;

import java.util.List;

public interface TimeTableServise {
    List<TimeTable>getAllTimeTable();

    TimeTable postTimeTable(TimeTableDto dto);
    List<TimeTableProjection> getAllByGroupId(Long groupId);
}
