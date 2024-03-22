package com.example.spring_security_core.servise;

import com.example.spring_security_core.dto.GroupDto;
import com.example.spring_security_core.entity.Groups;

import java.util.List;

public interface GroupService {

    Groups postGroup(GroupDto dto);
    List<Groups>getAllGroups();
}
