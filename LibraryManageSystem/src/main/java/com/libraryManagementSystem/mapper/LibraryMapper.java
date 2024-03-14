package com.libraryManagementSystem.mapper;

import com.libraryManagementSystem.entity.Student;
import com.libraryManagementSystem.entity.Book;
import com.libraryManagementSystem.entity.Borrowed;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface LibraryMapper {
    // Student operator
    @Results({
            @Result(id = true, property = "sid", column = "sid"),
            @Result(property = "stu_info", column = "stu_info"),
            @Result(property = "borrowedList", column = "sid", many =
            @Many(select = "getBookBySid")
            )
    })
    @Select("select * from students where sid = #{sid}")
    Student getStudentBySid(int sid);
    @Insert("insert into students(sid, stu_info) values(#{sid}, #{stu_info})")
    int insertStudent(Student student);

    @Results({
            @Result(id = true, column="sid", property="sid"),
            @Result(column="stu_info", property="stu_info"),
            @Result(column="sid", property="borrowedList", many=
                @Many(select="getBookBySid")
            )
    })
    @Select("select * from students")
    List<Student> getAllStudent();

    // Book operator
    @Select("select * from books where bid = #{bid}")
    Student getBookByBid(int bid);
    @Insert("insert into books(bid, book_info) values(#{bid}, #{book_info})")
    int insertBook(Book book);

    @Select("select * from books")
    List<Book> getAllBook();


    // Borrowed operator
    @Select("select * from borrowed where borrowid = #{borrowid}")
    Borrowed getBorrowedByBorrowid(int borrowid);

    @Results({
            @Result(id = true, column="sid", property="sid"),
            @Result(column="stu_info", property="stu_info"),
            @Result(column="sid", property="borrowedList", many=
                @Many(select="getBookBySid")
            )
    })
    @Select("select * from students inner join borrowed on students.sid = borrowed.sid where borrowid = #{borrowid}")
    Student getStudentByBorrowid(int borrowid);

    @Select("select * from books inner join borrowed on books.bid = borrowed.bid where borrowid = #{borrowid}")
    Book getBookByBorrowid(int borrowid);


    @Results({
            @Result(id = true, column="bid", property="bid"),
            @Result(column="book_info", property="book_info"),
    })
    @Select("select * from books inner join borrowed on books.bid = borrowed.bid where sid = #{sid}")
    List<Book> getBookBySid(int sid);

    @Select("select * from borrowed")
    List<Borrowed> getAllBorrowed();

    @Insert("insert into borrowed(sid, bid, borrowid, borrow_info) values(#{sid}, #{bid}, #{borrowid}, #{borrow_info})")
    int insertBorrowed(Borrowed borrowed);

}
