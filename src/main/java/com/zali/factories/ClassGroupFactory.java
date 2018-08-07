package com.zali.factories;

import com.zali.domain.ClassGroup;

public class ClassGroupFactory {

    public static ClassGroup getClassGroup() {

        return ClassGroup.getInstance();
    }
}
