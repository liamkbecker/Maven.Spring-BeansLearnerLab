package com.example.demo.config;

import com.example.demo.general.Classroom;
import com.example.demo.general.Students;
import org.springframework.context.annotation.Bean;

public class StudentConfig {

    @Bean(name = "students")
    public Students currentStudents(){
        //return Classroom.getStudents();
    }

}
