package com.libraryManagementSystem;

import com.libraryManagementSystem.entity.Book;
import com.libraryManagementSystem.entity.Student;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.libraryManagementSystem.mapper.LibraryMapper;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.List;

@Log
public class MainTest {


    static private SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    @SneakyThrows
    public static void before() {
        LogManager manager = LogManager.getLogManager();
        manager.readConfiguration(Resources.getResourceAsStream("logging.properties"));

        log.info("Before all tests");
        log.info("Create Mybatis SqlSessionFactory");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        log.info("Finished before all tests");
    }

    @Test
    public void mybatisTest() {
        log.info("Start Mybatis test");
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            LibraryMapper mapper = sqlSession.getMapper(LibraryMapper.class);
            log.info("Get student by sid");
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book().setBid(1).setBook_info("Book1"));
            bookList.add(new Book().setBid(2).setBook_info("Book2"));
            Assertions.assertEquals(new Student().setSid(1).setStu_info("John")
                    .setBorrowedList(bookList), mapper.getStudentBySid(1));

            mapper.getAllStudent().forEach((student) -> log.info(student.toString()));
            Assertions.assertEquals(mapper.getAllStudent().size(), 3);

            mapper.getAllBook().forEach((book) -> log.info(book.toString()));

            Assertions.assertEquals(new Student().setSid(1).setStu_info("John")
                    .setBorrowedList(bookList), mapper.getStudentByBorrowid(1));
        }
    }
}
