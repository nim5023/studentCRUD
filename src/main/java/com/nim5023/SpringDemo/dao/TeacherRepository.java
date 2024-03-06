package com.nim5023.SpringDemo.dao;


import com.nim5023.SpringDemo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
