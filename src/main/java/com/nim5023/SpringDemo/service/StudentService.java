package com.nim5023.SpringDemo.service;

import com.nim5023.SpringDemo.entity.Student;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StudentService {

    Student findById(int id);

    List<Student> findAll();

    @Transactional

    Student save(Student student);

    void delete(int id);

}
