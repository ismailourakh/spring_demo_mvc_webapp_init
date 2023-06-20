package com.example.spring_demo_mvc_webapp_init.service;

import com.example.spring_demo_mvc_webapp_init.DTO.StudentDTO;
import com.example.spring_demo_mvc_webapp_init.DTO.TeacherDTO;
import com.example.spring_demo_mvc_webapp_init.model.Student;
import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import com.example.spring_demo_mvc_webapp_init.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.example.spring_demo_mvc_webapp_init.model.Subject;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student updateStudent(Student student) {
        if (student.getId() == null) {
            throw new IllegalArgumentException("Invalid teacher ID");
        }
        return studentRepository.save(student);
    }

    public List<StudentDTO> findAllStudents() { return convertToDTOList(studentRepository.findAll()); }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Subject> getEnrolledSubjectsByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        return student.getSubjects();
    }

    public StudentDTO findStudentById(Long studentId) {
        return convertToDTO(studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID")));
    }
    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());

        return studentDTO;
    }
    private List<StudentDTO> convertToDTOList(List<Student> students) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(convertToDTO(student));
        }
        return studentDTOS;
    }
}
