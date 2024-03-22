package com.example.spring_security_core.dto;

import org.hibernate.annotations.NotFound;

public record TimeTableDayDto(
         boolean absent,
         boolean archive,
         String description,
         Integer mark,
         Long timeTableStudentId
) {
}
