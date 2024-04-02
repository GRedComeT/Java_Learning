package com.library.service;

import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.entity.Student;

import java.util.List;

public interface BookService {
    List<Borrow> getBorrowList();
    List<Book> getBookList();

    int getBookNumber();
    int getBorrowNumber();

    void addBorrow(int sid, int bid, String borrow_info);

    void returnBorrow(int id);
}
