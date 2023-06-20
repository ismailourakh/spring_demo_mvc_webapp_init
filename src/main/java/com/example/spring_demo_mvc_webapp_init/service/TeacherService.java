package com.example.spring_demo_mvc_webapp_init.service;

import com.example.spring_demo_mvc_webapp_init.DTO.TeacherDTO;
import com.example.spring_demo_mvc_webapp_init.model.Subject;
import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import com.example.spring_demo_mvc_webapp_init.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        if (teacher.getId() == null) {
            throw new IllegalArgumentException("Invalid teacher ID");
        }

        return teacherRepository.save(teacher);
    }

    public List<Subject> getSubjectsByTeacherId(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        return teacher.getSubjects();
    }

    public List<TeacherDTO> findAllTeachers() {
        return convertToDTOList(teacherRepository.findAll());
    }

    public TeacherDTO findTeacherById(Long teacherId) {
        return convertToDTO(teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID")));
    }

    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    private TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setName(teacher.getName());

        return teacherDTO;
    }

    private List<TeacherDTO> convertToDTOList(List<Teacher> teachers) {
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDTOs.add(convertToDTO(teacher));
        }
        return teacherDTOs;
    }
}


