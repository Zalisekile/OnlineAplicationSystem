package com.zali.factories;

import com.zali.domain.Student;


public class StudentFactory {

    public static Student getStudent() {

        return Student.getInstance();
    }
}
