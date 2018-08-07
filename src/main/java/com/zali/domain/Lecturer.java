package com.zali.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Lecturer
{
    @Id
    private int lecturerId;
    private String name;
    private String surname;
    private String email;
    private static Lecturer lecturer = null;

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
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

    public int getLecturerId() {
        return lecturerId;
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

    private Lecturer() {
    }

    public static Lecturer getInstance() {
        if(lecturer == null)
        {
            lecturer = new Lecturer();
        }
        return lecturer;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Lecturer lecturer = (Lecturer) obj;

        return lecturerId == lecturer.lecturerId;
    }

    @Override
    public String toString()
    {
        return    "Lecturer Id:\t\t" + this.getLecturerId() + "\n"
                + "Name:       \t\t" + this.getSurname() + "\n"
                + "Surname:    \t\t" + this.getSurname() + "\n"
                + "Email:      \t\t" + this.getEmail() + "\n";

    }

    @Override
    public int hashCode()
    {
        return lecturerId;
    }
}