package com.example.demo.general;

import java.util.stream.StreamSupport;

public class Instructor extends Person implements Teacher {

    public Instructor(long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        double actualTime = numberOfHours / StreamSupport.stream(learners.spliterator(), false).count();
        for (Learner i : learners) {
            i.learn(numberOfHours);
        }
    }

}
