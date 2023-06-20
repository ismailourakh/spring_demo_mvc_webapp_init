package com.example.spring_demo_mvc_webapp_init.controller;

import com.example.spring_demo_mvc_webapp_init.DTO.TeacherDTO;
import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import com.example.spring_demo_mvc_webapp_init.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.spring_demo_mvc_webapp_init.model.Subject;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@CrossOrigin("http://localhost:4200")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacher);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long teacherId, @RequestBody Teacher teacher) {
        teacher.setId(teacherId);
        Teacher updatedTeacher = teacherService.updateTeacher(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @GetMapping("/{teacherId}/subjects")
    public ResponseEntity<List<Subject>> getSubjectsByTeacherId(@PathVariable Long teacherId) {
        List<Subject> subjects = teacherService.getSubjectsByTeacherId(teacherId);
        return ResponseEntity.ok(subjects);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> teachers = teacherService.findAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long teacherId) {
        TeacherDTO teacher = teacherService.findTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.noContent().build();
    }
}


