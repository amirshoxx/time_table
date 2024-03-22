package com.example.spring_security_core.dto;

import com.example.spring_security_core.entity.Groups;
import com.example.spring_security_core.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

public record TimeTableDto(
        Integer price,
        String title,
        Long  mentorId,
        Long groupId
) {

    }
