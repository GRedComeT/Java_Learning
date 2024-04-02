package com.library.service.impl;

import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.mapper.BookMapper;
import com.library.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public List<Borrow> getBorrowList() {
        return mapper.getBorrowList();
    }

    @Override
    public Map<Book, Boolean> getBookMap() {
        Map<Book, Boolean> map = new LinkedHashMap<>();
        List<Book> bookList = mapper.getBookList();
        Set<Integer> borrowList = new HashSet<>();
        mapper.getBorrowList().forEach(borrow -> {
            borrowList.add(borrow.getBid());
        });
        bookList.forEach(book -> {
            map.put(book, borrowList.contains(book.getId()));
        });
        return map;
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

    @Override
    public void addBook(String book_info) {
        mapper.addBook(book_info);
    }

    @Override
    public void deleteBook(int id) {
        mapper.deleteBook(id);
    }
}
