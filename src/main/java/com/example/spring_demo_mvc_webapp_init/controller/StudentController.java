package com.example.spring_demo_mvc_webapp_init.controller;

import com.example.spring_demo_mvc_webapp_init.DTO.StudentDTO;
import com.example.spring_demo_mvc_webapp_init.DTO.TeacherDTO;
import com.example.spring_demo_mvc_webapp_init.model.Student;
import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.spring_demo_mvc_webapp_init.model.Subject;
import com.example.spring_demo_mvc_webapp_init.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("http://localhost:4200")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.findAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        student.setId(studentId);
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/{studentId}/subjects")
    public ResponseEntity<List<Subject>> getEnrolledSubjectsByStudentId(@PathVariable Long studentId) {
        List<Subject> subjects = studentService.getEnrolledSubjectsByStudentId(studentId);
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId) {
        StudentDTO student = studentService.findStudentById(studentId);
        return ResponseEntity.ok(student);
    }
}
