package com.example.spring_security_core.repo;

import com.example.spring_security_core.entity.TimeTableStudent;
import com.example.spring_security_core.entity.TimeTableStudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeTableStudentRepo extends JpaRepository<TimeTableStudent,Long> {
    @Query(value = "select  ts.id as id , ts.archive as archive, ts.paid as paid , u.full_name as FullName from time_table_student ts inner join users u on u.id = ts.student_id inner join time_table t on ts.time_id = t.id where t.id=:id",nativeQuery = true)
    List<TimeTableStudentProjection> getMyTimeTableStudent(Long id);
}
