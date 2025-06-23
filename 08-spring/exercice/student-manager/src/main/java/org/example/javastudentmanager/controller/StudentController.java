package org.example.javastudentmanager.controller;

import org.example.javastudentmanager.model.Student;
import org.example.javastudentmanager.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/students")
    public String listPage(Model model){
        String error = null;
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        model.addAttribute("error",error);
        return "students";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(value = "firstName",required = false) String firstName, @RequestParam(value = "lastName",required = false) String lastName, Model model){

        List<Student> studentsSearch;
        String error = "";

        if(firstName != null){
            studentsSearch = studentService.findByFirstName(studentService.findAll(), firstName);
            if(lastName != null){ studentsSearch = studentService.findByLastName(studentsSearch, lastName); }
        } else {
            if(lastName != null){ studentsSearch = studentService.findByLastName(studentService.findAll(), lastName); }
            else {
                error = "Missing parameters for searching";
                studentsSearch = studentService.findAll();
            }
        }

        if (studentsSearch.isEmpty()){
            error = "No students found";
            model.addAttribute("students",studentService.findAll());
            model.addAttribute("error",error);
            return "students";
        } else {
            model.addAttribute("students",studentsSearch);
            model.addAttribute("error",error);
            return "students";
        }
    }

    @GetMapping("/student/{studentId}")
    public String studentPage(@PathVariable UUID studentId, Model model){
        Student student = studentService.findById(studentId);
        model.addAttribute("student",student);
        model.addAttribute("type","edit");
        model.addAttribute("action","/student/edit");
        return "student";
    }

    @GetMapping("/student/register")
    public String registerStudentPage(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("type", "register");
        model.addAttribute("action", "/student/register");
        return "student";
    }

    @PostMapping("/student/register")
    public String registerStudent(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping("/student/edit")
    public String editStudent(@ModelAttribute Student student){
        studentService.update(student);
        return "redirect:/students";
    }

}
