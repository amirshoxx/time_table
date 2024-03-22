package com.example.spring_security_core.servise.impl;

import com.example.spring_security_core.dto.TimeTableDto;
import com.example.spring_security_core.entity.Groups;
import com.example.spring_security_core.entity.TimeTable;
import com.example.spring_security_core.entity.TimeTableProjection;
import com.example.spring_security_core.entity.User;
import com.example.spring_security_core.repo.GroupRepo;
import com.example.spring_security_core.repo.TimeTableRepo;
import com.example.spring_security_core.repo.UserRepo;
import com.example.spring_security_core.servise.TimeTableServise;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
@RequiredArgsConstructor

public class TimeTableImpl implements TimeTableServise {
  @Autowired
    TimeTableRepo timeTableRepo;
  @Autowired
  UserRepo userRepo;
  @Autowired
  GroupRepo groupRepo;


  @Override
    public List<TimeTable> getAllTimeTable() {
        return timeTableRepo.findAll();
    }

  @Override
  public TimeTable postTimeTable(TimeTableDto dto) {

    User user = userRepo.findById(dto.mentorId()).orElseThrow();
    Groups groups = groupRepo.findById(dto.groupId()).orElseThrow();
      TimeTable timeTable = TimeTable.builder()
              .price(dto.price())
              .title(dto.title())
              .mentor(user)
              .group(groups)
              .build();
      return timeTableRepo.save(timeTable);
  }

  @Override
  public List<TimeTableProjection> getAllByGroupId(Long groupId) {
    return timeTableRepo.getMyTimeTable(groupId);
  }
}
