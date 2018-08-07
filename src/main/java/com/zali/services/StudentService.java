package com.zali.services;


import com.zali.domain.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface StudentService {
    public List<Student>  getAllStudents();
    public Student getStudentByStudentId(long id);
    public void saveOrUpdate(Student student);
    public void deleteStudent(long studentId);

}
