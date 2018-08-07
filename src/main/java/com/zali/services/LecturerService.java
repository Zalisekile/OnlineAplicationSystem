package com.zali.services;

import com.zali.domain.Lecturer;

import java.util.List;

public interface LecturerService {
    public List<Lecturer> getAllLecturers();
    public Lecturer getLecturerByLecturerId(long id);
    public void saveOrUpdate(Lecturer lecturer);
    public void deleteLecturer(long lecturerId);
}
