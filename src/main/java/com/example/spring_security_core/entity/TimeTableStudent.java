package com.example.spring_security_core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "timeTableStudent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeTableStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean archive;
    private Integer paid;

    @ManyToOne(fetch = FetchType.EAGER)
    private User student;

    @ManyToOne(fetch = FetchType.EAGER)
    private TimeTable time;

    public TimeTableStudent(boolean archive, Integer paid, User student, TimeTable time) {
        this.archive = archive;
        this.paid = paid;
        this.student = student;
        this.time = time;
    }
}
