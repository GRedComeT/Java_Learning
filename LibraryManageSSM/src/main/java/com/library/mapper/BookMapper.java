package com.library.mapper;


import com.library.entity.Book;
import com.library.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {


    // ------------------- BORROW ---------------------//
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sid", property = "sid"),
            @Result(column = "bid", property = "bid"),
            @Result(column = "borrow_info", property = "borrow_info"),
            @Result(column = "stu_info", property = "stu_info"),
            @Result(column = "book_info", property = "book_info")
    })
    @Select("""
            select * from borrow left join student on borrow.sid = student.id
            left join book on borrow.bid = book.id
            """)
    List<Borrow> getBorrowList();

    @Insert("insert into borrow(sid, bid, borrow_info) values(#{sid}, #{bid}, #{borrow_info})")
    void addBorrow(@Param("sid") int sid, @Param("bid") int bid, @Param("borrow_info") String borrow_info);

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(int id);

    @Select("select COUNT(*) from borrow")
    int getBorrowNumber();

    // --------------------- BOOK ---------------------- //


    @Select("select * from book")
    List<Book> getBookList();

    @Delete("delete from book where id = #{id}")
    void deleteBook(int id);

    @Insert("insert into book(book_info) values(#{book_info})")
    void addBook(@Param("book_info") String book_info);

    @Select("select COUNT(*) from book")
    int getBookNumber();



}
