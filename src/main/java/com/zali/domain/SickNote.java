package com.zali.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SickNote
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sickNoteId;
    private String subjectCode;
    private int studentId;
    private String illness;
    private int daysOfAbsence;
    private int lecturerId;
    private boolean validated;

    public void setSickNoteId(Integer sickNoteId) {
        this.sickNoteId = sickNoteId;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setDaysOfAbsence(int daysOfAbsence) {
        this.daysOfAbsence = daysOfAbsence;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public static void setSickNote(SickNote sickNote) {
        SickNote.sickNote = sickNote;
    }



    public Integer getSickNoteId() {
        return sickNoteId;
    }

    public String getSubjectCode()
    {
        return subjectCode;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public String getIllness() {
        return illness;
    }

    public int getDaysOfAbsence() {
        return daysOfAbsence;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public boolean isValidated() {
        return validated;
    }

    private static SickNote sickNote = null;

    private SickNote() {
    }

    public static SickNote getInstance()
    {
        if(sickNote == null)
        {
            sickNote = new SickNote();
        }
        return sickNote;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        SickNote sickNote = (SickNote) obj;

        return sickNoteId == sickNote.sickNoteId;
    }

    @Override
    public String toString()
    {
        return    "SickNote ID:    \t\t" + this.getSickNoteId() + "\n"
                + "Subject Code:   \t\t" + this.getSubjectCode() + "\n"
                + "Student Number: \t\t" + this.getStudentId() + "\n"
                + "Illness:        \t\t" + this.getIllness() + "\n"
                + "Days Of Absence:\t\t" + this.getDaysOfAbsence() + "\n"
                + "LecturerId:     \t\t" + this.getLecturerId() + "\n"
                + "Approved:       \t\t" + isValidated();
    }

    @Override
    public int hashCode() {return sickNoteId;}


}
