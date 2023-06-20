package com.example.spring_demo_mvc_webapp_init.service;

import com.example.spring_demo_mvc_webapp_init.model.Subject;
import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import com.example.spring_demo_mvc_webapp_init.repository.SubjectRepository;
import com.example.spring_demo_mvc_webapp_init.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public SubjectService(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void assignTeacherToSubject(Long teacherId, Long subjectId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        subject.setTeacher(teacher);
        subjectRepository.save(subject);
    }
}
