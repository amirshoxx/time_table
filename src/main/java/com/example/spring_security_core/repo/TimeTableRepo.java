package com.example.spring_security_core.repo;

import com.example.spring_security_core.entity.TimeTable;
import com.example.spring_security_core.entity.TimeTableProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeTableRepo extends JpaRepository<TimeTable,Long> {
   @Query(value = "select  tt.id as id , tt.price as price , tt.title as title , u.full_name as fullName, tt.end_data as endData , tt.mentor_id as mentorId , tt.group_id as groupId from time_table tt inner join public.groups g on tt.group_id = g.id inner join users u on tt.mentor_id = u.id where tt.group_id=:groupId",nativeQuery = true)
    List<TimeTableProjection> getMyTimeTable(Long groupId);
}
