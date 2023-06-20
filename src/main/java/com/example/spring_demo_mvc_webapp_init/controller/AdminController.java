package com.example.spring_demo_mvc_webapp_init.controller;

import com.example.spring_demo_mvc_webapp_init.model.Student;
import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import com.example.spring_demo_mvc_webapp_init.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = adminService.createTeacher(teacher);
        return ResponseEntity.ok(createdTeacher);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = adminService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @PostMapping("/subjects/{subjectId}/students/{studentId}")
    public ResponseEntity<?> addStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
        adminService.addStudentToSubject(studentId, subjectId);
        return ResponseEntity.ok().build();
    }
}