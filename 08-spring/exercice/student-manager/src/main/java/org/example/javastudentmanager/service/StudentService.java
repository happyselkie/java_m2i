package org.example.javastudentmanager.service;

import org.example.javastudentmanager.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService implements ModelService<Student> {
    private final Map<UUID, Student> students;

    public StudentService(){
        students = new HashMap<>();

        Student studentA = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Toto")
                .lastName("Tutu")
                .age(20)
                .email("t.tutu@gmail.com")
                .build();
        Student studentB = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Tata")
                .lastName("Titi")
                .age(19)
                .email("t.titi@gmail.com")
                .build();
        Student studentC = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Rick")
                .lastName("Astley")
                .age(23)
                .email("nevergonnagiveyouup@rickroll.com")
                .build();

        this.students.put(studentA.getId(),studentA);
        this.students.put(studentB.getId(),studentB);
        this.students.put(studentC.getId(),studentC);
    }

    @Override
    public List<Student> findAll() { return this.students.values().stream().toList(); }

    @Override
    public Student findById(UUID id) {return this.students.get(id);}

    @Override
    public Student save(Student student){
        student.setId(UUID.randomUUID());
        students.put(student.getId(),student);
        return student;
    }


    @Override
    public Student update(Student student) {
        for(Map.Entry<UUID, Student> entry : students.entrySet()){
            if(entry.getKey().equals(student.getId())){
                entry.getValue().setFirstName(student.getFirstName());
                entry.getValue().setLastName(student.getLastName());
                entry.getValue().setAge(student.getAge());
                entry.getValue().setEmail(student.getEmail());
            }
        }
        return student;
    }

    @Override
    public boolean delete(Student student) {
        students.remove(student.getId());
        return true;
    }


    public List<Student> findByFirstName(List<Student> studentList, String firstName){
        return studentList.stream().filter(s -> s.getFirstName().contains(firstName)).toList();
    }

    public List<Student> findByLastName(List<Student> studentList, String lastName){
        return studentList.stream().filter(s -> s.getLastName().contains(lastName)).toList();
    }


}
