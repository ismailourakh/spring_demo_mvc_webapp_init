package com.example.spring_demo_mvc_webapp_init.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "admin")
    private List<Teacher> teachers;

    public Admin(Long id, String name, List<Teacher> teachers, List<Student> students, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.subjects = subjects;
    }

    public Admin() {
    }


    @OneToMany(mappedBy = "admin")
    private List<Student> students;

    @OneToMany(mappedBy = "admin")
    private List<Subject> subjects;
    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}