package com.library.controller;

import com.library.service.BookService;
import com.library.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BorrowController {

    @Resource
    BookService bookService;

    @Resource
    UserService userService;

    @GetMapping({"/borrow", "/", "index"})
    public String borrow(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("borrowList", bookService.getBorrowList());
        model.addAttribute("bookNumber", bookService.getBookList().size());
        model.addAttribute("studentNumber", userService.getStudentList().size());
        model.addAttribute("borrowNumber", bookService.getBorrowList().size());
        return "index";
    }

    @GetMapping("/add-borrow")
    public String addBorrow(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("bookList", bookService.getBookList());
        model.addAttribute("studentList", userService.getStudentList());
        return "add-borrow";
    }

    @PostMapping("/add-borrow")
    public String addBorrow(@RequestParam("book") int book, @RequestParam("student") int student,
    @RequestParam("borrow_info") String borrow_info) {
        bookService.addBorrow(student, book, borrow_info);
        return "redirect:/borrow";
    }

    @GetMapping("/return-book")
    public String returnBook(@RequestParam("id") int id) {
        bookService.returnBorrow(id);
        return "redirect:/borrow";
    }

}
