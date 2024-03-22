package com.example.spring_security_core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Days> dayType;


    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime endTime;

    private Integer price;
    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime startedTime;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Rome rome;

    public Groups(String name, List<Days> dayType, Integer price, Course course, Rome rome) {
        this.name = name;
        this.dayType = dayType;
        this.price = price;
        this.course = course;
        this.rome = rome;
    }
}
