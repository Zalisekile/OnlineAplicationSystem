package com.zali.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Subject
{
    @Id
    private String subjectCode;
    private String subjectName;
    private static Subject subject = null;

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }


    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    private Subject() {
    }

    public static Subject getInstance()
    {
        if(subject == null)
        {
            subject = new Subject();
        }
        return subject;
    }


    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Subject subject = (Subject) obj;

        return subjectCode.equals(subject.subjectCode);
    }

    @Override
    public String toString()
    {
        return    "Subject Code:\t\t" + this.getSubjectCode() + "\n"
                + "Subject Name:\t\t" + this.getSubjectName() + "\n";

    }

    @Override
    public int hashCode() {return subjectCode.hashCode();}

}
