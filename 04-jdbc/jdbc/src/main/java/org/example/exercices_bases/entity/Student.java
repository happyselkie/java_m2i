package org.example.exercices_bases.entity;

import java.sql.Date;

public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private int classroom_num;
    private Date degree_date;

    public Student(String firstname, String lastname, int classroom_num, Date degree_date) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.classroom_num = classroom_num;
        this.degree_date = degree_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getClassroom_num() {
        return classroom_num;
    }

    public void setClassroom_num(int classroom_num) {
        this.classroom_num = classroom_num;
    }

    public Date getDegree_date() {
        return degree_date;
    }

    public void setDegree_date(Date degree_date) {
        this.degree_date = degree_date;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", classroom_num=" + classroom_num +
                ", degree_date=" + degree_date +
                '}';
    }
}
