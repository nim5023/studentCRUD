package com.nim5023.SpringDemo.controller;

import com.nim5023.SpringDemo.entity.Student;
import com.nim5023.SpringDemo.exception.StudentNotFoundException;
import com.nim5023.SpringDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = studentService.findAll();
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return student;
    }

    @PostMapping("/students")
    public Student postStudent(@RequestBody Student student) {
        student.setId(0);
        return studentService.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        studentService.delete(studentId);
        return "Successfully deleted student: " + studentId;
    }

}
