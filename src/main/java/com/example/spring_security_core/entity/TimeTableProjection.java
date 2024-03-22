package com.example.spring_security_core.entity;

import java.util.Date;

public interface TimeTableProjection {
    Long getId();
    Integer getPrice();
    String getTitle();
    String getFullName();
    Date getEndData();
    Long  getMentorId();
    Long getGroupId();
}
