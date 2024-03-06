package com.nim5023.SpringDemo.dao;

import com.nim5023.SpringDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    Student save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student>  findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
