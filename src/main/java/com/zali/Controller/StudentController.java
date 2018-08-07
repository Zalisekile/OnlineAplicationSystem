package com.zali.Controller;

import com.zali.domain.Student;
import com.zali.factories.StudentFactory;
import com.zali.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/Student")
public class StudentController
{

    @Autowired
    StudentService studentService;

    @GetMapping(value="/list")
    public @ResponseBody
    List<Student> list() {
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @GetMapping(path="/add/")
    public @ResponseBody
    String addStudent(@RequestParam int studentId, @RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String course, @RequestParam String phoneNumber, @RequestParam String password, @RequestParam Boolean verified) {
        Student student =  StudentFactory.getStudent();
        student.setStudentId(studentId);
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        student.setCourse(course);
        student.setPhoneNumber(phoneNumber);
        student.setPassword(password);
        student.setVerified(verified);
        studentService.saveOrUpdate(student);

        return "Saved";
    }

    @GetMapping(path="/update/{studentId}")
    public @ResponseBody
    String UpdateStudent(@PathVariable("studentId") int studentId,@RequestParam String name,@RequestParam String surname,@RequestParam String email,@RequestParam String course,@RequestParam String phoneNumber,@RequestParam String password,@RequestParam Boolean verified) {

        Student stud = studentService.getStudentByStudentId(studentId);

        Student student = StudentFactory.getStudent();
        student.setStudentId(stud.getStudentId());
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        student.setCourse(course);
        student.setPassword(password);
        student.setVerified(verified);

        //studentService.deleteStudent(stud.getStudentId());
        studentService.saveOrUpdate(student);

        return "Updated";
    }

    @GetMapping(value="/read/{studentId}")
    public @ResponseBody
    String read(@PathVariable int studentId) {
        Student stud =studentService.getStudentByStudentId(studentId);
        return stud.toString();
    }

    @GetMapping(path="/delete/{studentId}")
    public @ResponseBody
    String delete(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return "Deleted";
    }

}
