package org.example.student_v2.dao;

import org.example.student_v2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByLastName(String lastName);
}
