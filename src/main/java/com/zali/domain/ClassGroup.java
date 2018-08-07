package com.zali.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ClassGroup
{

    @Id
    private String classGroupCode;
    private int year;

    public void setClassGroupCode(String classGroupCode) {
        this.classGroupCode = classGroupCode;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static void setClassGroup(ClassGroup classGroup) {
        ClassGroup.classGroup = classGroup;
    }



    public String getClassGroupCode() {
        return classGroupCode;
    }

    public int getYear() {
        return year;
    }

    private static ClassGroup classGroup = null;

    private ClassGroup() {
    }

   public static ClassGroup getInstance()
   {
       if(classGroup == null)
       {
           classGroup = new ClassGroup();
       }
       return classGroup;
   }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        ClassGroup classGroup = (ClassGroup) obj;

        return classGroupCode.equals(classGroup.classGroupCode);
    }

    @Override
    public String toString()
    {
        return  "Student Number:\t\t" + this.getClassGroupCode() + "\n"
                +"Surname:      \t\t" + this.getYear() + "\n";

    }

    @Override
    public int hashCode() {return classGroupCode.hashCode();}

}
