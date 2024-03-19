package com.library.service;

import com.library.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList();

    void deleteStudent(int sid);

    void addStudent(String stu_info);

    int countStudent();
}
