package com.zali.services.Impl;

import com.zali.domain.Subject;
import com.zali.repositories.SubjectRepository;
import com.zali.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectBySubjectCode(long subjectCode) {

        return  subjectRepository.findById(subjectCode).get();
    }

    @Override
    public void saveOrUpdate(Subject student) {
        subjectRepository.save(student);

    }

    @Override
    public void deleteSubject(long SubjectCode) {
        subjectRepository.deleteById(SubjectCode);

    }
}
