package org.example.student_v2.service;

import org.example.student_v2.dao.StudentRepository;
import org.example.student_v2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAll(){ return studentRepository.findAll(); }

    public List<Student> findByLastName(String lastName){ return studentRepository.findByLastName(lastName);}

    public Student findById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public void delete(Student student){
        studentRepository.delete(student);
    }


}
