package com.library.service.impl;

import com.library.dao.StudentMapper;
import com.library.entity.Student;
import com.library.service.StudentService;
import com.library.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudentList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudentList();
        }
    }

    @Override
    public void deleteStudent(int sid) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudent(sid);
        }
    }

    @Override
    public void addStudent(String stu_info) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.addStudent(stu_info);
        }
    }

    @Override
    public int countStudent() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.countStudent();
        }
    }
}
