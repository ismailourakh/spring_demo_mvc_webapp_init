package com.example.spring_demo_mvc_webapp_init.repository;

import com.example.spring_demo_mvc_webapp_init.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
