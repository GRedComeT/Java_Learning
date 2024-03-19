package com.library.dao;

import com.library.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select * from students")
    List<Student> getStudentList();

    @Delete("DELETE FROM students WHERE sid = #{sid}")
    void deleteStudent(int sid);

    @Insert("INSERT INTO students (stu_info) values (#{stu_info})")
    void addStudent(String stu_info);

    @Select("SELECT COUNT(*) FROM students")
    int countStudent();
}
