package com.example.demo.config;

import com.example.demo.general.Instructors;
import com.example.demo.general.Instructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;

@Configuration
public class InstructorConfig {

    @Bean
    public Instructors tcUsaInstructors(){

        Instructor person1 = new Instructor(2001, "Person 1");
        Instructor person2 = new Instructor(2002, "Person 2");

        ArrayList<Instructor> middleman = new ArrayList<Instructor>();
        middleman.add(person1);
        middleman.add(person2);

        Instructors instructors = new Instructors(middleman);
        return instructors;

    }

    @Bean
    public Instructors tcUkInstructors(){

        Instructor person3 = new Instructor(3001, "Person 3");
        Instructor person4 = new Instructor(3002, "Person 4");

        ArrayList<Instructor> middleman = new ArrayList<Instructor>();
        middleman.add(person3);
        middleman.add(person4);

        Instructors instructors = new Instructors(middleman);
        return instructors;

    }

    @Bean
    @Primary
    @Qualifier("instructors")
    public Instructors instructors(){

        Instructor kris = new Instructor(1001, "Kris");
        Instructor dolio = new Instructor(1002, "Dolio");

        ArrayList<Instructor> middleman = new ArrayList<Instructor>();
        middleman.add(kris);
        middleman.add(dolio);

        Instructors instructors = new Instructors(middleman);
        return instructors;

    }

}
