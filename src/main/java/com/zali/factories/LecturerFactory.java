package com.zali.factories;

import com.zali.domain.Lecturer;


public class LecturerFactory {

    public static Lecturer getLecturer() {

        return Lecturer.getInstance();
    }
}
