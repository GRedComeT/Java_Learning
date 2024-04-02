package com.library.service.impl;

import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.mapper.BookMapper;
import com.library.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;
    @Override
    public List<Borrow> getBorrowList() {
        return mapper.getBorrowList();
    }

    @Override
    public List<Book> getBookList() {
        return mapper.getBookList();
    }

    @Override
    public int getBookNumber() {
        return mapper.getBookNumber();
    }

    @Override
    public int getBorrowNumber() {
        return mapper.getBorrowNumber();
    }

    @Override
    public void addBorrow(int sid, int bid, String borrow_info) {
        mapper.addBorrow(sid, bid, borrow_info);
    }

    @Override
    public void returnBorrow(int id) {
        mapper.deleteBorrow(id);
    }
}
