package com.example.spring_security_core.Controller;


import com.example.spring_security_core.dto.GroupDto;
import com.example.spring_security_core.servise.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController

@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?> getAllGroup(){
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @PostMapping("/post")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?>postGroup(@RequestBody GroupDto dto){
        return ResponseEntity.ok(groupService.postGroup(dto));
    }


}
