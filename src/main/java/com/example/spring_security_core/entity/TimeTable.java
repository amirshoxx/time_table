package com.example.spring_security_core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "timeTable")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime endData;
    private Integer price;
    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime statData;
    private String title;

    @ManyToOne
    private User mentor;

    @ManyToOne
    private Groups group;

    public TimeTable( Integer price, String title, User mentor, Groups group) {
        this.price = price;
        this.title = title;
        this.mentor = mentor;
        this.group = group;
    }
}
