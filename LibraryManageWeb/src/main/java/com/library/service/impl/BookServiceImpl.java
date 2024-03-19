package com.library.service.impl;

import com.library.dao.BookMapper;
import com.library.entity.Book;
import com.library.utils.MybatisUtil;
import com.library.entity.Borrow;
import com.library.service.BookService;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class BookServiceImpl implements BookService {
    @Override
    public List<Borrow> getBorrowList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBorrowList();
        }
    }

    @Override
    public void addBorrow(Borrow borrow) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.addBorrow(borrow);
        }
    }

    @Override
    public void returnBook(int borrow_id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.deleteBorrow(borrow_id);
        }
    }

    @Override
    public List<Book> getActiveBookList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getActiveBookList();
        }
    }

    @Override
    public Map<Book, Boolean> getBookList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Set<Book> bookSet = new HashSet<>(this.getActiveBookList());
            Map<Book, Boolean> map = new LinkedHashMap<>();
            bookMapper.getBookList().forEach(book -> map.put(book, bookSet.contains(book)));
            return map;
        }
    }

    @Override
    public void deleteBook(int bid) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.deleteBook(bid);
        }
    }

    @Override
    public void addBook(String book_info) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.addBook(book_info);
        }
    }

    @Override
    public int countBook() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.countBook();
        }
    }

    @Override
    public int countBorrow() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.countBorrow();
        }
    }
}
