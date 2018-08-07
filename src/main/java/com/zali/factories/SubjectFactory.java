package com.zali.factories;

import com.zali.domain.Subject;


public class SubjectFactory {

    public static Subject getSubject() {

        return Subject.getInstance();
    }
}
