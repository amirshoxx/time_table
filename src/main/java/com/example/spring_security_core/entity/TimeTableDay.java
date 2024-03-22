package com.example.spring_security_core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "timeTableDay")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeTableDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean absent;
    private boolean archive;
    private String description;
    private Integer mark;

    @ManyToOne
    private TimeTableStudent timeTableStudent;

    public TimeTableDay(boolean absent, boolean archive, String description, Integer mark, TimeTableStudent timeTableStudent) {
        this.absent = absent;
        this.archive = archive;
        this.description = description;
        this.mark = mark;
        this.timeTableStudent = timeTableStudent;
    }
}
