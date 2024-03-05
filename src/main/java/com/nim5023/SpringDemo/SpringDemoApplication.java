package com.nim5023.SpringDemo;

import com.nim5023.SpringDemo.dao.StudentDAO;
import com.nim5023.SpringDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return (strs) -> {
//            createStudent(studentDAO);
//            readStudent(studentDAO, 1);
//            readStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO, "tommy");
//            updateStudent(studentDAO);

//            deleteStudent(studentDAO, 1);
//            deleteStudents(studentDAO);

        };
    }

    private void deleteStudents(StudentDAO studentDAO) {
        studentDAO.deleteAll();
    }

    private void deleteStudent(StudentDAO studentDAO, int id) {
        studentDAO.delete(id);

    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = readStudent(studentDAO, 1);
        student.setFirstName("New");
        student.setLastName("Name");
        studentDAO.update(student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO, String lastName) {

        List<Student> studentList = studentDAO.findByLastName(lastName);
        studentList.forEach(System.out::println);
    }

    private void readStudents(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findAll();
        studentList.forEach(System.out::println);
    }

    private Student readStudent(StudentDAO studentDAO, int id) {
        Student student = studentDAO.findById(id);
        System.out.println(student);
        return student;
    }

    private void createStudent(StudentDAO studentDAO) {
        Student student = new Student("Tom", "Tommy", "tom@gmail.com");
        studentDAO.save(student);
    }

}
