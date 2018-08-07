package com.zali.services.Impl;

import com.zali.domain.Student;
import com.zali.repositories.StudentRepository;
import com.zali.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentByStudentId(long id) {

        return  studentRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);

    }
}
