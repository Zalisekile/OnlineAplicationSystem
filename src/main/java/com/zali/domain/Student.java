package com.zali.domain;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Student
{
    @Id
    private long studentId;
    private String name;
    private String surname;
    private String email;
    private String course;
    private String phoneNumber;
    private String password;
    private boolean verified;


    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public long getStudentId() {
        return studentId;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean isVerified() {
        return verified;
    }



    private static Student stud = null;

    private Student() {
    }

    public static Student getInstance() {
        if (stud == null) {
            stud = new Student();
        }
        return stud;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student student = (Student) obj;

        return studentId == student.studentId;
    }

    @Override
    public String toString()
    {
      return  "Student Number:  \t\t" + this.getStudentId() + "\n"
            + "Surname:         \t\t" + this.getSurname() + "\n"
            + "Email:           \t\t" + this.getEmail() + "\n"
            + "Course:          \t\t" + this.getCourse() + "\n"
            + "Password:        \t\t" + this.getPassword() + "\n"
            + "PhoneNumber:     \t\t" + this.getPhoneNumber() + "\n"
            + "Verified:        \t\t" + isVerified();
    }

    @Override
    public int hashCode() {
        return (int) studentId;
    }

}
