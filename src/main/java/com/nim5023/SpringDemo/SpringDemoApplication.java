package com.nim5023.SpringDemo;

import com.nim5023.SpringDemo.dao.StudentDAO;
import com.nim5023.SpringDemo.dao.StudentDAOImpl;
import com.nim5023.SpringDemo.entity.Student;
import com.nim5023.SpringDemo.service.StudentService;
import com.nim5023.SpringDemo.service.StudentServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//        return runner -> {
//            StudentService studentService = new StudentServiceImpl(studentDAO);
//            System.out.println("STARTING....");
//            studentService.findAll();
//
//        };
//    }

}
