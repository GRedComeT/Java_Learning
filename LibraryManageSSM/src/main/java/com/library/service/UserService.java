package com.library.service;

import com.library.entity.Student;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<Student> getStudentList();
    int getStudentNumber();

    void addStudent(String stu_info);

    void deleteStudent(int id);
}
