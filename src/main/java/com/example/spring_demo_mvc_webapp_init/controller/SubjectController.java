package com.example.spring_demo_mvc_webapp_init.controller;

import com.example.spring_demo_mvc_webapp_init.model.Subject;
import com.example.spring_demo_mvc_webapp_init.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.createSubject(subject);
        return ResponseEntity.ok(createdSubject);
    }

    @PostMapping("/{subjectId}/teachers/{teacherId}")
    public ResponseEntity<?> assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
        subjectService.assignTeacherToSubject(teacherId, subjectId);
        return ResponseEntity.ok().build();
    }
}

