package com.zali.services.Impl;

import com.zali.domain.Lecturer;
import com.zali.factories.LecturerFactory;
import com.zali.repositories.LecturerRepository;
import com.zali.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@Transactional
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> getAllLecturers() {
        return (List<Lecturer>) lecturerRepository.findAll();
    }

    @Override
    public Lecturer getLecturerByLecturerId(long id) {

        return  lecturerRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Lecturer student) {
        lecturerRepository.save(student);

    }

    @Override
    public void deleteLecturer(long studentId) {
        lecturerRepository.deleteById(studentId);

    }
}
