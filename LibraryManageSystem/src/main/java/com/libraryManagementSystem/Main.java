package com.libraryManagementSystem;


import com.libraryManagementSystem.entity.Book;
import com.libraryManagementSystem.entity.Borrowed;
import com.libraryManagementSystem.entity.Student;
import com.libraryManagementSystem.util.SqlUtil;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

@Log
public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(Resources.getResourceAsStream("logging.properties"));
            while (true) {
                System.out.println("Typing '1' to insert Student");
                System.out.println("Typing '2' to insert Book");
                System.out.println("Typing '3' to get all students' information");
                System.out.println("Typing '4' to get all books' information");
                System.out.println("Typing '5' to get all borrowed information");
                System.out.println("Typing '6' to create a borrowed record");
                System.out.println("Typing others to exit");
                int choice;
                try {
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            insertStudent(scan);
                            break;
                        case 2:
                            insertBook(scan);
                            break;
                        case 3:
                            getAllStudent();
                            break;
                        case 4:
                            getAllBook();
                            break;
                        case 5:
                            getAllBorrowed();
                            break;
                        case 6:
                            insertBorrowed(scan);
                            break;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    log.info(e.toString());
                    return;
                }

            }
        } catch (IOException e) {
            log.info(e.toString());
        }


    }

    public static void insertStudent(Scanner scan) {
        System.out.println("Input sid:");
        int sid = scan.nextInt();
        scan.nextLine();
        System.out.println("Input stu_info:");
        String stu_info = scan.nextLine();
        Student student = new Student().setSid(sid).setStu_info(stu_info);
        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.insertStudent(student);
            if (i > 0) {
                log.info("Success insert a student: " + student);
            } else {
                log.info("Failed to insert a student: " + student);
            }
        });
    }

    public static void insertBook(Scanner scan) {
        System.out.println("Input bid:");
        int bid = scan.nextInt();
        scan.nextLine();
        System.out.println("Input book_info:");
        String book_info = scan.nextLine();
        Book book = new Book().setBid(bid).setBook_info(book_info);
        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.insertBook(book);
            if (i > 0) {
                log.info("Success insert a student: " + book);
            } else {
                log.info("Failed to insert a student: " + book);
            }
        });
    }

    public static void getAllStudent() {
        SqlUtil.doSqlWork(mapper -> {
            mapper.getAllStudent().forEach(System.out::println);
        });
    }
    public static void getAllBook() {
        SqlUtil.doSqlWork(mapper -> {
            mapper.getAllBook().forEach(System.out::println);
        });
    }

    public static void getAllBorrowed() {
        SqlUtil.doSqlWork(mapper -> {
            mapper.getAllBorrowed().forEach(System.out::println);
        });
    }

    public static void insertBorrowed(Scanner scan) {
        System.out.println("Input sid:");
        int sid = scan.nextInt();
        System.out.println("Input bid:");
        int bid = scan.nextInt();
        System.out.println("Input borrow id:");
        int borrowid = scan.nextInt();
        System.out.println("Input borrow_info:");
        scan.nextLine();
        String borrow_info = scan.nextLine();
        Borrowed borrowed = new Borrowed().setSid(sid).setBid(bid).setBorrowid(borrowid).setBorrow_info(borrow_info);
        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.insertBorrowed(borrowed);
            if (i > 0) {
                log.info("Success insert a borrowed: " + borrowed);
            } else {
                log.info("Failed to insert a borrowed: " + borrowed);
            }
        });
    }
}