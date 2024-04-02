package com.library.service;

import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.entity.Student;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Borrow> getBorrowList();
    Map<Book, Boolean> getBookMap();

    int getBookNumber();
    int getBorrowNumber();

    void addBorrow(int sid, int bid, String borrow_info);

    void returnBorrow(int id);

    void addBook(String book_info);

    void deleteBook(int id);
}
