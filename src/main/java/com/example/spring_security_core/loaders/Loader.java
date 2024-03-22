package com.example.spring_security_core.loaders;

import com.example.spring_security_core.entity.*;
import com.example.spring_security_core.repo.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class Loader implements CommandLineRunner {
    private final RoleRepo repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;
    @Autowired
    DayRepo dayRepo;
    @Autowired
    GroupRepo groupRepo;
    @Autowired
    TimeTableRepo timeTableRepo;
    @Autowired
    TimeTableStudentRepo timeTableStudentRepo;
    @Autowired
    TimeTableDayRepo timeTableDayRepo;
    @Autowired
    RomeRepo romeRepo;
    @Autowired
    CourseRepo courseRepo;


    @Override
    public void run(String... args) throws Exception {
        List<Role> all = repo.findAll();

        if (all.isEmpty()) {
            List<Role>   roles = repo.saveAll(List.of(
                     Role.builder()
                             .name("ROLE_ADMIN").build()
                    ,
                    Role.builder()
                            .name("ROLE_SUPER_ADMIN").build()
                    ,
                    Role.builder()
                            .name("ROLE_USER").build()
            ));
            User user = new User( "abdugafforov ozodbek","admin", passwordEncoder.encode("123"), 12,roles, true);
              userRepo.save(user);
              dayRepo.saveAll(List.of(
                    Days.builder()
                            .day("toq")
                            .build()
                    ,
                    Days.builder()
                            .day("juft")
                            .build()


            ));
            Rome rome = Rome.builder()
                    .name("1-xona")
                    .build();
              romeRepo.save(rome);

            Course course = Course.builder()

                    .name("full_stack")
                    .build();
           courseRepo.save(course);

        }


    }
}
