package com.library.service;

import com.library.entity.Book;
import com.library.entity.Borrow;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Borrow> getBorrowList();

    void addBorrow(Borrow borrow);
    void returnBook(int borrow_id);

    List<Book> getActiveBookList();

    Map<Book, Boolean> getBookList();

    void deleteBook(int bid);

    void addBook(String book_info);

    int countBook();

    int countBorrow();
}
