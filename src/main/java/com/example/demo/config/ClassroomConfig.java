package com.example.demo.config;

import com.example.demo.general.Classroom;
import com.example.demo.general.Instructors;
import com.example.demo.general.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ClassroomConfig {

    @Bean
    @DependsOn({"instructors", "currentStudents"})
    public Classroom currentCohort(){
        return new Classroom(currentCohort().getStudents(), currentCohort().getInstructors());
    }

    @Bean
    @DependsOn({"instructors", "prevStudents"})
    public Classroom prevCohort(){
        return new Classroom(prevCohort().getStudents(), currentCohort().getInstructors());
    }

}
