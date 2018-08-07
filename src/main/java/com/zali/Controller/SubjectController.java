package com.zali.Controller;

import com.zali.domain.Subject;
import com.zali.factories.SubjectFactory;
import com.zali.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/Subject")
public class SubjectController
{
    @Autowired
    SubjectService subjectService;

    @GetMapping(value="/list")
    public @ResponseBody
    List<Subject> list() {
        List<Subject> subjectList = subjectService.getAllSubjects();
        return subjectList;
    }

    @GetMapping(path="/add/")
    public @ResponseBody
    String addSubject(@RequestParam String subjectCode, @RequestParam String subjectName) {
        Subject subject =  SubjectFactory.getSubject();
        subject.setSubjectCode(subjectCode);
        subject.setSubjectName(subjectName);
        subjectService.saveOrUpdate(subject);

        return "Saved";
    }

    @GetMapping(path="/update/{subjectCode}")
    public @ResponseBody
    String UpdateSubject(@PathVariable("subjectCode") String subjectCode, @RequestParam String subjectName) {

        Subject sub = subjectService.getSubjectBySubjectCode(subjectCode.hashCode());

        Subject subject = SubjectFactory.getSubject();
        subject.setSubjectCode(sub.getSubjectCode());
        subject.setSubjectCode(subjectCode);
        subject.setSubjectName(subjectName);


        //subjectService.deleteSubject(stud.getSubjectId());
        subjectService.saveOrUpdate(subject);

        return "Updated";
    }

    @GetMapping(value="/read/{subjectCode}")
    public @ResponseBody
    String read(@PathVariable String subjectCode) {
        Subject stud =subjectService.getSubjectBySubjectCode(subjectCode.hashCode());
        return stud.toString();
    }

    @GetMapping(path="/delete/{subjectCode}")
    public @ResponseBody
    String delete(@PathVariable String subjectCode) {
        subjectService.deleteSubject(subjectCode.hashCode());
        return "Deleted";
    }
}
