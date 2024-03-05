package com.nim5023.SpringDemo.rest.controller;

import com.nim5023.SpringDemo.dao.StudentDAO;
import com.nim5023.SpringDemo.entity.Student;
import com.nim5023.SpringDemo.rest.exception.StudentErrorResponse;
import com.nim5023.SpringDemo.rest.exception.StudentNotFoundException;
import com.nim5023.SpringDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayDeque;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Value("${config.text}")
    private String output;

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


    @ExceptionHandler
    public ResponseEntity<String> handleException(IllegalArgumentException exception) {

        ResponseEntity<String> rs = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        return rs;
    }


//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
//        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        studentErrorResponse.setMessage(exception.getMessage());
//        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
//    }

}
