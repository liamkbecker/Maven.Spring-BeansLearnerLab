package com.example.demo.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {

    private Students students;
    private Instructors instructors;

    @Autowired
    public Alumni(Students students, Instructors instructors){
        this.students = students;
        this.instructors = instructors;
    }

    @PostConstruct
    public void executeBootcamp(){
        this.instructors.findById(1002).lecture(this.students, 1200);
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Instructors getInstructors() {
        return instructors;
    }

    public void setInstructors(Instructors instructors) {
        this.instructors = instructors;
    }
}
