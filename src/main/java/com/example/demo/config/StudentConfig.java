package com.example.demo.config;

import com.example.demo.general.Classroom;
import com.example.demo.general.Student;
import com.example.demo.general.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class StudentConfig {

    @Bean(name = "students")
    @Qualifier("currentStudents")
    public Students currentStudents(){

        Student hazel = new Student(72, "Hazel");
        Student abiel = new Student(82, "Abe");
        Student monali = new Student(92, "Monali");
        Student alena = new Student(102, "Lena");

        ArrayList<Student> middleman = new ArrayList<Student>();
        middleman.add(hazel);
        middleman.add(abiel);
        middleman.add(monali);
        middleman.add(alena);

        Students students = new Students(middleman);
        return students;

    }

    @Bean
    @Qualifier("prevStudents")
    public Students previousStudents(){

        Student greg = new Student(12, "Greg");
        Student ryan = new Student(22, "Ryan");
        Student ashley = new Student(32, "Ashley");
        Student kelly = new Student(42, "Kelly");

        ArrayList<Student> middleman = new ArrayList<Student>();
        middleman.add(greg);
        middleman.add(kelly);
        middleman.add(ashley);
        middleman.add(ryan);

        Students prevStudents = new Students(middleman);
        return prevStudents;

    }

}
