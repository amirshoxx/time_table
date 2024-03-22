package com.example.spring_security_core.servise.impl;

import com.example.spring_security_core.dto.GroupDto;
import com.example.spring_security_core.entity.*;
import com.example.spring_security_core.repo.CourseRepo;
import com.example.spring_security_core.repo.DayRepo;
import com.example.spring_security_core.repo.GroupRepo;
import com.example.spring_security_core.repo.RomeRepo;
import com.example.spring_security_core.servise.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class GroupImpl implements GroupService {
    @Autowired
    GroupRepo repo;
    @Autowired
    DayRepo dayRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    RomeRepo romeRepo;

    @Override
    public Groups postGroup(GroupDto dto  ) {
        Optional<Days> days = dayRepo.findByDay("toq");
        Course byId = courseRepo.findById(1L).orElseThrow();
        Rome rome = romeRepo.findById(1L).orElseThrow();

        if (days.isPresent()){
            Groups groups = Groups.builder()
                    .name(dto.name())
                    .dayType(List.of(days.get()))
                    .price(dto.price())
                    .course(byId)
                    .rome(rome)
                    .build();
            return repo.save(groups);
        }else return null;
    }

    @Override
    public List<Groups> getAllGroups() {
        return repo.findAll();
    }
}
