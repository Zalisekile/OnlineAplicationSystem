package com.zali.services;


import com.zali.domain.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAllSubjects();
    public Subject getSubjectBySubjectCode(long SubjectCode);
    public void saveOrUpdate(Subject subject);
    public void deleteSubject(long subjectCode);

}
