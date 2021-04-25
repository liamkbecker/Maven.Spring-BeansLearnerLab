package com.example.demo.general;

import java.util.Iterator;
import java.util.List;

public class Instructors extends People<Instructor>{

    public Instructors(List<Instructor> personList) {
        super(personList);
    }

    @Override
    public Iterator<Instructor> iterator() {
        return null;
    }

}
