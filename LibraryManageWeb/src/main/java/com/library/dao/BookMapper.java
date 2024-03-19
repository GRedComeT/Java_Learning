package com.library.dao;

import com.library.entity.Book;
import com.library.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Results({
            @Result(id=true, column="borrowid", property="borrow_id"),
            @Result(column="bid", property="bid"),
            @Result(column="book_info", property="book_info"),
            @Result(column="borrow_info", property="borrow_info"),
            @Result(column="sid", property="sid"),
            @Result(column="stu_info", property="student_info")

    })
    @Select("select * from borrowed inner join students on borrowed.sid = students.sid " +
            "inner join books on borrowed.bid = books.bid")
    List<Borrow> getBorrowList();

    @Delete("delete from borrowed where borrowid = #{borrow_id}")
    void deleteBorrow(int borrow_id);

    @Insert("INSERT INTO borrowed (sid, bid, borrow_info) VALUES (#{sid}, #{bid}, #{borrow_info})")
    void addBorrow(Borrow borrow);

    @Select("select * from books")
    List<Book> getBookList();

    @Select("select * from books where bid not in (select bid from borrowed)")
    List<Book> getActiveBookList();

    @Delete("DELETE FROM books WHERE bid = #{bid}")
    void deleteBook(int bid);

    @Insert("INSERT INTO books (book_info) VALUES (#{book_info})")
    void addBook(String book_info);

    @Select("SELECT COUNT(*) FROM books")
    int countBook();

    @Select("SELECT COUNT(*) FROM borrowed")
    int countBorrow();
}
