package com.example.spring_security_core.dto;

public record TimeTableStudentDto(
        boolean archive,
        Integer paid,
        Long studentId,
        Long timeId
) {
}
