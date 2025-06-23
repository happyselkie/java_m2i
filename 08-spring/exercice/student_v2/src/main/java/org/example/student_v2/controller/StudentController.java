package org.example.student_v2.controller;

import org.example.student_v2.entity.Student;
import org.example.student_v2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Page Home
    @GetMapping
    public String home(){
        return "home";
    }

    // Page list des students
    @GetMapping("/students") // http://localhost:8080/students http://localhost:8080/students?search=toto
    public String showStudents(@RequestParam(name = "search",required = false) String search, Model model){
        if(search == null){
            model.addAttribute("students",studentService.findAll());
        }else {
            model.addAttribute("students",studentService.findByLastName(search));
        }
        return "list";
    }

    // Page details
    @GetMapping("/student/{id}")
    public String showStudent(@PathVariable Integer id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }

    // Page formulaire
    @GetMapping("/formulaire")
    public String forlStudent(Model model){
        model.addAttribute("student", new Student());
        return "form";
    }

    // Recuperation des donnees du formulaire
    @PostMapping("/student")
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/students";
    }

}
