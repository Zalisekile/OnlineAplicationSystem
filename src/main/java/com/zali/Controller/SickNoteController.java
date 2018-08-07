package com.zali.Controller;

import com.zali.domain.SickNote;
import com.zali.factories.SickNoteFactory;
import com.zali.services.SickNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/SickNote")
public class SickNoteController
{
    @Autowired
    SickNoteService sickNoteService;

    @GetMapping(value="/list")
    public @ResponseBody
    List<SickNote> list() {
        List<SickNote> sickNoteList = sickNoteService.getAllSickNotes();
        return sickNoteList;
    }



    @GetMapping(path="/add/")
    public @ResponseBody
    String addSickNote(@RequestParam int sickNoteId,@RequestParam String subjectCode,@RequestParam int studentId,@RequestParam String illness,@RequestParam int daysOfAbsence,@RequestParam int lecturerId,@RequestParam boolean validated) {
        SickNote sickNote =  SickNoteFactory.getSickNote();
        sickNote.setSickNoteId(sickNoteId);
        sickNote.setSubjectCode(subjectCode);
        sickNote.setStudentId(studentId);
        sickNote.setIllness(illness);
        sickNote.setDaysOfAbsence(daysOfAbsence);
        sickNote.setLecturerId(lecturerId);
        sickNote.setValidated(validated);
        sickNoteService.saveOrUpdate(sickNote);

        return "Saved";
    }

    @GetMapping(path="/update/{sickNoteId}")
    public @ResponseBody
    String UpdateSickNote(@PathVariable("sickNoteId") int sickNoteId,@RequestParam String subjectCode,@RequestParam int studentId,@RequestParam String illness,@RequestParam int daysOfAbsence,@RequestParam int lecturerId,@RequestParam boolean validated) {

        SickNote sick = sickNoteService.getSickNoteBySickNoteId(sickNoteId);

        SickNote sickNote = SickNoteFactory.getSickNote();
        sickNote.setSickNoteId(sick.getSickNoteId());
        sickNote.setSubjectCode(subjectCode);
        sickNote.setStudentId(studentId);
        sickNote.setIllness(illness);
        sickNote.setDaysOfAbsence(daysOfAbsence);
        sickNote.setLecturerId(lecturerId);
        sickNote.setValidated(validated);

        sickNoteService.saveOrUpdate(sickNote);

        return "Updated";
    }

    @GetMapping(value="/read/{sickNoteId}")
    public @ResponseBody
    String read(@PathVariable int sickNoteId) {
        SickNote stud =sickNoteService.getSickNoteBySickNoteId(sickNoteId);
        return stud.toString();
    }

    @GetMapping(path="/delete/{sickNoteId}")
    public @ResponseBody
    String delete(@PathVariable int sickNoteId) {
        sickNoteService.deleteSickNote(sickNoteId);
        return "Deleted";
    }

}
