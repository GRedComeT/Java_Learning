package com.library.mapper;

import com.library.entity.Account;
import com.library.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    Account findUserByUsername(String username);

    @Select("select * from student")
    List<Student> getStudentList();

    @Select("select COUNT(*) from student")
    int getStudentNumber();

    @Insert("insert into student(stu_info) values(#{stu_info})")
    void addStudent(String stu_info);

    @Delete("delete from student where id = #{id}")
    void deleteStudent(int id);
}
