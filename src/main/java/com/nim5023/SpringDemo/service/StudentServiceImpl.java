package com.nim5023.SpringDemo.service;

import com.nim5023.SpringDemo.dao.StudentDAO;
import com.nim5023.SpringDemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO ) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        studentDAO.delete(id);
    }
}
