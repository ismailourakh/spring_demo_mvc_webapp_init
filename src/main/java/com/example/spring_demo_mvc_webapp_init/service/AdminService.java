package com.example.spring_demo_mvc_webapp_init.service;

import com.example.spring_demo_mvc_webapp_init.model.Student;
import com.example.spring_demo_mvc_webapp_init.model.Subject;
import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import com.example.spring_demo_mvc_webapp_init.repository.AdminRepository;
import com.example.spring_demo_mvc_webapp_init.repository.StudentRepository;
import com.example.spring_demo_mvc_webapp_init.repository.SubjectRepository;
import com.example.spring_demo_mvc_webapp_init.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public AdminService(AdminRepository adminRepository, TeacherRepository teacherRepository,
                        StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.adminRepository = adminRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void addStudentToSubject(Long studentId, Long subjectId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        subject.getStudents().add(student);
        subjectRepository.save(subject);
    }
}

