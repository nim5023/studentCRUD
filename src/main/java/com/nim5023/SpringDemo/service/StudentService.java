package com.nim5023.SpringDemo.service;

import com.nim5023.SpringDemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    Student findById(int id);

    List<Student> findAll();

}
