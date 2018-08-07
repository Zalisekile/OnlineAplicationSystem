package com.zali.Controller;


import com.zali.domain.Lecturer;
import com.zali.factories.LecturerFactory;
import com.zali.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/Lecturer")
public class LecturerController
{
    @Autowired
    LecturerService lecturerService;

    @GetMapping(value="/list")
    public @ResponseBody
    List<Lecturer> list() {
        List<Lecturer> lecturerList = lecturerService.getAllLecturers();
        return lecturerList;
    }

    @GetMapping(path="/add/")
    public @ResponseBody
    String addLecturer(@RequestParam int lecturerId, @RequestParam String name, @RequestParam String surname, @RequestParam String email) {
        Lecturer lecturer =  LecturerFactory.getLecturer();
        lecturer.setLecturerId(lecturerId);
        lecturer.setName(name);
        lecturer.setSurname(surname);
        lecturer.setEmail(email);

        lecturerService.saveOrUpdate(lecturer);

        return "Saved";
    }

    @GetMapping(path="/update/{lecturerId}")
    public @ResponseBody
    String UpdateLecturer(@PathVariable("lecturerId") int lecturerId,@RequestParam String name,@RequestParam String surname,@RequestParam String email) {

        Lecturer lect = lecturerService.getLecturerByLecturerId(lecturerId);

        Lecturer lecturer = LecturerFactory.getLecturer();
        lecturer.setLecturerId(lect.getLecturerId());
        lecturer.setName(name);
        lecturer.setSurname(surname);
        lecturer.setEmail(email);

        lecturerService.saveOrUpdate(lecturer);

        return "Updated";
    }

    @GetMapping(value="/read/{lecturerId}")
    public @ResponseBody
    String read(@PathVariable int lecturerId) {
        Lecturer stud =lecturerService.getLecturerByLecturerId(lecturerId);
        return stud.toString();
    }

    @GetMapping(path="/delete/{lecturerId}")
    public @ResponseBody
    String delete(@PathVariable int lecturerId) {
        lecturerService.deleteLecturer(lecturerId);
        return "Deleted";
    }
}
